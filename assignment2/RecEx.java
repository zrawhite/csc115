public class RecEx{

	public static int fact(int num, int factorial){
		if (num == 1){
			return factorial;
		} else {
			factorial = factorial*(num-1);
			return fact(num-1, factorial);
		}	
	}
	
	public static int power(int base, int expo){
		
		int num = base;
		for (int i = 0; i < expo; i++){
			num = num*base;
		}
		System.out.println(num);
		
		if (expo == 0){
			return -1;
		} else {
			
			return power(base, expo-1);
		}
	
		
	}
	
	public static void countdown(int num){
		
		System.out.print(num+" ");
		
		//base case
		if (num == 0){
			return;
		}
		
		//reduction step
		countdown(num-1);
		
		System.out.println(num+" ");
		
	}
	
	public int getLength(TaskListNode n){
		
		if (n==null)
			return 0;
			
		return 1+getLength(n.next);
		
	}
	
	public static void main(String[] args){
		
		//int factorial = countdown(11,1);
		//System.out.println(factorial);
		
		//countdown(10);
		int power1 = power(5, 6);
		
	}
}