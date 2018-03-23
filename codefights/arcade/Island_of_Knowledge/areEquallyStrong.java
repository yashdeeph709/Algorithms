boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
    int maxmy=yourLeft>yourRight?yourLeft:yourRight;
    int minmy=yourLeft<yourRight?yourLeft:yourRight;
    int maxF=friendsLeft>friendsRight?friendsLeft:friendsRight;
    int minF=friendsLeft<friendsRight?friendsLeft:friendsRight;
    System.out.println(maxF+" "+maxmy+" "+minF+" "+minmy);
    if(maxF==maxmy && minmy==minF){
        return true;
    }else{
        return false;
    }
}
