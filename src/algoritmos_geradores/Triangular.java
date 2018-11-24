package algoritmos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Triangular { // ++++++++++ INTERVALO DE 5K A 10K ++++++++++++++++

	private double xMax;
	private double xMin;
	private double c;
	private int numAmostras;
	private ArrayList<Integer> resultados;

	public Triangular(double xMax, double xMin, double c, int numAmostras) {
		this.xMax = xMax;
		this.xMin = xMin;
		this.c = c;
		this.numAmostras = numAmostras;
		resultados = new ArrayList<Integer>();
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
			resultados.add((int) amostra);
		}
		escreveFicheiro();
		System.out.println("processamento terminou");
	}

	private void escreveFicheiro() {
		try {
			PrintWriter outFile = new PrintWriter(new FileWriter("triangular.txt"));

			for (double a : resultados)
				outFile.println(a + ", ");

			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		double xMin = 5000.;
		double xMax = 10000.;
		double c = 6500.; // Moda
		int numAmostras = 1000;

		Triangular t = new Triangular(xMax, xMin, c, numAmostras);
		t.gerar();
	}

}
