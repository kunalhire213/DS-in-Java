// Doubly Circular LinkedList

class Node {
    public int data;
    public Node next;
    public Node prev;
}

class DoublyCircularList {
    private Node first;
    private Node last;
    private int count;

    public DoublyCircularList() {
        first = null;
        last = null;
        count = 0;
    }

    public void insertFirst(int no) {
        // create Node and Initialized
        Node newn = new Node();
        newn.data = no;
        newn.next = null;
        newn.prev = null;

        // Insert that Node
        if(first == null) {                // if list is empty
            first = newn;
            last = newn;
        } else {
            newn.next = first;
            newn.prev = last;
            first.prev = newn;
            last.next = newn;
            first = newn;
        }

        count++;
    }

    public void insertLast(int no) {
        // create Node and Initialized
        Node newn = new Node();
        newn.data = no;
        newn.next = null;
        newn.prev = null;

        // Insert that Node
        if(first == null) {                // if list is empty
            first = newn;
            last = newn;
        } else {
            newn.prev = last;
            newn.next = first;
            first.prev = newn;
            last.next = newn;
            last = newn;
        }

        count++;
    }

    public void insertAtPos(int no, int pos) {
        if(pos < 1 || pos > count+1) {
            System.out.println("Invalid Position");
            return;
        }

        if(pos == 1) {
            insertFirst(no);
        }
        else if(pos == count+1) {
            insertLast(no);
        }
        else {
            Node newn = new Node();
            newn.data = no;
            newn.next = null;
            newn.prev = null;

            Node temp = first;
            for(int i = 1; i < pos-1; i++) {
                temp = temp.next;
            }

            newn.prev = temp;
            newn.next = temp.next;
            temp.next.prev = newn;
            temp.next = newn;

            count++;
        }
    }

    public void deleteFirst() {
        if(count == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = last;
            last.next = first;
        }

        count--;
    }

    public void deleteLast() {
        if(count == 1) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = first;
            first.prev = last;
        }

        count--;
    }

    public void deleteAtPos(int pos) {
        if(pos < 1 || pos > count) {
            System.out.println("Invalid Position");
            return;
        }

        if(pos == 1) {
            deleteFirst();
        }
        else if(pos == count) {
            deleteLast();
        }
        else {
            Node temp = first;
            for(int i = 1; i < pos-1; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;
            temp.next.prev = temp;

            count--;
        }
    }

    public int size() {
        return count;
    }

    public void display() {
        Node temp = first;
        do {
            System.out.print("|"+temp.data+"| ->");
            temp = temp.next;
        } while(temp != first);

        System.out.println();
    }
}

class DoublyCL {
    public static void main(String[] args) {
        DoublyCircularList dcl = new DoublyCircularList();

        dcl.insertFirst(30);
        dcl.insertFirst(20);
        dcl.insertFirst(10);
        dcl.insertLast(40);
        dcl.insertLast(50);
        dcl.display();

        dcl.insertAtPos(21,3);
        dcl.display();

        dcl.deleteAtPos(3);
        dcl.display();

        dcl.deleteFirst();
        dcl.display();

        dcl.deleteLast();
        dcl.display();

        System.out.println("Total Nodes are : "+dcl.size());
    }
}