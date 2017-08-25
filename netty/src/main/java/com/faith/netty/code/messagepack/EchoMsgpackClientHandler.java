package com.faith.netty.code.messagepack;

import com.faith.netty.code.jdk.UserInfo;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by yunyun on 2017/8/25.
 */
public class EchoMsgpackClientHandler extends ChannelInboundHandlerAdapter {

    public EchoMsgpackClientHandler()

    {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for (int i = 0; i < 1000; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName("name_"+i);
            userInfo.setUserId(i);
            ctx.write(userInfo);
        }
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("client receive the msgpack : [" + msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
