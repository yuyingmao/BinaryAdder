//*************************************************************************
//File: Gate.java
//Author: Yuying Mao
//
//*************************************************************************

/**
 * class: Gate
 * A thread class that computes only one gate.
 */
public class Gate implements Runnable
{
    //the wire array which the Gate will get the value from and put the value to
    public Wires wires;
    //3 indexs that points to the value at that index in the wire array.
    public int i1;
    public int i2;
    public int i3;

    //the index the value needs to put into the wire array.
    public int outIndex;
    /**
     * constructor.
     * set all the arguemnts to the input value
     */
    public Gate(Wires wires, int i1, int i2, int i3, int outIndex)
    {
        this.wires=wires;
        this.i1=i1;
        this.i2=i2;
        this.i3=i3;
        this.outIndex=outIndex;
    }

    /**
     * override Runnable method.
     * tries to calculate the result and puts it into the wire array.
     */
    @Override
    public void run()
    {
        try {
            wires.putValue(outIndex,
                           calculate(wires.getValue(i1),
                                     wires.getValue(i2),
                                     wires.getValue(i3)));
        } catch (InterruptedException e) {
            System.err.println("Unable to get the value for Gate");
            System.exit(1);
        }
    }

    /**
     * method: calculate
     * calculates and returns the result depends on the 3 input values.
     * will be overrided by subclasses with their own calculation.
     */
    public int calculate(int v1, int v2, int v3)
    {return 2;}
}