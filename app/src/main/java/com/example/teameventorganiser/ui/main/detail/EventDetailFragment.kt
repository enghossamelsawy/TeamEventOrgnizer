package com.example.teameventorganiser.ui.main.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavHostController
import com.example.teameventorganiser.R
import com.example.teameventorganiser.core.data.Event
import com.example.teameventorganiser.presentation.view.NavRoutes
import com.example.teameventorganiser.presentation.view.TeamEventScreen
import com.example.teameventorganiser.presentation.viewmodel.EventDetailViewModel
import com.skydoves.landscapist.glide.GlideImage

class EventDetailFragment : Fragment() {

    private val viewModel: EventDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                composablePreview()
            }
        }
    }

    @Preview
    @Composable
    fun composablePreview() {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Event picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Title", color = Color.Blue, modifier = Modifier.size(17.dp))

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", color = Color.Blue, modifier = Modifier.size(15.dp))

            Spacer(modifier = Modifier.height(32.dp))
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                onClick = { viewModel.onJoinClicked() },
            ) {
                Text(text = "Join")
            }

            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                onClick = { viewModel.onViewParticipantsClicked() },
            ) {
                Text(text = "View Participants")
            }
        }
    }

    companion object {
        fun newInstance() = EventDetailFragment()
    }
}


@Preview
@Composable
fun composablePreview(navController: NavHostController) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))


        GlideImage(
            imageModel = "https://picsum.photos/id/237/200/300",
            // Crop, Fit, Inside, FillHeight, FillWidth, None
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(84.dp)
                .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
        )
//        Image(
//            painter = painterResource(id = R.drawable.ic_launcher_foreground),
//            contentDescription = "Event picture",
//            modifier = Modifier
//                .size(40.dp)
//                .clip(CircleShape)
//        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Title", color = Color.Blue, style = TextStyle(fontSize = 18.sp))

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Event Details", color = Color.Blue, style = TextStyle(fontSize = 16.sp))

        Spacer(modifier = Modifier.height(32.dp))
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            onClick = {  },
        ) {
            Text(text = "Join")
        }

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            onClick = {
                navController.navigate(TeamEventScreen.Participate.name)
            },
        ) {
            Text(text = "View Participants")
        }
    }
}

