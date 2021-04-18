import java.util.Arrays;

public class quickSort {

	public static void main(String[] args) {
		
		//Nepore�ana lista
		Integer[] array = new Integer[] { 12, 13, 14, 24, 10, 3, 6, 90, 70 };

		//Pomo�u funkcije quickSort sortiramo celu listu
		quickSort(array, 0, array.length - 1);

		System.out.printf("Lista: %s", Arrays.toString(array));
	}

	public static void quickSort(Integer[] arr, int low, int high) {
		//Gledamo da li mo�da u listi imaju null vrednosti
		if(arr == null || arr.length ==0){
			return;
		}
		
		if(low >= high) {
			return;
		}
		
		//Tra�imo srednju vrednost liste, tj.sredinu
		int middle = low + (high - low) /2;
		int pivot = arr[middle];
		//menjanje mesta vrednostima
		int i = low, j = high;
		//vrednosti leve strane da budu manje od pivota
		while(i <= j) {

			while(arr[i] < pivot) {
				i++;
			}
			//vrednosti desne strane da budu ve�e od pivota
			while(arr[j] > pivot) {
				j--;
			}
			//i ovde se upore�uju vrednosti i gledaju se vrednosti koje se menjaju
			//na kraju se vrednosti sa obe strane liste menjaju
			if(i<=j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		//Rekurzivno se sortiraju dve liste
		if(low < j){
			quickSort(arr, low, j);
		}
		if(high > i){
			quickSort(arr, i, high);
		}

	}

	public static void swap(Integer array[], int x, int y) {
		
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

}