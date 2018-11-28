package algoritmos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JogosSemGanhar {

	private int[] pos;
	private int contagens;
	private int nowins;

	public JogosSemGanhar(int contagens, int nowins) {
		this.contagens = contagens;
		this.nowins=nowins;
		pos = new int[5];
	}

	public void gerar() {
		int no_wins;
		if(nowins<=20)
			no_wins=nowins;
		else
			no_wins=20;
		 
		int contador = 0;
		try {
			while (contador < contagens) {
				double num = (Math.random() * 100);

				if (num < 45 - 2 * no_wins) // sair na posição 0
					pos[0] += 1;
				else if (num >= 45 - 2 * no_wins && num < 47.5 - no_wins) // sair na posição 1
					pos[1] += 1;
				else if (num >= 47.5 - no_wins && num < 52.5 + no_wins) //  sair na posição 2
					pos[2] += 1;
				else if (num >= 52.5 + no_wins && num < 55 + 2 * no_wins) //  sair na posição 3
					pos[3] += 1;
				else if (num >= 55 + 2 * no_wins) //  sair na posição 4
					pos[4] += 1;
				Thread.sleep(1);
				contador++;
			}
			System.out.println("Mostrando os resultados para " + nowins + " jogo(s) sem ganhar");
			for (int i = 0; i < pos.length; i++)
				System.out.println("posição " + i + " tem " + pos[i] + " ocorrências");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		escreveFicheiro();
	}
	
	
	public int gerarJogosSemGanhar(int no_wins) {
		
		if(nowins<=20)
			no_wins=nowins;
		else
			no_wins=20;
		
		double num = (Math.random() * 100);

		if (num < 45 - 2 * no_wins) // sair na posição 0
			return 0;
		else if (num >= 45 - 2 * no_wins && num < 47.5 - no_wins) // sair na posição 1
			return 1;
		else if (num >= 47.5 - no_wins && num < 52.5 + no_wins) //  sair na posição 2
			return 2;
			else if (num >= 52.5 + no_wins && num < 55 + 2 * no_wins) //  sair na posição 3
			return 3;
		
		//Provavelmente tem de ser s� else return 4; But I can't compile....
		else if (num >= 55 + 2 * no_wins) //  sair na posição 4
			return 4;
		
		
	}
	
	
	
	private void escreveFicheiro() {
		try {
			PrintWriter outFile = new PrintWriter(new FileWriter("jogossemganhar.txt"));

			outFile.println(pos[0]);
			outFile.println(pos[1]);
			outFile.println(pos[2]);
			outFile.println(pos[3]);
			outFile.println(pos[4]);

			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		final int JOGOS_SEM_GANHAR = 10;
		JogosSemGanhar j = new JogosSemGanhar(1000, JOGOS_SEM_GANHAR);
		j.gerar();
	}

}
