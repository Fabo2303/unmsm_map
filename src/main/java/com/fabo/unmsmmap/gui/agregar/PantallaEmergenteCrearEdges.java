package com.fabo.unmsmmap.gui.agregar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.fabo.unmsmmap.logica.entidades.Establecimiento;
import com.fabo.unmsmmap.logica.grafo.Edge;
import com.fabo.unmsmmap.logica.grafo.Vertex;
import com.fabo.unmsmmap.utilidades.CaminoComponente;
import com.fabo.unmsmmap.utilidades.CargaImagen;

public class PantallaEmergenteCrearEdges {
	private JPanel panelFondo;
	private JFrame ventana, aux;
	private JLabel imagenFondo;
	private Vertex<Establecimiento> origen;
	private Vertex<Establecimiento> llegada;
	private ArrayList<JLabel> labels;
	private ArrayList<Vertex<Establecimiento>> grafo;
	private LinkedList<Integer> coordenadas;
	private int contadorClics = 0;
	private int xInicial, yInicial;
	private float distancia = 0;
	private CaminoComponente caminoComponente = new CaminoComponente();
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;

	public PantallaEmergenteCrearEdges(ArrayList<Vertex<Establecimiento>> grafo, Vertex<Establecimiento> origen,
			JFrame aux) {
		this.origen = origen;
		this.aux = aux;
		this.coordenadas = new LinkedList<>();
		this.panelFondo = new JPanel();
		this.labels = new ArrayList<>();
		this.grafo = grafo;
		this.ventana = new JFrame();
		configVentana();
		initFondo();
		initComponentes();
		JOptionPane.showMessageDialog(null, "Seleccione el punto donde ingresará el nuevo establecimiento", "Ingreso", JOptionPane.INFORMATION_MESSAGE);
		ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
	}

	// SE ALMACENAN EN UN EDGE
	// SE GUARDAN LOS EDGES EN UN ARCHIVO DE EDGES

	private void configVentana() {
		ventana.setSize(WIDTH, HEIGHT);
		ventana.setTitle("ED-G5-UNMSM");
		ventana.setLocationRelativeTo(null); // Aparece al medio la ventana
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
					if(origen.getDato().getLabel().getX()!=0 && origen.getDato().getLabel().getY()!=0) {
						contadorClics=3;
						grafo.add(origen);
						ventana.setVisible(false);
						aux.setVisible(true);
					} else
						JOptionPane.showMessageDialog(panelFondo, "Debe seleccionar la posicion del nuevo establecimiento",
								"Ingreso", JOptionPane.WARNING_MESSAGE);

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

	// MOUSELESTENER GET X GET Y
	private void anyadirMouse() {
		MouseListener mouseListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JLabel label = (JLabel) e.getSource();
				obetenerVertex(label);
				contadorClics++;

				if (contadorClics == 2) {
					caminoComponente.agregarPunto(label.getX() + label.getWidth() / 2,
							label.getY() + label.getHeight());
					calcularDistancia(label.getX() + label.getWidth() / 2, label.getY() + label.getHeight());
					coordenadas.offer(label.getX() + label.getWidth() / 2);
					coordenadas.offer(label.getY() + label.getHeight());
					LinkedList<Integer> caminoCopia = new LinkedList<>(coordenadas);
					// ALMACENAR CAMINO EL EL ARCHIVO DE
					Edge<Establecimiento> arista1 = new Edge<>(llegada, distancia, caminoCopia);

					origen.addEdge(arista1);

					Edge<Establecimiento> arista2 = new Edge<>(origen, distancia, caminoCopia);

					llegada.addEdge(arista2);

					int option = JOptionPane.showConfirmDialog(panelFondo, "¿Desea añadir otro camino?", "Añadir camino",
							JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						reiniciarCamino();
					} else {
						grafo.add(origen);
						ventana.setVisible(false);
						aux.setVisible(true);

					}

				}
			}
		};

		for (int i = 0; i < labels.size(); i++) {
			labels.get(i).addMouseListener(mouseListener);
		}
	}

	private void reiniciarCamino() {
		distancia = 0;
		contadorClics = 1;
		coordenadas = new LinkedList<Integer>();
		coordenadas.add(origen.getDato().getLabel().getX() + origen.getDato().getLabel().getWidth() / 2);
		coordenadas.add(origen.getDato().getLabel().getY() + origen.getDato().getLabel().getHeight());
		xInicial = origen.getDato().getLabel().getX() + origen.getDato().getLabel().getWidth() / 2;
		yInicial = origen.getDato().getLabel().getY() + origen.getDato().getLabel().getHeight();
		panelFondo.remove(caminoComponente);
		caminoComponente = new CaminoComponente();
		caminito();
		panelFondo.remove(imagenFondo);
		imagenFondo();
		caminoComponente.agregarPunto(origen.getDato().getLabel().getX() + origen.getDato().getLabel().getWidth() / 2,
				origen.getDato().getLabel().getY() + origen.getDato().getLabel().getHeight());
		ventana.repaint();
		panelFondo.repaint();
	}

	protected void obetenerVertex(JLabel label) {
		for (Vertex<Establecimiento> v : grafo) {
			if (v.getDato().getLabel().equals(label)) {
				llegada = v;
				break;
			}
		}
	}

	private void inicializarEstablecimientos() {
		for (Vertex<Establecimiento> v : grafo) {
			labels.add(v.getDato().getLabel());
		}
	}

	private void pintarLabels() {
		for (JLabel i : labels) {
			panelFondo.add(i);
			i.setLayout(null);
		}
	}

	public void caminito() {
		caminoComponente.setPreferredSize(ventana.getSize());
		caminoComponente.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
		panelFondo.add(caminoComponente);

		// Agregar puntos al camino al hacer clic en el panel
		caminoComponente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(contadorClics==0) {
					if(JOptionPane.showConfirmDialog(null, "Confirma esta ubicacion?", "Ingreso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE)==JOptionPane.YES_OPTION) {
						origen.getDato().getLabel().setBounds(e.getX()-25, e.getY()-50, 50, 50);
						coordenadas.offer(e.getX());
						coordenadas.offer(e.getY());
						xInicial = e.getX();
						yInicial = e.getY();
						panelFondo.remove(imagenFondo);
						panelFondo.add(origen.getDato().getLabel());
						imagenFondo();
						caminoComponente.agregarPunto(e.getX(), e.getY());
						JOptionPane.showMessageDialog(null, "Ingrese caminos asociados al establecimiento", "Ingreso", JOptionPane.INFORMATION_MESSAGE);
						contadorClics++;
					}
				}else {
					calcularDistancia(e.getX(), e.getY());
					coordenadas.offer(e.getX());
					coordenadas.offer(e.getY());
					caminoComponente.agregarPunto(e.getX(), e.getY());
				}
			}
		});

	}

	public void calcularDistancia(int x, int y) {
		distancia += (float) Math.sqrt(Math.pow(x - xInicial, 2) + Math.pow(y - yInicial, 2))-100;
		xInicial = x;
		yInicial = y;
	}

	private void initComponentes() {
		inicializarEstablecimientos();
		anyadirMouse();
		pintarLabels();
		caminito();
		imagenFondo();
	}

	private void imagenFondo() {
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, WIDTH, HEIGHT);
		CargaImagen.setImagen(imagenFondo, "planoHor2.png");
		panelFondo.add(imagenFondo);
	}
}