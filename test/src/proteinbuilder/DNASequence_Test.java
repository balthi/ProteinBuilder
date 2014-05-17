package proteinbuilder;

import java.util.List;
import junit.framework.TestCase;

public class DNASequence_Test extends TestCase
{
   private static final String NORMAL = "AACCGGTTA";
   private static final String ABNORMAL = "AACCGTGCAT";
   private DNASequence dna1, dna2;
   
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
}