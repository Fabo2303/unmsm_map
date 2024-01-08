package com.fabo.unmsmmap.utilidades;

public class RutasArchivos {
    public static final String LOGO;
    public static final String FONDO;

    static {
        String sistemaOperativo = System.getProperty("os.name").toLowerCase();
        if (sistemaOperativo.contains("win")) {
            LOGO = "src/main/resources/imagenes/logo.webp";
            FONDO = "src\\main\\resources\\imagenes\\fondo_temporal.webp";
            // Otras rutas de imágenes para Windows...
        } else {
            LOGO = "src/Main/tilin.jpg";
            FONDO = "src/main/resources/imagenes/fondo_temporal.webp";
            // Otras rutas de imágenes para otros sistemas operativos...
        }
    }
}
