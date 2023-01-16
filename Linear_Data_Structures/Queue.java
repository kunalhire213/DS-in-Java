// Queue

class Node {
    public int data;
    public Node next;
}

class User_Queue {
    private Node head;
    private int count;

    public User_Queue() {
        head = null;
        count = 0;
    }

   // add element in Queue
    public void enQueue(int no) {
        // create node to insert
        Node newn = new Node();
        newn.data = no;
        newn.next = null;

        if(head == null) {
            head = newn;
        } else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }

            temp.next = newn;
        }
        count++;
    }

    // remove element from queue
    public int deQueue() {
        int no = head.data;

        if(count == 1) {
            head = null;
        } else {
            head = head.next;
        }

        count--;
        return no;
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print("|"+temp.data+"|-> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int size() {
        return count;
    }
}

class Queue {
    public static void main(String[] args) {
        User_Queue queue = new User_Queue();

        queue.enQueue(11);
        queue.enQueue(21);
        queue.enQueue(51);
        queue.display();
        System.out.print("Total Nodes are: "+queue.size());
        System.out.println();

        queue.deQueue();
        queue.display();
        System.out.print("Total Nodes are: "+queue.size());
        System.out.println();
    }
}