package com.wchb.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/26/18 11:18 PM
 */
public class S118 {
    //变量名
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new LinkedList<>();

        if (numRows <= 0) return triangle;

        // Second base case; first row is always [1].
        triangle.add(new LinkedList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new LinkedList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first row element is always 1.
            row.add(1);

            for (int j = 1; j <= rowNum; j++) {
                int n1 = j >= prevRow.size() ? 0 : prevRow.get(j);
                int n2 = j - 1 >= 0 ? prevRow.get(j - 1) : 0;
                row.add(n1 + n2);
            }


            triangle.add(row);
        }


        return triangle;
    }

    /************************************************************/
    // From LC Solution
    public List<List<Integer>> generateV2(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
}
