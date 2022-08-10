package Chat.SimpleChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        DataInputStream bufferedReader = null;
        DataOutputStream bufferedWriter;

        try {
            serverSocket = new ServerSocket(8180);
            System.out.println("server start");
            socket = serverSocket.accept();
            bufferedReader = new DataInputStream((socket.getInputStream()));
          //  bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("client connect");
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true){
            String msg = bufferedReader.readUTF();
            if(msg.equals("exit")){
                break;
            }else {
                System.out.println("msg = " + msg);
            }


        }

    }


}
