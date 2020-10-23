package common

import android.content.Intent
import android.os.AsyncTask
import com.aathil.loginscreen.activities.LogInActivity
import com.aathil.loginscreen.activities.SignUpActivity

class AsyncTaskExample(private var activity: LogInActivity?) : AsyncTask<Void, Void, Void>() {


    override fun onPreExecute() {
        super.onPreExecute()
        activity?.progressDialog?.show()



    }

    override fun doInBackground(vararg unUsed: Void?): Void? {

        return null
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        var intent = Intent(activity, SignUpActivity::class.java)
        activity?.startActivity(intent)

        super.onPostExecute(result)
    }
}