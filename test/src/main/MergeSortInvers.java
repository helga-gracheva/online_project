package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class MergeSortInvers {
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        String[] intStrs = null;
        int[] longs;
        //List<String> strings = new ArrayList<>();
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
            longs = new int[size];
            for (int i = 0; i < intStrs.length; i++) {
                longs[i] = Integer.parseInt(intStrs[i]);
            }

           int count = count(longs);
                bw.write(String.valueOf(count));
                bw.newLine();
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

    /*public static long[] sort(long[] longs, int start, int end,  BufferedWriter bw) throws  IOException{
        int length = end - start + 1;
        if (length  == 1 )
             return new long[]{longs[start]};

        if (length  == 2  ){
            long rez[] = new long[2];
            if (longs[start]>longs[end]){
                rez =  swap(longs[start],longs[end]);
            } else {
                rez[0] = longs[start];
                rez[1] = longs[end];
            }
        }

        int half = length/2;
        long b[] = sort(longs,start,start+half-1, bw);
        long c[] = sort(longs,start+half, end, bw);
        return merge(b, 0, b.length -1, c, 0, c.length -1 , bw, start, end);
    }


    public static long[] merge(long a[], int startA, int endA, long b[], int startB, int endB, BufferedWriter bw, int start, int end) throws IOException{

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
        return c;
    }
     private static long[] swap(long i,long j){
        return new long[]{j, i};
     }*/

    static int count(int[] a) {
        int result = 0;

        for (int i = 0; i < a.length-1; i++ ){
            for (int j = i + 1; j < a.length; j++){
                if (a[i]>a[j]) result++;
            }
        }
        return result;
    }
}
