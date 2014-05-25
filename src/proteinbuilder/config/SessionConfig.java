package proteinbuilder.config;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.RuntimeException;
import java.net.URI;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Scanner;

import proteinbuilder.ProteinList;
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
   public static final String DELIMITER = ":";
   
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
   private static final String PROTEIN_LIST = "proteins";
   
   
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
         createProteinList();
         storeProperties();
      }
      FORMAT = properties.getProperty(FORMAT_KEY);
      PROTEIN_LIST_URI = loadProteinList();
      loaded = true;
      
   }
   
   /*
   * Sets the default format for data storage
   */
   private void setFormat()
   {
      properties.setProperty(FORMAT_KEY, JSON);
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
   * Creates a file to store the list of proteins
   */
   private void createProteinList()
   {
      File f = new File(PROTEIN_FILE_DIRECTORY + PROTEIN_LIST);
      try
      {
         f.createNewFile();
      }
      catch(IOException ioe)
      {
         throw new RuntimeException("Error creating protein list.");
      }
   }
   
   private URI loadProteinList()
   {
      File f = new File(PROTEIN_FILE_DIRECTORY + PROTEIN_LIST);
      return f.toURI();
   }
   
   /*
   * Read all files in proteins directory, create a protein
   * from each and add it to the PROTEIN_SET
   */
   public ProteinList getProteinsFromFiles()
   {
      ProteinList proteinList = new ProteinList();
      File proteins = new File(PROTEIN_LIST_URI);
      File nextProtein;
      String nextProteinFile;
      Scanner proteinsIn;
      boolean all = false;
      try
      {
         proteinsIn = new Scanner(proteins);
         proteinsIn.useDelimiter(DELIMITER);
         while(proteinsIn.hasNext())
         {
            nextProteinFile = proteinsIn.next();
            nextProtein = new File(PROTEIN_FILE_DIRECTORY + nextProteinFile);
            proteinList.add(ProteinReaderFactory.getReader(nextProtein).getProteinFromFile(nextProtein));
         }
         proteinsIn.close();
      }
      catch(IOException ioe)
      {
         throw new RuntimeException("Error loading proteins from files.");
      }
      return proteinList;
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
            throw new RuntimeException("Error storing properties to file.");
         }
      }
      catch(FileNotFoundException fnfe)
      {
         throw new RuntimeException("Error storing properties to file.");
      }
   }
}