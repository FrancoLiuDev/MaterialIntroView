package co.mobiwise.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.mobiwise.materialintro.animation.MaterialIntroListener;
import co.mobiwise.sample.R;
import co.mobiwise.sample.adapter.RecyclerViewAdapter;
import co.mobiwise.sample.model.Song;

public class RecyclerviewFragment extends Fragment implements MaterialIntroListener {

    private static final String INTRO_CARD = "recyclerView_material_intro";
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        initializeRecyclerview();
        loadData();


        return view;
    }



    private void loadData() {

        Song song = new Song("Diamond", R.drawable.diamond, "Rihanna");
        List<Song> songList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            songList.add(song);
        }
        adapter.setSongList(songList);
    }


    private void initializeRecyclerview() {

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new RecyclerViewAdapter(getActivity().getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onUserClicked(String materialIntroViewId) {
        if (materialIntroViewId.equals(INTRO_CARD)) {
            Toast.makeText(getActivity(), "User Clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
