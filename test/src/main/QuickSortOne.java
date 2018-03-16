package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class QuickSortOne {
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        int[] longs;
        List<String> strings = new ArrayList<>();
        try {

            fr = new FileReader("input.txt");
            br = new BufferedReader(fr);
            fw = new FileWriter("output.txt");
            bw = new BufferedWriter(fw);
            String line;
            line = br.readLine();
            int n = Integer.parseInt(line.trim());

            longs = new int[n];
            if (n == 1) {longs[0]=n;}
            else if (n == 2) {longs[0]=n-1;longs[1]=n;}
            else if (n==3) {longs[0]=n-2;longs[1]=n;longs[2]=n-1;}
            else {
  /*              longs[1] = 1;longs[2] = 3;
                for (int step=4; step<=n; step++)
                    if ((step & 1) == 0)
                        longs[step-1] = longs[(step>>1)-1];
                    else
                    {
                        longs[step-1] = longs[step>>1];
                        longs[step>>1] = step;
                    }
                for (int i=0; i<(n>>1); i++)
                    longs[i] = i+i+2;*/
                longs[1] = 1;longs[2] = 3;
                for (int step=4; step<=n; step++)
                    if ((step%2) == 0)
                        longs[step-1] = longs[(step/2)-1];
                    else
                    {
                        longs[step-1] = longs[step/2];
                        longs[step/2] = step;
                    }
                for (int i=0; i<(n/2); i++)
                    longs[i] = i+i+2;
            }

            strings.add(Arrays.stream(longs).boxed().map(ints1 -> Long.toString(ints1)).collect(joining(" ")));

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
