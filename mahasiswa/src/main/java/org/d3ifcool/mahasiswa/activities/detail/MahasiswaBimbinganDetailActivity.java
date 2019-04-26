package org.d3ifcool.mahasiswa.activities.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.d3ifcool.mahasiswa.R;
import org.d3ifcool.mahasiswa.activities.MahasiswaPaBimbinganActivity;
import org.d3ifcool.mahasiswa.activities.editor.MahasiswaPaBimbinganTambahActivity;
import org.d3ifcool.mahasiswa.activities.editor.MahasiswaPaBimbinganUbahActivity;
import org.d3ifcool.service.interfaces.works.BimbinganWorkView;
import org.d3ifcool.service.models.Bimbingan;
import org.d3ifcool.service.models.ProyekAkhir;
import org.d3ifcool.service.presenters.BimbinganPresenter;

import java.util.ArrayList;

public class MahasiswaBimbinganDetailActivity extends AppCompatActivity implements BimbinganWorkView {

    public static final String EXTRA_BIMBINGAN = "extra_bimbingan";
    public static final String EXTRA_PROYEK_AKHIR = "extra_proyek_akhir";
    private BimbinganPresenter presenter;
    private ProgressDialog dialog;
    private Bimbingan extraBimbingan;
    private ArrayList<ProyekAkhir> extraProyekAkhir = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_bimbingan_detail);

        setTitle(getString(R.string.title_bimbingan_detail));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new BimbinganPresenter(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage(getString(R.string.text_progress_dialog));

        TextView textViewTanggal = findViewById(R.id.act_dsn_mhs_bimbingan_textview_tanggal);
        TextView textViewJudulBimbingan = findViewById(R.id.act_dsn_mhs_bimbingan_textview_judul);
        TextView textViewReviewBimbingan = findViewById(R.id.act_dsn_mhs_bimbingan_textview_review);

        extraBimbingan = getIntent().getParcelableExtra(EXTRA_BIMBINGAN);
        extraProyekAkhir = getIntent().getParcelableArrayListExtra(EXTRA_PROYEK_AKHIR);

        textViewTanggal.setText(extraBimbingan.getTanggal());
        textViewJudulBimbingan.setText(extraBimbingan.getJudul_bimbingan());
        textViewReviewBimbingan.setText(extraBimbingan.getIsi());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit_delete, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();

        if (i == android.R.id.home) {
            finish();

        } else if (i == R.id.toolbar_menu_ubah) {
            Intent intentUbah = new Intent(MahasiswaBimbinganDetailActivity.this, MahasiswaPaBimbinganUbahActivity.class);
            intentUbah.putExtra(MahasiswaPaBimbinganUbahActivity.EXTRA_BIMBINGAN, extraBimbingan);
            intentUbah.putExtra(MahasiswaPaBimbinganUbahActivity.EXTRA_PROYEK_AKHIR, extraProyekAkhir);
            startActivity(intentUbah);
            finish();

        } else if (i == R.id.toolbar_menu_hapus) {

            new AlertDialog
                    .Builder(this)
                    .setTitle(getString(R.string.dialog_hapus_title))
                    .setMessage(getString(R.string.dialog_hapus_text))

                    .setPositiveButton(R.string.iya, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            presenter.deleteBimbingan(extraBimbingan.getId());
                        }
                    })

                    .setNegativeButton(R.string.tidak, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.dismiss();
    }

    @Override
    public void onSucces() {
        finish();
    }

    @Override
    public void onFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}