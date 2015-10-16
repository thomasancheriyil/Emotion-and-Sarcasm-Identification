import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;


public class EmotionClassi {
public static void main(String args[])
{
	try
	{
		
	
	Scanner in=new Scanner(System.in);
	String emofile,sarfile,outfile,crawlfile;
	System.out.println("Enter the crawler output file");
	in=new Scanner(System.in);
	crawlfile=in.nextLine();
	//crawlfile="crawl.txt";
	System.out.println("Enter the emotion output file");
	in=new Scanner(System.in);
	emofile=in.nextLine();
	//emofile="emotiondisambi.txt";
	System.out.println("Enter the sarcasm output file");
	in=new Scanner(System.in);
	sarfile=in.nextLine();
	//sarfile="sarcasmoutput.txt";
	System.out.println("Enter the output file name");
	in=new Scanner(System.in);
	outfile=in.nextLine();
	//outfile="finaloutput.txt";
	//
	String st="",output="",happysar="",sadsar="",fearsar="",surpsar="",angersar="",happynosar="",sadnosar="",fearnosar="",surpnosar="",angernosar="",dissar="",disnosar="";
	int haps=0,sads=0,fears=0,surps=0,angs=0,diss=0,hapns=0,sadns=0,angns=0,surpns=0,fearns=0,disns=0;
	  //
	BufferedReader brc = new BufferedReader(new FileReader(crawlfile));
	BufferedReader bre = new BufferedReader(new FileReader(emofile));
	BufferedReader brs = new BufferedReader(new FileReader(sarfile));
	String emo="",sar="";
	
	while((st=brc.readLine())!=null)
	{
		//System.out.println(st);
		if(st.contains("post"))
		{
			//System.out.println("outside");
			//
			
			emo=bre.readLine();
			sar=brs.readLine();
			if(emo.equals("happy")&&sar.equals("yes sar"))
			{
				haps++;
				happysar+="\n\n post:"+haps+"\n\n"+output;
				output="";
				System.out.println("Happy sarcastic: "+happysar);
			}
			else if(emo.equals("happy")&&sar.equals("no sar"))
			{
				hapns++;
				happynosar+="\n\n post:"+hapns+"\n\n"+output;
				output="";
				System.out.println("Happy non sarcastic: "+happynosar);
				
			}
			else if(emo.equals("sad")&&sar.equals("yes sar"))
			{
				sads++;
				sadsar+="\n\n post:"+sads+"\n\n"+output;
				output="";
				System.out.println("Sad sarcastic: "+sadsar);
			}
			else if(emo.equals("sad")&&sar.equals("no sar"))
			{
				sadns++;
				sadnosar+="\n\n post:"+sadns+"\n\n"+output;
				output="";
				System.out.println("Sad non sarcastic: "+sadnosar);
			}
			else if(emo.equals("fear")&&sar.equals("yes sar"))
			{
				fears++;
				fearsar+="\n\n post:"+fears+"\n\n"+output;
				output="";
				System.out.println("Fear sarcastic: "+fearsar);
			}
			else if(emo.equals("fear")&&sar.equals("no sar"))
			{
				fearns++;
				fearnosar+="\n\n post:"+fearns+"\n\n"+output;
				output="";
				System.out.println("Fear non sarcastic: "+fearnosar);
			}
			else if(emo.equals("anger")&&sar.equals("yes sar"))
			{
				angs++;
				angersar+="\n\n post:"+angs+"\n\n"+output;
				output="";
				System.out.println("Anger sarcastic: "+angersar);
			}
			else if(emo.equals("anger")&&sar.equals("no sar"))
			{
				angns++;
				angernosar+="\n\n post:"+angns+"\n\n"+output;
				output="";
				System.out.println("Anger non sarcastic: "+angernosar);
			}
			else if(emo.equals("surprise")&&sar.equals("yes sar"))
			{
				surps++;
				surpsar+="\n\n post:"+surps+"\n\n"+output;
				output="";
				System.out.println("Surprise sarcastic: "+surpsar);
			}
			else if(emo.equals("surprise")&&sar.equals("no sar"))
			{
				surpns++;
				surpnosar+="\n\n post:"+surpns+"\n\n"+output;
				output="";
				System.out.println("Surprise non sarcastic: "+surpnosar);
			}
			else if(emo.equals("disgust")&&sar.equals("yes sar"))
			{
				diss++;
				dissar+="\n\n post:"+diss+"\n\n"+output;
				output="";
				System.out.println("Disgust sarcastic: "+dissar);
			}
			else if(emo.equals("disgust")&&sar.equals("no sar"))
			{
				disns++;
				disnosar+="\n\n post:"+disns+"\n\n"+output;
				output="";
				System.out.println("Disgust non sarcastic: "+disnosar);
			}
			//output+="\nemotion:"+bre.readLine()+"\nsarcasm:"+brs.readLine()+"\n";
		}
		else
		{
			//System.out.println("inside");
			output+=st;
		}
	}
	File file = new File(outfile);
	  FileOutputStream fis = new FileOutputStream(file);
	  PrintStream out = new PrintStream(fis);
	  System.setOut(out);
	  if(haps>0)
	  {
		  
		  System.out.println("Happy Sarcastic:\n"+happysar);
	  }
	  if(hapns>0)
	  {
		  
		  System.out.println("Happy non-sarcastic:\n"+happynosar);
	  }
	  if(sads>0)
	  {
		  
		  System.out.println("Sad Sarcastic:\n"+sadsar);
	  }
	  if(sadns>0)
	  {
		  
		  System.out.println("Sad non-sarcastic:\n"+sadnosar);
	  }
	  if(fears>0)
	  {
		  
		  System.out.println("Fear Sarcastic:\n"+fearsar);
	  }
	  if(fearns>0)
	  {
		  
		  System.out.println("Fear non-sarcastic:\n"+fearnosar);
	  }
	  if(angs>0)
	  {
		  
		  System.out.println("Anger Sarcastic:\n"+angersar);
	  }
	  if(angns>0)
	  {
		  
		  System.out.println("Anger non-sarcastic:\n"+angernosar);
	  }
	  if(surps>0)
	  {
		  
		  System.out.println("Surprise Sarcastic:\n"+surpsar);
	  }
	  if(surpns>0)
	  {
		  
		  System.out.println("Surprise non-sarcastic:\n"+surpnosar);
	  }
	  if(diss>0)
	  {
		  
		  System.out.println("Disgust Sarcastic:\n"+dissar);
	  }
	  if(disns>0)
	  {
		  
		  System.out.println("Disgust non-sarcastic:\n"+disnosar);
	  }
	  
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
