package com.example.homework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape // <-- Импорт для скругления углов
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Human(
    val name: String,
    val job: String,
    val projects: Int,
    val tasks: Int,
    val exp: Int,
)

class Buttons(
    val kname: String,
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val alim = Human("Abdulalim Usmanov", "KKC student", 2, 3, 0)
            val arthur = Human("Artur Kim", "photographer", 4, 5, 67)
            val sergei = Human("Sergey Aplatchikov", "jobless", 0, 0, 0)
            val knopka = Buttons("Message")
            val knopkatwo = Buttons("Subscribe")
            val knpoki = listOf(knopka, knopkatwo)
            val objects = listOf(alim, arthur, sergei)
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                objects.forEach { human ->
                    Box(
                        modifier = Modifier
                            .background(Color.Magenta, shape = RoundedCornerShape(12.dp))
                            .fillMaxWidth()
                            .padding(all = 8.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .background(Color.White, shape = CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = human.name.take(1),
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                Column {
                                    Text(
                                        text = human.name,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp
                                    )
                                    Text(
                                        text = human.job,
                                        fontSize = 12.sp,
                                        color = Color.DarkGray
                                    )
                                }
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                                        .padding(8.dp),
                                    contentAlignment = Alignment.Center
                                ){
                                    Text(
                                        text = "Projects: ${human.projects}",
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .background(Color.Yellow, shape = RoundedCornerShape(8.dp))
                                        .padding(8.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Tasks: ${human.tasks}",
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .background(Color.Red, shape = RoundedCornerShape(8.dp))
                                        .padding(8.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Exp: ${human.exp}",
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                knpoki.forEach { kn ->
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .background(Color.Blue, shape = RoundedCornerShape(8.dp))
                                            .padding(8.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = kn.kname,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}