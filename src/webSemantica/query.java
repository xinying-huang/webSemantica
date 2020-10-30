package webSemantica;



import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;

public class query {

	public static void main(String[] args) {
		//Model esquema = RDFDataMgr.loadModel("output-with-links.rml");
		//FileOutputStream file = new FileOutputStream(new File("output-with-links.nt"));

//        InputStream in = FileManager.get().open("output-with-links.nt");
//		Model model = ModelFactory.createDefaultModel();
//		model.read(in, null, "N-TRIPLES");
//		model.write(System.out);

		Model model = ModelFactory.createDefaultModel();
		model.read("output.nt");
		
//		// Despliegue de distrito
//	    String querystring1 = "SELECT DISTINCT ?Distrito\r\n" + 
//	    		"WHERE {\r\n" + 
//	    		"	?Distrito a <http://group56.org/zonas-verdes/Distrito>.\r\n" + 
//	    		"}";
//	    Query query1 = QueryFactory.create(querystring1);
//	    QueryExecution qexec1 = QueryExecutionFactory.create(query1, model);
//	    try {
//	    	ResultSet results1 = qexec1.execSelect();
//	    	while (results1.hasNext()) {
//	    		QuerySolution soln = results1.nextSolution();
//	    		Resource name = soln.getResource("Distrito");
//	    		System.out.println(name.getLocalName());
//	    	}
//	    } finally {
//	    	qexec1.close();
//	    }
	    
//------------------------------------------------------------------------------------
	    
	    //Obtiene informacion de calle y numero de archivo por distrito=centro
	    String distrito = "Centro";
	    String querystring2 = "SELECT DISTINCT ?Calle ?n ?Destino ?Naturaleza ?tamanoSolar ?apartado ?s\r\n" + 
	    		" WHERE {\r\n" + 
	    		"?Narchivo <http://group56.org/zonas-verdes/tieneDistrito> <http://group56.org/zonas-verdes/Distrito/"+ distrito +">.\r\n" + 
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreCalle> ?Calle." +
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreDestino> ?Destino." +
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreNaturaleza> ?Naturaleza." +
	    		"?Narchivo <http://group56.org/zonas-verdes/tamanioSolar> ?tamanoSolar." +
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreApartado>  ?apartado." +
	    		"<http://group56.org/zonas-verdes/Distrito/"+ distrito +"> <http://group56.org/zonas-verdes/tieneSubepigrafe> ?Subepigrafe." +
	    		"?Subepigrafe  <http://group56.org/zonas-verdes/nombreSubepigrafe> ?s." +
	    		"?Narchivo <http://group56.org/zonas-verdes/numeroArchivo> ?n." +
	    		"}";
	    Query query2 = QueryFactory.create(querystring2);
	    QueryExecution qexec2 = QueryExecutionFactory.create(query2, model);
	    try {
	    	ResultSet results1 = qexec2.execSelect();
	    	while (results1.hasNext()) {
	    		QuerySolution soln = results1.nextSolution();
	    		Literal name2 = soln.getLiteral("Calle");
	    		System.out.println(name2);
	    		name2 = soln.getLiteral("n");
	    		System.out.println(name2);
	    		name2 = soln.getLiteral("Destino");
	    		System.out.println(name2);
	    		name2 = soln.getLiteral("Naturaleza");
	    		System.out.println(name2);
	    		name2 = soln.getLiteral("tamanoSolar");
	    		System.out.println(name2.getDouble());
	    		name2 = soln.getLiteral("apartado");
	    		System.out.println(name2);
	    		name2 = soln.getLiteral("s");
	    		System.out.println(name2);
	    		System.out.println("---------------------------------");
	    	}
	    } finally {
	    	qexec2.close();
	    }	    
	    
//------------------------------------------------------------------------------------
	    
//	    //Obtiene informacion de calle y numero de archivo por numero de archivo
//	    String narchivo = "301.055";
//	    String querystring3 = "SELECT DISTINCT ?Calle ?Narchivo\r\n" + 
//	    		" WHERE {\r\n" + 
//	    		"?Subepigrafe <http://group56.org/zonas-verdes/numeroArchivo> \"300.000\".\r\n" + 
//	    		"?Subepigrafe <http://group56.org/zonas-verdes/nombreCalle> ?Calle." +
//	    		"?Subepigrafe <http://group56.org/zonas-verdes/numeroArchivo> ?Narchivo." +
//	    		"}";
//	    Query query3 = QueryFactory.create(querystring3);
//	    QueryExecution qexec3 = QueryExecutionFactory.create(query3, model);
//	    try {
//	    	ResultSet results1 = qexec3.execSelect();
//	    	while (results1.hasNext()) {
////	    		QuerySolution soln = results1.nextSolution();
////	    		Resource name = soln.getResource("Subepigrafe");
//	    		QuerySolution soln = results1.nextSolution();
//	    		Literal name2 = soln.getLiteral("Calle");
//	    		System.out.println(name2);
//	    		Literal name3 = soln.getLiteral("Narchivo");
//	    		System.out.println(name3);
//	    		System.out.println("---------------------------------");
//	    	}
//	    } finally {
//	    	qexec3.close();
//	    }	
	    
//------------------------------------------------------------------------------------
	    
////	    //Obtiene informacion de calle y numero de archivo por area/solar
//	    double solarmenor = 30000;
//	    double solarmayor = 2000;
//	    String querystring4 = "SELECT ?Solar ?Calle ?Narchivo\r\n" + 
//	    		" WHERE {\r\n" + 
//	    		"?Subepigrafe <http://group56.org/zonas-verdes/tamanioSolar> ?Solar.\r\n" + 
//	    		"FILTER ("+ solarmenor + "< ?Solar)." +
//	    		"?Subepigrafe <http://group56.org/zonas-verdes/nombreCalle> ?Calle." +
//	    		"?Subepigrafe <http://group56.org/zonas-verdes/numeroArchivo> ?Narchivo." +
//	    		"}";
//	    Query query4 = QueryFactory.create(querystring4);
//	    QueryExecution qexec4 = QueryExecutionFactory.create(query4, model);
//	    try {
//	    	ResultSet results1 = qexec4.execSelect();
//	    	while (results1.hasNext()) {
//	    		QuerySolution soln = results1.nextSolution();
//	    		Literal name2 = soln.getLiteral("Calle");
//	    		System.out.println(name2);
//	    		Literal name3 = soln.getLiteral("Narchivo");
//	    		System.out.println(name3);
//	    		Literal name4 = soln.getLiteral("Solar");
//	    		System.out.println(name4.getDouble() + " m2");
//	    		System.out.println("---------------------------------");
//	    	}
//	    } finally {
//	    	qexec4.close();
//	    }	
		
	}
}
