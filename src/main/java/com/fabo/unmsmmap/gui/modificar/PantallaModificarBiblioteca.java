package com.fabo.unmsmmap.gui.modificar;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import com.fabo.unmsmmap.logica.entidades.Biblioteca;
import com.fabo.unmsmmap.utilidades.*;

public class PantallaModificarBiblioteca {
	private ImagePanel imagePanel;
	private SpringLayout springLayout;
	private JLabel tituloLabel, logo, nombreLabel, telefonoLabel, atencionLabel, descripcionLabel, insertLogoLabel,
			insertImgLabel;
	private CustomButton regresarButton, adjuntarLogoButton, adjuntarImagenesButton, guardarButton;
	private JTextField nombreTextField, telefonoTextField, atencionTextField;
	private JTextArea descripcionTextArea;
	private Biblioteca biblioteca;
	private String iconLogo;
	private ArrayList<String> iconGallery;
	private JComboBox<String> bibliotecaBox;
	private ArrayList<Biblioteca> listaBibliotecas;

	public PantallaModificarBiblioteca() {
		imagePanel = ImagePanel.getInstance();
		springLayout = new SpringLayout();
		imagePanel.setLayout(springLayout);
		initBibliotecas();
		biblioteca = listaBibliotecas.get(0);
		initComponentes();
		updateComponentData();
		addResizeListener();
		addResizeListener();
	}

	public void updateComponentData() {
		nombreTextField.setText(biblioteca.getNombre());
		telefonoTextField.setText(biblioteca.getTelefono());
		atencionTextField.setText(biblioteca.getHorarioAtencion());
		descripcionTextArea.setText(biblioteca.getDescripcion());
		iconLogo = biblioteca.getLogo();
		iconGallery = biblioteca.getImagenes();
	}

	public void initBibliotecas() {
		listaBibliotecas = ManejadorArchivos.getObjectFromJson(RutasArchivos.BIBLIOTECAS_FILE, Biblioteca.class);
	}

	public String[] getBibliotecas() {
		ArrayList<String> bibliotecas = new ArrayList<String>();
		for (Object objeto : listaBibliotecas) {
			if (objeto instanceof Biblioteca) {
				Biblioteca biblioteca = (Biblioteca) objeto;
				bibliotecas.add(biblioteca.getNombre());
			}
		}
		return bibliotecas.toArray(new String[0]);
	}

	private void comboBoxBibliotecas() {
		bibliotecaBox = new JComboBox<String>(getBibliotecas());
		bibliotecaBox.setPreferredSize(new Dimension(600, 40));
		Formato.formato(bibliotecaBox, 0, 28f);
		bibliotecaBox.setOpaque(true);
		bibliotecaBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				biblioteca = listaBibliotecas.get(bibliotecaBox.getSelectedIndex());
				updateComponentData();
			}
		});
		updatePositionComboComedores();
		imagePanel.add(bibliotecaBox);
	}

	private void updatePositionComboComedores() {
		springLayout.putConstraint(SpringLayout.WEST, bibliotecaBox,
				(int) ((imagePanel.getWidth() - bibliotecaBox.getPreferredSize().getWidth()) / 2), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, bibliotecaBox,
				240, SpringLayout.NORTH, imagePanel);
	}

	private void initComponentes() {
		labelTitulo();
		nombre();
		telefono();
		atencion();
		descripcion();
		labelAdjLogo();
		buttonAdjuntarLogo();
		labelAdjImg();
		buttonAdjImagen();
		buttonGuardar();
		comboBoxBibliotecas();
		logo();
		buttonRegresar();
	}

	private void updatePositionComponents() {
		updatePositionLabelTitulo();
		updatePositionNombre();
		updatePositionTelefono();
		updatePositionAtencion();
		updatePositionDescripcion();
		updatePositionAdjLogo();
		updatePositionButtonAdjuntarLogo();
		updatePositionLabelAdjImg();
		updatePositionButtonAdjImagen();
		updatePositionButtonGuardar();
		updatePositionLogo();
		updatePositionButtonRegresar();
		updatePositionComboComedores();
	}

	private void labelTitulo() {
		tituloLabel = new JLabel("MODIFICAR BIBLIOTECA");
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

	private void nombre() {
		nombreLabel = new JLabel("Nombre");
		nombreLabel.setPreferredSize(new Dimension(260, 40));
		Formato.formato(nombreLabel, 0, 28f);
		imagePanel.add(nombreLabel);

		nombreTextField = new JTextField();
		nombreTextField.setPreferredSize(new Dimension(300, 40));
		Formato.formato(nombreTextField, 0, 28f);
		nombreTextField.setForeground(Color.black);
		nombreTextField.setOpaque(true);
		imagePanel.add(nombreTextField);
		updatePositionNombre();
	}

	private void updatePositionNombre() {
		springLayout.putConstraint(SpringLayout.WEST, nombreLabel,
				(int) ((imagePanel.getWidth() - nombreLabel.getPreferredSize().getWidth()) / 15), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, nombreLabel,
				300, SpringLayout.NORTH, imagePanel);
		springLayout.putConstraint(SpringLayout.WEST, nombreTextField,
				(int) ((imagePanel.getWidth() - nombreTextField.getPreferredSize().getWidth()) / 4),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, nombreTextField,
				300, SpringLayout.NORTH, imagePanel);
	}

	private void telefono() {
		telefonoLabel = new JLabel("Telefono");
		telefonoLabel.setPreferredSize(new Dimension(260, 40));
		Formato.formato(telefonoLabel, 0, 28f);
		imagePanel.add(telefonoLabel);

		telefonoTextField = new JTextField();
		telefonoTextField.setPreferredSize(new Dimension(300, 40));
		Formato.formato(telefonoTextField, 0, 28f);
		telefonoTextField.setForeground(Color.black);
		telefonoTextField.setOpaque(true);
		imagePanel.add(telefonoTextField);
		updatePositionTelefono();
	}

	private void updatePositionTelefono() {
		springLayout.putConstraint(SpringLayout.WEST, telefonoLabel,
				(int) ((imagePanel.getWidth() - telefonoLabel.getPreferredSize().getWidth()) / 15), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, telefonoLabel,
				350, SpringLayout.NORTH, imagePanel);
		springLayout.putConstraint(SpringLayout.WEST, telefonoTextField,
				(int) ((imagePanel.getWidth() - telefonoTextField.getPreferredSize().getWidth()) / 4),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, telefonoTextField,
				350, SpringLayout.NORTH, imagePanel);
	}

	private void atencion() {
		atencionLabel = new JLabel("Atención");
		atencionLabel.setPreferredSize(new Dimension(260, 40));
		Formato.formato(atencionLabel, 0, 28f);
		imagePanel.add(atencionLabel);

		atencionTextField = new JTextField();
		atencionTextField.setPreferredSize(new Dimension(300, 40));
		Formato.formato(atencionTextField, 0, 28f);
		atencionTextField.setForeground(Color.black);
		atencionTextField.setOpaque(true);
		imagePanel.add(atencionTextField);
		updatePositionAtencion();
	}

	private void updatePositionAtencion() {
		springLayout.putConstraint(SpringLayout.WEST, atencionLabel,
				(int) ((imagePanel.getWidth() - atencionLabel.getPreferredSize().getWidth()) / 15), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, atencionLabel,
				400, SpringLayout.NORTH, imagePanel);
		springLayout.putConstraint(SpringLayout.WEST, atencionTextField,
				(int) ((imagePanel.getWidth() - atencionTextField.getPreferredSize().getWidth()) / 4),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, atencionTextField,
				400, SpringLayout.NORTH, imagePanel);
	}

	private void descripcion() {
		descripcionLabel = new JLabel("Descripción");
		descripcionLabel.setPreferredSize(new Dimension(260, 40));
		Formato.formato(descripcionLabel, 0, 28f);
		imagePanel.add(descripcionLabel);

		descripcionTextArea = new JTextArea();
		descripcionTextArea.setPreferredSize(new Dimension(400, 80));
		Formato.formato(descripcionTextArea);
		descripcionTextArea.setEditable(true);
		descripcionTextArea.setForeground(Color.black);
		descripcionTextArea.setOpaque(true);
		imagePanel.add(descripcionTextArea);
		updatePositionDescripcion();
	}

	private void updatePositionDescripcion() {
		springLayout.putConstraint(SpringLayout.WEST, descripcionLabel,
				(int) ((imagePanel.getWidth() - descripcionLabel.getPreferredSize().getWidth()) / 1.5),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, descripcionLabel,
				300, SpringLayout.NORTH, imagePanel);
		springLayout.putConstraint(SpringLayout.WEST, descripcionTextArea,
				(int) ((imagePanel.getWidth() - descripcionTextArea.getPreferredSize().getWidth()) / 1.3),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, descripcionTextArea,
				350, SpringLayout.NORTH, imagePanel);
	}

	private void labelAdjLogo() {
		insertLogoLabel = new JLabel("Logo");
		insertLogoLabel.setPreferredSize(new Dimension(150, 40));
		Formato.formato(insertLogoLabel, 0, 26f);
		imagePanel.add(insertLogoLabel);
		updatePositionAdjLogo();
	}

	private void updatePositionAdjLogo() {
		springLayout.putConstraint(SpringLayout.WEST, insertLogoLabel,
				(int) ((imagePanel.getWidth() - insertLogoLabel.getPreferredSize().getWidth()) / 1.65),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, insertLogoLabel,
				450, SpringLayout.NORTH, imagePanel);
	}

	private void buttonAdjuntarLogo() {
		adjuntarLogoButton = new CustomButton("ADJUNTAR LOGO");
		adjuntarLogoButton.setPreferredSize(new Dimension(360, 40));
		Formato.formato(adjuntarLogoButton, 0, 25f, 10, 2);
		adjuntarLogoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iconLogo = FileChooser.seleccionarArchivo();
			}
		});
		imagePanel.add(adjuntarLogoButton);
		updatePositionButtonAdjuntarLogo();
	}

	private void updatePositionButtonAdjuntarLogo() {
		springLayout.putConstraint(SpringLayout.WEST, adjuntarLogoButton,
				(int) ((imagePanel.getWidth() - adjuntarLogoButton.getPreferredSize().getWidth()) / 1.05),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, adjuntarLogoButton,
				450, SpringLayout.NORTH, imagePanel);
	}

	private void labelAdjImg() {
		insertImgLabel = new JLabel("Imágenes");
		insertImgLabel.setPreferredSize(new Dimension(200, 40));
		Formato.formato(insertImgLabel, 0, 24f);
		imagePanel.add(insertImgLabel);
		updatePositionLabelAdjImg();
	}

	private void updatePositionLabelAdjImg() {
		springLayout.putConstraint(SpringLayout.WEST, insertImgLabel,
				(int) ((imagePanel.getWidth() - insertImgLabel.getPreferredSize().getWidth()) / 1.57),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, insertImgLabel,
				500, SpringLayout.NORTH, imagePanel);
	}

	private void buttonAdjImagen() {
		adjuntarImagenesButton = new CustomButton("ADJUNTAR IMÁGENES");
		adjuntarImagenesButton.setPreferredSize(new Dimension(360, 40));
		Formato.formato(adjuntarImagenesButton, 0, 25f, 10, 2);
		adjuntarImagenesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iconGallery.add(FileChooser.seleccionarArchivo());
			}
		});
		imagePanel.add(adjuntarImagenesButton);
		updatePositionButtonAdjImagen();
	}

	private void updatePositionButtonAdjImagen() {
		springLayout.putConstraint(SpringLayout.WEST, adjuntarImagenesButton,
				(int) ((imagePanel.getWidth() - adjuntarImagenesButton.getPreferredSize().getWidth()) / 1.05),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, adjuntarImagenesButton,
				500, SpringLayout.NORTH, imagePanel);
	}

	private void buttonGuardar() {
		guardarButton = new CustomButton("GUARDAR");
		guardarButton.setPreferredSize(new Dimension(260, 42));
		Formato.formato(guardarButton, 0, 25f, 10, 2);
		guardarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarBiblioteca();
			}
		});
		updatePositionButtonGuardar();
		imagePanel.add(guardarButton);
	}

	private void modificarBiblioteca() {
		String nombre = nombreTextField.getText();
		String telefono = telefonoTextField.getText();
		String horarioAtencion = atencionTextField.getText();
		String descripcion = descripcionTextArea.getText();
		if (!nombre.isBlank() && !telefono.isBlank() && !horarioAtencion.isBlank() && !descripcion.isBlank()
				&& !iconLogo.isBlank() && iconGallery.size() > 0) {
			Biblioteca modificado = new Biblioteca(biblioteca.getAlias(), nombre, descripcion, iconLogo, iconGallery,
					telefono, horarioAtencion);
			int index = listaBibliotecas.indexOf(biblioteca);
			listaBibliotecas.remove(index);
			listaBibliotecas.add(index, modificado);
			ManejadorArchivos.saveObjectToJson(listaBibliotecas, RutasArchivos.BIBLIOTECAS_FILE);
			imagePanel.removeAll();
			new PantallaModificarBiblioteca();
			imagePanel.repaint();
			imagePanel.revalidate();
		}
	}

	private void updatePositionButtonGuardar() {
		springLayout.putConstraint(SpringLayout.WEST, guardarButton,
				(int) ((imagePanel.getWidth() - guardarButton.getPreferredSize().getWidth()) / 1.05),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, guardarButton,
				600, SpringLayout.NORTH, imagePanel);
	}

	private void buttonRegresar() {
		regresarButton = new CustomButton("REGRESAR");
		regresarButton.setPreferredSize(new Dimension(260, 42));
		Formato.formato(regresarButton, 0, 25f, 10, 2);
		regresarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imagePanel.removeAll();
				new PantallaModificarEstablecimiento();
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