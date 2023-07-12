package com.example.jetcompose

import LoadingAnimation
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetcompose.ui.theme.JetComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
/*Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    LoadingAnimation()

}*/
           loginScreen()
            //counter()
          //  Recyclerview(users = dummyData())

            //  UserList()
            //UserCard()
            //Title()
        }
    }
    private fun  logged(username :String,password :String){
        if(username =="jks" && password =="12345"){

            Toast.makeText(this,"logged ",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"wrong ",Toast.LENGTH_LONG).show()

        }
    }

    @Composable
    fun loginScreen() {
        //modifier - how to layout or display behave inside to parent layout
        //Composable functions can store a single object in memory by using the remember composable. A value computed by remember is stored in the Composition during initial composition, and the stored value is returned during recomposition. remember can be used to store both mutable and immutable objects.
        val username = remember {
            mutableStateOf("")
        }
        val password = remember {
            mutableStateOf("")
        }

        Column (modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(20.dp), verticalArrangement = Arrangement.Center) {
            Text(
                text = "Hello Again", color = Color.Blue, fontSize = 25.sp,
                fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold
            )
            Text(
                text = "Welcome", color = Color.Blue, fontSize = 25.sp,
                fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold
            )
            Text(
                text = "Back", color = Color.Blue, fontSize = 25.sp,
                fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                value = username.value,
                onValueChange = { username.value = it },
                leadingIcon = {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = "person"
                    )
                }, label = { Text(text = "username")},
                placeholder = { Text(text = "enter username")}, modifier = Modifier.fillMaxWidth()

            )

            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                leadingIcon = {
                    Icon(
                        Icons.Default.Info,
                        contentDescription = "person"
                    )
                }, label = { Text(text = "password")},
                placeholder = { Text(text = "enter password")}, modifier = Modifier.fillMaxWidth()
            )

            OutlinedButton(onClick = {logged(username.value,password.value)},Modifier.fillMaxWidth()) {
                Text(text = "Login")
            }

        }


    }
    // this flag means see the background
    @Preview(showBackground = false)
    @Composable
    fun DefaultPreview() {
        // Surface(modifier = Modifier.fillMaxSize()) {
        loginScreen()
    }

    }


@Composable
fun UserList(){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        for(i in 1..10)
            UserCard()
    }
}
@Composable
fun UserCard() {
    //horizontal
    Row(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(2.dp)
        .border(
            width = 1.dp, color = Color.Gray
        )
        .padding(2.dp)) {
        Image(
            painter = painterResource(id = R.drawable.retailer_create_update_xxhdpi),
            contentDescription = "", contentScale = ContentScale.Crop, modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
    }
    //vertially
    Column() {
       Text(text = stringResource(id = R.string.app_name))
        Button(onClick = {

        }) {
           Text(text = "view Profile")
        }
    }
}


@Composable
fun EachRow(user: User){
    Card(modifier = Modifier
        .padding(horizontal = 8.dp, vertical = 8.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(10.dp)), elevation = 2.dp

    ) {
        Row(modifier = Modifier.padding(5.dp)) {
            Image(painter = painterResource(id = R.drawable.retailer_create_update_xxhdpi),
                contentDescription ="image", modifier = Modifier
                    .padding(8.dp)
                    .size(80.dp)
                    .align(Alignment.CenterVertically)
                    .clip(
                        RoundedCornerShape(CornerSize(10.dp))
                    ) )

            Text(text = user.description, modifier = Modifier.padding(8.dp))
        }
    }
}
@Composable
fun Recyclerview(users :List<User>){
    LazyColumn{
        items(users){user ->
            EachRow(user)
        }
    }
}
@Composable
fun Greeting(name: String) {
    //fillMaxSize().fillMaxWidth() these function act as match parent
    //thenfillMaxSize() fillMaxSize() means match parent
    //Surface composable makes the code easier as well as explicitly indicates that the code uses a material surface. Let's see an example:
    Surface(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hello $name")
    }
}


@Composable
fun Title() {
    val context = LocalContext.current
    Text(text = "Jetpack compose", fontSize = 32.sp,
        fontFamily = FontFamily.Cursive,
        color = colorResource(id = R.color.purple_500),
        modifier = Modifier.clickable {
            Toast.makeText(context, "title clicked", Toast.LENGTH_LONG).show()
        })
}



var counter =1
@Composable
fun sideeffects(){
    counter++
    Text(text = "counter")
}

@Composable
fun counter(){
    var count = remember {
        mutableStateOf(0)
    }
        var key =count.value %3==0
    LaunchedEffect(key1 = key ){
        Log.d("counter","current count${count.value}")
   }
    Button(onClick = { count.value++ }) {
        Text(text = "increment count")
    }
}