package com.example.composebasics_workshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
    //Remember guard against recomposition
    //Help preserve state
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if ( expanded.value ) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,
        //Vertical = space between rows, horizontal = sides
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        //fillMaxWidth = color to fill space, padding for space around text
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = "Hello, " )
                Text(text = "$name!")
            }
            ElevatedButton(
                //onClick take a function not a value
                onClick = { expanded.value = !expanded.value }
            ) {
                Text( if( expanded.value ) "Show Less" else "Show More")
            }
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

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Welcome to the Basic Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 25.dp),
            onClick = { shouldShowOnboarding = false }
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview(){
    ComposeBasicsWorkshopTheme {
        OnboardingScreen()
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    Greetings()
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names : List<String> = listOf("World", "Compose")
) {
    Column( modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names ) {
            Greeting(name = name)
        }
    }
}

@Preview (showBackground = true, widthDp = 320)
@Composable
private fun GreetingsPreview(){
    ComposeBasicsWorkshopTheme {
        Greetings()
    }
}

@Preview
@Composable
fun MyAppPreview() {
    MyApp(Modifier.fillMaxSize())
}
