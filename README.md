Hava Durumu Uygulaması
Bu proje, Spring Boot ve React kullanarak geliştirilmiş bir hava durumu uygulamasıdır. Uygulama, OpenWeatherMap API'sini kullanarak hava durumu verilerini getirir ve MongoDB veritabanında saklar. React ile modern ve kullanıcı dostu bir arayüz sunar ve Ant Design bileşenleri ile geliştirilmiştir.

Proje Yapısı
1. Backend - Spring Boot
API Entegrasyonu: OpenWeatherMap API'si kullanılarak hava durumu verileri çekilir.
Veritabanı: Hava durumu verileri MongoDB'ye kaydedilir.
Endpointler: React frontend ile haberleşmek için çeşitli API endpoint'leri oluşturulmuştur.
Kullanılan Teknolojiler:
Spring Boot
MongoDB
OpenWeatherMap API
Java
2. Frontend - React
Kullanıcı Arayüzü: Ant Design bileşenleri ile oluşturulmuş modern ve kullanıcı dostu bir arayüz.
Veri Gösterimi: Axios kullanılarak backend'den çekilen hava durumu verileri tablolar ve kartlar ile gösterilir.
Filtreleme: Şehir adına göre hava durumu verileri filtrelenebilir.
İkonlar: Hava durumuna göre dinamik ikonlar (güneşli, yağmurlu, karlı vb.) gösterilir.
Kullanılan Teknolojiler:
React.js
Ant Design
Axios
React Icons

KULLANIM

React arayüzü üzerinden şehir adına göre hava durumu bilgilerini sorgulayın.
API'den gelen hava durumu verileri, uygulamanın arayüzünde dinamik olarak gösterilecektir.
Filtreleme seçenekleri ile istediğiniz şehri arayarak veri alabilirsiniz.
Uygulama MongoDB'de hava durumu verilerini saklar.
Proje Özellikleri
OpenWeatherMap API ile entegre
MongoDB veri kaydetme
Dinamik hava durumu ikonları
Şehir adına göre filtreleme
Ant Design arayüz bileşenleri
