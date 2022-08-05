package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoSolution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int[] solutions = new int[N];
		for(int i=0; i< N; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(solutions);
		int end = N-1; int start = 0;
		int min = Integer.MAX_VALUE;
		int min1=solutions[start], min2=solutions[end]; //용액을 값 두개를 가질 변수들
		while(end > start) {
			if(min > Math.abs(solutions[end] + solutions[start])) {
				min = Math.abs(solutions[end] + solutions[start]);
				min1 = solutions[start];
				min2 = solutions[end];
			}
			if(Math.abs(solutions[end]) > Math.abs(solutions[start])) {
				end--;
			}
			else {
				start++;
			}
		}
		bw.write(min1 + " " + min2);
		bw.flush();
	}

}
