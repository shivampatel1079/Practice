package com.example.practice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.theme.PracticeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CheckboxSimpleExample(
                        //name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


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


//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposableLazy(modifier: Modifier = Modifier) {

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(cricketPlayer) {it->
            val name = it.name
            val color = it.color
            ShowCricket(name=name,color=color)

        }
    }
}

data class Playerlist(val name:String,val color: Color)

val cricketPlayer = listOf(
        Playerlist("Virat",Color.Blue),
        Playerlist("Rohit",Color.Green),
        Playerlist("Rahul",Color.Blue),
        Playerlist("Shurya",Color.Green),
        Playerlist("Rishab",Color.Blue),
        Playerlist("Hardik",Color.Green),
        Playerlist("Axar",Color.Blue),
        Playerlist("Ashwin",Color.Green),
        Playerlist("Shami",Color.Blue),
        Playerlist("Siraj",Color.Green),
        Playerlist("Bumrah",Color.Blue)
    )

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowCricket (
    modifier: Modifier = Modifier,
    name: String = "Virat",
    color: Color= Color.Blue
)
{
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(15.dp),
        //shadowElevation = 10.dp,
        color = Color.Gray.copy(alpha = 0.5f),
        border = BorderStroke(2.dp,color)



    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Spacer(modifier = modifier.width(30.dp))
            Icon(
                modifier = Modifier
                    .size(45.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(color),
                imageVector = Icons.Default.Person,
                contentDescription = "profile",
                //tint = Color.White
                )
            Spacer(modifier = modifier.width(10.dp))
            Text(
                modifier = Modifier.padding(10.dp),
                text = name,
                style = TextStyle(fontSize = 40.sp, shadow = Shadow(color = color, blurRadius = 20f))
            )
        }
    }
}


@Composable
fun CounterScreen (modifier: Modifier = Modifier) {

    var count by remember { mutableStateOf(0) }

    Box (modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Counter App",
                style = TextStyle(
                    fontSize = 40.sp,
                )

            )
            Spacer(modifier=Modifier.height(20.dp))

            Text(text = count.toString(),
                style = TextStyle(fontSize = 20.sp)
            )

            Spacer(modifier=Modifier.height(20.dp))

            Button(onClick = {count++}) {
                Text("Count")
            }

        }
    }

}

@Composable
fun CheckboxSimpleExample(modifier: Modifier = Modifier) {
    var checked by remember { mutableStateOf(false) }

    Row (modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)){
        Text("Male")
        Checkbox(checked = checked, onCheckedChange = {checked =!checked})
        Text("Female")
        Checkbox(checked = !checked, onCheckedChange = {checked = !checked})

    }
    Text(modifier = Modifier.padding(50.dp),text = "${if (checked) "Checked" else "Unchecked"}")

}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CheckboxTrail(){
    var selectM by remember { mutableStateOf(false) }
    var selectF by remember { mutableStateOf(false) }

    Row (modifier= Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center ){
        Text("Male")
        Checkbox(checked = selectM  , onCheckedChange = {selectM=it
            if (it) { selectF = false }
        })

        Text("Female")
        Checkbox(checked = selectF , onCheckedChange = {selectF=it
            if (it) { selectM = false }
        })
    }

    Text(if (selectM) "Checked" else "Unchecked")

    Text(if (selectF) "Checked" else "Unchecked")

}

//@Preview(showBackground = true, showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposableTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(title = { Text("HOME") },

        navigationIcon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = "") },

        actions = {
            Icon(imageVector = Icons.Default.Settings, contentDescription = "")
            Spacer(modifier=Modifier.width(20.dp))
            Icon(imageVector = Icons.Default.Info, contentDescription = "")
        },

        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer )
    )
//    CenterAlignedTopAppBar ,MediumTopAppBar, LargeTopAppBar

}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposableBottomAppBar(modifier: Modifier = Modifier) {

    Column (modifier=Modifier.fillMaxSize(),
             verticalArrangement = Arrangement.SpaceBetween
        ){
        ComposableTopAppBar()

        BottomAppBar(contentPadding = PaddingValues(start = 20.dp)) {
            Icon(imageVector = Icons.Default.Build, contentDescription = "")
            Spacer(modifier=Modifier.width(16.dp))
            Icon(imageVector = Icons.Default.Search, contentDescription = "")
            Spacer(modifier=Modifier.width(16.dp))
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposableScaffold(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {ComposableTopAppBar()},

        bottomBar = {BottomAppBar(contentPadding = PaddingValues(start = 20.dp)) {
            Icon(imageVector = Icons.Default.Build, contentDescription = "")
            Spacer(modifier=Modifier.width(16.dp))
            Icon(imageVector = Icons.Default.Search, contentDescription = "")
            Spacer(modifier=Modifier.width(16.dp))
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
        }},

        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        },

        floatingActionButtonPosition = FabPosition.Start

    ) { innerPadding ->
        ComposableLazy(modifier = Modifier.padding(innerPadding))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposableScaffoldNavigation(drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {TopAppBar(title = { Text("HOME", modifier = Modifier.padding(10.dp)) },

            navigationIcon = {
                IconButton(onClick = {
                    drawerState.apply {
                        scope.launch {
                            if (isOpen) close() else open()
                        }
                    }
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                }
            },

            actions = {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "")
                Spacer(modifier=Modifier.width(20.dp))
                Icon(imageVector = Icons.Default.Info, contentDescription = "")
            },

            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer )
        )},

        bottomBar = {BottomAppBar(contentPadding = PaddingValues(start = 20.dp)) {
            Icon(imageVector = Icons.Default.Build, contentDescription = "")
            Spacer(modifier=Modifier.width(16.dp))
            Icon(imageVector = Icons.Default.Search, contentDescription = "")
            Spacer(modifier=Modifier.width(16.dp))
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
        }},

        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        },

        floatingActionButtonPosition = FabPosition.Start

    ) { innerPadding ->
        ComposableLazy(modifier = Modifier.padding(innerPadding))

    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposableNavigationDrawer(modifier: Modifier = Modifier) {
    val drawerState = rememberDrawerState(DrawerValue.Open)
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Text(modifier = Modifier.padding(20.dp), fontSize = 25.sp, text = "Navigation Menu")
                HorizontalDivider()
                Spacer(modifier = Modifier.height(20.dp))
                NavigationDrawerItem(
                    label = { Text("Inbox") },
                    icon = { Icon(imageVector = Icons.Default.MailOutline, contentDescription = "") },
                    badge = { Icon(imageVector = Icons.Default.Check, contentDescription = "")},
                    selected = true,
                    onClick = {},
                )
                NavigationDrawerItem(
                    label = { Text("Outbox") },
                    icon = { Icon(imageVector = Icons.Default.Send, contentDescription = "") },
                    selected = false,
                    onClick = {},
                )
                NavigationDrawerItem(
                    label = { Text("Favorites") },
                    icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "") },
                    selected = false,
                    onClick = {},
                )
            }
        },
        drawerState = drawerState

    ) {
        ComposableScaffoldNavigation(drawerState)
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposableDialog(modifier: Modifier = Modifier) {
    var showDialog by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {showDialog = true}) {
            Text("Show Dialog")
        }
    }

    if (showDialog){
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            } ,
            confirmButton = {
                Button(onClick = {showDialog = false}) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                Button(onClick = {showDialog = false}) {
                    Text("Dismiss")
                }
            },
            icon = {
                Icon(imageVector = Icons.Default.Build, contentDescription = "")
            },
            title = { Text("Alert Dialog") },
            text = { Text("This is a alert dialog") },
            )
    }
    // If use Dialog then we can customize our dialog as we can pass content here
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposableBottomSheet(modifier: Modifier = Modifier) {
    var showBottomSheet by remember { mutableStateOf(false) }
    var sheetState = rememberModalBottomSheetState()
    var scope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {showBottomSheet = true}) {
            Text("Show Sheet")
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(onDismissRequest = {
            showBottomSheet = false
        }
        ) {
            Text(modifier = Modifier.fillMaxWidth(),text = "Select",fontWeight = FontWeight.Bold,fontSize = 26.sp, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.padding(start = 16.dp)) {
                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
                Spacer(modifier = Modifier.width(15.dp))
                Text("Add")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.padding(start = 16.dp)) {
                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
                Spacer(modifier = Modifier.width(15.dp))
                Text("Add")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.padding(start = 16.dp)) {
                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
                Spacer(modifier = Modifier.width(15.dp))
                Text("Add")
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(10.dp),
                onClick = {
                    scope.launch {
                        sheetState.hide()
                        showBottomSheet = false
                    }
            }) {
                Text("Hide Sheet")
            }
        }
    }
}
