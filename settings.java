package com.alpha.amica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class settings extends AppCompatActivity {

    SwitchCompat ActivityStatusSwitch, ReadReceiptsSwitch, MyMoveSwitch;
    Button ShareBtn, HelpSupportBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        ActivityStatusSwitch = findViewById(R.id.ActivityStatusSwitch);
        ReadReceiptsSwitch = findViewById(R.id.ReadReceiptsSwitch);
        MyMoveSwitch = findViewById(R.id.MyMoveSwitch);


        ShareBtn = findViewById(R.id.ShareBtn);
        HelpSupportBtn = findViewById(R.id.HelpSupportBtn);


        /** share Button**/

        ShareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Your body here";
                String shareSub = "Your subject here";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });

        /** Help & support Button **/

        HelpSupportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sharing=new Intent(settings.this,help_and_support.class);
                startActivity(sharing);

            }
        });
    }
}
