package com.example.isi_edu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class InscriptionActivity extends AppCompatActivity {
    private EditText txtFirstName, txtLastName;
    private CheckBox cbOLevel, cbBachelor, cbMaster;
    private Button btnSave;
    private String firstName, lastName, degrees, formation;
    private String signal = "Tous les elements doivent etre renseigner !!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        cbOLevel = findViewById(R.id.cbOLevel);
        cbBachelor = findViewById(R.id.cbBachelor);
        cbMaster = findViewById(R.id.cbMaster);
        btnSave = findViewById(R.id.btnSave);
        formation = getIntent().getStringExtra("FORMATION"); // Recupere le nom de la formation

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = txtFirstName.getText().toString().trim();
                lastName = txtLastName.getText().toString().trim();
                degrees="";

                if(cbOLevel.isChecked()){
                    degrees+=cbOLevel.getText().toString()+" ";
                }
                if(cbBachelor.isChecked()){
                    degrees+=cbBachelor.getText().toString()+" ";
                }
                if(cbMaster.isChecked()){
                    degrees+=cbMaster.getText().toString()+" ";
                }

                String resume = formation+"\n\n"+firstName+"\n\n"+lastName+"\n\n"+degrees;
                txtFirstName.setText("");
                txtLastName.setText("");
                if(!firstName.isEmpty() & !lastName.isEmpty() & !degrees.isEmpty()){
                    Toast.makeText(InscriptionActivity.this, resume, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(InscriptionActivity.this, signal, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
