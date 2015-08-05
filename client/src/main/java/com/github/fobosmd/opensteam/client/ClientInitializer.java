package com.github.fobosmd.opensteam.client;

import com.github.fobosmd.opensteam.common.entity.ItemEntity;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * Created by Kirill Listopad on 10/25/14.
 */
public class ClientInitializer extends ChannelInitializer<SocketChannel> {

    private final ClientHandler handler;

    public ClientInitializer(ClientHandler handler){
        this.handler = handler;
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new ObjectEncoder());
        pipeline.addLast(new ObjectDecoder(ClassResolvers.weakCachingConcurrentResolver(ItemEntity.class.getClassLoader())));
        pipeline.addLast(handler);
    }
}
