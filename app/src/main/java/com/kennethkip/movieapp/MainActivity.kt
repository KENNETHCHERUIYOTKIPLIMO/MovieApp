package com.kennethkip.movieapp

import android.graphics.Color
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kennethkip.movieapp.ui.theme.MovieAppTheme
import com.kennethkip.movieapp.ui.theme.Purple40
import com.kennethkip.movieapp.ui.theme.PurpleGrey80

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val play = listOf(
                R.drawable.movie1,
                R.drawable.movie2,
                R.drawable.movie4,
                R.drawable.movie5,
                R.drawable.movie6,
                R.drawable.movie7,
                R.drawable.movie8
            )

            MovieAppTheme {
                Scaffold(
                    topBar = {
                        Column(
                            modifier = Modifier.padding(
                                horizontal = 16.dp,
                            ),
                        ) {
                            TopAppBar(

                                navigationIcon = {
                                    Icon(imageVector = Icons.Default.Menu, contentDescription =null)

                                },
                                actions = {
                                    Image(
                                        modifier = Modifier
                                            .size(40.dp)
                                            .clip(CircleShape),
                                        painter = painterResource(id = R.drawable.movie1),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                    )
                                },
                                title = {},
                            )
                            Spacer (modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Text(
                                    text = "Activity",
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.SemiBold,
                                )
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                                ) {
                                    var buttonTab by remember {
                                        mutableStateOf("Friends")
                                    }
                                    CircleTab(
                                        title = "Friends",
                                        clickTab = buttonTab,
                                        onClickTab = { title ->
                                            buttonTab = title
                                        },
                                    )
                                    CircleTab(
                                        title = "You",
                                        clickTab = buttonTab,
                                        onClickTab = { title ->
                                            buttonTab = title
                                        },
                                    )
                                }
                            }
                        }
                    },
                ) {
                    LazyColumn(
                        modifier = Modifier.padding(it),
                        contentPadding = PaddingValues(20.dp),
                        verticalArrangement = Arrangement.spacedBy(30.dp),
                    ) {
                        item {
                            MovieCollection(
                                circleContent = {
                                    Text(text = "G")
                                },
                                name = "Gregor",
                                time = "2 min",
                                type = "liked collection",
                                content = {


                                    Text(
                                        "The best of Robert Downey Jr",
                                        color = Black,
                                        fontWeight = FontWeight.SemiBold,
                                    )
                                },
                            )
                        }

                        item {
                            MovieCollection(
                                circleContent = {
                                    Text(text = "S")
                                },
                                name = "Stewart",
                                time = "1hr ",
                                type = "liked",
                                content = {
                                    Column {
                                        Spacer(modifier = Modifier.height(12.dp))
                                        LazyRow(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                                        ) {
                                            items(play) { movie ->
                                                Card(
                                                    modifier = Modifier
                                                        .width(100.dp)
                                                        .height(150.dp),
                                                ) {
                                                    Image(
                                                        modifier = Modifier.fillMaxSize(),
                                                        painter = painterResource(id = movie),
                                                        contentDescription = null,
                                                        contentScale = ContentScale.Crop,
                                                    )
                                                }
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Button(
                                            modifier = Modifier.fillMaxWidth(),
                                            onClick = { /*TODO*/ },
                                            shape = RoundedCornerShape(8.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Yellow,
                                                contentColor = androidx.compose.ui.graphics.Color.Gray,
                                            ),
                                        ) {
                                            Text(text = "2 more")
                                        }
                                    }
                                },
                            )
                        }

                        item {
                            MovieCollection(
                                backgroundColor = androidx.compose.ui.graphics.Color.Black,
                                circleContent = {
                                    Image(
                                        modifier = Modifier.size(24.dp),
                                        painter = painterResource(id = R.drawable.movie2),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                    )
                                },
                                name = "Netflix",
                                time = "1 hour",
                                type = "posted",
                                content = {
                                    Column {
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(
                                            text = "Watch the official trailer for",
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 16.sp,
                                        )
                                        Text(
                                            text = "The IrishMan",
                                            color = Black,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 16.sp,
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))

                                        /* Row {
                                            Image(
                                                modifier = Modifier
                                                    .height(200.dp)
                                                    .clip(RoundedCornerShape(12.dp)),
                                                painter = painterResource(id = R.drawable.movie3),
                                                contentDescription = null,
                                                contentScale = ContentScale.Crop,
                                            )


                                            Image(
                                                modifier = Modifier
                                                    .height(200.dp)
                                                    .clip(RoundedCornerShape(12.dp)),
                                                painter = painterResource(id = R.drawable.movie3),
                                                contentDescription = null,
                                                contentScale = ContentScale.Crop,
                                            )
                                        }

                                        */

                                        LazyRow(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalArrangement = Arrangement.spacedBy(20.dp),
                                                
                                            ) {
                                             

                                        items(play) {
                                               
                                            Image(
                                                modifier = Modifier
                                                    .height(200.dp).width(150.dp)


                                                    .clip(RoundedCornerShape(10.dp)),
                                                painter = painterResource(id = R.drawable.movie4),
                                                contentDescription = null,
                                                contentScale = ContentScale.Crop,
                                            )

                                            Spacer(modifier = Modifier.padding(20.dp))
                                            Image(
                                                modifier = Modifier
                                                    .height(200.dp)
                                                    .clip(RoundedCornerShape(10.dp)),
                                                painter = painterResource(id = R.drawable.movie5),
                                                contentDescription = null,
                                                contentScale = ContentScale.Crop,
                                            )
                                            Spacer(modifier = Modifier.padding(20.dp))
                                            Image(
                                                modifier = Modifier
                                                    .height(200.dp)
                                                    .clip(RoundedCornerShape(10.dp)),
                                                painter = painterResource(id = R.drawable.movie6),
                                                contentDescription = null,
                                                contentScale = ContentScale.Crop,
                                            )
                                            Spacer(modifier = Modifier.padding(20.dp))
                                            Image(
                                                modifier = Modifier
                                                    .height(200.dp)
                                                    .clip(RoundedCornerShape(10.dp)),
                                                painter = painterResource(id = R.drawable.movie7),
                                                contentDescription = null,
                                                contentScale = ContentScale.Crop,
                                            )
                                            Spacer(modifier = Modifier.padding(20.dp))
                                            Image(
                                                modifier = Modifier
                                                    .height(200.dp)
                                                    .clip(RoundedCornerShape(10.dp)),
                                                painter = painterResource(id = R.drawable.movie8),
                                                contentDescription = null,
                                                contentScale = ContentScale.Crop,
                                            )

                                        }
                                    }
                                    }
                                },
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun MovieCollection(
        name: String,
        time: String,
        type: String,
        content: @Composable () -> Unit = {},
        circleContent: @Composable () -> Unit,
        backgroundColor: androidx.compose.ui.graphics.Color = Yellow,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Circle(
                colorBackground = backgroundColor,
                collection = {
                    circleContent()
                },
            )
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = name,
                        fontWeight = FontWeight.SemiBold,
                    )
                    Text(
                        text = time,
                        color = androidx.compose.ui.graphics.Color.Gray,
                    )
                }
                Text(
                    type,
                    color = androidx.compose.ui.graphics.Color.Gray,
                )
                content()
            }
        }
    }
}

@Composable
fun CircleTab(
    clickTab: String,
    title: String,
    onClickTab: (title: String) -> Unit,
) {

    val button = clickTab == title
    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (button) {
                    Black
                } else {
                    Yellow
                },
            )
            .clickable {
                onClickTab(title)
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = title,
            color = if (button) {
                androidx.compose.ui.graphics.Color.White
            } else {
                androidx.compose.ui.graphics.Color.Black
            },
        )
    }
}

@Composable
fun Circle(
    collection: @Composable () -> Unit,
    colorBackground : androidx.compose.ui.graphics.Color,
) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(colorBackground),
        contentAlignment = Alignment.Center,
    ) {
        collection()
    }
}







