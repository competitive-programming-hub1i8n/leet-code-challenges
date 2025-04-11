package org.example.implementations;

public class N_11_ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int saveArea,p1,p2, area;
        saveArea = 0;
        p1 = 0;
        p2 = height.length - 1;
        while (p1 != p2) {
            area = Math.min(height[p1], height[p2]) * (p2 - p1);
            saveArea = Math.max(saveArea, area);
            if (height[p1] < height[p2]) {
                p1++;
            } else {
                p2--;
            }
        }
        return saveArea;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));

        int[] height2 = {1,1};
        System.out.println(maxArea(height2));
    }
}
