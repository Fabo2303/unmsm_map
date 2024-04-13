package com.fabo.unmsmmap.gui.agregar;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.fabo.unmsmmap.logica.entidades.Biblioteca;
import com.fabo.unmsmmap.logica.entidades.Comedor;
import com.fabo.unmsmmap.logica.entidades.Establecimiento;
import com.fabo.unmsmmap.logica.entidades.Facultad;
import com.fabo.unmsmmap.logica.grafo.Edge;
import com.fabo.unmsmmap.utilidades.CaminoComponente;
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
	private LinkedList<Integer> edges;
	private ArrayList<CaminoComponente> caminoPintado;

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
		edges = new LinkedList<>();
		caminoPintado = new ArrayList<>();
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
			addClickActions(label);
			add(label);
			labels.add(label);
		}
	}

	private void addClickActions(JLabel label) {
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (typeClick == 1) {
					destino = establecimientos.get(labels.indexOf(label));
					edges.add(label.getX());
					edges.add(label.getY());
					saveEdge();
					typeClick = 0;
				}
			}
		});
	}

	private void saveEdge(){
		ArrayList<Edge> edges = ManejadorArchivos.getObjectFromJson(RutasArchivos.EDGES_FILE, Edge.class);
		edges.add(new Edge(origen.getAlias(), destino.getAlias(), getEdgesToString(), getDistance()));
		ManejadorArchivos.saveObjectToJson(edges, RutasArchivos.EDGES_FILE);
		this.edges.clear();
	}

	private float getDistance() {
		float distance = 0;
		for (int i = 0; i < edges.size(); i += 2) {
			distance += Math.sqrt(Math.pow(edges.get(i) - edges.get(i + 2), 2) + Math.pow(edges.get(i + 1) - edges.get(i + 3), 2));
		}
		return distance;
	}

	private String getEdgesToString(){
		String edgeString = "";
		for (int i = 0; i < edges.size(); i ++) {
			if (edges.size() - 1 == i) {
				edgeString += edges.get(i);
				break;
			}
			edgeString += edges.get(i) + ",";
		}
		return edgeString;
	}

	private void inicializarLabelOrigen() {
		handlerPanelClick();
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

	private void handlerPanelClick() {
		JPanel panel = this;
		panel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (typeClick == 0) {
					labelOrigen = new LabelWithID(origen.getAlias(), origen.getLogo(), e.getX(), e.getY());
					JLabel label = labelOrigen.paintIcon();
					panel.add(label);
					labels.add(label);
					edges.add(e.getX());
					edges.add(e.getY());
					typeClick = 1;
				}
				if (typeClick == 1) {
					edges.add(e.getX());
					edges.add(e.getY());
					drawSegments();
				}
				panel.repaint();
				panel.revalidate();

			}
		});
	}

	private void drawSegments() {
		if (true) {
			for (int i = 0; i < caminoPintado.size(); i++) {
				remove(caminoPintado.get(i));
			}
		}
		caminoPintado.clear();
		for (int i = 0; i < edges.size(); i += 2) {
			CaminoComponente c = new CaminoComponente();
			c.setPreferredSize(getSize());
			c.setBounds(0, 0, getSize().width, getSize().height);
			caminoPintado.add(c);
			c.agregarPunto(edges.get(i), edges.get(i + 1));
			repaint();
			revalidate();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
}