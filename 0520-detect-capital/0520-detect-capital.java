class Solution {
     public boolean detectCapitalUse(String word) {
     int uc=0;
     int lc=0; 
     for(char c:word.toCharArray()){ 
    if(Character.isUpperCase(c)) uc++;
     else lc++; }
      if(uc==word.length())
       return true; 
       if(lc==word.length())
        return true;
         if(uc==1&&Character.isUpperCase(word.charAt(0)))
          return true;
           return false; 
           } 
            }