import com.opencsv.CSVReader;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args){

        parseCSV();

    }

    public static void parseCSV() {

        File file = new File("src/repairs.csv");
        try{
            if(file != null){
                Scanner sc = new Scanner(file);
                while(sc.hasNext()){
                    System.out.println(sc.next());
                }
                sc.close();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }



    public static void readCSV_2(){

        try{
            CSVReader reader = new CSVReader(new FileReader("repairs.csv"));
            String[]nextline;
            while((nextline=reader.readNext()) != null){
                if(nextline != null){
                    System.out.println(Arrays.toString(nextline));
                }
            }
            System.out.println("Read Complete!");

        } catch(Exception e){
            System.out.println(e);
            System.out.println("Read Failed!");
        }
    }

}
