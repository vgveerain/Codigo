package com.bumos.vgvee.codigo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    EditText pNum;
    Button pSend;
    TextView textView,textView2;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBacks;
    FirebaseAuth mAuth;
    ImageView imageView;
    PhoneAuthProvider.ForceResendingToken mResendToken;
    String mVerificationId;
    private int btnType=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pNum = findViewById(R.id.pNumber);
        pSend = findViewById(R.id.sNumber);
        mAuth = FirebaseAuth.getInstance();
        textView = findViewById(R.id.tView1);
        textView2 = findViewById(R.id.tView2);
        imageView = findViewById(R.id.loginImage);

            pSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (btnType == 0) {
                        String phoneNumber = pNum.getText().toString();

                        if (phoneNumber.length() == 10) {

                            PhoneAuthProvider.getInstance().verifyPhoneNumber("+91"+phoneNumber,
                                    60,
                                    TimeUnit.SECONDS,
                                    LoginActivity.this,
                                    mCallBacks
                            );
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Please enter a Number", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        String verificationCode = pNum.getText().toString();

                        if(verificationCode.length() == 6)
                        {
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, verificationCode);
                        signInWithPhoneAuthCredential(credential);
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Please enter the verification code",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

        mCallBacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

                Log.d("TAG", "onVerificationCompleted:" + phoneAuthCredential);

                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

                Toast.makeText(LoginActivity.this, "Invalid mobile number", Toast.LENGTH_SHORT).show();
                }


            @Override
            public void onCodeSent(String verificationId,
                                   PhoneAuthProvider.ForceResendingToken token) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                Log.d("TAG", "onCodeSent:" + verificationId);

                // Save verification ID and resending token so we can use them later
                mVerificationId = verificationId;
                mResendToken = token;
                btnType =1;
                textView.setText("OTP Verification");
                textView2.setText("Enter the 6-digit OTP sent to your mobile number");
                imageView.setImageResource(R.drawable.verify);
                pNum.setText("");
                pSend.setText("Verify OTP");
                // ...
            }
        };
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithCredential:success");

                            Toast.makeText(LoginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();

                            FirebaseUser user = task.getResult().getUser();

                            Intent newIntent = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(newIntent);
                            finish();

                            // ...
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w("TAG", "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(LoginActivity.this, "The verification code entered was invalid", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    @Override
    public void onBackPressed() {
        if(btnType == 1) {
            btnType = 0;
            textView.setText("Verify Your Number");
            textView2.setText("Please enter your 10-digit mobile number to receive a verification code.Carrier rates may apply.");
            pNum.setText("");
            imageView.setImageResource(R.drawable.login);
            pSend.setText("Continue");
        }
        else
        {
            super.onBackPressed();
        }
    }

}
