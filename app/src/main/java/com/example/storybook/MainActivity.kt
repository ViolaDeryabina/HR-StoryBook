package com.example.storybook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hr_uikit.R
import com.example.hr_uikit.presentation.components.Avatar
import com.example.hr_uikit.presentation.components.BottomBar
import com.example.hr_uikit.presentation.components.BottomSheet
import com.example.hr_uikit.presentation.components.CardCustom
import com.example.hr_uikit.presentation.components.CustomCheckBox
import com.example.hr_uikit.presentation.components.DestructiveSolidButton
import com.example.hr_uikit.presentation.components.Input
import com.example.hr_uikit.presentation.components.Pagination
import com.example.hr_uikit.presentation.components.PrimaryButton
import com.example.hr_uikit.presentation.components.PrimaryLoading
import com.example.hr_uikit.presentation.components.SecondaryButton
import com.example.hr_uikit.presentation.components.Select
import com.example.hr_uikit.presentation.model.BottomSheetData
import com.example.hr_uikit.presentation.theme.CustomTheme
import com.example.hr_uikit.presentation.theme.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
    val scroll = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scroll)
    ) {
        PrimaryButton(
            onClick = {},
            text = "PrimaryButton",
            enabled = true
        )
        Spacer(modifier = Modifier.height(10.dp))
        PrimaryLoading(
            onClick = {},
            text = "PrimaryLoading",
            enabled = true
        )
        Spacer(modifier = Modifier.height(10.dp))
        SecondaryButton(
            onClick = {},
            text = "SecondaryButton",
            enabled = true
        )
        Spacer(modifier = Modifier.height(10.dp))
        DestructiveSolidButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            text = "DestructiveSolidButton",
            enabled = true
        )
        Spacer(modifier = Modifier.height(10.dp))
        var value by remember { mutableStateOf("") }
        var value2 by remember { mutableStateOf("") }
        Input(
            value = value,
            onValueChange = { value = it },
            placeholder = {
                Text(
                    text = "Active typing state",
                    style = CustomTheme.typography.BodyMedium16px,
                    color = Text
                )
            }, isError = true
        )
        Spacer(modifier = Modifier.height(10.dp))
        Input(
            value = value2,
            onValueChange = { value2 = it },
            placeholder = {
                Text(
                    text = "Active typing state",
                    style = CustomTheme.typography.BodyMedium16px,
                    color = Text
                )
            }, isError = false
        )
        Spacer(modifier = Modifier.height(10.dp))
        var showBottomSheet by remember { mutableStateOf(false) }
        var listState by remember {
            mutableStateOf(
                listOf(
                    BottomSheetData(
                        "New Applicants",
                        selected = true,
                        id = 0
                    ),
                    BottomSheetData("New Applicants", selected = false, id = 1),
                    BottomSheetData("New Applicants", selected = false, id = 2),
                    BottomSheetData("New Applicants", selected = false, id = 3),
                    BottomSheetData("New Applicants", selected = false, id = 4),
                    BottomSheetData("New Applicants", selected = false, id = 5)
                )
            )
        }
        if (showBottomSheet) {
            BottomSheet(
                listString = listState,
                onDismissRequest = { showBottomSheet = false },
                onItemSelected = { clickedItem ->
                    listState = listState.map { it.copy(selected = it.id == clickedItem.id) }
                },
                onClickCancel = { showBottomSheet = false },
                onClickUpdate = { showBottomSheet = false }
            )
        }
        Select(value = "", onValueChange = {}, onClick = { showBottomSheet = true })
        Spacer(modifier = Modifier.height(10.dp))
        CustomCheckBox(checked = true, onCheckedChange = {}, enabled = true)
        Spacer(modifier = Modifier.height(10.dp))
        CustomCheckBox(checked = false, onCheckedChange = {}, enabled = true)
        Spacer(modifier = Modifier.height(10.dp))
        CustomCheckBox(checked = true, onCheckedChange = {}, enabled = false)
        Spacer(modifier = Modifier.height(10.dp))
        CustomCheckBox(checked = false, onCheckedChange = {}, enabled = false)
        Spacer(modifier = Modifier.height(10.dp))
        CardCustom(
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Avatar(
            name = "FIO",
            bitmap = ImageBitmap.imageResource(R.drawable.candidate_avatar)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Avatar(
            name = "FIO",
            bitmap = null
        )
        Spacer(modifier = Modifier.height(10.dp))
        Pagination(currentPageIndex = 0)
        Spacer(modifier = Modifier.height(10.dp))
        Pagination(currentPageIndex = 1)
        Spacer(modifier = Modifier.height(10.dp))
        Pagination(currentPageIndex = 2)
        Spacer(modifier = Modifier.height(10.dp))
        Pagination(currentPageIndex = 0, progress = true)
        Spacer(modifier = Modifier.height(10.dp))
        Pagination(currentPageIndex = 1, progress = true)
        Spacer(modifier = Modifier.height(10.dp))
        Pagination(currentPageIndex = 2, progress = true)
        Spacer(modifier = Modifier.height(10.dp))
        BottomBar(selected = 0, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(10.dp))
        BottomBar(selected = 1, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(10.dp))
        BottomBar(selected = 2, modifier = Modifier.fillMaxWidth())


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomTheme {
        Greeting()
    }
}