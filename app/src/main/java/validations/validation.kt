package validations

import android.text.TextUtils
import java.util.regex.Pattern

fun String.isEmailValid(): Boolean {
    val expression = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}


fun String.isPassWordValid(): Boolean {
    val expression = "^(?=.{5,20}$)(?![_.0-9\\p{Punct}])(?!.*[_.]{2})[a-zA-Z0-9._\\p{Punct}]+(?<![_.])$"

    //val expression = "/^(?=.*\\d)(?=.*[A-Z])([@\$%&#])[0-9a-zA-Z]{4,}$/"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}
fun String.isNamevalid(): Boolean {
    val expression = "^(?=.{3,10}$)(?![_.0-9])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}

fun String.isEmpty() =
    !TextUtils.isEmpty(this)