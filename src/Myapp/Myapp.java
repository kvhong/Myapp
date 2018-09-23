package Myapp;

import java.io.IOException;
import java.util.Scanner;

public class Myapp {

	private static Scanner scanner;
	public static void main(String[] args) throws IOException {
		while(true) {
			Scanner scanner1;
			System.out.println("请输入: 1或2 (1.生成算式;2.校对答案)");
			scanner = new Scanner(System.in);
			String what = scanner.nextLine();
			if(what.equals("1")) {
				new build();
				System.out.println("是否结束: YES or NO");
				scanner1 = new Scanner(System.in);
				String exit = scanner1.nextLine();
				if(exit.equals("YES")) {
					break;
				}
			}else if(what.equals("2")) {
				new CorrectandWrong();
				System.out.println("是否结束: YES or NO");
				scanner1 = new Scanner(System.in);
				String exit = scanner1.nextLine();
				if(exit.equals("YES")) {
					break;
				}
			}else {
				System.out.println("输入错误，请重新输入!");
			}//while结束
		}
	}
	

}
