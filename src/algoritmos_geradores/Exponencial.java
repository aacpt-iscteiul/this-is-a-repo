package algoritmos_geradores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Exponencial { // ++++++++++ INTERVALO DE 25K A 30K ++++++++++++++++

	private double lambda;
	private int numAmostras;
	private double inicio;
	private ArrayList<Integer> resultados;
	double soma = 0.0;

	public Exponencial(double inicio, double lambda, int numAmostras) {
		this.lambda = lambda;
		this.numAmostras = numAmostras;
		this.inicio = inicio;
		resultados = new ArrayList<Integer>();
	}

//	public void gerar() {
//		for (int i = 0; i < numAmostras; i++) {
//			double amostra = inicio + Math.log(1 - Math.random()) / (-lambda);
//			amostra = (int) (amostra * 1000);
//			while (amostra > 30000) {
//				amostra = inicio + Math.log(1 - Math.random()) / (-lambda);
//				amostra = (int) (amostra * 1000);
//			}
//			resultados.add((int) amostra);
//			System.out.println((int) amostra);
//		}
//		escreveFicheiro();
//	}

	public void gerar() {
		for (int i = 0; i < numAmostras; i++) {
			double amostra = inicio - lambda * Math.log(Math.random());
			while (amostra > 30000) {
				amostra = inicio - lambda * Math.log(Math.random());
			}
			resultados.add((int) amostra);
			System.out.println(amostra);
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
			PrintWriter outFile = new PrintWriter(new FileWriter("exponencial" + numAmostras + ".txt"));

			for (double a : resultados)
				outFile.println(a + ", ");

			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("exponencial" + numAmostras + ".txt escrito em disco");
		for (int r : resultados) {
			soma += r;
		}
		System.out.println("media=" + soma / numAmostras);
	}

	public static void main(String[] args) {
//		double lambda = 0.0015;
//		double inicio = 25000.0;
		double lambda = 1000;
		double inicio = 25000.0;
		int numAmostras = 10000;
		Exponencial e = new Exponencial(inicio, lambda, numAmostras);
		e.gerar();
	}

}
