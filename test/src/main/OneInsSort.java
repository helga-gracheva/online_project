package main;

import java.io.*;
import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class OneInsSort {
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
    BufferedReader br = null;
    BufferedWriter bw = null;
    FileWriter fw = null;
    String[] intsStr = null;
        try {
        fr = new FileReader("input.txt");
        br = new BufferedReader(fr);
        String line;
        line =  br.readLine();
        int  size = Integer.parseInt(line.trim());
            int[] ints = new int[size];
            int[] indicies = new int[size];
        while ((line = br.readLine()) != null) {
            intsStr = line.split("\\s+");
        }
        for (int i = 0; i < intsStr.length; i++){
            ints[i] = Integer.parseInt(intsStr[i]);
            int j= i;
            if(j > 0 ){
                    while (j > 0) {
                        if (ints[j] < ints[j - 1]){
                         int temp = ints[j];
                         ints[j] = ints[j - 1];
                         ints[j - 1] = temp;
                         indicies[i] = j;
                        } else {
                            indicies[i] = j + 1;
                            break;
                        }
                        j--;
                    }
            }
            else indicies[i] = i + 1;
        }
        fw = new FileWriter("output.txt");
        bw = new BufferedWriter(fw);
        String str = Arrays.stream(indicies).boxed().map(ints1 -> Integer.toString(ints1)).collect(joining(" "));
        bw.write(str);
        bw.newLine();
        str = Arrays.stream(ints).boxed().map(ints1 -> Integer.toString(ints1)).collect(joining(" "));
        bw.write(str);
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
