/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE511_Logic_Time_Bomb__time_08.java
Label Definition File: CWE511_Logic_Time_Bomb.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 511 Logic Time Bomb
* Sinks: time
*    GoodSink: after a certain date, print to the console
*    BadSink : after a certain date, launch an executable
* Flow Variant: 08 Control flow: if(privateReturnsTrue()) and if(privateReturnsFalse())
*
* */





import java.util.Calendar;

public class CWE511_Logic_Time_Bomb__time_08 extends AbstractTestCase
{
    /* The methods below always return the same value, so a tool
     * should be able to figure out that every call to these
     * methods will return true or return false.
     */
    private boolean privateReturnsTrue()
    {
        return true;
    }

    private boolean privateReturnsFalse()
    {
        return false;
    }

    public void bad() throws Throwable
    {
        if (privateReturnsTrue())
        {
            Calendar calendarNow = Calendar.getInstance();
            Calendar calendarCheck = Calendar.getInstance();
            calendarCheck.set(2020, 1, 1);
            /* FLAW: date triggered backdoor */
            if (calendarNow.after(calendarCheck))
            {
                Runtime.getRuntime().exec("c:\\windows\\system32\\evil.exe");
            }
        }
    }

    /* good1() changes privateReturnsTrue() to privateReturnsFalse() */
    private void good1() throws Throwable
    {
        if (privateReturnsFalse())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            Calendar calendarNow = Calendar.getInstance();

            Calendar calendarCheck = Calendar.getInstance();
            calendarCheck.set(2020, 1, 1);

            /* FIX: no backdoor exists */
            if (calendarNow.after(calendarCheck))
            {
                IO.writeLine("Sorry, your license has expired.  Please contact support.");
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (privateReturnsTrue())
        {
            Calendar calendarNow = Calendar.getInstance();
            Calendar calendarCheck = Calendar.getInstance();
            calendarCheck.set(2020, 1, 1);
            /* FIX: no backdoor exists */
            if (calendarNow.after(calendarCheck))
            {
                IO.writeLine("Sorry, your license has expired.  Please contact support.");
            }
        }
    }

    public void good() throws Throwable
    {
        good1();
        good2();
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
