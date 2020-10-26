package validations

import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_sign_up.*
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

fun validEmail(email: String) : Pair<String, Boolean>{
    var msg = ""
    var emailBool = false

    if(email.isEmpty()){
        if(!email.isEmailValid()){
            msg = "Please Insert Valid email"

        }
            else{
            emailBool = true
            }
    }else{
        msg = "Email Should not be empty"
    }

    return Pair(msg, emailBool)
}

fun validName(name: String) : Pair<String, Boolean>{
    var msg = ""
    var nameBool = false

    if(name.isEmpty()){
        if(!name.isNamevalid()){
            msg = "Please Insert Valid User Name"

        }
        else{
            nameBool = true
        }
    }else{
        msg = "User Name Should not be empty"
    }

    return Pair(msg, nameBool)
}

fun validPass(password: String) : Pair<String, Boolean>{
    var msg = ""
    var passBool = false

    if(password.isEmpty()){
        if(!password.isPassWordValid()){
            msg = "Password should be 5-20 length and should start with alphabets"

        }
        else{
            passBool = true
        }
    }else{
        msg = "Password should be 5-20 length and should start with alphabets"
    }

    return Pair(msg, passBool)
}

fun validPass2(password: String) : Pair<String, Boolean>{
    var msg = ""
    var pass2Bool = false

    if(!password.isEmpty()){
        msg = "Re-enter the password please"
    }else{
        pass2Bool = true
    }

    return Pair(msg, pass2Bool)
}