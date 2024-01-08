package com.fabo.unmsmmap.utilidades;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {

	private static boolean identificarSistema() {
		String sSistemaOperativo = System.getProperty("os.name");
		return sSistemaOperativo.equals("Windows 10");
	}

	public static String seleccionarArchivo(JPanel fondo, JFileChooser buscador, String... extensiones) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Filtro archivos", extensiones);
		buscador.setFileFilter(filter);

		int result = buscador.showOpenDialog(fondo);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = buscador.getSelectedFile();
			buscador.setCurrentDirectory(selectedFile.getParentFile());
			if (identificarSistema())
				return selectedFile.getAbsolutePath().replace("\\", "\\\\");
			else
				return selectedFile.getAbsolutePath().replace("//", "////");
		}

		return null;
	}

}
