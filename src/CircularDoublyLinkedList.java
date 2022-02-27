import java.util.Scanner;

class Node5
{
    int data;
    Node5 next;
    Node5 previous;

    Node5(int data)
    {
        this.data=data;
    }
}
class CircularDoublyLinkedList
{
    Node5 head;

    public void insertatlast(Node5 newnode)
    {
        if(head==null)
        {
            head=newnode;
            head.next=head;
            head.previous=newnode;
            return;
        }
        Node5 temp=head;
        while(temp.next!=head)
        {
            temp=temp.next;
        }
        newnode.next=head;
        newnode.previous=temp;
        temp.next=newnode;
    }

    public void insertatbegning(Node5 newnode)
    {
        if(head==null)
        {
            head=newnode;
            head.next=head;
            head.previous=newnode;
        }
        else
        {
            Node5 temp=head;
            while(temp.next!=head)
            {
                temp=temp.next;
            }
            newnode.previous=head.previous;
            temp.next=newnode;
            newnode.next=head;
            head.previous=newnode;
            head=newnode;
        }
    }

    public void deletefrombegning()
    {
        if(head==null)
        {
            System.out.println("empty list");
            return;
        }
        Node5 temp=head;
        while(temp.next!=head)
        {
            temp=temp.next;
        }
        head=head.next;
        head.previous=temp;
        temp.next=head;
    }

    public int count()
    {
        int c=1;
        Node5 temp=head;
        while(temp.next!=head)
        {
            temp=temp.next;
            c++;
        }
        return c;
    }

    public void insertatpos(int pos,Node5 newnode)
    {
        Node5 temp=head;
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
        temp.next.previous=newnode;
        newnode.previous=temp;
        temp.next=newnode;
    }
    public void deletefromlast()
    {
        if(head==null)
        {
            System.out.println("empty list");
            return;
        }
        if(head.next==head)
        {
            head=null;
            return;
        }
        Node5 temp = head;
        while (temp.next.next != head)
        {
            temp = temp.next;
        }
        temp.next=head;
        head.previous=temp;
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
        Node5 temp=head;
        for(int i=0;i<pos-2;i++)
        {
            temp=temp.next;
        }
        temp.next=temp.next.next;
        temp.next.previous=temp;
    }

    public void display()
    {
        if(head==null)
        {
            System.out.println("list is empty");
        }
        else
        {
            Node5 temp=head;
            while(temp.next!=head)
            {
                System.out.println(temp.data);
                temp=temp.next;
            }
            System.out.println(temp.data);
        }
    }
    public void reverse()
    {
        if(head==null)
        {
            System.out.println("list is empty");
        }
        else
        {
            Node5 temp=head;
            while(temp.next!=head)
            {
                temp=temp.next;
            }
            while(temp!=head)
            {
                System.out.println(temp.data);
                temp=temp.previous;
            }
            System.out.println(temp.data);
        }
    }
}
class Test1 {
    public static void main(String[] args) {
        System.out.println("""
                press <1> for inseting node at the beginning
                press<2> for inserting node at the last
                press <3> for inserting at specific position
                press <4> for deleting node at the beginning
                press<5> for deleting node at the last
                press <6> for deleting at specific position
                press <7> to display the data of linked list
                press <8> to count the no. of nodes
                press <9> to display in reverse\n
                """);
        Scanner s=new Scanner(System.in);

        CircularDoublyLinkedList obj=new CircularDoublyLinkedList();
        char ch='y';
        while(ch=='y'|| ch=='Y')
        {
            int n=s.nextInt();
            switch (n)
            {
                case 1:
                    obj.insertatbegning(new Node5(s.nextInt()));
                    obj.display();
                    break;
                case 2:
                    obj.insertatlast(new Node5(s.nextInt()));
                    obj.display();
                    break;
                case 3:
                    obj.insertatpos(s.nextInt(), new Node5(s.nextInt()));
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
                case 9:
                    obj.reverse();
                    break;
                default:
                    System.out.println("invalid input");
            }
            System.out.println("\nwanna perform any other operation enter 'y' else enter 'n'");
            ch=s.next().charAt(0);
        }
    }
}