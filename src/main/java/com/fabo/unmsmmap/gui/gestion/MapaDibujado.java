package com.fabo.unmsmmap.gui.gestion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JLabel;

import com.fabo.unmsmmap.logica.algoritmos.Dijkstra;
import com.fabo.unmsmmap.logica.entidades.Biblioteca;
import com.fabo.unmsmmap.logica.entidades.Comedor;
import com.fabo.unmsmmap.logica.entidades.Establecimiento;
import com.fabo.unmsmmap.logica.entidades.Facultad;
import com.fabo.unmsmmap.logica.grafo.Edge;
import com.fabo.unmsmmap.utilidades.CaminoComponente;
import com.fabo.unmsmmap.utilidades.ImagePanel;
import com.fabo.unmsmmap.utilidades.LabelWithID;
import com.fabo.unmsmmap.utilidades.ManejadorArchivos;
import com.fabo.unmsmmap.utilidades.RutasArchivos;

public class MapaDibujado {

	private ImagePanel imagePanel;
	private ArrayList<LabelWithID> labelsWithID;
	private ArrayList<JLabel> labels;
	private ArrayList<JLabel> elegidos;
	private ArrayList<Establecimiento> establecimientos;
	private ArrayList<CaminoComponente> caminoPintado;
	private ArrayList<Edge> edges;

	public MapaDibujado() {
		imagePanel = ImagePanel.getInstance(RutasArchivos.PLANO);
		imagePanel.setLayout(null);
		initData();
		initComponentes();
	}

	private void initData() {
		labelsWithID = ManejadorArchivos.getObjectFromJson(RutasArchivos.LABELS_FILE, LabelWithID.class);
		establecimientos = initEstablecimientos();
		labels = new ArrayList<>();
		elegidos = new ArrayList<>();
		caminoPintado = new ArrayList<>();
		edges = ManejadorArchivos.getObjectFromJson(RutasArchivos.EDGES_FILE, Edge.class);
	}

	private ArrayList<Establecimiento> initEstablecimientos() {
		ArrayList<Establecimiento> establecimientos = new ArrayList<>();
		establecimientos.addAll(ManejadorArchivos.getObjectFromJson(RutasArchivos.FACULTADES_FILE, Facultad.class));
		establecimientos.addAll(ManejadorArchivos.getObjectFromJson(RutasArchivos.COMEDORES_FILE, Comedor.class));
		establecimientos.addAll(ManejadorArchivos.getObjectFromJson(RutasArchivos.BIBLIOTECAS_FILE, Biblioteca.class));
		return establecimientos;
	}

	private void initComponentes() {
		drawLabels();
		getCoordenadas();
	}

	private void drawLabels() {
		for (LabelWithID label : labelsWithID) {
			JLabel labelAux = label.paintIcon();
			addClickActions(labelAux);
			imagePanel.add(labelAux);
			labels.add(labelAux);
		}
	}

	private void addClickActions(JLabel label) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!label.isEnabled()) {
					String textEstablecimiento = label.getText();
					establecimientos.stream()
							.filter(establecimiento -> establecimiento.getAlias().equals(textEstablecimiento))
							.forEach(establecimiento -> new VentanaEmergenteDetalles(establecimiento));
					label.setEnabled(true);
					elegidos.remove(label);
					return;
				}

				label.setEnabled(false);
				elegidos.add(label);

				if (elegidos.size() == 2) {
					JLabel label1 = elegidos.get(0);
					JLabel label2 = elegidos.get(1);
					drawSegments(Dijkstra.dijkstra(establecimientos, label1.getText(), label2.getText()));
					label1.setEnabled(true);
					label2.setEnabled(true);
					elegidos.clear();
				}
			}
		});
	}

	private void drawSegments(ArrayList<String> caminos) {
		if (true) {
			for (int i = 0; i < caminoPintado.size(); i++) {
				imagePanel.remove(caminoPintado.get(i));
			}
		}
		caminoPintado.clear();
		for (int i = 0; i < caminos.size() - 1; i++) {
			CaminoComponente c = new CaminoComponente();
			c.setPreferredSize(imagePanel.getSize());
			c.setBounds(0, 0, imagePanel.getSize().width, imagePanel.getSize().height);
			caminoPintado.add(c);
			imagePanel.add(c);
			LinkedList<Integer> coordenadasCamino = extractCoordenadas(caminos.get(i), caminos.get(i + 1));
			c.agregarPunto(coordenadasCamino);
			imagePanel.repaint();
		}
	}

	private LinkedList<Integer> extractCoordenadas(String inicio, String fin) {
		final Edge[] edgeFound = new Edge[1];
		edges.stream().filter(edge -> edge.getOrigen().equals(inicio) && edge.getDestino().equals(fin))
				.forEach(edge -> {
					edgeFound[0] = edge;
					System.out.println(edge.getOrigen() + " " + edge.getDestino() + " " + edge.getDistance());
				});
		String[] coordenadas = edgeFound[0].getCamino().split(",");
		LinkedList<Integer> coordenadasInteger = new LinkedList<>();
		for (String coordenada : coordenadas) {
			coordenadasInteger.add(Integer.parseInt(coordenada));
		}
		return coordenadasInteger;
	}

	private void getCoordenadas() {
		imagePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("X " + (e.getX() - 30));
				System.out.println("Y " + (e.getY() - 50));
			}
		});
	}
}
