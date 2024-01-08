package com.fabo.unmsmmap.gui.gestion;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import com.fabo.unmsmmap.utilidades.Formato;

public class VentanaEmergenteDetalles {

	private JFrame ventana;
	private JPanel panelFondo;
	private JLabel imagenFondo, titulo1Label, titulo2Label;
	private JLabel nombreLabel, descripcionLabel, imagenesLabel, listaImgLabel, nextButton, prevButton;
	private JLabel codigoLabel, horarioLabel, capacidadLabel, correoLabel, telefonoLabel;
	private JTextField nombreField;
	private JTextArea descripcionArea;
	private JTextField codigoField, horarioField, capacidadField, correoField, telefonoField;
	private Establecimiento lugar;
	private Formato formato;
	private ArrayList<ImageIcon> fotos;
	private int indexImg = 0;
	private final int WIDTH = 1200;
	private final int HEIGHT = 675;

	public VentanaEmergenteDetalles(Establecimiento lugar) {
		this.lugar = lugar;
		this.panelFondo = new JPanel();
		this.ventana = new JFrame();
		this.formato = new Formato();
		configVentana();
		initFondo();
		initComponentes();
		ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
	}

	private void configVentana() {
		ventana.setSize(WIDTH, HEIGHT);
		ventana.setTitle("ED-G5-UNMSM");
		ventana.setLocationRelativeTo(null); // Aparece al medio la ventana
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
		panelFondo.setLayout(null);
		ventana.getContentPane().add(panelFondo);
	}

	private void initComponentes() {
		System.out.println(lugar.getClass().equals(Facultad.class));
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
		imagenFondo();
	}

	private void initDesign() {

		JLabel iconoLabel = new JLabel();
		iconoLabel.setBounds((int) (WIDTH * 0.87), (int) (HEIGHT * 0), (int) (WIDTH * 0.1), (int) (HEIGHT * 0.18));
		CargaImagen.setImagen(iconoLabel, "logo.png");
		panelFondo.add(iconoLabel);

		JLabel lineaHorizontal = new JLabel();
		lineaHorizontal.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
		lineaHorizontal.setBounds((int) (WIDTH * 0.05), titulo2Label.getY(),
				(int) (titulo2Label.getX() - WIDTH * 0.075), 1);
		panelFondo.add(lineaHorizontal);

		JLabel lineaHorizontal2 = new JLabel();
		lineaHorizontal2.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
		lineaHorizontal2.setBounds((int) (titulo2Label.getX() + titulo2Label.getWidth() + WIDTH * 0.02),
				titulo2Label.getY(), (int) (iconoLabel.getX() - titulo2Label.getX() - WIDTH * 0.25), 1);
		panelFondo.add(lineaHorizontal2);
	}

	private void initTitulo() {
		titulo1Label = new JLabel("Informacion de");
		titulo1Label.setBounds((int) (WIDTH * (0.39)), (int) (HEIGHT * 0.05), (int) (WIDTH * 0.22),
				(int) (HEIGHT * 0.045));
		formato.formato(titulo1Label, 1, (float) (HEIGHT * 0.045));
		panelFondo.add(titulo1Label);

		titulo2Label = new JLabel("Establecimiento");
		titulo2Label.setBounds((int) (WIDTH * (0.3865)), (int) (HEIGHT * 0.095), (int) (WIDTH * 0.235),
				(int) (HEIGHT * 0.045));
		formato.formato(titulo2Label, 1, (float) (HEIGHT * 0.045));
		panelFondo.add(titulo2Label);
	}

	private void initNombre() {
		nombreLabel = new JLabel("Nombre");
		nombreLabel.setBounds((int) (WIDTH * 0.05), (int) (titulo2Label.getY() + HEIGHT * 0.15), (int) (WIDTH * 0.15),
				(int) (HEIGHT * 0.045));
		formato.formato(nombreLabel, 0, (float) (HEIGHT * 0.035));
		panelFondo.add(nombreLabel);

		nombreField = new JTextField();
		nombreField.setBounds((int) (nombreLabel.getX() + nombreLabel.getWidth()), (int) (nombreLabel.getY()),
				(int) (WIDTH * 0.25), (int) (HEIGHT * 0.045));
		formato.formato(nombreField, 0, (float) (HEIGHT * 0.035));
		nombreField.setEditable(false);
		panelFondo.add(nombreField);
	}

	private void initDescripcion() {
		descripcionLabel = new JLabel("Descripcion");
		descripcionLabel.setBounds((int) (WIDTH * 0.55), (int) (nombreField.getY()), (int) (WIDTH * 0.15),
				(int) (HEIGHT * 0.045));
		formato.formato(descripcionLabel, 0, (float) (HEIGHT * 0.035));
		panelFondo.add(descripcionLabel);

		descripcionArea = new JTextArea();
		descripcionArea.setBounds((int) (descripcionLabel.getX()),
				(int) (descripcionLabel.getY() + descripcionLabel.getHeight() + HEIGHT * 0.015),
				(int) (WIDTH * 0.95 - descripcionLabel.getX()), (int) (HEIGHT * 0.18));
		formato.formato(descripcionArea);
		descripcionArea.setFont(descripcionArea.getFont().deriveFont((float) (HEIGHT * 0.035)));
		descripcionArea.setForeground(Color.WHITE);
		descripcionArea.setOpaque(false);
		descripcionArea.setBorder(null);
		descripcionArea.setEditable(false);
		panelFondo.add(descripcionArea);
	}

	private void initImagenes() {
		imagenesLabel = new JLabel("Imagenes");
		imagenesLabel.setBounds((int) (descripcionArea.getX()),
				(int) (descripcionArea.getY() + descripcionArea.getHeight() + HEIGHT * 0.015), (int) (WIDTH * 0.15),
				(int) (HEIGHT * 0.045));
		formato.formato(imagenesLabel, 0, (float) (HEIGHT * 0.035));
		panelFondo.add(imagenesLabel);

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
		panelFondo.add(listaImgLabel);

		int width = (int) (listaImgLabel.getWidth() * 0.03);
		int height = (int) (1.954 * width);

		prevButton = new JLabel();
		prevButton.setBounds((int) (listaImgLabel.getX()),
				(int) (listaImgLabel.getY() + listaImgLabel.getHeight() * 0.333), width, height);
		CargaImagen.setImagen(prevButton, "prevImgButton.png");
		panelFondo.add(prevButton);

		MouseAdapter prev = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indexImg--;

				if (indexImg < 0)
					indexImg = fotos.size() - 1;

				listaImgLabel.setIcon(fotos.get(indexImg));
			}
		};

		prevButton.addMouseListener(prev);

		nextButton = new JLabel();
		nextButton.setBounds((int) (listaImgLabel.getX() + listaImgLabel.getWidth() - width),
				(int) (listaImgLabel.getY() + listaImgLabel.getHeight() * 0.333), width, height);
		CargaImagen.setImagen(nextButton, "nextImgButton.png");
		panelFondo.add(nextButton);

		MouseAdapter next = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indexImg++;

				if (indexImg >= fotos.size())
					indexImg = 0;

				listaImgLabel.setIcon(fotos.get(indexImg));
			}
		};

		nextButton.addMouseListener(next);
	}

	private void initCorreo() {
		correoLabel = new JLabel("<html>Correo<br>electronico</html>");
		correoLabel.setBounds((int) (nombreLabel.getX()),
				(int) (nombreLabel.getY() + 4 * nombreLabel.getHeight() + HEIGHT * 0.15), nombreLabel.getWidth(),
				nombreLabel.getHeight() * 2);
		formato.formato(correoLabel, 0, (float) (HEIGHT * 0.035));
		panelFondo.add(correoLabel);

		correoField = new JTextField();
		correoField.setBounds(nombreField.getX(),
				(int) (nombreField.getY() + 4 * nombreField.getHeight() + HEIGHT * 0.15), nombreField.getWidth(),
				nombreField.getHeight() * 2);
		formato.formato(correoField, 0, (float) (HEIGHT * 0.035));
		correoField.setEditable(false);
		panelFondo.add(correoField);
	}

	private void initCodigo() {
		codigoLabel = new JLabel("Codigo");
		codigoLabel.setBounds((int) (nombreLabel.getX()),
				(int) (nombreLabel.getY() + nombreLabel.getHeight() + HEIGHT * 0.075), nombreLabel.getWidth(),
				nombreLabel.getHeight());
		formato.formato(codigoLabel, 0, (float) (HEIGHT * 0.035));
		panelFondo.add(codigoLabel);

		codigoField = new JTextField();
		codigoField.setBounds((int) (nombreField.getX()),
				(int) (nombreField.getY() + nombreField.getHeight() + HEIGHT * 0.075), nombreField.getWidth(),
				nombreField.getHeight());
		formato.formato(codigoField, 0, (float) (HEIGHT * 0.035));
		codigoField.setEditable(false);
		panelFondo.add(codigoField);

	}

	private void initHorario() {
		horarioLabel = new JLabel("<html>Horario de<br>atencion</html>");
		horarioLabel.setBounds((int) (nombreLabel.getX()),
				(int) (nombreLabel.getY() + nombreLabel.getHeight() + HEIGHT * 0.05), nombreLabel.getWidth(),
				nombreLabel.getHeight() * 2);
		formato.formato(horarioLabel, 0, (float) (HEIGHT * 0.035));
		panelFondo.add(horarioLabel);

		horarioField = new JTextField();
		horarioField.setBounds((int) (nombreField.getX()),
				(int) ((nombreField.getY() + nombreField.getHeight() + HEIGHT * 0.075)), nombreField.getWidth(),
				nombreField.getHeight());
		formato.formato(horarioField, 0, (float) (HEIGHT * 0.035));
		horarioField.setEditable(false);
		panelFondo.add(horarioField);

	}

	private void initCapacidad() {
		capacidadLabel = new JLabel("Capacidad");
		capacidadLabel.setBounds((int) (nombreLabel.getX()),
				(int) (horarioLabel.getY() + horarioLabel.getHeight() + HEIGHT * 0.05), nombreLabel.getWidth(),
				nombreLabel.getHeight());
		formato.formato(capacidadLabel, 0, (float) (HEIGHT * 0.035));
		panelFondo.add(capacidadLabel);

		capacidadField = new JTextField();
		capacidadField.setBounds((int) (nombreField.getX()),
				(int) (horarioLabel.getY() + horarioLabel.getHeight() + HEIGHT * 0.05), nombreField.getWidth(),
				nombreField.getHeight());
		formato.formato(capacidadField, 0, (float) (HEIGHT * 0.035));
		capacidadField.setEditable(false);
		panelFondo.add(capacidadField);

	}

	private void initTelefono() {
		telefonoLabel = new JLabel("Telefono");
		telefonoLabel.setBounds((int) (nombreLabel.getX()),
				(int) (nombreLabel.getY() + 3 * nombreLabel.getHeight() + HEIGHT * 0.1), nombreLabel.getWidth(),
				nombreLabel.getHeight());
		formato.formato(telefonoLabel, 0, (float) (HEIGHT * 0.035));
		panelFondo.add(telefonoLabel);

		telefonoField = new JTextField();
		telefonoField.setBounds((int) (nombreField.getX()),
				(int) (nombreField.getY() + 3 * nombreField.getHeight() + HEIGHT * 0.1), nombreField.getWidth(),
				nombreField.getHeight());
		formato.formato(telefonoField, 0, (float) (HEIGHT * 0.035));
		telefonoField.setEditable(false);
		panelFondo.add(telefonoField);

	}

	private void initData() {
		Object clase = lugar.getClass();
		nombreField.setText(lugar.getNombre());
		descripcionArea.setText(lugar.getDescripcion());
		if (clase.equals(Facultad.class)) {
			Facultad f = (Facultad)lugar;
			codigoField.setText(f.getCodigo());
			telefonoField.setText(f.getTelContacto());
			correoField.setText(f.getCorElec());
		}
		if (clase.equals(Comedor.class)) {
			Comedor c = (Comedor)lugar;
			capacidadField.setText(c.getCapacidad());
			horarioField.setText(c.getHorarioAtencion());
		}
		if (clase.equals(Biblioteca.class)) {
			Biblioteca b = (Biblioteca)lugar;
			telefonoField.setText(b.getTelefono());
			horarioField.setText(b.getHorarioAtencion());
		}

	}

	private void initLista() {
		this.fotos = lugar.getImagenes();
		reescalarImagenes(fotos, listaImgLabel);
		listaImgLabel.setIcon(fotos.get(indexImg));
	}

	private void reescalarImagenes(ArrayList<ImageIcon> fotos, JLabel listaImgLabel) {

		ArrayList<ImageIcon> copia = new ArrayList<>();

		for (ImageIcon img : fotos) {
			if (img.getIconHeight() > listaImgLabel.getHeight())
				img = new ImageIcon(img.getImage().getScaledInstance(
						img.getIconWidth() * listaImgLabel.getHeight() / img.getIconHeight(), listaImgLabel.getHeight(),
						Image.SCALE_SMOOTH));
			if (img.getIconWidth() > listaImgLabel.getWidth())
				img = new ImageIcon(img.getImage().getScaledInstance(listaImgLabel.getWidth(),
						img.getIconWidth() * listaImgLabel.getWidth() / img.getIconHeight(), Image.SCALE_SMOOTH));
			copia.add(img);
		}

		fotos.clear();

		for (ImageIcon img : copia)
			fotos.add(img);

	}

	private void imagenFondo() {
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, WIDTH, HEIGHT);
		CargaImagen.setImagen(imagenFondo, "fondo.png");
		panelFondo.add(imagenFondo);
	}
}