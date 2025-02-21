package com.example.scaffold.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.scaffold.Model.BottomBarNavigation
import com.example.scaffold.R



val items= listOf(
    BottomBarNavigation(
        icon = Icons.Outlined.Home,
        title = "Home"
    ),
    BottomBarNavigation(
        icon = Icons.Outlined.Favorite,
        title = "Favorite"
    ),
    BottomBarNavigation(
        icon = Icons.Outlined.ShoppingCart,
        title = "Cart"
    )
)


@Composable
fun bottomNavigation(){
    var selectedIndex by remember { mutableStateOf(0) }
    Surface(
        color = colorResource(id = R.color.grey),
        modifier = Modifier.fillMaxWidth().height(80.dp)
    ) {
        NavigationBar(
            containerColor = Color.Transparent,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedIndex==index,
                    onClick = {
                        selectedIndex=index
                    },
                    label = { Text(text = item.title, color = MaterialTheme.colorScheme.onPrimary)},
                    icon = { Icon(imageVector = item.icon, contentDescription =item.title, tint =MaterialTheme.colorScheme.onBackground) })
            }
        }
    }
}