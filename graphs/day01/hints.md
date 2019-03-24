## N-Queens

<details>
  <summary>Hint 1</summary>
  There must be a queen in every row of the chess board. Start at the top row of the board, and try to assign a queen to each column. Pass along which row you are currently assigning as a variable in your recursive function.
</details>

<details>
  <summary>Hint 2</summary>
  Use a data structure with O(1) access to store which columns contain queens.
</details>

<details>
  <summary>Hint 3</summary>
  We have provided a function to check if a Queen is on a the same diagonal as an input location (read the function comment to understand what it does). You may find this function helpful when checking if a location is valid for a queen.
</details>

## Coins on a Clock

<details>
  <summary>Hint 1</summary>
  Keep track of how many of each coin you have remaining. If all are 0, then you have completed the puzzle.
</details>


<details>
  <summary>Hint 2</summary>
  Make one of your recursion variables the current location to place a coin (for example, call it `i`). Ie, for your first recursive call, `i=0`. If you then place a dime, in your next recursive call, `i=10`.
</details>

## Cryptarithmetic Puzzle
<details>
  <summary>Hint 1</summary>
  Keep track of a `Set` of unassigned characters in your recursion.
</details>