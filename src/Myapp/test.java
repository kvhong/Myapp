package Myapp;

import java.awt.List;
import java.util.Random;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		Fenshu fenshu = new Fenshu(r.nextInt(10), r.nextInt(10));
		System.out.println(fenshu.getNumerator()+ "/"+fenshu.getDenominator());
//		Expression ex = new Expression();
//		String str = "2 - 2 ¡Á 2 - 2 =";
//		java.util.List<String> list = ex.process(str);
//		java.util.List<String> list2 = ex.simpleTosuffix(list);
//		ex.printList(list2);
//		System.out.println("\n"+ex.count(list2));
//		else if(judge[i].equals("-")) {
//			for(int j=0;j<i;j++) {
//				sbfleft.append(judge[j]);
//			}
//			for(int j=i+1;j<judge.length-1;j++) {
//				sbfright.append(judge[j]);
//			}
//			String left = sbfleft.toString();
//			String right = sbfright.toString();
//			java.util.List<String> listleft = ex.process(left);
//			java.util.List<String> listright = ex.process(right);
//			java.util.List<String> listleft2 = ex.simpleTosuffix(listleft);
//			java.util.List<String> listright2 = ex.simpleTosuffix(listright);
//			int cleft = ex.count(listleft2);
//			int cright = ex.count(listright2);
//			System.out.println(cleft);
//			System.out.println(cright);
	}

}
