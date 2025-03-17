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

## 1. Neden Bu Algoritmalar Kullanıldı ve Ne İşe Yarıyor?
**Müşteri Destek Temsilcisi Yönlendirmesi (Bitmask DP):**
Müşteri taleplerine göre temsilci ataması problemi, her müşteriye en uygun temsilcinin seçilmesiyle optimum toplam uygunluk skorunun elde edilmesini gerektirir. Bu tür atama problemleri, tüm kombinasyonların denenmesinde üstel zaman karmaşıklığına yol açabilir. Bitmask DP yaklaşımı, hangi temsilcilerin atandığını bit maskeleri ile izleyerek, alt problemlerin hesaplanıp sonuçların saklanmasını sağlar. Böylece hesaplamalar tekrarlanmaz ve daha verimli bir şekilde optimum sonuç elde edilir.

**Pazarlama Kampanyası Seçimi (0/1 Knapsack DP):**
Belirli bir bütçe kısıtı altında, farklı kampanyaların maliyet ve beklenen getirilerine göre seçim yapılması gerekmektedir. Bu problem, klasik 0/1 Knapsack problemine benzemektedir. DP kullanılarak, her kampanya için “seç” veya “seçme” kararı verilirken, bütçenin kısıtlandığı durumlarda maksimum getiri hesaplanır. Böylece, bütçeyi aşmadan en yüksek ROI’yi sağlayan kampanyaların seçimi yapılır.

## 2. Dinamik Programlama (DP) Yönteminin Diğer Yaklaşımlardan Farkı Nedir?
**Optimal Alt Yapı ve Tekrar Eden Hesaplamaların Önlenmesi:**
DP, problemleri daha küçük ve birbirine bağlı alt problemlere böler. Bu alt problemlerde elde edilen sonuçlar saklanır (memoization veya tabulation), böylece aynı hesaplamalar tekrar tekrar yapılmaz. Bu, özellikle kombinatoryal problemlerde büyük performans artışı sağlar.

**Kararların Birleştirilmesi:**
DP, her alt problemden gelen optimum çözümleri kullanarak, genel probleme optimum çözüme ulaşır. Bu yaklaşım, "optimal alt yapı" prensibi olarak bilinir.

**Diğer Yöntemlerle Karşılaştırma:**

**Greedy (Açgözlü) Yaklaşım:**
Greedy algoritmalar her adımda lokal olarak en iyi görünen seçeneği tercih eder. Ancak bu yöntem, tüm problemler için global optimumu garanti etmez. Özellikle karmaşık kombinatoryal problemlerde doğru sonuç vermeyebilir.
**Brute Force (Kaba Kuvvet) Yöntemi:**
Tüm olası çözüm kombinasyonlarının denenmesi esasına dayanır; bu da problemin boyutu büyüdükçe hesaplama süresini üstel olarak artırır.
**Dinamik Programlama:**
DP, problemi alt parçalara bölüp bu parçaları çözerek, daha verimli (genellikle polinomsal ya da pseudo-polynomial) zamanlarda optimum çözüme ulaşır. Özellikle optimal alt yapıya sahip ve alt problemler arasında tekrar eden hesaplamalar olan durumlarda tercih edilir.

**Katkıda Bulunma**

Katkılarınız memnuniyetle karşılanır ! Öneri, iyileştirme veya hata bildirimleri için lütfen bir issue açın veya pull request gönderin.

**İletişim**

Sorularınız veya geri bildirimleriniz için lütfen edizssenturk@gmail.com adresiyle iletişime geçin.

    

