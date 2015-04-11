package week6;

import java.util.Random;

public class Week6SC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		HashTablesSC st = new HashTablesSC();

		st.put("abc", 98989);
		for(int i=0; i<30; i++){
			st.put(RandomChar(), RandomInt());
		}
		st.put("abc", 454545);

		
		System.out.println("abc found ? " +st.get("abc"));
		for(int i=0; i<30; i++){
			String m = RandomChar();
			System.out.println(m + " found ? " +st.get(m));
		}
	}

	public static String RandomChar(){
		Random r = new Random();
		int v = -1;
		while(v<0){
			v = r.nextInt()%26;
		}
		v = v + 65;
		String s = (Character.toString((char)v));
		return s;
	}

	public static int RandomInt(){
		Random r = new Random();
		int v = -1;
		while(v<0){
			v = r.nextInt()%20;
		}
		return v;
	}

	public static int RandomInt(int x){
		Random r = new Random();
		int v = -1;
		while(v<x){
			v = r.nextInt()%30;
		}
		return v;
	}
}
