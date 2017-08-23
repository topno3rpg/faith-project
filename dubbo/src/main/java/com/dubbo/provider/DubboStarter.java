package com.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class DubboStarter {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-demo-provider.xml"});
        context.start();

        System.in.read(); // 按任意键退出
    }
}