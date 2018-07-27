package com.mk.jobs.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.mk.jobs.R;
import com.mk.jobs.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mostafa on 7/22/2018.
 */

public class MainActivity extends AppCompatActivity{
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    ArrayList<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent i = new Intent(getApplicationContext(),ServiceListActivity.class);
                i.putExtra("child_name",listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition));
                startActivity(i);
                return false;
            }
        });
    }


    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add("Doctors");
        listDataHeader.add("Engineers");
        listDataHeader.add("Coming Soon..");

        // Adding child data
        List<String> doctors = new ArrayList<>();
        doctors.add("Allergists/Immunologists");
        doctors.add("Anesthesiologists ");
        doctors.add("Cardiologists");
        doctors.add("Colon and Rectal Surgeons");
        doctors.add("Critical Care Medicine Specialists");
        doctors.add("Dermatologists");
        doctors.add("Endocrinologists ");
        doctors.add("others");

        List<String> engineers = new ArrayList<>();
        engineers.add("Computer Engineer");
        engineers.add("Electrical Engineer");
        engineers.add("Civil Engineer");
        engineers.add("Mechanical Engineer");
        engineers.add("Architectural Engineer");
        engineers.add("others");

        List<String> comingSoon = new ArrayList<>();
        comingSoon.add("job 1");
        comingSoon.add("job 2");
        comingSoon.add("job 3");

        listDataChild.put(listDataHeader.get(0), doctors); // Header, Child data
        listDataChild.put(listDataHeader.get(1), engineers);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}

