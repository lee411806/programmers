class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
        
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int[] arr2 = new int[10];
          
            for(int i=0 ; i<10; i++){
                for(int j=0; j<numbers.length ;j++){
                    if(arr[i]==numbers[j]){
                        arr2[i] = arr[i]; 
                        break;
                    }else{
                        arr2[i] = 0;
                    }
                }
            }           
                            int sum=0;
                            for(int i=0 ; i<10 ;i++){
                                if(arr2[i] != i){
                                    sum +=arr[i];
                                }
                            }
                    
        
        
        return sum;
    }
}