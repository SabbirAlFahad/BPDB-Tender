package com.itbl.bpdbtender;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SupplierListAdapter  extends ArrayAdapter<SupplierList> {

    private List<SupplierList> list;

    private LayoutInflater inflator;


    public SupplierListAdapter(Activity context, List<SupplierList> list) {
        super(context, R.layout.row_supplier_details, list);
        this.list = list;
        inflator = context.getLayoutInflater();

    }







    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SupplierDetailHolder supplierDetailHolder;

        if(convertView == null){

            //row = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflator.inflate(R.layout.row_supplier_details,null);
            supplierDetailHolder = new SupplierDetailHolder();

            supplierDetailHolder.tx_ref_date = (TextView)convertView.findViewById(R.id.ref_date);
            supplierDetailHolder.tx_bank_name= (TextView)convertView.findViewById(R.id.bank_name);
            supplierDetailHolder.tx_bi_desc = (TextView)convertView.findViewById(R.id.bi_desc);
            supplierDetailHolder.tx_branch_name= (TextView)convertView.findViewById(R.id.brach_name);
            supplierDetailHolder.tx_expiry_date= (TextView)convertView.findViewById(R.id.expiry_date);
            supplierDetailHolder.tx_issue_date= (TextView)convertView.findViewById(R.id.issue_date);
            supplierDetailHolder.tx_pkg_name= (TextView)convertView.findViewById(R.id.package_name);
            supplierDetailHolder.tx_ref_no = (TextView)convertView.findViewById(R.id.ref_no);
            supplierDetailHolder.tx_currency_name= (TextView)convertView.findViewById(R.id.currency_name);
            supplierDetailHolder.tx_price = (TextView)convertView.findViewById(R.id.price);
            supplierDetailHolder.tx_sup_name= (TextView)convertView.findViewById(R.id.sup_name);
            supplierDetailHolder.tx_ts_ref_no= (TextView)convertView.findViewById(R.id.ts_ref);
            supplierDetailHolder.tx_ts_value= (TextView)convertView.findViewById(R.id.ts_value);


            convertView.setTag(supplierDetailHolder);


            convertView.setTag(R.id.ref_date, supplierDetailHolder.tx_ref_date);
            convertView.setTag(R.id.bank_name, supplierDetailHolder.tx_bank_name);
            convertView.setTag(R.id.bi_desc, supplierDetailHolder.tx_bi_desc);
            convertView.setTag(R.id.brach_name, supplierDetailHolder.tx_branch_name);
            convertView.setTag(R.id.expiry_date, supplierDetailHolder.tx_expiry_date);
            convertView.setTag(R.id.issue_date, supplierDetailHolder.tx_issue_date);
            convertView.setTag(R.id.package_name, supplierDetailHolder.tx_pkg_name);
            convertView.setTag(R.id.ref_no, supplierDetailHolder.tx_ref_no);
            convertView.setTag(R.id.currency_name, supplierDetailHolder.tx_currency_name);
            convertView.setTag(R.id.price, supplierDetailHolder.tx_price);
            convertView.setTag(R.id.sup_name, supplierDetailHolder.tx_sup_name);
            convertView.setTag(R.id.ts_ref, supplierDetailHolder.tx_ts_ref_no);
            convertView.setTag(R.id.ts_value, supplierDetailHolder.tx_ts_value);


        }

        else{
            supplierDetailHolder = (SupplierDetailHolder)convertView.getTag();

        }
        supplierDetailHolder.tx_ref_date.setText(list.get(position).getRef_date());
        supplierDetailHolder.tx_bank_name.setText(list.get(position).getBank_name());
        supplierDetailHolder.tx_bi_desc.setText(list.get(position).getBi_desc());
        supplierDetailHolder.tx_branch_name.setText(list.get(position).getBracnh_name());
        supplierDetailHolder.tx_expiry_date.setText(list.get(position).getExpiry_date());
        supplierDetailHolder.tx_issue_date.setText(list.get(position).getIssue_date());
        supplierDetailHolder.tx_pkg_name.setText(list.get(position).getPkg_name());
        supplierDetailHolder.tx_ref_no.setText(list.get(position).getRef_no());
        supplierDetailHolder.tx_currency_name.setText(list.get(position).getCurrency());
        supplierDetailHolder.tx_price.setText(list.get(position).getPrice());
        supplierDetailHolder.tx_sup_name.setText(list.get(position).getSup_name());
        supplierDetailHolder.tx_ts_ref_no.setText(list.get(position).getTs_ref_no());
        supplierDetailHolder.tx_ts_value.setText(list.get(position).getTs_value());




        return convertView;

    }



    static class SupplierDetailHolder{
        protected static TextView tx_ref_date;
        protected static TextView tx_expiry_date;
        protected static TextView tx_issue_date;
        protected static TextView tx_ts_ref_no;
        protected static TextView tx_bank_name;
        protected static TextView tx_price;
        protected static TextView tx_pkg_name;
        protected static TextView tx_ref_no;
        protected static TextView tx_currency_name;
        protected static TextView tx_sup_name;
        protected static TextView tx_branch_name;
        protected static TextView tx_bi_desc;
        protected static TextView tx_ts_value;
    }
}

