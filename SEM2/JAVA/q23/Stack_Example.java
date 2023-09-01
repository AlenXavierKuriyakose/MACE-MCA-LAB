import java.util.Stack;

	public class Stack_Example{
	
		public static void main(String a[]){

			Stack<Integer> stk=new Stack<>();
			

				boolean res=stk.empty();//empty() function in Java returns true if the stack is empty; otherwise, it returns false 

				System.out.println("Is Stack empty= "+ res);
			
				
				stk.push(45);// used to insert value in a stack

				stk.push(56);

			System.out.println("Elements of stack= "+stk);
			
			res=stk.empty();

			System.out.println("Is Stack empty= "+ res);

				Integer x=(Integer)stk.pop();//Value is deleted from stack

			System.out.println("The value poped from stack is= "+ x);

				
			stk.push(90);

			System.out.println("Elements of stack= "+stk);

			 x=(Integer)stk.pop();

			System.out.println("The value poped from stack is= "+ x);
			
			 x=(Integer)stk.pop();

			System.out.println("The value poped from stack is= "+ x);

			res=stk.empty();
			
			System.out.println("Is Stack empty= "+ res);

	}
}
