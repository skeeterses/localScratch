import java.util.regex.*;
import java.io.*;

public class RegSQL {
  public static void main(String[] args) {
   String exampleString = new String("INSERT 'SCOTT' 'STINSON' '10.00' 'Lodi'");
// We want to replace '10.00' with 10.00
   Pattern pattern = Pattern.compile("'[0-9]*\\.[0-9]*'");
   Matcher matcher = pattern.matcher(exampleString);

   while (matcher.find()) {
//    System.out.println(matcher.group());
     String substring1 = matcher.group();
     String substring2 = substring1.replaceAll("'","");
//     System.out.println(substring2);
   
    String exampleString1 = exampleString.replaceFirst("'[0-9]*\\.[0-9]*'",substring2);
    System.out.println(exampleString1);

   }  

  }
}
