

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] wood;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        wood = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            wood[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(wood);

        int low = 0;
        int high = wood[N - 1];


        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (woodsRemain(mid, M, N)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }


        }

        System.out.println(high);


    }

    static boolean woodsRemain(int mid, int M, int N) {

        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (wood[i] > mid) sum += (wood[i] - mid);
        }

        if (sum >= M) {
            return true;
        }
        return false;
    }
}
