package com.fabo.unmsmmap.gui.gestion;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.fabo.unmsmmap.logica.entidades.Biblioteca;
import com.fabo.unmsmmap.logica.entidades.Comedor;
import com.fabo.unmsmmap.logica.entidades.Establecimiento;
import com.fabo.unmsmmap.logica.entidades.Facultad;
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

	public MapaDibujado() {
		imagePanel = ImagePanel.getInstance(RutasArchivos.PLANO);
		imagePanel.setLayout(null);
		initData();
		initComponentes();
	}

	private void initData(){
		labelsWithID = ManejadorArchivos.getObjectFromJson(RutasArchivos.LABELS_FILE, LabelWithID.class);
		establecimientos = iniEstablecimientos();
		labels = new ArrayList<>();
		elegidos = new ArrayList<>();
	}

	private ArrayList<Establecimiento> iniEstablecimientos(){
		ArrayList<Establecimiento> establecimientos = new ArrayList<>();
        establecimientos.addAll(ManejadorArchivos.getObjectFromJson(RutasArchivos.FACULTADES_FILE, Facultad.class));
        establecimientos.addAll(ManejadorArchivos.getObjectFromJson(RutasArchivos.COMEDORES_FILE, Comedor.class));
        establecimientos.addAll(ManejadorArchivos.getObjectFromJson(RutasArchivos.BIBLIOTECAS_FILE, Biblioteca.class));
        return establecimientos;
	}

	private void initComponentes() {
		drawLabels();
		getCoordinates();
	}

	private void drawLabels(){
		for (LabelWithID label : labelsWithID) {
			JLabel labelAux = label.paintIcon();
			addClickActions(labelAux);
            imagePanel.add(labelAux);
			labels.add(labelAux);
        }
	}

	private void addClickActions(JLabel label){
		label.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e){
				if(!label.isEnabled())
					System.out.println("Mostrar Galería");

				label.setEnabled(false);
				elegidos.add(label);

				if(elegidos.size() ==  2){
					JLabel label1 = elegidos.get(0);
					JLabel label2 = elegidos.get(1);
					System.out.println(label1.getText());
					System.out.println(label2.getText());
					label1.setEnabled(true);
					label2.setEnabled(true);
					elegidos.clear();
				}
            }
		});
	}

	// Create a function that will draw line segments between two labels
	private void drawSegments(String label1, String label2){
		ArrayList<String> caminos = new ArrayList<>();
		// Dijstra
		if (true) {
			for (int i = 0; i < caminoPintado.size(); i++) {
				imagePanel.remove(caminoPintado.get(i));
			}
		}
		caminoPintado.clear();
		for(String camino : caminos){
			CaminoComponente c = new CaminoComponente();
			c.setPreferredSize(imagePanel.getSize());
			c.setBounds(0, 0, imagePanel.getSize().width, imagePanel.getSize().height);
			caminoPintado.add(c);
			imagePanel.add(c);
			LinkedList<Integer> coordenadasCamino = extractCoordenadas(camino);
			c.agregarPunto(coordenadasCamino);
			imagePanel.repaint();
		}
	}

	private LinkedList<Integer> extractCoordenadas(String camino){
		String coordenadas[] = camino.split(",");
		LinkedList<Integer> coordenadasInteger = new LinkedList<>();
		for(String coordenada : coordenadas){
			coordenadasInteger.add(Integer.valueOf(coordenada));
		}
		return coordenadasInteger;
	}

	private void getCoordinates(){
		imagePanel.addMouseListener(new MouseAdapter(){
			@Override
            public void mouseClicked(MouseEvent e){
				System.out.println("X " + (e.getX() - 30));
				System.out.println("Y " + (e.getY() - 50));
            }
		});
	}
}
