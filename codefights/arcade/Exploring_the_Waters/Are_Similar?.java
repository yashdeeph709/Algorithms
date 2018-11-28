boolean areSimilar(int[] a, int[] b) {
    int count=0;
    int[] freq1=new int[1001];
    int[] freq2=new int[1001];
    for(int i=0;i<a.length;i++){
        freq1[a[i]]++;
        freq2[b[i]]++;
        if(a[i]!=b[i]){
            count++;
        }
    }
    for(int i=0;i<freq1.length;i++){
        if(freq1[i]!=freq2[i]){
            return false;
        }
    }
    return count>2?false:true;
}
//2 2 1 3 4 5 2
//2 1 2 3 4 5 2