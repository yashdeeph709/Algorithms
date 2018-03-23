int[][] minesweeper(boolean[][] matrix) {
    int[][] result=new int[matrix.length][matrix[0].length];
    for(int row=0;row<matrix.length;row++){
        for(int col=0;col<matrix[row].length;col++){
            result[row][col]=checkForMines(row,col,matrix);
        }
    }
    return result;
}
int checkForMines(int indexRow,int indexCol,boolean[][] matrix){
    int sum=0;
    
    if(indexRow-1>=0 && indexRow-1<matrix.length && indexCol-1>=0 && indexCol-1<matrix[indexRow-1].length){
        sum+=matrix[indexRow-1][indexCol-1]?1:0;
    }
    
    if(indexRow-1>=0 && indexRow-1<matrix.length && indexCol>=0 && indexCol<matrix[indexRow-1].length){
        sum+=matrix[indexRow-1][indexCol]?1:0;
    }
    
    if(indexRow-1>=0 && indexRow-1<matrix.length && indexCol+1>=0 && indexCol+1<matrix[indexRow-1].length){
        sum+=matrix[indexRow-1][indexCol+1]?1:0;
    }
    
    if(indexRow>=0 && indexRow<matrix.length && indexCol-1>=0 && indexCol-1<matrix[indexRow].length){
        sum+=matrix[indexRow][indexCol-1]?1:0;
    }
    
    if(indexRow>=0 && indexRow<matrix.length && indexCol+1>=0 && indexCol+1<matrix[indexRow].length){
        sum+=matrix[indexRow][indexCol+1]?1:0;
    }
    
    if(indexRow+1>=0 && indexRow+1<matrix.length && indexCol-1>=0 && indexCol-1<matrix[indexRow+1].length){
        sum+=matrix[indexRow+1][indexCol-1]?1:0;
    }
    
    if(indexRow+1>=0 && indexRow+1<matrix.length && indexCol>=0 && indexCol<matrix[indexRow+1].length){
        sum+=matrix[indexRow+1][indexCol]?1:0;
    }
    
    if(indexRow+1>=0 && indexRow+1<matrix.length && indexCol+1>=0 && indexCol+1<matrix[indexRow+1].length){
        sum+=matrix[indexRow+1][indexCol+1]?1:0;
    }
    return sum;
}