class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int GCD=1; 
        int LCM = 0;
        int multiple = m * n;
        int temp=0;
        
            if(n>m){
                temp = n;
                n = m; 
                m = temp;
            }
                       	
            			
            			while(n>0) {
            				 GCD = m % n;
            				 if(GCD==0)break;
            				 m=n;
            				 n=GCD;
            			}
            
            			System.out.println(n);	
            
                       
                            LCM = multiple / n ; 
                       System.out.println(LCM);
                            
                                answer[0] = n;
                                answer[1] = LCM;


        
        
        return answer;
    }
}