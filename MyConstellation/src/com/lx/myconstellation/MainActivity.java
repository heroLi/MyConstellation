package com.lx.myconstellation;

import com.lx.fragment.ConstellationFragment;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private Fragment constellationFragment;

	private RadioGroup radioGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
		constellationFragment = new ConstellationFragment();

		getSupportFragmentManager().beginTransaction()
				.add(R.id.main_layout, constellationFragment, "C")
				.commitAllowingStateLoss();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
