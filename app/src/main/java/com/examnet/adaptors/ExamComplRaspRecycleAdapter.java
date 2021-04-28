package com.examnet.adaptors;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.examnet.R;
import com.examnet.model.Intrebare;
import com.examnet.model.Raspunsuri;

import java.util.List;

public class ExamComplRaspRecycleAdapter extends RecyclerView.Adapter<ExamComplRaspRecycleAdapter.ViewHolder> {
    List<Intrebare> intrebareList;

    public ExamComplRaspRecycleAdapter(List<Intrebare> intrebareList) {
        this.intrebareList = intrebareList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_intrebare_compl_rasp, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.enunt.setText(intrebareList.get(position).getEnunt());

        viewHolder.raspunsUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Raspunsuri.raspunsuriComplRasp.put(position, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    @Override
    public int getItemCount() {
        return intrebareList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView enunt;
        EditText raspunsUser;

        ViewHolder(View itemView) {
            super(itemView);
            this.enunt = itemView.findViewById(R.id.tvEnuntComplRasp);
            this.raspunsUser = itemView.findViewById(R.id.compl_raspuns);
        }
    }
}