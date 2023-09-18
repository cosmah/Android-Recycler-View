package com.cosmah.androidrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactRecViewAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<Contact> contacts = new ArrayList<>();

    private Context context;
    private RecyclerView.ViewHolder holder;
    private int position;

    //constructor
    public ContactRecViewAdaptor(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item,parent,false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder myHolder = (ViewHolder) holder;
        myHolder.txtName.setText(contacts.get(position).getName());
        myHolder.txtEmail.setText(contacts.get(position).getEmail());
        myHolder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = myHolder.getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    Toast.makeText(context, contacts.get(pos).getName() + " is selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    //count items in adaptor
    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        //update data
        notifyDataSetChanged();
    }


    //responsible for holding data
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName, txtEmail;
        private CardView parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
