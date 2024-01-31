package com.luluksofiyah.uas.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.luluksofiyah.uas.R

val Poppin = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Normal),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_extrabold, FontWeight.Medium),
    Font(R.font.poppins_medium, FontWeight.Bold),
    Font(R.font.poppins_regular, FontWeight.SemiBold),
    Font(R.font.poppins_semibold, FontWeight.ExtraBold),
)



val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = Poppin,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = Poppin,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = Poppin,
        fontWeight = FontWeight.Normal,
        fontSize = 19.sp,
    ),

    titleSmall = TextStyle(
        fontFamily = Poppin,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
    ),

    titleMedium = TextStyle(
        fontFamily = Poppin,
        fontWeight = FontWeight.Medium,
        fontSize = 17.sp,
    ),

    titleLarge = TextStyle(
        fontFamily = Poppin,
        fontWeight = FontWeight.Medium,
        fontSize = 19.sp,
    ),
)