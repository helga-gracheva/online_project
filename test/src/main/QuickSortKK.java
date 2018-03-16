package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class QuickSortKK {
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
    BufferedReader br = null;
    BufferedWriter bw = null;
    FileWriter fw = null;
    String[] intsStr = null;
        List<String[]> lines = new ArrayList<>(2);
        try {
        fr = new FileReader("input.txt");
        br = new BufferedReader(fr);
        String line;
        //line =  br.readLine();
        //int  size = Integer.parseInt(line.trim());
//            int[] ints = new int[size];
//            int[] indicies = new int[size];
        while ((line = br.readLine()) != null) {
           lines.add(line.split("\\s+"));
        }
        int size = Integer.parseInt(lines.get(0)[0]);
        int k1 = Integer.parseInt(lines.get(0)[1]);
        int k2 = Integer.parseInt(lines.get(0)[2]);
        int a =  Integer.parseInt(lines.get(1)[0]);
        int b =  Integer.parseInt(lines.get(1)[1]);
        int c =  Integer.parseInt(lines.get(1)[2]);
        int a1 = Integer.parseInt(lines.get(1)[3]);
        int a2 = Integer.parseInt(lines.get(1)[4]);
        List<Integer> ints = new ArrayList<>();
        ints.set(0,a1);
        ints.set(1,a2);
        int mid = a*(size - 2) + b*(size - 2)+ c*(size - 2);
        boolean over = false;
        for (int i = 2; i < size && !over; i++){
           int elem = a*ints.get(i-2) + b* ints.get(i-1) + c;
           if (elem > k2) {
                over = true;
           } else { ints.set(i,elem);}
        }
        fw = new FileWriter("output.txt");
        bw = new BufferedWriter(fw);
        //String str = Arrays.stream(indicies).boxed().map(ints1 -> Integer.toString(ints1)).collect(joining(" "));
//        bw.write(str);
//        bw.newLine();
//        str = Arrays.stream(ints).boxed().map(ints1 -> Integer.toString(ints1)).collect(joining(" "));
//        bw.write(str);
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
