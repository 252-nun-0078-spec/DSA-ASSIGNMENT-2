// Program: Task01 - Stack Implementation Using Array
// Course: Data Structures (DS-3, Sections A & B)
// Student: Muhammad Sian (Roll No: 252-nun-0078)
// Description: Implements a Stack using a fixed-size array with Push, Pop,
//              Peek, and Display operations, handling Overflow and Underflow.

import java.util.Scanner;

public class Task01 {
    // Array to store stack elements
    private int[] stackArray;
    // Index of the top element in the stack
    private int top;
    // Maximum capacity of the stack
    private int capacity;

    // Default constructor with default capacity 5
    public Task01() {
        this(5);
    }

    // Parameterized constructor to initialize stack with user-defined capacity
    public Task01(int size) {
        if (size <= 0) {
            System.out.println("Warning: Invalid capacity. Defaulting capacity to 5.");
            size = 5;
        }
        this.capacity = size;
        this.stackArray = new int[capacity];
        // top is initialized to -1 to represent an empty stack
        this.top = -1;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to get current number of elements in the stack
    public int size() {
        return top + 1;
    }

    // Method to get the total capacity of the stack
    public int getCapacity() {
        return capacity;
    }

    // Push operation: Inserts an element onto the top of the stack
    public boolean push(int element) {
        // Condition: Stack Overflow check
        if (isFull()) {
            System.out.println("[STACK OVERFLOW] Cannot push " + element + ". Stack is completely full (Capacity: " + capacity + ").");
            return false;
        }
        // Increment top pointer and insert element at new top position
        top++;
        stackArray[top] = element;
        System.out.println("[SUCCESS] Pushed " + element + " to stack (Index: " + top + ").");
        return true;
    }

    // Pop operation: Removes and returns the top element from the stack
    public int pop() {
        // Condition: Stack Underflow check
        if (isEmpty()) {
            System.out.println("[STACK UNDERFLOW] Cannot pop. Stack is completely empty.");
            return -1; // Sentinel value indicating failure
        }
        // Retrieve the top element, then decrement top pointer
        int poppedElement = stackArray[top];
        System.out.println("[SUCCESS] Popped " + poppedElement + " from stack (Index: " + top + ").");
        top--;
        return poppedElement;
    }

    // Peek operation: Returns the top element without removing it
    public int peek() {
        // Condition: Stack Underflow check
        if (isEmpty()) {
            System.out.println("[STACK UNDERFLOW] Cannot peek. Stack is empty.");
            return -1; // Sentinel value indicating failure
        }
        // Return element at top index
        return stackArray[top];
    }

    // Display operation: Displays all elements from top to bottom
    public void display() {
        // Check if stack is empty
        if (isEmpty()) {
            System.out.println("[EMPTY STACK] The stack contains 0 elements.");
            return;
        }

        System.out.println("\n--- Current Stack Elements (Top to Bottom) ---");
        for (int i = top; i >= 0; i--) {
            if (i == top) {
                System.out.println("  Index [" + i + "]: " + stackArray[i] + "  <-- [TOP]");
            } else {
                System.out.println("  Index [" + i + "]: " + stackArray[i]);
            }
        }
        System.out.println("----------------------------------------------\n");
    }

    // Automated demonstration testing all required operations & boundary conditions
    public static void runDemonstration() {
        System.out.println("=================================================");
        System.out.println("  Q1: Stack Implementation Demonstration (Array)");
        System.out.println("=================================================");

        // Create a stack with capacity 4
        int capacity = 4;
        System.out.println("\n1. Initializing a new stack of capacity: " + capacity);
        Task01 stack = new Task01(capacity);

        // Check empty state
        System.out.println("   Is empty? " + stack.isEmpty());
        System.out.println("   Current size: " + stack.size());

        // Test Underflow on Pop and Peek
        System.out.println("\n2. Testing Underflow conditions on empty stack:");
        stack.pop();
        stack.peek();

        // Push elements
        System.out.println("\n3. Pushing elements into stack:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        // Display stack
        System.out.println("\n4. Displaying stack after 4 pushes:");
        stack.display();

        // Check full state
        System.out.println("   Is full? " + stack.isFull());
        System.out.println("   Current size: " + stack.size());

        // Test Overflow
        System.out.println("\n5. Testing Overflow condition (pushing 50 into full stack):");
        stack.push(50);

        // Test Peek
        System.out.println("\n6. Peeking top element:");
        int topVal = stack.peek();
        System.out.println("   Top element is: " + topVal);

        // Test Pop
        System.out.println("\n7. Popping two elements from stack:");
        stack.pop();
        stack.pop();

        // Display stack after pops
        System.out.println("\n8. Stack after 2 pops:");
        stack.display();

        System.out.println("=================================================");
        System.out.println("  Demonstration completed successfully!");
        System.out.println("=================================================\n");
    }

    // Main method: Runs demonstration and provides interactive menu
    public static void main(String[] args) {
        // Run full automated demonstration first
        runDemonstration();

        // Check if user wants interactive mode
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to enter interactive Stack menu? (y/n): ");
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        String choice = scanner.nextLine().trim();

        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter stack capacity: ");
            int customCap = 5;
            if (scanner.hasNextInt()) {
                customCap = scanner.nextInt();
            }
            Task01 customStack = new Task01(customCap);

            boolean exit = false;
            while (!exit) {
                System.out.println("\n--- Stack Interactive Menu ---");
                System.out.println("1. Push element");
                System.out.println("2. Pop element");
                System.out.println("3. Peek top element");
                System.out.println("4. Display stack");
                System.out.println("5. Check status (Empty/Full/Size)");
                System.out.println("6. Exit");
                System.out.print("Enter your choice (1-6): ");

                if (!scanner.hasNextInt()) {
                    break;
                }
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter integer value to push: ");
                        if (scanner.hasNextInt()) {
                            int val = scanner.nextInt();
                            customStack.push(val);
                        }
                        break;
                    case 2:
                        customStack.pop();
                        break;
                    case 3:
                        int peeked = customStack.peek();
                        if (peeked != -1) {
                            System.out.println("Top element: " + peeked);
                        }
                        break;
                    case 4:
                        customStack.display();
                        break;
                    case 5:
                        System.out.println("Size: " + customStack.size() + " / " + customStack.getCapacity());
                        System.out.println("Is Empty: " + customStack.isEmpty());
                        System.out.println("Is Full: " + customStack.isFull());
                        break;
                    case 6:
                        exit = true;
                        System.out.println("Exiting Stack Menu.");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select 1-6.");
                }
            }
        }
        scanner.close();
    }
}
