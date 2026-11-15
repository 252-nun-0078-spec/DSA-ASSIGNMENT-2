// Program: Task04 - Queue Operations Step-by-Step Trace (Q4)
// Course: Data Structures (DS-3, Sections A & B)
// Student: Muhammad Sian (Roll No: 252-nun-0078)
// Description: Traces the execution of the 6 given Queue operations:
//              Enqueue(10), Enqueue(20), Enqueue(30), Dequeue(), Enqueue(40), Dequeue().
//              Shows the Queue after every single operation and concludes
//              with the final Queue contents and its front element.

public class Task04 {

    // Helper class representing an array-based queue for tracing
    static class SimpleQueue {
        private int[] data;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public SimpleQueue(int cap) {
            this.capacity = cap;
            this.data = new int[capacity];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }

        public void enqueue(int val) {
            if (size == capacity) {
                System.out.println("  [Queue Overflow]");
                return;
            }
            rear = (rear + 1) % capacity;
            data[rear] = val;
            size++;
        }

        public int dequeue() {
            if (size == 0) {
                System.out.println("  [Queue Underflow]");
                return -1;
            }
            int val = data[front];
            front = (front + 1) % capacity;
            size--;
            return val;
        }

        public int getFrontElement() {
            if (size == 0) return -1;
            return data[front];
        }

        public int getRearElement() {
            if (size == 0) return -1;
            return data[rear];
        }

        public int getFrontIndex() {
            return front;
        }

        public int getRearIndex() {
            return rear;
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // Print contents from front to rear
        public String getContentsFrontToRear() {
            if (isEmpty()) return "[] (Empty)";
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % capacity;
                sb.append(data[idx]);
                if (i < size - 1) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }

        // Horizontal visual diagram of the queue
        public void printVisualQueue() {
            if (isEmpty()) {
                System.out.println("     FRONT -> [ Empty Queue ] <- REAR");
                return;
            }
            System.out.print("     FRONT -> ");
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % capacity;
                System.out.print("[ " + data[idx] + " ]");
                if (i < size - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println(" <- REAR");
        }
    }

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("  Q4: Queue Operations Trace & Final Analysis");
        System.out.println("===============================================================");
        System.out.println("Initial State: Initially Empty Queue (size = 0)\n");

        SimpleQueue queue = new SimpleQueue(10);
        queue.printVisualQueue();
        System.out.println();

        // Step 1: Enqueue(10)
        System.out.println("---------------------------------------------------------------");
        System.out.println("Step 1: Perform Operation -> Enqueue(10)");
        queue.enqueue(10);
        System.out.println("Action: Inserted 10 at Rear");
        System.out.println("Queue Contents (Front -> Rear): " + queue.getContentsFrontToRear());
        System.out.println("Front Element: " + queue.getFrontElement() + " | Rear Element: " + queue.getRearElement());
        System.out.println("Visual State:");
        queue.printVisualQueue();
        System.out.println();

        // Step 2: Enqueue(20)
        System.out.println("---------------------------------------------------------------");
        System.out.println("Step 2: Perform Operation -> Enqueue(20)");
        queue.enqueue(20);
        System.out.println("Action: Inserted 20 at Rear");
        System.out.println("Queue Contents (Front -> Rear): " + queue.getContentsFrontToRear());
        System.out.println("Front Element: " + queue.getFrontElement() + " | Rear Element: " + queue.getRearElement());
        System.out.println("Visual State:");
        queue.printVisualQueue();
        System.out.println();

        // Step 3: Enqueue(30)
        System.out.println("---------------------------------------------------------------");
        System.out.println("Step 3: Perform Operation -> Enqueue(30)");
        queue.enqueue(30);
        System.out.println("Action: Inserted 30 at Rear");
        System.out.println("Queue Contents (Front -> Rear): " + queue.getContentsFrontToRear());
        System.out.println("Front Element: " + queue.getFrontElement() + " | Rear Element: " + queue.getRearElement());
        System.out.println("Visual State:");
        queue.printVisualQueue();
        System.out.println();

        // Step 4: Dequeue()
        System.out.println("---------------------------------------------------------------");
        System.out.println("Step 4: Perform Operation -> Dequeue()");
        int dequeued1 = queue.dequeue();
        System.out.println("Action: Removed Front element (" + dequeued1 + ")");
        System.out.println("Queue Contents (Front -> Rear): " + queue.getContentsFrontToRear());
        System.out.println("Front Element: " + queue.getFrontElement() + " | Rear Element: " + queue.getRearElement());
        System.out.println("Visual State:");
        queue.printVisualQueue();
        System.out.println();

        // Step 5: Enqueue(40)
        System.out.println("---------------------------------------------------------------");
        System.out.println("Step 5: Perform Operation -> Enqueue(40)");
        queue.enqueue(40);
        System.out.println("Action: Inserted 40 at Rear");
        System.out.println("Queue Contents (Front -> Rear): " + queue.getContentsFrontToRear());
        System.out.println("Front Element: " + queue.getFrontElement() + " | Rear Element: " + queue.getRearElement());
        System.out.println("Visual State:");
        queue.printVisualQueue();
        System.out.println();

        // Step 6: Dequeue()
        System.out.println("---------------------------------------------------------------");
        System.out.println("Step 6: Perform Operation -> Dequeue()");
        int dequeued2 = queue.dequeue();
        System.out.println("Action: Removed Front element (" + dequeued2 + ")");
        System.out.println("Queue Contents (Front -> Rear): " + queue.getContentsFrontToRear());
        System.out.println("Front Element: " + queue.getFrontElement() + " | Rear Element: " + queue.getRearElement());
        System.out.println("Visual State:");
        queue.printVisualQueue();
        System.out.println();

        // Final Summary and Answers
        System.out.println("===============================================================");
        System.out.println("                       FINAL SUMMARY & ANSWERS                 ");
        System.out.println("===============================================================");
        System.out.println("Operations Performed Summary Table:");
        System.out.println("+------+---------------+--------------------+---------------+---------------+");
        System.out.println("| Step | Operation     | Element Affected   | Front Element | Rear Element  |");
        System.out.println("+------+---------------+--------------------+---------------+---------------+");
        System.out.println("|  1   | Enqueue(10)   | Inserted 10        |      10       |      10       |");
        System.out.println("|  2   | Enqueue(20)   | Inserted 20        |      10       |      20       |");
        System.out.println("|  3   | Enqueue(30)   | Inserted 30        |      10       |      30       |");
        System.out.println("|  4   | Dequeue()     | Removed 10         |      20       |      30       |");
        System.out.println("|  5   | Enqueue(40)   | Inserted 40        |      20       |      40       |");
        System.out.println("|  6   | Dequeue()     | Removed 20         |      30       |      40       |");
        System.out.println("+------+---------------+--------------------+---------------+---------------+");
        System.out.println();
        System.out.println(">>> Answers to Assignment Questions:");
        System.out.println("1. What will be the final contents of the Queue?");
        System.out.println("   -> Final contents (Front to Rear): [30, 40]");
        System.out.println("2. What will be its front element?");
        System.out.println("   -> Front element is: 30");
        System.out.println("   -> Rear element is:  40");
        System.out.println("===============================================================");
    }
}
