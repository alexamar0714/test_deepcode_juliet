/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_PropertiesFile_73a.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-73a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: PropertiesFile Read count from a .properties file (in property named data)
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks:
 *    GoodSink: Validate count before using it as a parameter in sleep function
 *    BadSink : Use count as the parameter for sleep withhout checking it's size first
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */



import java.util.LinkedList;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Level;

public class CWE400_Resource_Exhaustion__sleep_PropertiesFile_73a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int count;

        count = Integer.MIN_VALUE; /* Initialize count */

        /* retrieve the property */
        {
            Properties properties = new Properties();
            FileInputStream streamFileInput = null;

            try
            {
                streamFileInput = new FileInputStream("../common/config.properties");
                properties.load(streamFileInput);

                /* POTENTIAL FLAW: Read count from a .properties file */
                String stringNumber = properties.getProperty("data");
                if (stringNumber != null) // avoid NPD incidental warnings
                {
                    try
                    {
                        count = Integer.parseInt(stringNumber.trim());
                    }
                    catch(NumberFormatException exceptNumberFormat)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing count from string", exceptNumberFormat);
                    }
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
                /* Close stream reading object */
                try
                {
                    if (streamFileInput != null)
                    {
                        streamFileInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                }
            }
        }

        LinkedList<Integer> countLinkedList = new LinkedList<Integer>();
        countLinkedList.add(0, count);
        countLinkedList.add(1, count);
        countLinkedList.add(2, count);
        (new CWE400_Resource_Exhaustion__sleep_PropertiesFile_73b()).badSink(countLinkedList  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        int count;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        count = 2;

        LinkedList<Integer> countLinkedList = new LinkedList<Integer>();
        countLinkedList.add(0, count);
        countLinkedList.add(1, count);
        countLinkedList.add(2, count);
        (new CWE400_Resource_Exhaustion__sleep_PropertiesFile_73b()).goodG2BSink(countLinkedList  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        int count;

        count = Integer.MIN_VALUE; /* Initialize count */

        /* retrieve the property */
        {
            Properties properties = new Properties();
            FileInputStream streamFileInput = null;

            try
            {
                streamFileInput = new FileInputStream("../common/config.properties");
                properties.load(streamFileInput);

                /* POTENTIAL FLAW: Read count from a .properties file */
                String stringNumber = properties.getProperty("data");
                if (stringNumber != null) // avoid NPD incidental warnings
                {
                    try
                    {
                        count = Integer.parseInt(stringNumber.trim());
                    }
                    catch(NumberFormatException exceptNumberFormat)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing count from string", exceptNumberFormat);
                    }
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
                /* Close stream reading object */
                try
                {
                    if (streamFileInput != null)
                    {
                        streamFileInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                }
            }
        }

        LinkedList<Integer> countLinkedList = new LinkedList<Integer>();
        countLinkedList.add(0, count);
        countLinkedList.add(1, count);
        countLinkedList.add(2, count);
        (new CWE400_Resource_Exhaustion__sleep_PropertiesFile_73b()).goodB2GSink(countLinkedList  );
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
