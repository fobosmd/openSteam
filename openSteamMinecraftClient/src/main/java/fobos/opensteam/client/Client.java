package fobos.opensteam.client;

import com.google.common.collect.Iterables;
import fobos.opensteam.common.RequestType;
import fobos.opensteam.common.entity.ItemEntity;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * Created by md on 10/25/14.
 */
public class Client {
    private final InetSocketAddress socket = new InetSocketAddress("localhost", 8322);
    private final Bootstrap b;
    private final ClientHandler handler = new ClientHandler();

    public Client() {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ClientInitializer(handler));
        this.b = b;
    }

    public List<ItemEntity> getItems() {
        handler.setRequest(RequestType.ITEMS);
        try {
            b.connect(socket).sync().channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new IllegalStateException("Cannot connect and handle request", e);
        }
        List<ItemEntity> res = (List)handler.getResponse();
        return res;
    }

    public static void main(String[] args) throws Exception {
        Client c = new Client();
        List list = c.getItems();
        System.out.println(String.format("Items %s", Iterables.toString(list)));
        System.out.flush();
    }
}
