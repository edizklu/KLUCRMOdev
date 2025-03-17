# CRM Optimization System
Bu proje, müşteri destek süreçleri ve pazarlama kampanyası yatırımlarını optimize etmek için dinamik programlama tekniklerini kullanan bir CRM (Müşteri İlişkileri Yönetimi) çözümüdür. Projede iki temel işlev bulunmaktadır:

1. **Müşteri Destek Temsilcisi Yönlendirme:**  
   Belirli bir şehirdeki müşterilere, müşteri talepleri ve temsilcilerin uygunluk skorlarına göre en uygun temsilcinin atanması. Bu kısımda Bitmask DP yöntemi kullanılarak her müşteriye, henüz atanmamış temsilciler arasından en iyi seçimin yapılması sağlanır.

2. **Pazarlama Kampanyası Seçimi:**  
   Verilen bütçe kısıtı altında, her kampanyanın maliyet ve beklenen getirisine göre maksimum yatırım getirisi (ROI) elde etmek amacıyla en uygun kampanyaların seçilmesi. Bu kısımda klasik 0/1 Knapsack DP algoritması uygulanmaktadır.
## Özellikler

- **Dinamik Programlama Yaklaşımları:**  
  - Bitmask DP ile müşteri destek temsilcisi yönlendirmesi.  
  - 0/1 Knapsack DP ile pazarlama kampanyası seçimi.
- **Karmaşıklık Analizleri:**  
  Her iki algoritma için adım adım T(n) ve O(n) hesaplamaları proje dokümantasyonunda açıklanmıştır.
- **Java Uygulaması:**  
  Proje, Java dili kullanılarak yazılmıştır.


## Gereksinimler

- Java 8 veya daha üstü bir sürüm.
- Komut satırı ya da Java IDE (ör. IntelliJ IDEA, Eclipse) kullanarak derleme ve çalıştırma imkanı.

## Kullanım Örneği
Program çalıştırıldığında, iki örnek senaryo üzerinden hesaplamalar yapılır:

**Müşteri Destek Temsilcisi Yönlendirme:**
3 müşteri ve 3 temsilci için uygunluk skorlarına dayalı maksimum toplam skor hesaplanır.

**Pazarlama Kampanyası Seçimi:**
4 kampanya için verilen bütçe kısıtı altında maksimum ROI ve seçilen kampanyaların indeksleri belirlenir.



**Katkıda Bulunma**

Katkılarınız memnuniyetle karşılanır ! Öneri, iyileştirme veya hata bildirimleri için lütfen bir issue açın veya pull request gönderin.

**İletişim**

Sorularınız veya geri bildirimleriniz için lütfen edizssenturk@gmail.com adresiyle iletişime geçin.

    

