package algoritmos;

import java.util.ArrayList;

public class Rayleigh { // +++++++++ INTERVALO DE 20K 25K ++++++++++++++++

	private double loc;
	private double esc;
	private int numAmostras;
	private ArrayList<Double> resultados;

	public Rayleigh(double loc, double esc, int numAmostras) {
		this.loc = loc;
		this.esc = esc;
		this.numAmostras = numAmostras;
		resultados = new ArrayList<Double>();
	}

	private void gerar() {
		for (int i = 0; i < numAmostras; i++) {
			double amostra = loc + esc * Math.sqrt(-Math.log(Math.random()));
			amostra = (int) (amostra * 1000);
			if (amostra > 25000)
				amostra = 25000;
			System.out.println(amostra);
			resultados.add(amostra);
		}
	}

	public static void main(String[] args) {
		
		double loc = 20.0;		// localização
		double esc = 2.0;		// escala
		int numAmostras = 100;
		
		Rayleigh ray = new Rayleigh(loc, esc, numAmostras);
		ray.gerar();
	}
}
