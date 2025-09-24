public class CompareVersionNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compareVersion("1.01", "1.001"));

    }

    static class Solution {
        public int compareVersion(String version1, String version2) {
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");
            int maxLength = Math.max(v1.length, v2.length);
            for (int i = 0; i < maxLength; i++) {
                Integer n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
                Integer n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
                int compare = n1.compareTo(n2);
                if (compare != 0) {
                    return compare > 0 ? 1 : -1;
                }
            }

            return 0;
        }

    }
}
