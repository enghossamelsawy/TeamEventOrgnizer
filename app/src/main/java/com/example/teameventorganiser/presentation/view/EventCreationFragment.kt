package com.example.teameventorganiser.presentation.view

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teameventorganiser.R

class EventCreationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        return ComposeView(requireContext()).apply {
            setContent {
                MainContent()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainContent() {
        getEventTitle()
    }

    @Composable
    fun getEventTitle() {
        var text by remember { mutableStateOf("") }

        // title
        OutlinedTextField(
            value = text,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = resources.getString(R.string.creation_event_fragment_event_title)) },
            onValueChange = {
                text = it
            }
        )

        // description
        OutlinedTextField(
            value = text,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(200.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = resources.getString(R.string.creation_event_fragment_event_description)) },
            onValueChange = {
                text = it
            }
        )




    }


}