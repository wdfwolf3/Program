package program.javaTest.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class IOClientThread implements Runnable {
    private InputStream inputStream;

    public IOClientThread(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("10.15.34.163", 8090);
            OutputStream outputStream = socket.getOutputStream();
            Thread thread = new Thread(new IOClientThread(socket.getInputStream()));
            thread.start();
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String s = scanner.next();
                outputStream.write(s.getBytes());
                outputStream.flush();
                if ("exit".equals(s)) {
                    thread.join();
                    break;
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        int i = 0;
        byte[] bytes = new byte[1024];
        try {
            while ((i = inputStream.read(bytes)) != -1) {
                String s = new String(bytes, 0, 4);
                if ("exit".equals(s)) {
                    break;
                }
                System.out.println(new String(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
