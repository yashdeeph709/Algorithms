boolean almostIncreasingSequence(int[] sequence) {
    int length=sequence.length-1,i=-1,j=-1;
    for(i=0;i<length;i++){
       if(sequence[i]>=sequence[i+1]){
           break;
       }
    }
    if(i==length) return true;
    for(j=length;j>0;j--){
       if(sequence[j]<=sequence[j-1]){
           break;
       }
    }
    return i+1==j && 
        (j>=length 
         || sequence[i]<sequence[j+1] 
         || i==0
         || sequence[i-1]<sequence[j]);
}
    