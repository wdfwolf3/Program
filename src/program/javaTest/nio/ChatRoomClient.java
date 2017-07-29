package program.javaTest.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;


public class ChatRoomClient {

    private Selector selector = null;
    private static final int port = 9999;
    private Charset charset = Charset.forName("UTF-8");
    private SocketChannel sc = null;
    private String name = "";
    private static String USER_EXIST = "system message: user exist, please change a name";
    private static String USER_CONTENT_SPILIT = "#@#";

    public void init() throws IOException {
        selector = Selector.open();
        //连接远程主机的IP和端口
        sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", port));
        sc.configureBlocking(false);
        sc.register(selector, SelectionKey.OP_READ);
        //开辟一个新线程来读取从服务器端的数据
        Thread thread = new Thread(new ClientThread());
        thread.start();
        //在主线程中从键盘读取数据输入到服务器端
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if ("".equals(line)) {
                System.out.println("不允许发空消息！");
                continue;
            } else if ("quit".equals(line))
                break;
            if ("".equals(name)) {
                name = line;
                line = name + USER_CONTENT_SPILIT;
            } else {
                line = name + USER_CONTENT_SPILIT + line;
            }
            sc.write(charset.encode(line));//sc既能写也能读，这边是写
        }
    }

    private class ClientThread implements Runnable {
        public void run() {
            while (true) {
                ByteBuffer buff = ByteBuffer.allocate(1024);
                String content = "";
                try {
                    while (sc.read(buff) > 0) {
                        buff.flip();
                        content += charset.decode(buff);
//                    buff.clear();
                        //若系统发送通知名字已经存在，则需要换个昵称
                    }
                } catch (IOException e) {
                    System.out.println("server close!");
                    return;
                }
                if (USER_EXIST.equals(content))
                    name = "";
                if (!"".equals(content))
                    System.out.println(content);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new ChatRoomClient().init();
    }
}
