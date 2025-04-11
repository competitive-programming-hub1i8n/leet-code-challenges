package org.example.implementations;

public class N_201_FinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String val : operations){
            switch (val){
                case "++X":
                    ++x;
                    break;
                case "X++":
                    x++;
                    break;
                case "--X":
                    --x;
                    break;
                case "X--":
                    x--;
                    break;
                default:
                    break;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        String[] operations = {"--X","X++","X++"};
        int result = new N_201_FinalValueOfVariableAfterPerformingOperations().finalValueAfterOperations(operations);
        System.out.println(result);

        operations = new String[]{"++X","++X","X++"};
        result = new N_201_FinalValueOfVariableAfterPerformingOperations().finalValueAfterOperations(operations);
        System.out.println(result);
    }
}
