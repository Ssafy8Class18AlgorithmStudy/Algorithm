package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RockGame {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[] isWin = new boolean[N+4];
		isWin[1] = false;	//돌이 하나남으면 패배
		isWin[2] = true;	//돌이 두개남으면 승리
		isWin[3] = false;	//돌이 세개남으면 패배
		isWin[4] = true;	//돌이 네개남으면 승리
		
		for(int i= 5; i<= N; i++) {
			//상대가 돌을 하나 가져가거나 세개 가져가거나 네개 가져가서 내가 패배하는 돌을 만들면 패배
			if(isWin[i-1] && isWin[i-3] && isWin[i-4]) {
				isWin[i] = false;
			}
			else {
				isWin[i] = true;
			}
		}
		
		if(isWin[N]) {
			System.out.print("SK");
		}else {
			System.out.print("CY");
		}
	}

}
