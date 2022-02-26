import java.util.Scanner;

//structure of a node class for singly linked list
class Node
{
    int data;
    Node next;//self referential structure to hold the reference of the next element of the same type.
    public Node(int data)
    {
        this.data=data;
    }
}
class SinglyLinkedList
{
    Node head;

    //to insert the node at beginning
    public void insertAtBeginning(Node newnode)
    {
        newnode.next=head;
        head=newnode;
    }

    //to inset the element at last
    public void insertAtLast(Node newnode)
    {
        if(head==null)
        {
            head=newnode;
            return;
        }
        else
        {
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newnode;
        }
    }

    //insert at specific position
    public void insertAtPosition(int pos,Node newnode)
    {
        Node temp=head;
        for(int i=0;i<pos-1;i++)
        {
            temp=temp.next;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }

    //delete a node from beggining
    public void deleteFromBeginning()
    {
        if(head==null)
        {
            System.out.println("empty linked list");
        }
        else
        {
            head=head.next;
        }
    }

    //delete a node from last
    public void deleteFromLast()
    {
        Node temp=head;
        if(head==null)
        {
            System.out.println("empty linked list");
        }
        else
        {
            while(temp.next.next!=null)
            {
                temp=temp.next;
            }
            temp.next=null;

        }
    }

    //delete from specific position
    public void deleteAtPosition(int pos)
    {
        Node temp=head;
        for(int i=0;i<pos-1;i++)
        {
            temp=temp.next;
        }
        temp.next=temp.next.next;
    }

    //to display all values in linked list
    public void display()
    {
        if(head==null)
        {
            System.out.println("list is empty");
        }
        else
        {
            Node temp=head;
            while(temp != null)
            {
                System.out.println(temp.data);
                temp=temp.next;
            }
        }
    }
}
public class SLinkedList
{
    public static void main(String[] args)
    {
        System.out.println("press <1> for inseting node at the beginning\n" +
                "press<2> for inserting node at the last\n" +
                "press <3> for inserting at specific position\n" +
                "press <4> for deleting node at the beginning \n" +
                "press<5> for deleting node at the last\n" +
                "press <6> for deleting at specific position\n" +
                "press <7> to display the data of linked list\n");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        SinglyLinkedList obj = new SinglyLinkedList();
        char ch = 'y';
        while (ch == 'y' || ch == 'Y')
        {
            switch (n)
            {
                case 1:
                    obj.insertAtBeginning(new Node(s.nextInt()));
                    obj.display();
                case 2:
                    obj.insertAtLast(new Node(s.nextInt()));
                    obj.display();
                case 3:
                    obj.insertAtPosition(s.nextInt(), new Node(s.nextInt()));
                    obj.display();
                case 4:
                    obj.deleteFromBeginning();
                    obj.display();
                case 5:
                    obj.deleteFromLast();
                    obj.display();
                case 6:
                    obj.deleteAtPosition(s.nextInt());
                    obj.display();
                case 7:
                    obj.display();
                default:
                    System.out.println("invalid input");
            }
            System.out.println("wanna perfor any other operation enter 'y' else enter 'n'");
            ch = s.next().charAt(0);

        }
    };
}


