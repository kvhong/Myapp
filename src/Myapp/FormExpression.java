package Myapp;

import java.util.Random;

public class FormExpression {

	String FormExpression(int size , int operatenum) {
		Random r = new Random();
		String[] operate = {"+","-","��","��"};
		StringBuffer str = new StringBuffer();
		StringBuffer strnew = new StringBuffer();
		int num;
		int numerator;
		int denominator;
		String oper;
		Fenshu fenshu;
		int divcount = 0;
		int subcount = 0;
		String[] numlist = new String[operatenum+1];
		String[] operlist = new String[operatenum];
		for(int i=0;i<operatenum;i++) {
			oper=operate[r.nextInt(4)];
			operlist[i]=oper;
			if(oper.equals("��")) {
				divcount++;
			}
			if(oper.equals("-")) {
				subcount++;
			}
		}
		
		for(int i=0;i<operatenum+1;i++) {
			if(divcount==0) {
				num=r.nextInt(size);
				numerator = r.nextInt(size);
				denominator = r.nextInt(size);
			}else {
				num=r.nextInt(size)+1;
				numerator = r.nextInt(size)+1;
				denominator = r.nextInt(size)+1;
			}
			if(denominator!=0&&numerator<=denominator) {
			fenshu = new Fenshu(numerator,denominator);
			}else {
				fenshu = new Fenshu(denominator, numerator);
			}
			numlist[i]=randominput(num, fenshu);
		}
		
		for(int i=0;i<2*operatenum+1;i++) {
			if(i%2==0) {
				str.append(numlist[i/2]+" ");
			}
			if(i%2!=0) {
				str.append(operlist[(i-1)/2]+" ");
			}
		}
		str.append("="+" ");
		
		String[] judge = str.toString().split(" ");
		for(int j=0;j<subcount;j++) {
			for(int i=0;i<judge.length;i++) {
				if(judge[i].equals("-")) {
					Fenshu fs = new Fenshu();
					if(fs.compute(judge[i-1], judge[i+1])) {
						String temp=judge[i+1];
						judge[i+1]=judge[i-1];
						judge[i-1]=temp;
					}
				}
			}
		}
//		for(int i=judge.length-1;i>=0;i-=2) {
//			if(judge[i].equals("��")) {
//				if(judge[i+1].equals("0")||judge[i+1].startsWith("0")) {
//					String temp=judge[i+1];
//					judge[i+1]=judge[i-1];
//					judge[i-1]=temp;
//				}
//			}
//			if(judge.length>=6&&i>=2) {
//				if(judge[i].equals("��")&&judge[i-2].equals("��")) {
//					if(judge[i+1].equals("0")||judge[i+1].startsWith("0")) {
//						String temp=judge[i+1];
//						judge[i+1]=judge[i-3];
//						judge[i-3]=temp;
//					}else if(judge[i-1].equals("0")||judge[i-1].startsWith("0")) {
//						String temp=judge[i-1];
//						judge[i-1]=judge[i-3];
//						judge[i-3]=temp;
//					}
//				}
//			}
//		}
		for(int i=0;i<judge.length;i++) {
			strnew.append(judge[i]+" ");
		}
		
		return strnew.toString();
	}
	String randominput(int num,Fenshu fenshu) {
		String numstr = num+"";
		String fenshustr = fenshu.getNumerator() +"/"+fenshu.getDenominator();
		String[] strlist = {numstr , fenshustr};
		Random r = new Random();
		return strlist[r.nextInt(2)].toString();
	}
}