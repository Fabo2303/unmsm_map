package com.fabo.unmsmmap.datosprecargados;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;

import com.fabo.unmsmmap.logica.entidades.Biblioteca;
import com.fabo.unmsmmap.logica.entidades.Comedor;
import com.fabo.unmsmmap.logica.entidades.Establecimiento;
import com.fabo.unmsmmap.logica.entidades.Facultad;
import com.fabo.unmsmmap.logica.grafo.Edge;
import com.fabo.unmsmmap.logica.grafo.Graph;
import com.fabo.unmsmmap.logica.grafo.Vertex;
import com.fabo.unmsmmap.utilidades.CargaImagen;
import com.fabo.unmsmmap.utilidades.ManejadorArchivos;

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

		edges.add(new Edge<Establecimiento>(psicologia, 212, AlmacenDeCaminos.minasPsicologia()));

		minas.addEdge(new Edge<Establecimiento>(psicologia, 212, AlmacenDeCaminos.minasPsicologia()));
		// Con civil
		minas.addEdge(new Edge<Establecimiento>(civil, 535, AlmacenDeCaminos.minasCivil()));

		// Para psicologia
		// Con minas
		psicologia.addEdge(new Edge<Establecimiento>(minas, 212, AlmacenDeCaminos.minasPsicologia()));
		// Con sistemas
		psicologia.addEdge(new Edge<Establecimiento>(sistemas, 179, AlmacenDeCaminos.psicologiaSistemas()));
		// Con odontologia
		psicologia.addEdge(new Edge<Establecimiento>(odontologia, 233, AlmacenDeCaminos.psicologiaOdontologia()));
		// Con electronica
		psicologia.addEdge(new Edge<Establecimiento>(electronica, 295, AlmacenDeCaminos.psicologiaElectronica()));
		// Con ciencias economicas
		psicologia.addEdge(
				new Edge<Establecimiento>(ciencias_economicas, 89, AlmacenDeCaminos.psicologiaCienciasEconomicas()));

		// Para sistemas
		// Con psicologia
		sistemas.addEdge(new Edge<Establecimiento>(psicologia, 179, AlmacenDeCaminos.psicologiaSistemas()));
		// Con odontologia
		sistemas.addEdge(new Edge<Establecimiento>(odontologia, 135, AlmacenDeCaminos.odontologiaSistemas()));
		// Con educacion fisica
		sistemas.addEdge(new Edge<Establecimiento>(educacion_fisica, 262, AlmacenDeCaminos.sistemasEducacionFisica()));
		// Con ciencias economicas
		sistemas.addEdge(new Edge<Establecimiento>(ciencias_economicas, 46, AlmacenDeCaminos.cienciasEconomicasFISI()));

		// Para odontologia
		// Con psicologia
		odontologia.addEdge(new Edge<Establecimiento>(psicologia, 233, AlmacenDeCaminos.psicologiaOdontologia()));
		// Con sistemas
		odontologia.addEdge(new Edge<Establecimiento>(sistemas, 135, AlmacenDeCaminos.odontologiaSistemas()));
		// Con educacion
		odontologia.addEdge(new Edge<Establecimiento>(educacion, 156, AlmacenDeCaminos.odontologiaEducacion()));
		// Con electronica
		odontologia.addEdge(new Edge<Establecimiento>(electronica, 149, AlmacenDeCaminos.odontologiaElectrica()));
		// Con ciencias Economicas
		odontologia.addEdge(
				new Edge<Establecimiento>(ciencias_economicas, 134, AlmacenDeCaminos.cienciasEconomicasOdontologia()));
		// Con biblioteca
		odontologia.addEdge(new Edge<Establecimiento>(biblioteca, 223, AlmacenDeCaminos.odontologiaBiblioteca()));

		// Para educacion
		// Con odontologia
		educacion.addEdge(new Edge<Establecimiento>(odontologia, 156, AlmacenDeCaminos.odontologiaEducacion()));
		// Con educacion fisica
		educacion.addEdge(new Edge<Establecimiento>(educacion_fisica, 33, AlmacenDeCaminos.EducacionEducacionFisica()));
		// Con geografica
		educacion.addEdge(new Edge<Establecimiento>(geografica, 184, AlmacenDeCaminos.educacionGeografica()));
		// Con biblioteca
		educacion.addEdge(new Edge<Establecimiento>(biblioteca, 148, AlmacenDeCaminos.educacionBiblioteca()));

		// Para electronica
		// Con psicologia
		electronica.addEdge(new Edge<Establecimiento>(psicologia, 295, AlmacenDeCaminos.psicologiaElectronica()));
		// Con odontologia
		electronica.addEdge(new Edge<Establecimiento>(odontologia, 149, AlmacenDeCaminos.odontologiaElectrica()));
		// Con civil
		electronica.addEdge(new Edge<Establecimiento>(civil, 141, AlmacenDeCaminos.electronicaCivil()));
		// Con geografica
		electronica.addEdge(new Edge<Establecimiento>(geografica, 92, AlmacenDeCaminos.electronicaGeografica()));

		// Para civil
		// Con minas
		civil.addEdge(new Edge<Establecimiento>(minas, 535, AlmacenDeCaminos.minasCivil()));
		// Con electrica
		civil.addEdge(new Edge<Establecimiento>(electronica, 141, AlmacenDeCaminos.electronicaCivil()));
		// Con mecanica de fluidos
		civil.addEdge(new Edge<Establecimiento>(mecanica_fluidos, 150, AlmacenDeCaminos.civilFluidos()));

		// Para mecanica de fluidos
		// Con civil
		mecanica_fluidos.addEdge(new Edge<Establecimiento>(civil, 150, AlmacenDeCaminos.civilFluidos()));
		// Con geologica
		mecanica_fluidos.addEdge(new Edge<Establecimiento>(metalurgica, 524, AlmacenDeCaminos.fluidosMetalurgica()));
		// Con comedor
		mecanica_fluidos.addEdge(new Edge<Establecimiento>(comedor, 568, AlmacenDeCaminos.comedorFluidos()));

		// Para geologica
		// Con metalurgica
		geologica.addEdge(new Edge<Establecimiento>(metalurgica, 81, AlmacenDeCaminos.geologicaMetalurgica()));
		// Con matematicas
		geologica
				.addEdge(new Edge<Establecimiento>(ciencias_matematicas, 294, AlmacenDeCaminos.geologicaMatematicas()));

		// Para quimica
		// Con metalurgica
		quimica.addEdge(new Edge<Establecimiento>(metalurgica, 77, AlmacenDeCaminos.metalurgicaQuimica()));
		// Con comedor
		quimica.addEdge(new Edge<Establecimiento>(comedor, 240, AlmacenDeCaminos.quimicaComedor()));

		// Para Matematica
		// Con geologica
		ciencias_matematicas
				.addEdge(new Edge<Establecimiento>(geologica, 294, AlmacenDeCaminos.geologicaMatematicas()));
		// Con biologicas
		ciencias_matematicas
				.addEdge(new Edge<Establecimiento>(ciencias_biologicas, 67, AlmacenDeCaminos.matematicaBiologica()));
		// Con fisicas
		ciencias_matematicas
				.addEdge(new Edge<Establecimiento>(ciencias_fisicas, 64, AlmacenDeCaminos.matematicaFisica()));
		// Con comedor
		ciencias_matematicas.addEdge(new Edge<Establecimiento>(comedor, 148, AlmacenDeCaminos.matematicaComedor()));

		// Para industrial
		// Con ciencias fisicas
		industrial.addEdge(new Edge<Establecimiento>(ciencias_fisicas, 141, AlmacenDeCaminos.industrialfisica()));
		// Con derecho
		industrial.addEdge(new Edge<Establecimiento>(derecho, 169, AlmacenDeCaminos.industrialDerecho()));

		// Para derecho
		// Con industrial
		derecho.addEdge(new Edge<Establecimiento>(industrial, 169, AlmacenDeCaminos.industrialDerecho()));
		// Con cienciasEconomicas
		derecho.addEdge(new Edge<Establecimiento>(ciencias_economicasA, 99,
				AlmacenDeCaminos.derechoCienciasEconomicasAntiguo()));
		// Con sociales
		derecho.addEdge(new Edge<Establecimiento>(ciencias_sociales, 77, AlmacenDeCaminos.socialesDerecho()));

		// Para Administrativas
		// Con sociales
		ciencias_administrativas.addEdge(new Edge<Establecimiento>(ciencias_sociales, 75,
				AlmacenDeCaminos.cienciaSocialCienciaAdministrativa()));
		// Con ciencias economicas Antiguo
		ciencias_administrativas.addEdge(
				new Edge<Establecimiento>(ciencias_economicasA, 57, AlmacenDeCaminos.administrativoEconomicasA()));
		// Con letras
		ciencias_administrativas
				.addEdge(new Edge<Establecimiento>(letras, 75, AlmacenDeCaminos.cienciaAdministrativaLetras()));

		// Para Biologicas
		// Con Matematicas
		ciencias_biologicas
				.addEdge(new Edge<Establecimiento>(ciencias_matematicas, 67, AlmacenDeCaminos.matematicaBiologica()));
		// Con fisicas
		ciencias_biologicas
				.addEdge(new Edge<Establecimiento>(ciencias_fisicas, 52, AlmacenDeCaminos.biologicasFisica()));
		// Con comedor
		ciencias_biologicas.addEdge(new Edge<Establecimiento>(comedor, 119, AlmacenDeCaminos.comedorBiologicas()));

		// Para metalurgica
		// Con quimica
		metalurgica.addEdge(new Edge<Establecimiento>(quimica, 77, AlmacenDeCaminos.metalurgicaQuimica()));
		// Con geologica
		metalurgica.addEdge(new Edge<Establecimiento>(geologica, 115, AlmacenDeCaminos.geologicaMetalurgica()));
		// Con comedor
		metalurgica.addEdge(new Edge<Establecimiento>(comedor, 374, AlmacenDeCaminos.metalurgicaComedor()));

		// Para Ciencias fisicas
		// Con industrial
		ciencias_fisicas.addEdge(new Edge<Establecimiento>(industrial, 141, AlmacenDeCaminos.industrialfisica()));
		// Con ciencias biologicas
		ciencias_fisicas
				.addEdge(new Edge<Establecimiento>(ciencias_biologicas, 52, AlmacenDeCaminos.biologicasFisica()));
		// Con ciencias matematicas
		ciencias_fisicas
				.addEdge(new Edge<Establecimiento>(ciencias_matematicas, 64, AlmacenDeCaminos.matematicaFisica()));

		// Para ciencias contables
		// Con electronica2
		ciencias_contables
				.addEdge(new Edge<Establecimiento>(electronica2, 160, AlmacenDeCaminos.contablesElectronica2()));
		// Con ciencias sociales
		ciencias_contables
				.addEdge(new Edge<Establecimiento>(ciencias_sociales, 125, AlmacenDeCaminos.socialesContables()));
		// Con ciencias EconomicasAP
		ciencias_contables
				.addEdge(new Edge<Establecimiento>(ciencias_economicasA, 105, AlmacenDeCaminos.economicasAPContable()));

		// Para ciencias sociales
		// Con administrativas
		ciencias_sociales.addEdge(new Edge<Establecimiento>(ciencias_administrativas, 70,
				AlmacenDeCaminos.cienciaSocialCienciaAdministrativa()));
		// Con contables
		ciencias_sociales
				.addEdge(new Edge<Establecimiento>(ciencias_contables, 125, AlmacenDeCaminos.socialesContables()));
		// Con economicas Antiguo
		ciencias_sociales
				.addEdge(new Edge<Establecimiento>(ciencias_economicasA, 68, AlmacenDeCaminos.socialesEconomicasA()));
		// Con derecho
		ciencias_sociales.addEdge(new Edge<Establecimiento>(derecho, 77, AlmacenDeCaminos.socialesDerecho()));

		// Para letras
		// Con ciencias administrativas
		letras.addEdge(new Edge<Establecimiento>(ciencias_administrativas, 75,
				AlmacenDeCaminos.cienciaAdministrativaLetras()));
		// Con electrica2
		letras.addEdge(new Edge<Establecimiento>(electronica2, 170, AlmacenDeCaminos.letrasElectronica()));

		// Para electrica2
		// Con contables
		electronica2
				.addEdge(new Edge<Establecimiento>(ciencias_contables, 160, AlmacenDeCaminos.contablesElectronica2()));
		// Con educacionFisica
		electronica2.addEdge(
				new Edge<Establecimiento>(educacion_fisica, 443, AlmacenDeCaminos.electronica2EducacionFisica()));
		// Con letras
		electronica2.addEdge(new Edge<Establecimiento>(letras, 170, AlmacenDeCaminos.letrasElectronica()));

		// Para Educacion Fisica
		// Con educacion
		educacion_fisica.addEdge(new Edge<Establecimiento>(educacion, 33, AlmacenDeCaminos.EducacionEducacionFisica()));
		// Con electronica 2
		educacion_fisica
				.addEdge(new Edge<Establecimiento>(electronica2, 443, AlmacenDeCaminos.electronica2EducacionFisica()));

		// Para geografica
		// Con educacion
		geografica.addEdge(new Edge<Establecimiento>(educacion, 167, AlmacenDeCaminos.educacionGeografica()));
		// Con electronica
		geografica.addEdge(new Edge<Establecimiento>(electronica, 92, AlmacenDeCaminos.electronicaGeografica()));
		// Con comedor
		geografica.addEdge(new Edge<Establecimiento>(comedor, 659, AlmacenDeCaminos.geograficaComedor()));
		// Con biblioteca
		geografica.addEdge(new Edge<Establecimiento>(biblioteca, 93, AlmacenDeCaminos.geograficaBiblioteca()));

		// Para ciencias economicas
		// Con odontologia
		ciencias_economicas
				.addEdge(new Edge<Establecimiento>(odontologia, 134, AlmacenDeCaminos.cienciasEconomicasOdontologia()));
		// Con sistemas
		ciencias_economicas.addEdge(new Edge<Establecimiento>(sistemas, 46, AlmacenDeCaminos.cienciasEconomicasFISI()));
		ciencias_economicas
				.addEdge(new Edge<Establecimiento>(psicologia, 89, AlmacenDeCaminos.psicologiaCienciasEconomicas()));

		// Para ciencias economicas antiguo
		// Con ciencias sociales
		ciencias_economicasA
				.addEdge(new Edge<Establecimiento>(ciencias_sociales, 68, AlmacenDeCaminos.socialesEconomicasA()));
		// Con administrativo
		ciencias_economicasA.addEdge(
				new Edge<Establecimiento>(ciencias_administrativas, 57, AlmacenDeCaminos.administrativoEconomicasA()));
		// Con contables
		ciencias_economicasA
				.addEdge(new Edge<Establecimiento>(ciencias_contables, 105, AlmacenDeCaminos.economicasAPContable()));

		// Para biblioteca
		// Con educacion
		biblioteca.addEdge(new Edge<Establecimiento>(educacion, 148, AlmacenDeCaminos.educacionBiblioteca()));
		// Con odontologia
		biblioteca
				.addEdge(new Edge<Establecimiento>(odontologia, 223, AlmacenDeCaminos.cienciasEconomicasOdontologia()));
		// Con geografica
		biblioteca.addEdge(new Edge<Establecimiento>(geografica, 93, AlmacenDeCaminos.geograficaBiblioteca()));

		// Para comedor
		// Con quimica
		comedor.addEdge(new Edge<Establecimiento>(quimica, 240, AlmacenDeCaminos.quimicaComedor()));
		// Con ciencias matematicas
		comedor.addEdge(new Edge<Establecimiento>(ciencias_matematicas, 148, AlmacenDeCaminos.matematicaComedor()));
		// Con geografica
		comedor.addEdge(new Edge<Establecimiento>(geografica, 659, AlmacenDeCaminos.geograficaComedor()));
		// Con mecanica de fluidos
		comedor.addEdge(new Edge<Establecimiento>(mecanica_fluidos, 568, AlmacenDeCaminos.comedorFluidos()));
		// Con metalurgica
		comedor.addEdge(new Edge<Establecimiento>(metalurgica, 374, AlmacenDeCaminos.metalurgicaComedor()));
		// Con ciencias biologicas
		comedor.addEdge(new Edge<Establecimiento>(ciencias_biologicas, 119, AlmacenDeCaminos.comedorBiologicas()));
	}
}