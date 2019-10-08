package com.example.weekfiveandroiddev;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView title1;
    TextView title2;
    TextView title3;
    String name1 = "Note 1";
    String name2 = "Note 2";
    String name3 = "Note 3";
    private final int REQUEST_CODE1 = 20;
    private final int REQUEST_CODE2 = 30;
    private final int REQUEST_CODE3 = 40;

    //ArrayList<String> items = new ArrayList<>();
    //final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_main, R.id.title, items);
    //ListView ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title1 = findViewById(R.id.title1);
        title2 = findViewById(R.id.title2);
        title3 = findViewById(R.id.title3);

        /* ListView = (ListView) findViewById(R.id.simpleListView);
        ListView.setAdapter(arrayAdapter);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add new Items to List
                items.add("New Note");

                    notifyDataSetChanged ()
                        Notifies the attached observers that the underlying
                        data has been changed and any View reflecting the
                        data set should refresh itself.


                arrayAdapter.notifyDataSetChanged();

            }});*/


        title1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("mode", 1); // pass arbitrary data to launched activity
                i.putExtra("text", name1);
                startActivityForResult(i, REQUEST_CODE1);
            }
        });

        title2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("mode", 2); // pass arbitrary data to launched activity
                i.putExtra("text", name2);
                startActivityForResult(i, REQUEST_CODE2);
            }
        });

        title3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("mode", 3); // pass arbitrary data to launched activity
                i.putExtra("text", name3);
                startActivityForResult(i, REQUEST_CODE3);
            }
        });
    }

    // ActivityOne.java, time to handle the result of the sub-activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // REQUEST_CODE is defined above
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE1) {
            // Extract name value from result extras
            name1 = data.getExtras().getString("text");
            // Toast the name to display temporarily on screen
            title1.setText(name1);
        }

        else if(resultCode == RESULT_OK && requestCode == REQUEST_CODE2) {
            // Extract name value from result extras
            name2 = data.getExtras().getString("text");
            // Toast the name to display temporarily on screen
            title2.setText(name2);
        }

        else if(resultCode == RESULT_OK && requestCode == REQUEST_CODE3) {
            // Extract name value from result extras
            name3 = data.getExtras().getString("text");
            // Toast the name to display temporarily on screen
            title3.setText(name3);
        }
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
