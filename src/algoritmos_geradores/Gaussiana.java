package algoritmos;

import java.util.ArrayList;
import java.util.Random;

public class Gaussiana {

	private int contador;
	private ArrayList<Double> resultados;

	public Gaussiana(int contador) {
		this.contador = contador;
		resultados = new ArrayList<Double>();
	}

	public void gerar(double dp, double media, double min, double max) throws InterruptedException {
		int count = 0;
		while (count < contador) {
			Random r = new Random();
			double amostra = r.nextGaussian() * dp + media;
			while (amostra < min || amostra > max) {
				r = new Random();
				amostra = r.nextGaussian() * dp + media;
			}
			count++;
			resultados.add(amostra);
			System.out.println(amostra);
		}
	}

	public static void main(String[] args) {
		Gaussiana g = new Gaussiana(100);
		try {
			g.gerar(0.2, 5.0, 4.0, 6.0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
