// LU: BS_ Book Allocation
// Success rate: 30.00%
// You have n books, each with arr[i] pages. m students need to be allocated contiguous books, with each student getting at least one book. The objective is to find the allocation where the maximum number of pages assigned to a student is minimized.

// Note: Return -1 if a valid allocation is not possible.
// The books must be allocated in contiguous order.

// Input format:
// The first line contains two integers, n (number of books) and m (number of students).
// The second line contains n space-separated integers representing the number of pages in each book.

// Output format:
// Return an integer representing the minimum possible maximum pages that can be allocated to any student.

// Constraints:
// 1 <= n, m <= 10^5
// 1 <= arr[i] <= 10^6
import java.util.*;

public class lect1_4_Book_Allocation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println(BookAllocation(arr, m));
    }

    public static int BookAllocation(int[] arr, int m) {

        if (m > arr.length) {
            return -1;
        }

        int low = 0;
        int high = 0;

        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int students = StudentCount(arr, mid);

            if (students <= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int StudentCount(int[] arr, int maxPages) {

        int students = 1;
        int pages = 0;

        for (int book : arr) {
            if (pages + book > maxPages) {
                students++;
                pages = book;
            } else {
                pages += book;
            }
        }

        return students;
    }
}