package com.itbl.bpdbtender;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TenderPkgInfoListAdapter extends ArrayAdapter <TenderPkgInfoList> {

    private List<TenderPkgInfoList> list;

    private LayoutInflater inflator;


    public TenderPkgInfoListAdapter(Activity context, List<TenderPkgInfoList> list) {
        super(context, R.layout.row_tender_pkg, list);
        this.list = list;
        inflator = context.getLayoutInflater();

    }







    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TenderPkgInfoListHolder tenderPkgInfoListHolder;

        if(convertView == null){

            //row = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflator.inflate(R.layout.row_tender_pkg,null);
            tenderPkgInfoListHolder = new TenderPkgInfoListHolder();

           tenderPkgInfoListHolder.tx_sf = (TextView)convertView.findViewById(R.id.sf_details);
            tenderPkgInfoListHolder.tx_est_cost = (TextView)convertView.findViewById(R.id.estimate_cost);
            tenderPkgInfoListHolder.tx_curr = (TextView)convertView.findViewById(R.id.CURR_NAME);
            tenderPkgInfoListHolder.tx_dist = (TextView)convertView.findViewById(R.id.DIST);
            tenderPkgInfoListHolder.tx_thana = (TextView)convertView.findViewById(R.id.THANA);
            tenderPkgInfoListHolder.tx_div= (TextView)convertView.findViewById(R.id.DIV);



            convertView.setTag(tenderPkgInfoListHolder);
           convertView.setTag(R.id.sf_details, tenderPkgInfoListHolder.tx_sf);
            convertView.setTag(R.id.estimate_cost, tenderPkgInfoListHolder.tx_est_cost);
            convertView.setTag(R.id.CURR_NAME, tenderPkgInfoListHolder.tx_curr);
            convertView.setTag(R.id.DIST, tenderPkgInfoListHolder.tx_dist);
            convertView.setTag(R.id.THANA, tenderPkgInfoListHolder.tx_thana);
            convertView.setTag(R.id.DIV, tenderPkgInfoListHolder.tx_div);

           

        }

        else{
            tenderPkgInfoListHolder = (TenderPkgInfoListHolder)convertView.getTag();

        }


        //BookHistory bookHistory = (BookHistory)this.getItem(position);


        tenderPkgInfoListHolder.tx_sf.setText(list.get(position).getSf_des());
       tenderPkgInfoListHolder.tx_est_cost.setText(list.get(position).getEst_cost());
       tenderPkgInfoListHolder.tx_curr.setText(list.get(position).getCurr_name());
        tenderPkgInfoListHolder.tx_dist.setText(list.get(position).getDist_DESC());
        tenderPkgInfoListHolder.tx_thana.setText(list.get(position).getThana_DESC());
        tenderPkgInfoListHolder.tx_div.setText(list.get(position).getDiv_DESC());





        return convertView;

    }



    static class TenderPkgInfoListHolder{

        protected static TextView tx_sf;
        protected static TextView tx_est_cost;
       protected static TextView tx_curr;
        protected static TextView tx_dist;
        protected static TextView tx_thana;
        protected static TextView tx_div;

    }

}
