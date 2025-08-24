package org.example.implementations;

public class N_605_CanPlaceFlowers {
    public static void main(String[] args) {
        N_605_CanPlaceFlowers obj = new N_605_CanPlaceFlowers();
        System.out.println(obj.canPlaceFlowers(new int[]{1,0,0,0,1}, 1)); // true
        System.out.println(obj.canPlaceFlowers(new int[]{1,0,0,0,1}, 2)); // false
        System.out.println(obj.canPlaceFlowers(new int[]{0}, 1)); // true
        System.out.println(obj.canPlaceFlowers(new int[]{0,0}, 1)); // true
        System.out.println(obj.canPlaceFlowers(new int[]{0,0,0}, 2)); // true
        System.out.println(obj.canPlaceFlowers(new int[]{1,0,0,0,1,0,0}, 2)); // true

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0) return n <= 0;
        if (flowerbed.length == 1) return flowerbed[0] == 0;
        if (flowerbed.length == 2) return flowerbed[0] == 0 && flowerbed[1] == 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                flowerbed[i] = 1;
                n--;
                if (n <= 0) return true;
            }
        }
        return n <= 0;
    }
}
