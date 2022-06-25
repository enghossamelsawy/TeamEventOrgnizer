package com.example.teameventorganiser.presentation.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.teameventorganiser.R
import com.example.teameventorganiser.core.data.Event
import com.skydoves.landscapist.glide.GlideImage


@Preview
@Composable
fun BarkHomeContent(navController: NavHostController) {
    ConstraintLayout {
        Column {
            SearchBar(
                "",
                ""
            )
            val events = remember {
                listOf(
                    Event("event1", "@3323", "sdssd", "https://picsum.photos/id/237/200/300"),
                    Event("event2", "@3323", "sdssd", "https://picsum.photos/seed/picsum/200/300"),
                    Event("event3 ", "@3323", "sdssd", "https://picsum.photos/200")
                )
            }

            LazyColumn(modifier = Modifier.fillMaxHeight()) {
                items(items = events, itemContent = { item ->
                    EventListItem(item, navController)
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


@Composable
 fun EventImage(event: Event) {
    GlideImage(
        imageModel = event.eventImage,
        // Crop, Fit, Inside, FillHeight, FillWidth, None
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}


@Preview
@Composable
fun EventListItem(item: Event, navController: NavHostController) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {
                navController.navigate(TeamEventScreen.Details.name)
            },
        elevation = 10.dp
    ) {


        Row {
            EventImage(item)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = item.eventName, style = typography.labelLarge)
                Text(text = item.address, style = typography.labelSmall)

            }
        }
    }
}


@Preview
@Composable
fun FloatingActionButtonDemo(modifier: Modifier, navController: NavHostController) {

    FloatingActionButton(onClick = {
        navController.navigate(NavRoutes.SignIn.route)
    }, modifier = modifier) {
        Icon(
            imageVector = Icons.Filled.Add,
            "",
            modifier = modifier
        )
    }
}


//@ExperimentalAnimationApi
//@ExperimentalComposeUiApi
@Composable
fun SearchBar(
    searchText: String,
    placeholderText: String = "",
    onSearchTextChanged: (String) -> Unit = {},
    onClearClick: () -> Unit = {},
    onNavigateBack: () -> Unit = {}
) {
    var showClearButton by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }



    TopAppBar(title = { Text("") }, navigationIcon = {
        IconButton(onClick = { onNavigateBack() }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                modifier = Modifier,
                contentDescription = stringResource(id = R.string.icn_search_back_content_description)
            )
        }
    }, actions = {

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp)
                .onFocusChanged { focusState ->
                    showClearButton = (focusState.isFocused)
                }
                .focusRequester(focusRequester),
            value = searchText,
            onValueChange = onSearchTextChanged,
            placeholder = {
                Text(text = placeholderText)
            },
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
            ),
            trailingIcon = {

                IconButton(onClick = { onClearClick() }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.icn_search_clear_content_description)
                    )
                }
//                AnimatedVisibility(
//                    visible = showClearButton,
//                    enter = fadeIn(),
//                    exit = fadeOut()
//                ) {
//                    IconButton(onClick = { onClearClick() }) {
//                        Icon(
//                            imageVector = Icons.Filled.Close,
//                            contentDescription = stringResource(id = R.string.icn_search_clear_content_description)
//                        )
//                    }
//
//                }
            },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = androidx.compose.ui.text.input.ImeAction.Companion.Done),

        )


    })


    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}
