package MainPgm;

import java.io.*;
import java.util.Scanner;
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
public class DbEntry2
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
            BufferedWriter output;
            
            /**
             * Create and select a database for use. 
             */
            /*stt.execute("CREATE DATABASE IF NOT EXISTS fyp");*/
            stt.execute("USE fyp");
            
            /**
             * Create an example table
             */
            //stt.execute("DROP TABLE IF EXISTS people");
            /*stt.execute("CREATE TABLE IF NOT EXISTS questiontrainer (" +
                    "question VARCHAR(200),"
                    +"answer VARCHAR(5)"
                    + ")");*/
            
            /**
             * Add entries to the example table
             */
            String infile,outfile;
            Scanner in;
            try
            {
            	System.out.println("Enter the input file");
            	in=new Scanner(System.in);
            	infile=in.nextLine();
            	//infile="myoutput1.txt";
            	System.out.println("Enter the output file");
            	in=new Scanner(System.in);
            	outfile=in.nextLine();
            	//outfile="sarcasmoutput.txt";
            	br = new BufferedReader(new FileReader(infile));
            	output=new BufferedWriter(new FileWriter(outfile));
            	File file = new File(outfile);
          	  FileOutputStream fis = new FileOutputStream(file);
          	  PrintStream out = new PrintStream(fis);
          	  System.setOut(out);
            	int yesct=0,noct=0;
        		while((st=br.readLine())!=null)
        		{
        			question=st;
        		/*System.out.println(question+"\nEnter the answer for training");
        		Scanner in = new Scanner(System.in);
        		ans=in.nextLine();
            	stt.execute("INSERT INTO questiontrainer (question, answer) VALUES" + 
                    "('"+question+"', '"+ans+"')");*/
        			if(question.equals("post NN P"))
        			{
        				if(noct>0)
        					System.out.println("yes sar");
        				else
        					System.out.println("no sar");
        				//System.out.println("post");
        				yesct=0;
        				noct=0;
        				continue;
        			}
        			ResultSet res = stt.executeQuery("SELECT * FROM questiontrainer WHERE question = '"+question+"'");
        			while (res.next())
                    {
                        ans=res.getString("answer");
                        if(ans.equals("yes"))
                        	yesct++;
                        if(ans.equals("no"))
                        	noct++;
                    }
        			//System.out.println("yes="+yesct+" no="+noct);
        			
        			/*
        			if(yesct==0&&noct==0)
        				output.write("no");
        				
        				*/
        		}
        		br.close();
        		
        		
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }
            //System.out.println("Training done");
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