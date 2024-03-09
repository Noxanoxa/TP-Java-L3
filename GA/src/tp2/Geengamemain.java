package tp2;

import java.util.Random;
public class Geengamemain {
	static Random r = new Random();
	static String[] probacrom(int taillecrom, int nbgine) {
	int gine;
	String[] crom = new String[taillecrom];
	int[] tst = new int[taillecrom];
	for (int i = 0; i < taillecrom; i++) {
	tst[i] = 10;
	}
	for (int i = 0; i < taillecrom; i++) {
	gine = r.nextInt(7);
	for (int j = 0; j < taillecrom; j++) {
	if (gine == tst[j]) {
	gine = r.nextInt(7);
	j = 0;
	}
	}
	switch (gine) {
	case 0:
	crom[i] = "red";
	break;
	case 1:
	crom[i] = "green";
	break;
	case 2:
	crom[i] = "black";
	break;
	case 3:
	crom[i] = "bleu";
	break;
	case 4:
	crom[i] = "brown";
	break;
	case 5:
	crom[i] = "gray";
	break;
	case 6:
	crom[i] = "pink";
	break;
	}
	tst[i] = gine;
	}
	for (int i = 0; i < taillecrom; i++) {
	System.out.print("[" + crom[i] + "]");
	}
	return crom;
	}
	static int calchit(String t1[], String t2[], int d) {
	int hit = 0;float mis = 0;
	String[] crommis = new String[d];
	for (int i = 0; i < d; i++) {
	if (t1[i] == t2[i]) {
	hit++;
	}else {	for (int j = 0; j < d; j++) {
		if (t1[j] == t2[i]) {
			mis++;
		//mis=mis/2;
			crommis[i] = t2[i];
			}
			}}
	}
	System.out.println("1-------------nbr hit est:"+hit);
	System.out.println("2--------------nbr mis est: "+mis);
	System.out.println("--------- ----------mis------------------");
	/*for (int i = 0; i < d; i++) {
	System.out.print(" :[" + crommis[i] + "]");
	}*/
	mis=mis/2;
	return hit;
	}
	public static void main(String[] args) {
	int tcrom;
	int hit;
	tcrom =  (r.nextInt(3)+1)*2;//ydir taille t3 cromozom zawji
	String[] crom = new String[4];
	crom = probacrom(tcrom, 7);
	System.out.println("----------------------------------------------");
	String[] crom2 = new String[4];                                                                                                                                                      
	crom2 = probacrom(tcrom, 7);
	System.out.println("----------------------------------------------");
	hit = calchit(crom, crom2, tcrom);
	//System.out.println("hit=" + hit);
	}
}