/**
 * Purpose: to determine the frequency of letters in a message
 *
 * @author Briana Berger
 * @version 06/08/2018
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList; 
public class FreqAnalysisTester
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> words = new ArrayList<String>();
        String[] abc = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        double count = 0.0;
        double rounded = 0.0;
        Scanner in = new Scanner(System.in);
        
        System.out.print("What should the name of the input file be? ");
        String file = in.next();
        File fileInName = new File(file + ".txt");
        Scanner inFile = new Scanner(fileInName);
        
        File fileOutName = new File(file + "Freq.txt");
        PrintWriter outFile  = new PrintWriter(fileOutName);
        
        in.nextLine();
        
        //Parses data from text file into respective words array.
        while (inFile.hasNext())
        {
            words.add(inFile.next());
        }
        
        FreqAnalysis freq = new FreqAnalysis(words);
        ArrayList<Integer> frequencyCount = freq.analyze();
        for(Integer f : frequencyCount)
            count = count + f;
        
        System.out.printf("%11s %24s %30s %n", "Letter:", "Frequency in File:", "Percent Frequency in File:");
        for(int i = 0; i < abc.length; i++)
        {
            rounded = Math.round(((frequencyCount.get(i)/count) * 100.0) * 100.0)/100.0;
            System.out.printf("%7s %20s %26s %n", abc[i], frequencyCount.get(i), rounded + "%");
            outFile.printf("%7s %20s %26s %n", abc[i], frequencyCount.get(i), rounded + "%");
        }
        outFile.close(); 
    }
}
