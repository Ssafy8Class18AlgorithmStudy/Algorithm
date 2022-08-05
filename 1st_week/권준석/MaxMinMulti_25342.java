package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MaxMinMulti {
	
	public static long gcd(long p, long q) {//유클리드 호제법으로 구한 최대 공약수
		if(q==0) return p;
		return gcd(q, p%q);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <=T ; test_case++) {
			int N = Integer.parseInt(br.readLine());
			long max = 0;
			
			for(int topNum = N; topNum >= N-1; topNum--) 
			{
				for(int i = topNum-1; i >= topNum-2 ; i--) {
					long mul = (long)topNum * (long)i / gcd(topNum,i);
					for(int j = i-1; j >= i-2 && j > 0; j--) {
						long g = gcd(mul,j);
						if(max < ((long)mul / (long)g) * ((long)j) ) {
							max = ((long)mul / (long)g) * ((long)j);
						}
						if(g==1) {
							break;
						}
					}
				}
			}
			bw.write(max + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
