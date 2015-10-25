package ru.siestavl.siestavl.fragments;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import ru.siestavl.siestavl.R;

/**
 * Created by dmitry on 10/23/15.
 */
public class NumberDialog extends DialogFragment {

    private int numDials;
    private int currentValue;
    private NumberPicker numPic;
    private Button btnOk;
    private Button btnNo;
    private NumberPickerListener numberPickerListener;

/*    public static NumberDialog newInstance(NumberPickerListener numberPickerListener) {
        NumberDialog fragDialog = new NumberDialog();
        //Bundle arg = new Bundle();
        //arg.putInt("val", 1);
        //fragDialog.setArguments(arg);
        this.numberPickerListener = numberPickerListener;
        return fragDialog;
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_number_dialog, null);


        numPic = (NumberPicker)v.findViewById(R.id.numberPicker);
        numPic.setMinValue(1);
        numPic.setMaxValue(9);
        numPic.setWrapSelectorWheel(true);

        btnNo = (Button)v.findViewById(R.id.numberPicker_Cancel);
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btnOk = (Button)v.findViewById(R.id.numberPicker_Yes);
        btnOk.setOnClickListener(dialog_OkOnClickListener);

        return v;
    }

    private Button.OnClickListener dialog_OkOnClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            NumberPickerListener targetFragment = (NumberPickerListener) getTargetFragment();
            targetFragment.updateResult(numPic.getValue());
            //getTargetFragment().onActivityResult(getTargetRequestCode(), numPic.getValue(), getActivity().getIntent());
            dismiss();
        }
    };
    public interface NumberPickerListener {
        void updateResult(int inputInt);
    }

}
