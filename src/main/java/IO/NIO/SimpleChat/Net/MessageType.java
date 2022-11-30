package IO.NIO.SimpleChat.Net;

import java.io.Serializable;

public enum MessageType implements Serializable {
    DELIMITER("±"),
    LOGIN("login"),
    PASSWORD("password"),
    SENDALL("sendAll"),
    SENDTO("sendTo"),
    SIGNIN("signIn"),
    SIGNOUT("signOut"),
    REGISTER("register"),
    CLIENTLIST("clientList"),
    EXIT("exit");

    private String title;

    MessageType(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

}
