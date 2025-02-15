package com.zhouguan.composelearn

import android.os.Bundle
import android.preference.PreferenceActivity.Header
import android.provider.ContactsContract
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import javax.sql.DataSource

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

//    @Composable
//    fun App(appData : AppData){
//        val deliverData = compute(appData)
//        Header()
//        if(appData.isOwner){
//            EditButton()
//        }
//        Body{
//            for (item in deliverData.items){
//                Item(item)
//            }
//        }
//    }

}