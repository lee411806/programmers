class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int count = 0 ;
        int MaxHealth = health;
        int time = 1;
     
        for(int i = 0; i<attacks.length; i++){          
            for(int j = time; j <= attacks[i][0]; j++){
                time++;
                count++;          
                
                if(j == attacks[i][0]){
             
   
                  health =   health - attacks[i][1];
                  count = 0;
           if(count == 0 ){
           }
                    if(health < 1 ){
                        return -1;
                    }else if(i == attacks.length - 1){
                        answer = health;  
                        return answer;
                    }
                                        
                }   
               
           
            if(count > 0){
            health = health + bandage[1];            
                if(count == bandage[0]){
                health = health + bandage[2];            
                count = 0;
                }
                if(health > MaxHealth){
                    health = MaxHealth;
                }
            }
                
                
            }            
     answer = health;           
        }
        return answer;
    }
}