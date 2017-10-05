//*************************************************************************
//File: Adder.java
//Author: Yuying Mao
//Version: v3-Sept. 28, 2017, 10:45AM
//
//Overall: A multibit binary adder circuit.
//It adds two six-bit binary numbers and yields a seven-bit binary number.
//*************************************************************************

/**
 * class: Adder
 * Main program.
 * Validate the command line arguments,
 * Create the above objects,
 * Start the threads in this order:
 * the output thread, the gate threads and finally the input thread.
 */
public class Adder
{
    /**
     * Prevent construction
     */
    private Adder(){}

    /**
     * Main Program
     */
    public static void main(String [] args) throws Throwable
    {
        //check if user inputs 2 arguements.
        if(args.length!=2)
        {
            System.err.println("Usage: java Adder <a5a4a3a2a1a0> <b5b4b3b2b1b0>");
            System.exit(1);
        }

        //check if either arguement has 6-character long.
        if(args[0].length()!=6 || args[1].length()!=6)
        {
            System.err.println("Each argument must be a 6-bit binary number.");
            System.exit(1);
        }

        //tries to convert the arguements into integer,
        //if fails, it means there must be non-int input, prints out error and exits.
        //if success, creates all the objects and starts the threads in order.
        try {
            Integer.parseInt(args[0]);
            Integer.parseInt(args[1]);
           
            Wires wires=new Wires();

            //the output thread
            new Thread(new Printer(wires,18,19,20,21,22,23,24)).start();

            //the gate threads
            new Thread(new SUM(wires,12,11,5,24)).start();
            new Thread(new MAJ(wires,12,11,5,17)).start();
            new Thread(new SUM(wires,10,4,17,23)).start();
            new Thread(new MAJ(wires,10,4,17,16)).start();
            new Thread(new SUM(wires,9,3,16,22)).start();
            new Thread(new MAJ(wires,9,3,16,15)).start();
            new Thread(new SUM(wires,8,2,15,21)).start();
            new Thread(new MAJ(wires,8,2,15,14)).start();
            new Thread(new SUM(wires,7,1,14,20)).start();
            new Thread(new MAJ(wires,7,1,14,13)).start();
            new Thread(new SUM(wires,6,0,13,19)).start();
            new Thread(new MAJ(wires,6,0,13,18)).start();

            //the input thread
            new Thread(new Putter(wires,args[0],args[1],
                                  0,1,2,3,4,5,6,7,8,9,10,11,12)).start();

        } catch (NumberFormatException e){
            System.err.println("Each argument must only contain 0 or 1.");
            System.exit(1);
        }
        
    }
}