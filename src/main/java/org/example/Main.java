package org.example;

import java.util.*;

public class Main {

    /**
     * Müşteri Destek Temsilcisi Yönlendirme:
     * Her müşteriye, kullanılmayan temsilcilerden biri atanarak toplam uygunluk skorunun maksimize edilmesi amaçlanır.
     *
     * Algoritma:
     * - score[i][j] : i. müşteri için j. temsilcinin uygunluk skoru.
     * - n : müşteri sayısı, m : temsilci sayısı.
     * - dp[mask] : mask (m bitlik) ile temsilcilerden hangilerinin kullanıldığını tutarak, 
     *   count(mask) müşteri atandığında elde edilen maksimum toplam skor.
     *
     * Karmaşıklık: O(2^m * m). (m küçükse uygulanabilir)
     */
    public static int assignRepresentatives(int[][] score) {
        int n = score.length;         // Müşteri sayısı
        int m = score[0].length;      // Temsilci sayısı
        int size = 1 << m;            // 2^m durum
        int[] dp = new int[size];
        // Tüm durumları başlangıçta negatif sonsuz değere (min) atıyoruz.
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0; // Hiç temsilci atanmamış durumda skor 0

        // Her mask durumunu gezerek, atama yapıyoruz.
        for (int mask = 0; mask < size; mask++) {
            // mask'de kaç temsilci kullanıldıysa, o kadar müşteri ataması yapılmıştır.
            int i = Integer.bitCount(mask);
            if (i >= n) continue; // Tüm müşterilere atama yapılmışsa atla.

            // i. müşteriye atamak için henüz kullanılmamış tüm temsilcileri deneyelim.
            for (int j = 0; j < m; j++) {
                if ((mask & (1 << j)) == 0) { // temsilci j kullanılmamışsa
                    int newMask = mask | (1 << j);
                    dp[newMask] = Math.max(dp[newMask], dp[mask] + score[i][j]);
                }
            }
        }

        // Sonuç: dp[mask] değerleri arasında, tam olarak n temsilci atanan (bit sayısı n olan) mask durumlarından maksimum skoru al.
        int answer = Integer.MIN_VALUE;
        for (int mask = 0; mask < size; mask++) {
            if (Integer.bitCount(mask) == n) {
                answer = Math.max(answer, dp[mask]);
            }
        }
        return answer;
    }

    /**
     * Pazarlama Kampanyası Seçimi (0/1 Knapsack DP):
     * Verilen bütçe kısıtı altında, her kampanyanın maliyetine ve beklenen getirisine göre maksimum ROI elde edilir.
     *
     * dp[i][b]: İlk i kampanya kullanılarak, bütçe b harcayarak elde edilebilecek maksimum ROI.
     *
     * Karmaşıklık: O(n * budget)
     */
    public static CampaignSelectionResult selectCampaigns(int[] costs, int[] rois, int budget) {
        int n = costs.length;
        int[][] dp = new int[n + 1][budget + 1];

        // DP tablosunun doldurulması:
        for (int i = 1; i <= n; i++) {
            for (int b = 0; b <= budget; b++) {
                if (costs[i - 1] <= b) {
                    dp[i][b] = Math.max(dp[i - 1][b], rois[i - 1] + dp[i - 1][b - costs[i - 1]]);
                } else {
                    dp[i][b] = dp[i - 1][b];
                }
            }
        }

        // Geriye dönüş yöntemiyle seçilen kampanyaların izlenmesi:
        List<Integer> selected = new ArrayList<>();
        int b = budget;
        for (int i = n; i > 0; i--) {
            // Eğer dp[i][b] önceki satırdaki değerden farklı ise, i-1'inci kampanya seçilmiştir.
            if (dp[i][b] != dp[i - 1][b]) {
                selected.add(i - 1);
                b -= costs[i - 1];
            }
        }
        Collections.reverse(selected); // Seçim sırasını düzeltmek için ters çeviriyoruz.
        return new CampaignSelectionResult(dp[n][budget], selected);
    }

    // Kampanya seçim sonucu için yardımcı sınıf
    public static class CampaignSelectionResult {
        public int maxROI;
        public List<Integer> selectedCampaigns;

        public CampaignSelectionResult(int maxROI, List<Integer> selectedCampaigns) {
            this.maxROI = maxROI;
            this.selectedCampaigns = selectedCampaigns;
        }
    }

    public static void main(String[] args) {
        // Örnek 1: Müşteri Destek Temsilcisi Yönlendirme
        // 3 müşteri ve 3 temsilci için uygunluk skor matrisi
        int[][] scoreMatrix = {
                {10, 20, 30},
                {20, 30, 25},
                {15, 25, 35}
        };
        int maxScore = assignRepresentatives(scoreMatrix);
        System.out.println("Maksimum Uygunluk Skoru: " + maxScore);

        // Örnek 2: Pazarlama Kampanyası Seçimi
        int[] costs = {50, 30, 40, 10};
        int[] rois  = {60, 40, 50, 20};
        int budget = 80;
        CampaignSelectionResult result = selectCampaigns(costs, rois, budget);
        System.out.println("Maksimum ROI: " + result.maxROI);
        System.out.println("Seçilen Kampanyalar: " + result.selectedCampaigns);
    }
}
