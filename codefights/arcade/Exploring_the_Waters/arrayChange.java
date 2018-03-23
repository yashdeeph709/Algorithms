int arrayChange(int[] inputArray) {
    int moves=0;
    for(int i=1;i<inputArray.length;i++){
        if(inputArray[i-1]>=inputArray[i]){
            int diff=inputArray[i-1]-inputArray[i];
            inputArray[i]+=diff+1;
            moves+=diff+1;
            System.out.println(moves);
        }
    }
    return moves;
}
