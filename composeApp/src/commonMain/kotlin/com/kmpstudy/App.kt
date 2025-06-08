package com.kmpstudy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kmpstudy.samples.basic_components.image_and_icon.CommonIconsExample
import com.kmpstudy.samples.basic_components.image_and_icon.IconExamples
import com.kmpstudy.samples.basic_components.image_and_icon.ImageExamples
import com.kmpstudy.samples.basic_components.image_and_icon.ImageScaleExamples
import com.kmpstudy.samples.basic_components.text_and_button.ButtonExamples
import com.kmpstudy.samples.basic_components.text_and_button.ButtonStateExample
import com.kmpstudy.samples.basic_components.text_and_button.RichTextExample
import com.kmpstudy.samples.basic_components.text_and_button.TextExamples
import com.kmpstudy.samples.basic_components.text_and_input_controls.TextFieldExamples
import kmpdemo.composeapp.generated.resources.Res
import kmpdemo.composeapp.generated.resources.compose_multiplatform_logo
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    Column {
//        TextExamples()
//        RichTextExample()
//        ButtonExamples()
//        ImageExamples()
//        ImageScaleExamples()
//        ButtonStateExample()
//        IconExamples()
//        CommonIconsExample()
//        TextFieldExamples()
        ImageBackgroundExample()
    }
}

@Composable
fun ImageBackgroundExample() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painterResource(Res.drawable.compose_multiplatform_logo),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red.copy(0.5f)),
        )

        Column {
            Text("Hello")

            Button(
                onClick = {}
            ) {
                Text("Button")
            }
        }

    }
}


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
fun CounterScreen() {
    var count by remember { mutableStateOf(0) }

    Column(Modifier.padding(16.dp)) {
        Text("Current count: $count", style = MaterialTheme.typography.displayLarge)
        Spacer(Modifier.height(16.dp))
        Row {
            Button(onClick = { count++ }) { Text("+") }
            Spacer(Modifier.width(8.dp))
            Button(onClick = { count-- }) { Text("-") }
        }
    }
}