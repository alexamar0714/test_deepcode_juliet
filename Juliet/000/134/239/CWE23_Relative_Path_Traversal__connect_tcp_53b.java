/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__connect_tcp_53b.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-53b.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : no validation
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */





import java.io.*;


public class CWE23_Relative_Path_Traversal__connect_tcp_53b
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE23_Relative_Path_Traversal__connect_tcp_53c()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE23_Relative_Path_Traversal__connect_tcp_53c()).goodG2BSink(data );
    }
}
