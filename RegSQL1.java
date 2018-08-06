import java.util.regex.*;
import java.io.*;

// We're going to use the same pattern as RegSQL except
//   we now have to load the sql file from the command
//   line and replace every occurance of 'number.number'
//   with number.number and then write that to a new 
//   sql file.  Perhaps, we could just automatically add
//   a '1' to the input file name so that the new Books.sql
//   file is Books1.sql
//

public class RegSQL1 {
  public static void main(String[] args) {
  Pattern pattern = Pattern.compile("'[0-9]*\\.[0-9]*'");

  String inputFileName = new String(args[0]);
  String outputFileName = inputFileName.split("\\.")[0] + "1." + "sql";
  
  int i = 0; //Simple variable for reading a file.
  StringBuffer sqlLine = new StringBuffer();
  try(FileInputStream inputFile = new FileInputStream(inputFileName);
	FileWriter outputFile = new FileWriter(outputFileName)) {
//    try(DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(outputFileName));
//          FileInputStream inputFile = new FileInputStream(inputFileName))
     do
     {   
        // Build our string before running the pattern match by reading 1 line at a time.	     
        do
	{
        i = inputFile.read();
	if (i == -1)
	  break;	
	sqlLine.append((char) i);
	
	} while (i != '\n');

        Matcher matcher = pattern.matcher(sqlLine);
//        dataOut.flush();
	if (matcher.find())
	{
          String substring1 = matcher.group();
          String substring2 = substring1.replaceAll("'","");	  
          String tempString = new String(sqlLine);
	  String tempString1 = tempString.replaceFirst("'[0-9]*\\.[0-9]*'",substring2);
	  System.out.print(tempString1);
          outputFile.write(tempString1);
	}
	else
	{
	  System.out.print(sqlLine);
          String tempString = new String(sqlLine);
      	  outputFile.write(tempString);
	}
        sqlLine = new StringBuffer("");	
     }  while (i != -1);
  }
  catch(IOException exc) {
     System.out.println("IO Error: " + exc);
  }
  }
}
