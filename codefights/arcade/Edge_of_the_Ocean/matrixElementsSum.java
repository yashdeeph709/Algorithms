int matrixElementsSum(int[][] matrix) {
    int result=0;
    int columnSize=matrix[0].length;
    for(int i=0;i<columnSize;i++){
        for(int j=0;j<matrix.length;j++){
            if(matrix[j][i]==0){
               break; 
            }else{
               result+=matrix[j][i];
            }
        }
    }
    return result;
}
