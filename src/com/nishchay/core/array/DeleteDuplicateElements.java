package com.nishchay.core.array;

import java.util.Arrays;

public class DeleteDuplicateElements {

	public static void main(String[] args) {

		// int[] intArr = new int[] { 2, 3, 5, 5, 5, 6, 8, 8, 9, 10, 12 };
		int[] intArr = new int[] { 5, 5, 5, 5, 5, 5, 9, 10, 10, 10, 10, 12 };

		System.out.println("Array prior to delete : " + Arrays.toString(intArr));

		deleteDuplicates(intArr);

		System.out.println("Array after to delete : " + Arrays.toString(intArr));

	}

	/*
	 * private static void deleteDuplicates(int[] a, int size) { for (int i = 0;
	 * i < size; i++) for (int j = i + 1; j < size && a[i] == a[j]; j++) { //
	 * delete jth element delete(a, size, j); --size; } }
	 * 
	 * private static void delete(int[] a, int n, int loc) { for (int j = loc; j
	 * < n - 1; j++) { a[j] = a[j + 1]; } }
	 */

	private static void deleteDuplicates(int[] arr) {
		int size = arr.length;
		int check = arr[0];
		for (int i = 1; i < size;) {
			if (check == arr[i]) {
				deleteElement(arr, i);
				size = size - 1;
			} else {
				check = arr[i];
				i = i + 1;
			}
		}
	}

	private static void deleteElement(int[] arr, int index) {
		int size = arr.length;
		for (int i = index; i < size - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[size - 1] = 0;
	}

}
