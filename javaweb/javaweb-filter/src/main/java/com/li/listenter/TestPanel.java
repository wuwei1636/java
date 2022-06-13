package com.li.listenter;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame("中秋节快乐"); // 新建一个标题
        Panel panel = new Panel(null); // 面板
        frame.setLayout(null); // 设置窗体的布局
        frame.setBounds(300,300,300,300);

        frame.setBackground(new Color(0,0,255)); // 设置背景颜色

        panel.setBounds(50,50,200,200);
        panel.setBackground(new Color(0,255,255)); // 设置背景颜色

        frame.add(panel);

        frame.setVisible(true);
        // 监听关闭事件
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("打开");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }
}
