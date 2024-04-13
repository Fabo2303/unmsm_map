package com.fabo.unmsmmap.utilidades;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class CargaImagen {

	public static void setImagen(JLabel auxLabel, String path) {
		ImageIcon a = chargeImageIcon(path);
		auxLabel.setIcon(new ImageIcon(
				a.getImage().getScaledInstance((int) auxLabel.getPreferredSize().getWidth(),
						(int) auxLabel.getPreferredSize().getHeight(), Image.SCALE_SMOOTH)));
	}

	public static ImageIcon chargeImageIcon(String path) {
		Image image = null;
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("No se encontro la imagen: " + path);
		}
		return new ImageIcon(image);
	}
}
