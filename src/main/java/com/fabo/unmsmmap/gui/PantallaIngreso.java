package com.fabo.unmsmmap.gui;

import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

import com.fabo.unmsmmap.gui.administrador.LoginAdministrador;
import com.fabo.unmsmmap.utilidades.CargaImagen;
import com.fabo.unmsmmap.utilidades.CustomButton;
import com.fabo.unmsmmap.utilidades.Formato;
import com.fabo.unmsmmap.utilidades.ImagePanel;
import com.fabo.unmsmmap.utilidades.RutasArchivos;

public class PantallaIngreso {
	private ImagePanel imagePanel;
	private SpringLayout springLayout;
	private JLabel logo, ingresoLabel, tipoUsuarioLabel, visitanteIcon, administradorIcon;
	private CustomButton visitanteButton, administradorButton;

	public PantallaIngreso() {
		imagePanel = ImagePanel.getInstance(RutasArchivos.FONDO);
		springLayout = new SpringLayout();
		imagePanel.setLayout(springLayout);
		initComponentes();
		addResizeListener();
	}

	private void initComponentes() {
		logo();
		labelIngreso();
		labelTipoUsuario();
		buttonVisitante();
		buttonAdministrador();
		iconVisitante();
		iconAdministrador();
	}

	private void updatePositionComponents() {
		updatePositionLogo();
		updatePositionLabelIngreso();
		updatePositionLabelTipoUsuario();
		updateButtonVisitante();
		updateButtonAdministrador();
		updateIconVisitante();
		updateIconAdministrador();
	}

	private void logo() {
		logo = new JLabel("Logo");
		logo.setPreferredSize(new Dimension(148, 148));
		CargaImagen.setImagen(logo, RutasArchivos.LOGO);
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

	private void labelIngreso() {
		ingresoLabel = new JLabel("INGRESO");
		ingresoLabel.setPreferredSize(new Dimension(300, 40));
		Formato.formato(ingresoLabel, 1, 45f);
		updatePositionLabelIngreso();
		imagePanel.add(ingresoLabel);
	}

	private void updatePositionLabelIngreso() {
		springLayout.putConstraint(SpringLayout.WEST, ingresoLabel,
				(int) ((imagePanel.getWidth() - ingresoLabel.getPreferredSize().getWidth()) / 1.9), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, ingresoLabel,
				200, SpringLayout.NORTH, imagePanel);
	}

	private void labelTipoUsuario() {
		tipoUsuarioLabel = new JLabel("Seleccione un tipo de usuario:");
		tipoUsuarioLabel.setPreferredSize(new Dimension(350, 40));
		Formato.formato(tipoUsuarioLabel, 0, 16f);
		updatePositionLabelTipoUsuario();
		imagePanel.add(tipoUsuarioLabel);
	}

	private void updatePositionLabelTipoUsuario() {
		springLayout.putConstraint(SpringLayout.WEST, tipoUsuarioLabel,
				(int) ((imagePanel.getWidth() - tipoUsuarioLabel.getPreferredSize().getWidth()) / 1.8),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, tipoUsuarioLabel,
				250, SpringLayout.NORTH, imagePanel);
	}

	private void buttonVisitante() {
		visitanteButton = new CustomButton();
		visitanteButton.setText("VISITANTE");
		visitanteButton.setPreferredSize(new Dimension(225, 50));
		Formato.formato(visitanteButton, 0, 25f, 10, 2);
		visitanteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imagePanel.removeAll();
				// MapaDibujado pantallaEleccion = new MapaDibujado(ventana, grafo);
				imagePanel.repaint();
				imagePanel.revalidate();
			}
		});
		updateButtonVisitante();
		imagePanel.add(visitanteButton);
	}

	private void updateButtonVisitante() {
		springLayout.putConstraint(SpringLayout.WEST, visitanteButton,
				(int) ((imagePanel.getWidth() - visitanteButton.getPreferredSize().getWidth()) / 4.25),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, visitanteButton,
				500, SpringLayout.NORTH, imagePanel);
	}

	private void iconVisitante() {
		visitanteIcon = new JLabel("Visit");
		visitanteIcon.setPreferredSize(new Dimension(148, 148));
		CargaImagen.setImagen(visitanteIcon, RutasArchivos.ICON_VISITANTE);
		Formato.formato(visitanteIcon, 0, 40f);
		visitanteIcon.setOpaque(true);
		updateIconVisitante();
		imagePanel.add(visitanteIcon);
	}

	private void updateIconVisitante() {
		springLayout.putConstraint(SpringLayout.WEST, visitanteIcon,
				(int) ((imagePanel.getWidth() - visitanteIcon.getPreferredSize().getWidth()) / 4), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, visitanteIcon,
				300, SpringLayout.NORTH, imagePanel);
	}

	private void buttonAdministrador() {
		administradorButton = new CustomButton();
		administradorButton.setText("ADMINISTRADOR");
		administradorButton.setPreferredSize(new Dimension(290, 50));
		Formato.formato(administradorButton, 0, 25f, 10, 2);
		administradorButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imagePanel.removeAll();
				new LoginAdministrador();
				imagePanel.repaint();
				imagePanel.revalidate();
			}
		});
		updateButtonAdministrador();
		imagePanel.add(administradorButton);
	}

	private void updateButtonAdministrador() {
		springLayout.putConstraint(SpringLayout.WEST, administradorButton,
				(int) ((imagePanel.getWidth() - administradorButton.getPreferredSize().getWidth()) / 1.25),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, administradorButton,
				500, SpringLayout.NORTH, imagePanel);
	}

	private void iconAdministrador() {
		administradorIcon = new JLabel("Admin");
		administradorIcon = new JLabel("Visit");
		administradorIcon.setPreferredSize(new Dimension(148, 148));
		CargaImagen.setImagen(administradorIcon, RutasArchivos.ICON_ADMINISTRADOR);
		Formato.formato(administradorIcon, 0, 40f);
		administradorIcon.setOpaque(true);
		updateIconAdministrador();
		imagePanel.add(administradorIcon);
	}

	private void updateIconAdministrador() {
		springLayout.putConstraint(SpringLayout.WEST, administradorIcon,
				(int) ((imagePanel.getWidth() - administradorIcon.getPreferredSize().getWidth()) / 1.32),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, administradorIcon,
				300, SpringLayout.NORTH, imagePanel);
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