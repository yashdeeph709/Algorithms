int commonCharacterCount(String s1, String s2) {
    int result=0;
    int[] freqArray1=new int[26];
    int[] freqArray2=new int[26];
    for(int i=0;i<s1.length();i++){
        freqArray1[(int)s1.charAt(i)-97]++;
    }
    for(int i=0;i<s2.length();i++){
        freqArray2[(int)s2.charAt(i)-97]++;
    }
    for(int i=0;i<26;i++){
        if(freqArray1[i]==0 || freqArray2[i]==0)
            continue;
        System.out.println(freqArray1[i]+" "+freqArray2[i]+" "+i);
        if(freqArray1[i]==freqArray2[i]){
            result+=freqArray1[i];
            continue;
        }
        result+=freqArray1[i]>freqArray2[i]?freqArray2[i]:freqArray1[i];
    }
    return result;
}
