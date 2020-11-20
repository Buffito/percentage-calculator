package com.example.shade.percentagecalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int perc;
    float price,result;
    String temp1,temp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Button calc = findViewById(R.id.button);
        final EditText pricetag = findViewById(R.id.editText);
        final EditText percentage = findViewById(R.id.editText2);
        final AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pricetag.getText().toString().isEmpty() || percentage.getText().toString().isEmpty()){
                    dlgAlert.setMessage("Ουπς, κάτι πήγε στράβα  :( ");
                    dlgAlert.setTitle("Σφάλμα!");
                    dlgAlert.setCancelable(true);
                    dlgAlert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    pricetag.getText().clear();
                                    percentage.getText().clear();
                                }
                            });

                    dlgAlert.setNegativeButton("Κλείσιμο",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                    System.exit(0);
                                }
                            });
                    dlgAlert.create().show();
                }else{
                    temp1 = pricetag.getText().toString();
                    temp2 = percentage.getText().toString();
                    perc = Integer.parseInt(temp2);
                    price = Float.parseFloat(temp1);
                    result = price - (price * ((float)perc / 100));
                    dlgAlert.setMessage("Η τελική τιμή είναι " + result);
                    dlgAlert.setTitle("Τελική τιμή");
                    dlgAlert.setCancelable(true);
                    dlgAlert.setNegativeButton("Κλείσιμο",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                    System.exit(0);
                                }
                            });
                    dlgAlert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    pricetag.getText().clear();
                                    percentage.getText().clear();
                                }
                            });

                    dlgAlert.create().show();
                }

            }
        });


    }
}
