# StoryApp

## Mempertahankan Fitur dari Submission Sebelumnya
    [x] Pastikan berbagai fitur yang ada dalam submission sebelumnya berjalan dengan baik.

## Menampilkan Maps
    [] Menampilkan satu halaman baru berisi peta yang menampilkan semua cerita yang memiliki lokasi dengan benar. Bisa berupa marker maupun icon berupa gambar. Data story yang memiliki lokasi latitude dan longitude dapat diambil melalui parameter location seperti berikut
    https://story-api.dicoding.dev/v1/stories?location=1.

## Paging List
    [] Menampilkan list story dengan menggunakan Paging 3 dengan benar.

## Membuat Testing
    []Menerapkan unit test pada fungsi di dalam ViewModel yang mengambil list data Paging.
        Ketika berhasil memuat data cerita.
        []Memastikan data tidak null.
        []Memastikan jumlah data sesuai dengan yang diharapkan.
        []Memastikan data pertama yang dikembalikan sesuai.
        []Ketika tidak ada data cerita.
        []Memastikan jumlah data yang dikembalikan nol.

[] Menuliskan kode dengan bersih.
[] Bersihkan comment dan kode yang tidak digunakan.
[] Indentasi yang sesuai.
[] Menghapus import yang tidak digunakan.
[] Menambahkan informasi selama proses interaksi dengan API:
[] Loading ketika memuat data
[] Informasi error ketika gagal
[] Pesan informasi ketika tidak ada data
[] Menggunakan custom map style tersendiri pada Google Maps.
[] Menggunakan Paging 3 dengan menggunakan RemoteMediator.
[] Menambahkan input lokasi saat ini dari GPS yang bersifat opsional (gunakan checkbox atau switch) ketika tambah cerita.
[] Menerapkan Android Architecture Component (minimal ViewModel dan LiveData) dengan benar di semua halaman yang mengandung business logic.
[] Menerapkan UI test dan idling resources untuk salah satu skenario berikut.
[] Memastikan mekanisme proses login dan logout.
[] Memastikan mekanisme proses tambah cerita.

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
[] Membuat halaman untuk menambah cerita baru yang dapat diakses dari halaman daftar cerita. Berikut input minimal yang dibutuhkan.
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


Fitur yang harus ada pada aplikasi.