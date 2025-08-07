public class FruitIntoBasketsIII {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] fruits1 = { 10, 20, 30 };
        int[] baskets = { 15, 5, 25 };
        System.out.println("Unplaced Count: " + sol.numOfUnplacedFruits(fruits1, baskets));
        // Expect: output = 1;
    }

    private static class Solution {
        int[] tree;
        int[] baskets;
        int n;

        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            this.baskets = baskets;
            this.n = baskets.length;
            if (n == 0) {
                return fruits.length;
            }

            this.tree = new int[4 * n];

            build(1, 0, n - 1);

            int unplacedCount = 0;
            for (int fruitQty : fruits) {
                int basketIndex = findLeftmostBasket(fruitQty);

                if (basketIndex != -1) {
                    update(basketIndex);
                } else {
                    unplacedCount++;
                }
            }
            return unplacedCount;
        }

        private void build(int node, int start, int end) {
            if (start == end) {
                tree[node] = baskets[start];
            } else {
                int mid = (start + end) / 2;
                build(2 * node, start, mid);
                build(2 * node + 1, mid + 1, end);
                tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
            }
        }

        private int findLeftmostBasket(int fruitQty) {
            if (tree[1] < fruitQty) {
                return -1;
            }
            return search(1, 0, n - 1, fruitQty);
        }

        private int search(int node, int start, int end, int fruitQty) {
            if (start == end) {
                return (tree[node] >= fruitQty) ? start : -1;
            }

            int mid = (start + end) / 2;
            int result = -1;

            if (tree[2 * node] >= fruitQty) {
                result = search(2 * node, start, mid, fruitQty);
            }

            if (result != -1) {
                return result;
            }

            if (tree[2 * node + 1] >= fruitQty) {
                result = search(2 * node + 1, mid + 1, end, fruitQty);
            }

            return result;
        }

        private void update(int index) {
            updateRecursive(1, 0, n - 1, index);
        }

        private void updateRecursive(int node, int start, int end, int index) {
            if (start == end) {
                tree[node] = 0;
                return;
            }

            int mid = (start + end) / 2;
            if (start <= index && index <= mid) {
                updateRecursive(2 * node, start, mid, index);
            } else {
                updateRecursive(2 * node + 1, mid + 1, end, index);
            }

            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }
    }
}
