package webSemantica;



import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class query {
	// create an empty model
	
	
//	String inputFileName = "output.ttl";

	// use the RDFDataMgr to find the input file
//	InputStream in = RDFDataMgr.open(inputFileName).getInputStream();
//	if (RDFDataMgr.open(inputFileName).getInputStream() == null) {
//		throw new IllegalArgumentException(
//				"File: " + inputFileName + " not found");
//	}
	
	
//	Model model =  RDFDataMgr.loadModel("output-with-links.nt");
	public static void main(int [] args) {
		Model m = ModelFactory.createDefaultModel();
		m.read("output.ttl");
		m.write(System.out);
	}
}
