package proteinbuilder.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import proteinbuilder.Protein;
import proteinbuilder.AminoAcid;

public class JSONProteinReader extends ProteinReader
{  
   private static final int NAME_QUOTE_INDEX = 10;
   
   @Override 
   public Protein getProteinFromFile(File f)
   {
      Protein protein = new Protein();
      try
      {
         BufferedReader br = new BufferedReader(new FileReader(f));
         String line = br.readLine();
         int start = line.indexOf(QUOTE, NAME_QUOTE_INDEX);
         int stop = line.indexOf(QUOTE, start+1);
         
         protein.setName(line.substring(start+1, stop));
         
         line = line.substring(stop+1);
         start = line.indexOf(QUOTE);
         stop = line.indexOf(QUOTE, start+1);
         
         while(line.length() > 0 && start != -1 && stop != -1)
         {
            if(!line.substring(start+1, stop).equals("acids"))
            {
               protein.add(AminoAcid.getAminoAcidByName(line.substring(start+1, stop)));
            }
            line = line.substring(stop+1);
            start = line.indexOf(QUOTE);
            stop = line.indexOf(QUOTE, start+1);
         }
         
      } 
      catch(FileNotFoundException fnfe)
      {
         fnfe.printStackTrace();
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
      return protein;
   }
}