package com.trungnguyeen.danhba.adater;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.trungnguyeen.danhba.R;
import com.trungnguyeen.danhba.model.Contact;

import java.util.List;

/**
 * Created by trungnguyeen on 9/15/17.
 */

public class ContactAdapter extends ArrayAdapter<Contact>{

    private Context context;
    private int resource;
    private List<Contact> arrContact;
    public ContactAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.arrContact = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_contact_listview, parent, false);

            viewHolder.imgAvatar = (ImageView) convertView.findViewById(R.id.img_avatar);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txt_name);
            viewHolder.txtPhoneNumber = (TextView) convertView.findViewById(R.id.txt_phonenumber);

            convertView.setTag(viewHolder);

        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contact contact = arrContact.get(position);


        viewHolder.txtName.setText(contact.getmName());
        viewHolder.txtPhoneNumber.setText(contact.getmPhoneNumber());

        if(contact.isMale()){
            viewHolder.imgAvatar.setBackgroundResource(R.drawable.male);

        }else{
            viewHolder.imgAvatar.setBackgroundResource(R.drawable.female);
        }

        return convertView;
    }

    public class ViewHolder{
        ImageView imgAvatar;
        TextView txtName;
        TextView txtPhoneNumber;
    }
}
