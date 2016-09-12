
public class Bodega {

	public final int CAPACIDAD = 200;
	public final int ESPACIO_T1 = 10;
	public final int ESPACIO_T2 = 15;

	private int articulosT1;
	private int articulosT2;
	private boolean waitForItEmpacador;
	private boolean waitForItDescargadorT1;
	private boolean waitForItDescargadorT2;

	public Bodega() {
		articulosT1 = 0;
		articulosT2 = 0;
		waitForItEmpacador = true;
		waitForItDescargadorT1 = false;
		waitForItDescargadorT2 = false;
	}

	public void descargarArticulo(int type) {

		switch (type) {

		case 1:

			while (waitForItDescargadorT1) {
				
			}			
			articulosT1++;

		case 2:
			
			while (waitForItDescargadorT2) {
				
			}
			articulosT2++;
		}
		
		waitForItEmpacador = (articulosT1 < 3) && (articulosT2 < 4);

	}

	public void crearPaquete() {

		while (waitForItEmpacador) {

		}
		
		articulosT1-=3;
		articulosT2-=4;
		
		waitForItDescargadorT1= articulosT1*ESPACIO_T1+articulosT2*ESPACIO_T2 +ESPACIO_T1 > CAPACIDAD;
		waitForItDescargadorT2= articulosT1*ESPACIO_T1+articulosT2*ESPACIO_T2 +ESPACIO_T2 > CAPACIDAD;

	}

}
