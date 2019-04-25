# Dynamic Programming - Day01

**Updated: This assignment is due on Monday, April 29**

## Resources

* [Our Slides](https://drive.google.com/open?id=1BtAF6K0lxBfHEukjImDjPdbiwsI1awCXWQ4mTZjxQUA)
* [MIT Lecture on 2D DP](https://www.youtube.com/watch?v=ocZMDMZwhCY)
* [MIT Lecture Notes on 2D DP](https://drive.google.com/open?id=1rekTg-6I9wQevEaXTvH5sQympnePc-2h)

## Solutions

Choose one of the problems below to do in the top-down method, one in the bottom-up method, and the last however you choose. Like last homework, be prepared to explain the 5 steps of Dynamic Programming for each problem (Identify subproblems, guess solution, recurrence relation, memoize/DP array, solve original problem)

## Splitting coins

Vicky has a stack of coins and would like to split them up as evenly as possible with Prava. She is given a set of `N` coins. Each of these coins has a given value. She must place each of these coins in one of two piles. Output the smallest possible difference between the total values of these two piles. 

You are given
* `coins`, an array of all the coins Vicky must split

You will be filling out the function `public int splitCoins(int[] coins)` in `Coins.java` and run tests in `CoinsTest.java`

For example, if she had the coins `{3,1,1,2,5,7}`, she can try to split them up into `{3,5}` and `{1,1,2,7}` and the difference between these two piles would be `3`. The more optimal splitting is `{3, 2, 5}` and `{1, 1, 7}`, for a difference of `1`.

## Edit Distance

There are many cases in which it can be helpful to determine how different one string is from another.  Spellcheck programs use this concept to determine the most likely word attempted, biologists use it to determine how well one strand of DNA matches another, and machine translation programs use it to predict the accuracy of a generated sentence. 

Given two strings `a` and `b`, return the minimum number of operations required to convert string `a` to string `b`. You can apply three different operations to the first string:

    * Insert a new character
    * Delete an existing character
    * Replace one character with another

For example: 

```
a = "sunday"
b = "saturday"

editDistance = 3

Steps: replace n with r, insert t, insert a 
```

## Dungeon Game

Monsters have captured Professor Nick, `N`, and imprisoned him in the bottom-right corner of the Academic Center.  The monsters also went ahead with the old remodelling plan, so the AC now consists of M x N rooms laid out in a 2D grid.  The rest of our valiant teaching team, `T`, will need to fight through the rooms of monsters in order to save Nick.  

The teaching team has a health level indicated by the integer `h`.  If h drops to `0` or below at any point, everyone died, and Nick is stuck with the monsters.

Each room has either a monster or a health power up (e.g. coffee, monster fighting weapons, etc.) and will increase or decrease the health of the teaching team by the integer amount given for that room.

Given the 2D array of integers representing the health values of each room in the AC, assuming the teaching team starts in the top-left corner and Nick in the bottom-right corner, and assuming that the teaching team only moves right or down, return the **minimum initial health** required to save Professor Nick.  We need to know how much coffee to drink before attempting the rescue.

Example:

```
-------------------------
| -2 (T) |  -3	|   3   |
-------------------------
|   -5   | -10  |   1   |
-------------------------
|   10   |  30  | -5 (N)|
-------------------------

map = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}

minInitialHealth = 7, following the optimal path R -> R -> D -> D
```

## Submitting the Assignment
* Go to NINJA hours to get checked off (on or before Monday, April 29th).
* Be prepared to explain the runtime and the 5 DP steps for each of the problems you solved.
* Complete the [survey](https://forms.gle/8srYuVwbZxQbBFPFA).
