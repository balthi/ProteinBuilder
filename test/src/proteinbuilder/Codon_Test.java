package proteinbuilder;

import junit.framework.TestCase;

public class Codon_Test extends TestCase
{
   public static final String GLY="GLYCINE";
   public static final String CODON = "GGC";
   public static Codon GGC = Codon.GGC;
   
   public void testGetAminoAcid()
   {
      assertEquals("Wrong amino acid returned in testGetAminoAcid", AminoAcid.GLYCINE, GGC.getAminoAcid());
   }
   
   public void testGetName()
   {
      assertEquals("Wrong String returned in testGetName", CODON, GGC.getName());
   }
   
   public void testParseCodon()
   {
      assertEquals("Wrong Codon returned in testParseCodon", GGC, Codon.parseCodon(CODON));
   }
   
   public void testToString()
   {
      assertEquals("Wrong String returned in testToString", CODON, GGC.toString());
   }  
}