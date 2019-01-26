package com.bumos.vgvee.codigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class ReferralActivity extends AppCompatActivity {

    DatabaseReference rootReference, childReference;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;

    Button referralGo, referralSkip;
    EditText referralCode;

    User user;
    User u;

    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referral);

        user = getIntent().getParcelableExtra("user");

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        rootReference = firebaseDatabase.getReference();
        childReference = rootReference.child(firebaseAuth.getCurrentUser().getUid());

        referralGo = findViewById(R.id.referralGo);
        referralSkip = findViewById(R.id.referralSkip);

        referralCode = findViewById(R.id.referralCode);
//        InputFilter filter = new InputFilter() {
//            boolean canEnterSpace = false;
//
//            public CharSequence filter(CharSequence source, int start, int end,
//                                       Spanned dest, int dstart, int dend) {
//                canEnterSpace = false;
//
//                StringBuilder builder = new StringBuilder();
//
//                for (int i = start; i < end; i++) {
//                    char currentChar = source.charAt(i);
//
//                    if (Character.isLetterOrDigit(currentChar)) {
//                        builder.append(currentChar);
//                        canEnterSpace = true;
//                    }
//
//                    if(Character.isWhitespace(currentChar) && canEnterSpace) {
//                        builder.append(currentChar);
//                    }
//
//
//                }
//                return builder.toString();
//            }
//
//        };
//        referralCode.setFilters(new InputFilter[]{filter});

        String key = firebaseAuth.getCurrentUser().getUid().toString();
        String selfRef = key.substring(0, 6);
        Query query1 = rootReference.orderByChild("ReferralCodeSelf").equalTo(selfRef);
        query1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                User cu = dataSnapshot.getValue(User.class);
                referralCode.setText(cu.ReferralCodeReceived);

                flag = true;
                Intent intent = new Intent(ReferralActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        referralGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean ans = referralGo();
                if(ans){
                    Log.e("TAG1", ""+u.Key);
//                    rootReference.child(u.Key).setValue(u);
                    Map<String, Object> update2 = new HashMap<>();
                    update2.put("referrals", u.referrals+1);
                    update2.put("Name", u.Name);
                    update2.put("Email", u.Email);
                    update2.put("PhoneNum", u.PhoneNum);
                    update2.put("ReferralCodeSelf", u.ReferralCodeSelf);
                    update2.put("ReferralCodeReceived", u.ReferralCodeReceived);
                    update2.put("Key", u.Key);
                    rootReference.child(u.Key).updateChildren(update2);

                    flag = true;

                    Intent intent = new Intent(ReferralActivity.this, MainActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                    finish();
                }
            }
        });

        referralSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                referralSkip();

                flag = true;

                Intent intent = new Intent(ReferralActivity.this, MainActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }

    boolean referralGo(){
        String recRef = referralCode.getText().toString();
        String key = firebaseAuth.getCurrentUser().getUid().toString();
        String selfRef = key.substring(0, 6);
        user.ReferralCodeSelf = selfRef;
//        user.ReferralCodeReceived = recRef;
        boolean answer = checkReferral(recRef);
        if(answer){
            user.ReferralCodeReceived = recRef;
            Map<String, Object> update = new HashMap<>();
            update.put("ReferralCodeSelf", selfRef);
            update.put("ReferralCodeReceived", recRef);
            update.put("Key", key);
            update.put("Name", user.Name);
            update.put("Email", user.Email);
            update.put("PhoneNum", user.PhoneNum);
            update.put("referrals", 0);
            childReference.updateChildren(update);

            return true;
        }else{
            Toast.makeText(this, "Try Again!", Toast.LENGTH_SHORT).show();
            Log.e("TAG", ""+answer);
            return false;
        }
    }

    boolean checkReferral(String recRef){

        Query query = rootReference.orderByChild("ReferralCodeSelf").equalTo(recRef);
//        Query query = rootReference.orderByChild("Ref").startAt(recRef);
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();
//                for(DataSnapshot ds : dataSnapshots){
//                    u = ds.getValue(User.class);
//                }
                User cu = dataSnapshot.getValue(User.class);
                u = cu;
                Log.e("TAG", ""+dataSnapshot);
                Log.e("TAG", ""+u.Key);
//                u = dataSnapshot.getValue(User.class);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
//        query.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                u = dataSnapshot.getValue(User.class);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
        if(u == null){
            return false;
        }else{
            return true;
        }
    }

    void referralSkip(){
        String key = firebaseAuth.getCurrentUser().getUid().toString();
        String selfRef = key.substring(0, 6);
        user.ReferralCodeSelf = selfRef;
        user.ReferralCodeReceived = "";
        user.Key = key;

        Map<String, Object> update = new HashMap<>();
        update.put("ReferralCodeSelf", selfRef);
        update.put("ReferralCodeReceived", "");
        update.put("Key", key);
        update.put("Name", user.Name);
        update.put("Email", user.Email);
        update.put("PhoneNum", user.PhoneNum);
        update.put("referrals", 0);
        childReference.updateChildren(update);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(!flag){
            FirebaseAuth.getInstance().signOut();
        }
    }
}
