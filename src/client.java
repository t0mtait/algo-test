import java.util.Random;


public class client
{
public static void init()
{
    int attempted = 0;
    Stopwatch x = new Stopwatch();
    int[] list = new int[1000];
    Random y = new Random();
    for (int i = 0; i < list.length; i++)
        {
            list[i] = y.nextInt(50000);
        }
    System.out.println("Time taken to create and populate list: " + x.elapsedTime());
    

    for (int i = 0; i < list.length; i++)
        {
            System.out.print(list[i] + "\t");
        }
    while (isSorted(list) == false)
    {
        attempted++;
        shuffle(list);
        if(x.elapsedTime()%2 == 0)
        {
            System.out.println("Program still running. Time elapsed: " + x.elapsedTime() + "s " + "Combinations attempted: " + attempted);
            
        }
    }
    if (isSorted(list) == true)
    {
        System.out.println("Time taken to create and populate list and bogo sort it: " + x.elapsedTime());
    }

    
}

static void shuffle(int[] a)
    {
        // Math.random() returns a double positive
        // value, greater than or equal to 0.0 and
        // less than 1.0.
        for (int i = 0; i < a.length; i++)
            swap(a, i, (int)(Math.random() * i));
    }

    static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static boolean isSorted(int[] a)
    {
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i - 1])
                return false;
        return true;
    }
    public static void main (String[]args)
    {
        init();

    }
}
