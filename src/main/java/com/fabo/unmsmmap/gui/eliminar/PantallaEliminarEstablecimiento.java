package com.fabo.unmsmmap.gui.eliminar;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import com.fabo.unmsmmap.gui.administrador.PantallaMenuAdmin;
import com.fabo.unmsmmap.utilidades.CargaImagen;
import com.fabo.unmsmmap.utilidades.CustomButton;
import com.fabo.unmsmmap.utilidades.Formato;
import com.fabo.unmsmmap.utilidades.ImagePanel;

public class PantallaEliminarEstablecimiento {

	private ImagePanel imagePanel;
	private JLabel tituloLabel, tituloLabel2, logo;
	private SpringLayout springLayout;
	private CustomButton facultadButton, comedorButton, bibliotecaButton, regresarButton;

	public PantallaEliminarEstablecimiento() {
		imagePanel = ImagePanel.getInstance();
		springLayout = new SpringLayout();
		imagePanel.setLayout(springLayout);
		initComponentes();
		addResizeListener();
	}

	private void initComponentes() {
		labelTitulo();
		buttonFacultad();
		buttonBiblioteca();
		buttonComedor();
		buttonRegresar();
		logo();
	}

	private void updatePositionComponents() {
		updatePositionLabelTitulo();
		updatePositionbuttonFacultad();
		updatePositionbuttonComedor();
		updatePositionLogo();
		updatePositionButtonRegresar();
	}

	private void labelTitulo() {
		tituloLabel = new JLabel("MENÚ");
		tituloLabel.setPreferredSize(new Dimension(120, 40));
		Formato.formato(tituloLabel, 1, 32f);

		tituloLabel2 = new JLabel("ELIMINAR");
		tituloLabel2.setPreferredSize(new Dimension(200, 40));
		Formato.formato(tituloLabel2, 1, 32f);

		updatePositionLabelTitulo();
		imagePanel.add(tituloLabel);
		imagePanel.add(tituloLabel2);
	}

	private void updatePositionLabelTitulo() {
		springLayout.putConstraint(SpringLayout.WEST, tituloLabel,
				(int) ((imagePanel.getWidth() - tituloLabel.getPreferredSize().getWidth()) / 2), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, tituloLabel,
				180, SpringLayout.NORTH, imagePanel);

		springLayout.putConstraint(SpringLayout.WEST, tituloLabel2,
				(int) ((imagePanel.getWidth() - tituloLabel2.getPreferredSize().getWidth()) / 2), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, tituloLabel2,
				230, SpringLayout.NORTH, imagePanel);
	}

	private void buttonFacultad() {
		facultadButton = new CustomButton("FACULTAD ");
		facultadButton.setPreferredSize(new Dimension(200, 42));
		Formato.formato(facultadButton, 0, 25f, 10, 2);
		facultadButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imagePanel.removeAll();
				new PantallaEliminarFacultad();
				imagePanel.repaint();
				imagePanel.revalidate();
			}
		});
		updatePositionbuttonFacultad();
		imagePanel.add(facultadButton);
	}

	private void updatePositionbuttonFacultad() {
		springLayout.putConstraint(SpringLayout.WEST, facultadButton,
				(int) ((imagePanel.getWidth() - facultadButton.getPreferredSize().getWidth()) / 2),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, facultadButton,
				300, SpringLayout.NORTH, imagePanel);
	}

	private void buttonBiblioteca() {
		bibliotecaButton = new CustomButton("BIBLIOTECA");
		bibliotecaButton.setPreferredSize(new Dimension(200, 42));
		Formato.formato(bibliotecaButton, 0, 23f, 10, 2);
		bibliotecaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imagePanel.removeAll();
				new PantallaEliminarBiblioteca();
				imagePanel.repaint();
				imagePanel.revalidate();
			}
		});
		updatePositionbuttonBiblioteca();
		imagePanel.add(bibliotecaButton);
	}

	private void updatePositionbuttonBiblioteca() {
		springLayout.putConstraint(SpringLayout.WEST, bibliotecaButton,
				(int) ((imagePanel.getWidth() - bibliotecaButton.getPreferredSize().getWidth()) / 2),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, bibliotecaButton,
				370, SpringLayout.NORTH, imagePanel);
	}

	private void buttonComedor() {
		comedorButton = new CustomButton("COMEDOR");
		comedorButton.setPreferredSize(new Dimension(200, 42));
		Formato.formato(comedorButton, 0, 25f, 10, 2);
		comedorButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imagePanel.removeAll();
				new PantallaEliminarComedor();
				imagePanel.repaint();
				imagePanel.revalidate();
			}
		});
		updatePositionbuttonComedor();
		imagePanel.add(comedorButton);
	}

	private void updatePositionbuttonComedor() {
		springLayout.putConstraint(SpringLayout.WEST, comedorButton,
				(int) ((imagePanel.getWidth() - comedorButton.getPreferredSize().getWidth()) / 2),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, comedorButton,
				440, SpringLayout.NORTH, imagePanel);
	}

	private void buttonRegresar() {
		regresarButton = new CustomButton("REGRESAR");
		regresarButton.setPreferredSize(new Dimension(200, 42));
		Formato.formato(regresarButton, 0, 25f, 10, 2);
		regresarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imagePanel.removeAll();
				new PantallaMenuAdmin();
				imagePanel.repaint();
				imagePanel.revalidate();
			}
		});
		updatePositionButtonRegresar();
		imagePanel.add(regresarButton);
	}

	private void updatePositionButtonRegresar() {
		springLayout.putConstraint(SpringLayout.WEST, regresarButton,
				(int) ((imagePanel.getWidth() - regresarButton.getPreferredSize().getWidth()) / 7),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, regresarButton,
				600, SpringLayout.NORTH, imagePanel);
	}

	private void logo() {
		logo = new JLabel("Logo");
		logo.setPreferredSize(new Dimension(148, 148));
		CargaImagen.setImagen(logo, "src/main/resources/imagenes/logo.webp");
		Formato.formato(logo, 0, 40f);
		logo.setOpaque(true);
		updatePositionLogo();
		imagePanel.add(logo);
	}

	private void updatePositionLogo() {
		springLayout.putConstraint(SpringLayout.WEST, logo,
				(int) ((imagePanel.getWidth() - logo.getPreferredSize().getWidth()) / 2), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, logo,
				10, SpringLayout.NORTH, imagePanel);
	}

	private void addResizeListener() {
		imagePanel.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				updatePositionComponents();
				imagePanel.repaint();
				imagePanel.revalidate();
			}
		});
	}
}
