package com.itbl.bpdbtender;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class Dashboard extends AppCompatActivity{
    ImageView pdb_logo, itbl_logo;
    TextView welcome, tinfo, tcompany, topen, tclosing, tcontract, itbl;
    Button btn_pkjinfo, btn_suppliers, btn_topen, btn_tclosing, btn_tcontract, btn_logout, logout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        pdb_logo =  findViewById(R.id.pdb_logo);
        itbl_logo =  findViewById(R.id.itbl_logo);

        welcome =  findViewById(R.id.txt_welcome);
        tinfo =  findViewById(R.id.txt_tinfo);
        tcompany =  findViewById(R.id.txt_tcompany);
        tclosing =  findViewById(R.id.txt_tclosing);
        tcontract =  findViewById(R.id.txt_tcontract);
        logout =  findViewById(R.id.btn_logout);
        itbl =  findViewById(R.id.txt_itbl);

        btn_pkjinfo =  findViewById(R.id.btn_tinfo);
        btn_suppliers =  findViewById(R.id.btn_tcompany);
        btn_tclosing =  findViewById(R.id.btn_tclosing);
        btn_tcontract =  findViewById(R.id.btn_tcontract);
        btn_logout =  findViewById(R.id.btn_logout);

        welcome.setTypeface(ResourcesCompat.getFont(this, R.font.aldrich));
        tinfo.setTypeface(ResourcesCompat.getFont(this, R.font.aldrich));
        tcompany.setTypeface(ResourcesCompat.getFont(this, R.font.aldrich));
        tclosing.setTypeface(ResourcesCompat.getFont(this, R.font.aldrich));
        tcontract.setTypeface(ResourcesCompat.getFont(this, R.font.aldrich));
        logout.setTypeface(ResourcesCompat.getFont(this, R.font.aldrich));
        itbl.setTypeface(ResourcesCompat.getFont(this, R.font.aldrich));

        btn_pkjinfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                goToPackageInfo();
            }
        });

        btn_suppliers.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                goToAppliedSupplers();
            }
        });


        btn_tcontract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToContractList();
            }
        });

        btn_tclosing.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                goToClosingTender();
            }
        });


        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                goToLogin();
                SharedPreferences loginPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor preferencesEditor = loginPreferences.edit();
                preferencesEditor.putString("remember", "false");
                preferencesEditor.apply();
            }
        });
    }

    public void goToLogin(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    private void goToContractList(){
        Intent intent = new Intent(this, ContractListView.class);
        startActivity(intent);
    }

    private void goToClosingTender(){
        Intent intent = new Intent(this, ExpireTenderList.class);
        startActivity(intent);
    }



    private void goToAppliedSupplers(){
        Intent intent = new Intent(this,ProjectNameView2.class);
        startActivity(intent);
    }

    private void goToPackageInfo(){
        Intent intent = new Intent(this, ProjectNameView.class);
        startActivity(intent);
    }

}
