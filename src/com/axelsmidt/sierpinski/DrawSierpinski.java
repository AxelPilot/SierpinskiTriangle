package com.axelsmidt.sierpinski;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class DrawSierpinski extends JPanel implements ActionListener {
    Timer timer = new Timer(0, this);
    SecureRandom random = new SecureRandom();
    int[][] corners = new int[3][2]; // Triangle corner coordinates.
    int[] coordinate = new int[2]; // Point coordinates.

    public DrawSierpinski() {
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        coordinate[0] = random.nextInt(getWidth() - 20) + 10;
        coordinate[1] = random.nextInt(getHeight() - 20) + 10;

        // Triangle corner coordinates.
        // Top corner.
        corners[0][0] = getWidth() / 2;
        corners[0][1] = 10;

        // Bottom right corner.
        corners[1][0] = getWidth() - 10;
        corners[1][1] = getHeight() - 10;

        // Bottom left corner.
        corners[2][0] = 10;
        corners[2][1] = getHeight() - 10;

//        g.setColor(Color.WHITE);

        for (int i = 0; i < 100000; i++) {
            int corner = random.nextInt(3);
            if (coordinate[0] < corners[corner][0]) {
                coordinate[0] = Math.round(Float.valueOf(corners[corner][0] - coordinate[0]) / 2) + coordinate[0];
            } else {
                coordinate[0] = Math.round(Float.valueOf(coordinate[0] - corners[corner][0]) / 2) + corners[corner][0];
            }

            if (coordinate[1] < corners[corner][1]) {
                coordinate[1] = Math.round(Float.valueOf(corners[corner][1] - coordinate[1]) / 2) + coordinate[1];
            } else {
                coordinate[1] = Math.round(Float.valueOf(coordinate[1] - corners[corner][1]) / 2) + corners[corner][1];
            }

            if ((i % 10) == 0) {
                g.setColor(new Color(28 + random.nextInt(200), 28 + random.nextInt(200), 28 + random.nextInt(200)));
            }

            g.drawLine(coordinate[0], coordinate[1], coordinate[0], coordinate[1]);
        }
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
