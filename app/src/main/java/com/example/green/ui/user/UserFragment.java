package com.example.green.ui.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.green.R;
import com.example.green.RetrievingDataFromFirebase;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class UserFragment extends Fragment {
    private SharedPreferences sharedPreferences;
    private String SHARED_PREFS = "shared preference";
    private UserViewModel homeViewModel;
    private ImageView qrcode;
    private TextView balance_txt;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(UserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user, container, false);
        sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        String usr_name = sharedPreferences.getString("username", null);
        String password = sharedPreferences.getString("password", null);
        TextView username_text = root.findViewById(R.id.usernameProfile);
        TextView password_text = root.findViewById(R.id.passwordProfile);
        balance_txt = root.findViewById(R.id.balanceProfile);
        username_text.setText("Username: "+ usr_name);
        password_text.setText("Password: "+ password);
        Button button = root.findViewById(R.id.getqrcode);
        qrcode = root.findViewById(R.id.qrcode);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrievingDataFromFirebase retrievingDataFromFirebase = new RetrievingDataFromFirebase();
                String text = retrievingDataFromFirebase.retrieveUserID();

                if (text != null){
                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                    BitMatrix bitMatrix = null;
                    try {
                        bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 350, 350);
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                        qrcode.setImageBitmap(bitmap);
                        String balance = sharedPreferences.getString("balance", "0");
                        balance_txt.setText("Balance: " +balance);


                    } catch (WriterException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        return root;
    }
}