package algoritmos;

public class Diamante {

	private int[] pos;
	private int contagens;
	private Double pct1;
	private Double pct2;
	private Double pct3;

	public Diamante(int contagens, Double pct1, Double pct2, Double pct3) {
		this.contagens = contagens;
		this.pct1 = pct1;
		this.pct2 = pct2;
		this.pct3 = pct3;
		pos = new int[5];
	}

	public void gerar() {
		int contador = 0;
		try {
			while (contador < contagens) {
				double num = (Math.random() * 100);
				System.out.println((int) num);
				if (num < pct1) // 45% probabilidade de sair na posição 0
					pos[0] += 1;
				else if (num >= pct1 && num < (pct1 + pct2)) // 2.5% probabilidade de sair na posição 1
					pos[1] += 1;
				else if (num >= (pct1 + pct2) && num < (pct1 + pct2 + pct3)) // 5% probabilidade de sair na posição 2
					pos[2] += 1;
				else if (num >= (pct1 + pct2 + pct3) && num < (100 - pct1)) // 2.5% probabilidade de sair na posição 3
					pos[3] += 1;
				else if (num >= (100 - pct1)) // 45% probabilidade de sair na posição 4
					pos[4] += 1;
				Thread.sleep(1);
				contador++;
			}
			for (int i = 0; i < pos.length; i++)
				System.out.println("posição " + i + " tem " + pos[i] + " ocorrências");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Double pct1 = 45.0;
		Double pct2 = 2.5;
		Double pct3 = 5.0;

//		Double pct1 = 40.0;
//		Double pct2 = 4.0;
//		Double pct3 = 8.0;

		int contagens = 1000;

		Diamante d = new Diamante(contagens, pct1, pct2, pct3);
		d.gerar();
	}

}
