package proteinbuilder;

import javax.swing.event.ListDataListener;
import javax.swing.event.ListDataEvent;
import javax.swing.ListModel;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Iterator;
import java.lang.Iterable;

/**
* Maintains a list of proteins. Does not allow duplicate entries
*/
public class ProteinList implements Iterable<Protein>
{
   public ProteinList()
   {
      list = new Vector();
      listeners = new LinkedList();
   }
   
   private Vector<Protein> list;
   private LinkedList<ListDataListener> listeners;
   
   /**
   * Returns true if the protein was successfully
   * added to the set.
   */
   public boolean add(Protein protein)
   {
      if(list.contains(protein))
      {  
         System.err.println("Protein " + protein.toString() + " already in list.");
         return false;
      }
      for(ListDataListener listener : listeners)
      {
         listener.intervalAdded(new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, list.size(), list.size()+1));
      }
      return list.add(protein);
   }
   
   /**
   * Returns true if tbe set contains protein
   */
   public boolean contains(Protein protein)
   {
      return list.contains(protein);
   }
   
   /**
   * Returns an iterator for this protein set
   */
   public Iterator<Protein> iterator()
   {
      return list.iterator();
   }
   
   /**
   * Returns true if the protein was removed
   * from the set
   */
   public boolean remove(Protein protein)
   {
      if(!list.contains(protein))
      {
         return false;
      }
      for(ListDataListener listener : listeners)
      {
         listener.intervalRemoved(new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, list.indexOf(protein)-1, list.indexOf(protein)));
      }
      return list.remove(protein);
   }
   
   /**
   * Returns the number of elements in this set
   */
   public int size()
   {
      return list.size();
   }
}