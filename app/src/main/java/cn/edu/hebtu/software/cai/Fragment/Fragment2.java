package cn.edu.hebtu.software.cai.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.hebtu.software.cai.CustomAdapter;

import cn.edu.hebtu.software.cai.R;


public class Fragment2 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_classification,
                container,
                false);
        return view;
    }
        @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //创建listView
        final List<Map<String,Object>> list = new ArrayList<Map<String,Object>>(){};
        ListView listView = getActivity().findViewById(R.id.lv_list);
        final Map<String,Object> item1 = new HashMap<>();
        item1.put("name","菜系");
        list.add(item1);
        Map<String,Object> item2 = new HashMap<>();
        item2.put("name","食材");
        list.add(item2);
        Map<String,Object> item3 = new HashMap<>();
        item3.put("name","烹饪方法");
        list.add(item3);
        Map<String,Object> item4 = new HashMap<>();
        item4.put("name","味道");
        list.add(item4);
        Map<String,Object> item5 = new HashMap<>();
        item5.put("name","适宜人群");
        list.add(item5);
        CustomAdapter customAdapter = new CustomAdapter(getContext(),list,R.layout.list_item);
        listView.setAdapter(customAdapter);
        //创建GridView
           final GridView gridView=getActivity().findViewById(R.id.gv_list);
        //菜系
            final List<Map<String,Object>> gvlistcaixi = new ArrayList<>();
            Map<String,Object> gvitem11 = new HashMap<>();
            gvitem11.put("name","川菜");
            gvitem11.put("image",R.drawable.logo);
            gvlistcaixi.add(gvitem11);
            Map<String,Object> gvitem12 = new HashMap<>();
            gvitem12.put("name","鲁菜");
            gvitem12.put("image",R.drawable.logo);
            gvlistcaixi.add(gvitem12);
            Map<String,Object> gvitem13 = new HashMap<>();
            gvitem13.put("name","粤菜");
            gvitem13.put("image",R.drawable.logo);
            gvlistcaixi.add(gvitem13);
            Map<String,Object> gvitem14 = new HashMap<>();
            gvitem14.put("name","苏菜");
            gvitem14.put("image",R.drawable.logo);
            gvlistcaixi.add(gvitem14);
            Map<String,Object> gvitem15 = new HashMap<>();
            gvitem15.put("name","浙菜");
            gvitem15.put("image",R.drawable.logo);
            gvlistcaixi.add(gvitem15);
            Map<String,Object> gvitem16 = new HashMap<>();
            gvitem16.put("name","闽菜");
            gvitem16.put("image",R.drawable.logo);
            gvlistcaixi.add(gvitem16);
            Map<String,Object> gvitem17 = new HashMap<>();
            gvitem17.put("name","湘菜");
            gvitem17.put("image",R.drawable.logo);
            gvlistcaixi.add(gvitem17);
            Map<String,Object> gvitem18 = new HashMap<>();
            gvitem18.put("name","徽菜");
            gvitem18.put("image",R.drawable.logo);
            gvlistcaixi.add(gvitem18);
        //食材
            final List<Map<String,Object>> gvlistshicai = new ArrayList<>();
            Map<String,Object> gvitem21 = new HashMap<>();
            gvitem21.put("name","热门");
            gvitem21.put("image",R.drawable.logo);
            gvlistshicai.add(gvitem21);
            Map<String,Object> gvitem22 = new HashMap<>();
            gvitem22.put("name","肉禽");
            gvitem22.put("image",R.drawable.logo);
            gvlistshicai.add(gvitem22);
            Map<String,Object> gvitem23 = new HashMap<>();
            gvitem23.put("name","水产品");
            gvitem23.put("image",R.drawable.logo);
            gvlistshicai.add(gvitem23);
            Map<String,Object> gvitem24 = new HashMap<>();
            gvitem24.put("name","蔬菜");
            gvitem24.put("image",R.drawable.logo);
            gvlistshicai.add(gvitem24);
            Map<String,Object> gvitem25 = new HashMap<>();
            gvitem25.put("name","果品");
            gvitem25.put("image",R.drawable.logo);
            gvlistshicai.add(gvitem25);
            Map<String,Object> gvitem26 = new HashMap<>();
            gvitem26.put("name","米面豆乳");
            gvitem26.put("image",R.drawable.logo);
            gvlistshicai.add(gvitem26);
            Map<String,Object> gvitem27 = new HashMap<>();
            gvitem27.put("name","调味品");
            gvitem27.put("image",R.drawable.logo);
            gvlistshicai.add(gvitem27);
            Map<String,Object> gvitem28 = new HashMap<>();
            gvitem28.put("name","药食");
            gvitem28.put("image",R.drawable.logo);
            gvlistshicai.add(gvitem28);
        //烹饪方法
            final List<Map<String,Object>> gvlistpengren = new ArrayList<>();
            Map<String,Object> gvitem31 = new HashMap<>();
            gvitem31.put("name","炒");
            gvitem31.put("image",R.drawable.logo);
            gvlistpengren.add(gvitem31);
            Map<String,Object> gvitem32 = new HashMap<>();
            gvitem32.put("name","炸");
            gvitem32.put("image",R.drawable.logo);
            gvlistpengren.add(gvitem32);
            Map<String,Object> gvitem33 = new HashMap<>();
            gvitem33.put("name","煎");
            gvitem33.put("image",R.drawable.logo);
            gvlistpengren.add(gvitem33);
            Map<String,Object> gvitem34 = new HashMap<>();
            gvitem34.put("name","烤");
            gvitem34.put("image",R.drawable.logo);
            gvlistpengren.add(gvitem34);
            Map<String,Object> gvitem35 = new HashMap<>();
            gvitem35.put("name","焖");
            gvitem35.put("image",R.drawable.logo);
            gvlistpengren.add(gvitem35);
            Map<String,Object> gvitem36 = new HashMap<>();
            gvitem36.put("name","炖");
            gvitem36.put("image",R.drawable.logo);
            gvlistpengren.add(gvitem36);
            Map<String,Object> gvitem37 = new HashMap<>();
            gvitem37.put("name","煮");
            gvitem37.put("image",R.drawable.logo);
            gvlistpengren.add(gvitem37);
            Map<String,Object> gvitem38 = new HashMap<>();
            gvitem38.put("name","涮");
            gvitem38.put("image",R.drawable.logo);
            gvlistpengren.add(gvitem38);
        //味道
            final List<Map<String,Object>> gvlistweidao = new ArrayList<>();
            Map<String,Object> gvitem41 = new HashMap<>();
            gvitem41.put("name","酸");
            gvitem41.put("image",R.drawable.logo);
            gvlistweidao.add(gvitem41);
            Map<String,Object> gvitem42 = new HashMap<>();
            gvitem42.put("name","甜");
            gvitem42.put("image",R.drawable.logo);
            gvlistweidao.add(gvitem42);
            Map<String,Object> gvitem43 = new HashMap<>();
            gvitem43.put("name","苦");
            gvitem43.put("image",R.drawable.logo);
            gvlistweidao.add(gvitem43);
            Map<String,Object> gvitem44 = new HashMap<>();
            gvitem44.put("name","辣");
            gvitem44.put("image",R.drawable.logo);
            gvlistweidao.add(gvitem44);
            Map<String,Object> gvitem45 = new HashMap<>();
            gvitem45.put("name","咸");
            gvitem45.put("image",R.drawable.logo);
            gvlistweidao.add(gvitem45);
        //适宜人群
            final List<Map<String,Object>> gvlistrenqun = new ArrayList<>();
            Map<String,Object> gvitem51 = new HashMap<>();
            gvitem51.put("name","男性");
            gvitem51.put("image",R.drawable.logo);
            gvlistrenqun.add(gvitem51);
            Map<String,Object> gvitem52 = new HashMap<>();
            gvitem52.put("name","女性");
            gvitem52.put("image",R.drawable.logo);
            gvlistrenqun.add(gvitem52);
            Map<String,Object> gvitem5 = new HashMap<>();
            gvitem5.put("name","青少年");
            gvitem5.put("image",R.drawable.logo);
            gvlistrenqun.add(gvitem5);
            Map<String,Object> gvitem53 = new HashMap<>();
            gvitem53.put("name","养生保健");
            gvitem53.put("image",R.drawable.logo);
            gvlistrenqun.add(gvitem53);
            Map<String,Object> gvitem54 = new HashMap<>();
            gvitem54.put("name","美容减肥");
            gvitem54.put("image",R.drawable.logo);
            gvlistrenqun.add(gvitem54);
            Map<String,Object> gvitem55 = new HashMap<>();
            gvitem55.put("name","孕前哺乳");
            gvitem55.put("image",R.drawable.logo);
            gvlistrenqun.add(gvitem55);
            CustomAdapter customAdaptercaixi=new CustomAdapter(getContext(),gvlistcaixi,R.layout.gridview_item);
            gridView.setAdapter(customAdaptercaixi);

            //list点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position){
                            //点击菜系
                            case 0:
                                CustomAdapter customAdaptercaixi=new CustomAdapter(getContext(),gvlistcaixi,R.layout.gridview_item);
                                gridView.setAdapter(customAdaptercaixi);
                                break;
                            //点击食材
                            case 1:
                                CustomAdapter customAdaptershicai=new CustomAdapter(getContext(),gvlistshicai,R.layout.gridview_item);
                                gridView.setAdapter(customAdaptershicai);
                                break;
                            //点击烹饪方法
                            case 2:
                                CustomAdapter customAdapterpengren=new CustomAdapter(getContext(),gvlistpengren,R.layout.gridview_item);
                                gridView.setAdapter(customAdapterpengren);
                                break;
                            //点击味道
                            case 3:
                                CustomAdapter customAdapterweidao=new CustomAdapter(getContext(),gvlistweidao,R.layout.gridview_item);
                                gridView.setAdapter(customAdapterweidao);
                                break;
                            //点击适宜人群
                            case 4:
                                CustomAdapter customAdapterrenqun=new CustomAdapter(getContext(),gvlistrenqun,R.layout.gridview_item);
                                gridView.setAdapter(customAdapterrenqun);
                                break;

                        }

                }
            });
    }

}