boolean evenDigitsOnly(int n) {
    while(n/10>0){
        if((n%10)%2!=0){
            return false;
        }
        n/=10;
    }
    if(n%2!=0){
        return false;
    }
    return true;
}
