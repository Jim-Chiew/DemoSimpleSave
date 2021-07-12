package sg.edu.rp.c346.id20004713.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //obtain shared preference instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //create a share preference editor by calling edit()
        SharedPreferences.Editor preEdit = prefs.edit();
        //set a key-value pair in the editor
        preEdit.putString("greetings", "Hello");
        //call the commit() to save the changed made to the sharedPrefrance
        preEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE); //obtain shared preference instance
        String msg = prefs.getString("greetings", "No greetings name");  //Retrieve the data from shared preference
        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
}