package com.cosmah.androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactRecView = findViewById(R.id.contactRecyclerView);
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("John Doe", "johndoe@example.com", "https://i.pravatar.cc/150?img=1"));
        contacts.add(new Contact("Jane Smith", "janesmith@example.com", "https://i.pravatar.cc/150?img=2"));
        contacts.add(new Contact("Bob Johnson", "bobjohnson@example.com", "https://i.pravatar.cc/150?img=3"));
        contacts.add(new Contact("Alice Williams", "alicewilliams@example.com", "https://i.pravatar.cc/150?img=4"));
        contacts.add(new Contact("Charlie Brown", "charliebrown@example.com", "https://i.pravatar.cc/150?img=5"));
        contacts.add(new Contact("David Davis", "daviddavis@example.com", "https://i.pravatar.cc/150?img=6"));
        contacts.add(new Contact("Eva Green", "evagreen@example.com", "https://i.pravatar.cc/150?img=7"));
        contacts.add(new Contact("Frank Sinatra", "franksinatra@example.com", "https://i.pravatar.cc/150?img=8"));
        contacts.add(new Contact("Grace Kelly", "gracekelly@example.com", "https://i.pravatar.cc/150?img=9"));
        contacts.add(new Contact("Harry Potter", "harrypotter@example.com", "https://i.pravatar.cc/150?img=10"));
        // Now your contacts ArrayList is populated with ten Contact objects.

        ContactRecViewAdaptor adaptor = new ContactRecViewAdaptor(this);
        adaptor.setContacts(contacts);

        contactRecView.setAdapter(adaptor);
        //set layout manager
        //linear
        //contactRecView.setLayoutManager(new LinearLayoutManager(this));

        //linear horizontal
        //contactRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        //grid layout manager
        contactRecView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}