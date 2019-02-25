# Hints

## Boston Skyline

<details>
  <summary>Hint 1</summary>
  First, imagine you already have two "skylines", and you overlay them. Write a function that outputs the corresponding "merged" skyline.
</details>

<details>
  <summary>Hint 2</summary>
  Your algorithm for this problem will look very similar to mergesort.
</details>

<details>
  <summary>Hint 3</summary>
  Split the list of buildings in half. Calculate the skyline for each half, and then merge the results together.
</details>

## Radio Towers

<details>
  <summary>Hint 1</summary>
  Split the problem in half with a horizontal line. Then divide and conquer.
</details>

<details>
  <summary>Hint 2</summary>
  Solve the problem for the top-half and bottom-half of towers by recursively calling `validTowers` and splitting apart `Lx` and `Ly` into the `Lx` and `Ly` for the top and bottom halves of the towers. Then use your `checkStrip` function on the towers along the border of the two halves.
</details>

## Peak-Finding

<details>
  <summary>Hint 1</summary>
  The problem with the NlogN solution is that even as we cut down the problem horizontally, the problem never shrinks vertically, and we keep paying an O(N) cost to find the max of the current column we're considering.
</details>

<details>
  <summary>Hint 2</summary>
  After we've "divided" the problem in half twice, how can we make sure the problem has been cut in half in both dimensions?
</details>

<details>
  <summary>Hint 3</summary>
  Alternate between looking at the max of a column and comparing it to the elements to its left and right and looking at the max of a row and comparing it to the elements above and below it.
</details>