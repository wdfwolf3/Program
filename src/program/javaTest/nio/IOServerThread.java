package program.javaTest.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class IOServerThread implements Runnable {
    private OutputStream outputStream;

    public IOServerThread(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8090);
            byte[] bytes = new byte[1024];
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            int i = 0;
            Thread thread = new Thread(new IOServerThread(socket.getOutputStream()));
            thread.start();
            while ((i = inputStream.read(bytes)) != -1) {
                String s = new String(bytes, 0, 4);
                if ("exit".equals(s)) {
                    out.write(s.getBytes());
                    out.flush();
                    TimeUnit.SECONDS.sleep(5);
                    break;
                }
                System.out.println(new String(bytes));
            }
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            try {
                outputStream.write(s.getBytes());
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
