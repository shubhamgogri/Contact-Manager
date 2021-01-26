package com.example.new_data.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.new_data.Main2Activity;
import com.example.new_data.MainActivity;
import com.example.new_data.R;
import com.example.new_data.model.Contact;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private Context context;
    private List<Contact> contactList;


    public RecyclerViewAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_row,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Contact contact = contactList.get(position);

        viewHolder.contact_name.setText(contact.getName());
        viewHolder.contact_phone.setText(contact.getPhoneNumber());

    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView contact_name;
        public TextView contact_phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contact_name = itemView.findViewById(R.id.name);
            contact_phone = itemView.findViewById(R.id.phone_no);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            Contact contact = contactList.get(position);

            Intent intent = new Intent(context, Main2Activity.class);
            intent.putExtra("name", contact.getName());
            intent.putExtra("phone", contact.getPhoneNumber());
            context.startActivity(intent);
        }
    }
}
