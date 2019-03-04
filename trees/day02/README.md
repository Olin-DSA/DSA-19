# Trees Day 2 - 2-3 Trees, and Left-Leaning Red Black Trees

* [Slides](https://drive.google.com/open?id=1cR7LyDS0_BXIbnGHiTGZgxVEhrpR0cx722zy0EHlq2Q) from class lecture
* [Princeton Lecture Notes](https://www.cs.princeton.edu/~rs/talks/LLRB/RedBlack.pdf): The most helpful information is around page 36.
* [Video on 2-3 Trees and their relation to RB Trees](https://www.youtube.com/watch?v=9PiitpHLvRM)
* [Okay video on LLRB Trees](https://www.youtube.com/watch?v=0BeIo4JB0Z4)

This assignment is due Monday, March 11th at Midnight

## Learning Goals

By doing this assignment, you will:
* Understand why a 2-3 tree's balance factor is always 0
* Understand what a 2-3 tree's equivalent LLRB is
* Identify legal/illegal LLRBs
* Be able to insert into an LLRB and have it still be legal
* Know the runtime complexity of insert/search/delete in an LLRB

## Exercises

Build both a 2-3 tree and a LLRB for the following array (inserting in order):

- `[8, 1, 4, 0, 2, 7, 10, 9]`

Make sure you draw each step (and keep it). Your NINJA will ask you to walk through the process.

## Code

#### Changes

- We have created a new class called `RedBlackTree`. It includes helper functions such as `isRed` and `isBlack`
- `RedBlackTree` contains two functions: `is23` and `isBalanced`, which can be used to verify that a tree is a legal LLRB (we asked you to write these two algorithms in PSET today. Read them and make sure you understand them, since the test suite relies on them)
- `TreeNode` now does NOT keep track of the height of the node. Instead, it stores `color`.

### Implementation

#### `insert(TreeNode<T> n, T key)`

Implement `insert` based on the lecture in class and the materials we've provided above.

Note that in order to implement `insert`, there are some helper functions you should write:

 * `rotateRight(TreeNode<T> n)`
 * `rotateLeft(TreeNode<T> n)`
 * `flipColors(TreeNode<T> n)`
 * `balance(TreeNode<T> n)`

All of these functions have tests (except `balance`, which is tested by `insert`). You will probably find writing your own tests is helpful as well.

Make sure you note the runtime of `insert` in your comments.

#### (Optional) `delete(TreeNode<T> h, T key)`

We did not cover deletion in 2-3/LLRB trees today in class. Use the **Princeton Lecture Notes** to implement delete in your LLRB.

### Checkoff
- Be ready to talk about relative benefits of RB trees vs AVL vs B Trees
- Get your work checked by a NINJA or Instructor
- Fill out the survey [here](https://drive.google.com/open?id=1IONnQfbAgfBAjKZ3pAAEB5tk7KO9vxPaVKlENq-KsHM)
