int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
    for(int index=0;index<inputArray.length;index++){
        if(inputArray[index]==elemToReplace){
            inputArray[index]=substitutionElem;
        }
    }
    return inputArray;
}
