/*
문제
N개의 단어 -> 1. 길이가 짧은 것 2. 길이가 같으면 사전 순

입력 값
단어의 개수 , 단어

풀이
1. Map<단어의 개수(Integer), 단어(String[])>
2. 사전 순 -> 오름차 순 정렬
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int wordCount = Integer.parseInt(br.readLine());

        Map<Integer, List<String>> map = new HashMap<>();

        //맵에 단어이 길이와 단어의 길이에 따른 리스트 저장
        for (int i = 0; i < wordCount; i++) {
            String word = br.readLine();
            int wordLength = word.length();

            List<String> wordList = map.getOrDefault(wordLength, new ArrayList<>());
            wordList.add(word);
            map.put(wordLength, wordList); // 리스트를 다시 맵에 저장
        }


        // 전부 출력
        // 중복요소 제거해야 함으로 만약 리스트의 크기가 1보다 클 시 set에 넣었다 빼 줌
        // 리스트 오름차순 정렬 후 출력
        int count = 1;
        while (!map.isEmpty()) {
            if (map.containsKey(count)) {
                List<String> wordList = map.get(count);

                if (wordList.size() > 1) {
                    // Set에 리스트의 모든 요소를 추가 (중복 제거)
                    Set<String> set = new HashSet<>(wordList);

                    // Set을 다시 리스트로 변환
                    wordList = new ArrayList<>(set);

                    // 리스트를 정렬
                    Collections.sort(wordList);
                }

                // 리스트의 각 단어를 버퍼 라이터로 출력
                for (String word : wordList) {
                    bw.write(word + "\n");
                }
            }

            map.remove(count);
            count++;

        }

        bw.flush();
        bw.close();

    }

}
