package com.citizen.moneytracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Record> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemlist);

        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecordItemDecoration(24));
        recyclerView.setAdapter(new ItemListAdapter());

        createData();
    }

    private void createData() {
        data.add(new Record("Молоко", 100));
        data.add(new Record("Хлеб", 200));
        data.add(new Record("Сыр", 100));
        data.add(new Record("Колбаса", 350));
        data.add(new Record("Торт", 456));
        data.add(new Record("Курица", 89));
        data.add(new Record("Курсы", 56));
        data.add(new Record("Таблетки", 456));
        data.add(new Record("Монитор", 5));
        data.add(new Record("Ноутбук", 456));
        data.add(new Record("MacBook Pro", 645));
        data.add(new Record("Шкаф", 456));
    }

    private class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.RecordViewHolder> {

        @NonNull
        @Override
        public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_record, parent, false);
            return new RecordViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {
            Record record = data.get(position);
            holder.applyData(record);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        private class RecordViewHolder extends RecyclerView.ViewHolder {

            private final TextView title;
            private final TextView price;

            public RecordViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.title);
                price = itemView.findViewById(R.id.price);
            }

            public void applyData(Record record) {
                title.setText(record.getTitle());
                price.setText(record.getPrice() + getResources().getString(R.string.rub_char));
            }
        }
    }
}
