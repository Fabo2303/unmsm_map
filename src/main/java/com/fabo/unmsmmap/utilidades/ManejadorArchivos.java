package com.fabo.unmsmmap.utilidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.fabo.unmsmmap.logica.grafo.Vertex;

public class ManejadorArchivos<T> {

	private boolean identificarSistema() {
		String sSistemaOperativo = System.getProperty("os.name");
		return sSistemaOperativo.equals("Windows 10");
	}

	public void guardarDatosList(ArrayList<Vertex<T>> generico, String fileName) {
		String dir = System.getProperty("user.dir").replace("\\", "\\\\") + "\\\\Archivos\\\\";
		if (identificarSistema())
			dir = dir.replace("\\\\", "////");
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(dir + fileName))) {
			outputStream.writeUnshared(generico);
			System.out.println("Guardados correctamente en el archivo: " + fileName);
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Error al guardar: " + e.getMessage());
		}
	}

	// Cargar los JLabels desde un archivo
	public ArrayList<Vertex<T>> cargarDatosList(String fileName) {
		String dir = System.getProperty("user.dir").replace("\\", "\\\\") + "\\\\Archivos\\\\";
		if (identificarSistema())
			dir = dir.replace("\\\\", "////");
		ArrayList<Vertex<T>> generico = new ArrayList<>();
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(dir + fileName))) {
			generico = (ArrayList<Vertex<T>>) inputStream.readObject();
			System.out.println("Cargados correctamente desde el archivo: " + fileName);
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de E/S al leer el archivo: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("No se pudo encontrar la clase necesaria: " + e.getMessage());
		} catch (ClassCastException e) {
			System.out.println("No se pudo realizar el casting adecuado: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Ocurrió un error desconocido: " + e.getMessage());
		}
		return generico;
	}
}
