boolean chessBoardCellColor(String cell1, String cell2) {
    int row1=(int)(cell1.split("")[0].charAt(0))-65;
    int col1=Integer.parseInt(cell1.split("")[1]);
    int row2=((int)cell2.split("")[0].charAt(0))-65;
    int col2=Integer.parseInt(cell2.split("")[1]);
    if(getColor(row1,col1)==getColor(row2,col2)){
        return true;
    }
    return false;
}
int getColor(int row,int col){
    if(row%2==0){
        return col%2==0?1:0;
    }else{
        return col%2==0?0:1;
    }
}