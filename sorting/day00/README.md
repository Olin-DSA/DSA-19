# Sorting Day00 - `InsertionSort` and `MergeSort`

Due on Thursday, February 14th. (our Valentine's Day present to you <3)

## Learning Goals

By doing this assignment, you should be able to:

* Understand and justify the runtime and space complexities of each sort
* Understand how these two sorts are implemented.
* Improve true efficiency of Merge sort by using insertion sort on smaller arrays
  
## Resources

* We created a set of [slides](https://drive.google.com/open?id=1jEnFGECA8TaZM9TyAmEOQum1VT4hY35N) to help you visualize merge sort.
* Refer to [`hints.md`](https://github.com/Olin-DSA/DSA-19/blob/master/sorting/day00/hints.md) if you need additional help.


## Assignment

### Sorts

- Draw the recursive trees (see [here](https://drive.google.com/open?id=1jEnFGECA8TaZM9TyAmEOQum1VT4hY35N)) of the merge sort algorithm for the input array `[4,8,62,9,14,19]`. Show (a photo of) this to your NINJA at checkoff.
- In `InsertionSort.java` and `MergeSort.java` complete the `sort` method.
- For each `sort` function, detail the best, worst, and average case runtime complexity, as well as the space complexity, in the comments.

### Data Structures Review (Boomerang)

**Time: O(N^2) / Space: O(N)**.  Given an array containing n tuples of points in a plane, a "boomerang" is a set of points (i, j, k) such that the distance between i and j is equal to the distance between j and k.  Find the number of boomerangs on the plane. Note that you can never have an odd number of boomerangs because every boomerang set counts twice, as it can be flipped.

For example: Given the set of points [(0,0),(1,0),(2,0)], you should return 2. The boomerangs are [(0, 0), (1, 0), (2, 0)] and [(2,0), (1,0), (0,0)].

Given the set of points [(0, 0), (1, 0), (2, 0), (1, 1)], you should return 8. The four unique boomerangs are [(0, 0), (1, 0), (2, 0)], [(1, 1), (1, 0), (2, 0)], [(0, 0), (1, 0), (1, 1)], and [(0, 0), (1, 1), (2, 0)]. The other four boomerangs with the same set of points are [(2, 0), (1, 0), (0, 0)], [(2, 0), (1, 0), (1, 1)], [(1, 1), (1, 0), (0, 0)], and [(0, 0), (1, 1), (2, 0)].

There are [hints](https://github.com/Olin-DSA/DSA-19/blob/master/sorting/day00/hints.md) for this question.

Test your code with `BoomerangTest.java`.

### Getting checked off

- Talk your NINJA through your recursive trees for merge sort.
- Talk your NINJA through the four commented complexities for the sorting algorithms.
- Talk your NINJA through how you solved the boomerang problem, and why it satisfies the specified complexities.
- Complete the [survey](https://goo.gl/forms/FfDUPvxIR8XxLitj1).

