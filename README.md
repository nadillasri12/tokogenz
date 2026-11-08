# Toko GenZ - Daftar Produk

Aplikasi untuk mencatat daftar produk toko. Setiap produk diisi dengan
nama produk, kategori (Makanan atau Minuman), dan harga. Foto produk boleh
dikosongkan.

## Cara Membuka Proyek di NetBeans

### Opsi A: Clone langsung dari GitHub
1. Buka NetBeans.
2. Pilih menu **Team > Git > Clone**.
3. Isi **Repository URL** dengan alamat repo GitHub proyek ini https://github.com/nadillasri12/tokogenz.git
4. Kosongkan kolom Username dan Password (repo bersifat publik), lalu klik **Next**.
5. Pilih branch **main**, lalu klik **Next**.
6. Tentukan folder tujuan di komputer, lalu klik **Finish**.
7. Saat muncul pertanyaan "Open Project?", klik **Open Project**.

### Opsi B: Download ZIP
1. Di halaman repo GitHub, klik tombol hijau **Code > Download ZIP**.
2. Ekstrak file ZIP tersebut.
3. Di NetBeans, pilih **File > Open Project**, lalu pilih folder tokogenz hasil ekstrak.

## Cara Menjalankan Aplikasi
1. Tunggu NetBeans selesai mengunduh dependency (lihat progress bar di pojok kanan bawah).
2. Klik kanan proyek **tokogenz**, lalu pilih **Properties > Actions**.
3. Pilih **Run project**, lalu isi **Execute Goals** dengan:
   clean javafx:run
4. Pilih **Debug project**, lalu isi **Execute Goals** dengan:
   clean javafx:run@ide-debug
5. Klik **OK**.
6. Jalankan dengan **Run Project** (F6) atau tombol hijau di toolbar.

Catatan: gunakan **Run Project**, bukan Run File pada App.java.

### Alternatif lewat terminal
Buka terminal di folder proyek, lalu jalankan:

    mvn clean javafx:run

## Cara Menggunakan Aplikasi

### 1. Halaman Tambah Produk
Saat aplikasi dibuka, form masih kosong.

<img width="1366" height="768" alt="Screenshot (54)" src="https://github.com/user-attachments/assets/885ee2a9-5a66-4948-b4cb-435dd22ad3be" />
[Form kosong]



### 2. Mengisi data produk
1. Isi **Nama produk**.
2. Pilih **Kategori**: Makanan atau Minuman.
3. Isi **Harga** dengan angka bulat, minimal Rp500.
4. (Opsional) Klik **Pilih Foto** untuk menambahkan foto produk.
5. Klik **Simpan Produk**.

<img width="1366" height="768" alt="Screenshot 2026-11-08 181917" src="https://github.com/user-attachments/assets/49d33d63-cec4-4281-94b9-dc0a2b9d26c2" />
[Form terisi]



### 3. Jika isian belum benar
Produk tidak akan disimpan dan muncul pesan merah di bawah form.

<img width="1366" height="768" alt="Screenshot 2026-11-08 182010" src="https://github.com/user-attachments/assets/3c080196-503a-4674-b566-a0d1d07781ad" />
[Nama dan harga kosong]




<img width="1366" height="768" alt="Screenshot 2026-11-08 181944" src="https://github.com/user-attachments/assets/17fa5877-7e8c-436c-94b0-ea140d8376eb" />
[Harga di bawah Rp500]



### 4. Melihat daftar produk
Klik **Lihat Daftar**. Semua produk tampil di tabel
(kode, nama, kategori, harga).

<img width="1366" height="768" alt="Screenshot 2026-11-08 182211" src="https://github.com/user-attachments/assets/d533bb9e-1101-4920-a271-9789ec40175a" />
[Daftar produk]



### 5. Mencari produk
Ketik nama atau kode produk, lalu klik **Cari**.

<img width="1366" height="768" alt="Screenshot 2026-11-08 182239" src="https://github.com/user-attachments/assets/130ed88a-2dbf-4f9d-9d43-f28e6e97aa2f" />
[Cari nama]




<img width="1366" height="768" alt="Screenshot 2026-11-08 182224" src="https://github.com/user-attachments/assets/162eb262-8281-4f56-a94f-c37daf7d8842" />
[Cari kode]



Klik **Reset** untuk menampilkan semua produk lagi.

<img width="1366" height="768" alt="Screenshot 2026-11-08 182254" src="https://github.com/user-attachments/assets/c074bf54-1ee5-4444-afde-4371e98f95e6" />
[Setelah Reset]



### 6. Melihat detail produk
Pilih satu baris di tabel, lalu klik **Lihat Detail**.

<img width="1366" height="768" alt="Screenshot 2026-11-08 182305" src="https://github.com/user-attachments/assets/96ab36ac-87f2-4871-a227-3d14243e0e72" />
[Detail dengan foto]




<img width="1366" height="768" alt="Screenshot 2026-11-08 182419" src="https://github.com/user-attachments/assets/0c2eac84-476b-4841-8da5-8eee3f7b0d4d" />
[Detail tanpa foto]



Jika belum memilih baris, muncul pesan peringatan.

<img width="1366" height="768" alt="Screenshot 2026-11-08 190946" src="https://github.com/user-attachments/assets/e2967645-00ec-447b-bc7a-3ebe9987b589" />
[Belum memilih salah satu baris]



Catatan: data produk hanya disimpan selama aplikasi berjalan.
