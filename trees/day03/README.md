# HW 14 - BST/Divide+Conquer Review

**This assignment is due Thursday, March 14**


## Learning Goals

By doing this assignment, you should

* Gain practice working with BSTs and/or Divide/Conquer algorithms, and using them write efficient algorithms

## Assignment

**For this assignment, pick one of the two following problems**:

## Divide and Conquer

Choose one of the three problems from the [the D+C conquer HW](https://github.com/Olin-DSA/DSA-19/tree/master/sorting/day04) to do (do not choose the one you have already done). Make sure you note your Base Case, Divide, Conquer, Combine steps, and determine the runtime of your algorithm.

## Range Queries

You are tasked with designing a data structure which supports efficient range-queries. More specifically, you will receive a series of input keys (as integers), and you must be able to perform the two following operations efficiently:

* `rangeCount(lo, hi)` return the number of keys that are in the bounds `lo <= k <= hi`
* `rangeIndex(lo, hi)` return a sorted list of all keys that are in the bounds `lo <= k <= hi`

We recommend an AVLTree as a starting point, and have provided our solution in the file `AVLRangeTree`. **It is expected that you modify `AVLRangeTree`, and/or `BinarySearchTree`, and/or `RangeNode`.** Augment the data structure in order to more efficiently perform these operations. Your `AVLRangeTree`'s performance on `insert`, `delete`, and `find` must remain `O(logN).`

**See the [`hints.md`](https://github.com/Olin-DSA/DSA-19/blob/master/trees/day03/hints.md) document for hints on this question.**

**As always, consider the runtime of any code you write**

## Getting Checked Off

- Talk your NINJA through your solution and runtime to whichever algorithm you implemented
- Fill out the [survey](https://goo.gl/forms/pyD7UqqPUuewB80h1).
