import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
문제
1.고속도로 위 N개의 센서, 최대 k의 집중국
2.집중국의 수신가능 영역 길이의 합을 최소화 (수신가능 영역은 집중국의 수)
3.각 좌표 사이의 거리는 빈칸이 하나있음(좌표 겹쳐지지 않음)

입력값
센서의 개수
집중국의 개수
센서 좌표

풀이
1. 우선 센서 위치 정렬
2. 우리는 수신가능 영역길이를 최소화 해야함으로 길이가 긴 걸 빼줘야함
3. 센서 거리 배열 만들어서 각 거리중에서 최대값 구하고 집중국 수만큼 빼준다.
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sensorN = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensor = new int[sensorN];

        //센서 배열로 만들기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < sensorN; i++){
            sensor[i] = Integer.parseInt(st.nextToken());
//            System.out.print(senesor[i]+" ");
        }

        Arrays.sort(sensor);

        int[] distance = new int[sensorN-1];
        for(int i = 1; i < sensorN; i++){
            distance[i-1] = sensor[i]-sensor[i-1];
//            System.out.print(distance[i-1]+" ");
        }

        Arrays.sort(distance);

        int result =0;
        int count = distance.length - (K-1);
        for(int i=0 ; i<count ; i++){
            result += distance[i];
        }
        System.out.println(result);
    }
}
