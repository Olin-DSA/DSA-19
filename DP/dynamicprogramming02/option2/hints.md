## Text Justification

<details>
  <summary>Hint 1</summary>
  For your subproblem definition, use suffixes: `w[i:]`
</details>


<details>
  <summary>Hint 2</summary>
  Where does the first line break go?
</details>

<details>
  <summary>Hint 3</summary>
  Your subproblem definition will contain the minimum cost for a suffix of words. However, your function needs to return where the line breaks go (not the minimum cost achieved with those line breaks).
</details>

<details>
  <summary>Hint 4</summary>
  Keep an array separate from your `DP` memo, `nextBreak`, where `nextBreak[i]` represents the optimal place to put the next line break, if there is a line break before `w[i]`.
</details>

## Regex matching

<details>
  <summary>Hint 1</summary>
  Think about edit distance from the last homework
</details>

<details>
  <summary>Hint 2</summary>
  Try drawing out a 2D matrix (like in edit distance) with its axes being indexes into the string and the regex.
</details>

<details>
  <summary>Hint 3</summary>
  For your subproblem, think about: "Does `s[:i+1]` match `p[:j+1]`?" What if `p[j]` is a `.`? What if its a `*`?
</details>

## Balloon Popping

<details>
  <summary>Hint 1</summary>
  For your guess, think about where the *last* balloon you want to pop is.
</details>

<details>
  <summary>Hint 2</summary>
  Use subarrays as your subproblem. That is, `DP[i, j]` is the max value obtained by popping `B[i:j]` (our solution did this where both bounds are inclusive). In this case, if `i > j`, then `DP[i][j] = 0`
</details>

<details>
  <summary>Hint 3</summary>
  If `k` is the index of your choice for the last balloon to pop, `i<=k<=j`, you obtain value `B[i-1] * B[k] * B[j + 1]`. This is because `B[k]` is the last balloon in the subarray we pop, so all balloons on its left and right in the bounds `[i, j]` are gone, so the values you multiply by are at `i-1` and `j+1`
</details>

<details>
  <summary>Hint 4</summary>
  Your given problem becomes a subproblem in hint 2 if you pad the outside with 1s.
</details>
