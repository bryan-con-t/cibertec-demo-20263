package pe.cibertec.demo.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import pe.cibertec.demo.R

val Quicksand = FontFamily(
    Font(
        resId = R.font.quicksand_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.quicksand_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.quicksand_light,
        weight = FontWeight.Light
    ),
    Font(
        resId = R.font.quicksand_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resId = R.font.quicksand_semibold,
        weight = FontWeight.SemiBold
    ),
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Quicksand,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)