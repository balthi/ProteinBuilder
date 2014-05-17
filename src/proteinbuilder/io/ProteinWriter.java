package proteinbuilder.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import proteinbuilder.AminoAcid;
import proteinbuilder.Protein;

public abstract class ProteinWriter
{
   private static final String FILE_PATH = "lib/proteins/";
   private static String EXTENSION;
   
   public void writeToFile(Protein protein)
   {
      String out = getString(protein);
      File f = new File(FILE_PATH + protein.getName() + EXTENSION);
      try
      {
         f.createNewFile();
         URI safe = f.toURI();
         writeFile(out, safe);
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
   }
   
   protected String getString(Protein protein)
   {
      String out = protein.getName() + ":";
      for(AminoAcid aa : protein)
      {
         out = out + aa.toString() + ":";
      }
      return out;
   }
   
   private void writeFile(String protein, URI file)
   {
      File f = new File(file);
      try
      {
         FileWriter fw = new FileWriter(f);
         fw.write(protein);
         fw.close();
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
   }
}