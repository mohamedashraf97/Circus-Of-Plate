/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.Scanner;


/**
 *
 * @author MODY
 */
public class Snapshot {
  
    public int getScore() throws FileNotFoundException {
        Scanner s=null;
        try{
            s=new Scanner(new File("score.txt"));
        }catch(Exception e){
            return 0;
        }
        if(s.hasNextInt())
        
        return s.nextInt();
        return 0;
    }

    public void setScore(int score) throws FileNotFoundException {
        PrintWriter p=new PrintWriter("score.txt");
        p.print(score);
        p.close();
    }
    
    
}
