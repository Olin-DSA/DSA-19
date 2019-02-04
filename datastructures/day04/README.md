# Day04 - Hashmaps

## Learning Goals:

Students will be able to:

- Know how to use Maps in software engineering applications.
- Create an efficient implementation of Java's `Map` interface using an array of `LinkedList`s of key-value pairs.
- Understand the key concepts of hashing
  - Understand hash functions and considerations when creating them
  - Understand how a hash map chooses which bucket to place objects in
- Understand how a hash map achieves average constant time for `put`, `get`, and `remove`.
- Identify when using a map / hash map is effective

## Due Date:

Midnight, Monday Feb. 11, 2018

## Assignment

### Resources
- [Here](https://drive.google.com/open?id=1SLt9ISrA3oyT35w6TzcF3ke0QyzS9jB4jPqtjwkoGm4) are our slides for hashmaps.

- [This](https://youtu.be/shs0KM3wKv8?t=7s) is a really short video explaining hashmaps. It does a really good job explaining exactly what a hash function does, and how it's used in Hashmaps.

- [Think Data Structures](http://greenteapress.com/thinkdast/thinkdast.pdf) - Starting at Page 87. Covers hashing and hashmaps.

- [Super great amazing explanation of Hashmaps](https://www.youtube.com/watch?v=TQls-N_TqMw)

### Code
Prava has a lot of goats and not enough time to keep track of all of them. She needs a data structure to quickly store and retrieve their stall locations. Good thing you have the perfect solution!

To help Prava out, you will be **implementing your own Java Map**. That is, your object will satisfy the Java Map API. If your code isn't passing tests, make sure you understand what each of your functions is supposed to do by reading the [Java Map API](https://docs.oracle.com/javase/7/docs/api/java/util/Map.html). There are also comments in the code detailing what each function should do.

In `MyHashMap.java`, implement:
* **Internal**:`chooseBucket(Object key)`
* **External**:`get(Object key)`
* **External**:`containsKey(Object key)`
* **External**:`containsValue(Object value)`
* **Internal**`rehash(double growthFactor)`
* **External**:`put(K key, V value)`
* **External**:`remove(Object key)`

(By **Internal** we mean the functions only accessible inside the API)  
(By **External** we mean the functions accessible to the coder using the API)

### Problems

Read SillyString.java. Understand the potential use of this class and try to identify issues with its hashCode() method.

### Checkoff

To be checked off, you'll be expected to explain (among other things):
- the main purpose of a hash function. Are there any requirements or limitations when hashing?
- at least one problem with SillyString's hash function.

### Survey

Fill out the survey [here](tinyurl.com/OlinDSA-04).
