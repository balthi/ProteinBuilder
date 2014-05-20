package proteinbuilder.config;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

import proteinbuilder.ProteinSet;
import proteinbuilder.io.ProteinReader;
import proteinbuilder.io.ProteinReaderFactory;

public class SessionConfig
{
   //Global Properties
   public static final String NL = System.getProperty("line.separator");
   public static final String JSON = "json";
   public static final String XML = "xml";
   public static final String PLAIN = "txt";
   public static final String DNA_SEQ = "[acgtACGT]+";
   public static final String DNA_CHARS = "[acgtACGT]";
   
   //Session Properties
   public static String FORMAT;
   public static final String PROTEIN_FILE_DIRECTORY = "lib/proteins/";
   public static URI PROTEIN_LIST_URI;
   
   //Private variables
   private String CONFIG_FILE_DIRECTORY = "lib/config/";
   private String CONFIG_FILE_PATH = "lib/config/properties.xml";
   private Properties properties = new Properties();
   private String FORMAT_KEY = "format";
   private static final String PROTEIN_FILE_DIRECTORY_KEY = "directory";
   
   
   private static SessionConfig sc;
   private boolean loaded = false;
   
   private SessionConfig()
   {
      //Do nothing
   }
   
   public static SessionConfig getSessionConfig()
   {
      if(sc == null)
      {
         sc = new SessionConfig();
      }
      return sc;
   }
   
   /**
   * loads all configuration variables for this session
   */
   public void loadConfiguration()
   {
      if(loaded)
      {
         return;
      }
      try
      {
         InputStream is = new FileInputStream(new File(CONFIG_FILE_PATH));
         properties.loadFromXML(is);
      }
      catch(IOException ioe)
      {
         setFormat();
         createProteinDirectory();
         storeProperties();
      }
      FORMAT = properties.getProperty(FORMAT_KEY);
      loaded = true;
      
   }
   
   /*
   * Sets the default format for data storage
   */
   private void setFormat()
   {
      properties.setProperty(FORMAT_KEY, PLAIN);
   }
   
   /*
   * Creates a directory in \lib that holds
   * all protein files for the application
   */
   private void createProteinDirectory()
   {
      File f = new File(PROTEIN_FILE_DIRECTORY);
      f.mkdir();
      properties.setProperty(PROTEIN_FILE_DIRECTORY_KEY, PROTEIN_FILE_DIRECTORY);
   }
   
   /*
   * Read all files in proteins directory, create a protein
   * from each and add it to the PROTEIN_SET
   */
   public ProteinSet getProteinsFromFiles()
   {
      ProteinSet ps = new ProteinSet();
      ProteinReader pr;
      File f = new File(PROTEIN_FILE_DIRECTORY);
      File[] proteins = f.listFiles();
      for(int i=0; i < proteins.length; i++)
      {
         pr = ProteinReaderFactory.getReader(proteins[i]);
         ps.add(pr.getProteinFromFile(proteins[i]));
      }
      return ps;
   }
   
   /*
   * Store configuration variables to the config file
   */
   private void storeProperties()
   {
      File directory = new File(CONFIG_FILE_DIRECTORY);
      directory.mkdir();
      try
      {
         OutputStream os = new FileOutputStream(new File(CONFIG_FILE_PATH));
         try
         {
            properties.storeToXML(os, "System Properties Stored");
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
      }
      catch(FileNotFoundException fnfe)
      {
         fnfe.printStackTrace();
      }
   }
}