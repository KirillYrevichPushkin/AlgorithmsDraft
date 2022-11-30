package IO.NIO.SimpleChat.Net;

import java.io.Serializable;

public class Message implements Serializable {

//    private final String delimiter = "±";
    private String msgType;
    private String msg;
    private String [] clients;

    public Message(String msgType, String msg) {
        this.msgType = msgType;
        this.msg = msg;
    }

    public Message(String msgType, String msg, String[] clients) {
        this.msgType = msgType;
        this.msg = msg;
        this.clients = clients;
    }

//    public String getDelimiter() {
//        return delimiter;
//    }

    public String[] getClients() {
        return clients;
    }

    public String getMsgType() {
        return msgType;
    }

    public String getMsg() {
        return msg;
    }
}
