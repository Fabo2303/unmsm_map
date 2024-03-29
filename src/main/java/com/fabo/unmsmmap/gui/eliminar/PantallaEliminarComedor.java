package com.fabo.unmsmmap.gui.eliminar;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;

import com.fabo.unmsmmap.logica.entidades.Comedor;
import com.fabo.unmsmmap.utilidades.CargaImagen;
import com.fabo.unmsmmap.utilidades.CustomButton;
import com.fabo.unmsmmap.utilidades.Formato;
import com.fabo.unmsmmap.utilidades.ImagePanel;
import com.fabo.unmsmmap.utilidades.ManejadorArchivos;
import com.fabo.unmsmmap.utilidades.RutasArchivos;

public class PantallaEliminarComedor {

	private ImagePanel imagePanel;
	private SpringLayout springLayout;
	private JLabel tituloLabel, logo;
	private CustomButton regresarButton, eliminarButton;
	private JComboBox<String> comedoresBox;
	private ArrayList<Comedor> listaComedores;

	public PantallaEliminarComedor() {
		imagePanel = ImagePanel.getInstance();
		springLayout = new SpringLayout();
		imagePanel.setLayout(springLayout);
		initComedores();
		initComponentes();
		addResizeListener();
	}

	private void initComponentes() {
		logo();
		labelTitulo();
		labelSubtitulo();
		boxComedores();
		buttonEliminar();
		buttonRegresar();
	}

	private void updatePositionComponents() {
		updatePositionLabelTitulo();
		updatePositionLogo();
		updatePositionButtonEliminar();
		updatePositionBoxComedores();
		updatePositionButtonRegresar();
	}

	public void initComedores(){
		listaComedores = ManejadorArchivos.getObjectFromJson(RutasArchivos.COMEDORES_FILE, Comedor.class);
	}

	private void labelTitulo() {
		tituloLabel = new JLabel("ELIMINAR COMEDOR");
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
		tituloLabel = new JLabel("Seleccione un Comedor");
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

	private String[] getComedores() {
		ArrayList<String> comedores = new ArrayList<String>();
		for (Object objeto : listaComedores) {
			if (objeto instanceof Comedor) {
				Comedor comedor = (Comedor) objeto;
				comedores.add(comedor.getNombre());
			}
		}
		return comedores.toArray(new String[0]);
	}

	private void boxComedores() {
		comedoresBox = new JComboBox<>(getComedores());
		comedoresBox.setPreferredSize(new Dimension(600, 40));
		Formato.formato(comedoresBox, 1, 26f);
		updatePositionBoxComedores();
		imagePanel.add(comedoresBox);
	}

	private void updatePositionBoxComedores() {
		springLayout.putConstraint(SpringLayout.WEST, comedoresBox,
				(int) ((imagePanel.getWidth() - comedoresBox.getPreferredSize().getWidth()) / 2), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, comedoresBox,
				330, SpringLayout.NORTH, imagePanel);
	}

	private void buttonEliminar() {
		eliminarButton = new CustomButton("ELIMINAR");
		eliminarButton.setPreferredSize(new Dimension(200, 42));
		Formato.formato(eliminarButton, 0, 25f, 10, 2);
		eliminarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listaComedores.remove(comedoresBox.getSelectedIndex());
				ManejadorArchivos.saveObjectToJson(listaComedores, RutasArchivos.COMEDORES_FILE);
				imagePanel.removeAll();
				new PantallaEliminarComedor();
				imagePanel.repaint();
				imagePanel.revalidate();
				JOptionPane.showMessageDialog(null, "Se elimino el comedor", "ELIMINAR", JOptionPane.INFORMATION_MESSAGE);
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