## Assignment

You are free to write these solutions in whichever manner you prefer, top-down or bottom-up. Implement at least **two** of the three following problems.

Nothing should take very long to run. Let's say no more than 30 seconds for any of the tests.

### Text Justification

Given a body of text as an array of strings in order (`w`) and the maximum length (`m`) of a line, return a `List` of the indices of the first word of each line of justified text.  For example:

```
w = {"This", "is", "an", "example", "of", "text", "justification"}
m = 16

This   is    an
example of text
justification
```

should return the array `{0, 3, 6}`.

The cost of line l is c(l):
* c(l) = INF, if total_length(l) > m
* c(l) = (m - total_length(l))^3, otherwise

where:
* total_length = words + single space between each word (i.e. the number of words in the line - 1)
* m = the maximum length of a line

We have [hints!](./hints.md)

### Regex Matching
Write a function that implements regular expression matching for `'.'` and `'*'`. `'.'` matches any single character, while `'*'` matches 0 or more of the preceding character. The matching should cover the entire input string. Your inputs will be `s`, the input string, and `p`, the regular expression.

For example:

```
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
```
We have [hints!](./hints.md)

### Balloon Popping
You are given a list `B` of balloons. Each balloon is worth a specified amount of points represented by its value in the list. You must find the maximum value you can achieve by popping the balloons in the optimal order.

When you pop a balloon, you gain points equal to the product of the value of that balloons with the values of the balloons on its left and right. Then, that balloon disappears and its neighbors move together.

Return the maximum points possible

For example:
```
Input: [2, 4, 3, 5]
Choices=    3           4         2         5
List = [2,4,3,5] --> [2,4,5] --> [2,5] --> [5] --> []
Points =  4*3*5   +   2*4*5   +  1*2*5 + 1*5*1   = 115
Return 115
```
We have [hints!](./hints.md)
