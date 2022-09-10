import java.util.Arrays;
//Max heap
class Heap {
    int[] arr;
    int i = 0;
    public Heap(int size) {
        this.arr = new int[size];
    }
    public boolean add(int val) {
        if (i < this.arr.length) {
            this.arr[i++] = val;
            this.bubbleUp();
            return true;
        }
        return false;
    }
    public void bubbleUp() {
        int idx = this.i - 1;
        int val = this.arr[idx];
        int pIdx;
        int pVal;
        int temp;
        while (idx > 0) {
            pIdx = (idx - 1) / 2;
            pVal = this.arr[pIdx];
            if (val > pVal) {
                temp = this.arr[pIdx];
                this.arr[pIdx] = val;
                this.arr[idx] = temp;
            }
            idx = pIdx;
        }
    }
    public int getMax() {
        int res = this.arr[0];
        this.arr[0] = this.arr[--i];
        this.arr[i] = 0;
        this.trickleDown();
        return res;
    }
    public void trickleDown() {
        int idx = 0;
        int val = this.arr[idx];
        int childIdx1, childIdx2;
        int child1 = 0, child2 = 0, temp;
        int swapIdx = 0;
        while (idx < i) {
            childIdx1 = (2 * idx) + 1;
            childIdx2 = (2 * idx) + 2;
            if (childIdx1 < i) {
                child1 = this.arr[childIdx1];
                if (child1 > val) swapIdx = childIdx1;
            }
            if (childIdx2 < i) {
                child2 = this.arr[childIdx2];
                if (swapIdx != 0 && child2 > child1) swapIdx = childIdx2;
                if (swapIdx == 0 && child2 > val) swapIdx = childIdx2;
            }
            if (swapIdx == 0) break;
            temp = this.arr[swapIdx];
            this.arr[swapIdx] = val;
            this.arr[idx] = temp;
            idx = swapIdx;
            swapIdx = 0;
            temp = 0;
        }
    }
    public void display() {
        for (int j = 0; j < i; j++) {
            System.out.print(this.arr[j] + "\n");
        }
    }
}