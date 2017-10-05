//*************************************************************************
//File: Printer.java
//Author: Yuying Mao
//
//*************************************************************************

/**
 * class: Printer
 * A thread class that prints the output of the adder circuit.
 */
public class Printer implements Runnable
{
    //the wire array which the contains the result that the Printer will print out.
    private Wires wires;
    //the start and end index of the wire array
    private int i18;
    private int i19;
    private int i20;
    private int i21;
    private int i22;
    private int i23;
    private int i24;
        
    /**
     * constructor
     */
    public Printer(Wires wires,int i18,int i19,int i20,
                   int i21,int i22,int i23,int i24)
    {
        this.wires=wires;
        this.i18=i18;
        this.i19=i19;
        this.i20=i20;
        this.i21=i21;
        this.i22=i22;
        this.i23=i23;
        this.i24=i24;
    }

    /**
     * tries to get the value at index i,
     * if successes, prints it out.
     * if fails, prints error and exits.
     */
    public void run()
    {
        try {
            System.out.print((wires.getValue(i18)));
            System.out.print((wires.getValue(i19)));
            System.out.print((wires.getValue(i20)));
            System.out.print((wires.getValue(i21)));
            System.out.print((wires.getValue(i22)));
            System.out.print((wires.getValue(i23)));
            System.out.print((wires.getValue(i24)));

            System.out.println();
        } catch (InterruptedException e){
            System.err.println("Unable to print the result from wires");
            System.exit(1);
        } 
    }
}