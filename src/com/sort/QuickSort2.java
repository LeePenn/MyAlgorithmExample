package com.sort;

public class QuickSort2 {
	public static void main(String[] args) {
		int[] arr = new int[]{9,5,3,55,67,13,456,4,1,1,7,2,3,6};
		QuickSort2 qs = new QuickSort2();
		qs.sort(arr, 0, arr.length-1);
		for(int elm : arr) {
			System.out.println(elm+" ");
		}

	}

	public void sort(int[] arr, int l, int r) {
		if(l >= r) {
			return;
		}
		int s = l, e = r;
		int p = arr[l];
		while(l < r) {
			// r 在前，确保r为最后一个>=p的元素的索引，这样在出循环后才不会换错
			while(l < r && arr[r] > p) {
				--r;
			}
			while(l < r && arr[l] <= p) {
				++l;
			}
			if(l < r) {
				swap(arr, l, r);
			}
		}
		arr[s] = arr[l];
		arr[l] = p;
		sort(arr, s, l - 1);
		sort(arr, l + 1, e);
	}

	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		return;
	}
}
