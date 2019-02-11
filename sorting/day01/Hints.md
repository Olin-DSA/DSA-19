# Hints

## Heapsort Hints
<details>
<summary>Heapsort Hint</summary>
    Move the root (which you know is the biggest element if the array has been heapified) to the end and then sink the value you swapped it with. Now the second biggest value will be the root. Repeat this process.
</details>

## Running Median Hints
<details> 
  <summary>Hint 1</summary>
    In order to find the median of an array, we only need to know the value of either one or two elements in the corresponding sorted array. For example, if currently we've seen elements `[4, 3, 1, 5, 2]`, we only need one element from the corresponding sorted array `[1, 2, 3, 4, 5]`, which is the one at index `2` (which is `3`). If we add a number (say, 4), then the sorted array becomes `[1, 2, 3, 4, 4, 5]`, and we only need to know the elements at indices `2` and `3` to calculate the median (which evaluates to `3.5`).
</details>

###

<details> 
  <summary>Hint 2</summary>
    As we receive numbers in our input stream we can successfully store 2 numbers: 1. The number after the median (when the array is in sorted order), and 2. The number before the median (or the median itself, if the array is odd-length). Therefore, we can calculate the median each time we receive a new number. 
</details>

###

<details> 
  <summary>Hint 3</summary>
    Store all the numbers before or equal to the median in one data-structure, and all the numbers after the median in another data-structure. Which data structure will allow you to quickly find the median each time you see a number, and to shift elements back-and-forth quickly?
</details>