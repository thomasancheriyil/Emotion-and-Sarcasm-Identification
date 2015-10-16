import java.io.*;
import java.util.*;
public class SarcasmSeperation
{
public static void main(String args[])throws ArrayIndexOutOfBoundsException,FileNotFoundException,IOException
{
//BufferedReader reader = new BufferedReader(new FileReader("sarcasm1input.txt"));
//BufferedWriter bw1=new BufferedWriter(new FileWriter("sarcasm1split1.txt"));
//BufferedWriter bw2=new BufferedWriter(new FileWriter("sarcasm1split2.txt"));
Scanner in=new Scanner(System.in);
System.out.println("Enter the input file");
String infile=in.nextLine();

System.out.println("Enter the first output file");
String outfile1=in.nextLine();
System.out.println("Enter the second output file");
String outfile2=in.nextLine();

BufferedReader reader = new BufferedReader(new FileReader(infile));
/*File file1 = new File(output1);
FileOutputStream fis1 = new FileOutputStream(file1);
PrintStream out1 = new PrintStream(fis1);
System.setOut(out1);
*/
String line = reader.readLine();
String first="";
String second="";
String first1="",second1="";
String word;
int flag=0;
while( line != null)
{
StringTokenizer tokens = new StringTokenizer(line);
first1="";second1="";
while(tokens.hasMoreTokens())
{
word = tokens.nextToken();
if(word.equals("post"))
{
	first+="\n"+"post\n";
	second+="\n"+"post\n";
}
//System.out.println("word:"+word);
//System.out.println(word);
//if((!word.equals("and")||(!word.equals(",")))&&(flag==0))
if(flag==0)
{
	
first1+=word+" ";
 
}
if(word.equals("and")||word.equals(","))
{
flag=1;
continue;
}
if(flag==1)
{

second1+=word+" ";
}
if((word.endsWith(".")||word.endsWith("!"))&&flag==0)
{
	first1="";second1="";
}
if((word.endsWith(".")||word.endsWith("!"))&&flag==1)
{
	System.out.println("word:"+word);
	flag=0;
first+=first1;
	
	second+=second1;
	first1="";second1="";
}
}
/*if(flag==1)
{
	first+=first1;
	
	second+=second1;
	}
	
//bw1.write(first);
/*File file2 = new File(output2);
FileOutputStream fis2 = new FileOutputStream(file2);
PrintStream out2 = new PrintStream(fis2);
System.setOut(out2);*/
	//System.out.println("post");
	

//bw2.write(second);
line = reader.readLine();
flag=0;
first1="";second1="";
}
File file1 = new File(outfile1);
FileOutputStream fis1 = new FileOutputStream(file1);
PrintStream out1 = new PrintStream(fis1);
System.setOut(out1);

System.out.println(first);

File file2 = new File(outfile2);
FileOutputStream fis2 = new FileOutputStream(file2);
PrintStream out2 = new PrintStream(fis2);
System.setOut(out2);
System.out.println(second);
//bw1.close();
//bw2.close();
}
}