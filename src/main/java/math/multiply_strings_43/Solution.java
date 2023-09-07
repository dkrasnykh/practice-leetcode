package math.multiply_strings_43;

public class Solution {
    public String multiply(String num1, String num2) {
        String n1 = (num1.length() >= num2.length() ? num1 : num2);
        String n2 = n1.equals(num1) ? num2 : num1;
        int[][] matrix = new int[n2.length()][n1.length() + n2.length()];
        int extra = 0;
        for (int i = n2.length() - 1; i >= 0; --i) {
            int a1 = Character.getNumericValue(n2.charAt(i));
            for (int j = n1.length() - 1; j >= 0; --j) {
                int tmp = a1 * Character.getNumericValue(n1.charAt(j)) + extra;
                matrix[n2.length() - 1 - i][n1.length() + n2.length() - 1 - (n2.length() - 1 - i) - (n1.length() - 1 - j)] = tmp % 10;
                extra = tmp / 10;
            }
            StringBuilder t1 = new StringBuilder();
            t1.append(extra);
            String extraStr = t1.reverse().toString();
            for(int j = 0; j < extraStr.length(); ++j){
                matrix[n2.length() - 1 - i][n1.length() + n2.length() - 1 - (n2.length() - 1 - i) - n1.length() - j] = Character.getNumericValue(extraStr.charAt(j));
            }
            extra = 0;
        }
        StringBuilder sb = new StringBuilder();
        extra = 0;
        for(int j = matrix[0].length - 1; j >= 0; --j){
            int total = extra;
            for(int i = 0; i < matrix.length; ++i){
                total += matrix[i][j];
            }
            sb.append(total%10);
            String totalStr = Integer.toString(total);
            if(totalStr.length() > 1){
                extra = Integer.parseInt(totalStr.substring(0, totalStr.length() - 1));
            } else {
                extra = 0;
            }
        }
        if(extra > 0){
            StringBuilder t1 = new StringBuilder();
            t1.append(extra);
            sb.append(t1.reverse());
        }
        while(sb.length() > 0 && sb.charAt(sb.length() - 1) == '0'){
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println(s.multiply("123", "456"));
        //System.out.println(s.multiply("9", "9"));

        //output - "81081"
        //expected - "9801"
        //System.out.println(s.multiply("99", "99"));
        System.out.println(s.multiply("9", "99"));
    }
}
