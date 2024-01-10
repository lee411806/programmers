class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
         StringBuilder sb2 = new StringBuilder();

                    for(int i=0;  i< s.length()  ; i++){
                           sb.append(s.charAt(i));     
                        
                                if(Character.isDigit(s.charAt(i))==true){
                                     sb2.append(s.charAt(i)); 
                                    sb.delete(0, sb.length());
                                }else{
                                    
                                      switch(sb.toString()){
                                        case "one":
                                            sb2.append("1"); 
                                            sb.delete(0, sb.length());
                                            break;
                                        case "two":
                                            sb2.append("2"); 
                                            sb.delete(0, sb.length());
                                            break;
                                        case "three":
                                            sb2.append("3"); 
                                            sb.delete(0, sb.length());
                                            break;
                                        case "four":
                                            sb2.append("4"); 
                                            sb.delete(0, sb.length());
                                            break;
                                        case "five":
                                            sb2.append("5"); 
                                            sb.delete(0, sb.length());
                                            break;
                                        case "six":
                                            sb2.append("6"); 
                                            sb.delete(0, sb.length());
                                            break;
                                        case "seven":
                                            sb2.append("7"); 
                                            sb.delete(0, sb.length());
                                        break;  
                                          case "eight":
                                            sb2.append("8"); 
                                            sb.delete(0, sb.length());
                                        break;  
                                          case "nine":
                                            sb2.append("9"); 
                                            sb.delete(0, sb.length());
                                        break;  
                                          case "zero":
                                            sb2.append("0"); 
                                            sb.delete(0, sb.length());
                                        break;  

                                        default :
                                                
                                            
                                    } 
                                    
                                }
                                    
                                
                                
                                       



                    }

                         answer = Integer.parseInt(sb2.toString());
        
        return answer;
    }
}