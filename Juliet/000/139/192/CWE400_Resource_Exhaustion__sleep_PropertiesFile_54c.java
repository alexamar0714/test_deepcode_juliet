/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_PropertiesFile_54c.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-54c.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: PropertiesFile Read count from a .properties file (in property named data)
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks:
 *    GoodSink: Validate count before using it as a parameter in sleep function
 *    BadSink : Use count as the parameter for sleep withhout checking it's size first
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */




public class CWE400_Resource_Exhaustion__sleep_PropertiesFile_54c
{
    public void badSink(int count ) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__sleep_PropertiesFile_54d()).badSink(count );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int count ) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__sleep_PropertiesFile_54d()).goodG2BSink(count );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(int count ) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__sleep_PropertiesFile_54d()).goodB2GSink(count );
    }
}
