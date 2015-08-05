package fobos.opensteam.server;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import fobos.opensteam.common.RequestType;
import fobos.opensteam.common.entity.ItemEntity;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by Kirill Listopad on 10/25/14.
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        Preconditions.checkState(msg instanceof RequestType);

        RequestType rt = (RequestType)msg;

        System.out.println(String.format("Server gets RequestType: %s", rt));
        System.out.flush();

        Object res;
        if (rt == RequestType.ITEMS){
            res = Lists.newArrayList(new ItemEntity(1L, "DIAMOND", 13));
        } else {
            throw new IllegalStateException(String.format("RequestType %s is not supported", rt));
        }

        ctx.write(res);
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
