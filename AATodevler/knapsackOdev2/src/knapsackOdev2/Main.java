package knapsackOdev2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		long kodunBaslangicZamani = System.currentTimeMillis();
		Knapsack ks = new Knapsack();
		
		File file = new File("ks_200_0.txt");
		Scanner scan = new Scanner(file);
		
		int W = scan.nextInt();
		int n = scan.nextInt();
		
		int[] nesneAgirligi = new int[n];
		int[] degerler = new int[n];
		
		for(int i=0;i<n;i++) {
			degerler[i] = scan.nextInt();
			nesneAgirligi[i] = scan.nextInt();
		}
		scan.close();
		
		System.out.println("Toplam En Yüksek Değer: " + ks.knapsack(W, nesneAgirligi, degerler, n));
		long kodunBitisZamani=System.currentTimeMillis();
		long sure = kodunBitisZamani-kodunBaslangicZamani;
		System.out.println(sure);
    }
}

/*
 //10000 boyutlu dosya için
 Dinamik Programlama ile bellek alanı sorunu yaşandı. Greedy ve Paralel Programlama Yaklaşımları denendi fakat başarılı olunamadı !!
 package knapsackOdev2;
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Esya implements Comparable<Esya> {
    int _agirlik;
    int _deger;
    double _birimDeger;

    public Esya(int agirlik, int deger) {
        _agirlik = agirlik;
        _deger = deger;
        _birimDeger = (double) deger / agirlik;
    }

    @Override
    public int compareTo(Esya e) {
        return Double.compare(e._birimDeger, _birimDeger);
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
    long kodunBaslangicZamani = System.currentTimeMillis();
        List<Esya> esyalar = new ArrayList<>();
        int W = 0;

        BufferedReader br = new BufferedReader(new FileReader("ks_10000_0.txt"));
        String satir = br.readLine();
        String[] degerler = satir.split(" ");

            int n = Integer.parseInt(degerler[1]);
            for (int i = 0; i < n; i++) {
                satir = br.readLine();
                degerler = satir.split(" ");
                int agirlik = Integer.parseInt(degerler[0]);
                int deger = Integer.parseInt(degerler[1]);
                esyalar.add(new Esya(agirlik, deger));
            }

            W = Integer.parseInt(degerler[0]);

        Collections.sort(esyalar);
        int enYuksekDeger = knapsack(esyalar, W);
        System.out.println("Toplam En Yüksek Değer: " + enYuksekDeger);
        long kodunBitisZamani=System.currentTimeMillis();
		long sure = kodunBitisZamani-kodunBaslangicZamani;
		System.out.println(sure);
    }

    public static int knapsack(List<Esya> esyalar, int W) {
        int toplamDeger = 0;
        int bosYer = W;

        for (Esya _esya : esyalar) {
            if (_esya._agirlik <= bosYer) {
                toplamDeger += _esya._deger;
                bosYer -= _esya._agirlik;
            } 
        }

        return toplamDeger;
    }
}
*/