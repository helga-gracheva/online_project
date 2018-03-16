package main;

import java.io.*;

public class OneOne {
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        String[] ints = null;
        long result;
        try {

            fr = new FileReader("input.txt");
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                ints = line.split("\\s+");
            }
            long firstInt = Long.parseLong(ints[0]);
            long secondInt =Long.parseLong(ints[1]);
            result = firstInt + secondInt * secondInt;
            fw = new FileWriter("output.txt");
            bw = new BufferedWriter(fw);
            bw.write(Long.toString(result));
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
