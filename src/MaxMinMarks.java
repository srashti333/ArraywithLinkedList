import java.util.Scanner;

/* Q. Create an array of 10 students and print the record of those students who got the
 highest marks and who got minimum marks. The structure of student class is as follows
class Student
{
	private String name;
	private int rollno;
	private int marks;
} */
public class MaxMinMarks {
    int rollno;
    String name;
    int marks;
    int a;
    int m[];
    int r[];
    String n[];

    public MaxMinMarks() {
        Scanner s = new Scanner(System.in);
        a = s.nextInt();

        n = new String[a];
        r = new int[a];
        m = new int[a];

        for (int i = 0; i < a; i++) {
            name = s.next();
            rollno = s.nextInt();
            marks = s.nextInt();

            n[i] = name;
            r[i] = rollno;
            m[i] = marks;

        }
    }
    public void result()
    {
            int c = 0;
            int t = 0;
            for (int i = 0; i < a; i++)
            {
                if (c < m[i])
                {
                    c = m[i];
                    t = i;
                }
            }
            System.out.println("Student " + n[t] + " rollno " + r[t] + " got higest marks " + m[t]);
            for (int i = 0; i < a; i++)
            {
                if (c > m[i])
                {
                    c = m[i];
                    t = i;
                }
            }
            System.out.println("Student " + n[t] + " rollno " + r[t] + " got lowest marks " + m[t]);
    }


    public static void main(String[] args)
    {
        MaxMinMarks obj = new MaxMinMarks();
        obj.result();


    }

}
