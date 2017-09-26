package com.trungnguyeen.danhba;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.trungnguyeen.danhba.adater.ContactAdapter;
import com.trungnguyeen.danhba.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Contact> arrContact;
    private ContactAdapter contactAdapter;

    private EditText edtName;
    private EditText edtPhone;
    private RadioButton rbtnMale;
    private RadioButton rbtnFemale;
    private Button btnAddContact;
    private ListView lvContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();



    }

    private void addControls() {
        edtName = (EditText) findViewById(R.id.edt_name);
        edtPhone = (EditText) findViewById(R.id.edt_phoneNumber);
        rbtnMale = (RadioButton) findViewById(R.id.rbtn_male);
        rbtnFemale = (RadioButton) findViewById(R.id.rbtn_fmale);
        btnAddContact = (Button) findViewById(R.id.btn_add);

        lvContact = (ListView) findViewById(R.id.lv_Contact);
        arrContact = new ArrayList<>();
        contactAdapter = new ContactAdapter(MainActivity.this, R.layout.item_contact_listview, arrContact);
        lvContact.setAdapter(contactAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showDialogConfirm(i);
            }
        });
    }



    public void addContact(View view) {
        if(view.getId()==R.id.btn_add){
            String name = edtName.getText().toString().trim();
            String phoneNumber = edtPhone.getText().toString().trim();
            boolean isMale = true;
            if(rbtnFemale.isChecked()){
                isMale = false;
            }

            if(TextUtils.isEmpty(name) || TextUtils.isEmpty(phoneNumber)){
                Toast.makeText(this, "Please input Name and Phone Number", Toast.LENGTH_SHORT).show();
            }
            else{
                Contact contact = new Contact(isMale, name, phoneNumber);
                arrContact.add(contact);
            }
            contactAdapter.notifyDataSetChanged();
        }
    }


    public void hideSoftKeyboard(View view) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) MainActivity.this.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                MainActivity.this.getCurrentFocus().getWindowToken(), 0);
    }


    private void showDialogConfirm(final int position) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_layout);

        Button btnCall = (Button) dialog.findViewById(R.id.btn_call);
        Button btnSendMessage = (Button) dialog.findViewById(R.id.btn_sendMessage);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentCall(position);
            }
        });

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Send Message", Toast.LENGTH_SHORT).show();
            }
        });


        dialog.show();
    }


    private void IntentCall(int position) {
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_CALL);
//
//        intent.setData(Uri.parse("tel:" + arrContact.get(position).getmPhoneNumber().toString().trim()));
//        startActivity(intent);
        Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show();
    }

}
