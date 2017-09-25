package com.frame.charRoom;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {
    private static int PORT = 8090;

    public static void main(String[] args) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        EventLoopGroup acceptor = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        //设置循环线程组，前者用于处理客户端连接事件，后者用于处理网络IO
        bootstrap.group(acceptor, worker);
        //用于构造socketchannel工厂
        bootstrap.channel(NioServerSocketChannel.class);
        //为处理accept客户端的channel中的pipeline添加自定义处理函数
        bootstrap.childHandler(new ServerIniterHandler());
        try {
            //绑定端口（实际上是创建serversocketchannel，并注册到eventloop上），同步等待完成，返回相应channel
            Channel channel = bootstrap.bind(PORT).sync().channel();
            System.out.println("server starts running in port:" + PORT);
            channel.closeFuture().sync();//在这里阻塞，等待关闭
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //优雅退出
            acceptor.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
