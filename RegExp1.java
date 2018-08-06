/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regexp1;
import java.io.*;
import java.util.regex.*;


/**
 *
 * @author Scott Stinson
 */
// Regexp1.java
//   This is merely a program to test out the use of regular expressions
//   in Java.  Its complete BS that github desktop itself requires "Atom"
//   to edit the program from github when there's already editors installed.

public class RegExp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    PrintWriter screenOut = new PrintWriter(System.out, true);

   // Pattern p = Pattern.compile("a*b");
   // Matcher m = p.matcher("aaaaab");
   // boolean b = m.matches();

    Pattern p = Pattern.compile("H[0-9]");
    Matcher m = p.matcher("A123 B123 H2 H321 Habc 1234 H56");
    boolean b = m.find();

//Matcher m = p.matcher("H1");
    //boolean b = m.matches();

    screenOut.println("Does Pattern match? " + b);
    screenOut.println("At position " + m.start());
    }

}
