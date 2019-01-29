package com.alokda.bussinesstask.Azkary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alokda.bussinesstask.Model.AzkaryModel;
import com.alokda.bussinesstask.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityAzkary extends AppCompatActivity {
    RecyclerView rv_azkary;
    RecyclerView.LayoutManager layoutManager;

    AdapterAzkary mAdapter;
    List<AzkaryModel> mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkary);

        initData();
        initView();
        initAdapter();

    }

    private void initView() {
        rv_azkary = (RecyclerView) findViewById(R.id.rv_azkary);

    }

    private void initAdapter() {
        layoutManager = new LinearLayoutManager(this);
        rv_azkary.setLayoutManager(layoutManager);
        mAdapter = new AdapterAzkary(mList, getApplicationContext());
        rv_azkary.setAdapter(mAdapter);
    }

    private void initData() {
        mList = new ArrayList<>();
        AzkaryModel model = new AzkaryModel();
        model.setCount(10);
        model.setTitle("أَعُوذُ بِاللهِ مِنْ الشَّيْطَانِ الرَّجِيمِ");
        model.setDesc("لّهُ لاَ إِلَهَ إِلاَّ هُوَ الْحَيُّ الْقَيُّومُ لاَ تَأْخُذُهُ سِنَةٌ وَلاَ نَوْمٌ" +
                "لَّهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الأَرْضِ مَن ذَا الَّذِي يَشْفَعُ عِنْدَهُ إِلاَّ بِإِذْنِهِ " +
                "يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ وَلاَ \u200Fيُحِيطُونَ بِشَيْءٍ مِّنْ عِلْمِه" +
                "إِلاَّ بِمَا شَاء وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالأَرْضَ وَلاَ يَؤُودُهُ \u200F " +
                "حِفْظُهُمَا وَهُوَ الْعَلِيُّ الْعَظِيمُ");
        model.setUseful("من قالها حين يصبح أجير من الجن حتى يمسى ومن قالها حين يمسى أجير من الجن حتى يصبح. ");
        mList.add(model);

        model = new AzkaryModel();
        model.setTitle("بِسْمِ اللهِ الرَّحْمنِ الرَّحِيم");
        model.setDesc("قُلْ هُوَ ٱللَّهُ أَحَدٌ، ٱللَّهُ ٱلصَّمَدُ، لَمْ يَلِدْ وَلَمْ يُولَدْ، وَلَمْ يَكُن لَّهُۥ كُفُوًا أَحَدٌۢ.");
        model.setCount(3);
        mList.add(model);

        model.setTitle("بِسْمِ اللهِ الرَّحْمنِ الرَّحِيم");
        model = new AzkaryModel();
        model.setDesc("قُلْ أَعُوذُ بِرَبِّ ٱلْفَلَقِ، مِن شَرِّ مَا خَلَقَ، وَمِن شَرِّ غَاسِقٍ إِذَا وَقَبَ، وَمِن شَرِّ ٱلنَّفَّٰثَٰتِ فِى ٱلْعُقَدِ، وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ. ");
        model.setCount(3);
        mList.add(model);

        model = new AzkaryModel();
        model.setTitle("");
        model.setDesc("اللّهُـمَّ ما أَصْبَـَحَ بي مِـنْ نِعْـمَةٍ أَو بِأَحَـدٍ مِـنْ خَلْـقِك ، فَمِـنْكَ وَحْـدَكَ لا شريكَ لَـك ، فَلَـكَ الْحَمْـدُ وَلَـكَ الشُّكْـر");
        model.setCount(9);
        mList.add(model);
    }
}
