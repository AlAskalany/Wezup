package com.alaskalany.android.wezup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alaskalany.android.wezup.ui.main.MainFragment
import com.alaskalany.android.wezup.ui.main.dummy.DummyContent

class MainActivity : AppCompatActivity(), MainFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance(1))
                .commitNow()
        }
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        Toast.makeText(this, "Item Clicked", Toast.LENGTH_SHORT).show()
    }
}
