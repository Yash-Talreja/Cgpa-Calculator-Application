package com.example.cgpacalculatorapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cgpacalculatorapp.ui.theme.CgpaCalculatorAppTheme
import com.example.cgpacalculatorapp.ui.theme.Semester

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    private var semesters: MutableList<Semester> = mutableListOf()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CgpaCalculatorAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Cgpa(semesters)
                }
            }
        }
    }
}




@Composable
fun Cgpa(semesters:MutableList<Semester>) {
    var grade1 by remember { mutableStateOf("") }
    var credit1 by remember { mutableStateOf<Int?>(null) }
    var grade2 by remember { mutableStateOf("") }
    var credit2 by remember { mutableStateOf<Int?>(null) }
    var grade3 by remember { mutableStateOf("") }
    var credit3 by remember { mutableStateOf<Int?>(null) }
    var grade4 by remember { mutableStateOf("") }
    var credit4 by remember { mutableStateOf<Int?>(null) }
    var grade5 by remember { mutableStateOf("") }
    var credit5 by remember { mutableStateOf<Int?>(null) }
    var grade6 by remember { mutableStateOf("") }
    var credit6 by remember { mutableStateOf<Int?>(null) }
    var grade7 by remember { mutableStateOf("") }
    var credit7 by remember { mutableStateOf<Int?>(null) }
    var grade8 by remember { mutableStateOf("") }
    var credit8 by remember { mutableStateOf<Int?>(null) }
    var cgpa by remember { mutableStateOf(0.0) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Welcome To CGPA Calculator App\nAll The Best For The Future",
            modifier = Modifier
                .fillMaxWidth()
                .padding(35.dp),
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        SubjectText(subject = "Subject 1")
        Space()

        GradeTextField(grade = grade1, onValueChange = { grade1 = it })
        Space()
        CreditTextField(credit = credit1, onValueChange = { credit1 = it })
        Space()

        SubjectText(subject = "Subject 2")
        Space()

        GradeTextField(grade = grade2, onValueChange = { grade2 = it })
        Space()
        CreditTextField(credit = credit2, onValueChange = { credit2 = it })
        Space()
        SubjectText(subject = "Subject 3")
        Space()

        GradeTextField(grade = grade3, onValueChange = { grade3 = it })
        Space()
        CreditTextField(credit = credit3, onValueChange = { credit3 = it })
        Space()

        SubjectText(subject = "Subject 4")
        Space()
        GradeTextField(grade = grade4, onValueChange = { grade4 = it })
        Space()
        CreditTextField(credit = credit4, onValueChange = { credit4 = it })
        Space()

        SubjectText(subject = "Subject 5")
        Space()
        GradeTextField(grade = grade5, onValueChange = { grade5 = it })
        Space()
        CreditTextField(credit = credit5, onValueChange = { credit5 = it })
        Space()

        SubjectText(subject = "Subject 6")
        Space()
        GradeTextField(grade = grade6, onValueChange = { grade6 = it })
        Space()
        CreditTextField(credit = credit6, onValueChange = { credit6 = it })
        Space()

        SubjectText(subject = "Subject 7")
        Space()
        GradeTextField(grade = grade7, onValueChange = { grade7 = it })
        Space()
        CreditTextField(credit = credit7, onValueChange = { credit7 = it })
        Space()

        SubjectText(subject = "Subject 8")
        Space()
        GradeTextField(grade = grade8, onValueChange = { grade8 = it })
        Space()
        CreditTextField(credit = credit8, onValueChange = { credit8 = it })
        Space()

        // Add additional subjects here as needed

        Row {
            Column {
                Button(
                    onClick = {val Semester=Semester(grade1,credit1 ?:0)

                        semesters.add(Semester)

                        val totalcredit=semesters.sumOf { it.credit }
                        val totalgrade=semesters.sumOf { calculateGradePoint(it.grade,it.credit)  }

                        if (totalcredit>0){
                            cgpa=totalgrade/totalcredit.toDouble()
                        }else{
                            cgpa=0.0
                        }

                        grade1=""
                        credit1=null
                        grade2=""
                        credit2=null
                        grade3=""
                        credit3=null
                        grade4=""
                        credit4=null
                        grade5=""
                        credit5=null
                        grade6=""
                        credit6=null
                        grade7=""
                        credit7=null
                        grade8=""
                        credit8=null




                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFF006400)),
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(
                        text = "Calculate CGPA",
                        fontSize = 18.sp,
                        color = Color.Green
                    )
                }

                Surface(
                    modifier = Modifier
                        .width(180.dp)
                        .wrapContentHeight(),
                    color = Color.Black,
                    shape = RoundedCornerShape(40.dp)
                ) {
                    Text(
                        text = "Your All Time \nCGPA: $cgpa",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(20.dp)
                            .padding(start = 10.dp),
                        color = Color.White,
                    )
                }
            }

            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                color = Color.Black,
                shape = RoundedCornerShape(40.dp)
            ) {
                Column {
                    Text(
                        text = "Previous Semester",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(48.dp)
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        color = Color.White,
                    )

                    if (semesters.isNotEmpty()){

                        for (semester in semesters)

                            Text(
                                text = "Grade:${semester.grade}      Credit:${semester.credit}",
                                color = Color.White,
                                modifier = Modifier
                                    .padding(start = 28.dp)
                                    .padding(top = 10.dp),
                                fontSize = 25.sp)
                    }


                }
            }
        }
    }
}

fun calculateGradePoint(grade: String, credit: Int):Double {

   return when(grade.uppercase()){
        "o"->10.0
        "A+"->9.0
        "A"->8.0
        "B+"->7.0
        "B"->6.0
        "C"->5.0
        "P"->4.0
        "F"->0.0
        "Ab"->0.0
       else->0.0
    } *credit
}

@Composable
fun Space() {
    Spacer(modifier = Modifier.height(8.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GradeTextField(grade: String, onValueChange: (String) -> Unit) {
    TextField(
        value = grade,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        label = {
            Text(text = "Enter Grade", color = Color.Black, fontWeight = FontWeight.ExtraBold)
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color.Magenta
        ),
        shape = RoundedCornerShape(20.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditTextField(credit: Int?, onValueChange: (Int?) -> Unit) {
    TextField(
        value = credit?.toString() ?: "",
        onValueChange = { text ->
            onValueChange(text.toIntOrNull())
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        label = {
            Text(text = "Enter Credit", color = Color.Black, fontWeight = FontWeight.ExtraBold)
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color.Cyan
        ),
        shape = RoundedCornerShape(20.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun SubjectText(subject: String) {
    Text(
        text = subject,
        color = Color.Yellow,
        fontSize = 22.sp,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier.fillMaxWidth()
    )
}
