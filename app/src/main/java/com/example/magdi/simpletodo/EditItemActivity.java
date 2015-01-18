package com.example.magdi.simpletodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class EditItemActivity extends Activity {

    public int position;
    String itemValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Intent intent = getIntent();
        if (null != intent) {
            itemValue = intent.getStringExtra("Item");
            position = intent.getIntExtra("position", 0);
        }

        EditText item = (EditText) findViewById(R.id.eteditlv);
        item.setText(itemValue);
        item.setSelection(item.getText().length());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
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

    public void onSave(View view) {
        EditText etNewItem = (EditText) findViewById(R.id.eteditlv);
        String itemText = etNewItem.getText().toString();
        Intent i = new Intent(EditItemActivity.this, MainActivity.class);
        i.putExtra("Item", itemText);
        i.putExtra("position", position);
        setResult(RESULT_OK, i);
        finish();
    }
}
