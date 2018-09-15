package com.chau.michael.dealsnotification;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class LaunchScreen extends AppCompatActivity {
    private ListView listViewForDeals;
    private Boolean isNewDeal = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setBackgroundColor(Color.parseColor("#b91919"));
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("NintendoSwitchDeals");

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener( LaunchScreen.this,  new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String newToken = instanceIdResult.getToken();
                Log.e("newToken",newToken);

            }
        });

        //click events
        final Button newDealBtn = findViewById(R.id.newButton);
        final Button hotDealBtn = findViewById(R.id.hotButton);
        newDealBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isNewDeal = true;
            }
        });
        hotDealBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isNewDeal = false;
            }
        });

        //retrieveDeals();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.custom, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(LaunchScreen.this,UserSettings.class);
        LaunchScreen.this.startActivity(i);
        return true;
    }

    private void retrieveDeals(){
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url ="to do";
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // Display the first 500 characters of the response string.
//                        Log.d("","Response is: "+ response);
//                    }
//                }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Log.d("","Error");
//                }
//        });
//
//        // Add the request to the RequestQueue.
//        queue.add(stringRequest);
        toggleList();
    }

    private void toggleList(){
        if(isNewDeal){

        }else {

        }
    }
}
