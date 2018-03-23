int avoidObstacles(int[] inputArray) {
    for(int i=2;i<=40;i++){
        int j;
        for(j=0;j<inputArray.length;j++){
            if(inputArray[j]%i==0){
                break;
            }
        }
        if(j==inputArray.length){
            return i;
        }
    }
    return -1;
}
