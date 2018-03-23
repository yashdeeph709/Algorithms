/*
 * implementation: go through each and every element and compare it with its neighbours and check the
 * diff with the global maxima.
 */
int arrayMaximalAdjacentDifference(int[] inputArray) {
    int max=0;
    for(int i=1;i<inputArray.length-1;i++){
        int localmaxBack=inputArray[i]>inputArray[i-1]?inputArray[i]-inputArray[i-1]:inputArray[i-1]-inputArray[i];
        int localmaxForward=inputArray[i]>inputArray[i+1]?inputArray[i]-inputArray[i+1]:inputArray[i+1]-inputArray[i];
        if(localmaxBack>max){
            max=localmaxBack;
        }
        if(localmaxForward>max){
            max=localmaxForward;
        }
    }
    return max;
}
