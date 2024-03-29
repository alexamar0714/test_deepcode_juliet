/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE36_Absolute_Path_Traversal__connect_tcp_53c.java
Label Definition File: CWE36_Absolute_Path_Traversal.label.xml
Template File: sources-sink-53c.tmpl.java
*/
/*
 * @description
 * CWE: 36 Absolute Path Traversal
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : read line from file from disk
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */





import java.io.*;


public class CWE36_Absolute_Path_Traversal__connect_tcp_53c
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE36_Absolute_Path_Traversal__connect_tcp_53d()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE36_Absolute_Path_Traversal__connect_tcp_53d()).goodG2BSink(data );
    }
}
