    package com.example.marco.contacts_isi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.marco.contacts_isi.model.Agenda;
import com.example.marco.contacts_isi.model.Contact;

import java.util.ArrayList;

    public class SearchActivity extends AppCompatActivity {

    private Agenda agenda;
    private ListView listView_search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent intent = getIntent();
        this.agenda =
                (Agenda) intent.getSerializableExtra(MainActivity.EXTRA_AGENDA);
        this.listView_search = findViewById(R.id.listView_search);
    }

    public void button_search_onClick(View view) {

            EditText editText_search = findViewById(R.id.editText_search);

            String nameToSearch = editText_search.getText().toString();

            ArrayList<Contact> searchedContacts =
                    agenda.searchContactByName(nameToSearch);

            ArrayAdapter<Contact> adapter = new ArrayAdapter<Contact>(
                    this,
                    android.R.layout.simple_list_item_1,searchedContacts);

            listView_search.setAdapter(adapter);

            if (searchedContacts.isEmpty())
            {

                Toast.makeText(this, "No Contacts found...", Toast.LENGTH_LONG).show();
            }
        }

    }
