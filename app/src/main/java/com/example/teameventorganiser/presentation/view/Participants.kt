package com.example.teameventorganiser.presentation.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.teameventorganiser.R
import com.example.teameventorganiser.core.data.Event
import com.example.teameventorganiser.core.data.ParticipateUser
import com.skydoves.landscapist.glide.GlideImage


@Preview
@Composable
fun Participate(navController: NavHostController) {
    ConstraintLayout {
        Column {
            val events = remember {
                listOf(
                    ParticipateUser("event1", "@3323", "sdssd", "https://picsum.photos/id/237/200/300"),
                    ParticipateUser("event2", "@3323", "sdssd", "https://picsum.photos/seed/picsum/200/300"),
                    ParticipateUser("event3 ", "@3323", "sdssd", "https://picsum.photos/200")
                )
            }

            LazyColumn(modifier = Modifier.fillMaxHeight()) {
                items(items = events, itemContent = { item ->
                    showParticipate(item)
                })

            }
        }
        val (floatingButton) = createRefs()
        val modifier = Modifier.constrainAs(floatingButton) {
            bottom.linkTo(parent.bottom, margin = 16.dp)
            end.linkTo(parent.end, margin = 16.dp)
        }

        FloatingActionButtonDemo(modifier, navController)
    }
}


@Preview
@Composable
fun showParticipate(participateUser: ParticipateUser) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {
//                navController.navigate(TeamEventScreen.Details.name)
            },
        elevation = 10.dp
    ) {


        Column {
            GlideImage(
                imageModel = R.drawable.ic_profile,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(84.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Participate One", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}