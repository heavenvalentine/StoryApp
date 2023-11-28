# StoryApp

## Mempertahankan Fitur dari Submission Sebelumnya
    [x] Pastikan berbagai fitur yang ada dalam submission sebelumnya berjalan dengan baik.

## Menampilkan Maps
    [x] Menampilkan satu halaman baru berisi peta yang menampilkan semua cerita yang memiliki lokasi dengan benar. Bisa berupa marker maupun icon berupa gambar. Data story yang memiliki lokasi latitude dan longitude dapat diambil melalui parameter location seperti berikut
    https://story-api.dicoding.dev/v1/stories?location=1.

## Paging List
    [x] Menampilkan list story dengan menggunakan Paging 3 dengan benar.

## Membuat Testing
    [x]Menerapkan unit test pada fungsi di dalam ViewModel yang mengambil list data Paging.
        Ketika berhasil memuat data cerita.
        [x]Memastikan data tidak null.
        [x]Memastikan jumlah data sesuai dengan yang diharapkan.
        [x]Memastikan data pertama yang dikembalikan sesuai.
        [x]Ketika tidak ada data cerita.
        [x]Memastikan jumlah data yang dikembalikan nol.

## Saran
[x] Menuliskan kode dengan bersih.
[x] Bersihkan comment dan kode yang tidak digunakan.
[x] Indentasi yang sesuai.
[x] Menghapus import yang tidak digunakan.
[x] Menambahkan informasi selama proses interaksi dengan API:
[x] Loading ketika memuat data
[x] Informasi error ketika gagal
[x] Pesan informasi ketika tidak ada data
[x] Menggunakan custom map style tersendiri pada Google Maps.
[x] Menggunakan Paging 3 dengan menggunakan RemoteMediator.

[x] Menampilkan halaman login untuk masuk ke dalam aplikasi
[x] Email (R.id.ed_login_email)
[x] Password (R.id.ed_login_password)

[x] Membuat halaman register untuk mendaftarkan diri dalam aplikasi. Berikut input yang dibutuhkan.
[x] Nama (R.id.ed_register_name)
[x] Email (R.id.ed_register_email)
[x] Password (R.id.ed_register_password)
[x] Password wajib disembunyikan.

[x] Membuat Custom View berupa EditText pada halaman login atau register dengan ketentuan sebagai berikut.
[x] Jika jumlah password kurang dari 8 karakter, menampilkan pesan error secara langsung pada EditText tanpa harus pindah form atau klik tombol dulu.
[x] Menyimpan data sesi dan token di preferences. Data sesi digunakan untuk mengatur alur aplikasi dengan spesifikasi seperti berikut.
[x] Jika sudah login langsung masuk ke halaman utama.
[x] Jika belum maka akan masuk ke halaman login.


[x] Terdapat fitur untuk logout (R.id.action_logout) pada halaman utama dengan ketentuan sebagai berikut.
[x] Ketika tombol logout ditekan, informasi token, dan sesi harus dihapus.
[x] Daftar Cerita (List Story)
[x] Syarat yang harus dipenuhi sebagai berikut.
[x] Menampilkan daftar cerita dari API yang disediakan. Berikut minimal informasi yang wajib Anda tampilkan.
[x] Nama user (R.id.tv_item_name)
[x] Foto  (R.id.iv_item_photo)

[x] Muncul tampilan detail ketika salah satu item cerita ditekan. Berikut  minimal informasi yang wajib Anda tampilkan.
[x] Nama user (R.id.tv_detail_name)
[x] Foto (R.id.iv_detail_photo)
[x] Deskripsi (R.id.tv_detail_description)

[x] Tambah Cerita
Membuat halaman untuk menambah cerita baru yang dapat diakses dari halaman daftar cerita. Berikut input minimal yang dibutuhkan.
[x] File foto (wajib bisa dari gallery)
[x] Deskripsi cerita (R.id.ed_add_description)
[x] Terdapat tombol (R.id.button_add) untuk upload data ke server.
[x] Setelah tombol tersebut diklik dan proses upload berhasil, maka akan kembali ke halaman daftar cerita.
[x] Data cerita terbaru harus muncul di paling atas.

[x] Menampilkan Animasi: Membuat animasi pada aplikasi dengan menggunakan salah satu jenis animasi berikut.
[x] Property Animation
[x] Motion Animation: ada pada bagian MainActivity ke DetailActivity (memilih dari kumpulan cerita ke detail cerita)

[x] mengganti default error di glide storyadapter
[x] cek lagi bagian layout camera, mau diapus krn pake camera default atau tdk
[x] login register blm di tengah


## Daftar Isi
- [x] Membersihkan kode, menghapus komentar, dan kode yang tidak digunakan.
- [x] Memastikan indentasi kode yang benar.
- [x] Menghapus impor yang tidak digunakan.

## Custom EditText View
- [x] Membuat Custom EditText View.
- [x] Menerapkan validasi format email dan menampilkan pesan error langsung pada EditText.


## Alur Pengguna
- [x] Pastikan aplikasi hanya berpindah ke layar berikutnya setelah menerima respons berhasil atau gagal:
    - [x] Setelah login, menekan tombol kembali di layar beranda seharusnya keluar dari aplikasi.
    - [x] Setelah mengunggah, menekan tombol kembali di layar beranda seharusnya keluar dari aplikasi.
    - [x] Setelah logout, menekan tombol kembali seharusnya keluar dari aplikasi.

## Lokalisasi
- [x] Menerapkan dukungan multibahasa (lokalisasi) di aplikasi.

## Interaksi dengan API
- [x] Menerapkan pesan informatif selama interaksi dengan API:
    - [x] Tampilkan indikator loading saat memuat data.
    - [x] Tampilkan pesan error saat permintaan gagal.
    - [x] Tampilkan pesan informatif saat tidak ada data yang tersedia.

## Komponen Arsitektur Android
- [x] Menerapkan Komponen Arsitektur Android, termasuk ViewModel dan LiveData, dengan benar di semua halaman dengan logika bisnis.

## Catatan Tambahan

- [x] Tambahkan catatan atau detail tambahan yang khusus untuk proyek Anda.

![2](https://github.com/heavenvalentine/StoryApp/assets/121389422/f37240ad-2bee-4694-a48b-e541a57712b2)
![1](https://github.com/heavenvalentine/StoryApp/assets/121389422/ce426aac-3ee1-48b3-844b-b0623f7d1b9c)
![7](https://github.com/heavenvalentine/StoryApp/assets/121389422/b0e99f93-4d1a-49d6-a319-098bc1a7d9ff)
![6](https://github.com/heavenvalentine/StoryApp/assets/121389422/49d265a7-a730-40c9-bd12-758b0ab83300)
![5](https://github.com/heavenvalentine/StoryApp/assets/121389422/44cc98a6-140f-4589-9b9a-43672aec88ef)
![4](https://github.com/heavenvalentine/StoryApp/assets/121389422/b2460fe0-0b1c-4ed8-82bc-c5c8d303fe5f)
![3](https://github.com/heavenvalentine/StoryApp/assets/121389422/d5b07745-f937-4b00-81b5-d5167bcd428a)


