int makeArrayConsecutive2(int[] statues) {
    ArrayList<Integer> list=new ArrayList<Integer>();
    for(int i=0;i<statues.length;i++){
        list.add(statues[i]);
    }
    Collections.sort(list);
    int result=0;
    for(int i=1;i<list.size();i++){
        int diff=(list.get(i)-list.get(i-1));
        result+=diff-1;
    }
    return result;
}
