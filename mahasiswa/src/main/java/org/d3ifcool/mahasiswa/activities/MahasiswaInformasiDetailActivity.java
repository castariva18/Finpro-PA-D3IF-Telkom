package org.d3ifcool.mahasiswa.activities;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.d3ifcool.mahasiswa.R;
import org.d3ifcool.service.models.Informasi;

import static org.d3ifcool.service.network.ApiUrl.FinproUrl.URL_FOTO_DOSEN;

public class MahasiswaInformasiDetailActivity extends AppCompatActivity {

    public static final String EXTRA_INFORMASI = "extra_informasi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_informasi_detail);

        setTitle(getString(R.string.title_informasi_detail));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView_judul = findViewById(R.id.act_mhs_info_detail_textview_judul);
        TextView textView_isi = findViewById(R.id.act_mhs_info_detail_textview_isi);
        TextView textView_tanggal = findViewById(R.id.act_mhs_info_detail_textview_tanggal);
        TextView textView_dosen = findViewById(R.id.act_mhs_info_detail_textview_dosen);
        CircleImageView imageView_dosen = findViewById(R.id.ctn_mhs_mhs_bimbingan_circle_image);

        Informasi extraInfo = getIntent().getParcelableExtra(EXTRA_INFORMASI);
        String judul = extraInfo.getInfo_judul();
        String isi = extraInfo.getInfo_deskripsi();
        String tanggal = extraInfo.getInfo_tanggal();
        String dosen = extraInfo.getPublisher();
        String foto = extraInfo.getFoto();

        textView_judul.setText(judul);
        textView_isi.setText(isi);
        textView_tanggal.setText(tanggal);
        textView_dosen.setText(dosen);
        Picasso.get().load(URL_FOTO_DOSEN + foto).into(imageView_dosen);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
