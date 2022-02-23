package com.coolapps.tubearhaiapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.coolapps.tubearhaiapp.model.BeerResponse
import com.coolapps.tubearhaiapp.model.BeerResponseItem
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.coolapps.tubearhaiapp.component.*
import kotlinx.coroutines.flow.Flow
import androidx.paging.compose.itemsIndexed
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun MainScreen(mainViewModel: MainScreenViewModel, navController: NavHostController){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            TuBeerHaiLogo()
        }
        BeerRow(beers = mainViewModel.beers)
    }
}

@Composable
fun BeerRow(beers: Flow<PagingData<BeerResponse<BeerResponseItem>>>) {
    val lazyPagingItems = beers.collectAsLazyPagingItems()



    LazyColumn {
      //  val beer: BeerResponseItem
      //  val imageUrl = "https://images.punkapi.com/v2/${beer.image_url}.png"

            if (lazyPagingItems.loadState.refresh == LoadState.Loading) {
                item {
                  /*
                    Card( modifier = Modifier
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

                   */
                    Text(
                        text = "Waiting for items to load from the backend",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                    
                    
                }
            }

            itemsIndexed(lazyPagingItems) { index, item ->
                Text("Index=$index: $item", fontSize = 20.sp)
            }

            if (lazyPagingItems.loadState.append == LoadState.Loading) {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }

