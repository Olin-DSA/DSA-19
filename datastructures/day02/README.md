# Day02 - `Linked Lists, Stacks, and Queues`
This homework is due Monday, February 4th (see below for submission details).
# Learning Goals

- Understand memory allocation of linked lists
- Understand the need and implementation of pointer based data structures
- Be able to analyze time complexities of linked lists
- Understand when to use a LinkedList versus an ArrayList
- Understand the difference between a stack and a queue
- Identify problems where stacks or queues can contribute to an effective solution.
- Implement a stack and a queue that uses `O(n)` space and has `O(1)` per-operation time complexity.

# Resources

- In [Think DAST](http://greenteapress.com/thinkdast/thinkdast.pdf), read sections **4.1, 4.2, 5.4, and 5.5** which cover Linked Lists. Read section **6.6** which covers Stacks and Queues. Ignore the parts about "DFS", we'll learn about that later.

- Our lecture notes on Linked Lists and Stacks/Queues are [here](https://docs.google.com/presentation/d/1SWDq1ltentlA69a6eorkjT0j_PEP3Bd8D8QMsz4DGbI/edit?usp=sharing).

- Slides from last year on [LLs](https://docs.google.com/presentation/d/1_5Uz06Yw2P-CdXoP-j_D_RIVlP_y89wv7xjHdx4vzZ8/edit?usp=sharing) and [S+Qs](https://docs.google.com/presentation/d/1EBnTBGXLrpecftsyOScBp8OPW4bcv5hdMZol789w33o/edit?usp=sharing).

- Notes from UC Berkeley on [Linked Lists](https://drive.google.com/open?id=1czCHlwIhvMl-KkZon1hTiA6relpjfxkr) and [Stacks/Queues](https://drive.google.com/open?id=1NbfPaMdlokDTGlGVL20vynXECxfe0OfJ)

# Assignment

## Code

In this homework assignment, you will be implementing your own doubly-linked list in the `MyLinkedList` class and will be augmenting the stack data structure in the `MyStack` class to support the `maxElement` operation. You do not need to modify the code in the `MyQueue` class but you should look it over and understand how it makes use of the built in Java `LinkedList` class to implement the functionality of a queue. Then you will implement a priority queue in the `MyPriorityQueue` class.
### MyLinkedList
#### Provided for you

1. The internal `Node` class: its constructor takes in the Chicken, as well as references to the `prev` and `next` nodes.
1. Some internal variables you probably want to keep track of in the `LinkedList`: the `head` and `tail` `Node`s, and the `size` of the `LinkedList`.

#### Your code

Prava would like to start a farm that only contains chickens. She wants your help in creating a `LinkedList` to store the chickens.

You will be provided a `Chicken` class that your `MyLinkedList` will *exclusively* store. Each `Chicken` has the following properties:
```java
public class Chicken {
    String name;
    int age;
    String color;
}
```
The tests you will be running on your `MyLinkedList` class will be using this `Chicken` class.

1. Implement an empty constructor. Initialize `head`, `tail`, and `size`.

    `public MyLinkedList()`

2. Implement a method called `addLast` that will add a `Chicken` to the end of your `MyLinkedList`. Remember to consider the special case where `size` is 0.

    `public void addLast(Chicken c)`

3. Sometimes a chicken will confuse the beginning of the line with the end of the line, and Prava needs to be able to deal with this. Implement `addFirst` that will allow a chicken to be added to the front of the `LinkedList`. Remember to consider the special case where `size` is 0.

    `public void addFirst(Chicken c)`

4. Can we inspect a chicken in our `MyLinkedList`? Implement a method called `get` that will return a `Chicken` given the index of the `Chicken`. Make sure to check that `index` is valid.

    `public Chicken get(int index)`

5. Some chickens might leave the farm for various reasons. LinkedLists have special case O(1) deletes off the front and back. Implement `removeFirst` and `removeLast`, and make sure to return them so Prava can "deal" with them. Remember to consider the special cases where `size` is 0 or 1.

    `public Chicken removeFirst()`

    `public Chicken removeLast()`

6. Chickens might leave in any order. If a chicken in the middle leaves, we want to update our `LinkedList` pointers so that the `Node` before the removed chicken points to the `Node` after the removed `Chicken`. Return the removed `Chicken` so we can "deal" with it. Remember to consider the special cases where `index=0` or `index=size-1`.

    `public Chicken remove(int index)`


Test your DLL by running `MyLinkedListTest.java`. Make sure all test cases pass.

### Stack

Take a look at our implementation of `MyStack`. Note that it:

- heavily relies of the use of linked lists
- uses `O(n)` space-complexity
- has each of the its four functions (`push`, `pop`, `peek`, and `isEmpty`) take constant `O(1)` time.

Take the time to think through why each of these are they way they are.

### Queue

Take a look at our implementation of `MyQueue`. Note that it:

- heavily relies on the use of linked lists
- use `O(n)` space-complexity
- have each of the its four functions (`enqueue`, `dequeue`, `isEmpty`, `front`) take constant `O(1)` time.

Take the time to think through why each of these are they way they are.

### Augmentation

* Modify `MyStack` so that it supports: `public Integer maxElement()`. This function returns the largest element currently on the stack. All operations (including `maxElement`) should still be constant `O(1)` time per operation. For example:

```java
MyStack s = new MyStack();
s.push(4);
s.push(1);
s.push(5);
System.out.println(s.maxElement()); // this should print 5
s.pop(); // this pops the 5 off the stack
System.out.println(s.maxElement()); // this should print 4, since it is the largest remaining element on the stack
```
If you are stuck on this problem, you can try checking out the hint [here](https://github.com/Olin-DSA/DSA-19/tree/master/datastructures/day02/Hints.md)
* Write a new class `MyPriorityQueue`, which supports `enqueue` and `dequeueMax`. This queue's `dequeueMax` function dequeues the largest element on the queue, rather than the element at the front of the queue. In this case, you will only be able to do one of the operations in O(1) time because you will need to essentially sort the elements in priority order as you add them. The other operation will be O(N). For example:

```java
MyPriorityQueue q = new MyPriorityQueue();
q.enqueue(6);
q.enqueue(2);
q.enqueue(4);
System.out.println(q.dequeueMax()); // this should print 6, and remove the 6 from the queue
System.out.println(q.dequeueMax()); // this should print 4, and remove the 4 from the queue
q.enqueue(3); // 3 is now the largest element on the queue
System.out.println(q.dequeueMax()); // this should print 3, and remove the 3 from the queue
```

## Submitting the assignment

To get credit when you're done:

- Go to NINJA hours to get checked off (on or before Monday, February 4th)
- Submit [this](https://tinyurl.com/OlinDSA-02) survey
