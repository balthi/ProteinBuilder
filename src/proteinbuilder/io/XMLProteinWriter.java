package proteinbuilder.io;

import static proteinbuilder.config.SessionConfig.NL;
import proteinbuilder.AminoAcid;
import proteinbuilder.Protein;

public class XMLProteinWriter extends ProteinWriter
{
   private static String PROTEIN = "<protein>";
   private static String CLOSE_PROTEIN = "</protein>";
   private static String NAME = "<name Id=";
   private static String CLOSE = "/>";
   private static String ACID = "<acid Id=";
   
   @Override
   protected String getString(Protein protein)
   {
      String out = (PROTEIN + NL);
      out = (out + NAME + "\"" + protein.getName() + "\"" + CLOSE + NL);
      
      for(AminoAcid aa : protein)
      {
         out = (out + ACID + "\"" + aa.toString() + "\"" + CLOSE + NL);
      }
      
      out = out + CLOSE_PROTEIN;
      return out;
   }
}