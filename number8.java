// 8 
// Show how many stub AS in the dataset.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

public class number8 {
    //largest to smallest
    private static HashMap<String, Integer> sortByValueInverse(HashMap<String, Integer> unsortMap) {

        // Convert Map to List
        List<Map.Entry<String, Integer>> list
                = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // Sort list with comparator, to compare the Map values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                    Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // Convert sorted map back to a Map
        HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext();) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    /*private static void printTop10Largest(HashMap<String, Integer> notSortedMap) {
        HashMap<String, Integer> valueSortedMap = sortByValueInverse(notSortedMap);
        Iterator<String> it = valueSortedMap.keySet().iterator();
        String key;
        int value;
    
        for (int i = 1; i < 11; i++) {
            key = it.next();
            value = valueSortedMap.get(key);
            System.out.println(i + ". ASN" + key + " degree is " + value);
        }
    } */

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //FileReader fr = new FileReader("C:\\Users\\thanh\\Desktop\\CSCI4460 Networks Ops & Def\\PA3\\Test.txt"); //Test.txt
        FileReader fr = new FileReader("ASRelationship-2022-10-01.txt");
        //FileReader fr = new FileReader("C:\\Users\\thanh\\Desktop\\CSCI4460 Networks Ops & Def\\PA3\\ASRelationship-2022-10-01.txt"); //ASRelationship-2022-10-01.txt
        HashMap<String, Integer> list = new HashMap<String, Integer>();
        Set<List<Integer>> list1 = new HashSet<List<Integer>>();
        
        try (BufferedReader br = new BufferedReader(fr)) {
            
            String line = br.readLine();

            while((line = br.readLine()) != null) {

                StringTokenizer stLine = new StringTokenizer(line, "|");
                int as1 = Integer.parseInt(stLine.nextToken());
                int as2 = Integer.parseInt(stLine.nextToken());
                int rel = Integer.parseInt(stLine.nextToken());
                //String as1String = Integer.toString(as1);
                //String as2String = Integer.toString(as2);
                //Integer count = list.get(as1String);
                //String[] parts = line.split("\\|");
                
                if (rel == 0) {
                    if (list.containsKey(Integer.toString(as1))) {
                        list.put(Integer.toString(as1), list.get(Integer.toString(as1)) + 1);
                    } else {
                        list.put(Integer.toString(as1), 1);
                    }
                    if (list.containsKey(Integer.toString(as2))) {
                        list.put(Integer.toString(as2), list.get(Integer.toString(as2)) + 1);
                    } else {
                        list.put(Integer.toString(as2), 1);
                    }
                }

                if (rel == -1 && !list.containsKey(Integer.toString(as1))) {
                    if (list.containsKey(Integer.toString(as2))) {
                        list.put(Integer.toString(as2), list.get(Integer.toString(as2)) + 1);
                    } else {
                        list.put(Integer.toString(as2), 1);
                    }
                } 

                if (rel == -1 && ( list.containsKey(Integer.toString(as1)) == list.containsKey(Integer.toString(as2)))) {
                    if (list.containsKey(Integer.toString(as2))) {
                        list.remove(Integer.toString(as2), list.get(Integer.toString(as2)) - 1);
                    } /*else {
                        list.put(Integer.toString(as1), 1);
                    } */
                } 
 
            }
            System.out.println("8-) Show how many stub AS in the dataset: ");
            //printTop10Largest(list);
            System.out.println(list.size());
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}