package algoritmos;

import java.util.ArrayList;

public class Triangular { // ++++++++++ INTERVALO DE 5K A 10K ++++++++++++++++

	private double xMax;
	private double xMin;
	private double c;
	private int numAmostras;
	private ArrayList<Double> resultados;

	public Triangular(double xMax, double xMin, double c, int numAmostras) {
		this.xMax = xMax;
		this.xMin = xMin;
		this.c = c;
		this.numAmostras = numAmostras;
		resultados = new ArrayList<Double>();
	}

	public void gerar() {
		for (int i = 0; i < numAmostras; i++) {
			double amostra;
			double p = Math.random();
			double q = 1. - p;
			if (p <= (c - xMin) / (xMax - xMin)) {
				amostra = xMin + Math.sqrt((xMax - xMin) * (c - xMin) * p);
			} else {
				amostra = xMax - Math.sqrt((xMax - xMin) * (xMax - c) * q);
			}
			resultados.add(amostra);
			System.out.println(amostra);
		}

	}

	public static void main(String[] args) {

		double xMax = 15000.;
		double xMin = 10000.;
		double c = 11000.;      // Moda
		int numAmostras = 100;

		Triangular t = new Triangular(xMax, xMin, c, numAmostras);
		t.gerar();
	}

}
