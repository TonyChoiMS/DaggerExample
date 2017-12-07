package com.tony.daggerexample.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tony.daggerexample.data.model.Repository;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017-11-08.
 */

public class RepositoriesListAdapter extends ArrayAdapter<Repository> {

    private LayoutInflater inflater;

    public RepositoriesListAdapter(Context context, List<Repository> objects) {
        super(context, 0, objects);
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RepositoryHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            holder = new RepositoryHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (RepositoryHolder) convertView.getTag();
        }

        Repository repository = getItem(position);
        holder.text1.setText(repository.name);

        return convertView;
    }

    static class RepositoryHolder {
        @BindView(android.R.id.text1)
        TextView text1;

        public RepositoryHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
