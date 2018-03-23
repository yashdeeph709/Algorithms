int[] sortByHeight(int[] a) {
     int length=a.length;
     for(int i=0;i<a.length;i++) {
          int tempMax=-1;
          int tempIndex=-1;
          for(int j=0;j<length;j++){
             if(a[j]>tempMax){
                 tempMax=a[j];
                 tempIndex=j;
             }
          }
          for(int k=a.length-1;k>=0;k--){
               System.out.println("checking pos from last "+k+" "+a[k]);
               if(a[k]!=-1 && tempMax>=a[k]){
                    int t=a[k];
                    a[k]=a[tempIndex];
                    a[tempIndex]=t;
                    length=k-1;
                    break;
               }
          }
          System.out.println("TemMax"+tempMax);
          for(int x=0;x<a.length;x++){
               System.out.print(a[x]+",");
          }
          System.out.println();
     }
     return a;
}
