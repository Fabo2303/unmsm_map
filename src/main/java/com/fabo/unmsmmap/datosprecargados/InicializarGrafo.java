package com.fabo.unmsmmap.datosprecargados;

import java.util.ArrayList;

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

/*
 * Clase que almacena la información de los establecimientos de la universidad
 */
public class InicializarGrafo {
	private ArrayList<JLabel> labels = new ArrayList<>();;
	private ArrayList<Vertex<Establecimiento>> vertices = new ArrayList<>();
	private Graph<Establecimiento> grafo = new Graph<>();

	public void inicializarEstablecimientos() {
		// Para biblioteca
		JLabel Jbiblioteca = new JLabel();
		Jbiblioteca.setBounds(738, 156, 50, 50);
		CargaImagen.setImagen(Jbiblioteca, "biblioteca.png", 0);

		Vertex<Establecimiento> biblioteca = new Vertex<>(
				new Biblioteca("Biblioteca central", "Biblioteca", CargaImagen.retornarImagen("biblioteca.png"),
						CargaImagen.setGaleria("biblioteca_central\\\\biblioteca_", 3, ".jpg"), Jbiblioteca,
						"947806777", "12:00 - 15:00"),
				0);

		labels.add(biblioteca.getDato().getLabel());

		// Para ciencias fisicas
		JLabel Jciencias_fisicas = new JLabel();
		Jciencias_fisicas.setBounds(148, 443, 50, 50);
		CargaImagen.setImagen(Jciencias_fisicas, "ciencias_fisicas.png", 0);

		Vertex<Establecimiento> ciencias_fisicas = new Vertex<>(
				new Facultad("Ciencias Fisicas", "Facultad", CargaImagen.retornarImagen("ciencias_fisicas.png"),
						CargaImagen.setGaleria("ciencias_fisicas\\\\fisicas_", 2, ".jpg"), Jciencias_fisicas, "111",
						"992829322", "ciencias.fisicas@unmsm.edu.pe"),
				1);

		labels.add(ciencias_fisicas.getDato().getLabel());

		// Para ciencias biologicas
		JLabel Jciencias_biologicas = new JLabel();
		Jciencias_biologicas.setBounds(190, 385, 50, 50);
		CargaImagen.setImagen(Jciencias_biologicas, "ciencias_biologicas.png", 0);

		Vertex<Establecimiento> ciencias_biologicas = new Vertex<>(
				new Facultad("Ciencias Biologicas", "Facultad", CargaImagen.retornarImagen("ciencias_biologicas.png"),
						CargaImagen.setGaleria("biológicas\\\\biologicas_", 2, ".jpg"), Jciencias_biologicas, "222",
						"998675667", "ciencias.biologicas@unmsm.edu.pe"),
				2);

		labels.add(ciencias_biologicas.getDato().getLabel());

		// Para ciencias matematicas
		JLabel Jciencias_matematicas = new JLabel();
		Jciencias_matematicas.setBounds(103, 400, 50, 50);
		CargaImagen.setImagen(Jciencias_matematicas, "ciencias_matematicas.png", 0);

		Vertex<Establecimiento> ciencias_matematicas = new Vertex<>(
				new Facultad("Ciencias Matematicas", "Facultad", CargaImagen.retornarImagen("ciencias_matematicas.png"),
						CargaImagen.setGaleria("matemáticas\\\\matematicas_", 2, ".jpg"), Jciencias_matematicas, "333",
						"986665776", "matematicas@unmsm.edu.pe"),
				3);

		labels.add(ciencias_matematicas.getDato().getLabel());

		// para ciencias administrativas
		JLabel Jciencias_administrativas = new JLabel();
		Jciencias_administrativas.setBounds(468, 454, 50, 50);
		CargaImagen.setImagen(Jciencias_administrativas, "ciencias_administrativas.png", 0);

		Vertex<Establecimiento> ciencias_administrativas = new Vertex<>(new Facultad("Ciencias Administrativas",
				"Facultad", CargaImagen.retornarImagen("ciencias_administrativas.png"),
				CargaImagen.setGaleria("administrativas\\\\administrativas_", 2, ".jpg"), Jciencias_administrativas,
				"444", "932456678", "administrativas@unmsm.edu.pe"), 4);

		labels.add(ciencias_administrativas.getDato().getLabel());

		// Para ciencias contables
		JLabel Jciencias_contables = new JLabel();
		Jciencias_contables.setBounds(466, 544, 50, 50);
		CargaImagen.setImagen(Jciencias_contables, "ciencias_contables.png", 0);

		Vertex<Establecimiento> ciencias_contables = new Vertex<>(
				new Facultad("Ciencias Contables", "Facultad", CargaImagen.retornarImagen("ciencias_contables.png"),
						CargaImagen.setGaleria("matemáticas\\\\matematicas_", 2, ".jpg"), Jciencias_contables, "555",
						"923122312", "contables@unmsm.edu.pe"),
				5);

		labels.add(ciencias_contables.getDato().getLabel());

		// Para ciencias economicas
		JLabel Jciencias_economicas = new JLabel();
		Jciencias_economicas.setBounds(1116, 140, 50, 50);
		CargaImagen.setImagen(Jciencias_economicas, "ciencias_economicas.png", 0);

		Vertex<Establecimiento> ciencias_economicas = new Vertex<>(
				new Facultad("Ciencias Economicas", "Facultad", CargaImagen.retornarImagen("ciencias_economicas.png"),
						CargaImagen.setGaleria("ciencias_economicas_nuevo\\\\economicas_n", 1, ".jpg"),
						Jciencias_economicas, "666", "923213221", "economicas@unmsm.edu.pe"),
				6);

		labels.add(ciencias_economicas.getDato().getLabel());

		// Para ciencias sociales
		JLabel Jciencias_sociales = new JLabel();
		Jciencias_sociales.setBounds(380, 461, 50, 50);
		CargaImagen.setImagen(Jciencias_sociales, "ciencias_sociales.png", 0);

		Vertex<Establecimiento> ciencias_sociales = new Vertex<>(
				new Facultad("Ciencias Sociales", "Facultad", CargaImagen.retornarImagen("ciencias_sociales.png"),
						CargaImagen.setGaleria("sociales\\\\sociales_", 2, ".jpg"), Jciencias_sociales, "777",
						"921334453", "sociales@unmsm.edu.pe"),
				7);

		labels.add(ciencias_sociales.getDato().getLabel());

		// Para el comedor
		JLabel Jcomedor = new JLabel();
		Jcomedor.setBounds(260, 328, 50, 50);
		CargaImagen.setImagen(Jcomedor, "comedor.png", 0);

		Vertex<Establecimiento> comedor = new Vertex<>(
				new Comedor("Comedor", "Comedor", CargaImagen.retornarImagen("comedor.png"),
						CargaImagen.setGaleria("comedor\\\\comedor_", 2, ".jpg"), Jcomedor, "6:00 - 18:00", "120"),
				8);

		labels.add(comedor.getDato().getLabel());

		// Para derecho
		JLabel Jderecho = new JLabel();
		Jderecho.setBounds(330, 526, 50, 50);
		CargaImagen.setImagen(Jderecho, "derecho.png", 0);

		Vertex<Establecimiento> derecho = new Vertex<>(new Facultad("Derecho", "Facultad",
				CargaImagen.retornarImagen("derecho.png"), CargaImagen.setGaleria("derecho\\\\derecho_", 1, ".jpg"),
				Jderecho, "888", "924312312", "derecho@unmsm.edu.pe"), 9);

		labels.add(derecho.getDato().getLabel());

		// Para educacion

		JLabel Jeducacion = new JLabel();
		Jeducacion.setBounds(864, 188, 50, 50);
		CargaImagen.setImagen(Jeducacion, "educacion.png", 0);

		Vertex<Establecimiento> educacion = new Vertex<>(
				new Facultad("Educacion", "Facultad", CargaImagen.retornarImagen("educacion.png"),
						CargaImagen.setGaleria("educacion\\\\educacion_", 2, ".jpg"), Jeducacion, "999", "912312323",
						"educacion@unmsm.edu.pe"),
				10);

		labels.add(educacion.getDato().getLabel());

		// Para educacion fisica

		JLabel Jeducacion_fisica = new JLabel();
		Jeducacion_fisica.setBounds(925, 215, 50, 50);
		CargaImagen.setImagen(Jeducacion_fisica, "educacion_fisica.png", 0);

		Vertex<Establecimiento> educacion_fisica = new Vertex<>(
				new Facultad("Educacion Fisica", "Facultad", CargaImagen.retornarImagen("educacion_fisica.png"),
						CargaImagen.setGaleria("educacion_fisica\\\\edu_fisica_", 2, ".jpg"), Jeducacion_fisica, "1111",
						"93213256", "educacion.fisica@unmsm.edu.pe"),
				11);

		labels.add(educacion_fisica.getDato().getLabel());

		// Para quimica

		JLabel Jquimica = new JLabel();
		Jquimica.setBounds(146, 332, 50, 50);
		CargaImagen.setImagen(Jquimica, "quimica.png", 0);

		Vertex<Establecimiento> quimica = new Vertex<>(new Facultad("Quimica", "Facultad",
				CargaImagen.retornarImagen("quimica.png"), CargaImagen.setGaleria("quimica\\\\quimica_", 2, ".jpg"),
				Jquimica, "2222", "932132123", "@unmsm"), 12);

		labels.add(quimica.getDato().getLabel());

		// Para sistemas
		JLabel Jsistemas = new JLabel();
		Jsistemas.setBounds(1040, 172, 50, 50);
		CargaImagen.setImagen(Jsistemas, "fisi.png", 0);

		Vertex<Establecimiento> sistemas = new Vertex<>(new Facultad("Sistemas", "Facultad",
				CargaImagen.retornarImagen("fisi.png"), CargaImagen.setGaleria("sistemas\\\\sistemas_", 1, ".jpg"),
				Jsistemas, "3333", "912731232", "sistemas@unmsm.edu.pe"), 13);

		labels.add(sistemas.getDato().getLabel());

		// Para geografica
		JLabel Jgeografica = new JLabel();
		Jgeografica.setBounds(739, 92, 50, 50);
		CargaImagen.setImagen(Jgeografica, "geografica.png", 0);

		Vertex<Establecimiento> geografica = new Vertex<>(
				new Facultad("Geografica", "Facultad", CargaImagen.retornarImagen("geografica.png"),
						CargaImagen.setGaleria("geograficas\\\\geografica_", 2, ".jpg"), Jgeografica, "4444",
						"992837442", "geografica@unmsm.edu.pe"),
				14);

		labels.add(geografica.getDato().getLabel());

		// Para industrial
		JLabel Jindustrial = new JLabel();
		Jindustrial.setBounds(219, 513, 50, 50);
		CargaImagen.setImagen(Jindustrial, "industrial.png", 0);

		Vertex<Establecimiento> industrial = new Vertex<>(
				new Facultad("Industrial", "Facultad", CargaImagen.retornarImagen("industrial.png"),
						CargaImagen.setGaleria("industrial\\\\industrial_", 2, ".jpg"), Jindustrial, "5555",
						"912387223", "industrial@unmsm.edu.pe"),
				15);

		labels.add(industrial.getDato().getLabel());

		// Para electronica
		JLabel Jelectronica = new JLabel();
		Jelectronica.setBounds(776, 23, 50, 50);
		CargaImagen.setImagen(Jelectronica, "electronica.png", 0);

		Vertex<Establecimiento> electronica = new Vertex<>(
				new Facultad("Electronica", "Facultad", CargaImagen.retornarImagen("electronica.png"),
						CargaImagen.setGaleria("electronica_nuevo\\\\electronica_n", 2, ".jpg"), Jelectronica, "6666",
						"912312321", "electronica@unmsm.edu.pe"),
				16);

		labels.add(electronica.getDato().getLabel());

		// Para geologica
		JLabel Jgeologica = new JLabel();
		Jgeologica.setBounds(70, 180, 50, 50);
		CargaImagen.setImagen(Jgeologica, "geologica.png", 0);

		Vertex<Establecimiento> geologica = new Vertex<>(
				new Facultad("Geologica", "Facultad", CargaImagen.retornarImagen("geologica.png"),
						CargaImagen.setGaleria("geológica\\\\geologia_", 2, ".jpg"), Jgeologica, "7777", "989712323",
						"geologica@unmsm.edu.pe"),
				17);

		labels.add(geologica.getDato().getLabel());

		// Para letras
		JLabel Jletras = new JLabel();
		Jletras.setBounds(530, 469, 50, 50);
		CargaImagen.setImagen(Jletras, "letras.png", 0);

		Vertex<Establecimiento> letras = new Vertex<>(new Facultad("Letras", "Facultad",
				CargaImagen.retornarImagen("letras.png"), CargaImagen.setGaleria("letras\\\\letras_", 2, ".jpg"),
				Jletras, "8888", "989876754", "letras@unmsm.edu.pe"), 18);

		labels.add(letras.getDato().getLabel());

		// Para metalurgica

		JLabel Jmetalurgica = new JLabel();
		Jmetalurgica.setBounds(135, 255, 50, 50);
		CargaImagen.setImagen(Jmetalurgica, "metalurgica.png", 0);

		Vertex<Establecimiento> metalurgica = new Vertex<>(
				new Facultad("Metalurgica", "Facultad", CargaImagen.retornarImagen("metalurgica.png"),
						CargaImagen.setGaleria("metalúrgica\\\\metalurgica_", 1, ".jpg"), Jmetalurgica, "9999",
						"986823768", "metalurgica@unmsm.edu.pe"),
				19);

		labels.add(metalurgica.getDato().getLabel());

		// Para minas
		JLabel Jminas = new JLabel();
		Jminas.setBounds(1140, 35, 50, 50);
		CargaImagen.setImagen(Jminas, "minas.png", 0);

		Vertex<Establecimiento> minas = new Vertex<>(new Facultad("Minas", "Facultad",
				CargaImagen.retornarImagen("minas.png"), CargaImagen.setGaleria("ingenireria_minas\\\\minas_", 2, ".jpg"),
				Jminas, "11111", "736482232", "minas@unmsm.edu.pe"), 20);

		labels.add(minas.getDato().getLabel());

		// Para odontologia
		JLabel Jodontologia = new JLabel();
		Jodontologia.setBounds(949, 116, 50, 50);
		CargaImagen.setImagen(Jodontologia, "odontologia.png", 0);

		Vertex<Establecimiento> odontologia = new Vertex<>(
				new Facultad("Odontologia", "Facultad", CargaImagen.retornarImagen("odontologia.png"),
						CargaImagen.setGaleria("odontologia\\\\odontologia_", 2, ".jpg"), Jodontologia, "22222",
						"919231927", "odontologia@unmsm.edu.pe"),
				21);

		labels.add(odontologia.getDato().getLabel());

		// Para psicologia
		JLabel Jpsicologia = new JLabel();
		Jpsicologia.setBounds(1025, 53, 50, 50);
		CargaImagen.setImagen(Jpsicologia, "psicologia.png", 0);

		Vertex<Establecimiento> psicologia = new Vertex<>(
				new Facultad("Psicologia", "Facultad", CargaImagen.retornarImagen("psicologia.png"),
						CargaImagen.setGaleria("psicologia\\\\psicologia_", 2, ".jpg"), Jpsicologia, "33333",
						"9391292959", "psicologia@unmsm.edu.pe"),
				22);

		labels.add(psicologia.getDato().getLabel());

		// Para ciencias economicas Antiguo Pabellon
		JLabel Jciencias_economicasA = new JLabel();
		Jciencias_economicasA.setBounds(426, 496, 50, 50);
		CargaImagen.setImagen(Jciencias_economicasA, "ciencias_economicas.png", 0);

		Vertex<Establecimiento> ciencias_economicasA = new Vertex<>(
				new Facultad("Ciencias Economicas A", "Facultad", CargaImagen.retornarImagen("ciencias_economicas.png"),
						CargaImagen.setGaleria("ciencias_economicas_antiguo\\\\economicas_a", 2, ".jpg"),
						Jciencias_economicasA, "44444", "929319312", "economicas@unmsm.edu.pe"),
				23);

		labels.add(ciencias_economicasA.getDato().getLabel());

		// Para electronica2
		JLabel Jelectronica2 = new JLabel();
		Jelectronica2.setBounds(618, 470, 50, 50);
		CargaImagen.setImagen(Jelectronica2, "electronica.png", 0);

		Vertex<Establecimiento> electronica2 = new Vertex<>(new Facultad("Electronica", "Facultad",
				CargaImagen.retornarImagen("electronica.png"), CargaImagen.setGaleria("comedor\\\\comedor_", 2, ".jpg"),
				Jelectronica2, "55555", "923991929", "electronica@unmsm.edu.pe"), 24);

		labels.add(electronica2.getDato().getLabel());

		// Para civil
		JLabel Jcivil = new JLabel();
		Jcivil.setBounds(650, 13, 50, 50);
		CargaImagen.setImagen(Jcivil, "civil.png", 0);

		Vertex<Establecimiento> civil = new Vertex<>(new Facultad("Civil", "Facultad",
				CargaImagen.retornarImagen("civil.png"), CargaImagen.setGaleria("civil\\\\civil_", 2, ".jpg"), Jcivil,
				"66666", "929393919", "civil@unmsm.edu.pe"), 25);

		labels.add(civil.getDato().getLabel());

		// Para fluidos
		JLabel Jmecanica_fluidos = new JLabel();
		Jmecanica_fluidos.setBounds(574, 51, 50, 50);
		CargaImagen.setImagen(Jmecanica_fluidos, "mecanica_fluidos.png", 0);

		Vertex<Establecimiento> mecanica_fluidos = new Vertex<>(
				new Facultad("Mecanica fluidos", "Facultad", CargaImagen.retornarImagen("mecanica_fluidos.png"),
						CargaImagen.setGaleria("fluidos\\\\fluidos_", 2, ".jpg"), Jmecanica_fluidos, "77777",
						"982738231", "mecanicaFluidos@unmsm.edu.pe"),
				26);

		labels.add(mecanica_fluidos.getDato().getLabel());

		vertices.add(biblioteca);
		vertices.add(ciencias_fisicas);
		vertices.add(ciencias_biologicas);
		vertices.add(ciencias_matematicas);
		vertices.add(ciencias_administrativas);
		vertices.add(ciencias_contables);
		vertices.add(ciencias_economicas);
		vertices.add(ciencias_sociales);
		vertices.add(comedor);
		vertices.add(derecho);
		vertices.add(educacion);
		vertices.add(educacion_fisica);
		vertices.add(quimica);
		vertices.add(sistemas);
		vertices.add(geografica);
		vertices.add(industrial);
		vertices.add(electronica);
		vertices.add(geologica);
		vertices.add(letras);
		vertices.add(metalurgica);
		vertices.add(minas);
		vertices.add(odontologia);
		vertices.add(psicologia);
		vertices.add(ciencias_economicasA);
		vertices.add(electronica2);
		vertices.add(civil);
		vertices.add(mecanica_fluidos);

		// Para minas
		// Con psicologia
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

		grafo.setGraph(vertices);

		ManejadorArchivos<Establecimiento> ma = new ManejadorArchivos<>();
		ma.guardarDatosList(vertices, "grafo.dat");
	}

	public static void main(String[] args) {
		InicializarGrafo gf = new InicializarGrafo();
		gf.inicializarEstablecimientos();
	}
}