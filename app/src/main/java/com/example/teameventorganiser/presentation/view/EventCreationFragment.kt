package com.example.teameventorganiser.presentation.view

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { text = stringResource(R.string.creation_event_fragment_event_title) }
        )
    }


}