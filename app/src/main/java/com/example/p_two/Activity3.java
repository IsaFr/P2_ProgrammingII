package com.example.p_two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.RequiresApi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity3 extends AppCompatActivity {

    ImageView photoMember;
    TextView nameMember;
    TextView infoMember;
    TextView sexMember;
    TextView dateMember;
    TextView directionMember;

    Member member = Utilities.members;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        photoMember = (ImageView) findViewById(R.id.idImagen);
        nameMember = (TextView) findViewById(R.id.idName);
        infoMember = (TextView) findViewById(R.id.idInfo);
        sexMember = (TextView) findViewById(R.id.sexMember);
        dateMember = (TextView) findViewById(R.id.dateMember);
        directionMember = (TextView) findViewById(R.id.directionMember);

        photoMember.setImageResource(member.getPhoto());
        nameMember.setText(member.getName());
        infoMember.setText(member.getInfo());
        directionMember.setText(member.getDirection());
        dateFunction(dateMember);
        if(member.isSex())
        {
            sexMember.setText("Gender: Femenine");
        }
        else
        {
            sexMember.setText("Gender: Masculine");
        }


    }

    private void dateFunction(TextView view) {
        Date birthdate = member.getDateBith();
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        String dateMember = formatter.format(birthdate);
        view.setText(dateMember);

    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.getBack:
                Intent intentf = new Intent(this, Activity2.class);
                startActivity(intentf);
                break;

            case R.id.map:
                String mapLocation = "geo:0,0?q=" + Utilities.members.getDirection();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapLocation));
                startActivity(intent);
                break;

            case R.id.addDate:
                Date birthcake = Utilities.members.getDateBith();
                Date setter = new Date((new Date()).getYear(), birthcake.getMonth(), birthcake.getDate());
                Intent intentmap = new Intent(Intent.ACTION_INSERT);
                intentmap.setType("vnd.android.cursor.item/event");
                intentmap.putExtra(CalendarContract.Events.TITLE, "Birthday");
                intentmap.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, setter.getTime());
                intentmap.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
                startActivity(intentmap);
                break;

        }
    }
}
