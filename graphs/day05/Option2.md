**Stop reading now if you intend to do Option 1**

In the provided RubiksCube class, a Rubik’s Cube is represented with a BitSet of size 72, where every 3 bits represents a block. Each of the 24 blocks stores a color, where colors are represented by a integer from 0-6. Each integer is converted into 3 bits in binary. For example, 0 is [0,0,0], and 6 is [1,1,0]. There are 24 blocks in total on a cube, and that’s why we need 24x3=72 bits.

Each block is numbered as follows:

![](https://i.imgur.com/7Qb7kz0.jpg)

That is, [0, 21, 16] is one cubie, and [6, 11, 14] is another.

The RubiksCube class contains following methods:

* `RubiksCube()`:   The constructor creates a BitSet of size 24*3. Each face on Rubik’s Cube is represented with 4 adjacent bits. For example, [0,1,2,3] is one face, and [4,5,6,7] is another face. The constructor also assigns color to all faces and produces a solved Rubik’s Cube.
* `setColor(int index, int color)` : This method assigns a color to a block. A block is indexed from [0-23], and color [0-5].
* `getColor(int index)` : This function returns a specific block’s color. `index` is from [0-23].
* `rotate(List<Character> c)`： This methods takes a list of rotation commands (see glossary for notation). This methods calls rotate(char c) on each command.
* `rotate(char c)`: This method rotates a Rubik’s Cube based on the command.
* `intToBitset(int i)`: Convert an integer to a bitset of size 3
* `bitsetToInt(BitSet s)`: Convert a bitset to an integer
* `equals(Object obj)`： Assert that two Rubik’s Cubes have the same configuration
* `hashCode()*`: Return a hashcode of the Bitset
* `isSolved()`: Check the current cube with a newly constructed cube which is by default solved.

To get started, delete `src/RubiksCube` and replace it with `ourimplementation/RubiksCube`.