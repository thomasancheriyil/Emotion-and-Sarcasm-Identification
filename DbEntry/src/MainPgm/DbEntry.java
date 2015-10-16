package MainPgm;

import java.io.*;
/**
 * Imports all entries from the java.sql library. 
 * Improve on this by only importing needed classes. 
 * E.g.:
 * import java.sql.Connection
 * import java.sql.Statement
 * ...
 */
import java.sql.*;
import java.util.Scanner;
public class DbEntry
{
    public static void main(String[] args)
    {
        
        /**
         * 3306 is the default port for MySQL in XAMPP. Note both the 
         * MySQL server and Apache must be running. 
         */
        String url = "jdbc:mysql://localhost:3306/";
        
        /**
         * The MySQL user.
         */
        String user = "root";
        
        /**
         * Password for the above MySQL user. If no password has been 
         * set (as is the default for the root user in XAMPP's MySQL),
         * an empty string can be used.
         */
        String password = "";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            
            Statement stt = con.createStatement();
            String st,question,ans;
            BufferedReader br;
            
            /**
             * Create and select a database for use. 
             */
            stt.execute("CREATE DATABASE IF NOT EXISTS fyp");
            stt.execute("USE fyp");
            
            /**
             * Create an example table
             */
            //stt.execute("DROP TABLE IF EXISTS people");
            stt.execute("CREATE TABLE IF NOT EXISTS questiontrainer (" +
                    "question VARCHAR(200),"
                    +"answer VARCHAR(5)"
                    + ")");
            
            /**
             * Add entries to the example table
             */
            try
            {
            	br = new BufferedReader(new FileReader("myoutput1.txt"));
        		while((st=br.readLine())!=null)
        		{
        			question=st;
        			if(question.equals("post/NN"))
        				continue;
        		System.out.println(question+"\nEnter the answer for training");
        		Scanner in = new Scanner(System.in);
        		ans=in.nextLine();
            	stt.execute("INSERT INTO questiontrainer (question, answer) VALUES" + 
                    "('"+question+"', '"+ans+"')");
        		}
        		br.close();
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }
            System.out.println("Training done");
            /**
             * Query people entries with the lname 'Bloggs'
             */
        		
            
            /*
            
            ResultSet res = stt.executeQuery("SELECT * FROM people WHERE lname = 'Bloggs'");
            
            /**
             * Iterate over the result set from the above query
             */
            
            
            /*
            
            while (res.next())
            {
                System.out.println(res.getString("fname") + " " + res.getString("lname"));
            }
            System.out.println("");
            
            /**
             * Same as the last query, but using a prepared statement. 
             * Prepared statements should be used when building query strings
             * from user input as they protect against SQL injections
             */
            
            
            
            /*
            PreparedStatement prep = con.prepareStatement("SELECT * FROM people WHERE lname = ?");
            prep.setString(1, "Bloggs");
            
            res = prep.executeQuery();
            while (res.next())
            {
                System.out.println(res.getString("fname") + " " + res.getString("lname"));
            }
            
            /**
             * Free all opened resources
             */
            
            
            /*
            res.close();
            stt.close();
            prep.close();
            con.close();
            
            
            */
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}