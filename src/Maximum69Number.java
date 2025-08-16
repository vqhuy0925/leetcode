public class Maximum69Number {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("num = 96: " + solution.maximum69Number(96));
        System.out.println("num = 96996: " + solution.maximum69Number(96996));
        System.out.println("num = 696: " + solution.maximum69Number(696));
    }

    static class Solution {
        // public int maximum69Number(int num) {
        // int[] nums = convertIntegerToArray(num);
        // int indexChanged = 0;
        // for (int i = 0; i < nums.length; i++) {
        // System.out.println(nums[i]);
        // if (nums[i] < 9) {
        // indexChanged = i;
        // break;
        // }
        // }
        // nums[indexChanged] = 9;
        // int result = 0;
        // for (int digit : nums) {
        // result = result * 10 + digit;
        // }
        // return result;
        // }

        // public static int[] convertIntegerToArray(int number) {
        // String s = String.valueOf(number);
        // int[] digits = new int[s.length()];

        // for (int i = 0; i < s.length(); i++) {
        // digits[i] = Character.getNumericValue(s.charAt(i));
        // }
        // return digits;
        // }

        public int maximum69Number(int num) {
            String s = String.valueOf(num);
            int firstOfSix = s.indexOf('6');
            if (firstOfSix == -1) {
                return num;
            }
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(firstOfSix, '9');
            return Integer.parseInt(sb.toString());
        }

    }

}
