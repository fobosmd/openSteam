package fobos.opensteam.client;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import fobos.opensteam.common.RequestType;
import fobos.opensteam.common.entity.Item;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by md on 10/25/14.
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(RequestType.ITEMS);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        Preconditions.checkState(msg instanceof List);
        List<Item> items = (List)msg;

        System.out.printf("Client gets Items: %s", Iterables.toString(items));

//        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
