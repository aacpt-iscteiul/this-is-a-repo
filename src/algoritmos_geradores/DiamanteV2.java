package algoritmos_geradores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DiamanteV2 {

	private int[] pos;
	private int contagens;
	private Double pct1;
	private Double pct2;
	private Double pct3;

	public DiamanteV2(int contagens, Double pct1, Double pct2, Double pct3) {
		this.contagens = contagens;
		this.pct1 = pct1;
		this.pct2 = pct2;
		this.pct3 = pct3;
		pos = new int[5];
	}

	public int gerarPosDiamante() {

		double num = (Math.random() * 100);

		if (num < pct1) // 45% probabilidade de sair na posição 0
			return 0;
		else if (num >= pct1 && num < (pct1 + pct2)) // 4% probabilidade de sair na posição 1
			return 1;
		else if (num >= (pct1 + pct2) && num < (pct1 + pct2 + pct3)) // 2% probabilidade de sair na posição 2
			return 2;
		else if (num >= (pct1 + pct2 + pct3) && num < (100 - pct1)) // 4% probabilidade de sair na posição 3
			return 3;
		// Provavelmente tem de ser só else return 4; But I can't compile....
		// else if (num >= (100 - pct1)) // 45% probabilidade de sair na posição 4
		else
			return 4;

	}

	private void escreveFicheiro() {
		try {
			PrintWriter outFile = new PrintWriter(new FileWriter("diamanteV2_" + contagens + ".txt"));

			outFile.println(pos[0] + ",");
			outFile.println(pos[1] + ",");
			outFile.println(pos[2] + ",");
			outFile.println(pos[3] + ",");
			outFile.println(pos[4] + ",");

			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("diamanteV2_" + contagens + ".txt escrito em disco");
	}

	public void gerar() {
		int contador = 0;
		while (contador < contagens) {
			double num = (Math.random() * 100);

			if (num < pct1)                                              // 45% probabilidade de sair na posição 0
				pos[0] += 1;
			else if (num >= pct1 && num < (pct1 + pct2))                 // 4% probabilidade de sair na posição 1
				pos[1] += 1;
			else if (num >= (pct1 + pct2) && num < (pct1 + pct2 + pct3)) // 2% probabilidade de sair na posição 2
				pos[2] += 1;
			else if (num >= (pct1 + pct2 + pct3) && num < (100 - pct1))  // 4% probabilidade de sair na posição 3
				pos[3] += 1;
			else if (num >= (100 - pct1))                                // 45% probabilidade de sair na posição 4
				pos[4] += 1;
			contador++;
		}
		for (int i = 0; i < pos.length; i++)
			System.out.println("posição " + i + " tem " + pos[i] + " ocorrências");
		escreveFicheiro();
	}

	public static void main(String[] args) {
		Double pct1 = 45.0;
		Double pct2 = 4.0;
		Double pct3 = 2.0;
		int contagens = 10000;

		DiamanteV2 d = new DiamanteV2(contagens, pct1, pct2, pct3);
		d.gerar();
	}

}
