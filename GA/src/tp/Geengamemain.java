package tp;

import java.util.Random;

public class Geengamemain {
    static Random r = new Random();

    public static void main(String[] args) {
        int tcrom;
        int hit;
        tcrom = (r.nextInt(3) + 1) * 2; // randomly generate a chromosome size
        String[] crom = probacrom(tcrom, 7); // generate a chromosome
        System.out.println("----------------------------------------------");
        String[] crom2 = probacrom(tcrom, 7); // generate a second chromosome
        System.out.println("----------------------------------------------");
        hit = calchit(crom, crom2, tcrom); // compare the two chromosomes
        System.out.println("hit=" + hit); // print the number of matches
    }

    static String[] probacrom(int taillecrom, int nbgine) {
        int gine;
        String[] crom = new String[taillecrom];
        int[] tst = new int[taillecrom];
        for (int i = 0; i < taillecrom; i++) {
            tst[i] = 10;
        }
        for (int i = 0; i < taillecrom; i++) {
            gine = r.nextInt(nbgine);
            for (int j = 0; j < taillecrom; j++) {
                if (gine == tst[j]) {
                    gine = r.nextInt(nbgine);
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
                    crom[i] = "blue";
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
        int hit = 0;
        float mis = 0;
        String[] crommis = new String[d];
        for (int i = 0; i < d; i++) {
            if (t1[i].equals(t2[i])) {
                hit++;
            } else {
                for (int j = 0; j < d; j++) {
                    if (t1[j].equals(t2[i])) {
                        mis++;
                        crommis[i] = t2[i];
                    }
                }
            }
        }
        System.out.println("1-------------nbr hit est:" + hit);
        System.out.println("2--------------nbr mis est: " + mis / 2);
        System.out.println("--------- ----------mis------------------");
        for (int i = 0; i < d; i++) {
            System.out.print(" :[" + crommis[i] + "]");
        }
        return hit;
    }
    
    	
}
