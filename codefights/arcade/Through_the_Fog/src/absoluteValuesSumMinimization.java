int absoluteValuesSumMinimization(int[] a) {
    int size=a.length;
    return size%2==0?a[size/2-1]:a[size/2];
}
