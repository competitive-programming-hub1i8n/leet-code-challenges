package org.example.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class N_118_PascalTriangle {
    public static void main(String[] args) {
        N_118_PascalTriangle triangle =  new N_118_PascalTriangle();
        System.out.println(triangle.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        IntStream.range(0, numRows).forEach(i -> {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));
            for (int j = 1; j < i; j++) {
                int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                row.set(j, val);
            }
            result.add(row);
        });

        return result;
    }
}
