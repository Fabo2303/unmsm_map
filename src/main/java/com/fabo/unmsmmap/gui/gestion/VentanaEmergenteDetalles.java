package com.fabo.unmsmmap.gui.gestion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.fabo.unmsmmap.logica.entidades.Biblioteca;
import com.fabo.unmsmmap.logica.entidades.Comedor;
import com.fabo.unmsmmap.logica.entidades.Establecimiento;
import com.fabo.unmsmmap.logica.entidades.Facultad;
import com.fabo.unmsmmap.utilidades.CargaImagen;
import com.fabo.unmsmmap.utilidades.CustomButton;
import com.fabo.unmsmmap.utilidades.Formato;
import com.fabo.unmsmmap.utilidades.RutasArchivos;

public class VentanaEmergenteDetalles extends JPanel {

	private JFrame ventana;
	private JLabel titulo1Label, titulo2Label;
	private JLabel nombreLabel, descripcionLabel, imagenesLabel, listaImgLabel;
	private JLabel codigoLabel, horarioLabel, capacidadLabel, correoLabel, telefonoLabel;
	private JTextField nombreField;
	private JTextArea descripcionArea;
	private JTextField codigoField, horarioField, capacidadField, correoField, telefonoField;
	private Establecimiento lugar;
	private ArrayList<String> fotos;
	private int indexImg = 0;
	private BufferedImage image;
	private final int WIDTH = 1200;
	private final int HEIGHT = 675;

	public VentanaEmergenteDetalles(Establecimiento lugar) {
		this.lugar = lugar;
		try {
			image = ImageIO.read(new File(RutasArchivos.FONDO));
		} catch (IOException e) {
			System.out.println("No se encontro la imagen: " + RutasArchivos.FONDO);
		}
		this.ventana = new JFrame();
		configVentana();
		initFondo();
		initComponentes();
		ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
	}

	private void configVentana() {
		ventana.setSize(WIDTH, HEIGHT);
		ventana.setTitle("ED-G5-UNMSM");
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.setResizable(false);
		confirmacionCerrar();
		ventana.setVisible(true);
	}

	private void confirmacionCerrar() {
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				int option = JOptionPane.showConfirmDialog(ventana, "¿Estás seguro de que quieres salir?",
						"Confirmar salida", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					ventana.dispose();
					ventana.setVisible(false);
				}
			}
		});
	}

	private void initFondo() {
		ventana.setSize(WIDTH, HEIGHT);
		ventana.setLocationRelativeTo(null);
		this.setLayout(null);
		ventana.getContentPane().add(this);
	}

	private void initComponentes() {
		initTitulo();
		initNombre();
		initDescripcion();
		initImagenes();
		if (lugar.getClass().equals(Facultad.class)) {
			initCorreo();
			initCodigo();
		} else {
			initHorario();
		}
		if (lugar.getClass().equals(Comedor.class)) {
			initCapacidad();
		} else {
			initTelefono();
		}
		initData();
		initLista();
		initDesign();
	}

	private void initDesign() {

		JLabel iconoLabel = new JLabel();
		iconoLabel.setPreferredSize(new Dimension((int) (WIDTH * 0.1), (int) (HEIGHT * 0.18)));
		iconoLabel.setBounds((int) (WIDTH * 0.87), (int) (HEIGHT * 0), (int) (WIDTH * 0.1), (int) (HEIGHT * 0.18));
		CargaImagen.setImagen(iconoLabel, RutasArchivos.LOGO);
		this.add(iconoLabel);

		JLabel lineaHorizontal = new JLabel();
		lineaHorizontal.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
		lineaHorizontal.setBounds((int) (WIDTH * 0.05), titulo2Label.getY(),
				(int) (titulo2Label.getX() - WIDTH * 0.075), 1);
		this.add(lineaHorizontal);

		JLabel lineaHorizontal2 = new JLabel();
		lineaHorizontal2.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
		lineaHorizontal2.setBounds((int) (titulo2Label.getX() + titulo2Label.getWidth() + WIDTH * 0.02),
				titulo2Label.getY(), (int) (iconoLabel.getX() - titulo2Label.getX() - WIDTH * 0.25), 1);
		this.add(lineaHorizontal2);
	}

	private void initTitulo() {
		titulo1Label = new JLabel("Informacion de");
		titulo1Label.setBounds((int) (WIDTH * (0.39)), (int) (HEIGHT * 0.05), (int) (WIDTH * 0.22),
				(int) (HEIGHT * 0.045));
		Formato.formato(titulo1Label, 1, (float) (HEIGHT * 0.045));
		this.add(titulo1Label);

		titulo2Label = new JLabel("Establecimiento");
		titulo2Label.setBounds((int) (WIDTH * (0.3865)), (int) (HEIGHT * 0.095), (int) (WIDTH * 0.235),
				(int) (HEIGHT * 0.045));
		Formato.formato(titulo2Label, 1, (float) (HEIGHT * 0.045));
		this.add(titulo2Label);
	}

	private void initNombre() {
		nombreLabel = new JLabel("Nombre");
		nombreLabel.setBounds((int) (WIDTH * 0.05), (int) (titulo2Label.getY() + HEIGHT * 0.15), (int) (WIDTH * 0.15),
				(int) (HEIGHT * 0.045));
		Formato.formato(nombreLabel, 0, (float) (HEIGHT * 0.035));
		this.add(nombreLabel);

		nombreField = new JTextField();
		nombreField.setBounds((int) (nombreLabel.getX() + nombreLabel.getWidth()), (int) (nombreLabel.getY()),
				(int) (WIDTH * 0.25), (int) (HEIGHT * 0.045));
		Formato.formato(nombreField, 0, (float) (HEIGHT * 0.035));
		nombreField.setEditable(false);
		this.add(nombreField);
	}

	private void initDescripcion() {
		descripcionLabel = new JLabel("Descripcion");
		descripcionLabel.setBounds((int) (WIDTH * 0.55), (int) (nombreField.getY()), (int) (WIDTH * 0.15),
				(int) (HEIGHT * 0.045));
		Formato.formato(descripcionLabel, 0, (float) (HEIGHT * 0.035));
		this.add(descripcionLabel);

		descripcionArea = new JTextArea();
		descripcionArea.setBounds((int) (descripcionLabel.getX()),
				(int) (descripcionLabel.getY() + descripcionLabel.getHeight() + HEIGHT * 0.015),
				(int) (WIDTH * 0.95 - descripcionLabel.getX()), (int) (HEIGHT * 0.18));
		Formato.formato(descripcionArea);
		descripcionArea.setFont(descripcionArea.getFont().deriveFont((float) (HEIGHT * 0.035)));
		descripcionArea.setForeground(Color.WHITE);
		descripcionArea.setOpaque(false);
		descripcionArea.setBorder(null);
		descripcionArea.setEditable(false);
		this.add(descripcionArea);
	}

	private void initImagenes() {
		imagenesLabel = new JLabel("Imagenes");
		imagenesLabel.setBounds((int) (descripcionArea.getX()),
				(int) (descripcionArea.getY() + descripcionArea.getHeight() + HEIGHT * 0.015), (int) (WIDTH * 0.15),
				(int) (HEIGHT * 0.045));
		Formato.formato(imagenesLabel, 0, (float) (HEIGHT * 0.035));
		this.add(imagenesLabel);

		listaImgLabel = new JLabel();
		listaImgLabel.setBounds((int) (imagenesLabel.getX()),
				(int) (imagenesLabel.getY() + imagenesLabel.getHeight() + HEIGHT * 0.015),
				(int) (descripcionArea.getWidth()),
				(int) (HEIGHT * 0.85 - imagenesLabel.getY() - imagenesLabel.getHeight()));
		// Centrar horizontalmente
		listaImgLabel.setHorizontalAlignment(JLabel.CENTER);
		listaImgLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		// Centrar verticalmente
		listaImgLabel.setVerticalAlignment(JLabel.CENTER);
		listaImgLabel.setAlignmentY(JLabel.CENTER_ALIGNMENT);
		this.add(listaImgLabel);

		int width = (int) (listaImgLabel.getWidth() * 0.03);
		int height = (int) (1.954 * width);

		CustomButton prevButton = new CustomButton();
		prevButton.setText("<");
		prevButton.setBounds((int) (listaImgLabel.getX()),
				(int) (listaImgLabel.getY() + listaImgLabel.getHeight() * 0.333), width, height);
		Formato.formato(prevButton, 0, (float) (HEIGHT * 0.035));
		prevButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indexImg--;

				if (indexImg < 0)
					indexImg = fotos.size() - 1;

				listaImgLabel
						.setIcon(CargaImagen.chargeImageIcon(RutasArchivos.ESTABLECIMIENTOS + fotos.get(indexImg)));
			}
		});
		this.add(prevButton);

		CustomButton nextButton = new CustomButton();
		nextButton.setBounds((int) (listaImgLabel.getX() + listaImgLabel.getWidth() - width),
				(int) (listaImgLabel.getY() + listaImgLabel.getHeight() * 0.333), width, height);
		nextButton.setText(">");
		Formato.formato(nextButton, 0, (float) (HEIGHT * 0.035));
		nextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indexImg++;

				if (indexImg >= fotos.size())
					indexImg = 0;

				listaImgLabel
						.setIcon(CargaImagen.chargeImageIcon(RutasArchivos.ESTABLECIMIENTOS + fotos.get(indexImg)));
			}
		});
		this.add(nextButton);
	}

	private void initCorreo() {
		correoLabel = new JLabel("<html>Correo<br>electronico</html>");
		correoLabel.setBounds((int) (nombreLabel.getX()),
				(int) (nombreLabel.getY() + 4 * nombreLabel.getHeight() + HEIGHT * 0.15), nombreLabel.getWidth(),
				nombreLabel.getHeight() * 2);
		Formato.formato(correoLabel, 0, (float) (HEIGHT * 0.035));
		this.add(correoLabel);

		correoField = new JTextField();
		correoField.setBounds(nombreField.getX(),
				(int) (nombreField.getY() + 4 * nombreField.getHeight() + HEIGHT * 0.15), nombreField.getWidth(),
				nombreField.getHeight() * 2);
		Formato.formato(correoField, 0, (float) (HEIGHT * 0.035));
		correoField.setEditable(false);
		this.add(correoField);
	}

	private void initCodigo() {
		codigoLabel = new JLabel("Codigo");
		codigoLabel.setBounds((int) (nombreLabel.getX()),
				(int) (nombreLabel.getY() + nombreLabel.getHeight() + HEIGHT * 0.075), nombreLabel.getWidth(),
				nombreLabel.getHeight());
		Formato.formato(codigoLabel, 0, (float) (HEIGHT * 0.035));
		this.add(codigoLabel);

		codigoField = new JTextField();
		codigoField.setBounds((int) (nombreField.getX()),
				(int) (nombreField.getY() + nombreField.getHeight() + HEIGHT * 0.075), nombreField.getWidth(),
				nombreField.getHeight());
		Formato.formato(codigoField, 0, (float) (HEIGHT * 0.035));
		codigoField.setEditable(false);
		this.add(codigoField);

	}

	private void initHorario() {
		horarioLabel = new JLabel("<html>Horario de<br>atencion</html>");
		horarioLabel.setBounds((int) (nombreLabel.getX()),
				(int) (nombreLabel.getY() + nombreLabel.getHeight() + HEIGHT * 0.05), nombreLabel.getWidth(),
				nombreLabel.getHeight() * 2);
		Formato.formato(horarioLabel, 0, (float) (HEIGHT * 0.035));
		this.add(horarioLabel);

		horarioField = new JTextField();
		horarioField.setBounds((int) (nombreField.getX()),
				(int) ((nombreField.getY() + nombreField.getHeight() + HEIGHT * 0.075)), nombreField.getWidth(),
				nombreField.getHeight());
		Formato.formato(horarioField, 0, (float) (HEIGHT * 0.035));
		horarioField.setEditable(false);
		this.add(horarioField);

	}

	private void initCapacidad() {
		capacidadLabel = new JLabel("Capacidad");
		capacidadLabel.setBounds((int) (nombreLabel.getX()),
				(int) (horarioLabel.getY() + horarioLabel.getHeight() + HEIGHT * 0.05), nombreLabel.getWidth(),
				nombreLabel.getHeight());
		Formato.formato(capacidadLabel, 0, (float) (HEIGHT * 0.035));
		this.add(capacidadLabel);

		capacidadField = new JTextField();
		capacidadField.setBounds((int) (nombreField.getX()),
				(int) (horarioLabel.getY() + horarioLabel.getHeight() + HEIGHT * 0.05), nombreField.getWidth(),
				nombreField.getHeight());
		Formato.formato(capacidadField, 0, (float) (HEIGHT * 0.035));
		capacidadField.setEditable(false);
		this.add(capacidadField);

	}

	private void initTelefono() {
		telefonoLabel = new JLabel("Telefono");
		telefonoLabel.setBounds((int) (nombreLabel.getX()),
				(int) (nombreLabel.getY() + 3 * nombreLabel.getHeight() + HEIGHT * 0.1), nombreLabel.getWidth(),
				nombreLabel.getHeight());
		Formato.formato(telefonoLabel, 0, (float) (HEIGHT * 0.035));
		this.add(telefonoLabel);

		telefonoField = new JTextField();
		telefonoField.setBounds((int) (nombreField.getX()),
				(int) (nombreField.getY() + 3 * nombreField.getHeight() + HEIGHT * 0.1), nombreField.getWidth(),
				nombreField.getHeight());
		Formato.formato(telefonoField, 0, (float) (HEIGHT * 0.035));
		telefonoField.setEditable(false);
		this.add(telefonoField);

	}

	private void initData() {
		Object clase = lugar.getClass();
		nombreField.setText(lugar.getNombre());
		descripcionArea.setText(lugar.getDescripcion());
		if (clase.equals(Facultad.class)) {
			Facultad f = (Facultad) lugar;
			codigoField.setText(f.getCodigo());
			telefonoField.setText(f.getTelefonoContacto());
			correoField.setText(f.getCorreoContacto());
		}
		if (clase.equals(Comedor.class)) {
			Comedor c = (Comedor) lugar;
			capacidadField.setText(c.getCapacidad());
			horarioField.setText(c.getHorarioAtencion());
		}
		if (clase.equals(Biblioteca.class)) {
			Biblioteca b = (Biblioteca) lugar;
			telefonoField.setText(b.getTelefono());
			horarioField.setText(b.getHorarioAtencion());
		}

	}

	private void initLista() {
		this.fotos = lugar.getImagenes();
		listaImgLabel.setIcon(CargaImagen.chargeImageIcon(RutasArchivos.ESTABLECIMIENTOS + fotos.get(indexImg)));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
}