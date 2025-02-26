package com.example.practice

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

//@Preview(showBackground = true)
@Composable
fun ComposableRememberScope(modifier: Modifier = Modifier) {

    val scope = rememberCoroutineScope()
    //scope.launch {  } - Calls to launch should happen inside a LaunchedEffect and not composition
    var buttonText by remember { mutableStateOf("Hello") }

    Button(onClick = {
    // LaunchedEffect() { } - This will show error bec this is not a Comp and is only be called inside Comp
        scope.launch {
            delay(2000)
            buttonText = "Why"
        }
    }) {
        Text(buttonText)
    }
}

//@Preview(showBackground = true)
@Composable
fun ComposableRememberUpdatedState(modifier: Modifier = Modifier) {
    var count by remember { mutableIntStateOf(0) }

    Button(onClick = {
        count = Random.nextInt(1,100)
        Log.d("Shivam", "Random Count $count")
    }) {
        Text("Click")
    }
    ShowUpdatedVale(count)
}

@Composable
fun ShowUpdatedVale(count: Int) {
    val updatedCount = rememberUpdatedState(count)
    LaunchedEffect(key1 = Unit) {
        delay(10000)
        Log.d("Shivam", "Updated Count ${updatedCount.value} ")
    }
}

//@Preview(showBackground = true)
@Composable
fun ComposableProduceState(modifier: Modifier = Modifier) {

    val dataFetched by produceState("Loading...") {
        var data = getData() //this will not give error bec produceState hold coroutine scope
        value = if (data.isNotEmpty()) "Data Fetched"
        else "Data not Fetched"
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        if (dataFetched == "Loading..."){
            CircularProgressIndicator()
        }
        else Text(dataFetched)
    }

}

@Composable
fun ComposableLoading(modifier: Modifier = Modifier) {

    var initialData by remember { mutableStateOf("Loading...") }

    LaunchedEffect(Unit) {
        var dataFetched = getData()
        initialData = if (dataFetched.isNotEmpty()) "Data Fetched"
        else "Data not Fetched"
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        if (initialData == "Loading..."){
            CircularProgressIndicator()
        }
        else Text(initialData)
    }

}

//network call
suspend fun getData() : List<String> {
    delay(2000)
    return listOf("Hello","World")
}

//@Preview(showBackground = true)
@Composable
fun ComposableDerivedState(modifier: Modifier = Modifier) {
    var count by remember { mutableIntStateOf(0) }

    val updated by remember { derivedStateOf { count > 3 } }

    Column {
        Button(onClick = {count++}) {
            Text("Button 1")
        }

        if (updated){
            Log.d("SP", "Button Showing")
            Button(onClick = {}) { Text("Button 2") }
        }
        else{
            Log.d("SP", "Button NotShowing")
        }
    }
}
