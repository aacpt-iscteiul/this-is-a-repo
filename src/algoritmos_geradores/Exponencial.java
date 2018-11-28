package algoritmos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Exponencial { // ++++++++++ INTERVALO DE 25K A 30K ++++++++++++++++

	private double lambda;
	private int numAmostras;
	private double inicio;
	private ArrayList<Integer> resultados;

	public Exponencial(double inicio, double lambda, int numAmostras) {
		this.lambda = lambda;
		this.numAmostras = numAmostras;
		this.inicio = inicio;
		resultados = new ArrayList<Integer>();
	}

	public void gerar() {
		for (int i = 0; i < numAmostras; i++) {
			double amostra = inicio + Math.log(1 - Math.random()) / (-lambda);
			amostra = (int) (amostra * 1000);
			while (amostra > 30000) {
				amostra = inicio + Math.log(1 - Math.random()) / (-lambda);
				amostra = (int) (amostra * 1000);
			}
			resultados.add((int) amostra);
			System.out.println((int) amostra);
		}
		escreveFicheiro();
	}
	
	public double gerarExponencial() {
		
		double lambda = 1.0;
		double inicio = 25.0;
		
		double amostra = inicio + Math.log(1 - Math.random()) / (-lambda);
		amostra = (int) (amostra * 1000);
		while (amostra > 30000) {
			amostra = inicio + Math.log(1 - Math.random()) / (-lambda);
			amostra = (int) (amostra * 1000);
		}
		
		return amostra;
		
	}

	private void escreveFicheiro() {
		try {
			PrintWriter outFile = new PrintWriter(new FileWriter("exponencial.txt"));

			for (double a : resultados)
				outFile.println(a + ", ");

			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		double lambda = 0.0015;
//		double inicio = 25000.0;
		double lambda = 1.0;
		double inicio = 25.0;
		int numAmostras = 1000;
		Exponencial e = new Exponencial(inicio, lambda, numAmostras);
		e.gerar();
	}

}
