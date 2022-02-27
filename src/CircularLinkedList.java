import java.util.Scanner;

class Node2
{
    int data;
    Node2 next;
    public Node2(int data)
    {
        this.data=data;
    }
}
public class CircularLinkedList {
    Node2 head = null;
    Node2 tail= null;
    int c=0;

    public void insertatBegg(Node2 newnode)
    {
        if(head==null)
        {
            head = newnode;
            tail=newnode;
            newnode.next = head;
            return;
        }
        newnode.next=head;
        head=newnode;
    }

    public void insertatlast(Node2 newnode)
    {
        if(head==null)
        {
            head=newnode;
            newnode.next=head;
            return;
        }
        Node2 temp=head;
        if(temp.next==head)
        {
            temp.next=newnode;
            newnode.next=head;
        }
        while(temp!=head)
        {
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.next=head;

    }
    public void insertatpos(int pos, Node2 newnode)
    {
        if (pos <= 0)
        {
            System.out.println("cant insert,give value greater than 0");
            return;
        }
        if(pos==1)
        {
            newnode.next=head;
            head=newnode;
            newnode.next.next=head;
            return;
        }
        Node2 temp=head;
        if(pos==c)
        {
            while(temp.next!=head)
            {
                temp=temp.next;
            }
            newnode.next=head;
            temp.next=newnode;
            return;
        }
        for (int i = 0; i < pos - 2; i++)
        {
            temp = temp.next;
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }

    public void deletefrobegg()
    {
        if(head==null)
        {
            System.out.println("empty");
            return;
        }
        head=head.next;
        Node2 temp=head;
        while(temp.next!=head)
        {
            temp=temp.next;
        }
        temp.next=head;
    }

    public void deletefrolast()
    {
        if(head==null)
        {
            System.out.println("empty");
            return;
        }
        if(head.next==head)
        {
            head=null;
            return;
        }
        Node2 temp=head;
        while(temp.next.next!=head)
        {
            temp=temp.next;
        }
        temp.next=head;
    }


    public void deletefromposi(int pos)
    {
        if(head==null)
        {
            System.out.println("empty");
            return;
        }
        Node2 temp=head;
        if(pos==1)
        {
            head=head.next;
            while(temp.next!=head)
            {
                temp=temp.next;
            }
            temp.next=head;
            return;
        }
        if(pos==c)
        {
            while(temp.next.next!=head)
            {
                temp=temp.next;
            }
            temp.next=head;
            return;
        }
        for(int i=0;i<pos-1;i++)
        {
            temp=temp.next;
        }
        temp.next=temp.next.next;

    }

    public void count()
    {
        if(head==null)
        {
            System.out.println("empty");
            return;
        }
        Node2 temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
            c++;
        }
        System.out.println(c);
    }

    public void display()
    {
        if(head==null)
        {
            System.out.println("list is empty");
            return;
        }

        Node2 temp=head;
        while(temp.next!= head)
        {
            System.out.print(temp.data+ " ");
            temp=temp.next;
        }
        System.out.print(temp.data);
    }
}


class main
{
    public static void main(String[] args)
    {
        System.out.println("""
                press <1> for inseting node at the beginning
                press<2> for inserting node at the last
                press <3> for inserting at specific position
                press <4> for deleting node at the beginning
                press<5> for deleting node at the last
                press <6> for deleting at specific position
                press <7> to display the data of linked list
                press <8> to count the no. of nodes\n
                """);
        Scanner s=new Scanner(System.in);

        CircularLinkedList obj=new CircularLinkedList();
        char ch='y';
        while(ch=='y'|| ch=='Y')
        {
            int n=s.nextInt();
            switch (n)
            {
                case 1:
                    obj.insertatBegg(new Node2(s.nextInt()));
                    obj.display();
                    break;
                case 2:
                    obj.insertatlast(new Node2(s.nextInt()));
                    obj.display();
                    break;
                case 3:
                    obj.insertatpos(s.nextInt(), new Node2(s.nextInt()));
                    obj.display();
                    break;
              case 4:
                    obj.deletefrobegg();
                    obj.display();
                    break;
                case 5:
                    obj.deletefrolast();
                    obj.display();
                    break;
                case 6:
                    obj.deletefromposi(s.nextInt());
                    obj.display();
                    break;
                case 7:
                    obj.display();
                    break;
                case 8:
                    obj.count();
                    break;
                default:
                    System.out.println("invalid input");
            }
            System.out.println("\nwanna perform any other operation enter 'y' else enter 'n'");
            ch=s.next().charAt(0);
        }
    }
}