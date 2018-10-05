import java.util.Scanner;
import java.lang.Math;
import java.util.*;
import java.io.*;
public class Test {
    
	public static void main(String[] args) {
		String s = "";
		s = s.trim();
		System.out.println(s.length());
		String[] a = s.split(" ");
		System.out.println(a.length);
	}
}

class A{
        A(){
            // foo();
            // System.out.println("Created A");
	}
        void foo(){
        	System.out.println("This is A");
        }

}
class B extends A{
        B(){
                        foo();
                        System.out.println("Created B");
	}
        void foo(){
        	System.out.println("This is B");
        }
}

/*
	A1 A2 A3 A4

	M[i] represents the combination of first i numbers
	M[2] = 1
	M[i] = M[i - 1] + M[i - 2] + .. + M[2]


	15 * 5 * 10 + 15 * 10 * 20
	5 * 10 * 20 + 15 * 5 * 20

	[i, j] [j, k] [k, l]

	i * j * k + i * k * l

	j * k * l + i * j * l

	subtract: 
	k * j * (l - i) + i * l * (j - k)


	assume k = j + m
	j * k * l + i * j * l = j^2 * l + j * m * l + i * j * l

	i * j * k + i * k * l = j^2 * i + j * m * i + i * j * l + m * i * l	

*/	