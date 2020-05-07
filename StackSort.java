import java.util.ArrayList;
import java.util.Stack;

public class StackSort {

	private static Stack<Integer> theStack;
	
	
	public static void main(String[] args) {
		ArrayList<Integer> inp = new ArrayList<Integer>();
		for(int i = 0; i < args.length; i++)
			inp.add(Integer.parseInt(args[i]));
		theStack = new Stack<Integer>();
		System.out.println(inp);
		System.out.println(sort(inp));
	}
	private static ArrayList<Integer> sort(ArrayList<Integer> inp) {
		ArrayList<Integer> sortedArr = new ArrayList<Integer>();
		for(int i = 0; i < inp.size(); i++) {
			System.out.println("Stack at i: " + i + " = " +theStack);
			System.out.println("SortedArr at i: " + i + " = " + sortedArr);
			if(theStack.empty() || inp.get(i) < theStack.peek()) {
				theStack.push(inp.get(i));
			}
			else {
				sortedArr.add(theStack.pop());
				if(!theStack.empty()) {
					while(!theStack.empty() && inp.get(i) > theStack.peek()) {
						sortedArr.add(theStack.pop());
					}
				}
				theStack.add(inp.get(i));
			}
			System.out.println("Stack at i: " + i + " = " +theStack);
			System.out.println("SortedArr at i: " + i + " = " + sortedArr);

		}
		System.out.println(" ** Done with first for loop");
		int cnt = 0;
		while(!theStack.empty()) {
			sortedArr.add(theStack.pop());
			System.out.println("Stack at i: " + cnt + " = " +theStack);
			System.out.println("SortedArr at i: " + cnt + " = " + sortedArr);
			cnt++;
		}
		if(theStack.size() > 0 || sortedArr.size() != inp.size()) {
			System.out.println("FUCK");
		}
		return sortedArr;
	}
}

