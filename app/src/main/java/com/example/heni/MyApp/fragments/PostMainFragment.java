package com.example.heni.MyApp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.adapters.ItemImageAdapter;
import com.example.heni.MyApp.models.Post;
import com.example.heni.MyApp.utilities.CommonRecyclerItem;
import com.example.heni.MyApp.views.CommonRecyclerScreen;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.heni.MyApp.utilities.CommonRecyclerItem.ItemType.POST_CARD;

/**
 * Created by heni on 8/7/17.
 */

public class PostMainFragment extends Fragment {

    @BindView(R.id.r_mainHolder)
    RelativeLayout rMainHolder;
    @BindView(R.id.crs_holder)
    RelativeLayout crsHolder;
    List<Post> postList;
    Post post;
    CommonRecyclerScreen crs;
    ItemImageAdapter postAdapter;
    CommonRecyclerItem crPostHolder;

    String IMAGE = Post.PostType.IMAGE;
    String VIDEO = Post.PostType.VIDEO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.post_main_fragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        crs = new CommonRecyclerScreen(this.getContext(),view);
        resetScreen();
    }

    private void resetScreen(){
        crs = CommonRecyclerScreen.setupWithFragment(this);
        crs.setSwipeListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                resetScreen();
            }
        });
        createPosts();
    }

    private void createPosts(){
        postList = getDummyPosts();
        postAdapter = new ItemImageAdapter(getContext(),crs.getRecyclerItems());
        crs.getRecyclerView().setLayoutManager(new LinearLayoutManager(getContext()));
        crs.getRecyclerView().setAdapter(postAdapter);

        for(int i=0; i<postList.size();i++) {
            crPostHolder = new CommonRecyclerItem(POST_CARD, postList.get(i));
            crs.getRecyclerItems().add(crPostHolder);
        }
        postAdapter.setRecyclerItems(crs.getRecyclerItems());
        postAdapter.notifyDataSetChanged();

        crs.setSwipeRefreshing(false);
    }


    public List<Post> getDummyPosts(){

        List<Post> postList = new ArrayList<>();
        int[] images = new int[]{
                R.drawable.shinchan1,
                R.drawable.shinchan2,
                R.drawable.shinchan3,
                R.drawable.shinchan4,
        };

        String[] videolinksList = new String[]{
                "",
                "",
        };

        Post post1 = new Post("Post 1", "This is my First Post.dfdgkfgfdkgjdfgjfldkjgofgreigjkdflgfdkk lkdjgkdfjgkdfj dlkgflkdgjfkd lkgjrjtgrjg gjldfkgjfldkjgkdfljlkdfj lkdjgkdfjgkdfljgkldfjlkdfj eoir  oiewifjdifjoi weifowefiwejfieowjf lsjfewijrijfevjfdvjdf ifowfjwoeifjiwofjoijiowjfiowjf oijfoijfoweijfwojfv oeijfosdfjdoifjoidjfoweijf sijfoidfjoifjweoijfoweiv sd sdfds wfedww weffw :)",images[0], IMAGE);
        Post post2 = new Post("Post 2", "This is my Second Post. :)",images[1], IMAGE);
        Post post3 = new Post("Post 3", "This is my third Post. :)",images[2], IMAGE);
        Post post4 = new Post("Post 4", "This is my fourth Post. :)",images[2], IMAGE);
        Post post5 = new Post("Post 5", "This is my fifth Post. :)",images[2], IMAGE);
        postList.add(post1);
        postList.add(post2);
        postList.add(post3);
        postList.add(post4);
        postList.add(post5);

        return postList;
    }


}
