package com.fabo.unmsmmap.gui.administrador;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import com.fabo.unmsmmap.gui.PantallaIngreso;
import com.fabo.unmsmmap.gui.agregar.PantallaAgregarEstablecimiento;
import com.fabo.unmsmmap.gui.eliminar.PantallaEliminarEstablecimiento;
import com.fabo.unmsmmap.gui.modificar.PantallaModificarEstablecimiento;
import com.fabo.unmsmmap.utilidades.CargaImagen;
import com.fabo.unmsmmap.utilidades.CustomButton;
import com.fabo.unmsmmap.utilidades.Formato;
import com.fabo.unmsmmap.utilidades.ImagePanel;

public class PantallaMenuAdmin {
	private ImagePanel imagePanel;
	private JLabel tituloLabel, tituloLabel2, logo;
	private SpringLayout springLayout;
	private CustomButton anyadirButton, modificarButton, eliminarButton, regresarButton;

	public PantallaMenuAdmin() {
		this.imagePanel = ImagePanel.getInstance();
		springLayout = new SpringLayout();
		imagePanel.setLayout(springLayout);
		initComponentes();
		addResizeListener();
	}

	private void initComponentes() {
		labelTitulo();
		logo();
		buttonAnyadir();
		buttonModificar();
		buttonEliminar();
		buttonRegresar();
	}

	private void updatePositionComponents() {
		updatePositionLabelTitulo();
		updatePositionLogo();
		updatePositionButtonAnyadir();
		updatePositionButtonModificar();
		updatePositionButtonEliminar();
		updatePositionButtonRegresar();
	}

	private void labelTitulo() {
		tituloLabel = new JLabel("MENÚ");
		tituloLabel.setPreferredSize(new Dimension(120, 40));
		Formato.formato(tituloLabel, 1, 32f);

		tituloLabel2 = new JLabel("ADMINISTRADOR");
		tituloLabel2.setPreferredSize(new Dimension(350, 40));
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

	private void buttonAnyadir() {
		anyadirButton = new CustomButton("AÑADIR ESTABLECIMIENTO");
		anyadirButton.setPreferredSize(new Dimension(480, 42));
		Formato.formato(anyadirButton, 0, 25f, 10, 2);
		anyadirButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imagePanel.removeAll();
				new PantallaAgregarEstablecimiento();
				imagePanel.repaint();
				imagePanel.revalidate();
			}
		});
		updatePositionButtonAnyadir();
		imagePanel.add(anyadirButton);
	}

	private void updatePositionButtonAnyadir() {
		springLayout.putConstraint(SpringLayout.WEST, anyadirButton,
				(int) ((imagePanel.getWidth() - anyadirButton.getPreferredSize().getWidth()) / 2),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, anyadirButton,
				300, SpringLayout.NORTH, imagePanel);
	}

	private void buttonModificar() {
		modificarButton = new CustomButton("MODIFICAR ESTABLECIMIENTO");
		modificarButton.setPreferredSize(new Dimension(480, 42));
		Formato.formato(modificarButton, 0, 23f, 10, 2);
		modificarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imagePanel.removeAll();
				new PantallaModificarEstablecimiento();
				imagePanel.repaint();
				imagePanel.revalidate();
			}
		});
		updatePositionButtonModificar();
		imagePanel.add(modificarButton);
	}

	private void updatePositionButtonModificar() {
		springLayout.putConstraint(SpringLayout.WEST, modificarButton,
				(int) ((imagePanel.getWidth() - modificarButton.getPreferredSize().getWidth()) / 2),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, modificarButton,
				370, SpringLayout.NORTH, imagePanel);
	}

	private void buttonEliminar() {
		eliminarButton = new CustomButton("ELIMINAR ESTABLECIMIENTO");
		eliminarButton.setPreferredSize(new Dimension(480, 42));
		Formato.formato(eliminarButton, 0, 25f, 10, 2);
		eliminarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imagePanel.removeAll();
				new PantallaEliminarEstablecimiento();
				imagePanel.repaint();
				imagePanel.revalidate();
			}
		});
		updatePositionButtonEliminar();
		imagePanel.add(eliminarButton);
	}

	private void updatePositionButtonEliminar() {
		springLayout.putConstraint(SpringLayout.WEST, eliminarButton,
				(int) ((imagePanel.getWidth() - eliminarButton.getPreferredSize().getWidth()) / 2),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, eliminarButton,
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
				new PantallaIngreso();
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
