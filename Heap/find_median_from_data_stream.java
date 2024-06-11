class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // For the lower half
    private PriorityQueue<Integer> minHeap; // For the upper half
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap to store the larger half of the numbers
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        // Balance the heaps: ensure the smallest element in maxHeap is less than the largest in minHeap
        minHeap.offer(maxHeap.poll());

        // Balance sizes: maxHeap can have at most one more element than minHeap
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
         // If the heaps have different sizes, max-heap will have one extra element
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            // If the heaps are the same size, the median is the average of the two heap tops
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
