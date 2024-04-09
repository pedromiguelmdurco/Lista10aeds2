package num1;

import java.util.Arrays;
import java.util.Scanner;

public class teste {

	public static void quicksort(int[] array, int esq, int dir) {
		int i = esq, j = dir, pivo = array[(esq + dir) / 2];
		while (i <= j) {
			while (array[i] < pivo)
				i++;
			while (array[j] > pivo)
				j--;
			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				
				i++;
				j--;
			}
		}
		if (esq < j)
			quicksort(array, esq, j);
		if (i < dir)
			quicksort(array, i, dir);
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
		
		quicksort(array,0,array.length-1);
		
		System.out.println(Arrays.toString(array));

		teclado.close();
	}

}
