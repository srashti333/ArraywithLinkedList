/* Q. Write a program to find whether the array of integers contains a duplicate number. if yes print the location where duplicate numbers
 are found.*/
import java.util.Scanner;
import java.util.LinkedList;
class Test
{
    int len;
    int arr1[];
    LinkedList<Integer> l;
    Test()
    {
        Scanner s1=new Scanner(System.in);
        len= s1.nextInt();
        arr1=new int[len];
        l=new LinkedList<>();
        for(int i=0;i<len;i++)
        {
            arr1[i]=s1.nextInt();
        }
        l.add(arr1[0]);
    }

    public void result()
    {
        int u=1;
        for(int i:arr1) {
            int c=1;
            for(int j=0;j<u;j++)
            {
                if(l.get(j)==i)
                {

                    c=c+1;
                }

            }
            if(c==1)
            {
                l.add(i);
                u=u+1;
            }
        }
        if(u==len)
        {
            System.out.println("No duplicate element");
        }
        else
        {
            System.out.println("Duplicate element present");
            for(int i:l)
            {
                int c=0;
                for(int j:arr1)
                {
                    if(i==j)
                    {
                        c=c+1;
                    }
                }
                if(c>1)
                {
                    System.out.print(" element " + i + " at index ");
                    for(int j=0;j<len;j++)
                    {
                        if(i==arr1[j])
                        {
                            System.out.print(" " + j);
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Test obj=new Test();
        obj.result();
    }
}