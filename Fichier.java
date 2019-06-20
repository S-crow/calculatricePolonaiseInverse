import java.io.*;

public class Fichier {

       	
	public static void lireFichierLog(File log) throws IOException {

	BufferedReader lecteur = null;
	String line;

	try {
		lecteur = new BufferedReader(new FileReader(log));
	} catch(FileNotFoundException exc) {
		System.out.println("le fichier n'existe pas");
		System.out.println(-1);
	}	
        

		
	while((line=lecteur.readLine()) != null)
		System.out.println(line);
	
	lecteur.close();
	
	}	



}	
