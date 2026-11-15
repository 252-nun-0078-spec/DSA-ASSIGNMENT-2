// Program: Task03 - Queue Implementation Using Array
// Course: Data Structures (DS-3, Sections A & B)
// Student: Muhammad Sian (Roll No: 252-nun-0078)
// Description: Implements a Queue using an array with Enqueue, Dequeue,
//              Front (peek), and Display operations, handling Overflow and Underflow.

import java.util.Scanner;

public class Task03 {
    // Array to store queue elements
    private int[] queueArray;
    // Index of the front element
    private int front;
    // Index of the rear element
    private int rear;
    // Current number of elements in the queue
    private int count;
    // Maximum capacity of the queue
    private int capacity;

    // Default constructor with default capacity 5
    public Task03() {
        this(5);
    }

    // Parameterized constructor to initialize queue with specified capacity
    public Task03(int size) {
        if (size <= 0) {
            System.out.println("Warning: Invalid capacity. Defaulting capacity to 5.");
            size = 5;
        }
        this.capacity = size;
        this.queueArray = new int[capacity];
        // front points to 0, rear points to -1 initially
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    // Check if the queue is full (count equals capacity)
    public boolean isFull() {
        return count == capacity;
    }

    // Check if the queue is empty (count equals 0)
    public boolean isEmpty() {
        return count == 0;
    }

    // Get current number of elements in the queue
    public int size() {
        return count;
    }

    // Get total capacity of the queue
    public int getCapacity() {
        return capacity;
    }

    // Enqueue operation: Inserts an element at the rear of the queue
    public boolean enqueue(int element) {
        // Condition: Queue Overflow check
        if (isFull()) {
            System.out.println("[QUEUE OVERFLOW] Cannot enqueue " + element + ". Queue is full (Capacity: " + capacity + ").");
            return false;
        }
        // Advance rear cyclically to prevent false overflow
        rear = (rear + 1) % capacity;
        queueArray[rear] = element;
        count++;
        System.out.println("[SUCCESS] Enqueued " + element + " to queue (Rear index: " + rear + ").");
        return true;
    }

    // Dequeue operation: Removes and returns the front element of the queue
    public int dequeue() {
        // Condition: Queue Underflow check
        if (isEmpty()) {
            System.out.println("[QUEUE UNDERFLOW] Cannot dequeue. Queue is completely empty.");
            return -1; // Sentinel value indicating failure
        }
        // Retrieve front element
        int dequeuedElement = queueArray[front];
        System.out.println("[SUCCESS] Dequeued " + dequeuedElement + " from queue (Front index: " + front + ").");
        // Advance front cyclically
        front = (front + 1) % capacity;
        count--;
        return dequeuedElement;
    }

    // Front operation: Returns the first element without removing it
    public int front() {
        // Condition: Queue Underflow check
        if (isEmpty()) {
            System.out.println("[QUEUE UNDERFLOW] Cannot get front element. Queue is empty.");
            return -1; // Sentinel value indicating failure
        }
        return queueArray[front];
    }

    // Display operation: Displays all elements from front to rear
    public void display() {
        if (isEmpty()) {
            System.out.println("[EMPTY QUEUE] The queue contains 0 elements.");
            return;
        }

        System.out.println("\n--- Current Queue Elements (Front to Rear) ---");
        for (int i = 0; i < count; i++) {
            int actualIndex = (front + i) % capacity;
            if (i == 0 && i == count - 1) {
                System.out.println("  Pos [" + (i + 1) + "] (Array idx " + actualIndex + "): " + queueArray[actualIndex] + "  <-- [FRONT & REAR]");
            } else if (i == 0) {
                System.out.println("  Pos [" + (i + 1) + "] (Array idx " + actualIndex + "): " + queueArray[actualIndex] + "  <-- [FRONT]");
            } else if (i == count - 1) {
                System.out.println("  Pos [" + (i + 1) + "] (Array idx " + actualIndex + "): " + queueArray[actualIndex] + "  <-- [REAR]");
            } else {
                System.out.println("  Pos [" + (i + 1) + "] (Array idx " + actualIndex + "): " + queueArray[actualIndex]);
            }
        }
        System.out.println("----------------------------------------------\n");
    }

    // Automated demonstration testing all required operations & boundary conditions
    public static void runDemonstration() {
        System.out.println("=================================================");
        System.out.println("  Q3: Queue Implementation Demonstration (Array)");
        System.out.println("=================================================");

        // Create a queue with capacity 4
        int capacity = 4;
        System.out.println("\n1. Initializing a new queue of capacity: " + capacity);
        Task03 queue = new Task03(capacity);

        // Check empty state
        System.out.println("   Is empty? " + queue.isEmpty());
        System.out.println("   Current size: " + queue.size());

        // Test Underflow on Dequeue and Front
        System.out.println("\n2. Testing Underflow conditions on empty queue:");
        queue.dequeue();
        queue.front();

        // Enqueue elements
        System.out.println("\n3. Enqueuing elements into queue:");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        // Display queue
        System.out.println("\n4. Displaying queue after 4 enqueues:");
        queue.display();

        // Check full state
        System.out.println("   Is full? " + queue.isFull());
        System.out.println("   Current size: " + queue.size());

        // Test Overflow
        System.out.println("\n5. Testing Overflow condition (enqueuing 50 into full queue):");
        queue.enqueue(50);

        // Test Front
        System.out.println("\n6. Checking Front element:");
        int frontVal = queue.front();
        System.out.println("   Front element is: " + frontVal);

        // Test Dequeue
        System.out.println("\n7. Dequeuing two elements from queue:");
        queue.dequeue();
        queue.dequeue();

        // Display queue after dequeues
        System.out.println("\n8. Queue after 2 dequeues:");
        queue.display();

        // Test wrapping enqueue
        System.out.println("\n9. Testing cyclic enqueue after dequeuing (enqueuing 50 and 60):");
        queue.enqueue(50);
        queue.enqueue(60);
        queue.display();

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
        System.out.print("Would you like to enter interactive Queue menu? (y/n): ");
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        String choice = scanner.nextLine().trim();

        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter queue capacity: ");
            int customCap = 5;
            if (scanner.hasNextInt()) {
                customCap = scanner.nextInt();
            }
            Task03 customQueue = new Task03(customCap);

            boolean exit = false;
            while (!exit) {
                System.out.println("\n--- Queue Interactive Menu ---");
                System.out.println("1. Enqueue element");
                System.out.println("2. Dequeue element");
                System.out.println("3. Front (peek first element)");
                System.out.println("4. Display queue");
                System.out.println("5. Check status (Empty/Full/Size)");
                System.out.println("6. Exit");
                System.out.print("Enter your choice (1-6): ");

                if (!scanner.hasNextInt()) {
                    break;
                }
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter integer value to enqueue: ");
                        if (scanner.hasNextInt()) {
                            int val = scanner.nextInt();
                            customQueue.enqueue(val);
                        }
                        break;
                    case 2:
                        customQueue.dequeue();
                        break;
                    case 3:
                        int f = customQueue.front();
                        if (f != -1) {
                            System.out.println("Front element: " + f);
                        }
                        break;
                    case 4:
                        customQueue.display();
                        break;
                    case 5:
                        System.out.println("Size: " + customQueue.size() + " / " + customQueue.getCapacity());
                        System.out.println("Is Empty: " + customQueue.isEmpty());
                        System.out.println("Is Full: " + customQueue.isFull());
                        break;
                    case 6:
                        exit = true;
                        System.out.println("Exiting Queue Menu.");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select 1-6.");
                }
            }
        }
        scanner.close();
    }
}
