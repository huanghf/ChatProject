package com.yzx.chat.widget.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.yzx.chat.R;
import com.yzx.chat.base.BaseRecyclerViewAdapter;
import com.yzx.chat.bean.ContactBean;

import java.util.List;

/**
 * Created by YZX on 2018年02月22日.
 * 每一个不曾起舞的日子 都是对生命的辜负
 */

public class CreateGroupAdapter extends BaseRecyclerViewAdapter<CreateGroupAdapter.CreateGroupHolder> {

    private OnItemSelectedChangeListener mOnItemSelectedChangeListener;
    private List<ContactBean> mContactList;

    public CreateGroupAdapter(List<ContactBean> contactList) {
        mContactList = contactList;
    }

    @Override
    public CreateGroupHolder getViewHolder(ViewGroup parent, int viewType) {
        return new CreateGroupHolder(LayoutInflater.from(mContext).inflate(R.layout.item_create_group, parent, false), mItemSelectedChangeListenerProxy);
    }

    @Override
    public void bindDataToViewHolder(CreateGroupHolder holder, int position) {

    }

    @Override
    public int getViewHolderCount() {
        return 5;
    }

    public void setOnItemSelectedChangeListener(OnItemSelectedChangeListener onItemSelectedChangeListener) {
        mOnItemSelectedChangeListener = onItemSelectedChangeListener;
    }

    private final OnItemSelectedChangeListener mItemSelectedChangeListenerProxy = new OnItemSelectedChangeListener() {
        @Override
        public void onItemSelectedChange(int position, boolean isSelect) {
            if (mOnItemSelectedChangeListener != null) {
                mOnItemSelectedChangeListener.onItemSelectedChange(position, isSelect);
            }
        }
    };

    final static class CreateGroupHolder extends BaseRecyclerViewAdapter.BaseViewHolder {

        private OnItemSelectedChangeListener mOnItemSelectedChangeListener;
        CheckBox mCbIsSelected;

        CreateGroupHolder(View itemView, OnItemSelectedChangeListener onItemSelectedChangeListener) {
            super(itemView);
            mOnItemSelectedChangeListener = onItemSelectedChangeListener;
            mCbIsSelected = itemView.findViewById(R.id.CreateGroupAdapter_mCbIsSelected);
            itemView.setOnClickListener(mOnItemClickListener);
        }

        private final View.OnClickListener mOnItemClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCbIsSelected.setChecked(!mCbIsSelected.isChecked());
                mOnItemSelectedChangeListener.onItemSelectedChange(getAdapterPosition(), mCbIsSelected.isChecked());
            }
        };

    }

    public interface OnItemSelectedChangeListener {
        void onItemSelectedChange(int position, boolean isSelect);
    }
}