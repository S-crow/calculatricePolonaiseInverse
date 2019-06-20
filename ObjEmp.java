public class ObjEmp {

	private int obj;

	public ObjEmp(int obj){
		this.obj=obj;
	}	

	public int get(){
		return this.obj;
	}	

	public void  add(ObjEmp obj){

		this.obj+=obj.get();

	}
	public void sous(ObjEmp obj){
		this.obj-=obj.get();
	}
	public void div(ObjEmp obj){
		this.obj/=obj.get();
	}
	public void mul(ObjEmp obj){
		this.obj*=obj.get();
	}
	public String toString(){
		return "" + obj;

	}			




}
