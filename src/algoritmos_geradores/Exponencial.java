package algoritmos;

import java.util.ArrayList;

public class Exponencial { // ++++++++++ INTERVALO DE 25K A 30K ++++++++++++++++

	private double lambda;
	private int numAmostras;
	private double inicio;
	private ArrayList<Double> resultados;

	public Exponencial(double inicio, double lambda, int numAmostras) {
		this.lambda = lambda;
		this.numAmostras = numAmostras;
		this.inicio = inicio;
		resultados = new ArrayList<Double>();
	}

	public void gerar() {
		for (int i = 0; i < numAmostras; i++) {
			double amostra = inicio + Math.log(1 - Math.random()) / (-lambda);
			amostra = (int) (amostra * 1000);
			while (amostra > 30000) {
				amostra = inicio + Math.log(1 - Math.random()) / (-lambda);
				amostra = (int) (amostra * 1000);
			}
			resultados.add(amostra);
			System.out.println(amostra);
			
		}

	}

	public static void main(String[] args) {
//		double lambda = 0.0015;
//		double inicio = 25000.0;
		double lambda = 1.0;
		double inicio = 25.0;
		int numAmostras = 100;
		Exponencial e = new Exponencial(inicio, lambda, numAmostras);
		e.gerar();
	}

}
