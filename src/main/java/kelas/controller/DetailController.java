package kelas.controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kelas.Navigator;
import kelas.model.Produk;

public class DetailController {
    @FXML private Label kodeLabel;
    @FXML private Label namaLabel;
    @FXML private Label kategoriLabel;
    @FXML private Label hargaLabel;
    @FXML private ImageView gambarView;
    @FXML private Label pesanLabel;

    private Navigator navigator;

    // Dipanggil Navigator setelah FXML dimuat; menerima objek produk terpilih
    public void setData(Navigator navigator, Produk produk) {
        this.navigator = navigator;
        kodeLabel.setText(produk.getKode());
        namaLabel.setText(produk.getNama());
        kategoriLabel.setText(produk.getKategori());
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(
                Locale.forLanguageTag("id-ID")); rupiah.setMaximumFractionDigits(0); // tanpa ,00
        hargaLabel.setText(rupiah.format(produk.getHarga()));

        if (produk.getGambarUri() == null) {
            pesanLabel.setText("Produk ini belum ada fotonya.");
            return;
        }
        Image image = new Image(produk.getGambarUri(), 640, 480, true, true);
        if (image.isError()) {
            pesanLabel.setText("Foto tidak bisa dibuka. Mungkin file-nya sudah dipindah.");
        } else {
            gambarView.setImage(image);
        }
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
