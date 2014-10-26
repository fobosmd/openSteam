package fobos.opensteam.common.io;

import fobos.opensteam.common.RequestType;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by md on 10/25/14.
 */
public class RequestDecoder extends ByteToMessageDecoder {

    private static final int REQUEST_TYPE_LENGTH = 4;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {

        if (in.readableBytes() < REQUEST_TYPE_LENGTH) {
            return;
        }
        in.markReaderIndex();

        int i = in.readInt();
        RequestType requestType = RequestType.valueOf(i);
        out.add(requestType);
    }
}
