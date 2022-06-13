package com.li.demo01;

public class Client {
    public static void main(String[] args) {
        // 房东要租房子
        Host host = new Host();
        // 中介帮房东租房子 ，还有附属操作
        proxy proxy = new proxy(host);

        proxy.rent();
    }
}
