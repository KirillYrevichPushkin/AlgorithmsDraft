package IO.NIO.SimpleChat.Server;

import IO.NIO.SimpleChat.Net.Message;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class MainServer {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8189));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer buffer = ByteBuffer.allocate(256);

        while (true){
            selector.select();
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> iter = selectionKeySet.iterator();
            while (iter.hasNext()){

                SelectionKey key = iter.next();

                if(key.isAcceptable()){
                    register(selector, serverSocketChannel);
                }
                if(key.isReadable()){
                    readMsg(buffer, key);
                }
                iter.remove();
            }

        }
    }


    private static void register(Selector selector, ServerSocketChannel serverSocket) throws IOException {
        SocketChannel sChannel = serverSocket.accept();
        sChannel.configureBlocking(false);
        sChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE); // "|" определяет поведение для более чем одного события
        //  sChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("Client connect");
        System.out.println("Remote address" + sChannel.getRemoteAddress().toString());
    }

    private static void readMsg(ByteBuffer buffer, SelectionKey key) throws IOException {
        SocketChannel sChannel = (SocketChannel) key.channel();
        byte [] byteArr = new byte[1024];
        buffer.clear();
        int count;
        int start = 0;


        count = sChannel.read(buffer);
        buffer.flip();
        byteArr = buffer.array();

    //    byteArr = buffer.array();
        System.out.println();
        for (int i = 0; i < byteArr.length; i++) {
            System.out.print(byteArr[i]);
        }
        System.out.println();
 //       buffer.flip();

 //       while ((count = sChannel.read(buffer))!=-1){
      //      byteArr = Arrays.copyOfRange(byteArr, 0, count-1);
 //       byteArr = Arrays.copyOfRange(buffer.array(), 0, buffer.array().length-1);
  //          start += count-1;
 //       }
        byteArr = Arrays.copyOf(buffer.array(),count);
        System.out.println("count = " + count);
  //      System.out.println("byteArr.lenght = " + byteArr.length);

        Message message = deserialized(buffer.array());
        System.out.println("Message = " + message.getMsg());
        buffer.flip();
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
