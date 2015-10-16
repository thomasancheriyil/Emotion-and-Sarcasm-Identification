package ui;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ui extends JPanel {
    
        
   public void paint(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setFont(new Font("Serif", Font.BOLD, 48));
      paintHorizontallyCenteredText(g2, "TRENDING TAB ",200, 50); 
      
                  System.out.println("Reading File with BufferedReader class");
                //String fileName="C:/Program Files/Java/jdk1.7.0_45/finaloutput.txt";
                String fileName="finaloutput.txt";
                  try{
                
                
                FileReader inputFile = new FileReader(fileName);
                
                BufferedReader bufferReader = new BufferedReader(inputFile);

         
                String line;
                int i=0;
                  while ((line = bufferReader.readLine()) != null)   {
                        System.out.println(line);
                        g2.setFont(new Font("Serif", Font.PLAIN, 20));
                     g2.drawString(line, 10, 150+i);
                     i+=15;
                        
                }
                
                bufferReader.close();
                }catch(Exception e){
                        System.out.println("Error in reading file:" + e.getMessage());                  
                }
        }
      
      
   protected void paintHorizontallyCenteredText(Graphics2D g2,
   String s, float centerX, float baselineY) {
      FontRenderContext frc = g2.getFontRenderContext();
      Rectangle2D bounds = g2.getFont().getStringBounds(s, frc);
      float width = (float) bounds.getWidth();
      g2.drawString(s, centerX , baselineY);
   }

public static void main(String[] args) {
      /*JFrame f = new JFrame();
      

         JScrollPane scrPane = new JScrollPane(f);
    f.getContentPane().add(scrPane);
      f.getContentPane().add(new Ui());
      f.setSize(750, 550);
      JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      f.setContentPane(pane);
      f.setVisible(true);*/
      
      JFrame frame = new JFrame();  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
  JTextArea textArea = new JTextArea(5,20);  
  
  JScrollPane scrollPane = new JScrollPane(textArea);  
  scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
  scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
  frame.getContentPane().add(scrollPane);  
   frame.getContentPane().add(new Ui());
  frame.setSize(300, 200);  
  frame.setVisible(true);
   }
}