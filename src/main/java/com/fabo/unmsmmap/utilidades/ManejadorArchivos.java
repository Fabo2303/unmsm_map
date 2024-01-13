package com.fabo.unmsmmap.utilidades;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import com.fabo.unmsmmap.datosprecargados.InicializarGrafo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ManejadorArchivos {

	public static <T> ArrayList<T> getObjectFromJson(String filename, Class<T> type) {
		List<T> lista;
		try (FileReader reader = new FileReader(filename)) {
			Gson gson = new Gson();
			Type tipoLista = TypeToken.getParameterized(List.class, type).getType();
			lista = gson.fromJson(reader, tipoLista);
			return new ArrayList<>(lista);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> void saveObjectToJson(ArrayList<T> objects, String filename) {
		Gson gson = new Gson();
		try (FileWriter writer = new FileWriter(filename)) {
			gson.toJson(objects, writer);
			System.out.println("Se guardo el archivo en " + filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void verificarArchivos() {
		if (!isExists(RutasArchivos.BIBLIOTECAS_FILE))
			InicializarGrafo.inicializarBibliotecas();
		if (!isExists(RutasArchivos.COMEDORES_FILE))
			InicializarGrafo.inicializarComedores();
		if (!isExists(RutasArchivos.FACULTADES_FILE))
			InicializarGrafo.inicializarFacultades();
		if (!isExists(RutasArchivos.EDGES_FILE))
			InicializarGrafo.inicializarAristas();
	}

	public static boolean isExists(String rutaArchivo) {
		Path path = FileSystems.getDefault().getPath(rutaArchivo);
		return Files.exists(path) && !Files.isDirectory(path);
	}
}
