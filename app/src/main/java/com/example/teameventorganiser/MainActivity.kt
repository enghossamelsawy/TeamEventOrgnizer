package com.example.teameventorganiser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.teameventorganiser.presentation.theme.TeamEventOrganiserTheme
import com.example.teameventorganiser.presentation.view.BarkHomeContent
import com.example.teameventorganiser.presentation.view.LoginPage
import com.example.teameventorganiser.presentation.view.TeamEventScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeamEventOrganiserTheme {
                RallyApp()
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
            }
        }
    }


//    private fun findNavController(): NavController {
////        val navHostFragment =
////            fragmentManager.findFragmentById(R.id.nav_host_fragment) as
////        return navHostFragment.navController
//    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TeamEventOrganiserTheme {
        Greeting("Android")
    }
}


@Composable
fun RallyApp() {
    TeamEventOrganiserTheme {
        val allScreens = TeamEventScreen.values().toList()
        var currentScreen = rememberSaveable { mutableStateOf(TeamEventScreen.Home) }
        val navController = rememberNavController()


        NavHost(
            navController = navController,
            startDestination = TeamEventScreen.Home.name,
                    modifier = Modifier.padding(2.dp)
        ) {
            composable(TeamEventScreen.SignIn.name) {
                LoginPage(navController)
            }
            composable(TeamEventScreen.Home.name) {
//                Text(text = TeamEventScreen.Home.name)
                BarkHomeContent(navController)
            }
//            composable(TeamEventScreen.SignIn.name) {
//                Text(text = TeamEventScreen.SignIn.name)
//            }

            // TODO: Add the other two screens
        }
    }
}
