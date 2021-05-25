package com.itbl.bpdbtender;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExpireListAdapter extends ArrayAdapter<ExpireHistory> {

   private List<ExpireHistory> list;

    private LayoutInflater inflator;
    private List<ExpireHistory> newlist = null;
    private ItemFilter mFilter = new ItemFilter();

    public ExpireListAdapter(Activity context, List<ExpireHistory> newlist) {
        super(context, R.layout.row_explist, newlist);
        this.newlist = newlist;
        inflator = context.getLayoutInflater();
        this.list = new ArrayList<ExpireHistory>();
        this.list.addAll(newlist);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ExpireHistory getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }




    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

      ExpireHistoryHolder expireHistoryHolder;

      if(convertView == null){

           //row = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          convertView= inflator.inflate(R.layout.row_explist,null);
          expireHistoryHolder = new ExpireHistoryHolder();

          expireHistoryHolder.ref_no = convertView.findViewById(R.id.show_exprefno);
          expireHistoryHolder.show_proID = convertView.findViewById(R.id.show_proID);
          expireHistoryHolder.show_tname = convertView.findViewById(R.id.show_tname);
          expireHistoryHolder.show_expcname = convertView.findViewById(R.id.show_expcname);
          expireHistoryHolder.show_expiryD = convertView.findViewById(R.id.show_expiryD);
          expireHistoryHolder.show_openD = convertView.findViewById(R.id.show_openD);
          expireHistoryHolder.show_expstat = convertView.findViewById(R.id.show_expstat);
          expireHistoryHolder.show_expcurr = convertView.findViewById(R.id.show_expcurr);

          convertView.setTag(expireHistoryHolder);
          convertView.setTag(R.id.show_exprefno, expireHistoryHolder.ref_no);
          convertView.setTag(R.id.show_proID, expireHistoryHolder.show_proID);
          convertView.setTag(R.id.show_tname, expireHistoryHolder.show_tname);
          convertView.setTag(R.id.show_expcname, expireHistoryHolder.show_expcname);
          convertView.setTag(R.id.show_expiryD, expireHistoryHolder.show_expiryD);
          convertView.setTag(R.id.show_openD, expireHistoryHolder.show_openD);
          convertView.setTag(R.id.show_expstat, expireHistoryHolder.show_expstat);
          convertView.setTag(R.id.show_expcurr, expireHistoryHolder.show_expcurr);

      }

      else{
          expireHistoryHolder = (ExpireHistoryHolder)convertView.getTag();
      }
        expireHistoryHolder.ref_no.setText(String.valueOf(list.get(position).getRef_no()));
        expireHistoryHolder.show_proID.setText(String.valueOf(list.get(position).getShow_proID()));
        expireHistoryHolder.show_tname.setText(list.get(position).getShow_tname());
        expireHistoryHolder.show_expcname.setText(list.get(position).getShow_expcname());
        expireHistoryHolder.show_expiryD.setText(list.get(position).getShow_expiryD());
        expireHistoryHolder.show_openD.setText(list.get(position).getShow_openD());
        expireHistoryHolder.show_expcurr.setText(list.get(position).getShow_expcurr());
        expireHistoryHolder.show_expstat.setText(list.get(position).getShow_expstat());
        
        return convertView;

    }

    public Filter getFilter() {
        return mFilter;
    }



    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            final List<ExpireHistory> orglist = newlist;

            int count = orglist.size();
            final ArrayList<ExpireHistory> nlist = new ArrayList<ExpireHistory>(count);

            String filterableString, filterableString2, filterableString3,filterableString4,filterableString5,filterableString6,filterableString7,filterableString8;

            for (int i = 0; i < count; i++) {
                filterableString = orglist.get(i).getShow_tname();
                filterableString2 = String.valueOf(orglist.get(i).getShow_proID());
                filterableString3 =  orglist.get(i).getShow_expcurr();
                filterableString4 = orglist.get(i).getShow_openD();
                filterableString5 = String.valueOf(orglist.get(i).getRef_no());
                filterableString6 =  orglist.get(i).getShow_expiryD();
                filterableString7 =orglist.get(i).getShow_expcname();
                filterableString8 =orglist.get(i).getShow_expstat();



                if (filterableString.toLowerCase().contains(filterString) || filterableString2.toLowerCase().contains(filterString)||
                        filterableString3.toLowerCase().contains(filterString)  || filterableString4.toLowerCase().contains(filterString)  ||
                        filterableString5.toLowerCase().contains(filterString) || filterableString6.toLowerCase().contains(filterString)||
                        filterableString7.toLowerCase().contains(filterString)||filterableString8.toLowerCase().contains(filterString)
                        ) {


                    nlist.add(orglist.get(i));
                }
            }


            results.values = nlist;
            results.count = nlist.size();

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list = (ArrayList<ExpireHistory>) results.values;
            notifyDataSetChanged();
        }

    }



    static class ExpireHistoryHolder{

         protected static TextView ref_no;
         protected static TextView show_proID;
         protected static TextView show_tname;
         protected static TextView show_expcname;

         protected static TextView show_expiryD;
         protected static TextView show_openD;
         protected static TextView show_expstat;
         protected static TextView show_expcurr;

    }


}

