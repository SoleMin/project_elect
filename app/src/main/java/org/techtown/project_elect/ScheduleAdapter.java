package org.techtown.project_elect;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter extends BaseAdapter {

    LayoutInflater inflater = null;
    private List<Schedule> m_oData = null;
    private int nListCnt = 0;

    public ScheduleAdapter(List<Schedule> _oData)
    {
        m_oData = _oData;
        nListCnt = m_oData.size();
    }

    @Override
    public int getCount()
    {
        Log.i("TAG", "getCount");
        return nListCnt;
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            final Context context = parent.getContext();
            if (inflater == null)
            {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            convertView = inflater.inflate(R.layout.schedule, parent, false);
        }

        TextView mday = (TextView) convertView.findViewById(R.id.day);
        TextView mtime = (TextView) convertView.findViewById(R.id.time);
        TextView mtitle = (TextView) convertView.findViewById(R.id.title);
        TextView mcontent = (TextView) convertView.findViewById(R.id.content);

        mday.setText(m_oData.get(position).day);
        mtitle.setText(m_oData.get(position).time);
        mtitle.setText(m_oData.get(position).title);
        mcontent.setText(m_oData.get(position).content);
        return convertView;
    }

}