package com.wchb.ms;


import java.util.LinkedList;

/**
 * @date 7/26/18 7:31 PM
 */
public class S1 {

    private int increment(int[] array, int index) {
        ++index;
        while (index < array.length && array[index] == array[index - 1]) {
            ++index;
        }
        return index;
    }

    LinkedList<Integer> a;
    LinkedList<Integer> b;
    LinkedList<Integer> intersection;


    public void unique(int[] A, int[] B) {
        int i = 0;
        int j = 0;

        a = new LinkedList<>();
        b = new LinkedList<>();
        intersection = new LinkedList<>();

        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                intersection.add(A[i]);
                i = increment(A, i);
                j = increment(B, j);
            } else if (A[i] < B[j]) {
                a.add(A[i]);
                i = increment(A, i);
            } else {
                b.add(B[j]);
                j = increment(B, j);
            }
        }

        while (i < A.length) {
            a.add(A[i]);
            i = increment(A, i);
        }

        while (j < B.length) {
            b.add(B[j]);
            j = increment(B, j);
        }


        System.out.println("DONE");
    }


}
