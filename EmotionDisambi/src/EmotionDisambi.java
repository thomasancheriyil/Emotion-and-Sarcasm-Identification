import java.io.*;
import java.util.Scanner;
public class EmotionDisambi 
{
	public static void main(String args[])
	{
		String st,infile,outfile;
		int h=0,s=0,d=0,su=0,f=0,a=0;
		Scanner in;
		try
		{
			
			System.out.println("Enter the input file");
			in=new Scanner(System.in);
			infile=in.nextLine();
			//infile="emotionoutput.txt";
			System.out.println("Enter the output file");
			in=new Scanner(System.in);
			outfile=in.nextLine();
			//outfile="emotiondisambi.txt";
			BufferedReader br = new BufferedReader(new FileReader(infile));
			File file = new File(outfile);
			  FileOutputStream fis = new FileOutputStream(file);
			  PrintStream out = new PrintStream(fis);
			  System.setOut(out);
			while((st=br.readLine())!=null)
			{
				if(st.endsWith("H"))
					h++;
				else if(st.endsWith("S"))
					s++;
				else if(st.endsWith("D"))
					d++;
				else if(st.endsWith("SU"))
					su++;
				else if(st.endsWith("F"))
					f++;
				else if(st.endsWith("A"))
					a++;
				if(st.contains("NN\tP"))
				{
					if(h>s && h>d && h>su && h>f && h>a)
						System.out.println("happy");
					else if(s>h && s>d && s>su && s>f && s>a)
						System.out.println("sad");
					else if(d>h && d>s && d>su && d>f && d>a)
						System.out.println("disgust");
					else if(su>h && su>s && su>d && su>f && su>a)
						System.out.println("surprise");
					else if(a>h && a>s && a>d && a>f && a>su)
						System.out.println("anger");
					else if(f>h && f>s && f>d && f>a && f>su)
						System.out.println("fear");
					else
						System.out.println("neutral");
					
					h=0;s=0;d=0;su=0;f=0;a=0;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
