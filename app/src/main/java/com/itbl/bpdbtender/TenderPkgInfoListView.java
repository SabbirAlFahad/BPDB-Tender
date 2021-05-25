package com.itbl.bpdbtender;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class TenderPkgInfoListView extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    TenderPkgInfoListAdapter tenderPkgInfoListAdapter;
    ListView listView;
    TenderPkgInfoList tenderPkgInfoList;
    ArrayList<TenderPkgInfoList> tenderPkgInfoLists=new ArrayList<>();
    SharedPreferences sharedPreferences;
    String strLoction="" , packageID = "";

    Bundle bundle=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_list_package_detail);
        listView = (ListView) findViewById(R.id.table_pkjlist);


        bundle = getIntent().getExtras();
        if(bundle!=null){
            packageID = bundle.getString("packageID");
                Tender task = new Tender(TenderPkgInfoListView.this);
                task.execute();
            }





        }

    public class Tender extends AsyncTask<Void, Void, String> {
        @SuppressWarnings("unused")
        private Activity context;

        @SuppressWarnings("unused")
        ProgressDialog pd=null;


        public Tender(Activity context) {
            this.context = context;

        }

        @Override
        protected void onPreExecute() {
            pd = ProgressDialog.show(TenderPkgInfoListView.this, " Processing",
                    "Please wait...");
        }

        @Override
        protected String doInBackground(Void... params) {
//
            String result = "";

            try {




                String  district,division,sf_detail,est_cost,thana,currency;


                try {

                    String response = CustomHttpClientGet.execute("http://192.168.0.103:8003/packageInfo/"+packageID);

                    result = response.toString();
                    //result=result.replaceAll("[^a-zA-Z0-9]+","");

                } catch (Exception e) {
                    Log.e("log_tag", "Error in http connection!!" + e.toString());

                }

               // JSONArray jsonArray = new JSONArray(result.toString());

              //  while (count < jsonArray.length()) {

                JSONObject JO = new JSONObject(result);

                   sf_detail = JO.getString("sf_DESC");
                    est_cost = JO.getString("est_COST");
                    currency = JO.getString("currency_DESC");
                    district = JO.getString("dist_DESC");
                    thana = JO.getString("thana_DESC");
                    division = JO.getString("div_DESC");


                    TenderPkgInfoList tenderPkgInfoList = new TenderPkgInfoList( sf_detail,est_cost,currency,district,thana,division);

                    tenderPkgInfoLists.add(tenderPkgInfoList);
                    //count++;



            }

            catch (Exception e) {
                Log.e("log_tag", "Error in http connection!!" + e.toString());

            }


            return result;


        }

        @Override
        protected void onPostExecute(String result) {
            pd.dismiss();

            tenderPkgInfoListAdapter =new TenderPkgInfoListAdapter(TenderPkgInfoListView.this,tenderPkgInfoLists);
            listView.setAdapter(tenderPkgInfoListAdapter);




        }

    }}
