/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_File_modulo_53c.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-53c.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded non-zero number (two)
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */




public class CWE369_Divide_by_Zero__float_File_modulo_53c
{
    public void badSink(float data ) throws Throwable
    {
        (new CWE369_Divide_by_Zero__float_File_modulo_53d()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(float data ) throws Throwable
    {
        (new CWE369_Divide_by_Zero__float_File_modulo_53d()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(float data ) throws Throwable
    {
        (new CWE369_Divide_by_Zero__float_File_modulo_53d()).goodB2GSink(data );
    }
}
