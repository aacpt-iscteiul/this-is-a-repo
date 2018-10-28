package algoritmos;

import java.util.ArrayList;

public class Linear {

	private double declive;
	private ArrayList<Double> resultados;

	public Linear(double declive) {
		this.declive = declive;
		resultados = new ArrayList<Double>();
	}

	public void gerar(double x) {
		double resultado = 0.0;
		resultado = declive * x;
		resultados.add(resultado);
	}

	public static void main(String[] args) {
		double declive = 0.5;
		double x = 5;
		Linear l = new Linear(declive);
		l.gerar(x);
	}

}
