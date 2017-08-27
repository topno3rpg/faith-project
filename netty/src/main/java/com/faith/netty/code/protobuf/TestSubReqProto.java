package com.faith.netty.code.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.ArrayList;
import java.util.List;

public class TestSubReqProto {

    private static byte[] encode(SubReqProto.SubReq req) {
        return req.toByteArray();
    }

    private static SubReqProto.SubReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubReqProto.SubReq.parseFrom(body);
    }

    private static SubReqProto.SubReq createSubReq() {
        SubReqProto.SubReq.Builder builder = SubReqProto.SubReq.newBuilder();
        builder.setSubReqId(1);
        builder.setUserName("yunyun");
        builder.setProductName("netty book");
        List<String> list = new ArrayList<String>();
        list.add("nan jing");
        list.add("zhe jiang");
        builder.addAllAddress(list);
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubReqProto.SubReq req = createSubReq();
        System.out.println("before encode: \n" + req.toString());
        SubReqProto.SubReq req2 = decode(encode(req));
        System.out.println("after encode: \n" + req2.toString());
        System.out.println("assert equal: \n" + req.equals(req2));
    }

}
