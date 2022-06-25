package com.example.teameventorganiser.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.NavHostController

class LoginFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        return ComposeView(requireContext()).apply {
            setContent {
                LoginPage()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun LoginPage() {

        var username by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }


        Box(modifier = Modifier.fillMaxSize()) {
            ClickableText(
                text = AnnotatedString("Forgot your password...?"),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp),
                onClick = { },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default,
                    textDecoration = TextDecoration.Underline
                )
            )
        }
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(200.dp))


            Text(text = "Login", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive))

            Spacer(modifier = Modifier.height(20.dp))

            // TextField
            OutlinedTextField(
                value = username,
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = "Email address") },
                placeholder = { Text(text = "Your email") },
                onValueChange = {
                    username = it
                }
            )


            Spacer(modifier = Modifier.height(20.dp))

            // TextField

            OutlinedTextField(
                value = password,
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = "Password") },
                placeholder = { Text(text = "Your password") },
                onValueChange = {
                    password = it
                }
            )

            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {

                Row(Modifier.fillMaxSize()) {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .weight(1.0f)
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Login")
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .weight(1.0f)
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Register")
                    }
                }
            }
        }


        Spacer(modifier = Modifier.height(20.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun LoginPage(navController: NavHostController) {

    var username by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }


    Box(modifier = Modifier.fillMaxSize()) {
        ClickableText(
            text = AnnotatedString("Forgot your password...?"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = { },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline
            )
        )
    }
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(200.dp))


        Text(text = "Login", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive))

        Spacer(modifier = Modifier.height(20.dp))

        // TextField
        OutlinedTextField(
            value = username,
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Email address") },
            placeholder = { Text(text = "Your email") },
            onValueChange = {
                username = it
            }
        )


        Spacer(modifier = Modifier.height(20.dp))

        // TextField

        OutlinedTextField(
            value = password,
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Your password") },
            onValueChange = {
                password = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {

            Row(Modifier.fillMaxSize()) {
                Button(
                    onClick = { },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .weight(1.0f)
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Login")
                }

                Spacer(modifier = Modifier.width(20.dp))

                Button(
                    onClick = {


                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .weight(1.0f)
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Register")
                }
            }
        }
    }


    Spacer(modifier = Modifier.height(20.dp))
}

