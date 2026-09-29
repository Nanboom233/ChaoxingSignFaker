package org.aquamarine5.brainspark.chaoxingsignfaker.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.aquamarine5.brainspark.chaoxingsignfaker.R
import org.aquamarine5.brainspark.chaoxingsignfaker.utilities.ChaoxingAnalyser

@Composable
fun AnalyserCard() {
    val context = LocalContext.current
    val analyser = rememberSaveable(saver = ChaoxingAnalyser.MutableStateAnalyser.Saver) {
        ChaoxingAnalyser.createStateAnalyser()
    }
    LaunchedEffect(Unit) {
        ChaoxingAnalyser.setupStateAnalyser(context)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(painterResource(R.drawable.ic_chart_column), contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("本地使用次数统计", fontSize = 17.sp)
            }
            if (analyser.isLoaded.value) {
                Spacer(modifier = Modifier.padding(top = 8.dp))
                Text(
                    "拍照 ${analyser.photoSignCount.value}  位置 ${analyser.locationSignCount.value}  " +
                        "二维码 ${analyser.qrcodeSignCount.value}  点击 ${analyser.clickSignCount.value}"
                )
                Text(
                    "手势 ${analyser.gestureSignCount.value}  签到码 ${analyser.passwordSignCount.value}  " +
                        "代签 ${analyser.otherUserSignCount.value}"
                )
            }
        }
    }
}
