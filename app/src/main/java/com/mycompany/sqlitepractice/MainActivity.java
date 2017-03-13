package com.mycompany.sqlitepractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyDBHelper dbHandler;
    EditText infoTextView;
    TextView dbTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoTextView = (EditText) findViewById(R.id.entertextview);
        dbTextView = (TextView) findViewById(R.id.textViewTable);

        dbHandler = new MyDBHelper(this, null, null, 1);
        //printDatabase();
    }

    private void printDatabase() {
        dbTextView.setText(dbHandler.dbToString());
        infoTextView.setText("");
    }

    public void addRowOnClick(View view) {
        if (infoTextView.getText().length() > 0) {
            dbHandler.addProduct(new Products(infoTextView.getText().toString()));
            printDatabase();
        }
    }

    public void deleteRowOnClick(View view) {
        if (infoTextView.getText().length() > 0) {
            dbHandler.deleteProduct(infoTextView.getText().toString());
            printDatabase();
        }
    }
}
