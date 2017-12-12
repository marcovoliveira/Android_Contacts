package com.example.marco.contacts_isi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marco.contacts_isi.model.Agenda;
import com.example.marco.contacts_isi.model.Contact;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ADD = 1;
    public static final String EXTRA_AGENDA = "pt.ipleiria.contacts.AGENDA";
    private Agenda agenda;
    private ArrayAdapter<Contact> adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.agenda = new Agenda();

        Contact c1 = new Contact("Francisco Stromp", 961223344);
        Contact c2 = new Contact("Fernando Peyroteo", 932323232);
        Contact c3 = new Contact("Vítor Damas", 915566677);
        Contact c4 = new Contact("Rui Jordão", 967659876);
        Contact c5 = new Contact("Joseph Szabo", 234678905);
        this.agenda.addContact(c1);
        this.agenda.addContact(c2);
        this.agenda.addContact(c3);
        this.agenda.addContact(c4);
        this.agenda.addContact(c5);

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                agenda.getContacts());
        listView = findViewById(R.id.listView_contacts);
        listView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onClick_AddItem(MenuItem item) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivityForResult(intent, REQUEST_CODE_ADD);


    }

    public void onClick_SearchItem(MenuItem item) {
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra(EXTRA_AGENDA, agenda);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD) {
            if (resultCode == RESULT_OK) {
                Contact contact = (Contact)
                        data.getSerializableExtra(AddActivity.EXTRA_CONTACT);
                try {
                    agenda.addContact(contact);
                    adapter.notifyDataSetChanged();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    new AlertDialog.Builder(this).setMessage(e.getMessage()).show();
                }
            }


        }
    }
}


