import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;


public class SarOutputCombi {
	public static void main(String args[])
	{
		String st1,st2,infile1,infile2,outfile;
		int h1=0,s1=0,d1=0,su1=0,f1=0,a1=0,h2=0,s2=0,d2=0,su2=0,f2=0,a2=0;
		int sar=0;
		Scanner in;
		try
		{
			
			System.out.println("Enter the first input file");
			in=new Scanner(System.in);
			infile1=in.nextLine();
			//infile1="emotionoutput.txt";
			System.out.println("Enter the second input file");
			in=new Scanner(System.in);
			infile2=in.nextLine();
			
			System.out.println("Enter the output file");
			in=new Scanner(System.in);
			outfile=in.nextLine();
			
			BufferedReader br1 = new BufferedReader(new FileReader(infile1));
			BufferedReader br2 = new BufferedReader(new FileReader(infile2));
			
			File file = new File(outfile);
			  FileOutputStream fis = new FileOutputStream(file);
			  PrintStream out = new PrintStream(fis);
			  System.setOut(out);
			  st1=br1.readLine();
			  st2=br2.readLine();
			while(st1!=null && st2!=null)
			{
				if(st1.equals("yes sar")||st2.equals("yes sar"))
					System.out.println("yes sar");
				
				else
					System.out.println("no sar");
				
				st1=br1.readLine();
				st2=br2.readLine();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
