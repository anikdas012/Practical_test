package tk.anikdas.anikdas012.mobileapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tk.anikdas.anikdas012.mobileapplication.di.FragmentComponent

class MainActivity : AppCompatActivity() {

    lateinit var fragmentComponent: FragmentComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentComponent = (application as BaseApplication).appComponent
            .fragmentComponent().build()
    }
}