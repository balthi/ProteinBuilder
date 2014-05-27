package proteinbuilder;

import java.util.List;
import java.util.LinkedList;
import junit.framework.TestCase;

public final class DNASequence_Test extends TestCase
{
   private static final String NORMAL = "AACCGGTTA";
   private static final String ABNORMAL = "AACCGTGCAT";
   private static final int DNA_1_SIZE = 3;
   private DNASequence dna1, dna2;
   private static AminoAcid ASP = AminoAcid.ASPARAGINE;
   private static AminoAcid ARG = AminoAcid.ARGININE;
   private static AminoAcid LEU = AminoAcid.LEUCINE;
   
   public void setUp()
   {
      dna1 = new DNASequence(NORMAL);
      dna2 = new DNASequence(ABNORMAL);
   }
   
   public void testGetCodonSequenceNormal()
   {
      List<Codon> list = dna1.getCodonSequence();
      assertTrue("AAC not found in testGetCodonSequenceNormal", list.contains(Codon.AAC));
      assertTrue("CGG not found in testGetCodonSequenceNormal", list.contains(Codon.CGG));
      assertTrue("TTA not found in testGetCodonSequenceNormal", list.contains(Codon.TTA));
   }
   
   public void testGetCodonSequenceAbnormal()
   {
      List<Codon> list = dna2.getCodonSequence();
      assertTrue("AAC not found in testGetCodonSequenceNormal", list.contains(Codon.AAC));
      assertTrue("CGT not found in testGetCodonSequenceNormal", list.contains(Codon.CGT));
      assertTrue("GCA not found in testGetCodonSequenceNormal", list.contains(Codon.GCA));
   }
   
   public void testGetAminoAcids()
   {
      LinkedList<AminoAcid> list = dna1.getAminoAcids();
      assertTrue("ASPARAGINE not found in testGetAminoAcids", list.contains(ASP));
      assertTrue("ARGININE not found in testGetAminoAcids", list.contains(ARG));
      assertTrue("LEUCINE not found in testGetAminoAcids", list.contains(LEU));
   }
   
   public void testGetProtein()
   {
      Protein protein = dna1.getProtein();
      for(AminoAcid aa : protein)
      {
         System.err.println(aa.toString());
      }
      assertTrue("ASPARAGINE not found in testGetProtein", protein.contains(ASP));
      assertTrue("ARGININE not found in testGetProtein", protein.contains(ARG));
      assertTrue("LEUCINE not found in testGetProtein", protein.contains(LEU));
   }
}