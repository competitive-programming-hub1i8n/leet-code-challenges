package org.example.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class N_119_PascalTriangleII {
    public static void main(String[] args) {
        N_119_PascalTriangleII triangleII =  new N_119_PascalTriangleII();
        System.out.println(triangleII.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        IntStream.range(0, rowIndex + 1).forEach(i -> {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));
            for (int j = 1; j < i; j++) {
                int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                row.set(j, val);
            }
            result.add(row);
        });

        return result.get(rowIndex);
    }
}
