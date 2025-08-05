
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Egg[] eggs;
    static int maxCount = 0;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(durability,weight);
        }

        dfs(0);
        System.out.println(maxCount);

    }

    static void dfs(int pos){
        //종료 조건 : 계란을 다 들었다면
        //계란이 깨진 것만 count
        if(pos == N){
            int count = 0;
            for(int i=0; i<N; i++){
                if(eggs[i].durability <=0) count++;
            }
            maxCount = Math.max(maxCount, count);
            return;
        }

        // 현재 계란이 깨져 있으면 다음 계란으로
        if (eggs[pos].durability <= 0) {
            dfs(pos + 1);
            return;
        }

        // 칠 수 있는 다른 계란이 있는지 확인
        boolean canHit = false;
        for (int i = 0; i < N; i++) {
            if (i != pos && eggs[i].durability > 0) {
                canHit = true;
                break;
            }
        }

        // 칠 수 있는 계란이 없으면 그냥 넘어감
        if (!canHit) {
            dfs(pos + 1);
            return;
        }


        for (int target = 0; target < N; target++) {
            //자기자신 못치고 깨진 계란도 못침
            if (target == pos || eggs[target].durability <= 0) continue;

            // 현재 계란과 target 계란 충돌
            eggs[pos].durability -= eggs[target].weight;
            eggs[target].durability -= eggs[pos].weight;

            dfs(pos + 1);

            // 상태 복구 (백트래킹)
            eggs[pos].durability += eggs[target].weight;
            eggs[target].durability += eggs[pos].weight;
        }

    }


    static class Egg {
        int durability;
        int weight;

        Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }

}
