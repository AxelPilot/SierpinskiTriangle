package com.axelsmidt.sierpinski;

import javax.swing.JFrame;

public class SierpinskiTest {
    public static void main(String[] args) {
        JFrame app = new JFrame();

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(1200, 1000);
        app.setVisible(true);
        DrawSierpinski panel = new DrawSierpinski();
        app.add(panel);
    }
}
