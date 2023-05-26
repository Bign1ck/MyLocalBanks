package sg.edu.rp.c346.id22005813.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView clickDBS;
    TextView clickOCBC;
    TextView clickUOB;
    String buttonOption="";
    String ELmenu;
    String CHmenu;
    String dbsName;
    String ocbcName;
    String uobName;
    String dbsCName;
    String ocbcCName;
    String uobCName;
    String dbsWeb;
    String ocbcWeb;
    String uobWeb;
    String dbsNo;
    String ocbcNo;
    String uobNo;
    String errorTrans;

    boolean dbsFav = false;
    boolean ocbcFav = false;
    boolean uobFav = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickDBS = findViewById(R.id.buttonDBS);
        registerForContextMenu(clickDBS);
        clickOCBC = findViewById(R.id.buttonOCBC);
        registerForContextMenu(clickOCBC);
        clickUOB = findViewById(R.id.buttonUOB);
        registerForContextMenu(clickUOB);
        ELmenu = getString(R.string.english);
        CHmenu = getString(R.string.chinese);
        dbsName = getString(R.string.dbs);
        ocbcName = getString(R.string.ocbc);
        uobName = getString(R.string.uob);
        dbsCName = getString(R.string.dbsChinese);
        ocbcCName = getString(R.string.ocbcChinese);
        uobCName = getString(R.string.uobChinese);
        dbsWeb = getString(R.string.dbsWebsite);
        ocbcWeb = getString(R.string.ocbcWebsite);
        uobWeb = getString(R.string.uobWebsite);
        dbsNo = getString(R.string.dbsNo);
        ocbcNo = getString(R.string.ocbcNo);
        uobNo = getString(R.string.uobNo);
        errorTrans = getString(R.string.error);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            clickDBS.setText(dbsName);
            clickOCBC.setText(ocbcName);
            clickUOB.setText(uobName);
            return true;
        } else if (id == R.id.ChineseSelection) {
            clickDBS.setText(dbsCName);
            clickOCBC.setText(ocbcCName);
            clickUOB.setText(uobCName);
            return true;
        } else {
            clickDBS.setText(errorTrans);
            clickOCBC.setText(errorTrans);
            clickUOB.setText(errorTrans);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == clickDBS) {
            buttonOption = "DBS";
        } else if (v == clickOCBC) {
            buttonOption = "OCBC";
        } else if (v == clickUOB) {
            buttonOption = "UOB";
        }
            menu.add(0, 0, 0, "Contact the bank");
            menu.add(0, 1, 1, "Visit Website");
            menu.add(0, 2, 2, "Toggle Favourite");
        }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (buttonOption.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(dbsNo));
                startActivity(intentCall);
                Toast.makeText(MainActivity.this, "Contacting DBS Bank", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(dbsWeb));
                startActivity(intentWebsite);
                Toast.makeText(MainActivity.this, "Going to DBS Bank website", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == 2) {
                dbsFav = !dbsFav;
                updateFavouriteStatus(clickDBS,dbsFav);
                return true;
            }
        } else if (buttonOption.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(ocbcNo));
                startActivity(intentCall);
                Toast.makeText(MainActivity.this, "Contacting OCBC Bank", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(ocbcWeb));
                startActivity(intentWebsite);
                Toast.makeText(MainActivity.this, "Going to OCBC Bank website", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == 2) {
                ocbcFav = !ocbcFav;
                updateFavouriteStatus(clickOCBC,ocbcFav);
                return true;
            }
        } else if (buttonOption.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(uobNo));
                startActivity(intentCall);
                Toast.makeText(MainActivity.this, "Contacting UOB Bank", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(uobWeb));
                startActivity(intentWebsite);
                Toast.makeText(MainActivity.this, "Going to UOB Bank website", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == 2) {
                uobFav = !uobFav;
                updateFavouriteStatus(clickUOB,uobFav);
                return true;
            }
        }

        return super.onContextItemSelected(item);
    }

    private void updateFavouriteStatus(TextView textView, boolean isFavourite) {
        if (isFavourite){
            textView.setTextColor(Color.RED);
        } else {
            textView.setTextColor(Color.BLACK);
        }

    }
}


