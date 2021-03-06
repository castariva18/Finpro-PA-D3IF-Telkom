package org.d3ifcool.koor.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import org.d3ifcool.base.helpers.SpinnerHelper;
import org.d3ifcool.base.interfaces.lists.DosenListView;
import org.d3ifcool.base.interfaces.lists.ProyekAkhirListView;
import org.d3ifcool.base.models.Dosen;
import org.d3ifcool.base.models.ProyekAkhir;
import org.d3ifcool.base.presenters.DosenPresenter;
import org.d3ifcool.base.presenters.ProyekAkhirPresenter;
import org.d3ifcool.koor.R;
import org.d3ifcool.koor.adapters.KoorPemetaanMonevViewAdapter;

import java.util.ArrayList;
import java.util.List;

import static org.d3ifcool.base.helpers.Constant.ObjectConstanta.JUDUL_STATUS_DIGUNAKAN;
import static org.d3ifcool.base.networks.bridge.ApiUrl.FinproUrl.PARAM_JUDUL_STATUS;

/**
 * A simple {@link Fragment} subclass.
 */
public class KoorPemetaanMonevFragment extends Fragment implements DosenListView, ProyekAkhirListView {

    private static final String PARAM_PROYEK_AKHIR_DOSEN_PEMBIMBING = "judul.dsn_nip";

    private Spinner sp_dosen;
    private RecyclerView recyclerView;
    private KoorPemetaanMonevViewAdapter adapter;
    private ProgressDialog progressDialog;
    private View empty_view;
    private SwipeRefreshLayout swipeRefreshLayout;

    private SpinnerHelper spinnerHelper;
    private String spinnerItemPosition;
    private String dosenPembimbingNip;

    private ArrayList<Dosen> arrayListDosen = new ArrayList<>();
    private ArrayList<ProyekAkhir> arrayListProyekAkhir = new ArrayList<>();

    private DosenPresenter dosenPresenter;
    private ProyekAkhirPresenter proyekAkhirPresenter;

    public KoorPemetaanMonevFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_koor_pemetaan_monev, container, false);
        sp_dosen = view.findViewById(R.id.spinner_dosen);
        recyclerView = view.findViewById(R.id.frg_koor_judul_dsn_recyclerview);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage(getString(R.string.text_progress_dialog));

        spinnerHelper = new SpinnerHelper(getContext());

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        empty_view = view.findViewById(R.id.view_emptyview);

        dosenPresenter = new DosenPresenter(this);
        proyekAkhirPresenter = new ProyekAkhirPresenter(this);

        dosenPresenter.initContext(getContext());
        proyekAkhirPresenter.initContext(getContext());

        dosenPresenter.getDosen();

        sp_dosen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerItemPosition = parent.getItemAtPosition(position).toString();
                dosenPembimbingNip = arrayListDosen.get(position).getDsn_nip();
                proyekAkhirPresenter.searchDistinctProyekAkhirByTwo(PARAM_PROYEK_AKHIR_DOSEN_PEMBIMBING, dosenPembimbingNip, PARAM_JUDUL_STATUS, JUDUL_STATUS_DIGUNAKAN);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                proyekAkhirPresenter.searchDistinctProyekAkhirByTwo(PARAM_PROYEK_AKHIR_DOSEN_PEMBIMBING, dosenPembimbingNip, PARAM_JUDUL_STATUS, JUDUL_STATUS_DIGUNAKAN);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (dosenPembimbingNip != null) {
            proyekAkhirPresenter.searchDistinctProyekAkhirByTwo(PARAM_PROYEK_AKHIR_DOSEN_PEMBIMBING, dosenPembimbingNip, PARAM_JUDUL_STATUS, JUDUL_STATUS_DIGUNAKAN);
        }
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void onGetListProyekAkhir(List<ProyekAkhir> proyekAkhirList) {

        arrayListProyekAkhir.clear();
        arrayListProyekAkhir.addAll(proyekAkhirList);

        adapter = new KoorPemetaanMonevViewAdapter(getContext());
        adapter.additem(arrayListProyekAkhir);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setRefreshing(false);

        if (arrayListProyekAkhir.size() == 0) {
            empty_view.setVisibility(View.VISIBLE);
        } else {
            empty_view.setVisibility(View.GONE);
        }
    }

    @Override
    public void isEmptyListProyekAkhir() {
        empty_view.setVisibility(View.VISIBLE);
    }

    @Override
    public void onGetListDosen(List<Dosen> dosen) {
        arrayListDosen.clear();
        arrayListDosen.addAll(dosen);
        spinnerHelper.initSpinnerDosen(arrayListDosen, sp_dosen);
    }

    @Override
    public void isEmptyListDosen() {

    }

    @Override
    public void onFailed(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
