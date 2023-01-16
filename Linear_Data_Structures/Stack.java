// Stack

class Node {
    int data;
    Node next;
}

class User_Stack {
    private Node head;
    private int count;

    public User_Stack() {
        head = null;
        count = 0;
    }

    // push element in the stack
    public void push(int no) {
        // create node to insert
        Node newn = new Node();
        newn.data = no;
        newn.next = null;

        if(head == null) {
            head = newn;
        } else {
            newn.next = head;
            head = newn;
        }

        count++;
    }

    // pop element from the stack
    public int pop() {
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

class Stack {
    public static void main(String[] args) {
        User_Stack stack = new User_Stack();

        stack.push(11);
        stack.push(21);
        stack.push(51);
        stack.display();
        System.out.print("Total Nodes are: "+stack.size());
        System.out.println();

        stack.pop();
        stack.display();
        System.out.print("Total Nodes are: "+stack.size());
        System.out.println();
    }
}