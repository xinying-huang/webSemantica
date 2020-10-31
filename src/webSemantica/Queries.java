package webSemantica;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;

public class Queries {
	
	// Despliegue de distrito
	public static String queryDespliegueD () {
		return "SELECT DISTINCT ?Distrito\r\n" + 
	    		"WHERE {\r\n" + 
	    		"	?Distrito a <http://group56.org/zonas-verdes/Distrito>.\r\n" + 
	    		"}";
	}
	
	public static String queryNarchivo (int narchivo) {
		return "SELECT DISTINCT ?D ?S ?Calle ?Destino ?Naturaleza ?Solar ?Apartado\r\n" + 
				"WHERE {\r\n" + 
				"<http://group56.org/zonas-verdes/Numero_de_archivo/" + narchivo + "> <http://group56.org/zonas-verdes/tieneDistrito> ?Distrito.\r\n" + 
	    		"?Distrito <http://group56.org/zonas-verdes/nombreDistrito> ?D." +
				"?Distrito <http://group56.org/zonas-verdes/tieneSubepigrafe> ?Subepigrafe." +
		        "?Subepigrafe  <http://group56.org/zonas-verdes/nombreSubepigrafe> ?S." +
		        "<http://group56.org/zonas-verdes/Numero_de_archivo/" + narchivo + "> <http://group56.org/zonas-verdes/nombreCalle> ?Calle." +
		        "<http://group56.org/zonas-verdes/Numero_de_archivo/" + narchivo + "> <http://group56.org/zonas-verdes/nombreDestino> ?Destino." +
		        "<http://group56.org/zonas-verdes/Numero_de_archivo/" + narchivo + "> <http://group56.org/zonas-verdes/nombreNaturaleza> ?Naturaleza." +
		        "<http://group56.org/zonas-verdes/Numero_de_archivo/" + narchivo + "> <http://group56.org/zonas-verdes/tamanioSolar> ?Solar." +
		        "<http://group56.org/zonas-verdes/Numero_de_archivo/" + narchivo + "> <http://group56.org/zonas-verdes/nombreApartado>  ?Apartado." +
		        "}";
	}
	
	public static String queryDistrito (String distrito) {
		return "SELECT DISTINCT ?Calle ?N ?Destino ?Naturaleza ?Solar ?Apartado ?S\r\n" + 
	    		" WHERE {\r\n" + 
	    		"?Narchivo <http://group56.org/zonas-verdes/tieneDistrito> <http://group56.org/zonas-verdes/Distrito/"+ distrito +">.\r\n" + 
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreCalle> ?Calle." +
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreDestino> ?Destino." +
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreNaturaleza> ?Naturaleza." +
	    		"?Narchivo <http://group56.org/zonas-verdes/tamanioSolar> ?Solar." +
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreApartado>  ?Apartado." +
	    		"<http://group56.org/zonas-verdes/Distrito/"+ distrito +"> <http://group56.org/zonas-verdes/tieneSubepigrafe> ?Subepigrafe." +
	    		"?Subepigrafe  <http://group56.org/zonas-verdes/nombreSubepigrafe> ?S." +
	    		"?Narchivo <http://group56.org/zonas-verdes/numeroArchivo> ?N." +
	    		"}";
	}
	
	public static String querySolar (int solarmenor, int solarmayor) {
		String query = "SELECT DISTINCT ?D ?Calle ?N ?Destino ?Naturaleza ?Solar ?Apartado ?S\r\n" + 
	    		" WHERE {\r\n" + 
	    		"?Narchivo <http://group56.org/zonas-verdes/tamanioSolar> ?Solar." +
	    		"?Narchivo <http://group56.org/zonas-verdes/tieneDistrito> ?Distrito.\r\n" + 
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreCalle> ?Calle." +
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreDestino> ?Destino." +
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreNaturaleza> ?Naturaleza." +
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreApartado>  ?Apartado." +
	    		"?Distrito <http://group56.org/zonas-verdes/nombreDistrito> ?D." +
	    		"?Distrito <http://group56.org/zonas-verdes/tieneSubepigrafe> ?Subepigrafe." +
	    		"?Subepigrafe  <http://group56.org/zonas-verdes/nombreSubepigrafe> ?S." +
	    		"?Narchivo <http://group56.org/zonas-verdes/numeroArchivo> ?N.";
		if (solarmenor >= 0) {
			query += "FILTER ("+ solarmenor + "<= ?Solar).";
		}
		if (solarmayor >= 0) {
			query += "FILTER ("+ solarmayor + ">= ?Solar).";
		}
		return query += "}";
	}
	
	public static String queryDS (String distrito, int solarmenor, int solarmayor) {
		String query = "SELECT DISTINCT ?Calle ?N ?Destino ?Naturaleza ?Solar ?Apartado ?S\r\n" + 
	    		" WHERE {\r\n" + 
	    		"?Narchivo <http://group56.org/zonas-verdes/tieneDistrito> <http://group56.org/zonas-verdes/Distrito/"+ distrito +">.\r\n" + 
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreCalle> ?Calle." +
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreDestino> ?Destino." +
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreNaturaleza> ?Naturaleza." +
	    		"?Narchivo <http://group56.org/zonas-verdes/tamanioSolar> ?Solar." +
	    		"?Narchivo <http://group56.org/zonas-verdes/nombreApartado>  ?Apartado." +
	    		"<http://group56.org/zonas-verdes/Distrito/"+ distrito +"> <http://group56.org/zonas-verdes/tieneSubepigrafe> ?Subepigrafe." +
	    		"?Subepigrafe  <http://group56.org/zonas-verdes/nombreSubepigrafe> ?S." +
	    		"?Narchivo <http://group56.org/zonas-verdes/numeroArchivo> ?N.";
		if (solarmenor >= 0) {
			query += "FILTER ("+ solarmenor + "<= ?Solar).";
		}
		if (solarmayor >= 0) {
			query += "FILTER ("+ solarmayor + ">= ?Solar).";
		}
		return query += "}";
	}
	

//	public static void main(String[] args) {
//
//		Model model = ModelFactory.createDefaultModel();
//		model.read("output.nt");
//	    
//
//	    String narchivo = "300002";
//	    String distrito = "Centro";
//	    int solarmenor = 100000;
//	    int solarmayor = 500000;
//	    String querystring = "SELECT DISTINCT ?Calle ?N ?Destino ?Naturaleza ?Solar ?Apartado ?S\r\n" + 
//	    		" WHERE {\r\n" + 
//	    		"?Narchivo <http://group56.org/zonas-verdes/tieneDistrito> <http://group56.org/zonas-verdes/Distrito/"+ distrito +">.\r\n" + 
//	    		"?Narchivo <http://group56.org/zonas-verdes/nombreCalle> ?Calle." +
//	    		"?Narchivo <http://group56.org/zonas-verdes/nombreDestino> ?Destino." +
//	    		"?Narchivo <http://group56.org/zonas-verdes/nombreNaturaleza> ?Naturaleza." +
//	    		"?Narchivo <http://group56.org/zonas-verdes/tamanioSolar> ?Solar." +
//	    		"?Narchivo <http://group56.org/zonas-verdes/nombreApartado>  ?Apartado." +
//	    		"<http://group56.org/zonas-verdes/Distrito/"+ distrito +"> <http://group56.org/zonas-verdes/tieneSubepigrafe> ?Subepigrafe." +
//	    		"?Subepigrafe  <http://group56.org/zonas-verdes/nombreSubepigrafe> ?S." +
//	    		"?Narchivo <http://group56.org/zonas-verdes/numeroArchivo> ?N.";
//		if (solarmenor >= 0) {
//			querystring += "FILTER ("+ solarmenor + "<= ?Solar).";
//		}
//		if (solarmayor >= 0) {
//			querystring += "FILTER ("+ solarmayor + ">= ?Solar).";
//		}
//		querystring += "}";
//	    Query query = QueryFactory.create(querystring);
//	    QueryExecution qexec = QueryExecutionFactory.create(query, model);
//	    try {
//	    	ResultSet results = qexec.execSelect();
//	    	while (results.hasNext()) {
//	    		QuerySolution soln = results.nextSolution();
////	    		Resource name = soln.getResource("Distrito");
////	    		System.out.println(name.getLocalName());
//	    		Literal name2 = soln.getLiteral("D");
//	    		System.out.println(name2);
//	    		name2 = soln.getLiteral("S");
//	    		System.out.println(name2);
//	    		name2 = soln.getLiteral("Apartado");
//	    		System.out.println(name2);
//	    		name2 = soln.getLiteral("N");
//	    		System.out.println(name2);
//	    		name2 = soln.getLiteral("Naturaleza");
//	    		System.out.println(name2);
//	    		name2 = soln.getLiteral("Calle");
//	    		System.out.println(name2);
//	    		name2 = soln.getLiteral("Destino");
//	    		System.out.println(name2);
//	    		name2 = soln.getLiteral("Solar");
//	    		System.out.println(name2.getDouble());
//
//	    		System.out.println("---------------------------------");
//	    	}
//	    } finally {
//	    	qexec.close();
//	    }	
//	}
}
