package com.paragon.dictionary.fbreader.higo.readbook.ui.fragment;//package com.higo.readbook.ui.fragment;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.paragon.dictionary.fbreader.higo.readbook.bean.SettingArray;
import com.paragon.dictionary.fbreader.higo.readbook.bean.SettingItem;

import org.geometerplus.fbreader.fbreader.FBReaderApp;
import org.geometerplus.zlibrary.ui.android.R;
import org.geometerplus.zlibrary.ui.android.library.ZLAndroidApplication;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class BookSettingFragment extends Fragment implements AdapterView.OnItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    @Bind(R.id.setting_gridView)
    FixGridView gridView;

    // TODO: Rename and change types of parameters
    private SettingArray mParam1;
    private SettingArray mParam3;
    private FBReaderApp mParam2;

    private OnFragmentInteractionListener mListener;
    private View view;

    public BookSettingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookSettingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookSettingFragment newInstance(ArrayList<SettingItem> param1, FBReaderApp param2, ArrayList<SettingItem> param3) {
        ArrayList<SettingItem> datas = new ArrayList<SettingItem>();
        datas.addAll(param1);
        SettingArray settingArray = new SettingArray();
        SettingArray screenSettingArray = new SettingArray();
        settingArray.setList(datas);
        screenSettingArray.setList(param3);
        BookSettingFragment fragment = new BookSettingFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, settingArray);
        args.putParcelable(ARG_PARAM2, param2);
        args.putSerializable(ARG_PARAM3, screenSettingArray);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = (SettingArray) getArguments().getSerializable(ARG_PARAM1);
            mParam2 = (FBReaderApp) getArguments().getParcelable(ARG_PARAM2);
            mParam3 = (SettingArray) getArguments().getSerializable(ARG_PARAM3);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.book_setting_fragment, container, false);
        ButterKnife.bind(this, view);

        init();

        return view;

    }

    private void init() {

        BookSettingAdapter adapter = new BookSettingAdapter(getActivity(), mParam1.getList());
        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String action = mParam1.getList().get(position).getAction();
        if (action.equals("screenOrientation")) {
            onButtonPressed();
            //初始化屏幕方向
            String value = ((ZLAndroidApplication) getActivity().getApplication()).library().getOrientationOption().getValue();
            //屏幕方向
            final ArrayList<SettingItem> screenList = mParam3.getList();
            final CharSequence[] chars = new CharSequence[screenList.size()];
            int selectPosition = 0;
            for (int i=0;i< screenList.size();i++) {
                chars[i] = screenList.get(i).getName();

                if(screenList.get(i).getAction().toLowerCase().equals("screenOrientation".toLowerCase()+value.toLowerCase())){
                    selectPosition = i;
                }
            }

            final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//            builder.setIcon(R.drawable.icon_dark_info);
            builder.setTitle("屏幕方向");

            //    设置一个单项选择下拉框
            /**
             * 第一个参数指定我们要显示的一组下拉单选框的数据集合
             * 第二个参数代表索引，指定默认哪一个单选框被勾选上，1表示默认‘女‘ 会被勾选上
             * 第三个参数给每一个单选项绑定一个监听器
             */
            builder.setSingleChoiceItems(chars, selectPosition, new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
//                    Toast.makeText(getActivity(), "性别为：" + chars[which], Toast.LENGTH_SHORT).show();
                    builder.create().dismiss();
                    mParam2.runAction(screenList.get(which).getAction());

                }
            });
//            builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
//            {
//                @Override
//                public void onClick(DialogInterface dialog, int which)
//                {
//
//                }
//            });
//            builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
//            {
//                @Override
//                public void onClick(DialogInterface dialog, int which)
//                {
//
//                }
//            });
            builder.show();

            return;
        }
        mParam2.runAction(action);
        onButtonPressed();


    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onFragmentInteraction();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction();
    }
}
