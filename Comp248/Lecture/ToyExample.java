

/**
 Demonstrates the correct way to define an accessor
 method to a private array of class objects.
*/
public class ToyExample
{
    private Date1[] a;

    public ToyExample(int arraySize)
    {
        a = new Date1[arraySize];
        for (int i = 0; i < arraySize; i++)
             a[i] = new Date1( );
    }

    public ToyExample(ToyExample object)
    {
        int lengthOfArrays = object.a.length;
        this.a = new Date1[lengthOfArrays];
        for (int i = 0; i < lengthOfArrays; i++)
             this.a[i] = new Date1(object.a[i]);
    }

    public Date1[] getDateArray( )
    {
        Date1[] temp = new Date1[a.length];
        for (int i = 0; i < a.length; i++)
            temp[i] = new Date1(a[i]);
        return temp;
    }

       //   <There presumably are other methods that are not shown,
                           //but they are irrelevant to the point at hand.>

}

