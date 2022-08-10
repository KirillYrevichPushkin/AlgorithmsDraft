package Chat.SimpleChat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket;
        BufferedReader bufferedReader = null;
        DataOutputStream bufferedWriter;
        Scanner scanner = new Scanner(System.in);

        try {
            socket = new Socket("localhost", 8180);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new DataOutputStream(socket.getOutputStream());

            while (true){
                String msg = scanner.nextLine();
                if(msg.equals("exit")){
                    bufferedWriter.writeUTF(msg);
                    bufferedWriter.flush();
                    break;
                }else {
                    bufferedWriter.writeUTF(msg);
                    bufferedWriter.flush();
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
