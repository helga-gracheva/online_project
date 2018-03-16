package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class OneSortLast {
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        String[] intStrs = null;
        long[] ints;
        List<String> strings = new ArrayList<>();
        try {

            fr = new FileReader("input.txt");
            br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            int size = Integer.parseInt(line.trim());
            while ((line = br.readLine()) != null) {
                intStrs = line.split("\\s+");
            }
            ints = new long[size];
            for (int i = 0; i < intStrs.length; i++) {
                ints[i] = Long.parseLong(intStrs[i]);
            }
            for (int i = 1; i < ints.length; i++) {
                long elem = ints[i];
                int j = i - 1;
                while (j >= 0 && ints[j] > elem) {
                    ints[j + 1] = ints[j];
                    strings.add("Swap elements at indices " + (j + 1) + " and " + (j + 2) + ".");
                    j--;
                }
                ints[j + 1] = elem;
//                if (j + 2 != i + 1) {
//                    strings.add("Swap elements at indices " + (j + 2) + " and " + (i + 1) + ".");
//                }
            }
            strings.add("No more swaps needed.");
            strings.add(Arrays.stream(ints).boxed().map(ints1 -> Long.toString(ints1)).collect(joining(" ")));
            fw = new FileWriter("output.txt");
            bw = new BufferedWriter(fw);
            for (String string : strings) {
                bw.write(string);
                bw.newLine();
            }
            br.close();
            fr.close();

        } finally {

            if (br != null)
                br.close();

            if (fr != null)
                fr.close();
            if (bw != null)
                bw.close();

            if (fw != null)
                fw.close();
        }
    }
}
