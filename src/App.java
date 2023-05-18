import java.util.Scanner;

public class App {

	public static boolean validacao(int l, int c) {
		if (l > 9 || c > 9 || l < 0 || c < 0) {
			return false;
		}
		return true;
	}

	public static boolean insert(int l, int c, Navio n, Tabuleiro t) {
		if(n.linha+l > 9 || n.coluna+c > 9) {
			System.out.println("Seu navio não cabe aqui!!!");
			return false;
		}
		for (int i = l; i <= l + n.linha - 1; i++) {
			for (int j = c; j <= c + n.coluna - 1; j++) {
				if (t.tabuleiro[i][j] == 1) {
					System.out.println("Não se pode colocar um navio sobre o outro capitão.");
					return false;
				}
				t.tabuleiro[i][j] = 1;
			}
		}
		return true;
	}
	
	public static int scanner(Scanner scanner) {
		scanner.hasNextInt();
		while(!scanner.hasNextInt()) {
			System.out.println("Coloque entrada válida");
			scanner.nextLine();
		}
		int numero = scanner.nextInt();
		return numero;		
	}
	
	public static void inserirNavios(Navio n1, Navio n2, Navio n3, Navio n4, Tabuleiro t, int inserirNavios) {
		Scanner scanner = new Scanner(System.in);
		int nl = 0;
		int nc = 0;

		System.out.println("Coloque seus navios de guerra no mar!!!");
		while (inserirNavios <= 4) {
			if (inserirNavios == 1) {
				System.out.println("Seu navio é 1x4");
				System.out.format("Insira a linha do %d navio: ", inserirNavios);
				nl = scanner(scanner);
				

				System.out.format("Insira a coluna do %d navio: ", inserirNavios);
				nc = scanner(scanner);


			}
			if (inserirNavios == 2) {
				System.out.println("Seu navio é 1x1");
				System.out.format("Insira a linha do %d navio: ", inserirNavios);
				nl = scanner(scanner);
	

				System.out.format("Insira a coluna do %d navio: ", inserirNavios);
				nc = scanner(scanner);

			}
			if (inserirNavios == 3) {
				System.out.println("Seu navio é 2x2");
				System.out.format("Insira a linha do %d navio: ", inserirNavios);
				nl = scanner(scanner);


				System.out.format("Insira a coluna do %d navio: ", inserirNavios);
				nc = scanner(scanner);


			}
			if (inserirNavios == 4) {
				System.out.println("Seu navio é 3x2");
				System.out.format("Insira a linha do %d navio: ", inserirNavios);
				nl = scanner(scanner);


				System.out.format("Insira a coluna do %d navio: ", inserirNavios);
				nc = scanner(scanner);

			}

			if (!validacao(nl, nc)) {
				inserirNavios(n1, n2, n3, n4, t, inserirNavios);
			}

			switch (inserirNavios) {
			case 1:
				if(!insert(nl, nc, n1, t))
					inserirNavios(n1, n2, n3, n4, t, inserirNavios);
				break;
			case 2:
				if(!insert(nl, nc, n2, t))
					inserirNavios(n1, n2, n3, n4, t, inserirNavios);
				break;
			case 3:
				if(!insert(nl, nc, n3, t))
					inserirNavios(n1, n2, n3, n4, t, inserirNavios);
				break;
			case 4:
				if(!insert(nl, nc, n4, t))
					inserirNavios(n1, n2, n3, n4, t, inserirNavios);
				break;
			default:
				break;
			}

			System.out.flush();
			inserirNavios++;
		}

	}

	public static boolean disparo(int l, int c, Tabuleiro t) {

		if (t.tabuleiro[l][c] == 1) {
			t.tabuleiro[l][c] = 2;
			return true;
		}
		return false;
	}

	public static boolean endGame(Tabuleiro t, int jogador) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (t.tabuleiro[i][j] == 1) {
					return false;
				}
			}
		}
		
		System.out.println("Parabens você ganhou jogador: "+ jogador);
		return true;
	}

	public static void main(String[] args) {
		Tabuleiro t1 = new Tabuleiro();
		Tabuleiro t2 = new Tabuleiro();

		Navio n1 = new Navio(1, 4);
		Navio n2 = new Navio(1, 1);
		Navio n3 = new Navio(2, 2);
		Navio n4 = new Navio(3, 2);

		Scanner scanner = new Scanner(System.in);

		System.out.println("Jogador 01 pode colocar seus navios no mar");
		inserirNavios(n1, n2, n3, n4, t1, 1);
		System.out.println("Jogador 02 pode colocar seus navios no mar");
		inserirNavios(n1, n2, n3, n4, t2, 1);
		System.out.println("Vamos começar o jogo");
		int nl = 0;
		int nc = 0;
		int currentPlayer = 1;
		while (!endGame(t1, currentPlayer) && !endGame(t2, currentPlayer)) {
			System.out.println("Vez do jogador: " + currentPlayer);
			if (currentPlayer == 1) {

				System.out.format("Insira uma linha: ");
				nl = scanner(scanner);

				System.out.format("Insira uma coluna: ");
				nc = scanner(scanner);
				while (!validacao(nl, nc)) {
					System.out.println("Tente um numero dentro do tabuleiro capitão!!!");

					System.out.format("Insira uma linha: ");
					nl = scanner(scanner);

					System.out.format("Insira uma coluna: ");
					nc = scanner(scanner);
				}

				disparo(nl, nc, t2);
				t1.showTabuleiro();
				currentPlayer = 2;
			} else {
			
				System.out.format("Insira uma linha: ");
				nl = scanner(scanner);

				System.out.format("Insira uma coluna: ");
				nc = scanner(scanner);
				
				while (!validacao(nl, nc)) {
					System.out.println("Tente um numero dentro do tabuleiro capitão!!!");

					System.out.format("Insira uma linha: ");
					nl = scanner(scanner);

					System.out.format("Insira uma coluna: ");
					nc = scanner(scanner);
				}


				System.out.flush();
				disparo(nl, nc, t1);
				t2.showTabuleiro();
				currentPlayer = 1;
			}

		}
	}
}