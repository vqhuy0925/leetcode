public class Largest3OddNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("num = 52: " + solution.largestOddNumber("52"));
        System.out.println("num = 4206: " + solution.largestOddNumber("4206"));
    }

    static class Solution {
        public String largestOddNumber(String num) {
            for (int i = num.length() - 1; i >= 0; i--) {
                if (num.charAt(i) % 2 != 0) {
                    return num.substring(0, i + 1);
                }
            }
            return "";
        }
    }
}
