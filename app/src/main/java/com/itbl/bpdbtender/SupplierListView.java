package com.itbl.bpdbtender;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SupplierListView extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    SupplierListAdapter supplierListAdapter;
    ListView listView;
    SupplierList supplierList;
    ArrayList<SupplierList> supplierLists=new ArrayList<>();
    SharedPreferences sharedPreferences;
    String strLoction="",projID="";


    Bundle bundle=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_suppler_list);
        listView = (ListView) findViewById(R.id.table_suplist);

        bundle = getIntent().getExtras();
        if(bundle!=null){
            projID = bundle.getString("projID");
            Supply task = new Supply(SupplierListView.this);
            task.execute();
        }





    }

    public class Supply extends AsyncTask<Void, Void, String> {
        @SuppressWarnings("unused")
        private Activity context;

        @SuppressWarnings("unused")
        ProgressDialog pd=null;


        public Supply(Activity context) {
            this.context = context;

        }

        @Override
        protected void onPreExecute() {
            pd = ProgressDialog.show(SupplierListView.this, " Processing",
                    "Please wait...");
        }

        @Override
        protected String doInBackground(Void... params) {
//
            String result = "";

            try {


                int count = 0;

                String expiry_date,ref_date,sup_name,bank_name,ts_ref_no,bi_desc,ts_value,issue_date,ref_no,price,pkg_name,bracnh_name,currency;

                try {

                    String response = CustomHttpClientGet.execute("http://192.168.0.103:8003/SupplierInfo/"+projID);

                    result = response.toString();
                    //result=result.replaceAll("[^a-zA-Z0-9]+","");

                } catch (Exception e) {
                    Log.e("log_tag", "Error in http connection!!" + e.toString());

                }
                JSONArray jsonArray = new JSONArray(result.toString());

                while (count < jsonArray.length()){

                    JSONObject JO = jsonArray.getJSONObject(count);


                    expiry_date = JO.getString("ts_EXP_DATE");
                    ref_date = JO.getString("ref_DATE");
                    sup_name = JO.getString("sup_NAME");
                    bank_name = JO.getString("bank_NAME");
                    ts_ref_no = JO.getString("ts_REF_NO");
                    bi_desc = JO.getString("bi_DESC");
                    ts_value = JO.getString("ts_VALUE");
                    issue_date = JO.getString("ts_ISSUE_DATE");
                    ref_no = JO.getString("ref_NO");
                    price = JO.getString("quoted_PRICE");
                    pkg_name = JO.getString("pk_DESC");
                    bracnh_name = JO.getString("branch_NAME");
                    currency = JO.getString("currency_DESC");



                    SupplierList supplierList = new SupplierList( expiry_date,ref_date,sup_name,bank_name,ts_ref_no,bi_desc,ts_value,issue_date,
                            ref_no,price,pkg_name,bracnh_name,currency);

                    supplierLists.add(supplierList);
                    count++;
                }


            }

            catch (Exception e) {
                Log.e("log_tag", "Error in http connection!!" + e.toString());

            }


            return result;


        }

        @Override
        protected void onPostExecute(String result) {
//            if(result=="[]/n"){
//                Toast.makeText(ProjectDetailView.this,"hjfhjkhfj",Toast.LENGTH_SHORT).show();
//
//            }

            pd.dismiss();


            supplierListAdapter =new SupplierListAdapter(SupplierListView.this,supplierLists);
            listView.setAdapter(supplierListAdapter);


//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Intent intent = new Intent(ProjectDetailView.this, TenderPkgInfoListView.class);
//                    intent.putExtra("packageID",projectDetails.get(position).getPkj_id());
//                    startActivity(intent);


//
//                }
//            });

        }

    }
}

