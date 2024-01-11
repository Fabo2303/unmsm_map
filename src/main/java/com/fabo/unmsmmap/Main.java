package com.fabo.unmsmmap;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.fabo.unmsmmap.gui.PantallaInicial;
import com.fabo.unmsmmap.utilidades.ImagePanel;
import com.fabo.unmsmmap.utilidades.ManejadorArchivos;
import com.fabo.unmsmmap.utilidades.RutasArchivos;

public class Main {

	public static void initApp() {
		JFrame ventana = new JFrame();
		ventana.setSize(1280, 720);
		ventana.setTitle("San Marcos MAP");
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.add(ImagePanel.getInstance(RutasArchivos.FONDO_TEMPORAL));
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				int option = JOptionPane.showConfirmDialog(ventana, "¿Estás seguro de que quieres salir?",
						"Confirmar salida", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					System.out.println("Cerrando programa");
					System.exit(0);
				}
			}
		});
		ventana.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				ImagePanel.getInstance().setSize(ventana.getWidth(), ventana.getHeight());
			}
		});
		ventana.setVisible(true);
		new PantallaInicial();
	}

	public static void main(String[] args) {
		initApp();
		ManejadorArchivos.verificarArchivos();
	}
}
