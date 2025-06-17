package com.kmpstudy.samples.compose_fundamentals.compose_function_fundamentals

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// 坏例子：做太多事情
@Composable
fun BadComponent() {
    Column {
        Text("标题")  // 职责1：显示标题
        Button(onClick = { /*...*/ }) { // 职责2：处理点击
            Text("按钮")
        }
    }
}

// 好例子：拆分成单一职责
@Composable
fun TitleText(text: String) {
    Text(text, style = MaterialTheme.typography.headlineSmall)
}

@Composable
fun ConfirmButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("确认")
    }
}

//@Composable
//fun UserProfileCard(user: User) {
//    Column {
//        UserAvatar(user)          // 复用头像组件
//        UserInfoText(user)        // 复用信息文本
//        FollowButton(user.id)     // 复用按钮组件
//    }
//}

@Composable
fun HighlightText(
    text: String,
    isHighlighted: Boolean = false
) {
    Text(
        text = text,
        color = if (isHighlighted) Color.Blue else Color.Black
    )
}

@Composable
fun CardExample() {
    // 使用示例
    CardWithAction(
        title = "Settings",
        action = { Button(onClick = {}) { Text("Save") } }
    ) {
        Text("Change your preferences here")
    }
}

@Composable
fun CardWithAction(
    title: String,
    action: @Composable () -> Unit, // 插槽：由调用方决定按钮内容
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(start = 2.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
            .padding(8.dp)
    ) {
        Text(title, style = MaterialTheme.typography.titleMedium)
        content()
        Row(Modifier.width(300.dp)) {
            Spacer(Modifier.weight(1f))
            action() // 插入外部传入的Composable
        }
    }
}

//@Composable
//fun AppTheme(content: @Composable () -> Unit) {
//    MaterialTheme(
//        colors = lightColors(primary = Color.Blue),
//        typography = customTypography,
//        content = content
//    )
//}