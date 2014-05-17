package proteinbuilder.config;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SessionConfig
{
   //Global Properties
   public static final String NL = System.getProperty("line.separator");
   public static final String JSON = "json";
   public static final String XML = "xml";
   
   //Session Properties
   public static String FORMAT;
   
   //Private variables
   private String CONFIG_FILE_PATH = "lib/config/properties.xml";
   private Properties properties;
   private String FORMAT_KEY = "format";
   
   
   private static SessionConfig sc;
   
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
   
   public void loadConfiguration()
   {
      try
      {
         InputStream is = new FileInputStream(new File(CONFIG_FILE_PATH));
         properties.loadFromXML(is);
      }
      catch(IOException ioe)
      {
         setFormat();
      }
      FORMAT = properties.getProperty(FORMAT_KEY);
   }
   
   private void setFormat()
   {
      properties.setProperty(FORMAT_KEY, JSON);
   }
   
   private void storeProperties()
   {
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