package algoritmos_geradores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JogosSemGanharV2 {

	private int[] pos;
	private int contagens;
	private int nowins;

	public JogosSemGanharV2(int contagens, int nowins) {
		this.contagens = contagens;
		this.nowins = nowins;
		pos = new int[5];
	}

	public int gerarJogosSemGanhar(int no_wins) {

		if (nowins <= 20)
			no_wins = nowins;
		else
			no_wins = 20;

		double num = (Math.random() * 100);

		if (num < 45 - 2 * no_wins) // sair na posicao 0
			return 0;
		else if (num >= 45 - 2 * no_wins && num < 49 - no_wins) // sair na posicao 1
			return 1;
		else if (num >= 49 - no_wins && num < 51 + no_wins) // sair na posicao 2
			return 2;
		else if (num >= 51 + no_wins && num < 55 + 2 * no_wins) // sair na posicao 3
			return 3;

		// Provavelmente tem de ser s else return 4; But I can't compile....
		// else if (num >= 55 + 2 * no_wins) // sair na posicao 4
		else
			return 4;

	}

	private void escreveFicheiro() {
		try {
			PrintWriter outFile = new PrintWriter(
					new FileWriter("jogossemganharV2_" + nowins + "_" + contagens + ".txt"));

			outFile.println(pos[0] + ",");
			outFile.println(pos[1] + ",");
			outFile.println(pos[2] + ",");
			outFile.println(pos[3] + ",");
			outFile.println(pos[4] + ",");
			outFile.println(" " + ",");
			outFile.println(nowins + ",");

			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("jogossemganharV2_" + nowins + "_" + contagens + ".txt escrito em disco");
	}

//	System.out.println("Mostrando os resultados para " + nowins + " jogo(s) sem ganhar");
//	for (int i = 0; i < pos.length; i++)
//		System.out.println("posicao " + i + " tem " + pos[i] + " ocorrências");

	public void gerar() {
		if (nowins > 20)
			nowins = 20;
		int contador = 0;
		while (contador < contagens) {
			double num = (Math.random() * 100);
			if (num < 45 - 2 * nowins)                            // sair na posicao 0
				pos[0] += 1;
			else if (num >= 45 - 2 * nowins && num < 49 - nowins) // sair na posicao 1
				pos[1] += 1;
			else if (num >= 49 - nowins && num < 51 + nowins)     // sair na posicao 2
				pos[2] += 1;
			else if (num >= 51 + nowins && num < 55 + 2 * nowins) // sair na posicao 3
				pos[3] += 1;
			else if (num >= 55 + 2 * nowins)                      // sair na posicao 4
				pos[4] += 1;
			contador++;
		}
		escreveFicheiro();
	}

	public static void main(String[] args) {
		int contagens = 10000;
		final int NO_WINS = 20;
		JogosSemGanharV2 j = new JogosSemGanharV2(contagens, NO_WINS);
		j.gerar();
	}

}
