public class PileRPL implements Pile {

	private ObjEmp[] pile;
	public int top=-1;
	private int taillePile;

	public PileRPL(int max){
		taillePile=max;
		top=-1;
		pile = new ObjEmp[taillePile];


	}	

	public void empile(ObjEmp obj) {
		if(top == taillePile -1){
			System.out.println("pile pleine");
			System.exit(-1);
		}
		else{
			top++;
			pile[top]=obj;

		}	
	}


	public void depile() {
		if(isEmpty()){
			System.out.println("pile vide");
			System.exit(-1);
		}
		else{
			top--;
		}	

	}

	public void addition(){

		pile[top-1].add(pile[top]);

	}	

	public void  soustraction(){

		pile[top-1].sous(pile[top]);	
	}	

	public void multiplication(){

		pile[top-1].mul(pile[top]);	

	}

	public void division(){
		pile[top-1].div(pile[top]);
	}

	public boolean isEmpty(){
		return (top == -1);

	}	
	public ObjEmp getTop(){
		if(isEmpty()){
			System.out.println("la pile est vide");
			System.exit(-1);
		}	
		return pile[top];

	}
	public ObjEmp getResult(){
		return pile[top+1];

	}	
	public String toString(){
		String result="";
		for (int i=taillePile-1;i>=0;i--){
			result+=""+(i+1)+":"+pile[i]+"\n";
		}
		return result;	

	}
}
