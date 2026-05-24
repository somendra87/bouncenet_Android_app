package in.bouncenet.helpers;

import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import java.util.StringTokenizer;

public class BnTextHelper {
    private BnTextHelper(){
        //util class
    }

    public static SpannableString setMultiColorText(String fullText,String[] colors) {
        SpannableString spannable = new SpannableString(fullText);
        int start = 0;

        String[] words = fullText.split("\\s+");
        for (String w : words) {
            System.out.println("word from title : " + w);
        }
        for (int i = 0; i < words.length; i++) {
            int end = start + words[i].length();
            spannable.setSpan(new ForegroundColorSpan(Color.parseColor(colors[i])),
                    start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            start = end + 1; // +1 for space
            if (start >= fullText.length()) break;
        }
        return spannable;
    }


    public static TextWatcher bnTextWatcher(){
        // Text watcher
        return new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {

            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
        };
    }

}
