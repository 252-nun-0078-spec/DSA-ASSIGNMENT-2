// Program: Task02 - Stack Operations Step-by-Step Trace (Q2)
// Course: Data Structures (DS-3, Sections A & B)
// Student: Muhammad Sian (Roll No: 252-nun-0078)
// Description: Traces the execution of the 6 given Stack operations:
//              Push(10), Push(20), Push(30), Pop(), Push(40), Pop().
//              Shows the Stack after every single operation and concludes
//              with the final Stack contents and its top element.

public class Task02 {

    // Helper class representing an array-based stack for tracing
    static class SimpleStack {
        private int[] data;
        private int top;
        private int capacity;

        public SimpleStack(int cap) {
            this.capacity = cap;
            this.data = new int[capacity];
            this.top = -1;
        }

        public void push(int val) {
            if (top == capacity - 1) {
                System.out.println("  [Stack Overflow]");
                return;
            }
            top++;
            data[top] = val;
        }

        public int pop() {
            if (top == -1) {
                System.out.println("  [Stack Underflow]");
                return -1;
            }
            int val = data[top];
            top--;
            return val;
        }

        public int peek() {
            if (top == -1) return -1;
            return data[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public int getTopIndex() {
            return top;
        }

        // Print contents from bottom to top
        public String getContentsBottomToTop() {
            if (isEmpty()) return "[] (Empty)";
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i <= top; i++) {
                sb.append(data[i]);
                if (i < top) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }

        // Print contents from top to bottom
        public String getContentsTopToBottom() {
            if (isEmpty()) return "[] (Empty)";
            StringBuilder sb = new StringBuilder("[");
            for (int i = top; i >= 0; i--) {
                sb.append(data[i]);
                if (i > 0) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }

        // Visual representation of the stack
        public void printVisualStack() {
            if (isEmpty()) {
                System.out.println("     |        | (Empty)");
                System.out.println("     +--------+");
                return;
            }
            for (int i = top; i >= 0; i--) {
                if (i == top) {
                    System.out.printf("     |  %4d  | <-- TOP (index %d)%n", data[i], i);
                } else {
                    System.out.printf("     |  %4d  |     (index %d)%n", data[i], i);
                }
            }
            System.out.println("     +--------+ (Bottom)");
        }
    }

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("  Q2: Stack Operations Trace & Final Analysis");
        System.out.println("===============================================================");
        System.out.println("Initial State: Initially Empty Stack (top = -1)\n");

        SimpleStack stack = new SimpleStack(10);
        stack.printVisualStack();
        System.out.println();

        // Step 1: Push(10)
        System.out.println("---------------------------------------------------------------");
        System.out.println("Step 1: Perform Operation -> Push(10)");
        stack.push(10);
        System.out.println("Action: Inserted 10 at top index (" + stack.getTopIndex() + ")");
        System.out.println("Stack Contents (Bottom -> Top): " + stack.getContentsBottomToTop());
        System.out.println("Current Top Element: " + stack.peek());
        System.out.println("Visual State:");
        stack.printVisualStack();
        System.out.println();

        // Step 2: Push(20)
        System.out.println("---------------------------------------------------------------");
        System.out.println("Step 2: Perform Operation -> Push(20)");
        stack.push(20);
        System.out.println("Action: Inserted 20 at top index (" + stack.getTopIndex() + ")");
        System.out.println("Stack Contents (Bottom -> Top): " + stack.getContentsBottomToTop());
        System.out.println("Current Top Element: " + stack.peek());
        System.out.println("Visual State:");
        stack.printVisualStack();
        System.out.println();

        // Step 3: Push(30)
        System.out.println("---------------------------------------------------------------");
        System.out.println("Step 3: Perform Operation -> Push(30)");
        stack.push(30);
        System.out.println("Action: Inserted 30 at top index (" + stack.getTopIndex() + ")");
        System.out.println("Stack Contents (Bottom -> Top): " + stack.getContentsBottomToTop());
        System.out.println("Current Top Element: " + stack.peek());
        System.out.println("Visual State:");
        stack.printVisualStack();
        System.out.println();

        // Step 4: Pop()
        System.out.println("---------------------------------------------------------------");
        System.out.println("Step 4: Perform Operation -> Pop()");
        int popped1 = stack.pop();
        System.out.println("Action: Removed top element (" + popped1 + ")");
        System.out.println("Stack Contents (Bottom -> Top): " + stack.getContentsBottomToTop());
        System.out.println("Current Top Element: " + stack.peek());
        System.out.println("Visual State:");
        stack.printVisualStack();
        System.out.println();

        // Step 5: Push(40)
        System.out.println("---------------------------------------------------------------");
        System.out.println("Step 5: Perform Operation -> Push(40)");
        stack.push(40);
        System.out.println("Action: Inserted 40 at top index (" + stack.getTopIndex() + ")");
        System.out.println("Stack Contents (Bottom -> Top): " + stack.getContentsBottomToTop());
        System.out.println("Current Top Element: " + stack.peek());
        System.out.println("Visual State:");
        stack.printVisualStack();
        System.out.println();

        // Step 6: Pop()
        System.out.println("---------------------------------------------------------------");
        System.out.println("Step 6: Perform Operation -> Pop()");
        int popped2 = stack.pop();
        System.out.println("Action: Removed top element (" + popped2 + ")");
        System.out.println("Stack Contents (Bottom -> Top): " + stack.getContentsBottomToTop());
        System.out.println("Current Top Element: " + stack.peek());
        System.out.println("Visual State:");
        stack.printVisualStack();
        System.out.println();

        // Final Summary and Answers
        System.out.println("===============================================================");
        System.out.println("                       FINAL SUMMARY & ANSWERS                 ");
        System.out.println("===============================================================");
        System.out.println("Operations Performed Summary Table:");
        System.out.println("+------+------------+--------------------+-----------+-------------+");
        System.out.println("| Step | Operation  | Element Affected   | Top Index | Top Element |");
        System.out.println("+------+------------+--------------------+-----------+-------------+");
        System.out.println("|  1   | Push(10)   | Inserted 10        |     0     |     10      |");
        System.out.println("|  2   | Push(20)   | Inserted 20        |     1     |     20      |");
        System.out.println("|  3   | Push(30)   | Inserted 30        |     2     |     30      |");
        System.out.println("|  4   | Pop()      | Removed 30         |     1     |     20      |");
        System.out.println("|  5   | Push(40)   | Inserted 40        |     2     |     40      |");
        System.out.println("|  6   | Pop()      | Removed 40         |     1     |     20      |");
        System.out.println("+------+------------+--------------------+-----------+-------------+");
        System.out.println();
        System.out.println(">>> Answers to Assignment Questions:");
        System.out.println("1. What will be the final contents of the Stack?");
        System.out.println("   -> Final contents (Bottom to Top): [10, 20]");
        System.out.println("   -> Final contents (Top to Bottom): [20, 10]");
        System.out.println("2. What will be its top element?");
        System.out.println("   -> Top element is: 20");
        System.out.println("===============================================================");
    }
}
