package com.examnet.adaptors;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.examnet.R;
import com.examnet.model.Intrebare;
import com.examnet.model.Raspunsuri;

import java.util.List;

public class ExamComplRaspAdaptor extends ArrayAdapter<Intrebare> {

    private static class ItemViewHolder {
        TextView enunt;
        EditText editText;
    }
    public ExamComplRaspAdaptor(@NonNull Context context, int resource, @NonNull List<Intrebare> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Raspunsuri.raspunsuriComplRasp.put(position, "");
        Intrebare intrebare = getItem(position);
        ItemViewHolder itemViewHolder;
        final View result;

        if(convertView == null) {
            itemViewHolder = new ItemViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_intrebare_compl_rasp, parent, false);

            itemViewHolder.enunt = convertView.findViewById(R.id.tvEnunt);

            result = convertView;
            convertView.setTag(itemViewHolder);
        } else {
            itemViewHolder = (ItemViewHolder) convertView.getTag();
            result = convertView;
        }

        itemViewHolder.enunt.setText(intrebare.getEnunt());
        EditText editText = convertView.findViewById(R.id.compl_raspuns);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Raspunsuri.raspunsuriComplRasp.put(position, editText.getText().toString().toLowerCase());
            }
        });

        return result;
    }
}
