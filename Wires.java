//*************************************************************************
//File: Wires.java
//Author: Yuying Mao
//
//*************************************************************************

/**
 * class: Wire
 * A monitor class that holds the value of each wire in the adder circuit.
*/
public class Wires
{
    //the wire array, contains 25 integers which represent 25 wires.
    public int[] values;

    /**
     * constructor
     * initialize the wire array with 2.
     */
    public Wires()
    {
        values=new int[25];
        for(int i=0;i<25;i++)
        {
            values[i]=2;
        }
    }
    
    /**
    * method: putValue
    * Puts the given value into the monitor at index i.
    * It is an error if value is not 0 or 1 or a value has already been put at index i.
    * If error occurs, prints out the error and exits.
    */
    public synchronized void putValue(int i, int value)
    {
        if(value==1 || value==0 && values[i]==2)
        {
            values[i]=value;
            notifyAll();
        }

        //check if inputs are not only 0s and 1s.
        else if(value!=1 && value!=0)
        {
            System.err.println("Each argument must only contain 0 or 1.");
            System.exit(1);
        }
        //check if the index at the array has value already.
        else
        {
            System.err.println("Unable to put "+ value +" at index "+i);
            System.exit(1);
        }
    }

    /**
    * method: getValue
    * Returns the value stored in the monitor at index i.
    * It does not return until the value at index i has been put.
    */
    public synchronized int getValue(int i) throws InterruptedException
    {
        while(values[i]==2)
        {
            wait();
        }
        
        return values[i];
    }
}