package com.example.retrofittest.Activity;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.retrofittest.Adapter.Customlistadapter;
import com.example.retrofittest.Model.Phones;
import com.example.retrofittest.Model.User;
import com.example.retrofittest.R;
import com.example.retrofittest.Service.ApiService;
import com.example.retrofittest.Service.ServiceFactory;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {
    private Context context;
    private ProgressBar progressBar;
   private EditText enterNo;
   private ListView contactList;
    private Button showAll;
    private Button findUser;
    private TextView statusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        setContentView(R.layout.activity_main2);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        enterNo = (EditText) findViewById(R.id.editText);
        contactList = (ListView) findViewById(R.id.list);
        showAll = (Button) findViewById(R.id.button);
        findUser = (Button) findViewById(R.id.button2);
        statusText = (TextView) findViewById(R.id.textStatus);

        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Phones phones = new Phones();
                phones.addPhone("918129336422");
                phones.addPhone("918547181736");
                phones.addPhone("919809145582");
                phones.addPhone("8801706466627");
                phones.addPhone("918714343022");
                progressBar.setVisibility(View.VISIBLE);
                enterNo.setVisibility(View.INVISIBLE);
                showAll.setVisibility(View.INVISIBLE);
                findUser.setVisibility(View.INVISIBLE);
                ApiService apiService = ServiceFactory.GetApiService();
                Callback<List<User>> cbUsers = new Callback<List<User>>() {
                    @Override
                    public void success(List<User> users, Response response) {
                        Log.e("Users###########3", users.toString());
                        if (users.size()==0){
                            statusText.setVisibility(View.VISIBLE);
                            statusText.setText("No user found");
                        } else{
                            progressBar.setVisibility(View.INVISIBLE);
                            contactList.setVisibility(View.VISIBLE);
                            Customlistadapter customlistadapter = new Customlistadapter(context, users);
                            contactList.setAdapter(customlistadapter);
                        }

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        progressBar.setVisibility(View.INVISIBLE);
                        Log.e("Users#######", error.toString());
                    }
                };
                apiService.lookupContacts(phones,cbUsers);
            }
        });

        findUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactList.setVisibility(View.VISIBLE);
                enterNo.setVisibility(View.INVISIBLE);
                showAll.setVisibility(View.INVISIBLE);
                findUser.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                ApiService apiService = ServiceFactory.GetApiService();

                Callback<List<User>> cbUsers =  new Callback<List<User>>() {
                    @Override
                    public void success(List<User> users, Response response) {
                        Log.e("######", users+"");
                        progressBar.setVisibility(View.INVISIBLE);
                        contactList.setAdapter(new Customlistadapter(context,users ));
                    }

                    @Override
                    public void failure(RetrofitError error) {
                    Log.e("######", error+"");
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                };

                apiService.lookupUserByPhone(enterNo.getText().toString(), cbUsers);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
