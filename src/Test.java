import java.util.Scanner;

class Node4
{
    int data;
    Node4 next;

    Node4(int data)
    {
        this.data=data;
    }
}
 class CircularSinglyLinkedList
{
    Node4 head;

    public void insertatlast(Node4 newnode)
    {
        if(head==null)
        {
            head=newnode;
            head.next=head;
        }
        else
        {
            Node4 temp=head;
            while(temp.next!=head)
            {
                temp=temp.next;
            }
            temp.next=newnode;
            newnode.next=head;

        }
    }

    public void insertatbegning(Node4 newnode)
    {
        if(head==null)
        {
            head=newnode;
            head.next=head;
        }
        else
        {
            Node4 temp=head;
            while(temp.next!=head)
            {
                temp=temp.next;
            }
            temp.next=newnode;
            newnode.next=head;
            head=newnode;
        }
    }

    public void deletefrombegning()
    {
        if(head==null)
        {
            System.out.println("empty list");
        }
        else
        {
            Node4 temp=head;
            while(temp.next!=head)
            {
                temp=temp.next;
            }
            head=head.next;
            temp.next=head;
        }
    }

    public int count()
    {
         int c=1;
        Node4 temp=head;
        while(temp.next!=head)
        {
            temp=temp.next;
            c++;
        }
        return c;
    }
    public void insertatpos(int pos,Node4 newnode)
    {
        Node4 temp=head;
        if(pos<=0)
        {
            System.out.println("invald");
            return;
        }
        if(pos==1)
        {
            insertatbegning(newnode);
            return;
        }
        int c=count();
        if(pos==c+1)
        {
            insertatlast(newnode);
            return;
        }

        for(int i=0;i<pos-2;i++)
        {
            temp=temp.next;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }
    public void deletefromlast()
    {
        if(head==null)
        {
            System.out.println("empty list");
        }
        else
        {
            if(head.next==head)
            {
                head=null;
            }
            else
            {
                Node4 temp = head;
                while (temp.next.next != head) {
                    temp = temp.next;
                }
                temp.next=head;
            }

        }
    }

    public void delatpos(int pos)
    {
        if(pos<=0)
        {
            System.out.println("invalid");
            return;
        }
        if(pos==1)
        {
            deletefrombegning();
            return;
        }
        int c=count();
        if(pos==c)
        {
            deletefromlast();
            return;
        }
        Node4 temp=head;
        for(int i=0;i<pos-2;i++)
        {
            temp=temp.next;
        }
        temp.next=temp.next.next;
    }

    public void display()
    {
        if(head==null)
        {
            System.out.println("list is empty");
        }
        else
        {
            Node4 temp=head;
            while(temp.next!=head)
            {
                System.out.println(temp.data);
                temp=temp.next;
            }
            System.out.println(temp.data);
        }
    }
}
public class Test {
    public static void main(String[] args) {
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

        CircularSinglyLinkedList obj=new CircularSinglyLinkedList();
        char ch='y';
        while(ch=='y'|| ch=='Y')
        {
            int n=s.nextInt();
            switch (n)
            {
                case 1:
                    obj.insertatbegning(new Node4(s.nextInt()));
                    obj.display();
                    break;
                case 2:
                    obj.insertatlast(new Node4(s.nextInt()));
                    obj.display();
                    break;
                case 3:
                    obj.insertatpos(s.nextInt(), new Node4(s.nextInt()));
                    obj.display();
                    break;
                case 4:
                    obj.deletefrombegning();
                    obj.display();
                    break;
                case 5:
                    obj.deletefromlast();
                    obj.display();
                    break;
               case 6:
                    obj.delatpos(s.nextInt());
                    obj.display();
                    break;
                case 7:
                    obj.display();
                    break;
                case 8:
                    System.out.println(obj.count());
                    break;
                default:
                    System.out.println("invalid input");
            }
            System.out.println("\nwanna perform any other operation enter 'y' else enter 'n'");
            ch=s.next().charAt(0);
        }
    }
}