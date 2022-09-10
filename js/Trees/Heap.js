"use strict";
class Heap {
    constructor(value) {
        this.values = [];
    }
    insert(value) {
        this.values.push(value);
        this.bubbleUp();
    }
    bubbleUp() {
        let idx = this.values.length - 1;
        let element = this.values[idx];
        while (idx !== 0) {
            let parentIdx = Math.floor((idx - 1) / 2);
            let parent = this.values[parentIdx];
            if (element > parent) {
                this.values[idx] = parent;
                this.values[parentIdx] = element;
            }
            idx = parentIdx;
        }
    } //remove
    extractMax() {
        let max = this.values[0];
        let getLast = this.values.pop();
        if (this.values.length > 0) {
            this.values[0] = getLast;
            this.sinkDown();
        }
    }
    sinkDown() {
        let idx = 0,
            element = this.values[idx];
        let len = this.values.length;
        let leftChildIdx, rightChildIdx, leftChild, rightChild;
        while (true) {
            leftChildIdx = 2 * idx + 1;
            rightChildIdx = 2 * idx + 2;
            let swap = null;
            if (leftChildIdx < len) {
                leftChild = this.values[leftChildIdx];
                if (leftChild > element) {
                    swap = leftChildIdx;
                }
            }
            if (rightChildIdx < len) {
                rightChild = this.values[rightChildIdx];
                if (rightChild > leftChild) {
                    swap = rightChildIdx;
                }
            }
            if (swap === null) return;
            let temp = this.values[idx];
            this.values[idx] = this.values[swap];
            this.values[swap] = temp;
            idx = swap;
        }
    }
}
