//*************************************************************************
//File: Putter.java
//Author: Yuying Mao
//
//*************************************************************************

/**
* class: Putter
* A thread class that puts the inputs from the command line into the adder
* circuit, as well as the value 0 into the carry input.
*/
public class Putter implements Runnable
{
    //3 private arguements:
    // the wire array which the Putter will put the value in.
    private Wires wires;
    // 2 strings which are the user's input.
    private String a;
    private String b;
    //12 indexs refers where the wire array will store those inputs
    private int i0;
    private int i1;
    private int i2;
    private int i3;
    private int i4;
    private int i5;
    private int i6;
    private int i7;
    private int i8;
    private int i9;
    private int i10;
    private int i11;
    private int i12;

    /**
    * constructor
    * set the value of each arguement as the input.
    */
    public Putter(Wires wires, String input1, String input2,
                  int i0,int i1,int i2,int i3,int i4,int i5,
                  int i6,int i7,int i8,int i9,int i10,int i11,int i12)
    {
        this.wires=wires;
        this.a=input1;
        this.b=input2;
        this.i0=i0;
        this.i1=i1;
        this.i2=i2;
        this.i3=i3;
        this.i4=i4;
        this.i5=i5;
        this.i6=i6;
        this.i7=i7;
        this.i8=i8;
        this.i9=i9;
        this.i10=i10;
        this.i11=i11;
        this.i12=i12;
    }

    /**
     * method: run
     * gets the converted input and puts them into the wire array,
     * as well as 0.
     */
    public void run()
    {
        String[] input1=a.split("");
        String[] input2=b.split("");

        wires.putValue(i0,Integer.parseInt(input1[0]));
        wires.putValue(i1,Integer.parseInt(input1[1]));
        wires.putValue(i2,Integer.parseInt(input1[2]));
        wires.putValue(i3,Integer.parseInt(input1[3]));
        wires.putValue(i4,Integer.parseInt(input1[4]));
        wires.putValue(i5,Integer.parseInt(input1[5]));
        wires.putValue(i6,Integer.parseInt(input2[0]));
        wires.putValue(i7,Integer.parseInt(input2[1]));
        wires.putValue(i8,Integer.parseInt(input2[2]));
        wires.putValue(i9,Integer.parseInt(input2[3]));
        wires.putValue(i10,Integer.parseInt(input2[4]));
        wires.putValue(i11,Integer.parseInt(input2[5]));
        wires.putValue(i12,0);
    }
}