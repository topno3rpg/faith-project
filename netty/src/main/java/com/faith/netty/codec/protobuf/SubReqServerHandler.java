package com.faith.netty.codec.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by yunyun on 2017/8/28.
 */
public class SubReqServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubReqProto.SubReq req = (SubReqProto.SubReq) msg;
        if ("yunyun".equalsIgnoreCase(req.getUserName())) {
            System.out.println("Server accept req : " + req.toString());
            ctx.writeAndFlush(resp(req.getSubReqId()));
        }
    }

    private SubResProto.SubReq resp(int subReqId) {
        SubResProto.SubReq.Builder builder = SubResProto.SubReq.newBuilder();
        builder.setSubReqId(subReqId);
        builder.setRespCode(0);
        builder.setDesc("netty book order succeed, 3 days later, sent to the designated address");
        return builder.build();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
