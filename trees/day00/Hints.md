# Hints

## Binary Search Tree Hints
   <details>
   <summary>In order traversal hint</summary>
       Try making a helper function which you can call recursively. Make sure to call in order traversal on all the left children of a node before adding said node to the list. Then call it on its right children.
   </details>
   

###

   <details>
   <summary>Find successor hint</summary>
       If a node has a right child, then its successor would be the bottom most left child of the right child (or just the right child itself if the right child node has no left children). Think about when a parent might be the successor.
   </details>
   
###

   <details>
   <summary>Find predecessor hint</summary>
       If a node has a left child, then its predecessor would be the bottom most right child of the left child (or just the left child itself if the left child node has no right children). Think about when a parent might be the predecessor.
   </details>
   
###

  <details>
  <summary>Delete hint</summary>
      Make use of your find predecessor function and the moveChildrenFrom TreeNode function. You also may want to consider using recursion.
   </details>
   
## minimalHeight Problem Hints

<details>
<summary>Hint 1</summary>
Think about what element must be inserted first
</details>

###

<details>
<summary>Hint 2</summary>
Think about how you would use recursion
</details>

###

<details>
<summary>Hint 3</summary>
Think about binary search and how you may apply it
</details>

## isIsomorphic Problem Hints

<details>
<summary>Hint 1</summary>
Try everything
</details>

###

<details>
<summary>Hint 2</summary>
Remember the the generic algorithm for BSTs? How can you tweak it to swap left and right children of different nodes?</details>
</details>

###

<details><summary>Hint 3</summary>
If two tree are isomorphic, for each node in 1 of the trees there are 2 possibilities: the node's children are the same in the isomorphic version or they are switched. If we check for equality in both of these cases and one returns true, at least that node and its children are isomorphic (but what about the childrens' children?)
</details>