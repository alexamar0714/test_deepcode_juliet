/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__Property_executeQuery_14.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-14.tmpl.java
*/
/*
* @description
* CWE: 89 SQL Injection
* BadSource: Property Read data from a system property
* GoodSource: A hardcoded string
* Sinks: executeQuery
*    GoodSink: Use prepared statement and executeQuery (properly)
*    BadSink : data concatenated into SQL statement used in executeQuery(), which could result in SQL Injection
* Flow Variant: 14 Control flow: if(IO.staticFive==5) and if(IO.staticFive!=5)
*
* */






import java.sql.*;

import java.util.logging.Level;

public class CWE89_SQL_Injection__Property_executeQuery_14 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;
        if (IO.staticFive==5)
        {
            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            data = System.getProperty("user.home");
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.staticFive==5)
        {
            Connection dbConnection = null;
            Statement sqlStatement = null;
            ResultSet resultSet = null;
            try
            {
                dbConnection = IO.getDBConnection();
                sqlStatement = dbConnection.createStatement();
                /* POTENTIAL FLAW: data concatenated into SQL statement used in executeQuery(), which could result in SQL Injection */
                resultSet = sqlStatement.executeQuery("select * from users where name='"+data+"'");
                IO.writeLine(resultSet.getRow()); /* Use ResultSet in some way */
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
            }
            finally
            {
                try
                {
                    if (resultSet != null)
                    {
                        resultSet.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing ResultSet", exceptSql);
                }

                try
                {
                    if (sqlStatement != null)
                    {
                        sqlStatement.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing Statement", exceptSql);
                }

                try
                {
                    if (dbConnection != null)
                    {
                        dbConnection.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
                }
            }
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing first IO.staticFive==5 to IO.staticFive!=5 */
    private void goodG2B1() throws Throwable
    {
        String data;
        if (IO.staticFive!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }
        else
        {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }

        if (IO.staticFive==5)
        {
            Connection dbConnection = null;
            Statement sqlStatement = null;
            ResultSet resultSet = null;
            try
            {
                dbConnection = IO.getDBConnection();
                sqlStatement = dbConnection.createStatement();
                /* POTENTIAL FLAW: data concatenated into SQL statement used in executeQuery(), which could result in SQL Injection */
                resultSet = sqlStatement.executeQuery("select * from users where name='"+data+"'");
                IO.writeLine(resultSet.getRow()); /* Use ResultSet in some way */
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
            }
            finally
            {
                try
                {
                    if (resultSet != null)
                    {
                        resultSet.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing ResultSet", exceptSql);
                }

                try
                {
                    if (sqlStatement != null)
                    {
                        sqlStatement.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing Statement", exceptSql);
                }

                try
                {
                    if (dbConnection != null)
                    {
                        dbConnection.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
                }
            }
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        if (IO.staticFive==5)
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.staticFive==5)
        {
            Connection dbConnection = null;
            Statement sqlStatement = null;
            ResultSet resultSet = null;
            try
            {
                dbConnection = IO.getDBConnection();
                sqlStatement = dbConnection.createStatement();
                /* POTENTIAL FLAW: data concatenated into SQL statement used in executeQuery(), which could result in SQL Injection */
                resultSet = sqlStatement.executeQuery("select * from users where name='"+data+"'");
                IO.writeLine(resultSet.getRow()); /* Use ResultSet in some way */
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
            }
            finally
            {
                try
                {
                    if (resultSet != null)
                    {
                        resultSet.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing ResultSet", exceptSql);
                }

                try
                {
                    if (sqlStatement != null)
                    {
                        sqlStatement.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing Statement", exceptSql);
                }

                try
                {
                    if (dbConnection != null)
                    {
                        dbConnection.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
                }
            }
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second IO.staticFive==5 to IO.staticFive!=5 */
    private void goodB2G1() throws Throwable
    {
        String data;
        if (IO.staticFive==5)
        {
            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            data = System.getProperty("user.home");
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.staticFive!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            Connection dbConnection = null;
            PreparedStatement sqlStatement = null;
            ResultSet resultSet = null;

            try
            {
                /* FIX: Use prepared statement and executeQuery (properly) */
                dbConnection = IO.getDBConnection();
                sqlStatement = dbConnection.prepareStatement("select * from users where name=?");
                sqlStatement.setString(1, data);

                resultSet = sqlStatement.executeQuery();

                IO.writeLine(resultSet.getRow()); /* Use ResultSet in some way */
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
            }
            finally
            {
                try
                {
                    if (resultSet != null)
                    {
                        resultSet.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing ResultSet", exceptSql);
                }

                try
                {
                    if (sqlStatement != null)
                    {
                        sqlStatement.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing PreparedStatement", exceptSql);
                }

                try
                {
                    if (dbConnection != null)
                    {
                        dbConnection.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
                }
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        if (IO.staticFive==5)
        {
            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            data = System.getProperty("user.home");
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (IO.staticFive==5)
        {
            Connection dbConnection = null;
            PreparedStatement sqlStatement = null;
            ResultSet resultSet = null;
            try
            {
                /* FIX: Use prepared statement and executeQuery (properly) */
                dbConnection = IO.getDBConnection();
                sqlStatement = dbConnection.prepareStatement("select * from users where name=?");
                sqlStatement.setString(1, data);
                resultSet = sqlStatement.executeQuery();
                IO.writeLine(resultSet.getRow()); /* Use ResultSet in some way */
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
            }
            finally
            {
                try
                {
                    if (resultSet != null)
                    {
                        resultSet.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing ResultSet", exceptSql);
                }

                try
                {
                    if (sqlStatement != null)
                    {
                        sqlStatement.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing PreparedStatement", exceptSql);
                }

                try
                {
                    if (dbConnection != null)
                    {
                        dbConnection.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
                }
            }
        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
