import java.util.Scanner; 
import java.util.HashMap;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.*;
 import java.lang.Object;
       import java.util.StringTokenizer;
import java.util.HashMap;
 
public class crftraininput {
 
    public static void main(String args[])throws ArrayIndexOutOfBoundsException,FileNotFoundException,IOException
    {
    HashMap<String, String> hm = new HashMap<String, String>();
    String REGEX = "\\w+\\W[J][J]|\\w+\\W[V][B][G]|\\w+\\W[V][B][D]|\\w+\\W[V][B][N]";
//String REGEX = "\\w+\\W[J][J]";
//String REGEX = "[:][-][P]|[:][-][o]|[:][-][)]|[:][-][(]";
	//String REGEX1="\\w+\\W[V][B][D]";
    //private static final String INPUT =
                                    //"cat cat cat cattie cat";
//BufferedReader reader = null;
String result;
//reader = new BufferedReader(new FileReader("posdoc4.txt"));
//BufferedWriter bw=new BufferedWriter(new FileWriter("train4.txt"));

Scanner in=new Scanner(System.in);
System.out.println("Enter the input file");
String input=in.nextLine();
//String input="emotionpos.txt";

System.out.println("Enter the output file");
String output=in.nextLine();
//String output="emotionfeature.txt";

BufferedReader reader = new BufferedReader(new FileReader(input));
File file = new File(output);
FileOutputStream fis = new FileOutputStream(file);
PrintStream out = new PrintStream(fis);
System.setOut(out);


String line = reader.readLine();

while( line != null)
{
StringTokenizer tokens = new StringTokenizer(line);
while(tokens.hasMoreTokens())
{

String word = tokens.nextToken();

if(word.equals("post/NN")||word.equals("post/VB"))
	System.out.println("post NN");
Pattern p = Pattern.compile(REGEX);
       Matcher m = p.matcher(word);

       while(m.find())
       {
       
    	   
System.out.println(word.replace('/',' '));
	   
       }


}

//read next line
line = reader.readLine();
}}}

