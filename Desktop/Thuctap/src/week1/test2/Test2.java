package week1.test2;


import java.io.*;
import java.util.*;

public class Test2{
//    public static boolean check(String word){
//        boolean result = true;
//        int a = word.length();
//        char[] ch = word.toCharArray();
//        for(int k =0; k < a; k++){
//            char i = ch[k];
//            if((i>=65 && i<=90)||(i>=97 && i<=122)) result =true;
//            else {
//                result =false;
//                break;
//            }
//        }
//        return result;
//    }
    public static void main(String[] args){
        Map<String, Integer> result = new HashMap<String, Integer>();
        // doc file va xu ly dem tu
        try {
            Scanner input = new Scanner(new File("/home/dangtoan/Desktop/Thuctap/src/week1/test2/input.txt"));
            while (input.hasNext()) {
                String word = input.next();
//                if(check(word)) {
                    Integer count = result.get(word);
                    if (count != null) count++;
                    else count = 1;
                    result.put(word, count);
//                }
            }
            input.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        // ghi du lieu ra file
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(new File("/home/dangtoan/Desktop/Thuctap/src/week1/test2/output.txt")));
            for (Map.Entry<String, Integer> i: result.entrySet()) {
                output.write(i.getKey() + " - " + i.getValue());
                output.newLine();
            }
            output.flush();
            output.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}