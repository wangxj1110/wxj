import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class count {
	
	public static int left_operand, right_operand, ov;
	public static String operator;
	public static List list = new ArrayList<>();
	public static List resultlist = new ArrayList<>();
	
	public static void main(String[] args) {
		//主函数

		printHeader();
		generateEquations();
		printExercise();

	}

	public static void generateEquations() {
		// 生成习题
		Random random = new Random();
		for (int i = 0; i < 50; i++) {
			left_operand = random.nextInt(101);
			right_operand = random.nextInt(101);
			ov = random.nextInt(2);
			switch (ov) {
			case 0:
				operator = "+";
				rusultDetection();
				//检验习题结果范围
				list.add(left_operand + operator + right_operand+ '=');
				resultlist.add(left_operand + right_operand);
				break;
			default:
				operator = "-";
				rusultDetection();
				list.add(left_operand + operator + right_operand + '='); 
				//所有题目
				resultlist.add(left_operand - right_operand); 
				//所有答案
				break;
			}
		}
	}

	public static void rusultDetection() {
		//检验算式结果,和不大于100,差不小于0
		Random random1 = new Random();
		switch (operator) {
		case "+":
			while (left_operand + right_operand > 100) {
				left_operand = random1.nextInt(101);
				right_operand = random1.nextInt(101);
				if (left_operand + right_operand <= 100) {

				}
			}
			break;
		default:
			while (left_operand - right_operand < 0) {
				left_operand = random1.nextInt(101);
				right_operand = random1.nextInt(101);
				if (left_operand - right_operand >= 0) {
					break;
				}
			}
			break;
		}
	}

	public static void printHeader() {
		// 输出题目
		System.out.println("程序输出50道100以内的加减法算式的习题:");
	}

	public static void printExercise() {
		// 输出算式答案
		for (int i = 0; i < 50; i++) {
			System.out.print(list.get(i)+"\t");
			if((i+1)%5==0)
				System.out.print("\n");
		}
		System.out.println("下面是习题的答案:");
		for (int j = 0; j < 50; j++) {
			System.out.print(resultlist.get(j)+"\t");
			if((j+1)%5==0)
				System.out.print("\n");
		}
	}
}