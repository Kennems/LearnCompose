package com.zhouguan.composelearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import com.zhouguan.composelearn.ui.theme.ComPoseLearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        setContent{
            ComPoseLearnTheme {
//                TextWithPaddingToBaseline()
                ScrollingList()
            }
        }

//        setContent {
//            MessageCard(Message("Kotlin", "kkk"))
//        }

//        setContent {
//            Scaffold {
//                Column(modifier = Modifier.padding(it)) {
//                    MessageCard(Message("Kotlin", "kkk"))
//                }
//            }
//        }
    }

    @Composable
    fun MessageCard(message: Message) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.prayer),
                contentDescription = null
            )
            Column {
                Text(text = "Hello ${message.author}!")
                Text(text = message.body)
            }
        }
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(Message("Kotlin", "kkk"))
        setContent {
            Scaffold {
                Column(modifier = Modifier.padding(it)) {
                    MessageCard(Message("Kotlin", "kkk"))
                }
            }
        }
    }

    data class Message(val author: String, val body: String)

    fun bind(livesMsgs: LiveData<Message>) {
        livesMsgs.observe(this) {
            // TODO: updateBody(msgs)
        }
    }

    @Composable
    fun Messages(liveMsgs: LiveData<List<Message>>) {
        // 将 LiveData 转换为 Compose 状态
        val msgs = liveMsgs.observeAsState()
        for (msg in msgs.value!!) {
            MessageCard(msg)
        }
    }


}


//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComPoseLearnTheme {
//        Greeting("Android")
//    }
//}