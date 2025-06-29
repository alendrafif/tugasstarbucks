# Aplikasi UI Kloning Starbucks Sederhana

Proyek ini adalah contoh aplikasi Android sederhana yang meniru sebagian tampilan antarmuka (UI) dari aplikasi Starbucks. Aplikasi ini dibuat sepenuhnya menggunakan Kotlin dan Jetpack Compose, toolkit UI modern dari Google untuk membangun aplikasi Android native.

Tujuan utama dari proyek ini adalah sebagai sarana belajar dan demonstrasi implementasi layout dasar, daftar (list), dan komponen Material Design 3 dengan Jetpack Compose.

## Fitur

  - **Top App Bar:** Menampilkan logo (pseudo) dan ikon aksi.
  - **Header Sambutan:** Kartu di bagian atas untuk menyapa pengguna.
  - **Kartu Promosi:** Menampilkan penawaran spesial yang sedang berlangsung.
  - **Daftar Menu:** Daftar vertikal yang dapat di-scroll (`LazyColumn`) menampilkan berbagai item menu.
  - **Item Menu dengan Gambar:** Setiap item menu menampilkan gambar, nama, deskripsi singkat, dan harga.
  - **Tombol Aksi:** Tombol "Tambah" di setiap item menu.
  - **Bottom Navigation Bar:** Bar navigasi bawah dengan ikon untuk perpindahan halaman (UI statis).

## Teknologi yang Digunakan

  - **Bahasa:** [Kotlin](https://kotlinlang.org/)
  - **Toolkit UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose)
  - **Arsitektur:** Aplikasi sangat sederhana, semua logika UI berada di `MainActivity`.
  - **Desain:** [Material Design 3](https://m3.material.io/)
  - **IDE:** [Android Studio](https://developer.android.com/studio)

## Cara Menjalankan

Untuk menjalankan proyek ini di komputer Anda, ikuti langkah-langkah berikut:

#### 1\. Prasyarat

  - Pastikan Anda telah menginstal [Android Studio](https://developer.android.com/studio) (versi Iguana atau lebih baru direkomendasikan).
  - Koneksi internet untuk mengunduh dependensi Gradle.

#### 2\. Buka di Android Studio

  - Buka Android Studio.
  - Pilih "Open" dan arahkan ke folder proyek yang telah Anda kloning atau salin.
  - Tunggu hingga Android Studio selesai melakukan sinkronisasi Gradle.

#### 3\. Build dan Jalankan

  - Pilih emulator atau hubungkan perangkat Android fisik.
  - Klik tombol **Run 'app'** (ikon ► berwarna hijau) di toolbar atas.
