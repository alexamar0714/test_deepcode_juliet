/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__empty_block_16.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: empty_block
*    GoodSink: Include some code inside a block
*    BadSink : An empty code block has no effect
* Flow Variant: 16 Control flow: while(true)
*
* */





public class CWE398_Poor_Code_Quality__empty_block_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        while(true)
        {
            /* FLAW: The empty block on the next line has no effect */
            {
            }
            IO.writeLine("Hello from bad()");
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        while(true)
        {
            /* FIX: Include some code inside the block */
            {
                String sentence = "Inside the block"; /* Define a variable to justify having a block for scoping */
                IO.writeLine(sentence);
            }
            IO.writeLine("Hello from good()");
            break;
        }
    }

    public void good() throws Throwable
    {
        good1();
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
