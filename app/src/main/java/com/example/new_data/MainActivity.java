package com.example.new_data;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.new_data.adapter.RecyclerViewAdapter;
import com.example.new_data.data.DatabaseHandler;
import com.example.new_data.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageButton new_Contact_Button;
    private String new_phone;
    private String new_name;

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private ArrayList<Contact> contactArrayList;
    private EditText dets_name;
    private EditText dets_phone;
    private Button dets_button;
    private ArrayAdapter<String> arrayAdapter;
    DatabaseHandler db  = new DatabaseHandler(MainActivity.this);
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        Bundle bundle = getIntent().getExtras();
//        assert bundle != null;
//        new_name =  bundle.getString("name");
//        new_phone = bundle.getString("phone");
//        Contact new_contact = new Contact(new_name,new_phone);
//        db.addContact(new_contact);
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new_Contact_Button = findViewById(R.id.new_contact);
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));



        Log.d("Count", "onCreate: " + db.getCount());
//        db.addContact(new Contact("Shubham","9699957337"));
//        db.addContact(new Contact("Kajal","9819774563"));
//        db.addContact(new Contact("Papa","9833431481"));
//        db.addContact(new Contact("Mummy","9619285004"));
//        db.addContact(new Contact("Me","9004201078"));
//        db.addContact(new Contact("Don","8169334931"));
//
//        db.addContact(new Contact("Kiara","957131513"));
//        db.addContact(new Contact("Hritik","197648235"));
//        db.addContact(new Contact("Akshay","963147852"));
//        db.addContact(new Contact("Chris","789431562"));
//        db.addContact(new Contact("Kane","1387946550"));
//        db.addContact(new Contact("David","643254513"));
        contactArrayList = new ArrayList<>();


        new_Contact_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopUpDialog();
                dets_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new_name= dets_name.getText().toString();
                        new_phone = dets_phone.getText().toString();
                        db.addContact(new Contact(new_name,new_phone));
                        Toast.makeText(MainActivity.this, "Contact Saved", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        });

//        Contact c = db.getContact(37);
//        db.deleteContact(c);
//        Contact c1 = db.getContact(38);
//        db.deleteContact(c1);
//        Contact c2 = db.getContact(39);
//        db.deleteContact(c2);
//        Contact c3 = db.getContact(40);
//        db.deleteContact(c3);
//        Contact c4 = db.getContact(41);
//        db.deleteContact(c4);
//        Contact c5 = db.getContact(42);
//        db.deleteContact(c5);

//
//        c.setName("Shubham");
//        c.setPhoneNumber("123456");
//        int updateRow = db.updateContact(c);
//        Log.d( "UpadatedRow", "onCreate: "+ updateRow);

//        db.addContact(shubham);
//        Contact contact = db.getContact(1);
//        Log.d("Getting", "onCreate: " + contact.getName() + contact.getPhoneNumber());


//      iterating the contents
        List<Contact> contacts = db.getAllContacts();
        for (Contact contact: contacts){
            Log.d("MainActivity", "onCreate: "+ contact.getId() +" " + contact.getName() + " " + contact.getPhoneNumber());
            contactArrayList.add(contact);
        }


        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,contactArrayList);

        recyclerView.setAdapter(recyclerViewAdapter);



    }

    private void createPopUpDialog() {
        builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.new_contact,null);
        dets_name = view.findViewById(R.id.new_name);
        dets_phone = view.findViewById(R.id.new_phone);
        dets_button = view.findViewById(R.id.dets_button);

        builder.setView(view);
        dialog = builder.create();
        dialog.show();




    }
}


















//        Contact jeremy = new Contact();
//        jeremy.setName("Jeremy");
//        jeremy.setPhoneNumber("9856315");
//
//        Contact shubham = new Contact();
//        shubham.setName("Jeremy");
//        shubham.setPhoneNumber("9856315");
//
//

