package org.d3ifcool.mahasiswa.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.d3ifcool.mahasiswa.R;
import org.d3ifcool.mahasiswa.adapters.MahasiswaPaMonevViewAdapter;
import org.d3ifcool.service.models.DetailMonev;

import java.util.ArrayList;

public class MahasiswaPaMonevDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_pa_monev_detail);

        setTitle(getString(R.string.title_monev_detail));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textViewDosen = findViewById(R.id.act_mhs_pa_monev_detail_textview_dosen);
        TextView textViewJumlah = findViewById(R.id.act_mhs_pa_monev_detail_textview_jumlah);
        RecyclerView recyclerView = findViewById(R.id.act_mhs_pa_monev_detail_recyclerview);

        ArrayList<DetailMonev> arrayList = new ArrayList<>();
//        arrayList.add(new Monev(90, "01 Februari 2019", "Revisi Bab 4"));
//        arrayList.add(new Monev(90, "01 Februari 2019", "Revisi Bab 4"));
//        arrayList.add(new Monev(90, "01 Februari 2019", "Revisi Bab 4"));

        MahasiswaPaMonevViewAdapter adapter = new MahasiswaPaMonevViewAdapter(this);
        adapter.addItem(arrayList);
        adapter.setLayoutType(R.layout.content_item_mahasiswa_pa_monev);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

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
