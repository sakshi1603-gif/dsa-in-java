// Count of right triangles_HW
// Solution Vid:
// https://youtu.be/219ae5GyKJA 

import java.util.HashMap;
import java.util.Scanner;
public class Count_of_right_triangles_HW {
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
		int result = triangle(Xarr,Yarr);
		System.out.println(result);
	}
	public static int triangle(int []Xarr,int []Yarr){
		int n= Xarr.length;
		HashMap<Integer,Integer>fx = new HashMap<>();
		HashMap<Integer,Integer>fy = new HashMap<>();

		for(int i =0;i<n;i++){
			if(!fx.containsKey(Xarr[i])){
                fx.put(Xarr[i],1);
            }else{
                int temp= fx.get(Xarr[i]);
                fx.put(Xarr[i],temp+1);
            }
		}
        for(int i =0;i<n;i++){
			if(!fy.containsKey(Yarr[i])){
                fy.put(Yarr[i],1);
            }else{
                int temp= fy.get(Yarr[i]);
                fy.put(Yarr[i],temp+1);
            }
		}
        int ans=0;
        for(int i = 0;i<n;i++){
            int countx=fx.get(Xarr[i]);
            int county=fy.get(Yarr[i]);

            ans=ans+(countx-1)*(county-1);
        }

		return ans;
	}
}


// 📐 Count of Right Triangles (Axis-Aligned)
// Problem Statement

// You are given N distinct points on a 2D Cartesian plane.
// The coordinates of the points are provided in two arrays:

// Xarr[] → X-coordinates

// Yarr[] → Y-coordinates

// Each point is represented as:

// (Xarr[i], Yarr[i])