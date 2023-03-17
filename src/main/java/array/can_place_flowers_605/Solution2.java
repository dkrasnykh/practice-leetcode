package array.can_place_flowers_605;

//https://www.youtube.com/watch?v=ZGxqqjljpUI
public class Solution2 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int empty = 1 - flowerbed[0];
        for (Integer f : flowerbed) {
            if (f == 1) {
                n -= (empty - 1) / 2;
                empty = 0;
            } else {
                empty += 1;
            }
        }
        n -= empty / 2;
        return n <= 0;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));

    }
}
