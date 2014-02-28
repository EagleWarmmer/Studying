package Bages_Queues_Stacks;

import java.util.Stack;

public class DijikstraArithmeticExpression {

	public static double evaluate(String[] s) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		for (String str : s) {
			if (str.equals("("))
				;
			else if (str.equals("+"))
				ops.push(str);
			else if (str.equals("-"))
				ops.push(str);
			else if (str.equals("*"))
				ops.push(str);
			else if (str.equals("/"))
				ops.push(str);
			else if (str.equals("sqrt"))
				ops.push(str);
			else if (str.equals(")")) {
				String op = ops.pop();
				double val = vals.pop();
				if (op.equals("+"))
					val = vals.pop() + val;
				if (op.equals("-"))
					val = vals.pop() - val;
				if (op.equals("*"))
					val = vals.pop() * val;
				if (op.equals("/"))
					val = vals.pop() / val;
				if (op.equals("sqrt"))
					val = Math.sqrt(val);

				vals.push(val);
			} else {
				vals.push(Double.parseDouble(str));
			}
		}
		return vals.pop();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strs[];
		String s = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
		strs = s.split(" ");
		System.out.println(evaluate(strs));

		s = "( ( 1 + ( sqrt ( 5 ) ) / 2 )";
		strs = s.split(" ");
		System.out.println(evaluate(strs));

		s = "( 1 + ( ( 2 * 3 + 4 ) ) )";
		strs = s.split(" ");
		System.out.println(evaluate(strs));
		System.out.println(1 + 2 * 3);
	}
}
