package com.examnet.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.examnet.R;
import com.examnet.model.Intrebare;
import com.examnet.model.Raspunsuri;

import java.util.List;

public class ExamGrilaRecycleAdapter extends RecyclerView.Adapter<ExamGrilaRecycleAdapter.ViewHolder> {
    List<Intrebare> intrebareList;

    public ExamGrilaRecycleAdapter(List<Intrebare> intrebareList) {
        this.intrebareList = intrebareList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_intrebare, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.enunt.setText(intrebareList.get(position).getEnunt());
        for (int i = 0; i < intrebareList.get(position).getVarianteRaspuns().size(); i++) {
            RadioButton varianta = (RadioButton) viewHolder.varianteDeRaspuns.getChildAt(i);
            varianta.setText(intrebareList.get(position).getVarianteRaspuns().get(i));
        }

        viewHolder.varianteDeRaspuns.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            if (checkedId != -1) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = radioGroup.findViewById(selectedId);
                Raspunsuri.raspunsuriGrila.put(position, radioButton.getText().toString());
            }
        });
        viewHolder.bind(position);
    }


    @Override
    public int getItemCount() {
        return intrebareList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView enunt;
        RadioGroup varianteDeRaspuns;
        RadioButton radioButtonA;
        RadioButton radioButtonB;
        RadioButton radioButtonC;

        ViewHolder(View itemView) {
            super(itemView);
            this.enunt = itemView.findViewById(R.id.tvEnunt);
            this.varianteDeRaspuns = itemView.findViewById(R.id.groupIntrebari);

            radioButtonA = itemView.findViewById(R.id.raspuns_a);
            radioButtonB = itemView.findViewById(R.id.raspuns_b);
            radioButtonC = itemView.findViewById(R.id.raspuns_c);

            radioButtonA.setOnClickListener(view -> {
                radioButtonA.setChecked(true);
                intrebareList.get(getAdapterPosition()).setRaspunsDatDeUser("A");
            });
            radioButtonB.setOnClickListener(view -> {
                radioButtonB.setChecked(true);
                intrebareList.get(getAdapterPosition()).setRaspunsDatDeUser("B");
            });
            radioButtonC.setOnClickListener(view -> {
                radioButtonC.setChecked(true);
                intrebareList.get(getAdapterPosition()).setRaspunsDatDeUser("C");
            });
        }

        void bind(int position) {
            switch (intrebareList.get(position).getRaspunsDatDeUser()) {
                case "A":
                    radioButtonA.setChecked(true);
                    break;
                case "B":
                    radioButtonB.setChecked(true);
                    break;
                case "C":
                    radioButtonC.setChecked(true);
                    break;
                default:
                    varianteDeRaspuns.clearCheck();
                    break;
            }
        }
    }
}