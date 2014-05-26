package proteinbuilder.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.RuntimeException;
import proteinbuilder.Protein;
import proteinbuilder.AminoAcid;

public final class XMLProteinReader extends ProteinReader
{  
   @Override
   public Protein getProteinFromFile(File f)
   {
      Protein protein = new Protein();
      BufferedReader br;
      try
      {
         br = new BufferedReader(new FileReader(f));
         String line = null;
         try
         {
            while((line=br.readLine()) != null)
            {
               if(line.contains("/protein"))
               {
                  br.close();
                  break;
               }
               else if(line.contains("name"))
               {
                  int start = line.indexOf(QUOTE);
                  int stop = line.indexOf(QUOTE, start+1);
                  protein.setName(line.substring(start+1, stop));
               
               }
               else if(line.contains("acid"))
               {
                  int start = line.indexOf(QUOTE);
                  int stop = line.indexOf(QUOTE, start+1);
                  protein.add(AminoAcid.getAminoAcidByName(line.substring(start+1, stop)));
               }
            }
            //br.close();
         }
         catch(IOException ioe)
         {
            throw new RuntimeException("Error reading protein from file.");
         }
         finally
         {
            try
            {
               br.close();
            }
            catch(IOException i)
            {
               throw new RuntimeException("Error reading file.");
            }
         }
      }
      catch(FileNotFoundException fnfe)
      {
         throw new RuntimeException("Error reading protein from file. Could not find file.");
      }
      return protein;
   }
}