package `in`.introduc.mobile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BasicText("User Name: John Doe")
        Spacer(modifier = Modifier.height(8.dp))
        BasicText("Email: john.doe@example.com")
        Spacer(modifier = Modifier.height(8.dp))
        BasicText("Phone: +1234567890")
    }
}
