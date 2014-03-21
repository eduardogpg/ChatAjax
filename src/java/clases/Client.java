package clases;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author skalero01
 */
public class Client {
    private Socket sk;
    private DataOutputStream dos;
    private DataInputStream dis;
    static String message;
    String outPutC ="";
    int id;
    String name;
    boolean ingresoDatos;
    
    // Lista de usuarios
    public static ArrayList userList = new ArrayList();
    public static ArrayList userNames = new ArrayList();
    public static ArrayList expirado = new ArrayList();
    int SEC = 0;
    Calendar a = Calendar.getInstance();
    
    // Chats
    public static ArrayList chatList = new ArrayList();
    public static ArrayList chatsUser = new ArrayList();
    public static ArrayList chatsStatus = new ArrayList();
    
    public Client() throws IOException {
        ingresoDatos = false;
    }
     private void revConectados(){
        for(int i = 0; i < expirado.size(); i++){
            int tiempoFuera = SEC - (int)expirado.get(i);
            if(tiempoFuera > 5){
                this.removeUserExpirado(i);
            }
        }
    }
    public void removeUserExpirado(int userExp) {
        userList.set(userExp, null);
        userNames.set(userExp, null);
    }
    public int getNewID(String nombre) {
        userList.add(userList.size(), 0);
        userNames.add(userNames.size(), nombre);
        int sec = a.get(Calendar.SECOND);
        this.SEC = sec;
        expirado.add(expirado.size(), sec);
        return userList.size()-1;
        
    }
    public void setID(int ID) {
        this.id = ID;
        int sec = a.get(Calendar.SECOND);
        this.SEC = sec;
        expirado.set(id, sec);
        revConectados();
    }
    public void removeUser() {
        userList.set(id, null);
        userNames.set(id, null);
    }
    // Usuarios conectados en general
    public String usuariosConectados() {
        String salidaf = "";
        int cont = 0;
        for (int i=0; i<userNames.size(); i++) {
            if(userNames.get(i)!=null) {
                if (cont==0) {
                    salidaf = salidaf+"-1l!l";
                    cont++;
                }
                salidaf = salidaf + "<li id='u"+i+"'>"+userNames.get(i)+"</li>";
            }
        }
        return salidaf;
    }
    // Usuarios conectados en Room
    public String usuariosConectados(String rooms) {
        String[] room = rooms.split(",");
        String salidaf = "";
        for (int y=0; y<room.length; y++) {
            if (Integer.parseInt(room[y])>=0 && chatList.get(Integer.parseInt(room[y]))!=null) {
                salidaf = salidaf + "l!l"+room[y] +"l!l";
                int idCreador = (int)chatList.get(Integer.parseInt(room[y]));
                salidaf = salidaf + "<li id='u"+idCreador+"'>"+userNames.get(idCreador)+"</li>";
                String[] IdUsuarios = (String[]) chatsUser.get(Integer.parseInt(room[y]));
                for (int e=0; e<IdUsuarios.length; e++) {
                    int i= Integer.parseInt(IdUsuarios[e]);
                    salidaf = salidaf + "<li id='u"+i+"'>"+userNames.get(i)+"</li>";
                }
            }
        }
        
        return salidaf;        
    }
    // Enviar en general
    public void Enviar(String texto) throws IOException {
        String[] textoDiv = texto.split("l!l"); // Pos 0 == id Room, Pos 1 == Mensaje
        sk = new Socket("127.0.0.1", 10578);
        dos = new DataOutputStream(sk.getOutputStream());
        dis = new DataInputStream(sk.getInputStream());
        message = textoDiv[0]+"l!l<span>"+userNames.get(id)+":</span>"+textoDiv[1];
        ingresoDatos = true;
        dos.writeUTF(texto);
        for (int i=0; i<userList.size(); i++) {
            userList.set(i, 0);
        }
        this.Desconectar();
    }
    public String Recibir() {
        outPutC = "";
        if(id<userList.size()) {
            if(Integer.parseInt(userList.get(id).toString())==0 && message!=null) {
                outPutC = message;
                userList.set(id, 1);
            }
        }
        return outPutC;
    }
    public void Desconectar() throws IOException {
        dis.close();
        dos.close();
        sk.close();
    }
    public int crearChat(String IDsArray) {
        // CrearID Chat
        int IDChat = chatList.size();
        chatList.add(IDChat, id);

        String[] IDUsuarios = IDsArray.split(",");
        chatsUser.add(IDChat, IDUsuarios);
        int[] status = new int[IDUsuarios.length];
        for (int i=0; i<IDUsuarios.length; i++) {
            status[i] = 0;
        }
        chatsStatus.add(IDChat, status);
        return IDChat;
    }
    public String revNuevoChat() {
        String sal = "";
        for (int i=0; i<chatsUser.size(); i++) {
            if (chatsUser.get(i)!=null && chatList.get(i)!=null) {
                String[] IDs = (String[]) chatsUser.get(i);
                int[] stat = (int[]) chatsStatus.get(i);
                for (int e=0; e<IDs.length; e++) {
                    if(Integer.parseInt(IDs[e])==id && stat[e]==0) {
                        sal = sal+i;
                        stat[e] = 1;
                    }
                }
                chatsStatus.set(i, stat);
            }
        }
        return sal;
    }
    public void eliminarChat(int idi) {
        int idOrganizador = (int)chatList.get(idi);
        if(idOrganizador==this.id){
            chatList.set(idi, null);
            int[] stat = (int[]) chatsStatus.get(idi);
            for (int e=0; e<stat.length; e++) {
                stat[e] = 0;
            }
            chatsStatus.set(idi, stat);
        }
    }
    
    public String revEliminadoChat(String idChats) {
        String sal = "";
        if(idChats.length()>1) { // Se mandó arreglo
            String[] IDsChats = idChats.split(",");
            if(IDsChats.length>0) { // Hay más de un chat en el arreglo
                for (int i=0; i<IDsChats.length; i++) {
                    if (Integer.parseInt(IDsChats[i])>=0 && chatList.get(Integer.parseInt(IDsChats[i]))==null) {
                        sal = sal+Integer.parseInt(IDsChats[i]);
                        String[] IDs = (String[]) chatsUser.get(Integer.parseInt(IDsChats[i]));
                        int[] stat = (int[]) chatsStatus.get(Integer.parseInt(IDsChats[i]));
                        for (int e=0; e<IDs.length; e++) {
                            if(Integer.parseInt(IDs[e])==id && stat[e]==0) {
                                stat[e] = 1;
                            }
                        }
                        chatsStatus.set(Integer.parseInt(IDsChats[i]), stat);
                    }
                }
            }
        }
        
        return sal;
    }
    
    public void CleanClass() {
        message = null;
        userList.clear();
        userNames.clear();
        chatList.clear();
        chatsUser.clear();
        chatsStatus.clear();
         expirado.clear();
        
    }
}
