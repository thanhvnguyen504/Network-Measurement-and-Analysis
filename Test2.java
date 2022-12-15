// https://www.youtube.com/watch?v=XyWRoYLJ8rc
// https://www.java67.com/2016/07/how-to-read-text-file-into-arraylist-in-java.html#:~:text=All%20you%20need%20to%20do,)%3B%20String%20line%20%3D%20bufReader.
// https://stackoverflow.com/questions/2612970/two-key-hashset 
// https://ayasinnur.com/comopsec/ 
// https://stackoverflow.com/questions/32502924/what-is-this-statement-count-null-1-count-1 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

public class Test2 {

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

    private static void printTop10Largest(HashMap<String, Integer> notSortedMap) {
        HashMap<String, Integer> valueSortedMap = sortByValueInverse(notSortedMap);
        Iterator<String> it = valueSortedMap.keySet().iterator();
        String key;
        int value;
    
        for (int i = 1; i < 11; i++) {
            key = it.next();
            value = valueSortedMap.get(key);
            System.out.println(i + ", ASN" + key + " degree is " + value);
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //FileReader fr = new FileReader("C:\\Users\\thanh\\Desktop\\CSCI4460 Networks Ops & Def\\PA3\\Test.txt"); //Test.txt
        FileReader fr = new FileReader("C:\\Users\\thanh\\Desktop\\CSCI4460 Networks Ops & Def\\PA3\\ASRelationship-2022-10-01.txt"); //ASRelationship-2022-10-01.txt
        try (BufferedReader br = new BufferedReader(fr)) {
            // #1
            ArrayList<Integer> list = new ArrayList<Integer>();
            // #2
            Set<List<Integer>> list2 = new HashSet<List<Integer>>();
            // #3
            Set<List<Integer>> list3 = new HashSet<List<Integer>>();
            Set<List<Integer>> list4 = new HashSet<List<Integer>>();
            // #4
            HashMap<String, Integer> asNDD = new HashMap<String, Integer>();
            // #5
            HashMap<String, Integer> asNDD2 = new HashMap<String, Integer>();
            // #6
            HashMap<String, Integer> asNDD3 = new HashMap<String, Integer>();
            // #7
            //Set<List<Integer>> list5 = new HashSet<List<Integer>>();
            HashMap<String, Integer> asNDD4 = new HashMap<String, Integer>();
            // #8
            HashMap<String, Integer> asNDD5 = new HashMap<String, Integer>();
            //Set<List<Integer>> list5 = new HashSet<List<Integer>>();
            //ArrayList<Integer> list5 = new ArrayList<Integer>();

            String line = br.readLine();

            while((line = br.readLine()) != null) {
                
                
                StringTokenizer stLine = new StringTokenizer(line, "|");
                int as1 = Integer.parseInt(stLine.nextToken());
                int as2 = Integer.parseInt(stLine.nextToken());
                int rel = Integer.parseInt(stLine.nextToken());
                String as1String = Integer.toString(as1);
                String as2String = Integer.toString(as2);
                //String Source = stLine.nextToken();
                //System.out.println("AS1: " + as1 + " AS2: " + as2); //+ " Rel: " + rel + " Source: " + Source);
                //System.out.println("AS1: " + as1 + " AS2: " + as2 + " Rel: " + rel + " Source: " + Source);
                //System.out.println(line); // print out the whole line
                
                // 1
                list.add(as1);
                list.add(as2);
                //System.out.println(list);
                
                // 2
                list2.add((List<Integer>)Arrays.asList(new Integer[] {as1, as2}));
                list2.add((List<Integer>)Arrays.asList(new Integer[] {as2, as1}));
                //System.out.println(list2);
                
                // 3
                if (rel == 0) {
                    list3.add((List<Integer>)Arrays.asList(new Integer[] {as1, as2, rel}));
                    list3.add((List<Integer>)Arrays.asList(new Integer[] {as2, as1, rel}));
                }
                //System.out.println(list4);
                if (rel == -1) {
                    list4.add((List<Integer>)Arrays.asList(new Integer[] {as1, as2, rel}));
                    list4.add((List<Integer>)Arrays.asList(new Integer[] {as2, as1, rel}));
                }
                
                // 4 
                //String[] parts = line.split("\\|");
                //Integer count = asNDD.get(parts[0]);
                //asNDD.put(parts[0], (count == null) ? 1 : count +1);
                //count = asNDD.get(parts[1]);
                //asNDD.put(parts[1], (count == null) ? 1 : count +1);
                if (asNDD.containsKey(as1String)) {
                    asNDD.put(as1String, asNDD.get(as1String) + 1);
                } else {
                    asNDD.put(as1String, 1);
                }
                if (asNDD.containsKey(as2String)) {
                    asNDD.put(as2String, asNDD.get(as2String) + 1);
                } else {
                    asNDD.put(as2String, 1);
                }
            
                // 5
                /*if (rel == -1)  {
                    count = asNDD2.get(parts[0]);
                    asNDD2.put(parts[0], (count == null) ? 1 : count +1);
                    count = asNDD2.get(parts[1]);
                    asNDD2.put(parts[1], (count == null) ? 0 : count +0);
                }*/
                if (rel == -1 /*&& count == null*/) {
                    if (asNDD2.containsKey(as1String)) {
                        asNDD2.put(as1String, asNDD2.get(as1String) + 1);
                    } else {
                        asNDD2.put(as1String, 1);
                    }
                    
                    //count = list.get(as2String);
                    //if (count == null) {
                        if (asNDD2.containsKey(as2String)) {
                            asNDD2.put(as2String, asNDD2.get(as2String) + 1);
                        } else {
                            asNDD2.put(as2String, 1);
                        }
                    //}
                    
                }

                // 6
                /*if (rel == 0) {
                    count = asNDD3.get(parts[0]);
                    asNDD3.put(parts[0], (count == null) ? 1 : count +1);
                    count = asNDD3.get(parts[1]);
                    asNDD3.put(parts[1], (count == null) ? 1 : count +1);
                }*/

                if (rel == 0) {
                    if (asNDD3.containsKey(Integer.toString(as1))) {
                        asNDD3.put(Integer.toString(as1), asNDD3.get(Integer.toString(as1)) + 1);
                    } else {
                        asNDD3.put(Integer.toString(as1), 1);
                    }
                    if (asNDD3.containsKey(Integer.toString(as2))) {
                        asNDD3.put(Integer.toString(as2), asNDD3.get(Integer.toString(as2)) + 1);
                    } else {
                        asNDD3.put(Integer.toString(as2), 1);
                    }
                }

                // 7) Find top-10 largest tier-1 ASN in terms of connection size
                // Example 
                // E.g. <provider-as>|<customer-as>|-1|<source>
                // 1|5467|-1|bgp
                // 5|1|0|bgp
                    // Any ASN in the second spot of a business relation with -1 cannot be a tier-1 AS. For
                    // example, 5467 is not tier-1 AS. ASN1 can be, if it doesn’t have any provider. Note that, p2p
                    // relations are ok
                        // Check all dataset and find only ASNs that are not customers.
                /*if (rel == 0) {
                    count = asNDD4.get(parts[0]);
                    asNDD4.put(parts[0], (count == null) ? 1 : count +1);
                    count = asNDD4.get(parts[1]);
                    asNDD4.put(parts[1], (count == null) ? 1 : count +1);

                    if (rel == -1 && ( asNDD4.get(parts[0]) != asNDD4.get(parts[1]) ) ) {
                        if (rel == 0 && ( asNDD4.get(parts[0]) != asNDD4.get(parts[1]) )) { 
                            count = asNDD4.get(parts[0]);
                            asNDD4.put(parts[0], (count == null) ? 1 : count +1);
                            count = asNDD4.get(parts[1]);
                            asNDD4.put(parts[1], (count == null) ? 1 : count +1);
                        }
                    }
                } */

                if (rel == 0) {
                    if (asNDD4.containsKey(Integer.toString(as1))) {
                        asNDD4.put(Integer.toString(as1), asNDD4.get(Integer.toString(as1)) + 1);
                    } else {
                        asNDD4.put(Integer.toString(as1), 1);
                    }
                    if (asNDD4.containsKey(Integer.toString(as2))) {
                        asNDD4.put(Integer.toString(as2), asNDD4.get(Integer.toString(as2)) + 1);
                    } else {
                        asNDD4.put(Integer.toString(as2), 1);
                    }
                }

                if (rel == -1 && !asNDD4.containsKey(Integer.toString(as2))) {
                    if (asNDD4.containsKey(Integer.toString(as1))) {
                        asNDD4.put(Integer.toString(as1), asNDD4.get(Integer.toString(as1)) + 1);
                    } else {
                        asNDD4.put(Integer.toString(as1), 1);
                    }
                } 

                if (rel == -1 && ( asNDD4.containsKey(Integer.toString(as2)) == asNDD4.containsKey(Integer.toString(as1)))) {
                    if (asNDD4.containsKey(Integer.toString(as1))) {
                        asNDD4.remove(Integer.toString(as1), asNDD4.get(Integer.toString(as1)) - 1);
                    } /*else {
                        asNDD4.put(Integer.toString(as1), 1);
                    } */
                } 
                
                    // in this example 
                    // -1 means it is p2c
                    // 0 means it is c2p
                        // check to see if 1 in the as1 column is a customer or has a provider in any ASN
                        // if yes, 1 is not tier-1. if no, 1 is tier-1

                // check all dataset and find only ASNs that are not customers
                
                // check to see in p2c if the p is the customer in the list
                // check to see if p has a provider and is a customer in another ASN
                // if yes, 1 is not tier-1. if no, 1 is tier-1
                // 
                // if it does not have a provider in another, then it is a tier-1 ASN
                // if it does have a provider in another, then it is not a tier-1 ASN
                // if it is a tier-1 ASN, then print it out
                // if it is not a tier-1 ASN, then do not print it out
                // if it is a tier-1 ASN, then add it to a list
                // if it is not a tier-1 ASN, then do not add it to a list
                
                // Find top-10 largest tier-1 ASN in terms of connection size
            
                // 8 
                // Stub-AS: they may have providers and peers but they do not have customers.
                
                // if it is a stub-AS, then print it out
                // if it is not a stub-AS, then do not print it out
                // if it is a stub-AS, then add it to a list
                // if it is not a stub-AS, then do not add it to a list
                /*if (rel == 0) {
                    list5.add((List<Integer>)Arrays.asList(new Integer[] {as1}));
                    list5.add((List<Integer>)Arrays.asList(new Integer[] {as2})); 
                }
                if (rel == -1) {
                    list5.add((List<Integer>)Arrays.asList(new Integer[] {as1}));                    
                } */

                if (rel == 0) {
                    if (asNDD5.containsKey(Integer.toString(as1))) {
                        asNDD5.put(Integer.toString(as1), asNDD5.get(Integer.toString(as1)) + 1);
                    } else {
                        asNDD5.put(Integer.toString(as1), 1);
                    }
                    if (asNDD5.containsKey(Integer.toString(as2))) {
                        asNDD5.put(Integer.toString(as2), asNDD5.get(Integer.toString(as2)) + 1);
                    } else {
                        asNDD5.put(Integer.toString(as2), 1);
                    }
                }

                if (rel == -1 && !asNDD5.containsKey(Integer.toString(as1))) {
                    if (asNDD5.containsKey(Integer.toString(as2))) {
                        asNDD5.put(Integer.toString(as2), asNDD5.get(Integer.toString(as2)) + 1);
                    } else {
                        asNDD5.put(Integer.toString(as2), 1);
                    }
                } 

                if (rel == -1 && ( asNDD5.containsKey(Integer.toString(as1)) == asNDD5.containsKey(Integer.toString(as2)))) {
                    if (asNDD5.containsKey(Integer.toString(as2))) {
                        asNDD5.remove(Integer.toString(as2), asNDD5.get(Integer.toString(as2)) - 1);
                    } /*else {
                        list.put(Integer.toString(as1), 1);
                    } */
                } 

                //asNDD.put("ASN", as1);
                //asNDD.put("ASN", as2);
                //asNDD = sortByValueInverse(asNDD);
                //printTop10Largest(asNDD); 
                //list4.add((List<Integer>)Arrays.asList(new Integer[] {as1, as2, rel}));
                //list4.add((List<Integer>)Arrays.asList(new Integer[] {as2, as1, rel}));

                //System.out.println("inside while loop: " + list);
                //System.out.println("inside while loop: " + list2);
                //System.out.println("inside while loop: " + list3);78

            }      
            //System.out.println("ArrayList: " + list);
            //System.out.println("Size of ArrayList: " + list.size());
            
            HashSet<Integer> hset = new HashSet<Integer>(list);
            //System.out.println("HashSet: " + hset);
            System.out.println("1-) How many unique ASN in the data shet:\n" + hset.size());
            System.out.print("----------------------------------------------------------------------------------------------------------------\n");
            //System.out.println("2-) How many unique ASN links in the data set: " + ( ( (list2.size()) + (list3.size()) ) /2 ));
            System.out.println("2-) How many unique ASN links in the data set:\n" + ( ( (list2.size()) ) /2 ));
            System.out.print("----------------------------------------------------------------------------------------------------------------\n");
            System.out.println("3-) How many unique p2p and p2c relations in the data set:\n" + list3.size() / 2 + " p2p relations and " + list4.size() / 2 + " p2c relations");
            //System.out.println(list4.size() + list6.size());
            System.out.print("----------------------------------------------------------------------------------------------------------------\n");
            System.out.println("4-) Find top-10 largest ASN in terms of connection size (Node degree distribution):");
            printTop10Largest(asNDD); 
            System.out.print("----------------------------------------------------------------------------------------------------------------\n");
            System.out.println("5-) Find top-10 largest Provider ASN in terms of connection size (Node degree distribution):");
            printTop10Largest(asNDD2);
            System.out.print("----------------------------------------------------------------------------------------------------------------\n");
            System.out.println("6-) Find top-10 largest peer to peer ASN in terms of connection size (Node degree distribution):");
            printTop10Largest(asNDD3);
            System.out.print("----------------------------------------------------------------------------------------------------------------\n");
            System.out.println("7-) Find top-10 largest tier-1 ASN in terms of connection size (Node degree distribution):");
            printTop10Largest(asNDD4);
            System.out.print("----------------------------------------------------------------------------------------------------------------\n");
            System.out.println("8-) Show how many stub AS in the dataset: ");
            //System.out.println(hset.size() - asNDD4.size() );
            System.out.println(asNDD5.size());
            System.out.print("----------------------------------------------------------------------------------------------------------------\n");
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

    }
    
    
}