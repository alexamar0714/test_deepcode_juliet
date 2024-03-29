/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__int_getCookies_Servlet_divide_71b.java
Label Definition File: CWE369_Divide_by_Zero__int.label.xml
Template File: sources-sinks-71b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */




import javax.servlet.http.*;

public class CWE369_Divide_by_Zero__int_getCookies_Servlet_divide_71b
{
    public void badSink(Object dataObject , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = (Integer)dataObject;

        /* POTENTIAL FLAW: Zero denominator will cause an issue.  An integer division will
        result in an exception. */
        IO.writeLine("bad: 100/" + data + " = " + (100 / data) + "\n");

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(Object dataObject , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = (Integer)dataObject;

        /* POTENTIAL FLAW: Zero denominator will cause an issue.  An integer division will
        result in an exception. */
        IO.writeLine("bad: 100/" + data + " = " + (100 / data) + "\n");

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(Object dataObject , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = (Integer)dataObject;

        /* FIX: test for a zero denominator */
        if (data != 0)
        {
            IO.writeLine("100/" + data + " = " + (100 / data) + "\n");
        }
        else
        {
            IO.writeLine("This would result in a divide by zero");
        }

    }
}
