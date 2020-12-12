package com.sort;

import java.util.HashMap;

public class HeapSort {

	public static void main(String[] args) {
		int[] arr = new int[]{9,4,5,6,7,883,9,9,67,13,456,4,1,1,7,2,3,6};
		HeapSort heap = new HeapSort();
		heap.sort(arr);
		for(int elm : arr) {
			System.out.println(elm+" ");
		}
	}

	public void sort(int[] arr) {
		int n = arr.length;
		for(int i = n / 2 - 1; i >= 0; --i) {
			heapifyUp(arr, i, n);
		}
		for(int i = n - 1; i >= 0; --i) {
			swap(arr, i, 0);
			heapifyUp(arr, 0, i);
		}
	}

	public void heapifyUp(int[] arr, int i, int n) {
		int parent = i;
		int l = (i << 1) + 1;
		int r = (i << 1) + 2;
		if(l < n && arr[l] > arr[parent]) {
			parent = l;
		}
		if(r < n && arr[r] > arr[parent]) {
			parent = r;
		}
		if(parent != i) {
			swap(arr, parent, i);
			heapifyUp(arr, parent, n);
		}
	}

	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}

