import java.io.*; //We assume that the input will be from a seperate file in this example

public class SelectionSort
{
    int[] integerArray; //The code used to sort integers can be applied to any other numerical data type(eg. long, float, double) as well as characters
    String[] stringArray; //Can be used to sort any other type of object that has the compareTo() function properly formatted

    public void getIntegerInput ()
    { //Adapt this method for different types of input
        integerArray = new int [20];
        try
        {
            BufferedReader br = new BufferedReader (new FileReader ("integers.txt"));
            String temp;
            for (int i = 0 ; (temp = br.readLine ()) != null ; i++)
            {
                integerArray [i] = Integer.parseInt (temp);
            }
        }
        catch (IOException e)
        {
            System.out.println (e);
        }
    }


    public void getStringInput ()
    { //Adapt this method for different types of input
        stringArray = new String [20];
        try
        {
            BufferedReader br = new BufferedReader (new FileReader ("strings.txt"));
            String temp;
            for (int i = 0 ; (temp = br.readLine ()) != null ; i++)
            {
                stringArray [i] = temp;
            }
        }
        catch (IOException e)
        {
            System.out.println (e);
        }
    }


    public void stringSelectionSort ()
    {
        int smallest;
        for (int i = 0 ; i < stringArray.length ; i++)//Loops through the entire array
        {
            int j;
            smallest = stringArray.length - 1;
            for (j = i ; j < stringArray.length - 1 ; j++)
            {
                if (stringArray [smallest].compareTo (stringArray [j]) < 0)
                {
                    smallest = j;
                }
            }
            stringArray = stringCycle (stringArray, smallest);
        }
    }


    private String[] stringCycle (String[] stringArr, int end)
    { //Rotates a section of the array, between 0 and end
        String temp = stringArr [end];
        for (int i = end - 1 ; i >= 0 ; i--)
        {
            stringArr [i + 1] = stringArr [i];
        }
        stringArr [0] = temp;
        return stringArr;
    }


    public void intSelectionSort ()
    {
        int smallest;
        for (int i = 0 ; i < integerArray.length ; i++)
        {
            int j;
            smallest = integerArray.length - 1;
            for (j = i ; j < integerArray.length - 1 ; j++)
            {
                if (integerArray [smallest] < integerArray [j])
                {
                    smallest = j;
                }
            }
            integerArray = intCycle (integerArray, smallest);
        }
    }


    private int[] intCycle (int[] intArr, int end)
    { //Rotates a section of the array, between 0 and end
        int temp = intArr [end];
        for (int i = end - 1 ; i >= 0 ; i--)
        {
            intArr [i + 1] = intArr [i];
        }
        intArr [0] = temp;
        return intArr;
    }


    public String toString ()
    {
        if (integerArray != null)
            for (int i = 0 ; i < integerArray.length - 1 ; i++)
                return "" + integerArray [i];
        if (stringArray != null)
            for (int i = 0 ; i < stringArray.length - 1 ; i++)
                return stringArray [i];
        return null;
    }


    public static void main (String[] args)
    {
        SelectionSort is = new SelectionSort ();
        is.getStringInput ();
        is.stringSelectionSort();
        is.getIntegerInput ();
        is.intSelectionSort ();
        System.out.println (is);
    }
}
