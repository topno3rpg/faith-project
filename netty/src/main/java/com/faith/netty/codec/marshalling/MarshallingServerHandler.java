package com.faith.netty.codec.marshalling;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by yunyun on 2017/8/28.
 */
public class MarshallingServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Req req = (Req) msg;
        if ("yunyun".equalsIgnoreCase(req.getUserName())) {
            System.out.println("Server accept req : " + req.toString());
            ctx.writeAndFlush(resp(req.getId()));
        }
    }

    private Resp resp(int id) {
        Resp resp = new Resp();
        resp.setCode(0);
        resp.setMsg(id + " netty book order succeed, 3 days later, sent to the designated address");
        return resp;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
