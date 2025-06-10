package com.kmpstudy.samples.basic_components.switch_and_checkbox_and_radiobutton

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SwitchExamples() {
    Column(modifier = Modifier.padding(16.dp)) {
        var checked by remember { mutableStateOf(false) }

        // 基础开关
        Switch(
            checked = checked,
            onCheckedChange = { checked = it }
        )

        // 带标签的开关
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("飞行模式")
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = checked,
                onCheckedChange = { checked = it }
            )
        }

        // 自定义颜色的开关
        Switch(
            checked = checked,
            onCheckedChange = { checked = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                uncheckedThumbColor = MaterialTheme.colorScheme.surface,
                uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        )
    }
}


@Composable
fun CheckboxExamples() {
    Column(modifier = Modifier.padding(16.dp)) {
        // 基础复选框
        var checked by remember { mutableStateOf(false) }
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )

        Spacer(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.Black))

        // 带标签的复选框组
        val fruits = remember {
            mutableStateListOf("苹果", "香蕉", "橙子")
        }
        val selectedFruits = remember { mutableStateListOf<String>() }

        fruits.forEach { fruit ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = selectedFruits.contains(fruit),
                    onCheckedChange = { checked ->
                        if (checked) selectedFruits.add(fruit)
                        else selectedFruits.remove(fruit)
                    }
                )
                Text(fruit)
            }
        }
    }
}

@Composable
fun RadioButtonExamples() {
    Column(modifier = Modifier.padding(16.dp)) {
        // 单选按钮组
        val options = listOf("选项1", "选项2", "选项3")
        var selectedOption by remember { mutableStateOf(options[0]) }

        options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (option == selectedOption),
                        onClick = { selectedOption = option }
                    )
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = { selectedOption = option }
                )
                Text(
                    text = option,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}