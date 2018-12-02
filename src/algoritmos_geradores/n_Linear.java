package algoritmos_geradores;

import java.util.ArrayList;

public class n_Linear {

	private double declive;
	private ArrayList<Double> resultados;

	public n_Linear(double declive) {
		this.declive = declive;
		resultados = new ArrayList<Double>();
	}

	public void gerar(double x) {
		double resultado = 0.0;
		resultado = declive * x;
		resultados.add(resultado);
	}
	
	public double gerarn_Linear() {
		double declive = 0.5;
		double x = 5;
		double amostra = 0.0;
		amostra = declive * x;
		
		return amostra;
	}

	public static void main(String[] args) {
		double declive = 0.5;
		double x = 5;
		n_Linear l = new n_Linear(declive);
		l.gerar(x);
	}

}
