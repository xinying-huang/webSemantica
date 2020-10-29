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
		model.read("zonasverdes.ttl");
		//model.write(System.out);
	    String querystring = "SELECT DISTINCT ?Distrito ?Subepigrafe ?Apartado\r\n" + 
	    		"WHERE {\r\n" + 
	    		"	?Distrito a <http://group56.org/zonas-verdes/Distrito>.\r\n" + 
	    		"	?Distrito a <http://group56.org/zonas-verdes/Distrito>.\r\n" + 
	    		"}";
	    Query query = QueryFactory.create(querystring);
	    QueryExecution qexec = QueryExecutionFactory.create(query, model);
	    try {
	    	ResultSet results = qexec.execSelect();
	    	while (results.hasNext()) {
	    		QuerySolution soln = results.nextSolution();
	    		Resource name = soln.getResource("Distrito");
	    		System.out.println(name.getLocalName());
	    	}
	    } finally {
	    	qexec.close();
	    }
	    
		
	}
}
