
public class Empacador extends Thread{
	
	private Bodega b;
	
	public Empacador(Bodega bod) {
		b=bod;
	}
	
	@Override
	public void run() {
		
		while(true){
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			b.crearPaquete();
			
		}
		
	}

}
