boolean palindromeRearranging(String inputString) {
    int[] freq=new int[26];
    for(int i=0;i<inputString.length();i++){
        freq[(int)inputString.charAt(i)-97]++;
    }
    int count=0;
    for(int i=0;i<freq.length;i++){
        if(freq[i]%2!=0){
            count++;
        }
    }
    return count>1?false:true;
}
//abbbccca
//abbbbbccccca
//abcddee
//aabbcc-> abccba