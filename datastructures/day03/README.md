# Day03 - Linear data structures review
This homework is due Thursday, February 7th (see below for submission details).

# Learning Goals

- Think critically about how to use linear data structures covered so far (Arrays, ArrayLists, Stacks, Queues, LinkedLists) to write efficient algorithms
- Analyze runtime and space complexity of algorithms
- Begin developing an approach to solving algorithm problems

## Resources

- Problem solving guide:  [NFFSSSSSS](https://drive.google.com/open?id=1K1AIHLVg6HOh6qhXTkvFwOiAebhcPfkcT6aJuBmdSQQ)

# Problems

## Remove K Digits

**Time: O(N) / Space: O(N)** Given a non-negative integer represented as an array (e.g., 329 would be `[3, 2, 9]` and an integer k, remove k digits from the number so that the new number is the smallest possible. Assume `k < arr.length`. Return the new number as a `List`. Test your code with `RemoveKDigitsTest.java`. For example, given the list representing `1,432,219` and `k=3`, return the list representing `1,219`

## SLL Palindrome

**Time: O(N) / Space: O(1)** Given the head-node of a singly linked list storing ints, return true if the values in that list are palindromic. You are allowed to modify the input linked list. It may be helpful to think about how to do it with O(N) space first, and then optimize so that you use constant space in your final solution.

## Infix to postfix

**Time: O(N) / Space: O(N)** Infix is a form of notation you are probably familiar with, where the operator is between every pair of operands. Eg, `( 1 + 2 )` and `( ( 2 * 3 ) + 1 )`. In postfix form, the operators come after the two operands. The two previous expressions in postfix notation are `1 2 +` and `2 3 * 1 +`. Given a space-separated string of integers, operands (`+`, `-`, `/`, `*`), and parenthesis in infix notation, convert it to postfix notation. Here are some important notes/assumptions you can make while writing this algorithm:

- Postfix notation does not require parenthesis to specify order of operations, therefore your output should never contain parens.
- You can assume that every operation is surrounded by parenthesis. Eg, your code should be able to convert `( ( 2 * 3 ) + 1 )` to postfix, but you don't have to worry about converting `2 * 3 + 1` or `(2 * 3) + 1`.

Test your code with `InfixToPostfixWithParens.java`.

## Optional: Infix to postfix extension

How can you rewrite your function so that you don't need every operation to be surrounded by parenthesis? You can assume:

- You can ignore order of operations in the infix notation. That is, `1 + 2 * 3` should be converted to `1 2 + 3 *`

Test your code with both `InfixToPostfixWithParens.java` and `InfixToPostfixNoParens.java`.

## Submitting the assignment

To get credit when you're done:

- Go to NINJA hours to get checked off (on or before Thursday, February 7th)
- Submit [this](https://tinyurl.com/OlinDSA-03) survey
