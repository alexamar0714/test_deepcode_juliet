/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__getCookies_Servlet_write_52b.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: getCookies_Servlet Read count from the first cookie using getCookies()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */




import javax.servlet.http.*;

public class CWE400_Resource_Exhaustion__getCookies_Servlet_write_52b
{
    public void badSink(int count , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__getCookies_Servlet_write_52c()).badSink(count , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int count , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__getCookies_Servlet_write_52c()).goodG2BSink(count , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(int count , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__getCookies_Servlet_write_52c()).goodB2GSink(count , request, response);
    }
}
