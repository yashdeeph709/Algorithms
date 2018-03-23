int adjacentElementsProduct(int[] inputArray) {
    int largest=Integer.MIN_VALUE;
    for(int i=0;i<inputArray.length-1;i++){
       if(inputArray[i]*inputArray[i+1]>largest){
           largest=inputArray[i]*inputArray[i+1];
       } 
    }
    return largest;
}