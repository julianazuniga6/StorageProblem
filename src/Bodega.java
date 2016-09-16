
public class Bodega {

	public final int CAPACIDAD = 200;
	public final int ESPACIO_T1 = 10;
	public final int ESPACIO_T2 = 15;

	private int articulosT1;
	private int articulosT2;
	private boolean puedeEmpacar;
	private boolean waitForItDescargadorT1;
	private boolean waitForItDescargadorT2;

	private Descargador des;
	private Empacador emp;
	
	public Bodega() {
		articulosT1 = 0;
		articulosT2 = 0;
		puedeEmpacar = false;
		waitForItDescargadorT1 = false;
		waitForItDescargadorT2 = false;
		
		des = new Descargador(this);
		emp = new Empacador(this);
		
		des.start();
		emp.start();
	}

	public void descargarArticulo(int type) {

		switch (type) {

		case 1:
			
			while (waitForItDescargadorT1) {
				
			}			
			articulosT1++;
			System.out.println("Hay "+articulosT1+" tipo 1");
			break;
		case 2:
						
			while (waitForItDescargadorT2) {
				
			}
			articulosT2++;
			System.out.println("Hay "+articulosT2+" tipo 2");
			break;
		}
		
		puedeEmpacar = (articulosT1 >= 3) && (articulosT2 >= 4);
		System.out.println("******** "+puedeEmpacar+" ********");

	}

	public void crearPaquete() {
		
		boolean b=puedeEmpacar;
		while (!b) {
			b=puedeEmpacar;
						
		}
		
		System.err.println("CREANDO PAQUETE");
//		if(puedeEmpacar){
			System.err.println("PAQUETE CREADO!!");
			articulosT1-=3;
			articulosT2-=4;
			waitForItDescargadorT1= articulosT1*ESPACIO_T1+articulosT2*ESPACIO_T2 +ESPACIO_T1 > CAPACIDAD;
			waitForItDescargadorT2= articulosT1*ESPACIO_T1+articulosT2*ESPACIO_T2 +ESPACIO_T2 > CAPACIDAD;
			puedeEmpacar = (articulosT1 >= 3) && (articulosT2 >= 4);
//		}else{
//			
//		}

	}

	public static void main(String[] args) {
		Bodega	b = new Bodega();
	}
	
}
