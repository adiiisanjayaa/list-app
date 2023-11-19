package com.example.listapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.listapp.model.data.Destination
import com.example.listapp.model.destinations
import com.example.listapp.ui.theme.ListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ListAppTheme {
                window.statusBarColor = MaterialTheme.colors.primary.toArgb()
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp (){
    val navController = rememberNavController()
    val detailArgs = listOf(navArgument("destinationID") { type = NavType.IntType })

    NavHost(navController = navController, startDestination = "home") {
        // add all destinations here
        composable(route = "home") { HomeScreen(listDestination = destinations, navController = navController) } // home destination
        composable(route = "detail/{destinationID}", arguments = detailArgs) { backStackEntry ->
            //extract the arguments from backStackEntry
            val destinationID = backStackEntry.arguments?.getInt("destinationID");
            DetailScreen(destinationID, navController) } // profile destination
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListAppTheme {
        Greeting("Android")
    }
}