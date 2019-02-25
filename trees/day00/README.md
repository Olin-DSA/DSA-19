# HW 11 - Intro to Binary Search Trees

This homework is due on Monday, March 4th (see below for submission details).

## Learning Goals
After doing this assignment, you should
* understand the structure of BSTs
* learn how to execute an in order traversal on a BST
* learn how to find the successor and predecessor of a node
* have explored properties of BSTs

## Resources

* Checkout our slides [here](https://docs.google.com/presentation/d/1T--3jAs4A28ekGtQ0OKtWQKVC_dK27CY8RUk5HNchsE/edit?usp=sharing). These have some information on the pre-written functions
* MIT lecture notes [here](https://drive.google.com/open?id=1t1AzWW_1FeFpn8GSCRgGY2rPtw5zg_ws).

## Binary Search Tree Implementation

1. Implement the following methods in `BinarySearchTree.java`:
  * `public List<T> inOrderTraversal()` Performs an in-order traversal of the tree. <br>
    * How would you traverse the tree such that the smallest-key
      node is processed first, and the largest-key node is processed
      last? <br><br>

  * `public T findSuccessor(T key)` Finds the node immediately following `n` in the in-order traversal of the entire tree.
      * What if n has no successor?<br>
      * What if its successor is one of its descendants?<br>
      * What if its successor is one of its ancestors?<br><br>

  * `public T findPredecessor(T key)` Finds the node immediately preceding `n` in the in-order traversal of the entire tree
  Run corresponding tests in `BinarySearchTreeTest.java` to make sure your implementations are correct.
    * What if n has no predecessor?<br>
    * What if its predecessor is one of its descendants?<br>
    * What if its predecessor is one of its ancestors?<br><br>
2. What is the worst case runtime of `inOrderTraversal`, `findSuccessor` and `findPredecessor`? (think carefully)
3. Handle the third case of the `delete` function. If you remember from lecture, there are 3 cases:
  * Node has no children
  * Node has one child
  * Node has two children


## Visualization

1. Draw the binary search tree resulted from inserting the keys [20,10,15,12,18,11,14,16,19,13,17].
2. Explain to your NINJA the step by step process (by drawing) of these operations on your tree above, noting down all pointer changes at each step:
  * `delete(15)` then
  * `delete(10)` then
  * `delete(19)`

## Problems

Choose at least one of the following problems:

1. Given an unsorted array, create a binary search tree with minimal height. Implement this in `Problems.minimalHeight`.

2. Two trees T1 and T2 are isomorphic if T1 can be transformed to T2 by swapping left and right children of (some of) the nodes in T1. Write a function that determines if two trees are isomorphic. You are given their root nodes. Implement this in `Problems.isIsomorphic`. In the image below, the first, second and third binary trees are isomorphic with each other, while the last is not since the children of node 2 and 3 were switched. 


You can find a reference image [here](https://drive.google.com/open?id=1VJaDcC_J4n-JGSptVUEIFtj4Ls3pbwwC).

## Feeling Stuck?

Check out the [hints](https://github.com/Olin-DSA/DSA-19/blob/master/trees/day00/Hints.md)!

## Submitting the Assignment
* Go to NINJA hours to get checked off (on or before Monday, March 4th).
* Talk to a NINJA with your working test cases and BST drawing. Make sure you are prepared to explain your high-level solution to the problems **without looking through your code**. Feel free to draw out the steps of your algorithm beforehand if you feel like it would help.
* Complete the [survey](https://goo.gl/forms/h1orPQaz9EiIVkNQ2).
