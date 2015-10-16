
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.util.Scanner;

class TaggerDemo {

  private TaggerDemo() {}

  public static void main(String[] args) throws Exception {
    /*if (args.length != 3) {
      System.err.println("usage: java TaggerDemo modelFile fileToTag");
      return;
    }*/
	  String input,output,st;
	  System.out.println("Enter the input file");
	  Scanner in=new Scanner(System.in);
	  input=in.nextLine();
	  //input="crawl.txt";
	  
	  System.out.println("Enter the output file");
	  in=new Scanner(System.in);
	  output=in.nextLine();
	  //output="emotionpos.txt";
	  
	  //System.out.println("Enter the tagger");
	  //in=new Scanner(System.in);
	  //tagger1=in.nextLine();
	  String tagger1="models\\english-bidirectional-distsim.tagger";
	  
	  File file = new File(output);
	  FileOutputStream fis = new FileOutputStream(file);
	  PrintStream out = new PrintStream(fis);
	  System.setOut(out);
BufferedWriter bw=new BufferedWriter(new FileWriter(output));
    MaxentTagger tagger = new MaxentTagger(tagger1);
    List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new FileReader(input)));
    for (List<HasWord> sentence : sentences) {
      ArrayList<TaggedWord> tSentence = tagger.tagSentence(sentence);
      st=Sentence.listToString(tSentence, false);
      //bw.append(st);
      System.out.println(st);
    }
  }

}
