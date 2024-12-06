package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun GreetingPreview() {
    PracticeTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposableTextField(modifier: Modifier = Modifier) {
    var tfTxet by remember { mutableStateOf("") }
    TextField(
        value = tfTxet,
        onValueChange = { tfTxet = it },
        modifier = Modifier.fillMaxSize().padding(30.dp).wrapContentSize(Alignment.Center),
        //modifier = modifier.then(Modifier.padding(30.dp)).then(Modifier.wrapContentSize(Alignment.Center))
        label = { Text("Email") },
        placeholder = { Text("Enter it") } ,//Optional
        leadingIcon = { Icon(imageVector = Icons.Default.Email,
            contentDescription = null //Required
        ) },
        trailingIcon = {} ,// the icon will in the end of the text field
        prefix = {}, // if you want to add something or text in the start of the text field
        suffix = {}, // if you want to add something or text in the end of the text field like @gmail.com
        supportingText = {}, // if you want to add something or text in the bottom of the text field
        //isError = true, // make iserror true until all req. filled are done to continue for submission.
        visualTransformation = PasswordVisualTransformation() // it used for password hiding


    )
}