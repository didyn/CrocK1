import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        //System.out.println(reverse("palindrome"));
        if (args == null)
            throw new IllegalArgumentException("fileNames cannot be null");
        int max = 0;
        LogReader log = new LogReader(args[0]);
        while (log.getCurrentLog() != null){
            log.nextArray();
        }
        for (int i = 0; i < log.getCurrentArray().length; i++)
            if (log.getCurrentArray()[i] > max)
                max = log.getCurrentArray()[i];
        if (max == 0){
            throw new IllegalArgumentException("no calls");
        }
        System.out.println(max);


    }

    public static String reverse(String string){
        String vowels = "aeiouy";
        char[] newString = string.toCharArray();
        char k;
        int j = newString.length - 1;
        int i = 0;
        while (i < j){
            boolean flag = false;
            if (vowels.indexOf(newString[i])!= -1)
                while (!flag && i != j){
                    if (vowels.indexOf(newString[j])!= -1){
                        k = newString[i];
                        newString[i] = newString[j];
                        newString[j] = k;
                        flag = true;
                    }
                    j--;
                }
            i++;
        }

        return String.valueOf(newString);
    }

    /*static int callCenter(String fileName){
        int max = 0;
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))){
            String line;
            //int[] array = new int[0];
            ArrayList arrayList = new ArrayList();
            while ((line = input.readLine()) != null){
                int k = line.indexOf(',');
                int timeStart = Integer.parseInt(line.substring(0, k));
                int timeEnd = Integer.parseInt(line.substring(k + 1));
                arrayList.size() = timeEnd;
                for (int i = timeStart; i <= timeEnd; i++)
                    arrayList.add(i, (int)arrayList.get(i) + 1);
            }

            for (int i = 0; i < arrayList.size(); i++)
                if ((int)arrayList.get(i) != 0 && (int)arrayList.get(i) > max)
                    max = (int)arrayList.get(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (max == 0)
            System.out.println("не было звонков");
        return max;
    }*/

}
