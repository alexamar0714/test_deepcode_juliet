/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_URLConnection_divide_72b.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-72b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded non-zero number (two)
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */



import java.util.Vector;

public class CWE369_Divide_by_Zero__float_URLConnection_divide_72b
{
    public void badSink(Vector<Float> dataVector ) throws Throwable
    {
        float data = dataVector.remove(2);

        /* POTENTIAL FLAW: Possibly divide by zero */
        int result = (int)(100.0 / data);
        IO.writeLine(result);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(Vector<Float> dataVector ) throws Throwable
    {
        float data = dataVector.remove(2);

        /* POTENTIAL FLAW: Possibly divide by zero */
        int result = (int)(100.0 / data);
        IO.writeLine(result);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(Vector<Float> dataVector ) throws Throwable
    {
        float data = dataVector.remove(2);

        /* FIX: Check for value of or near zero before dividing */
        if (Math.abs(data) > 0.000001)
        {
            int result = (int)(100.0 / data);
            IO.writeLine(result);
        }
        else
        {
            IO.writeLine("This would result in a divide by zero");
        }

    }
}
