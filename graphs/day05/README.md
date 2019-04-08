## Graphs 05

This homework is due on **Thursday, April 18th**
It is strongly recommended you work with a partner for this assignment

Congrats on solving the 8-puzzle! We now have another classic challenge for you: solve a Rubik’s Cube! For computation’s sake, we are only asking you to solve a 2x2x2 cube. Due to the potential complexity of this assignment we are giving you two options for this homework. But first some terminology:

### Resources

* [Our Slides](https://docs.google.com/presentation/d/1kBJVDhhlG-r-weEx7AmE2V5276HaONmR4yVf3mjtVGU/edit?usp=sharing)

### Glossary

* Block - A single colored square. There are 24 blocks on a 2x2x2 Rubik's Cube
* Cubie - An unalterable piece of the cube, the corner. Each cubie contains 3 blocks. There are 8 cubies on a 2x2x2 Rubik’s Cube
* Face - A side of a Rubik's Cube. Each face is made up of four blocks and four cubies. There are 6 faces on a 2x2x2 Rubik's Cube.
* Rotation - Counterclockwise or clockwise movement of the cubies relative to a given face. There are 6 specific and unique rotations, where direction is defined as when looking at the front face of the cube:
    * Rotate the front face clockwise: **f**
    * Rotate the upper face clockwise: **u**
    * Rotate the right face clockwise: **r**
    * Rotate the front  face counterclockwise: **F**
    * Rotate the upper face counterclockwise: **U**
    * Rotate the right face counterclockwise: **R**
* Solved - When every face is composed of four blocks of the same color.

![](https://i.imgur.com/1XeMT1L.png)

### Option 1- Create your own data-structure, and use BFS

Keeping true to the name of **Data Structures** and Algorithms, in this version of the homework you will be implementing your own model of a 2x2x2 Rubik's Cube, as a class in `RubicksCube.java` .

Methods and variables (written out as shown) necessary for passing our tests will be:

* `public RubiksCube()` - Constructor for the `RubiksCube` class. Creates a solved version of the cube.
* `public boolean equals(Object cube)` - Takes in a Rubik’s Cube object and compares it to itself for equality.
* `public int hashCode()` - overrides hashCode, allowing for hash-set/hash-map functionality with RubiksCube objects
* `public RubiksCube rotate(char c)` - Takes in a character that represents the rotation of a face (see above) and performs that rotation on your cube model. This returns a new Rubik’s Cube (it doesn’t modify the original)
* `public boolean isSolved()` - Returns whether the cube this method is called on is in a solved state.
* `public List<Character> solve()` - Returns the set of rotations as a list of characters (see above for notation) needed to solve the cube this method is called on. For this option you need only use BFS, however feel free to use A* (or something else!) if you want an extra challenge.

The tradeoff comes in that instead of writing an A* solution, you just need to implement BFS for your `solve` method. No heuristic necessary!

### Option 2 - Create your own heuristic and search algorithm, use our data-structure

Alternatively, you can use the Rubik’s Cube class we provide. You will need to understand how it works (refer to the slides). You will come up with your own heuristic and implement an A* solution (or some other interesting algorithm). Your algorithm should solve the Rubik’s cube faster and more efficiently than a BFS approach.

Your heuristic should provide information that quantifies how “solved” a Rubiks’s cube is. This information helps your algorithm to go to the right direction when exploring solutions.

If you have chosen to do option 2, continue reading it [here](Option2.md)

### Check off
* Fill out the [survey](https://forms.gle/QG4GuwsSH9uzmYbK6)
