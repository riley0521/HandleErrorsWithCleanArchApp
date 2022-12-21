package com.rpfcoding.handleerrorswithcleanarchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rpfcoding.handleerrorswithcleanarchapp.presentation.MyViewModel
import com.rpfcoding.handleerrorswithcleanarchapp.ui.theme.HandleErrorsWithCleanArchAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HandleErrorsWithCleanArchAppTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    val viewModel = viewModel<MyViewModel>()
                    val email by viewModel.email.collectAsState()
                    val error by viewModel.error.collectAsState()

                    TextField(
                        value = email,
                        onValueChange = viewModel::onEmailChanged,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = viewModel::submitEmail,
                        modifier = Modifier
                            .align(Alignment.End)
                    ) {
                        Text(text = "Submit")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    if(error != null) {
                        Text(text = error!!.asString())
                    }
                }
            }
        }
    }
}