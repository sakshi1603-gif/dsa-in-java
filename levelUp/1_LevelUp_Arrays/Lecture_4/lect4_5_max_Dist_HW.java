// 849. Maximize Distance to Closest Person
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

// There is at least one empty seat, and at least one person sitting.

// Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

// Return that maximum distance to the closest person.
public class lect4_5_max_Dist_HW {

    public static int maxDistToClosest(int[] seats) {

        int distance = Integer.MIN_VALUE;
        int i = -1;
        int n = seats.length;

        for(int j = 0; j < n; j++) {

            if(seats[j] == 1) {

                if(i == -1) {
                    distance = Math.max(distance, j);
                } else {
                    distance = Math.max(distance, (j - i) / 2);
                }

                i = j;
            }
        }

        distance = Math.max(distance, n - 1 - i);

        return distance;
    }

    public static void main(String[] args) {

        int[] seats = {1,0,0,0,1,0,1};

        System.out.println(maxDistToClosest(seats));
    }
}