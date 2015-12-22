package com.hanssem.day8_test;

import android.view.View;
import android.widget.AdapterView;

/**
 * 아이템이 선택되었을 때 처리하는 리스너 새로 정의
 *
 * @author Mike
 */
public interface OnDataSelectionListener {


    public void onDataSelected(AdapterView parent, View v, int position, long id);

}
