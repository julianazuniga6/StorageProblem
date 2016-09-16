
public class Descargador extends Thread {

	private Bodega b;

	public Descargador(Bodega bod) {
		b = bod;
	}

	@Override
	public void run() {

		while (true) {

			try {
				sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int t = (int) (Math.random() * 2);

			if (t == 0) {
				b.descargarArticulo(1);
			} else {
				b.descargarArticulo(2);
			}

		}
	}

}
