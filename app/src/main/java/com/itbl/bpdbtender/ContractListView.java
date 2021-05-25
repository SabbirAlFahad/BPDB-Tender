package com.itbl.bpdbtender;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ContractListView extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContractListAdapter contractListAdapter;
    ListView listView;
    ContractList contractList;
    ArrayList<ContractList> contractLists=new ArrayList<>();
    SharedPreferences sharedPreferences;
    String strLoction="",projID="";


    Bundle bundle=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_contract_list);
        listView = (ListView) findViewById(R.id.table_conlist);

        bundle = getIntent().getExtras();
        if(bundle!=null){
            projID = bundle.getString("projID");
            ContractListView.Supply task = new ContractListView.Supply(ContractListView.this);
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
            pd = ProgressDialog.show(ContractListView.this, " Processing",
                    "Please wait...");
        }

        @Override
        protected String doInBackground(Void... params) {
//
            String result = "";

            try {


                int count = 0;

                String contract_currType,contract_price,contract_value,contract_No,contract_issueD,
                        contract_type,contract_bankName,contract_pkgDetails,contract_RefNo,
                        contract_suppName,contract_securityInfo,contract_Date,contract_branchName,contract_expiryD;

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


                    contract_currType = JO.getString("contract_currType");
                    contract_price = JO.getString("contract_price");
                    contract_value = JO.getString("contract_value");
                    contract_No = JO.getString("contract_No");
                    contract_issueD = JO.getString("contract_issueD");
                    contract_type = JO.getString("contract_type");
                    contract_bankName = JO.getString("contract_bankName");
                    contract_pkgDetails = JO.getString("contract_pkgDetails");
                    contract_RefNo = JO.getString("contract_RefNo");
                    contract_suppName = JO.getString("contract_suppName");
                    contract_securityInfo = JO.getString("contract_securityInfo");
                    contract_Date = JO.getString("contract_Date");
                    contract_branchName = JO.getString("contract_branchName");
                    contract_expiryD = JO.getString("contract_expiryD");



                    ContractList contractList = new ContractList( contract_currType,contract_price,contract_value,contract_No,
                            contract_issueD,contract_type,contract_bankName,contract_pkgDetails,
                            contract_RefNo,contract_suppName,contract_securityInfo,contract_Date,contract_branchName,contract_expiryD);

                    contractLists.add(contractList);
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


            contractListAdapter =new ContractListAdapter(ContractListView.this,contractLists);
            listView.setAdapter(contractListAdapter);


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
