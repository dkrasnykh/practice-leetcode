package array.can_place_flowers_605;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int k = 0;
        int[] flowebedcopy = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, flowebedcopy, 1, flowerbed.length);
        for (int i = 1; i <= flowerbed.length; ++i) {
            if(flowebedcopy[i] == 0 && flowebedcopy[i-1]==0 && flowebedcopy[i+1]==0){
                flowebedcopy[i] = 1;
                ++k;
            }
        }
        return k >= n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
    }
}
