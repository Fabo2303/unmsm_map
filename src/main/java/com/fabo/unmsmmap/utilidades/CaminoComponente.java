package com.fabo.unmsmmap.utilidades;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.LinkedList;

public class CaminoComponente extends JComponent {
    // Atributos
    private GeneralPath path;

    // Constructor
    public CaminoComponente() {
        // this.rese
        path = new GeneralPath();
    }

    // Otros métodos
    public void agregarPunto(int x, int y) {
        if (path.getCurrentPoint() == null) {
            // Si no hay puntos en el camino, mover al punto inicial
            path.moveTo(x, y);
        } else {
            // Agregar un segmento desde el último punto hasta el nuevo punto
            path.lineTo(x, y);
        }
        repaint();
    }

    public void agregarPunto(LinkedList<Integer> coordenadas) {
        path.moveTo(coordenadas.poll(), coordenadas.poll());
        while (!coordenadas.isEmpty()) {
            // Agregar un segmento desde el último punto hasta el nuevo punto
            path.lineTo(coordenadas.poll(), coordenadas.poll());
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(3.0f));
        g2d.setColor(Color.BLACK);
        g2d.draw(path);
        g2d.dispose();
    }

    public void clearAll() {
        path.closePath();
        path.reset();
    }
}