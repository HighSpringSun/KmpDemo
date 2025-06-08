package com.kmpstudy.samples.basic_components.text_and_input_controls

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldExamples() {
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        // 基础输入框
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("用户名") },
            placeholder = { Text("请输入用户名") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 轮廓输入框
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("邮箱") },
            placeholder = { Text("请输入邮箱地址") }
        )
    }
}