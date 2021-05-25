package com.itbl.bpdbtender;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProjectDetailView extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ProjectDetailAdapter projectDetailAdapter;
    ListView listView;
    ProjectDetail ProjectDetail;
    ArrayList<ProjectDetail> projectDetails=new ArrayList<>();
    SharedPreferences sharedPreferences;
    String strLoction="",projID="";


    Bundle bundle=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_details_listview);
        listView = (ListView) findViewById(R.id.table_projectdtllist);

        bundle = getIntent().getExtras();
        if(bundle!=null){
            projID = bundle.getString("projID");
            ProjectDetailView.Tender task = new Tender(ProjectDetailView.this);
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
            pd = ProgressDialog.show(ProjectDetailView.this, " Processing",
                    "Please wait...");
        }

        @Override
        protected String doInBackground(Void... params) {
//
            String result = "";

            try {


              int count = 0;

                String closing_date,pkg_no,ref_date,ref_no,opening_date,currency_name,location,cntr_type,pkg_name,pkgId,fc_curr;

                try {

                    String response = CustomHttpClientGet.execute("http://192.168.0.103:8003/projectDetail/"+projID);

                    result = response.toString();
                    //result=result.replaceAll("[^a-zA-Z0-9]+","");

                } catch (Exception e) {
                    Log.e("log_tag", "Error in http connection!!" + e.toString());

                }
                JSONArray jsonArray = new JSONArray(result.toString());

                while (count < jsonArray.length()){

                    JSONObject JO = jsonArray.getJSONObject(count);


                    ref_date = JO.getString("ref_DATE");
                    cntr_type = JO.getString("cntr_TYPE_DESC");
                    opening_date = JO.getString("opening_DATE");
                    pkg_no = JO.getString("pkj_NO");
                    location = JO.getString("ts_VALUE_LOC");
                    fc_curr = JO.getString("ts_VALUE_FC");
                    pkg_name = JO.getString("pk_DESC");
                    ref_no = JO.getString("ref_NO");
                    currency_name = JO.getString("currency_DESC");
                    closing_date = JO.getString("closing_DATE");
                    pkgId = JO.getString("pkj_ID");

                    ProjectDetail projectDetail = new ProjectDetail( ref_date,cntr_type,opening_date,pkg_no,location,fc_curr,pkg_name,
                            ref_no,currency_name,pkgId,closing_date);

                    projectDetails.add(projectDetail);
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
            if(result=="[]/n"){
                Toast.makeText(ProjectDetailView.this,"hjfhjkhfj",Toast.LENGTH_SHORT).show();

            }

            pd.dismiss();


            projectDetailAdapter =new ProjectDetailAdapter(ProjectDetailView.this,projectDetails);
            listView.setAdapter(projectDetailAdapter);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ProjectDetailView.this, TenderPkgInfoListView.class);
                    intent.putExtra("packageID",projectDetails.get(position).getPkj_id());
                    startActivity(intent);



                }
            });

        }

    }
}
