package Myapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Myapp {

	public static void main(String[] args) throws IOException {
		while(true) {
			Scanner scanner1;
			System.out.println("������: 1��2 (1.������ʽ;2.У�Դ�)");
			Scanner scanner = new Scanner(System.in);
			String what = scanner.nextLine();
			if(what.equals("1")) {
				build build = new build();
				build.build();
				System.out.println("�Ƿ����: YES or NO");
				scanner1 = new Scanner(System.in);
				String exit = scanner1.nextLine();
				if(exit.equals("YES")) {
					break;
				}
			}else if(what.equals("2")) {
				CorrectandWrong correctandWrong = new CorrectandWrong();
				correctandWrong.CorrectandWrong();
				System.out.println("�Ƿ����: YES or NO");
				scanner1 = new Scanner(System.in);
				String exit = scanner1.nextLine();
				if(exit.equals("YES")) {
					break;
				}
			}else {
				System.out.println("�����������������!");
			}//while����
		}
	}
	

}
