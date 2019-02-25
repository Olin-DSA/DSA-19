# Sorting Day 4 - Divide and Conquer

This homework is due Thursday, February 28 (see below for submission details).

## Learning Goals

- Gain experience designing divide and conquer algorithms
- Write efficient algorithms using the Base Case, Divide, Conquer, Combine format
- Be able to analyse runtime of recursive algorithms.

## Resources

- [Notes from today's lecture](https://docs.google.com/presentation/d/1I2WI0X_SqtQ7iSRFgKcTbW5dnT3DeOHiYyqvEVncwxo/edit?usp=sharing)
- [MIT Lecture](https://youtu.be/-EQTVuAhSFY?t=1m17s) on Divide + Conquer. Our lecture used material from the first ~17 minutes of this lecture.
- [MIT Convex Hull lecture](https://youtu.be/EzeYI7p9MjU?t=7m16s). Skip [here](https://youtu.be/EzeYI7p9MjU?t=36m17s) if you just want the discussion on the Combine step.
- If you are doing the Peek-finding problem for HW, you will likely find [this](https://drive.google.com/open?id=189xjtCH--VZ7dug5-Df5Quig9GVuk35W) PDF useful, as well as the corresponding [video lecture](https://www.youtube.com/watch?v=HtSuA80QTyo&feature=youtu.be&t=15m26s) (also linked down below).
- There is a [`hints.md`](https://github.com/Olin-DSA/DSA-19/blob/master/sorting/day04/hints.md) document for all of these questions!

## Assignment

For this assignment, **choose one of the following algorithms, and complete the associated file so the tests pass.**

Remember that there is a [`hints.md`](https://github.com/Olin-DSA/DSA-19/blob/master/sorting/day04/hints.md) document with hints for all of the following questions.

### Boston Skyline

Suppose you are looking out at Boston's skyline, and you see a series of building in a 2D plane. You know the `left`-boundary, `right`-boundary, and `height` of each building. Each for example, the following buildings

![](https://i.imgur.com/em5O3uy.jpg)

Are represented by `[[1, 3, 2], [2, 4, 1], [3, 5, 4], [6, 8, 2], [7, 9, 1]]`.

Your task is to write an algorithm that outputs the "skyline" of a series of buildings, represented by the left-most point of each line along the silhouette. For example, the previous building's skyline looks like this:

![](https://i.imgur.com/gktU3lV.jpg)

For this series of buildings, your function would return `[[1, 2], [3, 4], [5, 0], [6, 2], [8, 1], [9, 0]]`. Your algorithm should run in better than `O(N^2)` time, where N is the number of buildings.

### Radio Towers

You are tasked with validating a set of radio tower coordinates. No two towers share an x-coordinate, and no two towers share a y-coordinate. Your job is to make sure no two radio towers are within 1 euclidean mile of eachother, or they will broadcast over eachother.

Design and write a divide-and-conquer algorithm that determines if the set of towers contains two towers within 1 mile of eachother. Return false if there are two such towers. Your input comes in the form of two sorted lists. `Lx` contains all the towers sorted in ascending order by `x` coordinate, and `Ly` contains the towers sorted in ascending order by `y` coordinate. Both lists contain the same set of towers, just in a different order.

For your "Combine" step, we recommend you write an algorithm that, given a "strip" `S` of radio towers whose y-coordinates fall in 2-mile vertical strip, sorted by x-coordinate, returns if `S` is valid in O(N) time. We have provided a function header for this function, as well as unit-tests.

After the "Divide" and "Conquer" steps, if the subproblems do not find any violation, the only place violations can still happen is in the strip `S`, which we check in the "Combine" phase using `checkStrip`.

When implementing `checkStrip`, use the following pseudocode:

```
checkStrip(strip) {
  for i in [0, strip.length):
    for j in [i + 1, i + 8):
      if j < strip.length and (strip[i] and strip[j] within distance 1 of eachother):
        return False
  return True
}
```

Note that for a tower `t` in `S`, we check the distance between `t` and 7 towers in `S` following `t` (which have larger x coordinates). If any pair has distance within 1, return false. The following is a proof of why this is sufficient for the "Combine" step:

We divide `S` into squares of size 1/2. No two valid towers can be in the same 1/2 by 1/2 square. Each square contains at most one tower, otherwise a pair within the same square should have been detected during "Conquer". For a tower `t` in `S`, a following tower within distance 1 must be inside a 2-by-1 rectangle along the strip. There are only 8 such squares. Thus, excluding `t` itself, only 7 following towers need to be checked. (Towers with smaller x coordinates have already been checked against `t`.)

![](https://i.imgur.com/0oS0ntc.jpg)

### Peak-Finding

#### 1-D Array

Imagine you had a 1-dimensional array of numbers. A peak of that array would be any element that is not less than either of its neighbors (assuming `nums[-1] = nums[N]= -INF`). For example, in `[3,2,3,4,5,6,4,3,2]`, the peaks are the first `3` and the `6`. In `[1,1,1,1,1]`, every element is a peak.

One way of solving this in `O(N)` time is to look at every element until you find an element that is a peak, or find the global maximum. We can do this in `O(log N)` time using a binary search technique! (how??)

**In `PeakFinding.java`, implement `int findOneDPeak(int[] nums)` and return the index of ANY peak in `O(log N)` time.**

#### 2-D Array

Now that you have warmed up, solve this same problem in two dimensions. An element is a peak in a two dimensional array if it is not less than any of its four non-diagonal neighbors (or at least the neighbors that exist, meaning values on the edges can also be peaks). Your algorithm is expected to run in O(N) time, where `N` is the length of one dimension of the grid, assuming it is a square.

##### O(NlogN) Solution

Think about using the 1-D method (which is `O(logN)`) on the max elements of each column, (finding each is `O(N)`), and comparing each max element to the elements on *directly* its left and right. You would only perform O(logN) max operations, so the overall runtime is O(NlogN).

The [MIT lecture notes](https://drive.google.com/open?id=189xjtCH--VZ7dug5-Df5Quig9GVuk35W) explain this algorithm thoroughly. If you prefer watching a lecture to reading notes, [here's the accompanying lecture](https://youtu.be/HtSuA80QTyo?t=15m26s).

##### Design an O(N) algorithm

**Implement `int[] findTwoDPeak(int[][] nums)`, where `answer[0]` is the row index and `answer[1]` is the column index of any peak. In other words, the peak is `nums[answer[0]][answer[1]]`.**

## Getting Checked Off

- Talk your NINJA through your solution and runtime to whichever algorithm you implemented
- Explain the Base Case, Divide, Conquer, Combine steps you used.
- Fill out the [survey](https://tinyurl.com/OlinDSA-09).
