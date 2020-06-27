package com.example.p_two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Activity2 extends AppCompatActivity {

    ArrayList<Member> listMembers;
    RecyclerView recyclerMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        constructRecycler();
    }


    private void fillMembers() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        listMembers.add(new Member("Joseph Adams Cabrera", "CEO, Chief Executive Officer", R.drawable.ceo, false, (Date) formatter.parse("08/14/1974"), "DC, Washington"));
        listMembers.add(new Member("Anne Peña Rosario", "COO, Chief Operations Officer", R.drawable.coo,  true, (Date) formatter.parse("12/21/1976"), "La Romana, Dominican Republic"));
        listMembers.add(new Member("Carlos Almánzar Rodríguez", "CFO, Chief Financial Officer", R.drawable.cfo,  false, (Date) formatter.parse("01/20/1974"), "Santo Domingo, Dominican Republic"));
        listMembers.add(new Member("Laura De Moya Pérez", "CMO, Chief Marketing Officer", R.drawable.cmo,  true,(Date) formatter.parse("05/5/1995"), "Santo Domingo, Dominican Republic"));
        listMembers.add(new Member("Pamela Sanders", "CIO, Chief Information Officer", R.drawable.cio,  true, (Date) formatter.parse("06/18/1997"), "Santo Domingo, Dominican Republic"));
        listMembers.add(new Member("José Muñoz", "CTO, Chief Technology Officer", R.drawable.cto,  false, (Date) formatter.parse("12/25/1995"), "Santo Domingo, Dominican Republic"));
        listMembers.add(new Member("Juan Ramírez", "COO, Chief Communications Officer", R.drawable.cco,  false, (Date) formatter.parse("03/15/1993"), "New York City, New York"));
        listMembers.add(new Member("Luis Sánchez", "CDO, Chief Digital Officer", R.drawable.cdo,  false, (Date) formatter.parse("05/01/1996"), "New York City, New York"));

    }


    public void onClick(View view) throws ParseException {

        switch (view.getId()){
            case R.id.btnList:Utilities.visualización = Utilities.LIST;
                break;
            case R.id.btnGrid:Utilities.visualización = Utilities.GRID;
                break;
        }
        constructRecycler();
}

    private void constructRecycler() {
        listMembers = new ArrayList<>();
        recyclerMembers = (RecyclerView) findViewById(R.id.recyclerId);
        if(Utilities.visualización==Utilities.LIST) {
            recyclerMembers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        }
        else{
            recyclerMembers.setLayoutManager(new GridLayoutManager(this, 2));
        }
        try {
            fillMembers();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        AdapterMembers adapter = new AdapterMembers(listMembers);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utilities.members = listMembers.get(recyclerMembers.getChildAdapterPosition(view));
                Intent intent_3 = new Intent(getApplicationContext(), Activity3.class);
                startActivity(intent_3);

            }
        });

        recyclerMembers.setAdapter(adapter);
    }
    }
