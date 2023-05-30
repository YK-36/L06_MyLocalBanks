package sg.edu.rp.c346.id22015127.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView dbsClick;
    TextView ocbcClick;
    TextView uobClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbsClick = findViewById(R.id.dbs);
        ocbcClick = findViewById(R.id.ocbc);
        uobClick = findViewById(R.id.uob);
        registerForContextMenu(dbsClick);
        registerForContextMenu(ocbcClick);
        registerForContextMenu(uobClick);
    }
    String bank = "";
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);
        if(v == dbsClick){
            bank = "dbs";
        } else if (v == ocbcClick) {
            bank = "ocbc";
        } else if (v == uobClick) {
            bank = "uob";
        }
    }
    boolean favDBS = false;
    boolean favOCBC = false;
    boolean favUOB = false;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(bank.equalsIgnoreCase("dbs")){
            if (id == R.id.Website){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;
            }
            else if (id == R.id.Contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+"18001111111"));
                startActivity(intentCall);
                return true;
            }
            else if (id == R.id.Favourite) {
                if(favDBS==false){
                    dbsClick.setTextColor(Color.parseColor("red"));
                    favDBS = true;
                }else {
                    dbsClick.setTextColor(Color.parseColor("black"));
                    favDBS = false;
                }
            }
        }
        else if (bank.equalsIgnoreCase("ocbc")) {
            if (id == R.id.Website){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true;
            }
            else if (id == R.id.Contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+"18003633333"));
                startActivity(intentCall);
                return true;
            }
            else if (id == R.id.Favourite) {
                if(favOCBC==false){
                    ocbcClick.setTextColor(Color.parseColor("red"));
                    favOCBC = true;
                }else {
                    ocbcClick.setTextColor(Color.parseColor("black"));
                    favOCBC = false;
                }
            }
        }
        else if (bank.equalsIgnoreCase("uob")) {
            if (id == R.id.Website){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true;
            }
            else if (id == R.id.Contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+"18002222121"));
                startActivity(intentCall);
                return true;
            }
            else if (id == R.id.Favourite) {
                if(favUOB==false){
                    uobClick.setTextColor(Color.parseColor("red"));
                    favUOB = true;
                }else {
                    uobClick.setTextColor(Color.parseColor("black"));
                    favUOB = false;
                }
            }
        }

        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.language, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.setEng) {
            dbsClick.setText("DBS");
            ocbcClick.setText("OCBC");
            uobClick.setText("UOB");
            return true;
        } else if (id == R.id.setChi) {
            dbsClick.setText("星展银行");
            ocbcClick.setText("华侨银行");
            uobClick.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}