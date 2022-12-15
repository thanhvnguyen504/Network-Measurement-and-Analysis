// Number 3
// Show how many unique p2p and p2c relations in the dataset
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

public class number3 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //FileReader fr = new FileReader("C:\\Users\\thanh\\Desktop\\CSCI4460 Networks Ops & Def\\PA3\\Test.txt"); //Test.txt
        //FileReader fr = new FileReader("C:\\Users\\thanh\\Desktop\\CSCI4460 Networks Ops & Def\\PA3\\ASRelationship-2022-10-01.txt"); //ASRelationship-2022-10-01.txt
        FileReader fr = new FileReader("ASRelationship-2022-10-01.txt");

        Set<List<Integer>> list1 = new HashSet<List<Integer>>();
        Set<List<Integer>> list2 = new HashSet<List<Integer>>();
        
        try (BufferedReader br = new BufferedReader(fr)) {
            
            String line = br.readLine();

            while((line = br.readLine()) != null) {
                StringTokenizer stLine = new StringTokenizer(line, "|");
                int as1 = Integer.parseInt(stLine.nextToken());
                int as2 = Integer.parseInt(stLine.nextToken());
                int rel = Integer.parseInt(stLine.nextToken());

                if (rel == 0) {
                    list1.add((List<Integer>)Arrays.asList(new Integer[] {as1, as2}));
                    list1.add((List<Integer>)Arrays.asList(new Integer[] {as2, as1}));
                } else if (rel == -1) {
                    list2.add((List<Integer>)Arrays.asList(new Integer[] {as1, as2}));
                    list2.add((List<Integer>)Arrays.asList(new Integer[] {as2, as1}));
                }
            }

            System.out.println("3-) How many unique p2p and p2c relations in the data set:\n" + list1.size() / 2 + " p2p relations and " + list2.size() / 2 + " p2c relations");
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}