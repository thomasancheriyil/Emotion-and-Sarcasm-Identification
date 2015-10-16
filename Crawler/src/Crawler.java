
import java.awt.Desktop;
import java.util.Scanner;
import java.net.MalformedURLException;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Crawler {
    public static void main(String args[]) throws FileNotFoundException, IOException {
    	Scanner in1 = new Scanner(System.in);
    	System.out.println("Enter the URL to be crawled");
    	//String url = "http://www.quora.com/Do-arranged-marriages-in-India-really-work";
    	String url = in1.nextLine();
              //String url="http://www.quora.com/I-feel-slightly-ashamed-of-the-fact-that-my-partner-is-not-as-good-looking-as-I-am-How-do-I-overcome-this-feeling";
              //String url = "https://twitter.com/hashtag/Arrow";
              System.out.println(url);
              //openWebpage(url);
              Document doc = (Document) Jsoup.connect(url).get();
              String outfile;
              String st=doc.toString();
              int flag1=0,flag2=0,i=0;
              int first[]=new int[50];
              int last[]=new int[50];
              int count=0;
              String temp="";
              String check,check1;
              System.out.println("Enter the output file name");
              Scanner in=new Scanner(System.in);
              outfile=in.nextLine();

              String line = st;
   
              boolean bt=true;
String text = st;
String word = "<div class=\"answer_content\"";
String post;

//System.out.println(text.indexOf(word)); // prints "4"
//System.out.println(text.lastIndexOf(word)); // prints "22"

// find all occurrences forward
for ( i = -1; (i = text.indexOf(word, i + 1)) != -1; ) {
    first[count++]=i;
    //System.out.println(i);
    
} // prints "4", "13", "22"
count=0;

word="<div class=\"ContentFooter AnswerFooter\">";
for ( i = -1; (i = text.indexOf(word, i + 1)) != -1; ) {
    last[count++]=i;
    //System.out.println(i);
    
} 
       int start=0;       
       post="";
for(i=0;i<count;i++)
{
    start=first[i];
    //post+="Post no:"+(i+1)+"\n";
    if(i>0)
        post+="post"+"\n";
    while(start<last[i])
    {
        if(st.charAt(start)=='<')
            bt=false;
        if(st.charAt(start-1)=='>')
            bt=true;
        
        
        if(bt==true)
            post+=st.charAt(start);
        start++;
    }
}
post+="post"+"\n";
System.out.println(post);





File file = new File(outfile);
FileOutputStream fis = new FileOutputStream(file);
PrintStream out = new PrintStream(fis);
System.setOut(out);
System.out.println(post);
//bw.write(post);

        }
   
    public static void openWebpage(URI uri) {
    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
        try {
            desktop.browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public static void openWebpage(String s) throws MalformedURLException {
    try {
        URL url = new URL(s);
        openWebpage(url.toURI());
    } catch (URISyntaxException e) {
        e.printStackTrace();
    }
}
};
