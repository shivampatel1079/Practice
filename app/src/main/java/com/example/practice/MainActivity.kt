package com.example.practice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
                    Checkboxexample(
                        //name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposableTextField(modifier: Modifier = Modifier) {
    var tfTxet by remember { mutableStateOf("") }
    TextField(
        value = tfTxet,
        onValueChange = { tfTxet = it },
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .wrapContentSize(Alignment.Center),
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
        //visualTransformation = PasswordVisualTransformation(), // it used for password hiding
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Words,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Search
            ),
        keyboardActions = KeyboardActions(
            onSearch = { Log.d("ImeAction", "Clicked on search")}
        )

    )
}

@Composable
fun PassEye(modifier: Modifier = Modifier) {

    Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        var valtext by remember { mutableStateOf("") }

        var passVisible by remember { mutableStateOf(true) }

        TextField(value = valtext,
                  onValueChange = {valtext =it},
                  label = { Text("Password") },
                  trailingIcon = {
                      IconButton(onClick = { passVisible = !passVisible })
                      {
                          Icon(imageVector =
                          if (passVisible){
                              ImageVector.vectorResource(id = R.drawable.visibility_24dp_e8eaed_fill0_wght400_grad0_opsz24 )
                          }
                          else{
                                  ImageVector.vectorResource(id = R.drawable.visibility_off_24dp_e8eaed_fill0_wght400_grad0_opsz24)
                              },
                              contentDescription = "")
                      }
                  },
            visualTransformation = if (passVisible){
                PasswordVisualTransformation()
            }
            else{
                VisualTransformation.None
            }


            )

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Checkboxexample(modifier: Modifier = Modifier) {
    var checked by remember { mutableStateOf(false) }

    Row (modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)){
        Text("Male")
        Checkbox(checked = checked, onCheckedChange = {checked =!checked})
        Text("Female")
        Checkbox(checked = !checked, onCheckedChange = {checked = !checked})

    }
    Text(modifier = Modifier.padding(50.dp),text = "${if (checked) "Checked" else "Unchecked"}")

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CheckboxExample(modifier: Modifier = Modifier) {
    var isMaleChecked by remember { mutableStateOf(false) }
    var isFemaleChecked by remember { mutableStateOf(false) }

    Row(modifier = modifier) {
        Text("Male")
        Checkbox(
            checked = isMaleChecked,
            onCheckedChange = {
                isMaleChecked = it
                if (it) isFemaleChecked = false // Uncheck Female if Male is checked
            }
        )
        Spacer(modifier = Modifier.width(8.dp)) // Add some space between items
        Text("Female")
        Checkbox(
            checked = isFemaleChecked,
            onCheckedChange = {
                isFemaleChecked = it
                if (it) isMaleChecked = false // Uncheck Male if Female is checked
            }
        )
    }
}
