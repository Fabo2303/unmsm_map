package com.fabo.unmsmmap.datosprecargados;

import java.util.ArrayList;
import java.util.Arrays;

import com.fabo.unmsmmap.logica.entidades.Biblioteca;
import com.fabo.unmsmmap.logica.entidades.Comedor;
import com.fabo.unmsmmap.logica.entidades.Establecimiento;
import com.fabo.unmsmmap.logica.entidades.Facultad;
import com.fabo.unmsmmap.logica.grafo.Edge;

public class InicializarGrafo {
	public void inicializarEstablecimientos() {
		Comedor comedor = new Comedor("COM1", "Comedor", "Comedor", "comedor.png",
				new ArrayList<>(
						Arrays.asList("comedor/comedor_1.webp", "comedor/comedor_2.webp", "comedor/comedor_3.webp")),
				"12:00 - 18:00", "600");

		Biblioteca biblioteca = new Biblioteca("BIB1", "Biblioteca central", "Biblioteca", "biblioteca.png",
				new ArrayList<>(Arrays.asList("biblioteca_central/biblioteca_1.webp",
						"biblioteca_central/biblioteca_2.webp", "biblioteca_central/biblioteca_3.webp")),
				"947806777", "12:00 - 15:00");

		Facultad ciencias_fisicas = new Facultad("FAC01", "Ciencias Fisicas", "Facultad", "ciencias_fisicas.png",
				new ArrayList<>(Arrays.asList("ciencias_fisicas/fisicas_1.webp", "ciencias_fisicas/fisicas_2.webp")),
				"001", "992829322", "ciencias.fisicas@unmsm.edu.pe");

		Facultad ciencias_biologicas = new Facultad("FAC02", "Ciencias Biologicas", "Facultad",
				"ciencias_biologicas.png",
				new ArrayList<>(Arrays.asList("ciencias_biologicas/biologicas_1.webp",
						"ciencias_biologicas/biologicas_2.webp")),
				"002", "992829322", "ciencias.biologicas@unmsm.edu.pe");

		Facultad ciencias_matematicas = new Facultad("FAC03", "Ciencias Matematicas", "Facultad",
				"ciencias_matematicas.png",
				new ArrayList<>(Arrays.asList("ciencias_matematicas/matematicas_1.webp",
						"ciencias_matematicas/matematicas_2.webp")),
				"003", "986665776", "ciencias.matematicas@unmsm.edu.pe");

		Facultad ciencias_administrativas = new Facultad(
				"FAC04", "Ciencias Administrativas", "Facultad", "ciencias_administrativas.png", new ArrayList<>(Arrays
						.asList("administrativas/administrativas_1.webp", "administrativas/administrativas_2.webp")),
				"004", "932456678", "administrativas@unmsm.edu.pe");

		Facultad ciencias_contables = new Facultad("FAC05", "Ciencias Contables", "Facultad", "ciencias_contables.png",
				new ArrayList<>(
						Arrays.asList("ciencias_contables/contables_1.webp", "ciencias_contables/contables_2.webp")),
				"005", "923122312", "contables@unmsm.edu.pe");

		Facultad ciencias_economicas_nuevo = new Facultad("FAC06", "Ciencias Economicas Nuevo", "Facultad",
				"ciencias_economicas_nuevo.png",
				new ArrayList<>(Arrays.asList("ciencias_economicas_nuevo/economicas_nuevo_1.webp")), "006", "923213221",
				"economicas.nuevo@unmsm.edu.pe");

		Facultad ciencias_economicas_antiguo = new Facultad("FAC07", "Ciencias Economicas Antiguo", "Facultad",
				"ciencias_economicas_antiguo.png",
				new ArrayList<>(Arrays.asList("ciencias_economicas_antiguo/economicas_antiguo_1.webp",
						"ciencias_economicas_antiguo/economicas_antiguo_2.webp")),
				"008", "929319312", "economicas.antiguo@unmsm.edu.pe");

		Facultad ciencias_sociales = new Facultad("FAC08", "Ciencias Sociales", "Facultad", "ciencias_sociales.png",
				new ArrayList<>(Arrays.asList("ciencias_sociales/sociales_1.webp", "ciencias_sociales/sociales_2.webp",
						"ciencias_sociales/sociales_3.webp")),
				"009", "921334453", "sociales@unmsm.edu.pe");

		Facultad derecho = new Facultad("FAC09", "Derecho", "Facultad", "derecho.png",
				new ArrayList<>(Arrays.asList("derecho/derecho_1.webp")), "010", "924312312", "derecho@unmsm.edu.pe");

		Facultad educacion = new Facultad("FAC10", "Educacion", "Facultad", "educacion.png",
				new ArrayList<>(Arrays.asList("educacion/educacion_1.webp", "educacion/educacion_2.webp")),
				"011", "912312323", "educacion@unmsm.edu.pe");

		Facultad educacion_fisica = new Facultad("FAC11", "Educacion Fisica", "Facultad", "educacion_fisica.png",
				new ArrayList<>(
						Arrays.asList("educacion_fisica/edu_fisica_1.webp", "educacion_fisica/edu_fisica_2.webp")),
				"012", "93213256", "educacion.fisica@unmsm.edu.pe");

		Facultad quimica = new Facultad("FAC12", "Quimica", "Facultad", "quimica.png",
				new ArrayList<>(Arrays.asList("quimica/quimica_1.webp", "quimica/quimica_2.webp")), "013", "932132123",
				"quimica@unmsm.edu.pe");

		Facultad sistemas = new Facultad(
				"FAC13", "Sistemas", "Facultad", "sistemas.png",
				new ArrayList<>(Arrays.asList("sistemas/sistemas_1.webp")), "014", "912731232",
				"sistemas@unmsm.edu.pe");

		Facultad geografica = new Facultad(
				"FAC14", "Geografica", "Facultad", "geografica.png",
				new ArrayList<>(Arrays.asList("geografica/geografica_1.webp", "geografica/geografica_2.webp")), "015",
				"992837442", "geografica@unmsm.edu.pe");

		// Pasa los datos de la facultad industrial
		Facultad industrial = new Facultad(
				"FAC15", "Industrial", "Facultad", "industrial.png",
				new ArrayList<>(Arrays.asList("industrial/industrial_1.webp")),
				"016", "912387223", "industrial@unmsm.edu.pe");

		Facultad electronica_nuevo = new Facultad(
				"FAC16", "Electronica", "Facultad", "electronica.png", new ArrayList<>(Arrays
						.asList("electronica_nuevo/electronica_n1.webp", "electronica_nuevo/electronica_n2.webp")),
				"017", "912312321", "electronica@unmsm.edu.pe");

		Facultad geologica = new Facultad(
				"FAC17", "Geologica", "Facultad", "geologica.png",
				new ArrayList<>(Arrays.asList("geologica/geologica_1.webp", "geologica/geologica_2.webp",
						"geologica/geologica_3.webp")),
				"018", "912312323", "geologica@unmsm.edu.pe");

		Facultad letras = new Facultad(
				"FAC18", "Letras", "Facultad", "letras.png",
				new ArrayList<>(Arrays.asList("letras/letras_1.webp", "letras/letras_2.webp")), "019", "912312323",
				"letras@unmsm.edu.pe");

		Facultad metalurgica = new Facultad("FAC19", "Metalurgica", "Facultad", "metalurgica.png",
				new ArrayList<>(Arrays.asList("metalurgica/metalurgica_1.webp")), "020", "986823768",
				"metalurgica@unmsm.edu.pe");

		Facultad minas = new Facultad(
				"FAC20", "Minas", "Facultad", "minas.png",
				new ArrayList<>(Arrays.asList("minas/minas_1.webp", "minas/minas_2.webp")), "021", "736482232",
				"minas@unmsm.edu.pe");

		Facultad odontologia = new Facultad(
				"FAC21", "Odontologia", "Facultad", "odontologia.png",
				new ArrayList<>(Arrays.asList("odontologia/odontologia_1.webp", "odontologia/odontologia_2.webp")),
				"022", "919231927", "odontologia@unmsm.edu.pe");

		Facultad psicologia = new Facultad(
				"FAC22", "Psicologia", "Facultad", "psicologia.png",
				new ArrayList<>(Arrays.asList("psicologia/psicologia_1.webp", "psicologia/psicologia_2.webp")), "023",
				"9391292959", "psicologia@unmsm.edu.pe");

		Facultad electronica_antiguo = new Facultad(
				"FAC23", "Electronica Antiguo", "Facultad", "electronica_antiguo.png",
				new ArrayList<>(Arrays.asList("electronica_antiguo/electronica_a1.webp")), "024", "923991929",
				"electronica@unmsm.edu.pe");

		Facultad civil = new Facultad(
				"FAC24", "Civil", "Facultad", "civil.png",
				new ArrayList<>(Arrays.asList("civil/civil_1.webp", "civil/civil_2.web")), "024", "929393919",
				"civil@unmsm.edu.pe");

		Facultad mecanica_fluidos = new Facultad(
				"FAC25", "Mecanica fluidos", "Facultad", "mecanica_fluidos.png",
				new ArrayList<>(Arrays.asList("fluidos/fluidos_1.webp", "fluidos/fluidos_2.web")), "024", "982738231",
				"mecanica.fluidos@unmsm.edu.pe");

		ArrayList<Comedor> comedores = new ArrayList<Comedor>();
		comedores.add(comedor);

		ArrayList<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();
		bibliotecas.add(biblioteca);

		ArrayList<Establecimiento> facultades = new ArrayList<Establecimiento>();

		facultades.add(ciencias_fisicas);
		facultades.add(ciencias_biologicas);
		facultades.add(ciencias_matematicas);
		facultades.add(ciencias_administrativas);
		facultades.add(ciencias_contables);
		facultades.add(ciencias_economicas_nuevo);
		facultades.add(ciencias_economicas_antiguo);
		facultades.add(ciencias_sociales);
		facultades.add(derecho);
		facultades.add(educacion);
		facultades.add(educacion_fisica);
		facultades.add(quimica);
		facultades.add(sistemas);
		facultades.add(geografica);
		facultades.add(industrial);
		facultades.add(electronica_nuevo);
		facultades.add(geologica);
		facultades.add(letras);
		facultades.add(metalurgica);
		facultades.add(minas);
		facultades.add(odontologia);
		facultades.add(psicologia);
		facultades.add(electronica_antiguo);
		facultades.add(civil);
		facultades.add(mecanica_fluidos);

		ArrayList<Edge<Establecimiento>> edges = new ArrayList<>();

		edges.add(new Edge<>("FAC20", "FAC22", AlmacenDeCaminos.MINAS_PSICOLOGIA, 212));
		edges.add(new Edge<>("FAC20", "FAC24", AlmacenDeCaminos.MINAS_CIVIL, 535));
		edges.add(new Edge<>("FAC22", "FAC13", AlmacenDeCaminos.PSICOLOGIA_SISTEMAS, 179));
		edges.add(new Edge<>("FAC22", "FAC21", AlmacenDeCaminos.PSICOLOGIA_ODONTOLOGIA, 233));
		edges.add(new Edge<>("FAC22", "FAC16", AlmacenDeCaminos.PSICOLOGIA_ELECTRONICA, 295));
		edges.add(new Edge<>("FAC22", "FAC06", AlmacenDeCaminos.PSICOLOGIA_CIENCIAS_ECONOMICAS, 89));
		edges.add(new Edge<>("FAC13", "FAC21", AlmacenDeCaminos.SISTEMAS_ODONTOLOGIA, 135));
		edges.add(new Edge<>("FAC13", "FAC11", AlmacenDeCaminos.SISTEMAS_EDUCACION_FISICA, 262));
		edges.add(new Edge<>("FAC13", "FAC06", AlmacenDeCaminos.SISTEMAS_CIENCIAS_ECONOMICAS, 46));
		edges.add(new Edge<>("FAC21", "FAC10", AlmacenDeCaminos.ODONTOLOGIA_EDUCACION, 156));
		edges.add(new Edge<>("FAC21", "FAC16", AlmacenDeCaminos.ODONTOLOGIA_ELECTRICA, 149));
		edges.add(new Edge<>("FAC21", "FAC06", AlmacenDeCaminos.ODONTOLOGIA_CIENCIAS_ECONOMICAS, 134));
		edges.add(new Edge<>("FAC21", "BIB1", AlmacenDeCaminos.ODONTOLOGIA_BIBLIOTECA, 223));
		edges.add(new Edge<>("FAC10", "FAC11", AlmacenDeCaminos.EDUCACION_EDUCACION_FISICA, 33));
		edges.add(new Edge<>("FAC10", "FAC14", AlmacenDeCaminos.EDUCACION_GEOGRAFICA, 184));
		edges.add(new Edge<>("FAC10", "BIB1", AlmacenDeCaminos.EDUCACION_BIBLIOTECA, 148));
		edges.add(new Edge<>("FAC16", "FAC24", AlmacenDeCaminos.ELECTRONICA_CIVIL, 141));
		edges.add(new Edge<>("FAC16", "FAC14", AlmacenDeCaminos.ELECTRONICA_GEOGRAFICA, 92));
		edges.add(new Edge<>("FAC24", "FAC25", AlmacenDeCaminos.CIVIL_FLUIDOS, 150));
		edges.add(new Edge<>("FAC25", "FAC17", AlmacenDeCaminos.FLUIDOS_METALURGICA, 524));
		edges.add(new Edge<>("FAC25", "COM1", AlmacenDeCaminos.COMEDOR_FLUIDOS, 568));
		edges.add(new Edge<>("FAC17", "FAC19", AlmacenDeCaminos.GEOLOGICA_METALURGICA, 81));
		edges.add(new Edge<>("FAC17", "FAC03", AlmacenDeCaminos.GEOLOGICA_MATEMATICAS, 294));
		edges.add(new Edge<>("FAC12", "FAC19", AlmacenDeCaminos.METALURGICA_QUIMICA, 77));
		edges.add(new Edge<>("FAC12", "COM1", AlmacenDeCaminos.QUIMICA_COMEDOR, 240));
		edges.add(new Edge<>("FAC03", "FAC02", AlmacenDeCaminos.MATEMATICA_BIOLOGICA, 67));
		edges.add(new Edge<>("FAC03", "FAC01", AlmacenDeCaminos.MATEMATICA_FISICA, 64));
		edges.add(new Edge<>("FAC03", "COM1", AlmacenDeCaminos.MATEMATICA_COMEDOR, 148));
		edges.add(new Edge<>("FAC15", "FAC01", AlmacenDeCaminos.INDUSTRIAL_FISICA, 141));
		edges.add(new Edge<>("FAC15", "FAC09", AlmacenDeCaminos.INDUSTRIAL_DERECHO, 169));
		edges.add(new Edge<>("FAC09", "FAC07", AlmacenDeCaminos.DERECHO_ECONOMICAS_ANTIGUO, 99));
		edges.add(new Edge<>("FAC09", "FAC08", AlmacenDeCaminos.SOCIALES_DERECHO, 77));
		edges.add(new Edge<>("FAC04", "FAC08", AlmacenDeCaminos.SOCIALES_CIENCIA_ADMINISTRATIVA, 75));
		edges.add(new Edge<>("FAC04", "FAC07", AlmacenDeCaminos.ADMINISTRATIVO_CIENCIA_ECONOMICA_ANTIGUO, 57));
		edges.add(new Edge<>("FAC04", "FAC18", AlmacenDeCaminos.CIENCIA_ADMINISTRATIVA_LETRAS, 75));
		edges.add(new Edge<>("FAC02", "FAC01", AlmacenDeCaminos.CIENCIAS_BIOLOGICAS_FISICA, 52));
		edges.add(new Edge<>("FAC02", "COM1", AlmacenDeCaminos.COMEDOR_BIOLOGICA, 119));
		edges.add(new Edge<>("FAC19", "COM1", AlmacenDeCaminos.METALURGICA_COMEDOR, 374));
		edges.add(new Edge<>("FAC05", "FAC23", AlmacenDeCaminos.CONTABLES_ELECTRONICA_ANTIGUO, 160));
		edges.add(new Edge<>("FAC05", "FAC08", AlmacenDeCaminos.SOCIALES_CIENCIA_CONTABLE, 125));
		edges.add(new Edge<>("FAC05", "FAC07", AlmacenDeCaminos.CONTABLE_CIENCIA_ECONOMICA_ANTIGUO, 105));
		edges.add(new Edge<>("FAC08", "FAC07", AlmacenDeCaminos.SOCIALES_ECONOMICAS_ANTIGUO, 68));
		edges.add(new Edge<>("FAC08", "FAC09", AlmacenDeCaminos.SOCIALES_DERECHO, 77));
		edges.add(new Edge<>("FAC18", "FAC23", AlmacenDeCaminos.LETRAS_ELECTRONICA, 170));
		edges.add(new Edge<>("FAC23", "FAC11", AlmacenDeCaminos.ELECTRONICA_ANTIGUO_EDUCACION_FISICA, 443));
		edges.add(new Edge<>("FAC14", "COM1", AlmacenDeCaminos.COMEDOR_GEOGRAFICA, 659));
		edges.add(new Edge<>("FAC14", "BIB1", AlmacenDeCaminos.BIBLIOTECA_GEOGRAFICA, 93));
	}
}