import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class count {
	
	public static int left_operand, right_operand, ov;
	public static String operator;
	public static List list = new ArrayList<>();
	public static List resultlist = new ArrayList<>();
	
	public static void main(String[] args) {
		//������

		printHeader();
		generateEquations();
		printExercise();

	}

	public static void generateEquations() {
		// ����ϰ��
		Random random = new Random();
		for (int i = 0; i < 50; i++) {
			left_operand = random.nextInt(101);
			right_operand = random.nextInt(101);
			ov = random.nextInt(2);
			switch (ov) {
			case 0:
				operator = "+";
				rusultDetection();
				//����ϰ������Χ
				list.add(left_operand + operator + right_operand+ '=');
				resultlist.add(left_operand + right_operand);
				break;
			default:
				operator = "-";
				rusultDetection();
				list.add(left_operand + operator + right_operand + '='); 
				//������Ŀ
				resultlist.add(left_operand - right_operand); 
				//���д�
				break;
			}
		}
	}

	public static void rusultDetection() {
		//������ʽ���,�Ͳ�����100,�С��0
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
		// �����Ŀ
		System.out.println("�������50��100���ڵļӼ�����ʽ��ϰ��:");
	}

	public static void printExercise() {
		// �����ʽ��
		for (int i = 0; i < 50; i++) {
			System.out.print(list.get(i)+"\t");
			if((i+1)%5==0)
				System.out.print("\n");
		}
		System.out.println("������ϰ��Ĵ�:");
		for (int j = 0; j < 50; j++) {
			System.out.print(resultlist.get(j)+"\t");
			if((j+1)%5==0)
				System.out.print("\n");
		}
	}
}