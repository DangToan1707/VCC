package week1.test1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Test1 {
     int MAX_SIZE = 200000;
    Set<Integer> tapA = new HashSet<Integer>();
     Set<Integer> tapB = new HashSet<Integer>();
     Set<Integer> result = new HashSet<Integer>();

    public void sinhTapA() {
        do {
            tapA.add(ThreadLocalRandom.current().nextInt(400000));
        } while(tapA.size() < MAX_SIZE);

    }
    public  void sinhTapB() {
        do {
            tapB.add(ThreadLocalRandom.current().nextInt(400000));
        } while(tapB.size() < MAX_SIZE);
    }
    public static void main(String args[]) {

        Test1 test1 = new Test1();
        test1.sinhTapA();
        System.out.println(test1.tapA.size());
        test1.sinhTapB();
        System.out.println(test1.tapB.size());
        test1.result.addAll(test1.tapA);
        test1.result.addAll(test1.tapB);
        ArrayList<Integer> results = new ArrayList<Integer>();
        for(int i : test1.tapA) {
            if(test1.tapB.contains(i)) {
                results.add(i);
            }
        }
        System.out.println("tap hop cua 2 tap hop : " + test1.result.size());
        System.out.println("tap giao cua 2 tap hop : " + results.size());

        test1.tapA.clear();
        test1.tapB.clear();
        test1.result.clear();
        results.clear();
    }

}