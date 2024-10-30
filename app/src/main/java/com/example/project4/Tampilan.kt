package com.example.project4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier

@Preview (showBackground = true)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
){
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var selectGender by remember { mutableStateOf("") }

    val jenisKelamin = listOf("Pria","Perempuan")

    var confirmNama by remember { mutableStateOf("") }
    var confirmEmail by remember { mutableStateOf("") }
    var confirmAlamat by remember { mutableStateOf("") }
    var confirmNoHp by remember { mutableStateOf("") }
    var confirmSelectGender by remember { mutableStateOf("") }

    val confirmJenisKelamin = listOf("Pria","Perempuan")

    Column(modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        OutlinedTextField(value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Masukan Nama") },
            label = { Text("Nama") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            jenisKelamin.forEach{ item ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = selectGender == item,
                        onClick = {
                            selectGender =item
                        }
                    )
                    Text(item)
                }

            }
        }
        OutlinedTextField(value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukan Email") },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(5.dp))
        OutlinedTextField(value = alamat, onValueChange = {alamat = it},
            placeholder = { Text("Masukan Alamat")
            },
            label = { Text("Alamat") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = noHp, onValueChange = {noHp = it},
            placeholder = { Text("Masukan No Hp") },
            label = { Text("No HP") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth())

        Button(onClick = {
            confirmNama = nama
            confirmSelectGender = selectGender
            confirmEmail = email
            confirmAlamat = alamat
            confirmNoHp = noHp

        }){
            Text("Submit")
        }

        Card(modifier.size(height = 250.dp, width = 300.dp)) {
            CardSection(JudulParam = "Nama", IsiParam = confirmNama)
            CardSection(JudulParam = "Jenis Kelamin", IsiParam = confirmSelectGender)
            CardSection(JudulParam = "Email", IsiParam = confirmEmail)
            CardSection(JudulParam = "Alamat", IsiParam = confirmAlamat)
            CardSection(JudulParam = "No HP", IsiParam = confirmNoHp)
        }
    }
}

@Composable
fun CardSection(JudulParam: String, IsiParam: String){
    Column (horizontalAlignment = Alignment.Start){
        Row (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = JudulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = "$IsiParam", modifier = Modifier.weight(2f))
        }
    }
}

