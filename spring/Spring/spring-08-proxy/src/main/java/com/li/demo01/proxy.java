package com.li.demo01;

public class proxy implements Rent{
    private Host host;

    public proxy() {
    }

    public proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
        hetong();
        fare();
    }

    //看房
    public void seeHouse(){
        System.out.println("中介看房");
    }

    // 签合同
    public void hetong(){
        System.out.println("签合同");
    }
    // 收中介费
    public void fare(){
        System.out.println("收中介费");
    }
}
