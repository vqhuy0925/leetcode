public class FindClosestPerson {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findClosest(2, 7, 4));
        System.out.println(solution.findClosest(2, 5, 6));
    }

    static class Solution {
        public int findClosest(int x, int y, int z) {
            int xStep = Math.abs(x - z);
            int yStep = Math.abs(y - z);
            if (xStep == yStep)
                return 0;
            return xStep < yStep ? 1 : 2;
        }
    }

}
