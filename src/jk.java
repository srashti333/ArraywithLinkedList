import java.util.Scanner;

class Node1
{
    int data;
    Node1 next;
    Node1 previous;

    Node1(int data)
    {

        this.data=data;
    }
}

class DoubllyLList
{
    Node1 head;

    public void insertatbeggning(Node1 newnode)
    {
        if(head==null)
        {
            head=newnode;
            return;
        }
        head.previous=newnode;
        newnode.next=head;
        head=newnode;
    }

    public void insertatLast(Node1 newnode)
    {
        if(head==null)
        {
            head=newnode;
            return;
        }
        Node1 temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.previous=temp;

    }

    public void insertatpostion(int pos, Node1 newnode)
    {
        Node1 temp=head;
        for(int i=0;i<pos-2;i++)
        {
            temp=temp.next;
        }
        newnode.previous=temp;
        newnode.next=temp.next;
        temp=temp.next;
        temp.previous=newnode;
        temp=newnode.previous;
        temp.next=newnode;
    }
    public void deletefrombegnning()
    {
        if(head==null)
        {
            System.out.println("Linked List is empty");
            return;
        }
        head=head.next;
        head.previous=null;

    }

    public void deletefromlast()
    {
        if(head==null)
        {
            System.out.println("Linkeadlist is empty");
            return;
        }
        if(head.next==null)
        {
            head=null;
            return;
        }
        Node1 temp=head;
        while(temp.next.next!=null)
        {
            temp=temp.next;
        }
        temp.next=null;

    }

    public void deletefrompos(int pos)
    {
        if(head==null)
        {
            System.out.println("empty");
        }
        Node1 temp=head;
        Node1 previous=null;
        for(int i=0;i<pos-2;i++)
        {
            temp=temp.next;
        }
        temp.next.next.previous=temp;
        temp.next=temp.next.next;
        reversedisplay();
    }

    public void delete()
    {
        if(head==null)
        {
            System.out.println("empty");
        }
        else
        {
            Node1 temp=head;
            Node1 previous=null;
            while(temp.next!=null)
            {
                previous=temp;
                temp=temp.next;
            }
            if(temp==head)
            {
                head=null;
            }
        }
    }

    public void display()
    {
        if(head==null)
        {
            System.out.println("LinkedList is empty");
        }
        else
        {
            Node1 temp=head;
            while(temp!=null)
            {
                System.out.println(temp.data);
                temp=temp.next;
            }
        }
    }

    public void reversedisplay()
    {
        if(head==null)
        {
            System.out.println("LinkedList is empty");
        }
        else
        {
            Node1 temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            while(temp!=null)
            {
                System.out.println(temp.data);
                temp=temp.previous;
            }
        }
    }
}

public class jk
{
    public static void main(String[] args) {
        System.out.println("""
                press <1> for inseting node at the beginning
                press<2> for inserting node at the last
                press <3> for inserting at specific position
                press <4> for deleting node at the beginning
                press<5> for deleting node at the last
                press <6> for deleting at specific position
                press <7> to display the data of linked list
                press <8> to display in reverse
                """);
        Scanner s=new Scanner(System.in);

        DoubllyLList obj=new DoubllyLList();
        char ch='y';
        while(ch=='y'|| ch=='Y')
        {
            int n=s.nextInt();
            switch (n)
            {
                case 1:
                    obj.insertatbeggning(new Node1(s.nextInt()));
                    obj.display();
                    break;
                case 2:
                    obj.insertatLast(new Node1(s.nextInt()));
                    obj.display();
                    break;
                case 3:
                    obj.insertatpostion(s.nextInt(), new Node1(s.nextInt()));
                    obj.display();
                    break;
                case 4:
                    obj.deletefrombegnning();
                    obj.display();
                    break;
                case 5:
                    obj.deletefromlast();
                    obj.display();
                    break;
                case 6:
                    obj.deletefrompos(s.nextInt());
                    obj.display();
                    break;
                case 7:
                    obj.display();
                    break;
                case 8:
                    obj.reversedisplay();
                    break;
                default:
                    System.out.println("invalid input");
            }
            System.out.println("wanna perfor any other operation enter 'y' else enter 'n'");
            ch=s.next().charAt(0);
        }
    }
}