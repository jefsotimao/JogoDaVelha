package exermatrizes;

import java.util.Scanner;

public class ExerJogoDaVelha {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		char[][] tabuleiro = new char[3][3];

		System.out.println("--------Jogo da Velha---------");
		System.out.println("Jogador 1 : X ");
		System.out.println("Jogador 2 : O ");

		boolean ganhou = false;
		int jogada = 1; // quantidade de jogadas
		char sinal;
		int linha = 0, coluna = 0;

		while (!ganhou) {

			if (jogada % 2 == 1) { // se jogada for impar, e a vez do jogador 1,
									// se for par, jogador 2
				System.out.println("Vez do jogador 1, escolha a linha e coluna (1-3)");
				sinal = 'X';
			} else {
				System.out.println("Vez do jogador 2, escolha a linha e coluna (1-3)");
				sinal = 'O';
			}

			boolean linhaValida = false;
			while (!linhaValida) {
				System.out.println("Digite uma linha entre 1, 2 e 3");
				linha = s.nextInt();
				if (linha >= 1 && linha <= 3) {
					linhaValida = true;
				} else {
					System.out.println("Escolha invalida, favor tente novamente");
				}
			}

			boolean colunaValida = false;
			while (!colunaValida) {
				System.out.println("Digite uma coluna entre 1, 2 e 3");
				coluna = s.nextInt();
				if (coluna >= 1 && coluna <= 3) {
					colunaValida = true;
				} else {
					System.out.println("Escolha invalida, favor tente novamente");
				}
			}

			linha--;
			coluna--; // aqui precisa decrementar pois queremos que comece com
						// 1, 2 ou 3, e nao com 0, 1 ou 2
			if (tabuleiro[linha][coluna] == 'X' || tabuleiro[linha][coluna] == 'O') {
				System.out.println("Jogada ja realizada, favor tente novamente");
			} else {
				tabuleiro[linha][coluna] = sinal; // aqui conta como jogada
													// valida entao incrmente
													// jogada
				jogada++;

			}

			// imprimindo o tabuleiro
			for (int i = 0; i < tabuleiro.length; i++) {
				for (int j = 0; j < tabuleiro[i].length; j++) {
					System.out.print(tabuleiro[i][j]+ " | ");
				}
				System.out.println();
			}

			
			// verificando o ganhador
			
			if((tabuleiro[0][0] == 'X' && tabuleiro[0][1] == 'X' && tabuleiro[0][2] == 'X') || //linha 1
				(tabuleiro[1][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[1][2] == 'X') || //linha 2
				(tabuleiro[2][0] == 'X' && tabuleiro[2][1] == 'X' && tabuleiro[2][2] == 'X') || //linha 3
				(tabuleiro[0][0] == 'X' && tabuleiro[1][0] == 'X' && tabuleiro[2][0] == 'X') || //coluna 1
				(tabuleiro[0][1] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][1] == 'X') || // coluna 2
				(tabuleiro[0][2] == 'X' && tabuleiro[1][2] == 'X' && tabuleiro[2][2] == 'X') || //coluna 3
				(tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X') || //diagonal
				(tabuleiro[0][2] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][0] == 'X')) // diagonal inversa 
			
				{
				ganhou = true;
				System.out.println("Parabens, jogador 1 ganhou!");
				} else if
					((tabuleiro[0][0] == 'O' && tabuleiro[0][1] == 'O' && tabuleiro[0][2] == 'O') || //linha 1
							(tabuleiro[1][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[1][2] == 'O') || //linha 2
							(tabuleiro[2][0] == 'O' && tabuleiro[2][1] == 'O' && tabuleiro[2][2] == 'O') || //linha 3
							(tabuleiro[0][0] == 'O' && tabuleiro[1][0] == 'O' && tabuleiro[2][0] == 'O') || //coluna 1
							(tabuleiro[0][1] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][1] == 'O') || // coluna 2
							(tabuleiro[0][2] == 'O' && tabuleiro[1][2] == 'O' && tabuleiro[2][2] == 'O') || //coluna 3
							(tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2] == 'O') || //diagonal
							(tabuleiro[0][2] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][0] == 'O')) //diagonal inversa
				{ 
					ganhou = true;
					System.out.println("Parabens, jogador 2 ganhou!");
				}else if(jogada>9){ // se chegarmos a mais de 9 jogadas, e porque deu impate
					ganhou = true; // tbm encerramos o loop
					System.out.println("Jogo empatado");
				}
			
			
			
		}

	}

}
