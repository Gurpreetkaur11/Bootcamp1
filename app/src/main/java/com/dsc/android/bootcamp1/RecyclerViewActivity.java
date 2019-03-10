package com.dsc.android.bootcamp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<RecyclerViewData> userList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recycler_view);
       // createMockList();
        apicall();
        setUpRecyclerView();

    }

    private void apicall(){
        ApiServices apiServices = AppClient.getInstance().createService(ApiServices.class);
        Call<UserWrapper> call = apiServices.getUserList();
        call.enqueue(new Callback<UserWrapper>() {
            @Override
            public void onResponse(Call<UserWrapper> call, Response<UserWrapper> response) {
                if(response.isSuccessful()){
                    if(response.body() !=null){
                        Toast.makeText(RecyclerViewActivity.this, "Successful response", Toast.LENGTH_LONG).show();
                        userList.addAll(response.body().getRecyclerViewData());

                    }
                }
            }

            @Override
            public void onFailure(Call<UserWrapper> call, Throwable t) {

            }
        });
    }

//    private void createMockList(){
//        RecyclerViewData data;
//        data = new RecyclerViewData("https://bit.ly/2NT7svr","Gurpreet kaur","1243567876");
//        mockDataList.add(data);
//        data = new RecyclerViewData("https://bit.ly/2NT7svr","Jyotini Yadav","3456789879");
//        mockDataList.add(data);
//        data = new RecyclerViewData("https://bit.ly/2NT7svr","Richi rich ","4567887687");
//        mockDataList.add(data);
//        data = new RecyclerViewData("https://bit.ly/2NT7svr","Raj Agrawal","2222343434");
//        mockDataList.add(data);
//        data = new RecyclerViewData("https://bit.ly/2NT7svr","Jaspreet Singh","3434343434");
//        mockDataList.add(data);
//        data = new RecyclerViewData("https://bit.ly/2NT7svr","Tikam Talreja","87878887877");
//        mockDataList.add(data);
//    }



    public void setUpRecyclerView(){
         recyclerViewAdapter = new RecyclerViewAdapter(this);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
         recyclerView.setAdapter(recyclerViewAdapter);
         recyclerViewAdapter.setRecyclerViewDataList(userList);
         recyclerViewAdapter.notifyDataSetChanged();

    }
}
