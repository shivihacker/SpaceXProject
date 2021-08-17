package com.example.spacexproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.ContactHolder> {
    private List<Model> models;
    Context context;
    CrewViewModel  crewViewModel;
//    DeleteItemClicklistner deleteItemClicklistner;
//    private Model model;

//    public void setContacts(List<CrewMember> crewMembers) {
//        this.crewMembers = crewMembers;
//        notifyDataSetChanged();
//    }


    public CrewAdapter(List<Model> models, Context context) {
        this.models = models;
        this.context=context;
//        this.deleteItemClicklistner=deleteItemClicklistner;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        return new ContactHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder,int position) {
        Model currModel = models.get(position);
        holder.name.setText(currModel.getName());
        holder.agency.setText(currModel.getAgency());
        holder.wikipedia.setText(currModel.getWikipedia());
        holder.status.setText(currModel.getStatus());
        Picasso.get().load(currModel.getImage()).into(holder.img);
//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               crewViewModel.delete(models.get(position));
////                String id=currModel.getId();
////                deleteItemClicklistner.onItemClick(position,currModel.getId());
//            }
//        });
   }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void getAllCrews(List<Model> models){
        this.models = models;
    }


    public class ContactHolder extends RecyclerView.ViewHolder {
        private TextView name,agency,wikipedia,status;
        private Button delete,refresh;
        private ImageView img;
        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            agency=itemView.findViewById(R.id.agency);
            wikipedia=itemView.findViewById(R.id.wiki);
            status=itemView.findViewById(R.id.status);
            img=itemView.findViewById(R.id.img);
            delete=itemView.findViewById(R.id.delete);
            refresh=itemView.findViewById(R.id.refresh);

//            delete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
////                    List<Model> model=new ArrayList<>();
////                    String id =models.get(getAdapterPosition()).getId();
////                    model.set(id);
////                    MainActivity.crewDatabase.crewDao().deleteAll(model);
//                }
//            });
        }

    }

//    public interface DeleteItemClicklistner{
//        void onItemClick(int position, String id);
//    }
}
