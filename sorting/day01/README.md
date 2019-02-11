# Sorting Day 1 - Quicksort, Heaps and `HeapSort`

This homework is due Thursday, February 21st (see below for submission details).

## Learning Goals

By doing this assignment, you should be able to:

* Understand and justify the runtime and space complexities of quicksort
  * Why quicksort is O(logN) space
* Understand how these two sorts are implemented.
* Avoid worst case performances (time and/or space) of Quick sort by randomly shuffling before sorting
* Understand the heap sort algorithm:
  * Understand why building a heap is O(N) time
  * Understand why heap sort is worst, average and best case O(NlogN) time
  * Understand the O(1) space complexity of heap sort
* Understand how to implement a priority queue
  * How to implement it using a max-heap

## Resources

* You can find our slides about heapsort [here](https://docs.google.com/presentation/d/1MqtQkyYduoSxgNQtQ5Mh_c4TxFreSdY87sbw17IbvzA/edit?usp=sharing).
* [MIT lecture slides](https://drive.google.com/open?id=1A-T35tNHuOmlW4Y_u_65HMSGGzBsIljC) on Quicksort, which also covers why randomization guarantees O(NlogN) time. Corresponding lecture [here](https://www.youtube.com/watch?v=vK_q-C-kXhs)
* Quick [stackexchange](https://cs.stackexchange.com/questions/35509/can-anybody-explain-intuitively-why-quick-sort-need-logn-extra-space-and-merge) covering space complexity of Quicksort vs Mergesort

## Assignment

### Quicksort + Heapsort

- For both `HeapSort.java` and `QuickShort.java`, complete the methods annotated with `TODO`s so that `sort` runs; use (or not) the helper methods and method declarations we've provided for you.

- Detail the best, worst, and average case runtime complexity in the comments. Also, detail the space complexity.

### Running Median

For this problem, you might find it helpful to use a priority queue (PQ). Java offers an implementation of `PriorityQueue`, with the following methods:

- `isEmpty`
- `size`
- `peek`
- `offer`, which is the same as `enqueue` from the queue you implemented.
- `poll`, which is the same as `dequeue` from the queue you implemented.

[Here's](https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html) the API.

#### The Problem

You are given an input stream of integers `inputStream`. Return a `double[] runningMedian`, where `runningMedian[i]` is the median of all elements in `inputStream[:i+1]`, that is, up to and including `i`.

You can think of it like you are seeing the integers one at a time, and at any given time you must output what the median of all the integers you've seen so far is.

You may find it helpful to think about the O(N^2) solution first. Maintain a sorted dynamic array `sortedArray`, and after each element comes in, find its place in the sorted array and insert it, then output the median of the sorted array. Why is this O(N^2)?

The code for the N^2 solution is provided in `Problems.java`. Can you do better? For your convenience, we provide two helper functions which initialize a maxPQ and a minPQ which store Integers. Feel free to use one or both in your solution.

### Feeling Stuck?

Check out the [hints](https://github.com/Olin-DSA/DSA-19/blob/master/sorting/day01/Hints.md)!


## Submitting the Assignment

To get credit when you are done:
- Go to NINJA hours to get checked off (on or before Thursday, February 21st).
- Provide an explanation for each of the four heapsort complexities to your NINJA.
- Provide an explanation for each of the four quicksort complexities to your NINJA.
- Talk your NINJA through your solution to the running median problem
- Complete the [survey](https://tinyurl.com/OlinDSA-06
).
