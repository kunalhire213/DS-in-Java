// Doubly Linear LinkedList

class Node {                     // this is node class to store the data 
    public int data;
    public Node prev;
    public Node next;
}

class DoublyLinearList {
    private Node first;
    private int count;

    public DoublyLinearList() {
        first = null;
        count = 0;
    }

    public void insertFirst(int no) {
        //create node and initialize
        Node newn = new Node();
        newn.data = no;
        newn.prev = null;
        newn.next = null;

        // insert this node
        if(first == null) {            // if list is empty
            first = newn;
        } else {
            first.prev = newn;
            newn.next = first;
            first = newn;
        }

        count++;
    }

    public void insertLast(int no) {
        //create node and initialize
        Node newn = new Node();
        newn.data = no;
        newn.prev = null;
        newn.next = null;

        // insert this node
        if(first == null) {            // if list is empty
            first = newn;
        } else {
            Node temp = first;
            while(temp.next != null) {
                temp = temp.next;
            }

            temp.next = newn;
            newn.prev = temp;
        }

        count++;
    }

    public void insertAtPos(int no, int pos) {
        if(pos <= 0 || pos > count+1) {
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
            newn.prev = null;
            newn.next = null;

            Node temp = first;
            for(int i = 1; i < pos-1; i++) {
                temp = temp.next;
            }

            newn.next = temp.next;
            newn.prev = temp;
            temp.next = newn;
            temp.next.prev = newn;

            count++;
        }
    }

    public void deleteFirst() {
        if(count == 1) {
            first = null;
        } else {
            first = first.next;
            first.prev = null;
        }

        count--;
    }

    public void deleteLast() {
        if(count == 1) {
            first = null;
        } else {
            Node temp = first;
            while(temp.next != null) {
                temp = temp.next;
            }

            temp.prev.next = null;
        }

        count--;
    }

    public void deleteAtPos(int pos) {
        if(pos <= 0 || pos > count) {
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
        while(temp != null) {
            System.out.print("|"+temp.data+"|"+"-> ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class DoublyLL {
    public static void main(String[] args) {
        DoublyLinearList dll = new DoublyLinearList();

        dll.insertFirst(20);
        dll.insertFirst(10);
        dll.insertLast(30);
        dll.insertLast(40);
        dll.display(); 

        dll.insertAtPos(21,3);
        dll.display(); 

        dll.deleteAtPos(3);
        dll.display();

        dll.deleteFirst();
        dll.display();

        dll.deleteLast();
        dll.display();

        //dll.deleteAtPos(2);
        //dll.display();
    }
} 