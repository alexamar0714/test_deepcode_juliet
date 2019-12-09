/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE382_Use_of_System_Exit__Servlet_Runtime_12.java
Label Definition File: CWE382_Use_of_System_Exit__Servlet.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 382 Use of System.exit()
* Sinks: Runtime
*    GoodSink: notify user, do not use Runtime.getRuntime.exit
*    BadSink : calling Runtime.getRuntime.exit, breaching best practices
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */





import javax.servlet.http.*;

public class CWE382_Use_of_System_Exit__Servlet_Runtime_12 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            /* FLAW: use of Runtime.getRuntime.exit */
            Runtime.getRuntime().exit(1);
        }
        else
        {

            /* FIX: fail safe */
            response.getWriter().write("You cannot shut down this application, only the admin can");

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.staticReturnsTrueOrFalse())
        {
            /* FIX: fail safe */
            response.getWriter().write("You cannot shut down this application, only the admin can");
        }
        else
        {

            /* FIX: fail safe */
            response.getWriter().write("You cannot shut down this application, only the admin can");

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
