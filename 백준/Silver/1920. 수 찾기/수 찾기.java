import java.io.*;
import java.util.*;
public class Main { 
public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }
    Arrays.sort(arr); // 이분 탐색을 위해 정렬

    int m = s.nextInt();
    int[] arrM = new int[m];
    for (int i = 0; i < m; i++) {
      arrM[i] = s.nextInt();
      System.out.println(binarySearch(arr, arrM[i]));
    }
  }

  private static int binarySearch(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (arr[mid] == target) {
        return 1;
      } else if (arr[mid] > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return 0;
  }
}