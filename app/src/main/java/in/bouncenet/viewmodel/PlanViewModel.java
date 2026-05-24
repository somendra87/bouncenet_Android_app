package in.bouncenet.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import in.bouncenet.common.recycler.BaseRecyclerItem;
import in.bouncenet.enums.PlanType;
import in.bouncenet.items.InviterAndEarnItem;
import in.bouncenet.items.ItemSectionHeader;
import in.bouncenet.items.PlanPageHeroSectionItem;
import in.bouncenet.items.PlanItem;

public class PlanViewModel extends ViewModel {

    private final MutableLiveData<List<BaseRecyclerItem>> plansLiveData = new MutableLiveData<>();
    private int selectedPosition = -1;
    public LiveData<List<BaseRecyclerItem>> getPlansLiveData(){
        return plansLiveData;
    }

    public PlanViewModel(){
        loadPlansPage();
    }

    private void loadPlansPage(){
        List<BaseRecyclerItem> recyclerPlanItems = new ArrayList<>();

        recyclerPlanItems.add(new PlanPageHeroSectionItem());

        recyclerPlanItems.add(new ItemSectionHeader(
                "Choose Your Plan",
                "Start focused, then upgrade as your comeback grows."
        ));

        recyclerPlanItems.add(new PlanItem(PlanType.SILVER));
        recyclerPlanItems.add(new PlanItem(PlanType.GOLD));
        recyclerPlanItems.add(new PlanItem(PlanType.DIAMOND));

        recyclerPlanItems.add(new InviterAndEarnItem());

        plansLiveData.setValue(recyclerPlanItems);
    }

    public void onPlanSelected(int position) {
        if (selectedPosition == position){
            return;
        }

        List<BaseRecyclerItem> currentList = plansLiveData.getValue();
        if (currentList == null || currentList.isEmpty()) {
            return;
        }

        List<BaseRecyclerItem> updatedList = new ArrayList<>();

        for (int i = 0; i < currentList.size() ; i++) {
            BaseRecyclerItem currentItem = currentList.get(i);

            if (currentItem instanceof PlanItem) {
                PlanItem oldItem = (PlanItem) currentList.get(i);
                PlanItem newItem = new PlanItem(oldItem.getPlanType());

                newItem.setSelected(i == position);
                updatedList.add(newItem);
            } else {
                updatedList.add(currentItem);
            }
        }

        selectedPosition = position;

        // Notify observers (Fragment wil update RecyclerView )
        plansLiveData.setValue(updatedList);
    }



}
