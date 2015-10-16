import java.util.*;
import java.io.*;
public class QueryProcess
{
public static void main(String args[])throws ArrayIndexOutOfBoundsException,FileNotFoundException,IOException
{
//String input="CM verdict";
Scanner in=new Scanner(System.in);

System.out.println("Enter the input topic");
String inputtopic=in.nextLine();

System.out.println("Enter the input file");
String input=in.nextLine();
System.out.println("Enter the output file");
String output=in.nextLine();
BufferedReader reader = new BufferedReader(new FileReader(input));
File file = new File(output);
FileOutputStream fis = new FileOutputStream(file);
PrintStream out = new PrintStream(fis);
System.setOut(out);
int flag,length=0;
StringTokenizer intokens=new StringTokenizer(inputtopic);
while(intokens.hasMoreTokens())
{
String inword=intokens.nextToken();
length++;
}
String line = reader.readLine();

while( line != null)
{
flag=0;
StringTokenizer tokens = new StringTokenizer(line);
while(tokens.hasMoreTokens())
{

String word = tokens.nextToken();
StringTokenizer inputtokens=new StringTokenizer(inputtopic);
while(inputtokens.hasMoreTokens())
{
String inputword=inputtokens.nextToken();
//System.out.println("inputword is "+inputword+" the line word is "+word);
if(inputword.equals(word))
{

flag++;
}
}
}
if(flag==2)
System.out.println(line);
line = reader.readLine();
}
}
}

