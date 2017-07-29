package program.javaTest.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8090);
            byte[] bytes = new byte[1024];
//            while (true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                int i = 0;
                while ((i = inputStream.read(bytes)) != -1){
                    System.out.println(new String(bytes));
                }
//            }
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
