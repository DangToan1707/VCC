package Demo;

import java.util.Scanner;

public class binarySearch {
    public int search(int[] a, int n, int x){
        int result = 0;
        int i=0;
        while ( i == n ){
            int temp = (int)(i+n)/2;
            if(a[temp] == x ) result = temp;
            else if(a[temp] < x)
            {
                n = temp;
            }
            else{
                i =temp;
            }
        }
        if(result == 0) {
            System.out.println(" khong co gia tri " + x + " trong mang ");
            return 0 ;
        }
        else return result;
    }
    public static void main(String args[]){
        binarySearch A = new binarySearch();
        int x=5;
        int[] a={1,2,3,4,5,6,7,8};
        int n = a.length;
        int X =A.search(a,n,x);
        System.out.println(X);
    }
}
