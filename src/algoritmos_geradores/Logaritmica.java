package algoritmos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Logaritmica {

	private double xMin;
	private double xMax;
	private int numAmostras;
	private ArrayList<Double> resultados;

	public Logaritmica(double xMin, double xMax, int numAmostras) {
		this.xMax = xMax;
		this.xMin = xMin;
		this.numAmostras = numAmostras;
		resultados = new ArrayList<Double>();
	}

	public void gerar() {
		double a = xMin;
		double b = xMax - xMin;
		for (int i = 0; i < numAmostras; i++) {
			double amostra = a + b * Math.random() * Math.random();
			amostra = (int) (amostra * 1000);
			while(amostra < 15000 || amostra > 20000) {
				amostra = a + b * Math.random() * Math.random();
				amostra = (int) (amostra * 1000);
			}
			System.out.println(amostra);
			resultados.add(amostra);
		}
		escreveFicheiro();
	}
	
	private void escreveFicheiro() {
		try {
			PrintWriter outFile = new PrintWriter(new FileWriter("logaritmica.txt"));

			for (double a : resultados)
				outFile.println(a + ", ");

			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		double xMin = 15.0;
		double xMax = 20.0;
		int numAmostras = 1000;
		Logaritmica l = new Logaritmica(xMin, xMax, numAmostras);
		l.gerar();
	}

}
