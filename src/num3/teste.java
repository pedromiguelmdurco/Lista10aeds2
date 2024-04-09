package num3;

import java.util.Arrays;

public class teste {

	public static int mergesort(int[] array, int esq, int dir, int cont) {
		if (esq < dir) {
			cont++;
			int meio = (esq + dir) / 2;
			cont =mergesort(array, esq, meio, cont);
			cont = mergesort(array, meio + 1, dir, cont);
			cont = intercalar(array, esq, meio, dir, cont);
		}
		return cont;
	}

	public static int intercalar(int[] array, int esq, int meio, int dir, int cont) {

		int nEsq = meio - esq + 1;
		int nDir = dir - meio;
		int[] arrayEsq = new int[nEsq + 1];
		int[] arrayDir = new int[nDir + 1];

		arrayEsq[nEsq] = Integer.MAX_VALUE;
		arrayDir[nDir] = Integer.MAX_VALUE;

		int iEsq, iDir, i;

		for (iEsq = 0; iEsq < nEsq; iEsq++) {
			arrayEsq[iEsq] = array[esq + iEsq];
			cont++;
		}
		for (iDir = 0; iDir < nDir; iDir++) {
			arrayDir[iDir] = array[(meio + 1) + iDir];
			cont++;
		}

		for (iEsq = 0, iDir = 0, i = esq; i <= dir; i++) {
			cont++;
			array[i] = (arrayEsq[iEsq] <= arrayDir[iDir]) ? arrayEsq[iEsq++] : arrayDir[iDir++];
		}
		System.out.println(Arrays.toString(array));
		return cont;
	}

	public static int quicksort(int[] array, int esq, int dir, int cont) {
		int i = esq, j = dir, pivo = array[(esq + dir) / 2];
		while (i <= j) {
			while (array[i] < pivo)
				i++;cont++;
			while (array[j] > pivo)
				j--;cont++;
			if (i <= j) {
				cont++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				
				System.out.println(Arrays.toString(array));
				i++;
				j--;
			}
		}
		if (esq < j) {
			cont++;
			cont = quicksort(array, esq, j, cont);
		}
		if (i < dir) {
			cont++;
			cont = quicksort(array, i, dir, cont);
		}
		return cont;
	}

	public static void main(String[] args) {
		int[] array;
		int cont = 0, cont2 = 0;

		array = new int[] {20,14,1,3,2,4,11,7,8,9,17,18,16,15,6,5,13,12,10,19};
		System.out.println(Arrays.toString(array));
		cont += mergesort(array, 0, array.length - 1, cont);
		System.out.println(Arrays.toString(array));
		System.out.println(cont);
		System.out.println("-------------------------------");

		array = new int[] { 20,14,1,3,2,4,11,7,8,9,17,18,16,15,6,5,13,12,10,19};

		System.out.println(Arrays.toString(array));
		cont2+=quicksort(array, 0, array.length - 1, cont2);
		System.out.println(Arrays.toString(array));

		System.out.println(cont2);
	}

}
