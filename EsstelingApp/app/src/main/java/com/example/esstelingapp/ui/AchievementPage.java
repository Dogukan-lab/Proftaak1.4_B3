package com.example.esstelingapp.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esstelingapp.Achievement;
import com.example.esstelingapp.R;
import com.example.esstelingapp.data.DataSingleton;
import com.example.esstelingapp.mqtt.MQTTController;

import java.util.LinkedList;

public class AchievementPage extends Fragment {
    private static final String PREFS_NAME = "prefs";
    private static final String PREF_COLOUR_BLIND_THEME = "colour_blind_theme";

    private final LinkedList<Achievement> mAchievementList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private AchievementAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_achievement_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        mAchievementList.add(new Achievement("Piglet home builder",true,0));
//        mAchievementList.add(new Achievement("Red riding hood",false,0));
//        mAchievementList.add(new Achievement("follow the breadcrumbs",false,0));
//        mAchievementList.add(new Achievement("sneaky dragon treasure thief",false,0));
//        mAchievementList.add(new Achievement("junior story seeker",false,0));
//        mAchievementList.add(new Achievement("master story seeker",false,0));

        SharedPreferences sharedPreferences = DataSingleton.getInstance().getMainContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Boolean isColorBlind = sharedPreferences.getBoolean(PREF_COLOUR_BLIND_THEME, false);
        if (isColorBlind){
            getView().setBackgroundResource(R.drawable.old_paper_cb);
        }else {
            getView().setBackgroundResource(R.drawable.old_paper);
        }

        for(Achievement a : DataSingleton.getInstance().getAchievements()){
            mAchievementList.add(a);
        }


        // Create recycler view.
        mRecyclerView = getView().findViewById(R.id.AchievementRecycler);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new AchievementAdapter(getContext(), mAchievementList);
        // Connect the adapter with the recycler view.
        mRecyclerView.setAdapter(mAdapter);
        // Give the recycler view a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
