package com.example.listapp

import android.R
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listapp.model.data.Destination
import com.example.listapp.model.destinations
import com.example.listapp.ui.theme.ListAppTheme

@Composable
fun DestinationCard(destination: Destination, onClick: () -> Unit,) {
    Card(
        modifier = Modifier
            // The space between each card and the other
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight().clickable { onClick() },
        shape = MaterialTheme.shapes.medium,
        elevation = 2.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = destination.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp, 100.dp),
                contentScale = ContentScale.Fit,
            )
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = destination.name,
                    style = MaterialTheme.typography.h2,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.onSurface,
                )
                Text(
                    text = destination.summary,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Left,
                    maxLines = 1,
                )
            }
        }
    }
}
//
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
//@Composable
//fun PlanetCardPreview() {
//    ListAppTheme {
//        DestinationCard(destinations[0])
//    }
//}
//
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
//@Composable
//fun PlanetCard1Preview() {
//    ListAppTheme {
//        DestinationCard(destinations[1])
//    }
//}