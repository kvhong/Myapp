package Myapp;

import java.util.StringTokenizer;

public class Fenshu {
	int numerator;  // ����
	int denominator; // ��ĸ
	
	Fenshu(){
	}
 
	Fenshu(int a,int b){
		if(a == 0){
			numerator = 0;
			denominator = 1;
		}else if(b == -1){
			numerator = a;
			denominator = 1;
		}else{
			setNumeratorAndDenominator(a,b);
		}
	}
	
	void setNumeratorAndDenominator(int a, int b){  // ���÷��Ӻͷ�ĸ
		int c = f(Math.abs(a),Math.abs(b));         // �������Լ��
		numerator = a / c;
		denominator = b / c;
		if(numerator<0 && denominator<0){
			numerator = - numerator;
			denominator = - denominator;
		}
	}
	
	int getNumerator(){
		return numerator;
	}
 
	int getDenominator(){
		return denominator;
	}
	
	int f(int a,int b){  // ��a��b�����Լ��
		if(a < b){
			int c = a;
			a = b;
			b = c;
		}
		int r = a % b;
		while(r != 0){
			a = b;
			b = r;;
			r = a % b;
		}
		return b;
	}
	
	Fenshu add(Fenshu r){  // �ӷ�����
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator * b + denominator * a;
		int newDenominator = denominator * b;
		Fenshu result = new Fenshu(newNumerator,newDenominator);
		return result;
	}
	
	Fenshu sub(Fenshu r){  // ��������
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator * b - denominator * a;
		int newDenominator = denominator * b;
		Fenshu result = new Fenshu(newNumerator,newDenominator);
		return result;
	} 
	
	Fenshu muti(Fenshu r){ // �˷�����
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator * a;
		int newDenominator = denominator * b;
		Fenshu result = new Fenshu(newNumerator,newDenominator);
		return result;
	}
	
	Fenshu div(Fenshu r){  // ��������
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator * b;
		int newDenominator = denominator * a;
		Fenshu result = new Fenshu(newNumerator,newDenominator);
		return result;
	}
	
	// �Ƚϴ�С
	public boolean compute(String data1,String data2){
		StringTokenizer fenxi = new StringTokenizer(data1,"/");
	    int data1_1 = Integer.parseInt(fenxi.nextToken());
	    int data1_2;
	    if(fenxi.hasMoreTokens()) {
	    	data1_2 = Integer.parseInt(fenxi.nextToken());
	    }else {
	    	data1_2 = 1;
	    }
	    
		fenxi = new StringTokenizer(data2,"/");
	    int data2_1 = Integer.parseInt(fenxi.nextToken());
	    int data2_2;
	    if(fenxi.hasMoreTokens()) {
	    	data2_2 = Integer.parseInt(fenxi.nextToken());
	    }else {
	    	data2_2 = 1;
	    }
	    
	    	    
	    Fenshu r1 = new Fenshu(data1_1,data1_2);
	    Fenshu r2 = new Fenshu(data2_1,data2_2);
		
	    Fenshu result;
		int a,b;
 			result = r1.sub(r2);
			a = result.getNumerator();
 			b = result.getDenominator();
			if(a < 0) {
				return true;
			}
			return false;
	}
}

