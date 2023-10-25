# StoryApp
 
1.Halaman Autentikasi
 
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
        
    [] Menampilkan Animasi: Membuat animasi pada aplikasi dengan menggunakan salah satu jenis animasi berikut.
    [x] Property Animation
    [] Motion Animation
    [] Shared Element
    [] Tuliskan jenis dan lokasi animasi pada Student Note.

[x] mengganti default error di glide storyadapter
[x] cek lagi bagian layout camera, mau diapus krn pake camera default atau tdk
[x] login register blm di tengah