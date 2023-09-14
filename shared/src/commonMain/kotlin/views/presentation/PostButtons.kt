package views.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import event.TrendWaveEvent

/**
 * three buttons on home screen
 *
 * @param modifier -> Edits for HomeScreen
 * @param buttontext -> Text inside the button
 * @param onEvent -> EventHandling
 * @param event -> Type of event
 */
@Composable
fun PostButton(
    modifier: Modifier,
    buttontext: String,
    imageVector: ImageVector,
    onEvent: (TrendWaveEvent)-> Unit,
    event: TrendWaveEvent
) {
    Column(
        modifier = modifier
            .height(80.dp)
            .width(80.dp)
            .background(
                Color(230, 255, 255),
                RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp,
                    bottomEnd = 30.dp,
                    bottomStart = 30.dp
                )
            ).clickable {
                onEvent(event)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.height(21.dp))
        Icon(
            imageVector = imageVector,
            contentDescription = "",
            modifier = Modifier.scale(1.5f)
        )

        Text(
            text = buttontext,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.offset(y = 40.dp)
        )
    }
}
