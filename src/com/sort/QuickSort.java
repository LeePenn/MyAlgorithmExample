package com.sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = new int[]{9,5,4,1,1,7,2,3,6};
		QuickSort.sort(arr, 0, arr.length-1);
		for(int elm : arr) {
			System.out.println(elm+" ");
		}

	}

	static void sort(int arr[], int start, int end) {
		if(start<end) {
//          int index = partition(arr, start, end);
			int index = doublePartition(arr, start, end);
			sort(arr, start, index-1);
			sort(arr, index+1, end);
		}
	}

	static int partition(int arr[], int start, int end) {

		int pivot = arr[start];
		int i = start;
		for(int j = start+1;j<=end;j++) {
			if(arr[j] < pivot) {
				++i;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i];
		arr[i] = arr[start];
		arr[start] = temp;
		return i;
	}

	static int doublePartition(int[] arr, int start, int end) {
		int pivot = arr[start];
		int i = start; // start element as pivot
		while(start < end) {
			while(start<end && arr[start] <= pivot) {
				start++;
			}
			while(start<end && arr[end] > pivot) { // end must befort start
				end--;
			}


			if(start < end) {
				int tmp = arr[start];
				arr[start] = arr[end];
				arr[end] = tmp;
			}
		}
		start--; // 因为start先于end，所以会多加1
		arr[i] = arr[start];
		arr[start] = pivot;
		System.out.println(start);
		System.out.println(Arrays.toString(arr));
		return start;

	}
}
