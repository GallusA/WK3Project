package com.example.gallusawa.wk3project;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gallusawa on 8/21/17.
 */

public class SMSAdaptor extends RecyclerView.Adapter<SMSAdaptor.ViewHolder>{
    private static final String TAG = "SMSListAdapter";
    ArrayList<SMS> smsList;
    Context context;

    public SMSAdaptor(ArrayList<SMS> smsList ) {
        this.smsList = smsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_messages, parent, false);
        return new ViewHolder(view);
    }

    private int lastPosition = -1;
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        if(position > lastPosition){

        }

        Log.d(TAG, "onBindViewHolder: ");
        final SMS sms = smsList.get(position);
        holder.tvNumber.setText(sms.getNumber());
        holder.tvMessage.setText(sms.getMessage());

        holder.scroll.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                if(holder.scroll.getChildAt(0).getHeight() > holder.scroll_parent.getMeasuredHeight()) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {

        return smsList.size();
    }

    public void UpdateData(SMS sms){
        smsList.add(0,sms);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Nullable
        @BindView(R.id.tvNumber)
        TextView tvNumber;

        @Nullable
        @BindView(R.id.tvMessage)
        TextView tvMessage;

        @Nullable
        @BindView(R.id.scroll)
        ScrollView scroll;

        @Nullable
        @BindView(R.id.scroll_parent)
        FrameLayout scroll_parent;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}