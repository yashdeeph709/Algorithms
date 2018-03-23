String[] addBorder(String[] picture) {
    int colLen=picture[0].length()+1;
    String corners="";
    for(int i=0;i<=colLen;i++){
        corners+="*";
    }
    String[] pictureNew=new String[picture.length+2];
    pictureNew[0]=corners;
    pictureNew[pictureNew.length-1]=corners;
    int j=1;
    for(int i=0;i<picture.length;i++){
        pictureNew[j]="*"+picture[i]+"*";
        j++;
    }
    return pictureNew;
}
