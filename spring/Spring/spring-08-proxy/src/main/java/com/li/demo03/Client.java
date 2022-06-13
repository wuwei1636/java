package com.li.demo03;

public class Client {
    public static void main(String[] args) {

        //真实角色
        Host host = new Host();

        // 代理角色,现在没有
        ProxyInvacation proxy = new ProxyInvacation();

        //通过调用程序处理角色，来处理我们要用的接口对象
        proxy.setRent(host);

        Rent proxy1 = (Rent) proxy.getProxy();

        proxy1.rent();

    }
}
