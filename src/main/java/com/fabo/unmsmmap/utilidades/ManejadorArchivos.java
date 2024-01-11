package com.fabo.unmsmmap.utilidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import com.fabo.unmsmmap.datosprecargados.InicializarGrafo;
import com.fabo.unmsmmap.logica.grafo.Vertex;
import com.google.gson.Gson;

public class ManejadorArchivos {

	private boolean identificarSistema() {
		String sSistemaOperativo = System.getProperty("os.name");
		return sSistemaOperativo.equals("Windows 10");
	}

	public <T> void guardarDatosList(ArrayList<Vertex<T>> generico, String fileName) {
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
	public <T> ArrayList<Vertex<T>> cargarDatosList(String fileName) {
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

	public static <T> void saveObjectToJson(ArrayList<T> objects, String nameFile){
		Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(nameFile)) {
            gson.toJson(objects, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void verificarArchivos(){
		if(!isExists(RutasArchivos.BIBLIOTECAS_FILE))
			InicializarGrafo.inicializarBibliotecas();
		if(!isExists(RutasArchivos.COMEDORES_FILE))
			InicializarGrafo.inicializarComedores();
		if(!isExists(RutasArchivos.FACULTADES_FILE))
			InicializarGrafo.inicializarFacultades();
		if(!isExists(RutasArchivos.EDGES_FILE))
			InicializarGrafo.inicializarAristas();
	}

	public static boolean isExists(String rutaArchivo){
		Path path = FileSystems.getDefault().getPath(rutaArchivo);
        return Files.exists(path) && !Files.isDirectory(path);
	}
}
