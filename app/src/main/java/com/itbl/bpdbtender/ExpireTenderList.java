package com.itbl.bpdbtender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ExpireTenderList extends AppCompatActivity {

    Spinner explist_spinner;
    String json_string, strtype;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ExpireListAdapter expireListAdapter;
    ListView listView;
    ExpireHistory expireHistory;
    ArrayList<ExpireHistory> expireHistories=new ArrayList<>();
    TextView header;
    EditText inputSearch;
    Button search;
    SharedPreferences sharedPreferences;
    String strLoction="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_expire_list);
        listView = findViewById(R.id.table_explist);
        inputSearch = findViewById(R.id.explist_search);

        header = findViewById(R.id.header);
        header.setTypeface(ResourcesCompat.getFont(this, R.font.aldrich));
        // json_string = getIntent().getExtras().getString("json_data");

        sharedPreferences= getSharedPreferences("projectId", Context.MODE_PRIVATE);
        strLoction=sharedPreferences.getString("PROJECT_ID", "");
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                //Supplier.this.adapter.getFilter().filter(inputSearch.getText().toString());
                String text = inputSearch.getText().toString().toLowerCase(Locale.getDefault());
                expireListAdapter.getFilter().filter(text);

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });


        ExpireTenderList.Display task = new  ExpireTenderList.Display(ExpireTenderList.this);
        task.execute();

//

    }
        public class Display extends AsyncTask<Void, Void, String>{
            @SuppressWarnings("unused")
            private Activity context;

            @SuppressWarnings("unused")
            ProgressDialog pd=null;

            public Display(Activity context){
                this.context = context;
            }

            @Override
            protected void onPreExecute(){
                pd = ProgressDialog.show(ExpireTenderList.this, " Processing",
                        "Please wait...");
            }

            @Override
            protected String doInBackground(Void... params){
                final List<Pair<String, String>> postParameters = new ArrayList<>();
                postParameters.add(new Pair("strLocation", strLoction));
                String result = "";

            try{

            int count = 0;

            Integer ref_no, show_proID;
            String show_tname, show_expcname, show_expiryD, show_openD, show_expcurr, show_expstat;

            try {
                String response = CustomHttpClientGet.execute("http://103.123.11.173:8003/ExpireList ");
                 result = response.toString();
                //result=result.replaceAll("[^a-zA-Z0-9]+","");

            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection!!" + e.toString());
            }
            
            JSONArray jsonArray = new JSONArray(result.toString());

            while (count < jsonArray.length()){

                JSONObject JO = jsonArray.getJSONObject(count);


                show_tname = JO.getString("tenderId");
                show_proID = Integer.valueOf(JO.getString("projectId"));
                show_expcurr = JO.getString("currcode");
                show_openD = JO.getString("startDate");
                ref_no = Integer.valueOf(JO.getString("refNo"));
                show_expiryD = JO.getString("expireOn");
                show_expcname = JO.getString("companyName");
                show_expstat = JO.getString("status");



                ExpireHistory expireHistory = new ExpireHistory(show_tname, show_proID,show_expcurr,show_openD,ref_no,
                        show_expiryD, show_expcname,show_expstat);
                expireHistories.add(expireHistory);
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
                pd.dismiss();

                expireListAdapter =new ExpireListAdapter(ExpireTenderList.this,expireHistories);
                listView.setAdapter(expireListAdapter);



            }
  }



        }