import java.util.*;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }

    public static List<Integer> removeKDigits(int[] num, int k) {

        LinkedList<Integer> arr = new LinkedList<>();

        for (int i : num) {

            while (!arr.isEmpty() && i < arr.getLast() && k>0) {
                arr.removeLast();
                k--;
            }
            if (arr.size() < num.length - k)
                arr.addLast(i);

        }

        return arr;
    }

    private static Node reverse(Node n) {
        Node prev = null;
        while (n != null) {
            Node temp = n.next;
            n.next = prev;
            prev = n;
            n = temp;
        }
        return prev;
    }

    private static boolean compare(Node n1, Node n2) {
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }

    public static boolean isPalindrome(Node n) {
        int listLength = 0;
        Node m = n;
        while(m != null) {
            m = m.next;
            listLength++;
        }
        if (listLength < 2) return true;
        Node beforeMidNode = n;
        for (int i = 0; i < (listLength - 1) / 2; i++) beforeMidNode = beforeMidNode.next;
        beforeMidNode.next = reverse(beforeMidNode.next);

        return compare(n, beforeMidNode.next);
    }


    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }

    private static boolean isParens(String s) {
        return s.equals("(") || s.equals(")");
    }

    // This code requies parens to surround operations
//    public static String infixToPostfix(String s) {
//        String[] tokens = s.split(" ");
//        List<String> output = new ArrayList<>();
//        Stack<String> stack = new Stack<>();
//        for (String c : tokens) {
//            if (isOperator(c)) stack.push(c);
//            else if (c.equals(")")) output.add(stack.pop());
//            else if (c.equals("(")) {
//            } else output.add(c);
//        }
//        return String.join(" ", output);
//    }

    // This code handles strings without parens surrounding operations
    public static String infixToPostfix(String s) {
        String[] tokens = s.split(" ");
        List<String> output = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (String c : tokens) {
            // If char is an operand
            if (!isOperator(c) && !isParens(c)) output.add(c);
            else if (c.equals("(")) stack.push(c);
            else if (c.equals(")")) {
                // Pop operands until ( on top
                while(!stack.peek().equals("("))
                    output.add(stack.pop());
                stack.pop(); // remove the ( from the stack
            } else { // This is an operator
                while (!stack.empty() && !stack.peek().equals("("))
                    output.add(stack.pop());
                stack.push(c);
            }
        }
        while(!stack.empty())
            output.add(stack.pop());
        return String.join(" ", output);
    }

}
