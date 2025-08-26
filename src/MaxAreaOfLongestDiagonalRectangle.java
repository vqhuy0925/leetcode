public class MaxAreaOfLongestDiagonalRectangle {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.areaOfMaxDiagonal2(new int[][] { { 9, 3 }, { 8, 6 } }));
        System.out.println(solution.areaOfMaxDiagonal2(new int[][] { { 3, 4 }, { 4, 3 } }));
    }

    static class Solution {
        public int areaOfMaxDiagonal(int[][] dimensions) {
            if (dimensions.length == 0) {
                return 0;
            }
            double maxDiagonal = 0;
            int[] maxDimension = dimensions[0];
            for (int i = 0; i < dimensions.length; i++) {
                double currentDiagonal = Math
                        .sqrt(dimensions[i][0] * dimensions[i][0] + dimensions[i][1] * dimensions[i][1]);
                if (currentDiagonal > maxDiagonal) {
                    maxDiagonal = currentDiagonal;
                    maxDimension = dimensions[i];
                }
            }
            return maxDimension[0] * maxDimension[1];
        }

        public int areaOfMaxDiagonal2(int[][] dimensions) {
            int maxArea = 0;
            long maxDiagonal = 0;

            for (int[] dimension : dimensions) {
                int length = dimension[0];
                int width = dimension[1];
                long currentDiagonal = length * length + width * width;
                int currentArea = length * width;
                if (currentDiagonal > maxDiagonal) {
                    maxDiagonal = currentDiagonal;
                    maxArea = currentArea;
                } else if (currentDiagonal == maxDiagonal && currentArea > maxArea) {
                    maxArea = currentArea;
                }

            }
            return maxArea;
        }
    }
}
