class Solution {
    public int solution(int[] numbers, int target) {
      return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int index, int sum) {
    if (index == numbers.length) {
        return sum == target ? 1 : 0;
    }
    return dfs(numbers, target, index + 1, sum + numbers[index]) + 
           dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}