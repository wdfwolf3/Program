package program.javaTest.threadtest;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StopOutBlockThread extends Thread {
    public static final int BUFFER_SIZE = 512;
    Socket socket;
    InputStream is;

    public StopOutBlockThread(Socket socket) {
        this.socket = socket;
        try {
            is = this.socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void interrupt() {
        try {
            System.out.println("interrupt");
            socket.close();
        } catch (IOException e) {
        } finally {
            super.interrupt();
        }
        super.interrupt();
    }

    @Override
    public void run() {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            while (true) {
                int count = is.read(buf);
                if (count < 0)
                    break;
                else if (count > 0) {

                }
            }
        } catch (IOException e) {
            System.out.println("entry catch block!");
        }
        System.out.println("thread stop!");
    }

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            Socket socket = new Socket("localhost", 8080);
            server.accept();
            StopOutBlockThread thread = new StopOutBlockThread(socket);
            thread.start();
            System.out.println("thread starting...");
            thread.interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}