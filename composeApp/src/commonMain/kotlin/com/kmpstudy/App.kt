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
import com.kmpstudy.samples.basic_components.divider_and_spacer.CommonLayoutPatterns
import com.kmpstudy.samples.basic_components.divider_and_spacer.DividerExamples
import com.kmpstudy.samples.basic_components.divider_and_spacer.SpacerExamples
import com.kmpstudy.samples.basic_components.image_and_icon.CommonIconsExample
import com.kmpstudy.samples.basic_components.image_and_icon.IconExamples
import com.kmpstudy.samples.basic_components.image_and_icon.ImageExamples
import com.kmpstudy.samples.basic_components.image_and_icon.ImageScaleExamples
import com.kmpstudy.samples.basic_components.slider.MediaPlayerSlider
import com.kmpstudy.samples.basic_components.slider.RangeSliderExample
import com.kmpstudy.samples.basic_components.slider.SliderExamples
import com.kmpstudy.samples.basic_components.surface_and_card.CardExamples
import com.kmpstudy.samples.basic_components.surface_and_card.CustomCardExample
import com.kmpstudy.samples.basic_components.surface_and_card.SurfaceExamples
import com.kmpstudy.samples.basic_components.surface_and_card.SurfaceVariants
import com.kmpstudy.samples.basic_components.switch_and_checkbox_and_radiobutton.CheckboxExamples
import com.kmpstudy.samples.basic_components.switch_and_checkbox_and_radiobutton.RadioButtonExamples
import com.kmpstudy.samples.basic_components.switch_and_checkbox_and_radiobutton.SwitchExamples
import com.kmpstudy.samples.basic_components.text_and_button.ButtonExamples
import com.kmpstudy.samples.basic_components.text_and_button.ButtonStateExample
import com.kmpstudy.samples.basic_components.text_and_button.RichTextExample
import com.kmpstudy.samples.basic_components.text_and_button.TextExamples
import com.kmpstudy.samples.basic_components.text_and_input_controls.SearchTextField
import com.kmpstudy.samples.basic_components.text_and_input_controls.SpecialTextFieldExamples
import com.kmpstudy.samples.basic_components.text_and_input_controls.TextFieldExamples
import com.kmpstudy.samples.basic_components.text_and_input_controls.ValidationTextField
import com.kmpstudy.samples.modifier_system.modifier_basics.CardStyleExample
import com.kmpstudy.samples.modifier_system.modifier_basics.ChainCallExample
import com.kmpstudy.samples.modifier_system.modifier_basics.ModifierBasicExample
import com.kmpstudy.samples.modifier_system.modifier_basics.OrderComparisonExample
import com.kmpstudy.samples.modifier_system.modifier_basics.ScopeExample
import com.kmpstudy.samples.modifier_system.size_and_padding.AspectRatioExample
import com.kmpstudy.samples.modifier_system.size_and_padding.FancyButtonExample
import com.kmpstudy.samples.modifier_system.size_and_padding.FillSizeExample
import com.kmpstudy.samples.modifier_system.size_and_padding.MarginExample
import com.kmpstudy.samples.modifier_system.size_and_padding.PaddingExample
import com.kmpstudy.samples.modifier_system.size_and_padding.SizeModifierExample
import com.kmpstudy.samples.modifier_system.size_and_padding.WeightExample
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
//        TextFieldExamples()
//        SpecialTextFieldExamples()
//        Column {
//            ValidationTextField()
//            ValidationTextField()
//        }
//        Column {
//            SearchTextField()
//            SearchTextField()
//        }
//        SwitchExamples()
//        CheckboxExamples()
//        RadioButtonExamples()
//        SliderExamples()
//        RangeSliderExample()
//        MediaPlayerSlider()
//        SurfaceExamples()
//        SurfaceVariants()
//        CardExamples()
//        CustomCardExample()
//        DividerExamples()
//        SpacerExamples()
//        CommonLayoutPatterns()
//        ModifierBasicExample()
//        ChainCallExample()
//        OrderComparisonExample()
//        ScopeExample()
//        CardStyleExample()
//        SizeModifierExample()
//        FillSizeExample()
//        PaddingExample()
//        MarginExample()
//        AspectRatioExample()
//        WeightExample()
        FancyButtonExample()
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