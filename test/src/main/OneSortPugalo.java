package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class OneSortPugalo {
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
            boolean sorted = true;
            String line;
            line = br.readLine();
            intStrs = line.split("\\s+");
            int n = Integer.parseInt(intStrs[0]);
            int k = Integer.parseInt(intStrs[1]);
            line = br.readLine();
            intStrs = line.split("\\s+");
            ints = new long[n];
            for (int i = 0; i < intStrs.length; i++) {
                ints[i] = Long.parseLong(intStrs[i]);
            }
            for (int i = 0; i + k < ints.length; i++) {
                if (ints[i] > ints[i+k]){
                   long temp = ints[i];
                   ints[i] = ints[i+k];
                   ints[i+k] = temp;
                }
            }

            for (int i = 1; i < ints.length; i++) {
                if (ints[i] < ints[i-1]){
                    sorted = false;
                }
            }

            fw = new FileWriter("output.txt");
            bw = new BufferedWriter(fw);
            if (sorted) {
                bw.write("YES");
            } else {
                bw.write("NO");
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
