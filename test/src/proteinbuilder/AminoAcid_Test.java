package proteinbuilder;

import java.util.List;
import junit.framework.TestCase;

public class AminoAcid_Test extends TestCase
{
   public static final String GLY="GLYCINE";
   public static final int NUM_AMINO_ACIDS = 21;
   
   public void testGetName()
   {
      assertEquals("Names do not match in testGetName.", "GLYCINE", AminoAcid.GLYCINE.getName());
   }
   
   public void testGetAminoAcidByName()
   {
      assertEquals("AminoAcids do not match in testGetAminoAcidByName", AminoAcid.GLYCINE, AminoAcid.getAminoAcidByName(GLY));
   }
   
   public void testGetCodons()
   {
      List<Codon> list = AminoAcid.GLYCINE.getCodons();
      assertTrue("GGT missing in testGetCodons", list.contains(Codon.GGT));
      assertTrue("GGC missing in testGetCodons", list.contains(Codon.GGC));
      assertTrue("GGA missing in testGetCodons", list.contains(Codon.GGA));
      assertTrue("GGG missing in testGetCodons", list.contains(Codon.GGG));
      assertTrue("Extra codons found in testGetCodons", list.size() == 4);
   }
   
   public void testToString()
   {
      assertEquals("Wrong String returned in testToString", GLY, AminoAcid.GLYCINE.toString());
   }
   
   public void testGetAllAminoAcids()
   {
      List<AminoAcid> list = AminoAcid.getAllAminoAcids();
      assertEquals("Wrong number of amino acids returned in testGetAllAminoAcids", NUM_AMINO_ACIDS, list.size());
      assertTrue("GLYCINE missing in testGetAllAminoAcids", list.contains(AminoAcid.GLYCINE));
   }
}