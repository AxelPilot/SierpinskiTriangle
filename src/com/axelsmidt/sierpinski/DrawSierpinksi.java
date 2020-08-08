package com.axelsmidt.sierpinski;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

public class DrawSierpinksi extends JPanel {
    public DrawSierpinksi() {
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        SecureRandom random = new SecureRandom();

        // Triangle corner coordinates.
        int[][] corners = new int[3][2];

        int[] coordinate = new int[2];
        coordinate[0] = random.nextInt(getWidth() - 20) + 10;
        coordinate[1] = random.nextInt(getHeight() - 20) + 10;

        // Top corner.
        corners[0][0] = getWidth() / 2;
        corners[0][1] = 10;

        // Bottom right corner.
        corners[1][0] = getWidth() - 10;
        corners[1][1] = getHeight() - 10;

        // Bottom left corner.
        corners[2][0] = 10;
        corners[2][1] = getHeight() - 10;

        g.setColor(Color.WHITE);

        // Drawing triangle.
        for (int coord[] : corners) {
            g.drawLine(coord[0], coord[1], coord[0], coord[1]);
        }

        g.drawLine(coordinate[0], coordinate[1], coordinate[0], coordinate[1]);

        for (int i = 0; i < 500000; i++) {
            int corner = random.nextInt(3);
            if (coordinate[0] < corners[corner][0]) {
                coordinate[0] = Math.round((corners[corner][0] - coordinate[0]) / 2) + coordinate[0];
            } else {
                coordinate[0] = Math.round((coordinate[0] - corners[corner][0]) / 2) + corners[corner][0];
            }

            if (coordinate[1] < corners[corner][1]) {
                coordinate[1] = Math.round((corners[corner][1] - coordinate[1]) / 2) + coordinate[1];
            } else {
                coordinate[1] = Math.round((coordinate[1] - corners[corner][1]) / 2) + corners[corner][1];
            }

            g.setColor(new Color(28 + random.nextInt(200), 28 + random.nextInt(200), 28 + random.nextInt(200)));
            g.drawLine(coordinate[0], coordinate[1], coordinate[0], coordinate[1]);
        }
    }
}
