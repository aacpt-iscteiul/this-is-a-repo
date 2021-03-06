package algoritmos;

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
	}

	public static void main(String[] args) {
		final int JOGOS_SEM_GANHAR = 20;
		JogosSemGanhar j = new JogosSemGanhar(1000, JOGOS_SEM_GANHAR);
		j.gerar();
	}

}
