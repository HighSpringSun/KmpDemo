package com.kmpstudy.samples.basic_components.text_and_input_controls

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
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

@Composable
fun SpecialTextFieldExamples() {
    var password by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        // 密码输入框
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("密码") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 数字输入框
        OutlinedTextField(
            value = number,
            onValueChange = { if (it.all { char -> char.isDigit() }) number = it },
            label = { Text("年龄") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
fun ValidationTextField() {
    var text by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                isError = it.length < 3
            },
            label = { Text("用户名") },
            isError = isError,
            supportingText = {
                if (isError) {
                    Text(
                        text = "用户名至少需要3个字符",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            trailingIcon = {
                if (isError)
                    Icon(Icons.Filled.Warning, "warning", tint = MaterialTheme.colorScheme.error)
                else
                    Icon(Icons.Filled.Check, "success", tint = MaterialTheme.colorScheme.primary)
            }
        )
    }
}


@Composable
fun SearchTextField() {
    var searchQuery by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        placeholder = { Text("搜索...") },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "搜索")
        },
        trailingIcon = {
            if (searchQuery.isNotEmpty()) {
                IconButton(onClick = { searchQuery = "" }) {
                    Icon(Icons.Default.Clear, "清除")
                }
            }
        },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}