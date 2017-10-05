//*************************************************************************
//File: MAJ.java
//Author: Yuying Mao
//
//*************************************************************************

/**
 * class: MAJ
 * A subclass of Gate.
 */
public class MAJ extends Gate
{
    /**
     * constructor
     */
    public MAJ(Wires wires, int i1, int i2, int i3, int outIndex)
    {
        super(wires,i1,i2,i3,outIndex);
    }

    @Override
    public int calculate(int v1, int v2, int v3)
    {
        int result=2;
        if(v1==0)
        {
            if(v2==0) result=0;
            else
            {
                if(v3==0) result=0;
                else result=1;
            }
        }
        else
        {
            if(v2==0)
            {
                if(v3==0) result=0;
                else result=1;
            }
            else result=1;
        }
        return result;
    }
}