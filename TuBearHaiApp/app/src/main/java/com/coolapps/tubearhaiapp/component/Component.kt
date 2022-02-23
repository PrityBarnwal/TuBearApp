package com.coolapps.tubearhaiapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.coolapps.tubearhaiapp.model.BeerResponseItem
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun TuBeerHaiLogo(modifier: Modifier = Modifier) {
    Text(text = "Tu Beer Hai",
        modifier = modifier.padding(bottom = 6.dp),
        style = MaterialTheme.typography.h3,
        color = Color.Red.copy(alpha = 0.5f))
}


@Composable
fun BeerItem(beer: BeerResponseItem) {
    val beerResponseItem = beer.image_url
    val imageUrl = "https://images.punkapi.com/v2/${beerResponseItem}.png"

    Card(
        modifier = Modifier
            .clickable { }
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface() {
                Row(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {
                        BeerImage(imageUrl= imageUrl)
                    }
                }
            }
        }

@Composable
fun BeerImage(imageUrl: String) {
    Image(painter = rememberImagePainter(imageUrl), contentDescription = "icon image",
    modifier = Modifier.size(80.dp))

}
