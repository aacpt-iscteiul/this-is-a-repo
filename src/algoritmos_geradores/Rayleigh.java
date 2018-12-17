package algoritmos_geradores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Rayleigh { // +++++++++ INTERVALO DE 20K 25K ++++++++++++++++

	private double loc;
	private double esc;
	private int numAmostras;
	private ArrayList<Integer> resultados;
	private int soma = 0;

	public Rayleigh(double loc, double esc, int numAmostras) {
		this.loc = loc;
		this.esc = esc;
		this.numAmostras = numAmostras;
		resultados = new ArrayList<Integer>();
	}

//	private void gerar() {
//		for (int i = 0; i < numAmostras; i++) {
//			double amostra = loc + esc * Math.sqrt(-Math.log(Math.random()));
//			amostra = (int) (amostra * 1000);
//			while (amostra > 25000) {
//				amostra = loc + esc * Math.sqrt(-Math.log(Math.random()));
//				amostra = (int) (amostra * 1000);
//			}
//			System.out.println((int) amostra);
//			resultados.add((int) amostra);
//		}
//		escreveFicheiro();
//	}

	private void gerar() {
		for (int i = 0; i < numAmostras; i++) {
			double amostra = loc + esc * Math.sqrt(-Math.log(Math.random()));
			while (amostra > 25000) {
				amostra = loc + esc * Math.sqrt(-Math.log(Math.random()));
			}
			System.out.println((int) amostra);
			resultados.add((int) amostra);
		}
		escreveFicheiro();
	}

	public double gerarRayleigh() {
		double loc = 20.0; // localização
		double esc = 2.0; // escala

		double amostra = loc + esc * Math.sqrt(-Math.log(Math.random()));
		amostra = (int) (amostra * 1000);
		while (amostra > 25000) {
			amostra = loc + esc * Math.sqrt(-Math.log(Math.random()));
			amostra = (int) (amostra * 1000);
		}

		return amostra;
	}

	private void escreveFicheiro() {
		try {
			PrintWriter outFile = new PrintWriter(new FileWriter("rayleigh" + numAmostras + ".txt"));

			for (double a : resultados)
				outFile.println(a + ", ");

			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("rayleigh" + numAmostras + ".txt escrito em disco");
		for (int r : resultados) {
			soma += r;
		}
		System.out.println("media=" + soma / numAmostras);
	}

	public static void main(String[] args) {

		double loc = 20000.0; // localização
		double esc = 2000.0; // escala
		int numAmostras = 10000;

		Rayleigh ray = new Rayleigh(loc, esc, numAmostras);
		ray.gerar();
	}
}
