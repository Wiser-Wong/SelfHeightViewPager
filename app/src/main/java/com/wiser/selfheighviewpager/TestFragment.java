package com.wiser.selfheighviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TestFragment extends Fragment {

	RecyclerView rlv;

	public static TestFragment getInstance(List<String> list) {
		TestFragment fragment = new TestFragment();
		Bundle bundle = new Bundle();
		bundle.putStringArrayList("list", (ArrayList<String>) list);
		fragment.setArguments(bundle);
		return fragment;
	}

	@Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.test_fragment, container, false);
		rlv = view.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rlv.setAdapter(new TestAdapter(getActivity(),getArguments() != null ? getArguments().getStringArrayList("list") : null));
		return view;
	}
}
