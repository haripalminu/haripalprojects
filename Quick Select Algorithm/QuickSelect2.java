/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksheet2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mia
 */
public class QuickSelect2 {

    int kthLargest(int[] list, int k) {
        int left = 0;
        int right = list.length - 1;
        while (true) {


            int pivIndex = (left + right) / 2;
            int newPiv = partition(list, left, right, pivIndex);
            if (newPiv == k) {
                return list[newPiv];
            } else if (newPiv < k) {
                left = newPiv + 1;
            } else {
                right = newPiv - 1;
            }
        }
    }

    private static int partition(int[] list, int left, int right, int pivot) {
        int pivValue = list[pivot];
        swap(list, pivot, right);
        int storePos = left;
        for (int i = left; i < right; i++) {
            if (list[i] > pivValue) {
                swap(list, i, storePos);
                storePos++;
            }
        }
        swap(list, storePos, right);
        return storePos;
    }

    private static void swap(int[] list, int a, int b) {
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;

    }

    public static void main(String[] args) {

        int[] a = {1, 3, 2, 4, 9, 7, 5, 6, 10, 8};

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter Kth largest number you want to find");
        int k = reader.nextInt();
        if (k > a.length) {
            return;
        }

        System.out.print("\n");
        QuickSelect2 q = new QuickSelect2();

        int index = q.kthLargest(a, k);

        System.out.println(index);

        System.out.println("The array is \n");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print("  ");
        }

    }
}
