package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class NumberSort4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(numbers);

		int oldInt=0;
		for(int i= N-1;  i >=0 ; i--) {
			if(oldInt != numbers[i]) {
				wr.write(numbers[i] + "\n");
			}
			oldInt = numbers[i];
		}
		wr.flush();
	}

}
