package proteinbuilder.io;

import java.util.Iterator;
import proteinbuilder.AminoAcid;
import proteinbuilder.Protein;

public final class JSONProteinWriter extends ProteinWriter
{
   private static String PROTEIN = "{\"protein\":\"";
   private static String ACIDS = "\"acids\":[";
   private static String CLOSE = "]}";
   
   @Override
   protected String getString(Protein protein)
   {
      String out = PROTEIN + protein.getName() + "\"," + ACIDS;
      
      Iterator<AminoAcid> iterator = protein.iterator();
      while(iterator.hasNext())
      {
         out = (out + "\"" + iterator.next().toString() + "\"");
         if(iterator.hasNext())
         {
            out = out + ",";
         }
      }
      out = out + CLOSE;
      return out;
   }
}