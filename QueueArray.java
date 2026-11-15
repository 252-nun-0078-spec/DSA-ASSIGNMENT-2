// Program: QueueArray - Queue Implementation Using Array
// Course: Data Structures (DS-3, Sections A & B)
// Student: Muhammad Sian (Roll No: 252-nun-0078)
// Description: Implements a Queue using an array with Enqueue, Dequeue,
//              Front (peek), and Display operations, handling Overflow and Underflow.

public class QueueArray {
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
    public QueueArray() {
        this(5);
    }

    // Parameterized constructor to initialize queue with specified capacity
    public QueueArray(int size) {
        if (size <= 0) {
            System.out.println("Warning: Invalid capacity. Defaulting capacity to 5.");
            size = 5;
        }
        this.capacity = size;
        this.queueArray = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return count == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Get current number of elements
    public int size() {
        return count;
    }

    // Get capacity
    public int getCapacity() {
        return capacity;
    }

    // Enqueue operation
    public boolean enqueue(int element) {
        if (isFull()) {
            System.out.println("[QUEUE OVERFLOW] Cannot enqueue " + element + ". Queue is full (Capacity: " + capacity + ").");
            return false;
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = element;
        count++;
        System.out.println("[SUCCESS] Enqueued " + element + " to queue (Rear index: " + rear + ").");
        return true;
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("[QUEUE UNDERFLOW] Cannot dequeue. Queue is completely empty.");
            return -1;
        }
        int dequeuedElement = queueArray[front];
        System.out.println("[SUCCESS] Dequeued " + dequeuedElement + " from queue (Front index: " + front + ").");
        front = (front + 1) % capacity;
        count--;
        return dequeuedElement;
    }

    // Front operation
    public int front() {
        if (isEmpty()) {
            System.out.println("[QUEUE UNDERFLOW] Cannot get front element. Queue is empty.");
            return -1;
        }
        return queueArray[front];
    }

    // Display operation
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

    public static void runDemonstration() {
        System.out.println("=================================================");
        System.out.println("  Q3: Queue Implementation Demonstration (Array)");
        System.out.println("=================================================");

        QueueArray queue = new QueueArray(4);
        queue.dequeue();
        queue.front();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.display();

        queue.enqueue(50); // Overflow test
        System.out.println("Front element: " + queue.front());

        queue.dequeue();
        queue.dequeue();
        queue.display();

        queue.enqueue(50);
        queue.enqueue(60);
        queue.display();
        System.out.println("=================================================\n");
    }

    public static void main(String[] args) {
        runDemonstration();
    }
}
