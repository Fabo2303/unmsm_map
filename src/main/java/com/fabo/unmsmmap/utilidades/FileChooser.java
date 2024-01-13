package com.fabo.unmsmmap.utilidades;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {
	private static JFileChooser fileChooser = new JFileChooser();

	public static String seleccionarArchivo() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPG & GIF Images", "jpg", "webp", "png");
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal != JFileChooser.APPROVE_OPTION)
			return "";
		return fileChooser.getSelectedFile().getAbsolutePath().replace((char) 92, (char) 47);
	}
}
