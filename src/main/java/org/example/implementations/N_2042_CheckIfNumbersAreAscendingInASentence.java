package org.example.implementations;

import java.util.StringTokenizer;

public class N_2042_CheckIfNumbersAreAscendingInASentence {
    public boolean areNumbersAscending(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s);
        Integer prev = null;
        while (tokenizer.hasMoreElements()){
            String token = tokenizer.nextToken();
            Result result = isNumber(token);
            if (result.getIsNumber()){
                if (prev != null && prev >= result.getNumber()){
                    return false;
                }
                prev = result.getNumber();
            }
        }
        return true;
    }

    public Result isNumber(String number){
        try {
            Integer num = Integer.parseInt(number);
            return new Result(true, num);
        } catch (NumberFormatException e){
            return new Result(false, null);
        }
    }

    static class Result{
        private Boolean isNumber;
        private Integer number;

        public Result(Boolean isNumber, Integer number) {
            this.isNumber = isNumber;
            this.number = number;
        }

        public Boolean getIsNumber() {
            return isNumber;
        }

        public Integer getNumber(){
            return this.number;
        }


    }

    public static void main(String[] args) {
        N_2042_CheckIfNumbersAreAscendingInASentence inASentence = new N_2042_CheckIfNumbersAreAscendingInASentence();

        System.out.println(inASentence.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        System.out.println(inASentence.areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
    }
}
