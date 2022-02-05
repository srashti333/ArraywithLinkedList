import java.util.LinkedList;
import java.util.Scanner;

/* Q. Write a program to find whether the array of integers contains a duplicate number. if yes print the location where duplicate numbers
 are found.*/
class AL01
{
    int n,arr[];
    LinkedList<Integer> l;
    AL01()
    {
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        arr=new int[n];
        l=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            arr[i]=s.nextInt();
        }
        l.add(arr[0]);
    }
    public void result()
    {
        int c=0,d=0;
        for(int i = 0; i <n; i++) {
            for(int j = i + 1; j < n; j++)
            {
                if(arr[i] == arr[j])
                {
                        System.out.println("element " + arr[j] + " is present on index " + i + " " + j );

                }
            }
        }
    }
}
public class AL1 {
    public static void main(String[] args) {
        AL01 obj =new AL01();
        obj.result();
    }
}
