class Node
{
    public int data;
    public Node next;
}

class LinkedList
{
    private Node first;
    private int size;

    public LinkedList()
    {
        first = null;
        size = 0;
    }

    public void InsertFirst(int no)
    {
        Node newn = new Node();

        newn.data = no;
        newn.next = null;

        if(size == 0)
        {
            first = newn;
        }
        else
        {
            newn.next = first;
            first = newn;
        }

        size++;
    }

    public void InsertLast(int no)
    {
        Node newn = new Node();

        newn.data = no;
        newn.next = null;

        if(size == 0)
        {
            first = newn;
        }
        else
        {
            Node temp = first;
            while(temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = newn;
        }

        size++;
    }

    public void InsertAtPos(int no, int pos)
    {
        if(pos < 1 || pos > size+1)
        {
            System.out.println("Invalid Position");
            return;
        }

        if(pos == 1)
        {
            InsertFirst(no);
        }
        else if(pos == size+1)
        {
            InsertLast(no);
        }
        else
        {
            Node newn = new Node();

            newn.data = no;
            newn.next = null;
            
            Node temp = first;
            for(int i = 1; i < pos-1; i++)
            {
                temp = temp.next;
            }
            newn.next = temp.next;
            temp.next = newn;

            size++;
        }
    }

    public void DeleteFirst()
    {
        if(size == 0)
        {
            return;
        }
        else if(size == 1)
        {
            first = null;
        }
        else
        {
            first = first.next;
        }

        size--;
    }

    public void DeleteLast()
    {
        if(size == 0)
        {
            return;
        }
        else if(size == 1)
        {
            first = null;
        }
        else
        {
            Node temp = first;
            while(temp.next.next != null)
            {
                temp = temp.next;
            }
            temp.next = null;
        }

        size--;
    }

    public void DeleteAtPos(int pos)
    {
        if(pos < 1 || pos > size)
        {
            System.out.println("Invalid Position");
        }

        if(pos == 1)
        {
            DeleteFirst();
        }
        else if(pos == size)
        {
            DeleteLast();
        }
        else
        {
            Node temp = first;
            for(int i = 1; i < pos-1; i++)
            {
                temp = temp.next;
            }

            temp.next = temp.next.next;

            size--;
        }
    }

    public void Display()
    {
        Node temp = first;
        while(temp != null)
        {
            System.out.print("|"+temp.data+"| ->");
            temp = temp.next;
        }

        System.out.println();
    }

    public int Count()
    {
        return size;
    }
}

class SinglyLL
{
    public static void main(String[] args)
    {
        LinkedList LL = new LinkedList();

        LL.InsertFirst(30);
        LL.InsertFirst(20);
        LL.InsertFirst(10);
        LL.InsertLast(40);
        LL.InsertLast(50);

        LL.InsertAtPos(35,4);

        LL.Display();

        LL.DeleteFirst();
        LL.DeleteLast();
        LL.DeleteAtPos(1);
        LL.Display();
    }
}