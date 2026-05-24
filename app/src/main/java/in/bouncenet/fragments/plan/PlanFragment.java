package in.bouncenet.fragments.plan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import in.bouncenet.R;
import in.bouncenet.common.recycler.BaseRecyclerItem;
import in.bouncenet.common.recycler.GenericAdapter;
import in.bouncenet.common.views.GlobalTopBarView;
import in.bouncenet.items.PlanItem;
import in.bouncenet.viewmodel.PlanViewModel;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class PlanFragment extends Fragment {


    private PlanViewModel planViewModel;
    private RecyclerView planMainPageRecyclerView;
    private GenericAdapter genericAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_plan, container, false);

        planMainPageRecyclerView = view.findViewById(R.id.recyclePlanMainPage);
        planMainPageRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        planViewModel = new ViewModelProvider(this).get(PlanViewModel.class);
        GlobalTopBarView topBar = view.findViewById(R.id.planTopBar);
        setUpAdapter();
        observePlansViewModel();

        return view;
    }

    private void observePlansViewModel() {
     planViewModel.getPlansLiveData().observe(getViewLifecycleOwner(), items ->{
         if (genericAdapter != null ) {
             genericAdapter.submitList(items);
         }
     });

    }

    private void setUpAdapter() {
        genericAdapter = new GenericAdapter();
        genericAdapter.setOnItemClickListener(position -> {
            planViewModel.onPlanSelected(position);
        });
        planMainPageRecyclerView.setAdapter(genericAdapter);
    }
}