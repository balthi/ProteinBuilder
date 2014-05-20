package proteinbuilder;

import java.lang.Comparable;
import java.util.LinkedList;
import java.util.Iterator;
import proteinbuilder.io.ProteinWriter;
import proteinbuilder.io.ProteinWriterFactory;

public class Protein implements Comparable<Protein>, Iterable<AminoAcid>
{
   public Protein()
   {
      acids = new LinkedList();
   }
   
   public Protein(String name)
   {
      this.name = name;
      acids = new LinkedList();
   }
   
   private String name;
   private LinkedList<AminoAcid> acids;
   
   /**
   * Add an amino acid to this protein
   */
   public void add(AminoAcid aa)
   {
      acids.add(aa);
   }
   
   /**
   * Compares this protein to p
   */
   @Override
   public int compareTo(Protein p)
   {
      return name.compareTo(p.getName());
   }
   
   /**
   * Returns the name of this protein
   */
   public String getName()
   {
      return name;
   }
   
   @Override
   public int hashCode()
   {
      int prime = 7;
      int product = prime * name.hashCode();
      for(AminoAcid aa : this)
      {
         product *= prime*aa.hashCode();
      }
      return product;
   }
   
   @Override
   public boolean equals(Object o)
   {
      return this.hashCode() == o.hashCode();
   }
   
   /**
   * Returns an iterator for this protein
   */
   @Override
   public Iterator<AminoAcid> iterator()
   {
      return acids.iterator();
   }
   
   /**
   * Removes and returns the last amino acid from this protein
   */
   public AminoAcid pop()
   {
      return acids.removeLast();
   }
   
   /**
   * Sets the name of this protein
   */
   public void setName(String name)
   {
      this.name = name;
   }
   
   /**
   * Returns the number of amino acids in this protein
   */
   public int size()
   {
      return acids.size();
   }
   
   /**
   * writes this protein to a file
   */
   public void writeToFile()
   {
      ProteinWriter pw = ProteinWriterFactory.getProteinWriter();
      pw.writeToFile(this);
   }
   
}