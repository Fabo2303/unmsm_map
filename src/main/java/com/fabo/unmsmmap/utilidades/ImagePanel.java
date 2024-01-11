package com.fabo.unmsmmap.utilidades;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private BufferedImage image;
    private static ImagePanel instance;

    private ImagePanel() {
    }

    /**
     * 
     * 
     * @return retorna instancia ImagePanel
     */
    public static ImagePanel getInstance() {
        if (instance == null) {
            instance = new ImagePanel();
        }
        return instance;
    }

    public static ImagePanel getInstance(String path) {
        ImagePanel imagePanel = getInstance();
        imagePanel.setImage(path);
        return imagePanel;
    }

    /**
     * 
     * @param path ruta de la imagen
     */
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
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
