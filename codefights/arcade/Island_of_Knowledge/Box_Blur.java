int[][] boxBlur(int[][] image) {
    int length=image.length;
    int[][] boxBlurred=new int[image.length-2][image[0].length-2];
    for(int i=0;i<=length-3;i++){
        for(int j=0;j<=image[0].length-3;j++){
            boxBlurred[i][j]=determinant(i,j,image)/9;
//            System.out.println(determinant(i,j,image)/9);
        }
    }
    return boxBlurred;
}
int determinant(int startIndexRow,int startIndexCol,int[][] image){
    int determinant=0;
    System.out.println("Going from "+startIndexRow+" to "+(startIndexRow+3)+" and col "+startIndexCol+" to "+(startIndexCol+3));
    for(int row=startIndexRow;row<startIndexRow+3;row++){
        for(int col=startIndexCol;col<startIndexCol+3;col++){
            determinant+=image[row][col];
        }
    }
    return determinant;
}