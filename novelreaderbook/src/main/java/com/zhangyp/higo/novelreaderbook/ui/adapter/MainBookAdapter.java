package com.zhangyp.higo.novelreaderbook.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhangyp.higo.novelreaderbook.R;

import java.util.List;

/**
 * Created by zhangyipeng on 16/1/18.
 */
public class MainBookAdapter   extends RecyclerView.Adapter<MainBookAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mDataSet;

    public MainBookAdapter(Context context, List<String> dataSet) {
        mContext = context;
        mDataSet = dataSet;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.gv_book_item, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClick(holder.itemView ,position);
            }
        });
        Picasso.with(mContext).load(R.mipmap.app_icon).into(holder.image);
        holder.text.setText(mDataSet.get(position));
    }

    @Override public int getItemCount() {
        return mDataSet.size();
    }

    public void remove(int position) {
        mDataSet.remove(position);
        notifyItemRemoved(position);
    }

    public void add(String text, int position) {
        mDataSet.add(position, text);
        notifyItemInserted(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView text;
        private View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;

            image = (ImageView) itemView.findViewById(R.id.iv_book_icon);
            text = (TextView) itemView.findViewById(R.id.tv_bookname);
        }


    }
    private OnItemRecyclerViewClickListener listener;
    public void setOnItemRecyclerViewClick(OnItemRecyclerViewClickListener listener ){
        this.listener = listener;
    }


    public interface OnItemRecyclerViewClickListener{
        void itemClick(View view,int position);
    }
}