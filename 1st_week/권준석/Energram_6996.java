package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Energram {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i< N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			
			char[] charA = a.toCharArray();
			char[] charB = b.toCharArray();
			
			Arrays.sort(charA);
			Arrays.sort(charB);
			
			String compA = String.valueOf(charA);
			String compB = String.valueOf(charB);
			
			if(compA.equals(compB)) {
				bw.write(a + " & " + b +" are anagrams.\n");
			}
			else {
				bw.write(a + " & " + b +" are NOT anagrams.\n");
			}
		}
		bw.flush();
	}

}
