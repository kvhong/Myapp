package Myapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Scanner;

public class CorrectandWrong {

	void CorrectandWrong() throws IOException {
		System.out.println("�����������ļ���: ");
		Scanner scanner1 = new Scanner(System.in);
		String Exefile = scanner1.nextLine();
		System.out.println("��������ļ���: ");
		Scanner scanner2 = new Scanner(System.in);
		String Ansfile = scanner2.nextLine();
		File exefile = new File(Exefile);
		File ansfile = new File(Ansfile);
		if(exefile.exists()&&ansfile.exists()) {
		InputStreamReader exread = new InputStreamReader(new FileInputStream(Exefile), "GB2312");
		BufferedReader exbr = new BufferedReader(exread);
		InputStreamReader anread = new InputStreamReader(new FileInputStream(Ansfile), "GB2312");
		BufferedReader anbr = new BufferedReader(anread);
		String ex;
		String an;
		String exback = null;
		String anback = null;
		String[] exlist = null;
		String[] anlist = null;
		String[] Exercises = null;
		StringBuffer exercises = new StringBuffer();
		String[] Answers = null;
		StringBuffer answers = new StringBuffer();
		int correctnum = 0;
		int wrongnum = 0;
		StringBuffer correct = new StringBuffer();
		StringBuffer wrong = new StringBuffer();
		while((ex=exbr.readLine())!=null) {
			exlist = ex.split(" ");
			if(exlist[exlist.length-1].equals("=")) {
				exback = "-";
			}else {
				exback = exlist[exlist.length-1];
			}
			exercises.append(exback+",");
		}
		Exercises = exercises.toString().split(",");
		while((an=anbr.readLine())!=null) {
			anlist = an.split(" ");
			anback = anlist[anlist.length-1];
			answers.append(anback+",");
		}
		Answers = answers.toString().split(",");
		for(int i=0;i<Exercises.length;i++) {
			if(Exercises[i].equals(Answers[i])) {
				correct.append(i+1+" ");
				correctnum++;
			}else {
				wrong.append(i+1+" ");
				wrongnum++;
			}
		}
		System.out.println("Correct: "+correctnum+" ( "+correct+")");
		System.out.println("Wrong: "+wrongnum+" ( "+wrong+")");
		NumberFormat nt = NumberFormat.getPercentInstance();
		nt.setMinimumFractionDigits(2);
		double correctpercent = (double) correctnum / (double) Exercises.length;
		double wrongpercent = (double) wrongnum / (double) Exercises.length;
		System.out.println("��ȷ��: "+nt.format(correctpercent));
		System.out.println("������: "+nt.format(wrongpercent));
		exread.close();
		anread.close();
		exbr.close();
		anbr.close();
		}else {
			System.out.println("�Ҳ���ָ���ļ�!");
		}
	}
}
