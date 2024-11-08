# Deprem Yardım Uygulaması (depremyrdm)

Bu proje, deprem sonrası yardım faaliyetlerini koordine etmek amacıyla geliştirilmiştir. Afetzedelerin ihtiyaçlarını hızlı ve etkili bir şekilde karşılamayı amaçlayan deprem yardım uygulaması, gıda, barınma ve sağlık gibi temel ihtiyaçlar için yardım taleplerini toplar ve gönüllülerin bu talepleri görüntüleyerek yanıt vermesini sağlar.

## İçindekiler
- [Özellikler](#özellikler)
- [Kullanılan Teknolojiler](#kullanılan-teknolojiler)
- [Kurulum](#kurulum)
- [Kullanım](#kullanım)
- [Katkı](#katkı)
- [Lisans](#lisans)

## Özellikler
- **Kullanıcı Kaydı ve Girişi**: Afetzedeler ve gönüllüler için kullanıcı hesapları oluşturma ve giriş yapma imkanı.
- **İhtiyaç Bildirimi**: Afetzedelerin gıda, barınma, sağlık gibi ihtiyaçlarını bildirebileceği bir platform.
- **Yardım Talepleri**: Gönüllüler ve yardım kuruluşları, afetzedelerin ihtiyaçlarına yönelik yardım taleplerini görüntüleyebilir ve yanıtlayabilir.
- **Harita Entegrasyonu**: Yardım taleplerinin ve ihtiyaçların coğrafi konumlarını gösteren harita entegrasyonu.
- **Bildirimler**: Yardım talepleri ve ihtiyaçlarla ilgili anlık bildirimler gönderme.

## Kullanılan Teknolojiler
- **Frontend**: React Native ile mobil uygulama geliştirme.
- **Backend**: Node.js ve Express.js ile sunucu tarafı geliştirme.
- **Veritabanı**: MongoDB ile NoSQL veritabanı yönetimi.
- **Harita Servisi**: Google Maps API entegrasyonu.
- **Bildirimler**: Firebase Cloud Messaging (FCM) ile anlık bildirimler.

## Kurulum
1. **Depoyu Klonlayın**:
    ```bash
    git clone https://github.com/Dogukanmukan/earthquake-relief-app.alpha.git
    ```

2. **Backend Kurulumu**:
    - `backend` dizinine gidin:
      ```bash
      cd earthquake-relief-app.alpha/backend
      ```
    - Gerekli paketleri yükleyin:
      ```bash
      npm install
      ```
    - Sunucuyu başlatın:
      ```bash
      npm start
      ```

3. **Frontend Kurulumu**:
    - `frontend` dizinine gidin:
      ```bash
      cd ../frontend
      ```
    - Gerekli paketleri yükleyin:
      ```bash
      npm install
      ```
    - Uygulamayı çalıştırın:
      ```bash
      npm start
      ```

## Kullanım
- Uygulamayı çalıştırdıktan sonra, kullanıcılar ihtiyaçlarını bildirebilir ve gönüllüler bu talepleri yanıtlayarak yardımlarını gerçekleştirebilir.
- Anlık bildirimler ve harita üzerinden yardım taleplerinin konum bilgilerini görme özelliği kullanıma hazır hale gelir.

## Katkı
1. Projeyi forkladıktan sonra geliştirmelerinizi kendi branch'inizde yapabilirsiniz.
2. Değişikliklerinizi commit edin ve GitHub’a push yapın.
3. Bir `pull request` oluşturarak önerilerinizi paylaşabilirsiniz.

## Lisans
Bu proje MIT Lisansı ile lisanslanmıştır. Ayrıntılar için `LICENSE` dosyasına bakabilirsiniz.
