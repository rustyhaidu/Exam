package com.examnet.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.examnet.R;
import com.examnet.model.Examen;
import com.examnet.model.Intrebare;
import com.examnet.model.Raspunsuri;

import java.util.List;

public class ExamGrilaAdaptor extends ArrayAdapter<Intrebare> {

    private static class ItemViewHolder {
        TextView enunt;
        RadioGroup varianteDeRaspuns;
    }
    public ExamGrilaAdaptor(@NonNull Context context, int resource, @NonNull List<Intrebare> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Raspunsuri.raspunsuriGrila.put(position, "");

        Intrebare intrebare = getItem(position);
        ItemViewHolder itemViewHolder;
        final View result;

        if(convertView == null) {
            itemViewHolder = new ItemViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_intrebare, parent, false);

            itemViewHolder.enunt = convertView.findViewById(R.id.tvEnunt);
            itemViewHolder.varianteDeRaspuns = convertView.findViewById(R.id.groupIntrebari);

            result = convertView;
            convertView.setTag(itemViewHolder);
        } else {
            itemViewHolder = (ItemViewHolder) convertView.getTag();
            result = convertView;
        }

        itemViewHolder.enunt.setText(intrebare.getEnunt());
        for(int i = 0; i < intrebare.getVarianteRaspuns().size(); i++){
            RadioButton varianta = (RadioButton) itemViewHolder.varianteDeRaspuns.getChildAt(i);
            varianta.setText(intrebare.getVarianteRaspuns().get(i));
        }

        View finalConvertView = convertView;
        itemViewHolder.varianteDeRaspuns.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = finalConvertView.findViewById(selectedId);
                Raspunsuri.raspunsuriGrila.put(position, radioButton.getText().toString());
            }
        });

        return result;
    }
}
