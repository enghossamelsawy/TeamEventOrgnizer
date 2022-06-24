package com.example.teameventorganiser.ui.main.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.teameventorganiser.R

@Composable
fun ComposableEventDetailScreen() {

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Event picture",
            modifier = Modifier.clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Title", color = Color.Blue)

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Event Details:" +
                    "\n" +
                    "To navigate to a composable destination in the navigation graph, you must use the navigate() method. navigate() takes a single String parameter that represents the destination’s route. To navigate from a composable within the navigation graph, call navigate():",
            color = Color.Blue
        )

        Spacer(modifier = Modifier.height(32.dp))
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*viewModel.onJoinClicked()*/ },
        ) {
            Text(text = "Join")
        }

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*viewModel.onViewParticipantsClicked()*/ },
        ) {
            Text(text = "View Participants")
        }
    }
}