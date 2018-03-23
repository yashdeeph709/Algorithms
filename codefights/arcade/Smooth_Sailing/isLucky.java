boolean isLucky(int n) {
    int numberOfDigits=0;
    if(n<=99){
       numberOfDigits=2; 
       if(n%10==(n/10)){
           return true;
       }else{
           return false;
       }
    }
    if(n<=9999 && n>99){
        numberOfDigits=4;
        int firstPiece=n%100;
        int secondPiece=n/100;
        int FirstSum=firstPiece%10+firstPiece/10;
        int secondSum=secondPiece%10+secondPiece/10;
        if(FirstSum==secondSum){
            return true;
        }else{
            return false;
        }
    }
    if(n<=999999 && n>9999){
        numberOfDigits=6;
        int firstPiece=n%1000;
        int secondPiece=n/1000;
        int FirstSum=(firstPiece%10)+(firstPiece/10)%10+(firstPiece/100);
        int secondSum=(secondPiece%10)+(secondPiece/10)%10+(secondPiece/100);
        System.out.println(firstPiece+" "+ secondPiece+" "+FirstSum+" "+secondSum);
        if(FirstSum==secondSum){
            return true;
        }else{
            return false;
        }
    }
    return false;
}
