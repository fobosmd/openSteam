package fobos.opensteam.client;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import fobos.opensteam.common.RequestType;
import fobos.opensteam.common.entity.ItemEntity;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.List;

/**
 * Created by Kirill Listopad on 10/25/14.
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    private RequestType request;
    private Object response;

    public RequestType getRequest() {
        return request;
    }

    public void setRequest(RequestType request) {
        this.request = request;
    }

    public Object getResponse() {
        return response;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(request);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        Preconditions.checkState(msg instanceof List);
        response = msg;
        ctx.disconnect();
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
