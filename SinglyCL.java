// Singly Circular LinkedList

class Node {
    public int data;
    public Node next;
}

class SinglyCircularList {
    private Node first;
    private Node last;
    private int size;

    public SinglyCircularList() {
        first = null;
        last = null;
        size = 0;
    }

    public void insertFirst(int no) {
        Node newn = new Node();
        newn.data = no;
        newn.next = null;

        if(first == null) {
            first = newn;
            last = newn;
        } else {
            newn.next = first;
            first = newn;
        }

        last.next = first;
        size++;
    }

    public void insertLast(int no) {
        Node newn = new Node();
        newn.data = no;
        newn.next = null;

        if(first == null) {
            first = newn;
            last = newn;
        } else {
            last.next = newn;
            last = newn;
        }

        last.next = first;
        size++;
    }

    public void insertAtPos(int no, int pos) {
        if(pos > size+1 || pos <= 0) {
            System.out.println("Invalid Position");
            return;
        }

        if(pos == 1) {
            insertFirst(no);
        } 
        else if(pos == size+1) {
            insertLast(no);
        }
        else {
            Node newn = new Node();
            newn.data = no;
            newn.next = null;

            Node temp = first;
            for(int i = 1; i < pos-1; i++) {
                temp = temp.next;
            }

            newn.next = temp.next;
            temp.next = newn;
            size++;
        }
    }

    public void deleteFirst() {
        if(first == null) {
            return;
        }

        if(size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            last.next = first;
        }

        size--;
    }

    public void deleteLast() {
        if(first == null) {
            return;
        }

        if(size == 1) {
            first = null;
            last = null;
        } else {
            Node temp = first;

            while(temp.next != last) {
                temp = temp.next;
            }

            last = temp;
            last.next = first;
            temp = null;

            size--;
        }
    }

    public void deleteAtPos(int pos) {
        if(pos <= 0 || pos > size) {
            System.out.println("Invalid Position");
            return;
        }

        if(pos == 1) {
            deleteFirst();
        }
        else if(pos == size) {
            deleteLast();
        }
        else {
            Node temp = first;
            for(int i = 1; i < pos-1; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;
            size--;
            temp = null;
        }
    }

    public int count() {
        return size;
    }

    public void display() {
        Node temp = first;

        do {
            System.out.print("|"+temp.data+"|"+" ->");
            temp = temp.next;
        }while(temp != first);

        System.out.println();
    }
}

class SinglyCL {
    public static void main(String[] args) {
        SinglyCircularList cl = new SinglyCircularList();

        cl.insertFirst(30);
        cl.insertFirst(20);
        cl.insertFirst(10);
        cl.insertLast(40);
        cl.insertLast(50);
        cl.insertAtPos(21,3);
        cl.display();

        cl.deleteFirst();
        cl.deleteLast();
        cl.display();

        cl.deleteAtPos(3);
        cl.display();
    }
}