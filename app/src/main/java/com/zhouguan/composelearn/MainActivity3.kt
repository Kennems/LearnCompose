package com.zhouguan.composelearn

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zhouguan.composelearn.MainActivity2.Message
import com.zhouguan.composelearn.ui.theme.ComPoseLearnTheme

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComPoseLearnTheme() {
                MessageCard(Message("Kotlin", "ZhouGuan"))
            }
        }
    }

    @Composable
    fun MessageCard(message: Message) {
        Box(
            modifier = Modifier
                .fillMaxSize() // 占满整个父容器
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center // 让 Box 内的内容整体居中
        ) {
            Row(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .background(MaterialTheme.colorScheme.background),
                verticalAlignment = Alignment.CenterVertically, // Row 内部垂直居中
                horizontalArrangement = Arrangement.Center // Row 内部水平居中
            ) {
                Image(
                    painter = painterResource(id = R.drawable.boat),
                    contentDescription = "boat",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop // 确保图片填充整个圆形区域
                )
                Column(
                    modifier = Modifier.padding(start = 8.dp), // 图片和文字间添加间距
                    verticalArrangement = Arrangement.Center, // Column 内部垂直居中
                    horizontalAlignment = Alignment.Start // Column 内文字水平对齐方式
                ) {
                    Text(
                        text = "Hello ${message.author}!",
                        color = MaterialTheme.colorScheme.onBackground
                    )// 使用主题提供的颜色
                    Text(
                        text = message.body,
                        color = MaterialTheme.colorScheme.onBackground
                    )// 使用主题提供的颜色
                }
            }
        }
    }


    @Preview
    @Composable
    fun PreviewMessageCard() {
        ComPoseLearnTheme() {
            MessageCard(Message("Kotlin", "ZhouGuan"))
        }
    }

    data class Message(val author: String, val body: String)

}