import java.util.Arrays;

public class insertionSort2 {

	public static void main(String[] args) {
		Integer[] array = new Integer[] { 12, 13, 24, 10, 3, 6, 90, 70 };

		// Let's sort using bubble sort
		insertionSortImproved(array, 0, array.length);

		// Verify sorted array
		System.out.printf("Lista: %s", Arrays.toString(array));

	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void insertionSortImproved(Object[] a, int fromIndex, int toIndex) {
		Object d;
		for (int i = fromIndex + 1; i < toIndex; i++) {
			d = a[i];
			int jLeft = fromIndex;
			int jRight = i - 1;
			
			//binary search for lists and putting the suitable position
			if(((Comparable) a[jRight]).compareTo(d) > 0) {
				while(jRight - jLeft >= 2) {
					int jMiddle = (jRight - jLeft) / 2 + jLeft - 1;
					if(((Comparable) a[jMiddle]).compareTo(d) > 0) {
						jRight = jMiddle;
					} else {
						jLeft = jMiddle + 1;
					}
				}
				if(jRight - jLeft == 1) {
					int jMiddle = jLeft;
					if(((Comparable) a[jMiddle]).compareTo(d) > 0) {
						jRight = jMiddle;
					} else {
						jLeft = jMiddle + 1;
					}
				}
				//Place element to the right place
				int j = i;
				for (j = i; j > jLeft; j--) {
					a[j] = a[j - 1];
				}
				a[j] = d;
			}
		}
	}
}
