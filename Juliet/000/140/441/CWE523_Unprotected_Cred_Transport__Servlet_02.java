/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE523_Unprotected_Cred_Transport__Servlet_02.java
Label Definition File: CWE523_Unprotected_Cred_Transport__Servlet.label.xml
Template File: point-flaw-02.tmpl.java
*/
/*
* @description
* CWE: 523 Unprotected Transport of Credentials
* Sinks: non_ssl
*    GoodSink: Send across SSL connection
*    BadSink : Send across non-SSL connection
* Flow Variant: 02 Control flow: if(true) and if(false)
*
* */





import javax.servlet.http.*;

import java.io.PrintWriter;
import java.io.IOException;

import java.util.logging.Level;

public class CWE523_Unprotected_Cred_Transport__Servlet_02 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (true)
        {
            PrintWriter writer = null;
            try
            {
                writer = response.getWriter();
                /* FLAW: transmitting login credentials across a non-SSL connection */
                writer.println("<form action='http://hostname.com/j_security_check' method='post'>");
                writer.println("<table>");
                writer.println("<tr><td>Name:</td>");
                writer.println("<td><input type='text' name='j_username'></td></tr>");
                writer.println("<tr><td>Password:</td>");
                writer.println("<td><input type='password' name='j_password' size='8'></td>");
                writer.println("</tr>");
                writer.println("</table><br />");
                writer.println("<input type='submit' value='login'>");
                writer.println("</form>");
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "There was a problem writing", exceptIO);
            }
            finally
            {
                if (writer != null)
                {
                    writer.close();
                }
            }
        }
    }

    /* good1() changes true to false */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (false)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            PrintWriter writer = null;
            try
            {
                writer = response.getWriter();

                /* FIX: ensure the connection is secure (https) */
                writer.println("<form action='https://hostname.com/j_security_check' method='post'>");
                writer.println("<table>");
                writer.println("<tr><td>Name:</td>");
                writer.println("<td><input type='text' name='j_username'></td></tr>");
                writer.println("<tr><td>Password:</td>");
                writer.println("<td><input type='password' name='j_password' size='8'></td>");
                writer.println("</tr>");
                writer.println("</table><br />");
                writer.println("<input type='submit' value='login'>");
                writer.println("</form>");
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "There was a problem writing", exceptIO);
            }
            finally
            {
                if (writer != null)
                {
                    writer.close();
                }
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (true)
        {
            PrintWriter writer = null;
            try
            {
                writer = response.getWriter();
                /* FIX: ensure the connection is secure (https) */
                writer.println("<form action='https://hostname.com/j_security_check' method='post'>");
                writer.println("<table>");
                writer.println("<tr><td>Name:</td>");
                writer.println("<td><input type='text' name='j_username'></td></tr>");
                writer.println("<tr><td>Password:</td>");
                writer.println("<td><input type='password' name='j_password' size='8'></td>");
                writer.println("</tr>");
                writer.println("</table><br />");
                writer.println("<input type='submit' value='login'>");
                writer.println("</form>");
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "There was a problem writing", exceptIO);
            }
            finally
            {
                if (writer != null)
                {
                    writer.close();
                }
            }
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
        good2(request, response);
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
