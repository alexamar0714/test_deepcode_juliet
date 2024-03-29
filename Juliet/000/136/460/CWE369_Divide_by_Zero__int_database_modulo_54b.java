/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__int_database_modulo_54b.java
Label Definition File: CWE369_Divide_by_Zero__int.label.xml
Template File: sources-sinks-54b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: database Read data from a database
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */






public class CWE369_Divide_by_Zero__int_database_modulo_54b
{
    public void badSink(int data ) throws Throwable
    {
        (new CWE369_Divide_by_Zero__int_database_modulo_54c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int data ) throws Throwable
    {
        (new CWE369_Divide_by_Zero__int_database_modulo_54c()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(int data ) throws Throwable
    {
        (new CWE369_Divide_by_Zero__int_database_modulo_54c()).goodB2GSink(data );
    }
}
