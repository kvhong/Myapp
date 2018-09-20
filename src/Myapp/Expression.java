package Myapp;

import java.util.*;
public class Expression {
 
	public char[] op = {'+','-','��','��','(',')'};
	public String[] strOp = {"+","-","��","��","(",")"};
	public boolean isDigit(char c){
		if(c>='0'&&c<='9'){
			return true;
		}
		return false;
	}
	public boolean isOp(char c){
		for(int i=0;i<op.length;i++){
			if(op[i]==c){
				return true;
			}
		}
		return false;
	}
	public boolean isOp(String s){
		for(int i=0;i<strOp.length;i++){
			if(strOp[i].equals(s)){
				return true;
			}
		}
		return false;
	}
	public boolean isFenshu(char c) {
		if(c=='/') {
			return true;
		}
		return false;
	}
	
	//��������ļ���ʽ
	public List<String> process(String str){
		List<String> list = new ArrayList<String>();
		char c;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();i++){
			c = str.charAt(i);
			if(isDigit(c)||isFenshu(c)){
				sb.append(c);
				
			}
//			if(isFenshu(c)) {
//				c='��';
//			}
			if(isOp(c)){
				if(sb.toString().length()>0){
					list.add(sb.toString());
					sb.delete(0, sb.toString().length());
				}
				list.add(c+"");
			}
		}
		if(sb.toString().length()>0){
			list.add(sb.toString());
			sb.delete(0, sb.toString().length());
		}
		return list;
	}
	public void printList(List<String> list){
		for(String o:list){
			System.out.print(o+" ");
		}
	}
	
	//һ�����ʽת��Ϊ��׺����ʽ
	public List<String> simpleTosuffix(List<String> list){
		List<String> Postfixlist = new ArrayList<String>();//��ź�׺����ʽ
		Stack<String> stack = new Stack<String>();//�ݴ������
		for(int i=0;i<list.size();i++){
			
			String s = list.get(i);
			if(s.equals("(")){
				stack.push(s);
			}else if(s.equals("��")||s.equals("��")){
				stack.push(s);
			}else if(s.equals("+")||s.equals("-")){
				if(!stack.empty()){
					while(!(stack.peek().equals("("))){
						Postfixlist.add(stack.pop());
						if(stack.empty()){
							break;
						}
					}
					stack.push(s);
				}else{
					stack.push(s);
				}
			}else if(s.equals(")")){
				while(!(stack.peek().equals("("))){
					Postfixlist.add(stack.pop());
				}
				stack.pop();
			}else{
				Postfixlist.add(s);
			}
			if(i==list.size()-1){
				while(!stack.empty()){
					Postfixlist.add(stack.pop());
				}
			}
		}
		return Postfixlist;
	}
	
	//��׺����ʽ����
	public Fenshu count(List<String> list){
		Stack<Fenshu> stack = new Stack<Fenshu>();
		for(int i=0;i<list.size();i++){
			String s = list.get(i);
			if(!isOp(s)){
				Fenshu fenshu;
				StringTokenizer tokenizer = new StringTokenizer(s, "/");
				int numerator = Integer.parseInt(tokenizer.nextToken());
				if(tokenizer.hasMoreTokens()) {
					int denominator = Integer.parseInt(tokenizer.nextToken());
					fenshu = new Fenshu(numerator, denominator);
				}else {
					fenshu = new Fenshu(numerator, -1);
				}
				stack.push(fenshu);
			}else{
				if(s.equals("+")){
					Fenshu a1 = stack.pop();
					Fenshu a2 = stack.pop();
					Fenshu v = a2.add(a1);
					stack.push(v);
				}else if(s.equals("-")){
					Fenshu a1 = stack.pop();
					Fenshu a2 = stack.pop();
					Fenshu v = a2.sub(a1);
					stack.push(v);
				}else if(s.equals("��")){
					Fenshu a1 = stack.pop();
					Fenshu a2 = stack.pop();
					Fenshu v = a2.muti(a1);
					stack.push(v);
				}else if(s.equals("��")){
					Fenshu a1 = stack.pop();
					Fenshu a2 = stack.pop();
					Fenshu v = a2.div(a1);
					stack.push(v);
				}
			}
		}
		return stack.pop();
	}
}