package algoritmos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
			while (amostra > 25000) {
				amostra = loc + esc * Math.sqrt(-Math.log(Math.random()));
				amostra = (int) (amostra * 1000);
			}
			System.out.println(amostra);
			resultados.add(amostra);
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
			PrintWriter outFile = new PrintWriter(new FileWriter("rayleigh.txt"));

			for (double a : resultados)
				outFile.println(a + ", ");

			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		double loc = 20.0; // localização
		double esc = 2.0; // escala
		int numAmostras = 1000;

		Rayleigh ray = new Rayleigh(loc, esc, numAmostras);
		ray.gerar();
	}
}
