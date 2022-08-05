package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Dot{
	int x;
	int y;
	Dot(){ x= 0; y = 0;}
}

public class DotSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Dot[] dotArr = new Dot[N];
		for(int i=0; i<N; i++) {
			dotArr[i] = new Dot();
		}
		
		
		
		for(int i = 0; i< N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dotArr[i].x = Integer.parseInt(st.nextToken());
			dotArr[i].y = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(dotArr, new Comparator<Dot>(){
			public int compare(Dot i1, Dot i2) {
				if(i1.x > i2.x) {
					return 1;
				}
				else if(i1.x == i2.x) {
					if(i1.y > i2.y) {
						return 1;
					}
					else
						return-1;
				}
				else
					return -1;
			}
		});
		
		for(int i = 0; i< N; i++) {
			bw.write(dotArr[i].x + " " + dotArr[i].y + "\n");
		}
		bw.flush();
	}

}
