import java.io.*;
import java.util.Scanner;
import java.lang.String;
import java.util.concurrent.TimeUnit;

public class Calculatrice {
	public static Scanner scanner = new Scanner(System.in);
	public static Scanner sc = new Scanner(System.in);
	public static File file = new File("./log.txt");


	public static void main(String[]args){

		/*Test pour la pile

		  PileRPL pile = new PileRPL(3);
		  ObjEmp obj1 = new ObjEmp(27);
		  ObjEmp obj2 = new ObjEmp(3);
		  pile.empile(obj1);
		  pile.empile(obj2);

		  System.out.println(pile);
		  pile.division();
		  System.out.println(pile);	
		 */		
		char  mode = ' ';
		do{

			do{

				System.out.println("\n\n=====================================================\n");
				System.out.println("==================  Calculatrice  ===================\n"); 
				System.out.println("=====================================================\n");


				System.out.println("Choisissez le mode de conversion :\n");
				System.out.println("1 - Calculatrice en mode local ");
				System.out.println("2 - Calculatrice en mode réseau ");
				System.out.println("3 - Charger session précèdente");
				System.out.println("4 - Quitter");
				mode = sc.nextLine().charAt(0);


			}while (mode!='1' && mode!='2' && mode!='3' && mode!='4');



			switch (mode) {
				case '1':
					System.out.println("\nVous avez choisi le mode local\n");
					calculatrice();

					break;
				case '2':
					System.out.println("\nVous avez choisi le mode réseau\n");

					Server serveur = new Server(2009);
					try {
						TimeUnit.MINUTES.sleep(1);
					} catch (Exception e) {}	
					break;
				case '3':
					System.out.println("\nChargement de la dernière session...\n");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch	(Exception e){}
					
					try{
						Fichier.lireFichierLog(file);
					} catch(IOException exc){
						System.out.println("Impossible d'ouvrir le fichier");
					}

					calculatrice();

					break;
				case '4':
					System.out.println("A bientôt \n");
					break;
			}
		} while( mode!='4');
		System.exit(-1);
	}




	static void calculatrice(){
		String saisieClavier;
		String log="";
		FileWriter fw;

		do{
			String str = "\nEntrez un calcul : \n(ou 'q' pour quitter) ";
			System.out.println(str);

			saisieClavier=scanner.nextLine();

			if(!saisieClavier.equals("q")){	
				String result = "= " + Calc.calc(saisieClavier);

				System.out.println(result);

				log +=str+"\n"+saisieClavier+"\n\n"+result+"\n";
			}
		} while(!(saisieClavier.length() == 0) && !saisieClavier.equals("q"));


		try{
			fw = new FileWriter(file);
			fw.write(log);
			fw.close();
		} catch (IOException e){}	



	}	

	static void calculatrice(PrintWriter out, BufferedReader in){
		String saisieClavier=null;
		String log="";
		FileWriter fw;

		do{

			String str = "\nEntrez un calcul : \n(ou 'q' pour quitter)";
			out.println(str);

			try{
				saisieClavier=in.readLine();
			}catch (IOException e) {
				e.printStackTrace();
			}

			if(!saisieClavier.equals("q")){ 
				String result = "= " + Calc.calc(saisieClavier);

				out.println(result);

				log +=str+"\n"+saisieClavier+"\n\n"+result+"\n";
			}
		} while(!(saisieClavier.length() == 0) && !saisieClavier.equals("q"));


		try{
			fw = new FileWriter(file);
			fw.write(log);
			fw.close();
		} catch (IOException e){}	
		//System.exit(1);
	}

}	
