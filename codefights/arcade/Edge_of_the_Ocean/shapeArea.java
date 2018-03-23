int shapeArea(int n) {
    if(n==1 || n==0){
        return n;
    }
    int result=2;
    int level=3;
    int i=2;
    while(i<n){
        result+=2*level;
        level+=2;
        i++;
    }
    result+=level;
    return result;
}
