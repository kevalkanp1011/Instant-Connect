package dev.kevalkanpariya.webrtcvideocalll.ui.presentations.call

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.webrtcvideocalll.R
import dev.kevalkanpariya.webrtcvideocalll.event.UiEvent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ReceiveCallLayout(
    //scaffoldState: ScaffoldState,
    viewModel: CallViewModel
) {

    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                /*is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.uiText.asString(context)
                    )
                }*/
                is UiEvent.Navigate -> {
                    //onNavigate(event.route)
                }
                else -> Unit
            }
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(text = "Someone is calling you..")

        Row {
            Icon(
                painter = painterResource(id = R.drawable.baseline_call_24),
                contentDescription = "receive call",
                tint = Color.Green,
                modifier = Modifier
                    .clip(
                        CircleShape
                    )
                    .background(Color.White)
                    .padding(10.dp)
                    .clickable {

                    }
            )
            Spacer(modifier = Modifier.width(20.dp))
            Icon(
                painter = painterResource(id = R.drawable.baseline_call_end_24),
                contentDescription = "receive call",
                tint = Color.Red,
                modifier = Modifier
                    .clip(
                        CircleShape
                    )
                    .background(Color.White)
                    .padding(10.dp)
                    .clickable {

                    }
            )
        }

    }
}

@Preview
@Composable
fun CallScreen() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Name",)
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_call_24),
                        contentDescription = "receive call",
                        tint = Color.Green,
                        modifier = Modifier
                            .clip(
                                CircleShape
                            )
                            .background(Color.White)
                            .padding(10.dp)
                    )

                }
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Name",)
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_call_24),
                        contentDescription = "receive call",
                        tint = Color.Green,
                        modifier = Modifier
                            .clip(
                                CircleShape
                            )
                            .background(Color.White)
                            .padding(10.dp)
                    )

                }
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Name",)
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_call_24),
                        contentDescription = "receive call",
                        tint = Color.Green,
                        modifier = Modifier
                            .clip(
                                CircleShape
                            )
                            .background(Color.White)
                            .padding(10.dp)
                    )

                }
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Name",)
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_call_24),
                        contentDescription = "receive call",
                        tint = Color.Green,
                        modifier = Modifier
                            .clip(
                                CircleShape
                            )
                            .background(Color.White)
                            .padding(10.dp)
                    )

                }
            }
        }

    }
}