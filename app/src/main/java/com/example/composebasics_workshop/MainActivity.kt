package com.example.composebasics_workshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasics_workshop.ui.theme.ComposeBasicsWorkshopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsWorkshopTheme {
                MyApp(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}


@Composable
private fun MyApp(modifier: Modifier = Modifier,
                  names: List<String> = listOf("World", "Compose")) {
//    Surface (
//        modifier = modifier,
//        color = MaterialTheme.colorScheme.background
//    ) {
//        Greeting("Android")
//    }
    //vertical is added padding to the top and bottom of the column
    Column(modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }

}

@Composable
//Composable fun. is just a reg. fun. with @Composable
//which allow it to call another composable fun within it. [Text]
fun Greeting(name: String) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        //Vertical = space between rows, horizontal = sides
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        //fillMaxWidth = color to fill space, padding for space around text
        Column(modifier = Modifier.fillMaxWidth().padding(24.dp)){
            Text(text = "Hello", )
            Text(text = "$name!")
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    ComposeBasicsWorkshopTheme {
        MyApp()
    }
}
