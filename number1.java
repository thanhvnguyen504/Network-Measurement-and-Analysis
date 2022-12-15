// Number 1
// Show how many unique ASN in the dataset. 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

public class number1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //FileReader fr = new FileReader("C:\\Users\\thanh\\Desktop\\CSCI4460 Networks Ops & Def\\PA3\\Test.txt"); //Test.txt
        //FileReader fr = new FileReader("C:\\Users\\thanh\\Desktop\\CSCI4460 Networks Ops & Def\\PA3\\ASRelationship-2022-10-01.txt"); //ASRelationship-2022-10-01.txt
        FileReader fr = new FileReader("ASRelationship-2022-10-01.txt");
        ArrayList<Integer> list = new ArrayList<Integer>();
        try (BufferedReader br = new BufferedReader(fr)) {

            String line = br.readLine();

            while((line = br.readLine()) != null) {
                StringTokenizer stLine = new StringTokenizer(line, "|");
                int as1 = Integer.parseInt(stLine.nextToken());
                int as2 = Integer.parseInt(stLine.nextToken());
                int rel = Integer.parseInt(stLine.nextToken());

                list.add(as1);
                list.add(as2);
            }

            HashSet<Integer> hset = new HashSet<Integer>(list);

            System.out.println("1-) How many unique ASN in the data shet:\n" + hset.size());
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}