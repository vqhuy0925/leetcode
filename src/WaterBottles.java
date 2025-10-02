public class WaterBottles {
     public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWaterBottles(9, 3));
        System.out.println(solution.numWaterBottles(15, 3));
    }

    static class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int rest = numBottles;
            int empty = numBottles;
            while(empty >= numExchange){
                int newFull = empty / numExchange;
                rest += newFull;
                empty = empty % numExchange + newFull;
            }
            return rest;
        }
    }
}
