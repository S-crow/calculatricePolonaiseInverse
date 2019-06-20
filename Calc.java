public class Calc {

	public static ObjEmp calc(String saisieClavier) {
		Pile p = new PileRPL(5);
		String str="";

		for (int i = 0; i < saisieClavier.length(); i++) {
			char c = saisieClavier.charAt(i);

			str="";


			while(c!=' ' && (c >= '0') && (c <= '9')){

				str+=c;
				i++;
				try {
					c=saisieClavier.charAt(i);
				} catch (StringIndexOutOfBoundsException e) {}

			}

			try{
				p.empile(new ObjEmp(Integer.parseInt(str)));
			} catch (NumberFormatException e){}


			if ((c == '+') || (c == '-') || (c == '*') || (c == '/')) {   //Si c'est un opérateur on effectue l'opération correspondante


				ObjEmp x=null, y=null;


				// On récupère le second argument
				if (!p.isEmpty()) {
					y = p.getTop();
					p.depile();
				} else {
					System.out.println("Expression incomplète");
					System.exit(-1);
				}

				//On récupère le premier argument
				if (!p.isEmpty()) {
					x = p.getTop();
					p.depile();
				} else {
					System.out.println("Expression incomplète");
					System.exit(-1);
				}

				// On calcule et empile le résultat
				switch (c) {
					case '+':
						x.add(y);
						break;
					case '-':
						x.sous(y);
						break;
					case '*':
						x.mul(y);
						break;
					case '/':
						x.div(y);
						break;
				}

				
			}
			
			System.out.println(p); //On affiche la pile
		}
		return p.getResult();
	}


}	
