package proteinbuilder.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import proteinbuilder.Protein;
import proteinbuilder.AminoAcid;

public class PTProteinReader extends ProteinReader
{     
   @Override 
   public Protein getProteinFromFile(File f)
   {
      Protein protein = new Protein();
      try
      {
         Scanner in = new Scanner(f);
         in.useDelimiter(DELIMITER);
         protein.setName(in.next());
         while(in.hasNext())
         {
            protein.add(AminoAcid.getAminoAcidByName(in.next()));
         }  
      } 
      catch(FileNotFoundException fnfe)
      {
         fnfe.printStackTrace();
      }
      return protein;
   }
}