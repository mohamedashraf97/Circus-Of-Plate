/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ECC1
 */
public class DynamicLinkage implements DynamicLinkageInt{

    public String paths[] = new String[3];
    public Color color[] = new Color[3];

    @Override
    public Color[] getColor() {
        Color c;
        try {
            File file = new File("Dynamic.txt");
            try (FileReader fileReader = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                int i = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    
                    if (i >= 3) {
                        if (line.equalsIgnoreCase("red")) {
                            color[i - 3] = Color.RED;
                        } else if (line.equalsIgnoreCase("blue")) {
                            color[i - 3] = Color.BLUE;
                        } else if (line.equalsIgnoreCase("green")) {
                            color[i - 3] = Color.GREEN;
                        }
                    }
                    i++;
                }
            }
            //System.out.println(Arrays.toString(color));
            return color;
        } catch (IOException e) {
            //System.out.println(color); 
            return null;
        }

    }

    @Override
    public String[] getPaths() {

        try {
            File file = new File("Dynamic.txt");
            try (FileReader fileReader = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                int i = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    paths[i] = line;
                    i++;
                    if (i == 3) {
                        break;
                    }
                    
                }
            }
            //System.out.println(paths);
            return paths;
        } catch (Exception e) {// System.out.println(paths);   
            return null;
        }

    }
}
