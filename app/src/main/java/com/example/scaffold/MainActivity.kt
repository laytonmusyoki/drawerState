package com.example.scaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.scaffold.View.bottomNavigation
import com.example.scaffold.ui.theme.ScaffoldTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScaffoldTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = { DrawerContent { scope.launch { drawerState.close() } } } // Close drawer on item click
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            TopAppBar(
                                title = { Text(text = "Search here...") },
                                colors = TopAppBarDefaults.topAppBarColors(containerColor = colorResource(id = R.color.grey)),
                                navigationIcon = {
                                    IconButton(
                                        modifier = Modifier.padding(start = 10.dp, end = 20.dp),
                                        onClick = { scope.launch { drawerState.open() } }
                                    ) {
                                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                                    }
                                },
                                actions = {
                                    Icon(
                                        modifier = Modifier.padding(end = 10.dp),
                                        imageVector = Icons.Outlined.Notifications,
                                        contentDescription = "Notifications"
                                    )
                                    Icon(
                                        imageVector = Icons.Outlined.MoreVert,
                                        modifier = Modifier.padding(end = 10.dp),
                                        contentDescription = "More Options"
                                    )
                                }
                            )
                        },
                        bottomBar = {
                            BottomAppBar {
                                bottomNavigation()
                            }
                        }
                    ) { innerPadding ->
                        // Your main screen content
                        Box(modifier = Modifier.padding(innerPadding)) {
                            Text(text = "Main Content Goes Here")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DrawerContent(onItemClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxHeight().width(300.dp).background(Color.Cyan)) {
        Text("Navigation", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Home",
            modifier = Modifier.padding(12.dp).clickable { onItemClick() }
        )
        Text(
            text = "Settings",
            modifier = Modifier.padding(12.dp).clickable { onItemClick() }
        )
    }
}
