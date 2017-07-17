package com.marsjiang.myflipperbottomdialog.bottomsheet;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.marsjiang.myflipperbottomdialog.R;

import static com.marsjiang.myflipperbottomdialog.R.id.rv_test;


/**
 * BottomSheetFragment
 * Created by Jiang on 2016/9/28.
 */

public class BottomSheetFragment extends BottomSheetDialogFragment {
    private CoordinatorLayout ll_bottom_sheet;
    private static Context mContext;
    private static LinearLayout mll_bottom;
    private BottomSheetBehavior mBehavior;

    public static BottomSheetFragment getInstance(Context context, LinearLayout ll_bottom) {
        mContext = context;
        mll_bottom = ll_bottom;
        BottomSheetFragment fragment = new BottomSheetFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View ll_bottom_sheet_layout = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);
        //设定弹出评论区域高度
        ll_bottom_sheet = (CoordinatorLayout) ll_bottom_sheet_layout.findViewById(R.id.ll_bottom_sheet);
        RecyclerView rv_test = (RecyclerView) ll_bottom_sheet_layout.findViewById(R.id.rv_test);
//        int a = mll_bottom.getWidth();
//        int da = mll_bottom.getHeight();
//        ll_bottom_sheet.setLayoutParams(new CoordinatorLayout.LayoutParams(mll_bottom.getWidth(), mll_bottom.getHeight()));
//        mBehavior = BottomSheetBehavior.from(rv_test);
//        mBehavior.setPeekHeight(mll_bottom.getHeight());
        return ll_bottom_sheet_layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(rv_test);
        new ListAdapter(mRecyclerView);
    }

    private final class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

        public ListAdapter(RecyclerView recyclerView) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(this);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.item_bottom, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText("item" + (++position));
        }

        @Override
        public int getItemCount() {
            return 20;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public final TextView textView;

            public ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.textview);
            }
        }
    }
}
