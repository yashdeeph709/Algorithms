String[] allLongestStrings(String[] inputArray) {
       int maxSize=0;
       String maxStrings="";
       for(int i=0;i<inputArray.length;i++){
              if(inputArray[i].length()>maxSize){
                     maxStrings="";
                     maxStrings=inputArray[i];
                     maxSize=inputArray[i].length();
              }else
              if(inputArray[i].length()==maxSize){
                     maxStrings+=","+inputArray[i];
              }
       }
       return maxStrings.split(",");
}
