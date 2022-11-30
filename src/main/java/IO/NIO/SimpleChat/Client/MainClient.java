package IO.NIO.SimpleChat.Client;

import IO.NIO.SimpleChat.Net.Message;
import IO.NIO.SimpleChat.Net.MessageType;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel;
        ByteBuffer buffer;

        socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 8189));
        buffer = ByteBuffer.allocate(256);


        Scanner scanner = new Scanner(System.in);
        String msg;

        while (true){
            if((msg = scanner.nextLine()).equals("exit")){
                return;
            }else {
                writeMsg(msg,socketChannel,buffer);
            }

        }
    }

    private static void writeMsg(String msg, SocketChannel socketChannel, ByteBuffer buffer) throws IOException {
        Message message = new Message(MessageType.SENDALL.getTitle(), msg);
        byte [] byteArr = new byte[1024];
        byte [] arrObject = serialization(message);
        byte [] ba = null;
        System.out.println("arrO = " + arrObject.toString());
        System.out.println("arrO.lenght = " + arrObject.length);
        if(arrObject.length <= buffer.limit()){
            System.out.println("if1");
            buffer.clear();
            buffer.put(arrObject);
            buffer.flip();
         //   ba = buffer.array();

            socketChannel.write(buffer);
            ba = buffer.array();
            buffer.clear();
            System.out.println("if1.1");
        }else {
            int index = 0;
            buffer.clear();

            while (index <= arrObject.length-1) {

                buffer.put(arrObject, index, buffer.array().length - 1);
                buffer.flip();

                socketChannel.write(buffer);

                index += buffer.array().length;
                if(index > arrObject.length-1){
                    index = arrObject.length-1;
                }
                buffer.clear();
            }
        }
        System.out.println();
        for (int i = 0; i < arrObject.length; i++) {
            System.out.print(arrObject[i]);
        }

        System.out.println();
        for (int i = 0; i < ba.length; i++) {
            System.out.print(ba[i]);
        }


    }

    private static byte [] serialization (Message m){
        byte [] byteArr = null;
        try(ByteArrayOutputStream bao = new ByteArrayOutputStream()){
            try(ObjectOutputStream oos = new ObjectOutputStream(bao)) {
                oos.writeObject(m);
                byteArr = bao.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArr;
    }


    private static Message deserialized(byte [] byteBuf){
        Message m = null;
        try(ByteArrayInputStream bai = new ByteArrayInputStream(byteBuf)){
            try(ObjectInputStream ois = new ObjectInputStream(bai)) {
                m = (Message) ois.readObject();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return m;
    }

}
