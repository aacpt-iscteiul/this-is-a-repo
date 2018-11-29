package algoritmos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Coseno {

	private double xMax;
	private double xMin;
	private int numAmostras;
	private ArrayList<Integer> resultados;

	public Coseno(double xMax, double xMin, int numAmostras) {
		this.xMax = xMax;
		this.xMin = xMin;
		this.numAmostras = numAmostras;
		resultados = new ArrayList<Integer>();
	}

	public void gerar() {

		double a = 0.5 * (xMin + xMax); 		// parametro de localização = moda/média
		double b = (xMax - xMin) / Math.PI; 	// parametro de escala
		for (int i = 0; i < numAmostras; i++) {
			double amostra = a + b * Math.asin(1.0 - Math.random() * 2);
			resultados.add((int)amostra);
			System.out.println(amostra);
		}
		escreveFicheiro();

	}
	
	public double gerarCos() {
		
		double xMin = 10000.;
		double xMax = 15000.;
		double a = 0.5 * (xMin + xMax); 		// parametro de localização = moda/média
		double b = (xMax - xMin) / Math.PI; 	// parametro de escala
		double amostra = a + b * Math.asin(1.0 - Math.random() * 2);
		
		return amostra;
	}
	
	private void escreveFicheiro() {
		try {
			PrintWriter outFile = new PrintWriter(new FileWriter("coseno" + numAmostras + ".txt"));

			for (double a : resultados)
				outFile.println(a + ", ");

			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("coseno" + numAmostras + ".txt escrito em disco");
	}

	public static void main(String[] args) {

		double xMin = 10000.;
		double xMax = 15000.;
		int numAmostras = 10000;

		Coseno c = new Coseno(xMax, xMin, numAmostras);
		c.gerar();
	}

}
