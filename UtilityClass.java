package data_structures;

public class UtilityClass {

	public static <T> void grow_array(T[] arr) {
		T[] new_arr = (T[]) new Object[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			new_arr[i] = arr[i];
		}
		arr = new_arr;
	}
  
}
