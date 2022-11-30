package IO.NIO.SimpleChat;

import IO.NIO.SimpleChat.Net.Message;
import IO.NIO.SimpleChat.Net.MessageType;

import java.io.*;

public class MainTestSer {

    public static void main(String[] args) {
        Message message = new Message(MessageType.SIGNIN.getTitle(), "19");
        byte[] byteArr = serialization(message);

        byte[] b2 = new byte[256];
        System.arraycopy(byteArr,0,b2,0, byteArr.length);
        Message message1 = deserialized(b2);

        System.out.println(" messsage1 = " + message1.getMsg());


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
