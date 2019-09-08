package com.alaskalany.android.wezup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alaskalany.android.model.IDailyData
import com.alaskalany.android.wezup.databinding.MainActivityBinding
import com.alaskalany.android.wezup.ui.main.MainFragment
import com.alaskalany.android.wezup.ui.main.dummy.DummyContent

class MainActivity : AppCompatActivity(), MainFragment.OnListFragmentInteractionListener {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance(1))
                .commitNow()
        }
    }

    override fun onListFragmentInteraction(item: IDailyData?) {
        Toast.makeText(this, "Item Clicked", Toast.LENGTH_SHORT).show()
    }
}
