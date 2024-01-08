package com.fabo.unmsmmap.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.fabo.unmsmmap.utilidades.ImagePanel;

public class PantallaInicial {

	private ImagePanel imagePanel;

	public PantallaInicial() {
		imagePanel = ImagePanel.getInstance();
		addListener();
	}

	public void addListener() {
		imagePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imagePanel.removeAll();
				imagePanel.removeMouseListener(this);
				new PantallaIngreso();
				imagePanel.repaint();
				imagePanel.revalidate();
			}
		});
	}
}
