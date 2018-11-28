package algoritmos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
			resultados.add(round(amostra, 2));
			System.out.println(round(amostra, 2));
		}
		escreveFicheiro();
	}
	
	public double gerarGaussiana() {
		
		double dp = 0.2;
		double media = 5.0;
		double min = 4.0;
		double max = 6.0;
		
		
		Random r = new Random();
		double amostra = r.nextGaussian() * dp + media;
		
		
		//amostra = round(amostra, 2); //Implement this?
		return amostra;
		
		
	}
	
	private void escreveFicheiro() {
		try {
			PrintWriter outFile = new PrintWriter(new FileWriter("gaussiana.txt"));

			for (double a : resultados)
				outFile.println(a + ", ");

			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	public static void main(String[] args) {
		Gaussiana g = new Gaussiana(1000);
		try {
			g.gerar(0.2, 5.0, 4.0, 6.0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
