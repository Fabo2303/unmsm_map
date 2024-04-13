package com.fabo.unmsmmap.gui.agregar;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.fabo.unmsmmap.logica.entidades.Biblioteca;
import com.fabo.unmsmmap.logica.entidades.Comedor;
import com.fabo.unmsmmap.logica.entidades.Establecimiento;
import com.fabo.unmsmmap.logica.entidades.Facultad;
import com.fabo.unmsmmap.utilidades.LabelWithID;
import com.fabo.unmsmmap.utilidades.ManejadorArchivos;
import com.fabo.unmsmmap.utilidades.RutasArchivos;

public class PantallaEmergenteCrearEdges extends JPanel {

	private int typeClick = 0;
	private BufferedImage image;
	private JFrame ventana;
	private ArrayList<LabelWithID> labelsWithID;
	private ArrayList<JLabel> labels;
	private ArrayList<Establecimiento> establecimientos;
	private Establecimiento origen;
	private LabelWithID labelOrigen;
	private Establecimiento destino;

	public PantallaEmergenteCrearEdges(Establecimiento origen) {
		try {
			image = ImageIO.read(new File(RutasArchivos.PLANO));
		} catch (Exception e) {
			System.out.println("Tu imagen no existe.");
		}
		this.origen = origen;
		setLayout(null);
		initVentana();
		initData();
		initComponentes();
	}

	private void initData() {
		labelsWithID = ManejadorArchivos.getObjectFromJson(RutasArchivos.LABELS_FILE, LabelWithID.class);
		labels = new ArrayList<>();
		establecimientos = initEstablecimientos();
	}

	private ArrayList<Establecimiento> initEstablecimientos() {
		ArrayList<Establecimiento> establecimientos = new ArrayList<>();
		establecimientos
				.addAll(ManejadorArchivos.getObjectFromJson(RutasArchivos.FACULTADES_FILE, Facultad.class));
		establecimientos
				.addAll(ManejadorArchivos.getObjectFromJson(RutasArchivos.COMEDORES_FILE, Comedor.class));
		establecimientos
				.addAll(ManejadorArchivos.getObjectFromJson(RutasArchivos.BIBLIOTECAS_FILE, Biblioteca.class));
		return establecimientos;
	}

	private void initComponentes() {
		drawLabels();
		inicializarLabelOrigen();
	}

	private void drawLabels() {
		for (LabelWithID labelWithID : labelsWithID) {
			JLabel label = labelWithID.paintIcon();
			// addClickActions(label);
			add(label);
			labels.add(label);
		}
	}

	private void inicializarLabelOrigen() {

	}

	private void initVentana() {
		ventana = new JFrame();
		ventana.setTitle("Asignar rutas");
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setSize(1280, 720);
		ventana.setLocationRelativeTo(null);
		confirmacionCerrar();
		ventana.setContentPane(this);
		ventana.setVisible(true);
	}

	private void confirmacionCerrar() {
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				System.out.println("Cerrando ventana");
			}
		});
	}

	public void handlerPanelClick(int x, int y) {
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if (typeClick == 0) {
					labelOrigen = new LabelWithID(origen.getAlias(), origen.getLogo(), x, y);
					typeClick = 1;
				}
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
}