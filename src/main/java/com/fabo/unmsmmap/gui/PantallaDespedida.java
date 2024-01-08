package com.fabo.unmsmmap.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PantallaDespedida extends JPanel{
	private JFrame frame;
	private BufferedImage image;

	public PantallaDespedida() {
		frame.setSize(240, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
		setImage();
        frame.add(this);
	}

	public void setImage(String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Tu imagen no existe.");
        }
    }

	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), frame);
        }
    }
}
