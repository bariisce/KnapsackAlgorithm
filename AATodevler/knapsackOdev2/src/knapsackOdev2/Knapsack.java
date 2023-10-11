package knapsackOdev2;

public class Knapsack {
	public int knapsack(int W, int[] nesneAgirligi, int[] degerler, int n) {
		int[][] k = new int[n+1][W+1];
		
		for(int i=1;i<=n;i++) {
			for(int w=1;w<=W;w++) {
				if(nesneAgirligi[i-1]<=w) {
					k[i][w]=Math.max(degerler[i - 1] + k[i - 1][w - nesneAgirligi[i - 1]], k[i - 1][w]);
				}
				else {
					k[i][w]=k[i-1][w];
				}
			}
		}
		int enBuyukDeger = k[n][W];
        int bosYer = W;
        int[] secilenNesneler = new int[n];
        for (int i = n; i > 0 && enBuyukDeger > 0; i--) {
            if (enBuyukDeger != k[i - 1][bosYer]) {
                secilenNesneler[i - 1] = 1;
                enBuyukDeger -= degerler[i - 1];
                bosYer -= nesneAgirligi[i - 1];
            }
        }
        System.out.println("Knapsack kapasitesi: " + W);
        System.out.println("Eşya sayısı: " + n);
        System.out.println("Seçilen eşyaların ağırlıkları ve değerleri:");
        for (int i = 0; i < n; i++) {
            if (secilenNesneler[i] == 1) {
                System.out.println(" Değer: " + degerler[i] + "  Ağırlık: " + nesneAgirligi[i]);
            }
        }
		return k[n][W];
		
	}
}
