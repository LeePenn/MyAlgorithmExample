package com.sort;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[]{9,5,4,4,56,6,1,7,2,3,6};
		MergeSort.sort(arr, 0, arr.length-1);
		for(int elm : arr) {
			System.out.println(elm+" ");
		}
	}

	private static void sort(int[] arr, int l, int r) {
		if(l < r) {
			int m = (l + r) >> 1;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	private static void merge(int[] arr, int l, int m, int r) {
		int l1 = m - l + 1, l2 = r - m;
		int[] left = new int[l1], right = new int[l2];
		for(int i = 0; i < l1; ++i) {
			left[i] = arr[l + i];
		}
		for(int i = 0; i < l2; ++i) {
			right[i] = arr[m + 1 + i];
		}

		int i = 0, j = 0;
		int k = l;
		while(i < l1 && j < l2) {
			if(left[i] <= right[j]) {
				arr[k] = left[i++];
			} else {
				arr[k] = right[j++];
			}
			k++;
		}
		while(i < l1) {
			arr[k++] = left[i++];
		}
		while(j < l2) {
			arr[k++] = right[j++];
		}
	}

}
