package com.li.listenter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// 统计网站在线人数监听； 统计session
public class OnlineCountlisterner implements HttpSessionListener {

    // 创建session监听
    // 一旦创建一个session就会出发事件
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext sct = httpSessionEvent.getSession().getServletContext();
        Integer oct = (Integer) sct.getAttribute("OnlineCount");

        if(oct == null)
        {
            oct = new Integer(1);
        }
        else {
            int count = oct.intValue();
            oct = new Integer(count + 1);
        }

        sct.setAttribute("OnlineCount",oct);
    }

    // 销毁session监听
    // 一旦销毁一个session就会出发事件
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext sct = httpSessionEvent.getSession().getServletContext();
        Integer oct = (Integer) sct.getAttribute("OnlineCount");

        if(oct == null)
        {
            oct = new Integer(0);
        }
        else {
            int count = oct.intValue();
            oct = new Integer(count - 1);
        }

        sct.setAttribute("OnlineCount",oct);
    }

    /*
        session 销毁：
        1.手动销毁 getSession().invalidate()
        2.自动销毁
    * */
}
