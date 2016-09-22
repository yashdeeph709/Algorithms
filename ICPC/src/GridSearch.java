import java.io.File;
import java.util.Scanner;

public class GridSearch {

	private static Scanner sc;

	public static void main(String[] args) throws Exception {	
			sc = new Scanner(new File("C:\\Users\\c5244128\\Desktop\\HackerZone\\ICPC\\Tests\\GridSearchTestCases"));
			int noOfTestcases=sc.nextInt();
		while(noOfTestcases>0){
			int rowMaster=sc.nextInt();
			int colMaster=sc.nextInt();
			int master[][]=new int[rowMaster][colMaster];
			for(int i=0;i<rowMaster;i++){
				String number=sc.next();
				for(int j=0;j<colMaster;j++){
					master[i][j]=Integer.parseInt(""+number.charAt(j));
				}
			}
			int rowTest=sc.nextInt();
			int colTest=sc.nextInt();
			int test[][]=new int[rowTest][colTest];
			for(int i=0;i<rowTest;i++){
				String number=sc.next();
				for(int j=0;j<colTest;j++){
					test[i][j]=Integer.parseInt(""+number.charAt(j));
				}
			}
			boolean testResult=true;
			Checker:
			for(int i=0;i<rowMaster;i++){
				for(int j=0;j<colMaster;j++){
					if(master[i][j]==test[0][0]){
						testResult=true;
						Checkermax:
						for(int x=0;x<rowTest;x++){
							for(int y=0;y<colTest;y++){
								if(!(i+x>=rowMaster || j+y>=colMaster)){
									if(master[i+x][j+y]==test[x][y]){
										if(x==rowTest-1 && y==colTest-1){
											testResult=false;
											break Checker;
										}
									}else{
										break Checkermax;
									}
								}else{
									break Checkermax;
								}
							}
						}
					}
				}
			}
			if(!testResult){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}

			noOfTestcases--;
		}
	}

}
