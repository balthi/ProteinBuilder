package proteinbuilder.io;

import java.util.Iterator;
import proteinbuilder.Protein;
import proteinbuilder.AminoAcid;

public class PTProteinWriter extends ProteinWriter
{
   private static final String DELIMITER = ":";

   @Override
   protected String getString(Protein protein)
   {
      String out = protein.getName() + DELIMITER;
      for(AminoAcid aa : protein)
      {
         out = out + aa.toString() + DELIMITER;
      }
      return out;
   }
}