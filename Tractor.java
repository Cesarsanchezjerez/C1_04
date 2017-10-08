package hito1;

public class Tractor {
	
	
	private boolean norte=true;
	private boolean sur=true;
	private boolean este=true;
	private boolean oeste=true;
	
	public void posiblesmovimientos(int x, int y, int c,int f){
		
		if(x==0) {
			norte=false;
		}
		if(x==f-1) {
			sur=false;
		}
		if(y==0) {
			oeste=false;
		}
		if(y==c-1) {
			este=false;
		}
	}
	public boolean getnorte() {
		return norte;
	}
	public boolean getsur() {
		return sur;
	}
	public boolean geteste() {
		return este;
	}
	public boolean getoeste() {
		return oeste;
	}
}
