boolean checkPalindrome(String inputString) {
    int length=inputString.length()-1;
    for(int i=inputString.length()-1;i>=0;i--){
        if(inputString.charAt(i)!=inputString.charAt(length-i)){
           return false; 
        }
    }
    return true;
}
