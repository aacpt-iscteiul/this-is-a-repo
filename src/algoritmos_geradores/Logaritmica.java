package algoritmos;

import java.util.ArrayList;

public class Logaritmica {

	private double xMin;
	private double xMax;
	private int numAmostras;
	private ArrayList<Double> amostraados;

	public Logaritmica(double xMin, double xMax, int numAmostras) {
		this.xMax = xMax;
		this.xMin = xMin;
		this.numAmostras = numAmostras;
		amostraados = new ArrayList<Double>();
	}

	public void gerar() {
		double a = xMin;
		double b = xMax - xMin;
		for (int i = 0; i < numAmostras; i++) {
			double amostra = a + b * Math.random() * Math.random();
			amostra = (int) (amostra * 1000);
			System.out.println(amostra);
			amostraados.add(amostra);
		}
	}

	public static void main(String[] args) {
		double xMin = 15.0;
		double xMax = 20.0;
		int numAmostras = 100;
		Logaritmica l = new Logaritmica(xMin, xMax, numAmostras);
		l.gerar();
	}

}
