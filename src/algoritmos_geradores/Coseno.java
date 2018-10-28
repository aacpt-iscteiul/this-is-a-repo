package algoritmos;

import java.util.ArrayList;

public class Coseno {

	private double xMax;
	private double xMin;
	private int numAmostras;
	private ArrayList<Double> resultados;

	public Coseno(double xMax, double xMin, int numAmostras) {
		this.xMax = xMax;
		this.xMin = xMin;
		this.numAmostras = numAmostras;
		resultados = new ArrayList<Double>();
	}

	public void gerar() {

		double a = 0.5 * (xMin + xMax); 		// parametro de localização = moda/média
		double b = (xMax - xMin) / Math.PI; 	// parametro de escala
		for (int i = 0; i < numAmostras; i++) {
			double amostra = a + b * Math.asin(1.0 - Math.random() * 2);
			resultados.add(amostra);
			System.out.println(amostra);
		}

	}

	public static void main(String[] args) {

		double xMax = 10000.;
		double xMin = 5000.;
		int numAmostras = 100;

		Coseno c = new Coseno(xMax, xMin, numAmostras);
		c.gerar();
	}

}
