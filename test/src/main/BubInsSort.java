package main;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class BubInsSort {
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
            Map<Double, Integer>  map = new HashMap<>(size);
            double[] doubles = new double[size];
        while ((line = br.readLine()) != null) {
            intsStr = line.split("\\s+");
        }
        for (int i = 0; i < intsStr.length; i++){
            doubles[i] = Double.parseDouble(intsStr[i]);
            map.put(doubles[i],i+1);
            int j= i;
            if(j > 0 ){
                    while (j > 0) {
                        if (doubles[j] < doubles[j - 1]){
                            double temp = doubles[j];
                            doubles[j] = doubles[j - 1];
                            doubles[j - 1] = temp;
                        } else {
                            break;
                        }
                        j--;
                    }
            }
        }

        fw = new FileWriter("output.txt");
        bw = new BufferedWriter(fw);
        String str = map.get(doubles[0]) + " " + map.get(doubles[size / 2]) + " " +  map.get(doubles[size - 1 ]);
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
