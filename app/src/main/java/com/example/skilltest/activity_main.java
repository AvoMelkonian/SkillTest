package com.example.skilltest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class activity_main extends AppCompatActivity {
    RecyclerView rv;
    LinearLayoutManager layoutManager;
    RvAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);

        //data
        QuizInfo data1 = new QuizInfo("Topic1", "lorem ipsum lorem ipsum lorem ipsum lorem ipsum");
        QuizInfo data2 = new QuizInfo("Topic2", "lorem ipsum lorem ipsum lorem ipsum lorem ipsum");
        QuizInfo data3 = new QuizInfo("Topic3", "lorem ipsum lorem ipsum lorem ipsum lorem ipsum");
        QuizInfo data4 = new QuizInfo("Topic4", "lorem ipsum lorem ipsum lorem ipsum lorem ipsum");

        //data source
        ArrayList<QuizInfo> dataSource = new ArrayList<QuizInfo>();
        dataSource.add(data1);
        dataSource.add(data2);
        dataSource.add(data3);
        dataSource.add(data4);

        //make it horizontal
        layoutManager = new LinearLayoutManager(activity_main.this,LinearLayoutManager.HORIZONTAL,false);
        rvAdapter = new RvAdapter(dataSource);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(rvAdapter);

    }

    class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvHolder>{
        ArrayList<QuizInfo> data;

        public RvAdapter(ArrayList<QuizInfo> data){
            this.data = data;
        }
        @NonNull
        @Override
        public RvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(activity_main.this).inflate(R.layout.rv_data,parent,false);
            return  new RvHolder(view);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        @Override
        public void onBindViewHolder(@NonNull RvHolder holder, int position) {
            holder.qTitle.setText( data.get(position).getTitle());
            holder.qDesc.setText( data.get(position).getDesc());
        }

        class RvHolder extends RecyclerView.ViewHolder{
            TextView qTitle;
            TextView qDesc;
            public RvHolder(@NonNull View itemView) {
                super(itemView);
                qTitle = itemView.findViewById(R.id.quiz_title);
                qDesc = itemView.findViewById(R.id.quiz_desc);
            }
        }
    }

    static class QuizInfo {
        private String title;
        private  String desc;

        QuizInfo(String title,  String desc ){
            this.title = title;
            this.desc =desc;
        }

        public String getTitle(){
            return title;
        }

        public String getDesc() {
            return desc;
        }
    }

}