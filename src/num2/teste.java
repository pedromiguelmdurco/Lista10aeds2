package num2;

import java.util.Arrays;
import java.util.Scanner;

public class teste {

	public static void mergesort(int[] array, int esq, int dir) {
		if (esq < dir) {
			int meio = (esq + dir) / 2;
			mergesort(array, esq, meio);
			mergesort(array, meio + 1, dir);
			intercalar(array, esq, meio, dir);
		}
	}

	public static void intercalar(int[] array, int esq, int meio, int dir) {

		int nEsq = meio - esq + 1;
		int nDir = dir - meio;
		int[] arrayEsq = new int[nEsq + 1];
		int[] arrayDir = new int[nDir + 1];

		arrayEsq[nEsq] = Integer.MAX_VALUE;
		arrayDir[nDir] = Integer.MAX_VALUE;

		int iEsq, iDir, i;

		for (iEsq = 0; iEsq < nEsq; iEsq++) {
			arrayEsq[iEsq] = array[esq + iEsq];
		}

		for (iDir = 0; iDir < nDir; iDir++) {
			arrayDir[iDir] = array[(meio + 1) + iDir];
		}

		for (iEsq = 0, iDir = 0, i = esq; i <= dir; i++) {
			array[i] = (arrayEsq[iEsq] <= arrayDir[iDir]) ? arrayEsq[iEsq++] : arrayDir[iDir++];
		}
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int[] array;

		System.out.println("Digite o tamanho do vetor");
		array = new int[teclado.nextInt()];

		for (int cont = 0; cont < array.length; cont++) {
			System.out.println("Digite um valor");
			array[cont] = teclado.nextInt();
		}
		
		mergesort(array,0,array.length-1);
		
		System.out.println(Arrays.toString(array));

		teclado.close();
	}

}
