/**
 *
 * @author anitgeorge
 */

public class FenwickTree {

    int N;
    long[] tree;
    FenwickTree(long[] nums){
        N = nums.length;
        tree = new long[N + 1];
        tree[0] = 0L;
        tree = nums.clone();
        for(int i = 1; i < N; i++){
            int parent = i + lsb(i);
            if(parent < N)
                tree[parent] += tree[i];
        }
    }
    private int lsb(int num){
        return Integer.lowestOneBit(num);
    }

    public long prefixSum(int i){
        long sum = 0L;
        while(i > 0){
            sum += tree[i];
            i -= lsb(i);
        }
        return sum;
    }

    public long rangeQuery(int left, int right){

        return left < right ? prefixSum(right) - prefixSum(left - 1) : -1;
    }

    public void add(int i, long v){
        while(i < N){
            tree[i] += v;
            i = i + lsb(i);
        }
    }
}
