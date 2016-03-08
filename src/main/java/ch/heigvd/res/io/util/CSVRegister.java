/**
 -----------------------------------------------------------------------------------
 Laboratoire : 01
 Fichier     : CSVRegister.java
 Auteur(s)   : Andrea Cotza
 Date        : 05.03.2016
 -----------------------------------------------------------------------------------
*/

package ch.heigvd.res.io.util;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class allow to generate a csv file and add data line by line on it.
 */
public class CSVRegister {

   private int colNum;
   private FileWriter writer;

   /**
    * Create the CSV file with the chosen columns names.
    */
   public CSVRegister(String fileName, String... titles) throws IOException {
      writer = new FileWriter(fileName);

      colNum = titles.length;
      addLine(titles);
   }

   /**
    * Add a line of data in the CSV file. The number of parameters must match the
    * nomber of columns header.
    */
   public void addLine(String... columns) throws IOException, IllegalArgumentException {
      if(columns.length == colNum) {
         boolean isFirst = true;
         for (String data : columns) {
            if (isFirst) {
               isFirst = false;
            } else {
               writer.append(",");
            }

            writer.append(data);
         }

         writer.append('\n');
      }
      else {
         throw new IllegalArgumentException("Not enought/Too many data field, expected: " + colNum);
      }
   }

   /**
    * flush the buffer inside the file and close the file
    */
   public void close() throws IOException{
      writer.flush();
      writer.close();
   }
}
