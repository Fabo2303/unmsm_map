package com.fabo.unmsmmap.gui.eliminar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import com.fabo.unmsmmap.logica.entidades.Establecimiento;
import com.fabo.unmsmmap.logica.entidades.Facultad;
import com.fabo.unmsmmap.utilidades.CargaImagen;
import com.fabo.unmsmmap.utilidades.CustomButton;
import com.fabo.unmsmmap.utilidades.Formato;
import com.fabo.unmsmmap.utilidades.ImagePanel;
import com.fabo.unmsmmap.utilidades.RutasArchivos;

public class PantallaEliminarFacultad {

	private ImagePanel imagePanel;
	private SpringLayout springLayout;
	private JLabel tituloLabel, logo;
	private CustomButton regresarButton, eliminarButton;
	private JComboBox<String> facultadesBox;

	public PantallaEliminarFacultad() {
		imagePanel = ImagePanel.getInstance();
		springLayout = new SpringLayout();
		imagePanel.setLayout(springLayout);
		initComponentes();
		addResizeListener();
	}

	private void initComponentes() {
		logo();
		labelTitulo();
		labelSubtitulo();
		boxFacultades();
		buttonEliminar();
		buttonRegresar();
	}

	private void updatePositionComponents() {
		updatePositionLabelTitulo();
		updatePositionLogo();
		updatePositionButtonEliminar();
		updatePositionBoxFacultades();
		updatePositionButtonRegresar();
	}

	private void labelTitulo() {
		tituloLabel = new JLabel("ELIMINAR FACULTAD");
		tituloLabel.setPreferredSize(new Dimension(440, 40));
		Formato.formato(tituloLabel, 1, 32f);
		updatePositionLabelTitulo();
		imagePanel.add(tituloLabel);
	}

	private void updatePositionLabelTitulo() {
		springLayout.putConstraint(SpringLayout.WEST, tituloLabel,
				(int) ((imagePanel.getWidth() - tituloLabel.getPreferredSize().getWidth()) / 2), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, tituloLabel,
				180, SpringLayout.NORTH, imagePanel);
	}

	private void labelSubtitulo() {
		tituloLabel = new JLabel("Seleccione una facultad");
		tituloLabel.setPreferredSize(new Dimension(350, 40));
		Formato.formato(tituloLabel, 1, 26f);
		updatePositionLabelSubtitulo();
		imagePanel.add(tituloLabel);
	}

	private void updatePositionLabelSubtitulo() {
		springLayout.putConstraint(SpringLayout.WEST, tituloLabel,
				(int) ((imagePanel.getWidth() - tituloLabel.getPreferredSize().getWidth()) / 2), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, tituloLabel,
				230, SpringLayout.NORTH, imagePanel);
	}

	private String[] getFacultades(ArrayList<Establecimiento> establecimientos) {
		ArrayList<String> facultades = new ArrayList<>();
		for (Object objeto : establecimientos) {
			if (objeto instanceof Facultad) {
				Facultad facultad = (Facultad) objeto;
				facultades.add(facultad.getNombre());
			}
		}
		return facultades.toArray(new String[0]);
	}

	private void boxFacultades() {
		facultadesBox = new JComboBox<>();
		facultadesBox.setPreferredSize(new Dimension(300, 40));
		Formato.formato(facultadesBox, 1, 26f);
		facultadesBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreFacultad = (String) facultadesBox.getSelectedItem();
			}
		});
		updatePositionBoxFacultades();
		imagePanel.add(facultadesBox);
	}

	private void updatePositionBoxFacultades() {
		springLayout.putConstraint(SpringLayout.WEST, facultadesBox,
				(int) ((imagePanel.getWidth() - facultadesBox.getPreferredSize().getWidth()) / 2), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, facultadesBox,
				330, SpringLayout.NORTH, imagePanel);
	}

	private void buttonEliminar() {
		eliminarButton = new CustomButton("ELIMINAR");
		eliminarButton.setPreferredSize(new Dimension(200, 42));
		Formato.formato(eliminarButton, 0, 25f, 10, 2);
		eliminarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// new PantallaAgregarEs
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
				new PantallaEliminarEstablecimiento();
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
