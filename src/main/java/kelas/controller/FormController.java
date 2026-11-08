package kelas.controller;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class FormController {

    @FXML
    private TextField namaField;
    @FXML
    private ComboBox<String> kategoriBox;
    @FXML
    private TextField hargaField;
    @FXML
    private ImageView gambarView;
    @FXML
    private Label pesanLabel;

    private String gambarUri; // kosong (null) kalau tidak pilih foto
    private Navigator navigator;
    private DataProduk data;

    @FXML
    private void initialize() {
        kategoriBox.getItems().addAll("Makanan", "Minuman");
        kategoriBox.setValue("Makanan");
    }

    public void setKonteks(Navigator navigator, DataProduk data) {
        this.navigator = navigator;
        this.data = data;
    }

    @FXML
    private void simpan() {
        String nama = namaField.getText().trim();
        String hargaTeks = hargaField.getText().trim();
        String kesalahan = ""; // daftar isian yang salah, dalam satu baris
        long harga = 0;

        if (nama.isEmpty()) {
            kesalahan += "nama belum diisi, ";
        }
        if (kategoriBox.getValue() == null) {
            kesalahan += "kategori belum dipilih, ";
        }
        if (hargaTeks.isEmpty()) {
            kesalahan += "harga belum diisi, ";
        } else {
            try {
                harga = Long.parseLong(hargaTeks);
                if (harga < 500) {
                    kesalahan += "harga minimal Rp500, ";
                }
            } catch (NumberFormatException e) {
                kesalahan += "harga harus angka bulat, ";
            }
        }

        // Ada yang salah: tampilkan teks, produk tidak disimpan
        if (!kesalahan.isEmpty()) {
            // buang tanda ", " di bagian akhir
            kesalahan = kesalahan.substring(0, kesalahan.length() - 2);
            pesanLabel.setText("Mohon betulkan isian form: " + kesalahan + ".");
            return;
        }

        try {
            Produk p = data.tambah(nama, kategoriBox.getValue(), harga, gambarUri);
            // Berhasil: kosongkan form agar bisa input produk berikutnya
            namaField.clear();
            hargaField.clear();
            kategoriBox.setValue("Makanan");
            gambarUri = null;
            gambarView.setImage(null);
            pesanLabel.setText("Produk " + p.getKode() + " berhasil disimpan.");
        } catch (IllegalArgumentException e) {
            pesanLabel.setText(e.getMessage());
        }
    }

    // Dipanggil tombol "Pilih Foto"
    @FXML
    private void pilihGambar() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Pilih foto produk");
        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "Gambar PNG/JPEG", "*.png", "*.jpg", "*.jpeg"));
        File file = chooser.showOpenDialog(namaField.getScene().getWindow());
        if (file == null) {
            return; // dibatalkan, tidak ada yang berubah
        }
        if (file.length() > 5L * 1024 * 1024) {
            pesanLabel.setText("Ukuran foto maksimal 5 MB.");
            return;
        }
        Image image = new Image(file.toURI().toString(), 640, 480, true, true);
        if (image.isError()) {
            pesanLabel.setText("Foto tidak bisa dibuka.");
            return;
        }
        gambarUri = file.toURI().toString();
        gambarView.setImage(image);
        pesanLabel.setText("");
    }

    // Dipanggil tombol "Hapus Foto"
    @FXML
    private void hapusGambar() {
        gambarUri = null;
        gambarView.setImage(null);
        pesanLabel.setText("Foto dihapus.");
    }

    @FXML
    private void bukaDaftar() {
        try {
            navigator.bukaDaftar();
        } catch (IOException e) {
            pesanLabel.setText("Daftar gagal dibuka.");
            e.printStackTrace();
        }
    }
}
