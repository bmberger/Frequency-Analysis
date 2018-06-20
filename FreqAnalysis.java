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
public class FreqAnalysis extends FreqAnalysisTester
{
    // instance variables
    private ArrayList<String> wordsArray;

    /**
     * Constructor for objects of class FreqAnalysis
     */
    public FreqAnalysis(ArrayList w)
    {
        this.wordsArray = w;
    }

    /**
     * Purpose: Calculate frequency of each letter in text file given.
     *
     * @return    abcFreq
     */
    public ArrayList analyze()
    {
        String[] abc = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        ArrayList<Integer> abcFreq = new ArrayList<Integer>(abc.length);
        int val = 0;
        for(int f = 0; f < abc.length; f++)
        {
            abcFreq.add(f, 0);
        }
        
        //looping through whole array of words
        for(int j = 0; j < this.wordsArray.size(); j++)
        {
            //looping through the word
            for(int i = 0; i < this.wordsArray.get(j).length(); i++)
            {
                //looping through abc's to match to our word
                for (int k = 0; k < abc.length; k++)
                {
                    if(abc[k].equalsIgnoreCase((this.wordsArray.get(j)).substring(i,i+1)))
                    {
                        val = abcFreq.get(k);
                        abcFreq.set(k, val + 1);
                    }
                }
            }
        }
        return abcFreq;
    }
}
