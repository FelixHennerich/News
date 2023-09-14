package views

import account.image.ImageDataSource
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FeatherIcons
import compose.icons.TablerIcons
import compose.icons.feathericons.User
import compose.icons.tablericons.Bookmark
import compose.icons.tablericons.Message
import compose.icons.tablericons.Settings
import event.TrendWaveEvent
import event.TrendWaveState
import managers.DataStorageManager
import post.Post
import post.presentation.PostDisplay
import views.presentation.PostButton
import views.sheet.SettingsSheet
import post.presentation.addPostSheet

class HomeScreen {

    /**
     * HOME SCREEN Screen after login or register
     *
     * @param onEvent -> EventHandling in Viewmodel
     * @param state -> StateManager for PostAddSheet
     * @param localDataSource -> Get local data system
     * @param imageDataSource -> Get Image data system
     */
    @Composable
    fun HomeScreen(
        onEvent: (TrendWaveEvent) -> Unit,
        state: TrendWaveState,
        localDataSource: DataStorageManager,
        imageDataSource: ImageDataSource
    ) {
        state.posts += Post("uuid here", "username","01.04.2012", "This is a post texth hallo was geht lol w nur ich braichhe hier mehr worte bla bla la")
        state.posts += Post("uuid here", "username","01.04.2012", "This is a pos312t text")
        state.posts += Post("uuid here", "username","01.04.2012", "This is a po3231st text")
        state.posts += Post("uuid here", "username","01.04.2012", "6 is a 44post text")
        state.posts += Post("uuid here", "username","01.04.2012", "6 is a post text")
        state.posts += Post("uuid here", "username","01.04.2012", "This7 is a pos8t text")

        Scaffold(
            Modifier.offset(y = 25.dp)
        ) {
            LazyColumn {
                item {
                    Row(
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth()
                            .background(Color(230, 255, 255)),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Hello, ",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 15.dp, start = 25.dp)
                        )
                        Text(
                            text = "${localDataSource.readString("username")}",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 15.dp, end = 190.dp)
                        )
                        IconButton(
                            onClick = { onEvent(TrendWaveEvent.ClickSettingsScreen) },
                            modifier = Modifier.padding(15.dp)
                        ) {
                            Icon(
                                imageVector = TablerIcons.Settings,
                                contentDescription = "",
                                modifier = Modifier
                                    .scale(1.5f)

                            )
                        }
                    }
                    Row(
                        modifier = Modifier.offset(y = 30.dp, x = 35.dp),
                        horizontalArrangement = Arrangement.spacedBy(40.dp)
                    ) {
                        PostButton(
                            modifier = Modifier,
                            buttontext = "Post",
                            imageVector = TablerIcons.Message,
                            onEvent = onEvent,
                            event = TrendWaveEvent.ClickPostButton
                        )
                        PostButton(
                            modifier = Modifier,
                            buttontext = "Saved",
                            imageVector = TablerIcons.Bookmark,
                            onEvent = onEvent,
                            event = TrendWaveEvent.TestHomeButton
                        )
                        PostButton(
                            modifier = Modifier,
                            buttontext = "Profile",
                            imageVector = FeatherIcons.User,
                            onEvent = onEvent,
                            event = TrendWaveEvent.TestHomeButton
                        )
                    }

                    Text(
                        text = "Recent activity",
                        modifier = Modifier.offset(x = 20.dp, y= 90.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                item {
                    Spacer(Modifier.height(100.dp))
                }
                items(state.posts) { post ->
                    PostDisplay(
                        modifier = Modifier,
                        posttext = post.text,
                        postuser = post.username,
                        postdate = post.date,
                        topEnd = 10.dp,
                        topStart = 10.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp
                    )
                    Spacer(Modifier.height(6.dp))
                }
                item{
                    Spacer(Modifier.height(100.dp))
                }
            }
        }
        addPostSheet(
            isOpen = state.isAddPostSheetOpen,
            onEvent = onEvent
        )
        SettingsSheet(
            isOpen = state.isSettingsSheetOpen,
            imageDataSource = imageDataSource,
            localDataSource = localDataSource,
            onEvent = onEvent
        )
    }

}