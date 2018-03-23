String alphabeticShift(String inputString) {
    String result="";
    for(int i=0;i<inputString.length();i++){
        int charCode=(int)inputString.charAt(i);
        if(charCode-(int)'a'==25){
            result+='a';
        }else{
            result+=(char)(++charCode);
        }
    }
    return result;
}
