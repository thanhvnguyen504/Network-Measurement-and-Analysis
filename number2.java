// Number 2
// Show how many unique links in the dataset
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

public class number2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //FileReader fr = new FileReader("C:\\Users\\thanh\\Desktop\\CSCI4460 Networks Ops & Def\\PA3\\Test.txt"); //Test.txt
        //FileReader fr = new FileReader("C:\\Users\\thanh\\Desktop\\CSCI4460 Networks Ops & Def\\PA3\\ASRelationship-2022-10-01.txt"); //ASRelationship-2022-10-01.txt
        FileReader fr = new FileReader("ASRelationship-2022-10-01.txt");
        try (BufferedReader br = new BufferedReader(fr)) {
            // #2
            Set<List<Integer>> list = new HashSet<List<Integer>>();

            String line = br.readLine();

            while((line = br.readLine()) != null) {
                StringTokenizer stLine = new StringTokenizer(line, "|");
                int as1 = Integer.parseInt(stLine.nextToken());
                int as2 = Integer.parseInt(stLine.nextToken());
                int rel = Integer.parseInt(stLine.nextToken());

                list.add((List<Integer>)Arrays.asList(new Integer[] {as1, as2}));
                list.add((List<Integer>)Arrays.asList(new Integer[] {as2, as1}));
            }

            System.out.println("2-) How many unique ASN links in the data set:\n" + ( ( (list.size()) ) /2 ));
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}