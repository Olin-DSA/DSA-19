# Hints

## Range Queries

<details>
  <summary>Hint 1: Optimal Complexities</summary>
  rangeCount should run in O(log(N)). rangeIndex should run in O(log(N) + L), where L = number of keys between [lo,  hi].
</details>

<details>
  <summary>Hint 2: rangeCount </summary>
  As a first step, write a function rank(k) which returns the number of keys <= k.
</details>

<details>
  <summary>Hint 3: rangeCount </summary>
  Augment the RangeNode to store the number of nodes in its subtree.
</details>

<details>
  <summary>Hint 4: rangeIndex </summary>
  Your solution to this will look quite similar to an in-order-traversal.
</details>
