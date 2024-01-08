package com.fabo.unmsmmap.gui.agregar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.fabo.unmsmmap.utilidades.*;

public class PantallaAgregarFacultad {
	private ImagePanel imagePanel;
	private SpringLayout springLayout;
	private JLabel tituloLabel, logo;
	private CustomButton regresarButton;
	private JLabel codigoLabel, nombreLabel, telefonoLabel, correoLabel, descripcionLabel, insertLogoLabel,
			insertImgLabel;
	private CustomButton adjuntarLogoButton, adjuntarImagenesButton, guardarButton;
	private JTextField codigoTextField, nombreTextField, telefonoTextField, correoTextField;
	private JTextArea descripcionTextArea;

	public PantallaAgregarFacultad() {
		imagePanel = ImagePanel.getInstance();
		springLayout = new SpringLayout();
		imagePanel.setLayout(springLayout);
		initComponentes();
		addResizeListener();
	}

	private void initComponentes() {
		labelTitulo();
		codigo();
		nombre();
		telefono();
		correo();
		descripcion();
		labelAdjLogo();
		buttonAdjuntarLogo();
		labelAdjImg();
		buttonAdjImagen();
		buttonGuardar();
		logo();
		buttonRegresar();
	}

	private void updatePositionComponents() {
		updatePositionLabelTitulo();
		updatePositionCodigo();
		updatePositionNombre();
		updatePositionCorreo();
		updatePositionTelefono();
		updatePositionDescripcion();
		updatePositionAdjLogo();
		updatePositionButtonAdjuntarLogo();
		updatePositionLabelAdjImg();
		updatePositionButtonAdjImagen();
		updatePositionButtonGuardar();
		updatePositionLogo();
		updatePositionButtonRegresar();
	}

	private void labelTitulo() {
		tituloLabel = new JLabel("AGREGAR FACULTAD");
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

	private void codigo() {
		codigoLabel = new JLabel("Código");
		codigoLabel.setPreferredSize(new Dimension(260, 40));
		Formato.formato(codigoLabel, 0, 28f);
		imagePanel.add(codigoLabel);

		codigoTextField = new JTextField();
		codigoTextField.setPreferredSize(new Dimension(300, 40));
		Formato.formato(codigoTextField, 0, 28f);
		codigoTextField.setForeground(Color.black);
		codigoTextField.setOpaque(true);
		imagePanel.add(codigoTextField);
		updatePositionCodigo();
	}

	private void updatePositionCodigo() {
		springLayout.putConstraint(SpringLayout.WEST, codigoLabel,
				(int) ((imagePanel.getWidth() - codigoLabel.getPreferredSize().getWidth()) / 15), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, codigoLabel,
				230, SpringLayout.NORTH, imagePanel);
		springLayout.putConstraint(SpringLayout.WEST, codigoTextField,
				(int) ((imagePanel.getWidth() - codigoTextField.getPreferredSize().getWidth()) / 4),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, codigoTextField,
				230, SpringLayout.NORTH, imagePanel);
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
				280, SpringLayout.NORTH, imagePanel);
		springLayout.putConstraint(SpringLayout.WEST, nombreTextField,
				(int) ((imagePanel.getWidth() - nombreTextField.getPreferredSize().getWidth()) / 4),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, nombreTextField,
				280, SpringLayout.NORTH, imagePanel);
	}

	private void telefono() {
		telefonoLabel = new JLabel("Teléfono");
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
				330, SpringLayout.NORTH, imagePanel);
		springLayout.putConstraint(SpringLayout.WEST, telefonoTextField,
				(int) ((imagePanel.getWidth() - telefonoTextField.getPreferredSize().getWidth()) / 4),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, telefonoTextField,
				330, SpringLayout.NORTH, imagePanel);
	}

	private void correo() {
		correoLabel = new JLabel("Correo");
		correoLabel.setPreferredSize(new Dimension(260, 40));
		Formato.formato(correoLabel, 0, 26f);
		imagePanel.add(correoLabel);

		correoTextField = new JTextField();
		correoTextField.setPreferredSize(new Dimension(300, 40));
		Formato.formato(correoTextField, 0, 28f);
		correoTextField.setForeground(Color.black);
		correoTextField.setOpaque(true);
		imagePanel.add(correoTextField);
		updatePositionCorreo();
	}

	private void updatePositionCorreo() {
		springLayout.putConstraint(SpringLayout.WEST, correoLabel,
				(int) ((imagePanel.getWidth() - correoLabel.getPreferredSize().getWidth()) / 15), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, correoLabel,
				380, SpringLayout.NORTH, imagePanel);
		springLayout.putConstraint(SpringLayout.WEST, correoTextField,
				(int) ((imagePanel.getWidth() - correoTextField.getPreferredSize().getWidth()) / 4),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, correoTextField,
				380, SpringLayout.NORTH, imagePanel);
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
				230, SpringLayout.NORTH, imagePanel);
		springLayout.putConstraint(SpringLayout.WEST, descripcionTextArea,
				(int) ((imagePanel.getWidth() - descripcionTextArea.getPreferredSize().getWidth()) / 1.3),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, descripcionTextArea,
				280, SpringLayout.NORTH, imagePanel);
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
				380, SpringLayout.NORTH, imagePanel);
	}

	private void buttonAdjuntarLogo() {
		adjuntarLogoButton = new CustomButton("ADJUNTAR LOGO");
		adjuntarLogoButton.setPreferredSize(new Dimension(360, 40));
		Formato.formato(adjuntarLogoButton, 0, 25f, 10, 2);
		adjuntarLogoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// POR MODIFICAR
				// Agregar filechooser
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
				380, SpringLayout.NORTH, imagePanel);
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
				430, SpringLayout.NORTH, imagePanel);
	}

	private void buttonAdjImagen() {
		adjuntarImagenesButton = new CustomButton("ADJUNTAR IMÁGENES");
		adjuntarImagenesButton.setPreferredSize(new Dimension(360, 40));
		Formato.formato(adjuntarImagenesButton, 0, 25f, 10, 2);
		adjuntarImagenesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Agregar filechooser
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
				430, SpringLayout.NORTH, imagePanel);
	}

	private void buttonGuardar() {
		guardarButton = new CustomButton("GUARDAR");
		guardarButton.setPreferredSize(new Dimension(260, 42));
		Formato.formato(guardarButton, 0, 25f, 10, 2);
		guardarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		updatePositionButtonGuardar();
		imagePanel.add(guardarButton);
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
				new PantallaAgregarEstablecimiento();
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