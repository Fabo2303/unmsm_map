package com.fabo.unmsmmap.utilidades;

import java.awt.Dimension;

import javax.swing.JLabel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LabelWithID {
    private String alias;
    private String imagePath;
    private int position_x;
    private int position_y;

    public JLabel paintIcon() {
        JLabel auxLabel = new JLabel(alias);
        auxLabel.setPreferredSize(new Dimension(50, 50));
        auxLabel.setBounds(position_x, position_y, 50, 50);
        CargaImagen.setImagen(auxLabel, imagePath);
        return auxLabel;
    }
}
