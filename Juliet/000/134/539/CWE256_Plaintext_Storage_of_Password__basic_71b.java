/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE256_Plaintext_Storage_of_Password__basic_71b.java
Label Definition File: CWE256_Plaintext_Storage_of_Password__basic.label.xml
Template File: sources-sinks-71b.tmpl.java
*/
/*
 * @description
 * CWE: 256 Plaintext Storage of a Password.  Read the password from a Properties file or a regular file.  In the good case, read the file from the console.
 * BadSource:  Read password from a .properties file (from the property named password)
 * GoodSource: Read password from a .properties file (from the property named password) and then decrypt it
 * Sinks:
 *    GoodSink: Decrypt password and use decrypted password as password to connect to DB
 *    BadSink : Use password as password to connect to DB
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */







import java.util.logging.Level;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class CWE256_Plaintext_Storage_of_Password__basic_71b
{
    public void badSink(Object passwordObject ) throws Throwable
    {
        String password = (String)passwordObject;

        /* POTENTIAL FLAW: Use password as a password to connect to a DB  (without being decrypted) */

        Connection dBConnection = null;
        try
        {
            dBConnection = DriverManager.getConnection("192.168.105.23", "sa", password);
        }
        catch (SQLException exceptSql)
        {
            IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
        }
        finally
        {
            try
            {
                if (dBConnection != null)
                {
                    dBConnection.close();
                }
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
            }
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(Object passwordObject ) throws Throwable
    {
        String password = (String)passwordObject;

        /* POTENTIAL FLAW: Use password as a password to connect to a DB  (without being decrypted) */

        Connection dBConnection = null;
        try
        {
            dBConnection = DriverManager.getConnection("192.168.105.23", "sa", password);
        }
        catch (SQLException exceptSql)
        {
            IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
        }
        finally
        {
            try
            {
                if (dBConnection != null)
                {
                    dBConnection.close();
                }
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
            }
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(Object passwordObject ) throws Throwable
    {
        String password = (String)passwordObject;

        /* FIX: password is decrypted before being used as a database password */
        {
            Cipher aesCipher = Cipher.getInstance("AES");

            /* INCIDENTAL: Hardcoded crypto */
            SecretKeySpec secretKeySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
            aesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            String decryptedPassword = new String(aesCipher.doFinal(password.getBytes("UTF-8")), "UTF-8");
            password = decryptedPassword;
        }

        Connection dBConnection = null;
        try
        {
            dBConnection = DriverManager.getConnection("192.168.105.23", "sa", password);
        }
        catch (SQLException exceptSql)
        {
            IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
        }
        finally
        {
            try
            {
                if (dBConnection != null)
                {
                    dBConnection.close();
                }
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
            }
        }

    }
}
