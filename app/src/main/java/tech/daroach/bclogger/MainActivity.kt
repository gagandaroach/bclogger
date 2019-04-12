package tech.daroach.bclogger

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import tech.daroach.bclogger.ui.Dashboard

class MainActivity : AppCompatActivity(), Dashboard.OnFragmentInteractionListener {

    companion object {
        const val TAG = "androidx_is_nice"
    }

    override fun onFragmentInteraction(uri: Uri) {
        Log.d(TAG, "OnFragmentInteraction: " + uri.toString()) //TODO: figure out what this is needed for.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
