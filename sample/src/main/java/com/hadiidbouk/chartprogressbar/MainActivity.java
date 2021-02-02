package com.hadiidbouk.chartprogressbar;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hadiidbouk.charts.BarData;
import com.hadiidbouk.charts.ChartProgressBar;
import com.hadiidbouk.charts.OnBarClickedListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnBarClickedListener {

	private ChartProgressBar mChart;
	private ArrayList<BarData> dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dataList = new ArrayList<>();

		BarData data = new BarData("Sep", 3.4f, "3.4€");
		dataList.add(data);

		data = new BarData("Oct", 8.0f, "8.0€");
		dataList.add(data);

		data = new BarData("Nov", 1.8f, "1.8€");
		dataList.add(data);

		data = new BarData("Dec", 7.3f, "7.3€");
		dataList.add(data);

		data = new BarData("Jan", 6.2f, "6.2€");
		dataList.add(data);

		data = new BarData("Feb", 3.3f, "3.3€");
		dataList.add(data);

		mChart = (ChartProgressBar) findViewById(R.id.ChartProgressBar);

		mChart.setDataList(dataList);
		mChart.setProgressColor(Color.parseColor("#456456"));
		mChart.build();
		mChart.setOnBarClickedListener(this);
		mChart.disableBar(dataList.size() - 1);
	}

	public void BtnPressed(View view) {
		int id = view.getId();
		switch (id) {
			case R.id.BtnClear :
				mChart.removeBarValues();
				break;
			case R.id.BtnReset :
				mChart.resetBarValues();
				break;
			case R.id.plus :
				BarData bar = dataList.get(0);
				bar.setBarValue(bar.getBarValue()+1);
				dataList.set(0, bar);
				mChart.increaseBar(0);
				break;
			case R.id.minus :
				BarData bar2 = dataList.get(0);
				bar2.setBarValue(bar2.getBarValue()-1);
				dataList.set(0, bar2);
				mChart.decreaseBar(0);
				break;
		}
	}

	@Override public void onBarClicked(int index) {
		Toast.makeText(this, String.valueOf(index), Toast.LENGTH_SHORT).show();
	}
}
