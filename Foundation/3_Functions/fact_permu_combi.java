import java.util.Scanner;
public class fact_permu_combi {
	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		int n = scn.nextInt();
		int r = scn.nextInt();
		//Integer representing n!
		int resultFact=fact(n);
		System.out.println("representing n! -> "+resultFact);


		//nteger representing npr
		if (r > n) {
    System.out.println("Invalid input: r cannot be greater than n");
    return;
}

		int b=fact(n-r);
		int resultPermu =resultFact/b;
		System.out.println("representing npr -> "+resultPermu);


		//"Integer representing ncr"
		int a=fact(r);
		int resultcombi= resultFact/(a*b);
		System.out.println("representing ncr -> "+resultcombi);



	}
	public static int fact(int n ){
		int ans =1;
		for(int i =1; i<=n ;i++){
			ans=ans*i;
		}
		return ans ;
	}
}