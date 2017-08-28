package com.faith.netty.codec.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunyun on 2017/8/28.
 */
public class SubReqClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for (int i = 0; i < 10; i++) {
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private SubReqProto.SubReq subReq(int i) {
        SubReqProto.SubReq.Builder builder = SubReqProto.SubReq.newBuilder();
        builder.setSubReqId(i);
        builder.setUserName("yunyun");
        builder.setProductName("netty for protobuf");
        List<String> address = new ArrayList<String>();
        address.add("nanjing");
        address.add("zhejiang");
        builder.addAllAddress(address);
        return builder.build();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("receive server response : " + msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
