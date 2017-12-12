package com.example.marco.contacts_isi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.marco.contacts_isi.model.Contact;

public class AddActivity extends AppCompatActivity {

    public static final String EXTRA_CONTACT =
            "com.example.marco.EXTRA_CONTACT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button button_add = findViewById(R.id.button_add);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText_addId = findViewById(R.id.editText_addPhone);
                String idAsString = editText_addId.getText().toString();
                int id = Integer.parseInt(idAsString);

                EditText editText_addName = findViewById(R.id.editText_addName);
                String name = editText_addName.getText().toString();

                // Criar contacto
                Contact newContact = new Contact(name, id);

                // devolver o contacto a MainActivity
                Intent returnIntent = new Intent();
                returnIntent.putExtra(EXTRA_CONTACT, newContact);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
