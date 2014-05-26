package proteinbuilder.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import proteinbuilder.Protein;
import proteinbuilder.AminoAcid;

public final class PTProteinReader extends ProteinReader
{     
   @Override 
   public Protein getProteinFromFile(File f)
   {
      Protein protein = new Protein();
      Scanner in;
      try
      {
         in = new Scanner(f);
         in.useDelimiter(DELIMITER);
         protein.setName(in.next());
         while(in.hasNext())
         {
            protein.add(AminoAcid.getAminoAcidByName(in.next()));
         }
         in.close();  
      } 
      catch(FileNotFoundException fnfe)
      {
         throw new RuntimeException("Error reading protein from file.");
      }
      return protein;
   }
}