package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortThree {
    private static int count;
    private static int i0;
    private static int i1;
    private static int i2;
    private static int i3;
    private static int i4;
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

           int count = count(longs, 0, longs.length-1);

            bw.write(String.valueOf(count));

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

    public static int count(long[] longs, int start, int end) throws  IOException{
        int length = end - start + 1;
        if (length  == 1 )
             return 0;

        if (length  == 2  ){
            if (longs[start]>longs[end]){
                count++;
                return 1;
            }
        }

        int half = length/2;
        count += count(longs,start,start+half-1);
        count += count(longs,start+half, end);
        long[]b = Arrays.copyOfRange(longs,start,start+half-1);
        long[]c = Arrays.copyOfRange(longs,start+half, end);
        return count += merge(b, 0, b.length -1, c, 0, c.length -1);
    }


    public static int merge(long a[], int startA, int endA, long b[], int startB, int endB) throws IOException{
        int aLength=endA-startA+1;
        int bLength=endB-startB+1;

        long[] c = new long[aLength+bLength];

        int ai = 0;
        int bi = 0;

        int result =0;
        for(int i=0; i<c.length; i++) {
            if(ai>=aLength) {
                c[i] = b[bi++];
                i1++;
                continue;
            }
            if(bi>=bLength) {
                c[i] = a[ai++];
                i2++;
                result++;
                continue;

            }
            if(a[ai]<b[bi]) {
                c[i] = a[ai++];
i3++;
            } else {
                c[i]= b[bi++];
                i4++;
               // count++;
                result++;
            }
        }
        return result;
    }
}
