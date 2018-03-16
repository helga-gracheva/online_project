package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class MergeSortOne {
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        String[] intStrs = null;
        long[] longs;
        List<String> strings = new ArrayList<>();
        try {

            fr = new FileReader("input.txt");
            br = new BufferedReader(fr);
            fw = new FileWriter("output.txt");
            bw = new BufferedWriter(fw);
            String line;
            line = br.readLine();
            int size = Integer.parseInt(line.trim());
            while ((line = br.readLine()) != null) {
                intStrs = line.split("\\s+");
            }
            longs = new long[size];
            for (int i = 0; i < intStrs.length; i++) {
                longs[i] = Long.parseLong(intStrs[i]);
            }

           long[] sorted = sort(longs, 0, longs.length-1, bw);

            strings.add(Arrays.stream(sorted).boxed().map(ints1 -> Long.toString(ints1)).collect(joining(" ")));

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

    public static long[] sort(long[] longs, int start, int end,  BufferedWriter bw) throws  IOException{
        int length = end - start + 1;
        if (length  == 1 )
             return new long[]{longs[start]};

        if (length  == 2  ){
//            long rez[] = new long[2];
//            if (longs[start]>longs[end]){
//                rez =  swap(longs[start],longs[end]);
//            } else {
//                rez[0] = longs[start];
//                rez[1] = longs[end];
//                //return new long[]{longs[start], longs[end]};
//            }
//            bw.write( (start+1)+ " " +(end+1) + " " + rez[0]+" "+rez[1]);
//            bw.newLine();
        }

        int half = length/2;
        long b[] = sort(longs,start,start+half-1, bw);
        long c[] = sort(longs,start+half, end, bw);
        return merge(b, 0, b.length -1, c, 0, c.length -1 , bw, start, end);
    }


    public static long[] merge(long a[], int startA, int endA, long b[], int startB, int endB, BufferedWriter bw, int start, int end) throws IOException{
//        bw.write((startA+1) + " " + (endA+1) + " " + a[startA]+" "+a[endA]);
//        bw.newLine();
//        bw.write( (endA+startB+2)+ " " +(endA+endB+2) + " " + b[startB]+" "+b[endB]);
//        bw.newLine();



        int aLength=endA-startA+1;
        int bLength=endB-startB+1;

        long[] c = new long[aLength+bLength];

        int ai = 0;
        int bi = 0;

        for(int i=0; i<c.length; i++) {
            if(ai>=aLength) {
                c[i] = b[bi++];
                continue;
            }
            if(bi>=bLength) {
                c[i] = a[ai++];
                continue;
            }
            if(a[ai]<b[bi]) {
                c[i] = a[ai++];
            } else {
                c[i]= b[bi++];
            }
        }
//        bw.write( (startA +1)+ " " +(endA+endB+2) + " " + c[0]+" "+c[aLength+bLength-1]);
//        bw.newLine();
        bw.write( (start+1)+ " " +(end+1) + " " + c[0]+" "+c[aLength+bLength-1]);
        bw.newLine();
        return c;
    }
     private static long[] swap(long i,long j){
        return new long[]{j, i};
     }
}
