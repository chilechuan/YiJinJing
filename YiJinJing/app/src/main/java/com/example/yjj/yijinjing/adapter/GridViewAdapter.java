package com.example.yjj.yijinjing.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yjj.yijinjing.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tx on 2017/11/17.
 */

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.GridViewHolder>{

    private Context context;
    private List<String> mDatas = new ArrayList<>();

    public GridViewAdapter(Context context, List<String> mDatas){
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gridview, parent, false);
        GridViewHolder gridViewHolder = new GridViewHolder(view);
        return gridViewHolder;
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        holder.tvGrid.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder{

        TextView tvGrid;

        public GridViewHolder(View itemView) {
            super(itemView);
            tvGrid = (TextView) itemView.findViewById(R.id.tv_grid);
        }
    }

}
