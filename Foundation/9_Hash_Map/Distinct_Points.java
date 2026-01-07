// 📍 Distinct Points
// Problem Statement

// You are given N points on a 2D Cartesian plane.
// The coordinates of the points are provided using two arrays:

// X[] → x-coordinates
// Y[] → y-coordinates
// Each point is represented as:
// (X[i], Y[i])
// Your task is to count how many distinct points are present.

// Two points are considered the same if both their X and Y coordinates are equal.





import java.util.HashSet;
import java.util.Scanner;
public class Distinct_Points {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n=scn.nextInt();
		int[]Xarr=new int[n];
		int[]Yarr=new int[n];
		for(int i=0;i<n;i++){
			Xarr[i]=scn.nextInt();
		}
		for(int i=0;i<n;i++){
			Yarr[i]=scn.nextInt();
		}
		int result = distinctPoint(Xarr,Yarr);
		System.out.println(result);
	}
	public static int distinctPoint(int []Xarr,int []Yarr){
		int n= Xarr.length;
		HashSet<String>hs = new HashSet<>();

		for(int i =0;i<n;i++){
            hs.add(Xarr[i] + " " + Yarr[i]);
        }
        

		return hs.size();
	}
}

