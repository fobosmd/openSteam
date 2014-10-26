package fobos.opensteam.common.io;

import fobos.opensteam.common.RequestType;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by md on 10/25/14.
 */
public class RequestEncoder extends MessageToByteEncoder<RequestType> {

    @Override
    protected void encode(ChannelHandlerContext ctx, RequestType msg, ByteBuf out) throws Exception {
        out.writeInt(msg.getIndex());
    }
}
