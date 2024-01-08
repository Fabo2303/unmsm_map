package com.fabo.unmsmmap.gui.gestion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.fabo.unmsmmap.logica.algoritmos.Bfs;
import com.fabo.unmsmmap.logica.algoritmos.Dfs;
import com.fabo.unmsmmap.logica.algoritmos.Dijkstra;
import com.fabo.unmsmmap.logica.entidades.Establecimiento;
import com.fabo.unmsmmap.logica.grafo.Edge;
import com.fabo.unmsmmap.logica.grafo.Graph;
import com.fabo.unmsmmap.logica.grafo.Vertex;
import com.fabo.unmsmmap.utilidades.Boton;
import com.fabo.unmsmmap.utilidades.CaminoComponente;
import com.fabo.unmsmmap.utilidades.CargaImagen;
import com.fabo.unmsmmap.utilidades.Formato;

public class MapaDibujado {
	private JPanel panelFondo;
	private JFrame ventana;
	private JLabel imagenFondo;
	private ArrayList<JLabel> labels;
	private ArrayList<CaminoComponente> caminoPintado;
	private ArrayList<Vertex<Establecimiento>> vertices;
	private CaminoComponente caminoComponente;
	private Boton bfsBtn, dfsBtn;
	private int indicador = 0;
	private List<JLabel> clickeados = new ArrayList<>();
	private int contadorClics = 0;
	private Dijkstra<Establecimiento> algoritmo;
	private Graph<Establecimiento> grafo = new Graph<>();
	private Formato formato = new Formato();
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;

	private ArrayList<JLabel> arregloLabelVacio = new ArrayList<>();
	
	private int i = 0;
	private Timer time;
	private Map<JLabel, Vertex<Establecimiento>> union;
	private Map<Vertex<Establecimiento>, JLabel> desunion;
	private Map<JLabel, JLabel> relacionVacioNormal;
	private Bfs<Establecimiento> algoritmoBfs = new Bfs<>();
	private Dfs<Establecimiento> algoritmoDfs = new Dfs<>();

	public MapaDibujado(JFrame ventana, ArrayList<Vertex<Establecimiento>> grafo) {
		this.vertices = grafo;
		this.grafo.setGraph(vertices);
		caminoComponente = new CaminoComponente();
		this.algoritmo = new Dijkstra<>();
		this.panelFondo = new JPanel();
		this.caminoPintado = new ArrayList<>();
		this.labels = new ArrayList<>();
		this.ventana = ventana;
		this.union = new HashMap<>();
		this.desunion = new HashMap<>();
		initFondo();
		initComponentes();
		ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
	}

	private void initFondo() {
		ventana.setSize(WIDTH, HEIGHT);
		ventana.setLocationRelativeTo(null);
		panelFondo.setLayout(null);
		ventana.getContentPane().add(panelFondo);
	}

	private void coordenadas() {
		MouseListener mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("X " + (e.getX() - 30));
				System.out.println("Y " + (e.getY() - 50));
			}
		};
		panelFondo.addMouseListener(mouse);
	}

	private void anyadirMouse() {
		MouseListener mouseListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				System.out.println(e.getSource());

				if (!label.isEnabled()) {
					mostrarDatos(label);
					contadorClics = 0;
					label.setEnabled(true);
					clickeados.remove(label);
					return;
				}

				label.setEnabled(false);
				contadorClics++;
				clickeados.add(label);

				if (contadorClics == 2) {
					if (clickeados.size() == 2) {

						System.out.println(algoritmo.caminoCorto(grafo, identificar(clickeados.get(0)),
								identificar(clickeados.get(1))));
						dibujarLinea(algoritmo.obtenerCamino(grafo, identificar(clickeados.get(0)),
								identificar(clickeados.get(1))));
					}

					contadorClics = 0;
					for (JLabel l : labels) {
						l.setEnabled(true);
					}
					clickeados.clear();
				}
			}
		};

		for (int i = 0; i < labels.size(); i++) {
			labels.get(i).addMouseListener(mouseListener);
		}
	}

	private Vertex<Establecimiento> identificar(JLabel a) {
		for (Vertex<Establecimiento> i : vertices) {
			if (i.getDato().getLabel().equals(a)) {
				System.out.println(i.getDato().getNombre());
				return i;
			}
		}
		return null;
	}

	private void pintarLabels() {
		relacionVacioNormal = new HashMap<>();
		int cont = 0;
		for (JLabel i : labels) {
			JLabel labelVacio = new JLabel();
			labelVacio.setBounds(i.getX(),i.getY(), i.getWidth(), i.getHeight());
			CargaImagen.setImagen(labelVacio, "logovacio.png", 0);
			panelFondo.add(i);
			i.setLayout(null);
			arregloLabelVacio.add(labelVacio);
			relacionVacioNormal.put(i,arregloLabelVacio.get(cont));
			cont++;
		}
	}

	private LinkedList<Integer> extraerCamino(Vertex<Establecimiento> v1, Vertex<Establecimiento> v2) {
		ArrayList<Edge<Establecimiento>> arista = v1.getEdges();
		for (int i = 0; i < arista.size(); i++) {
			if (arista.get(i).getFinal().equals(v2)) {
				return arista.get(i).getCamino();
			}
		}
		return null;
	}

	private void dibujarLinea(List<Vertex<Establecimiento>> a) {
		if (indicador == 1) {
			for (int i = 0; i < caminoPintado.size(); i++) {
				panelFondo.remove(caminoPintado.get(i));
			}
			indicador = 0;
		}
		caminoPintado.clear();
		for (Vertex<Establecimiento> i : a) {
			System.out.println(i.getDato().getNombre());
		}
		for (int i = 0; i < a.size() - 1; i++) {
			CaminoComponente b = new CaminoComponente();
			b.setPreferredSize(ventana.getSize());
			b.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
			caminoPintado.add(b);
			panelFondo.add(b);
			LinkedList<Integer> camino = new LinkedList<>(extraerCamino(a.get(i), a.get(i + 1)));
			b.agregarPunto(camino);
			ventana.repaint();
			panelFondo.repaint();
		}

		for (int i = 0; i < caminoPintado.size(); i++) {
			panelFondo.add(caminoPintado.get(i));
			ventana.repaint();
			panelFondo.repaint();
		}

		panelFondo.repaint();
		panelFondo.remove(imagenFondo);
		imagenFondo();
		indicador++;
	}

	private void inicializarEstablecimientos() {
		for (Vertex<Establecimiento> v : vertices) {
			labels.add(v.getDato().getLabel());
			System.out.println(v.getDato().getNombre());
		}
	}

	private void mostrarDatos(JLabel label) {
		Vertex<Establecimiento> vertice = identificar(label);
		VentanaEmergenteDetalles detalles = new VentanaEmergenteDetalles(vertice.getDato());
	}

	public void empezarAnimacion(List<Vertex<Establecimiento>> result) {
		
		for (int i = 0; i < caminoPintado.size(); i++) {
			panelFondo.remove(caminoPintado.get(i));
		}
		panelFondo.remove(imagenFondo);
		imagenFondo();
		panelFondo.repaint();
		
		i = 0;
		time = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (i < result.size()) {
					panelFondo.remove(relacionVacioNormal.get(desunion.get(result.get(i))));
					panelFondo.remove(imagenFondo);
					imagenFondo();
				}
				i++;
				if (i == result.size() + 2) 
					time.stop();
				
				contadorClics=0;
				clickeados = new ArrayList<>();
				ventana.repaint();
				panelFondo.repaint();
			}
		});

		time.start();
	}
	
	public void asociarVertexLabel() {
		for(Vertex<Establecimiento> v: vertices) {
			union.put(v.getDato().getLabel(),v);
		}
	}
	
	public void asociarLabelVertex() {
		for(Vertex<Establecimiento> v: vertices) {
			desunion.put(v,v.getDato().getLabel());
		}
	}

	public void initBotones() {
		bfsBtn = new Boton();
		bfsBtn.setText("RECORRIDO BFS");
		bfsBtn.setBounds((int)(WIDTH*0.7),(int)(HEIGHT*0.7),(int)(WIDTH*0.25), (int)(HEIGHT*0.065));
		formato.formato(bfsBtn, 0, (float)(HEIGHT*0.035), 50, 0);
		MouseAdapter accionBfs = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel accionador = new JLabel();
				accionador = devolverLabelDisable();
				boolean start = false;
				if(accionador!=null)
					start=true;
				
				if(start) {
					pintarLabelVacios();
					List<Vertex<Establecimiento>> result = algoritmoBfs.bfs(union.get(accionador), grafo);
					empezarAnimacion(result);
				}
				
			}
		};
		bfsBtn.addMouseListener(accionBfs);
		panelFondo.add(bfsBtn);
		
		dfsBtn = new Boton();
		dfsBtn.setText("RECORRDIO DFS");
		dfsBtn.setBounds(bfsBtn.getX(),(int)(bfsBtn.getY()+bfsBtn.getHeight()+HEIGHT*0.05),(int)(WIDTH*0.25), (int)(HEIGHT*0.065));
		formato.formato(dfsBtn, 0, (float)(HEIGHT*0.035), 50, 0);
		MouseAdapter accionDfs = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel accionador = new JLabel();
				accionador = devolverLabelDisable();
				boolean start = false;
				if(accionador!=null)
					start=true;
				
				if(start) {
					pintarLabelVacios();
					algoritmoDfs.dfs(union.get(accionador), grafo);
					List<Vertex<Establecimiento>> result = algoritmoDfs.getSalida();
					empezarAnimacion(result);
					accionador.setEnabled(true);
				}
				
			}
		};
		dfsBtn.addMouseListener(accionDfs);
		panelFondo.add(dfsBtn);
	}
	
	
	public void pintarLabelVacios() {
		int cont = 0;
		for(JLabel i: arregloLabelVacio) {
			panelFondo.remove(labels.get(cont));
			panelFondo.add(i);
			panelFondo.add(labels.get(cont));
			cont++;
		}
		panelFondo.remove(imagenFondo);
		imagenFondo();
		panelFondo.repaint();
	}
	
	
	public JLabel devolverLabelDisable() {
		for(JLabel l:labels) {
			if(!l.isEnabled()) {
				l.setEnabled(true);
				return l;
			}
		}
		return null;
	}

	private void initComponentes() {
		initBotones();
		inicializarEstablecimientos();
		anyadirMouse();
		pintarLabels();
		asociarLabelVertex();
		asociarVertexLabel();
		imagenFondo();
	}

	private void imagenFondo() {
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, WIDTH - 15, HEIGHT - 40);
		CargaImagen.setImagen(imagenFondo, "planoHor2.png");
		panelFondo.add(imagenFondo);
	}
}
