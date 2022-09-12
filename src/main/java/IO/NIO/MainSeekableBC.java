package IO.NIO;

import Chat.SimpleChat.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;

public class MainSeekableBC {


    public static void main(String[] args) throws IOException {
        int nBytes;
        Path path1 = Paths.get("src/main/java/IO/NIO/temp1.txt");
        Path path2 = Paths.get("src/main/java/IO/NIO/temp2.txt");

        ByteBuffer buffer = ByteBuffer.allocate(128);

        long t1 = System.currentTimeMillis();
        try(SeekableByteChannel fChan1 = Files.newByteChannel(path1, StandardOpenOption.READ, StandardOpenOption.WRITE);
            SeekableByteChannel fChan2 = Files.newByteChannel(path2, StandardOpenOption.READ, StandardOpenOption.WRITE)){

            //записали в буфер
            while ((nBytes = fChan1.read(buffer)) != -1){

                //перевели указатель буфера на начало, для чтения записанных данных
/*                buffer.flip();

                for (int i = 0; i < nBytes; i++) {
                    System.out.println((char)buffer.get());
                }*/

                //перевели указатель буфера на начало, для чтения записанных данных
                buffer.flip();

                //записали данные с буфера в другой файл
                fChan2.write(buffer);

                //перевели указатель буфера на начало, для чтения записанных данных
                buffer.flip();
            }

        }
        System.out.println(System.currentTimeMillis()-t1);

    }


}
