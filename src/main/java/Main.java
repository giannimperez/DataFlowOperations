import com.opencsv.CSVReader;

import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement pstmt;

    public static void main(String[] args){

        Main main = new Main();
        main.initialize();
        main.parseCSV();

    }

    public void initialize(){
        initializeDB();
    }

    /**
     * Creates the database connection
     *
     * @author Gianni Perez
     */
    private void initializeDB() {
        //  Database credentials
         String password = "";
         final String JDBC_DRIVER = "org.h2.Driver";
         final String DB_URL = "jdbc:h2:./res/myDB";
         final String USER = "";
         final String PASS = "";
        System.out.println("Attempting...");
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Succesfully Connected!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void parseCSV() {

        File file = new File("src/repairs.csv");
        try{
            if(file != null){
                Scanner sc = new Scanner(file);
                while(sc.hasNext()){
                    System.out.println(sc.next());
                    try {
                        String sql = "INSERT INTO CSV_INFO(INFO) VALUES ('" + sc.next() + "')";
                        pstmt = conn.prepareStatement(sql);
                        pstmt.executeUpdate();
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
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
