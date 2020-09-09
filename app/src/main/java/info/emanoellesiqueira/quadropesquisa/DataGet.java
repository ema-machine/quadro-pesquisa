package info.emanoellesiqueira.quadropesquisa;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class DataGet extends AsyncTask<String,Void,String> {

    private TextView txtid;
    private TextView txtTitle;
    private TextView txtCompleted;

    public DataGet(TextView txtid, TextView txtTitle, TextView txtCompleted) {
        this.txtid = txtid;
        this.txtTitle = txtTitle;
        this.txtCompleted = txtCompleted;

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {

        String url = strings[0];
        String result = NetworkToolkit.doGet(url);


        return result;
    }

    @Override
    protected void onPostExecute(String s) {

        try{
            JSONObject jsonResponse = new JSONObject(s);
            Log.i("vazio", String.valueOf(jsonResponse));
            String searchid = jsonResponse.getString("id");
            String searchtitle = jsonResponse.getString("title");
            String searchcompleted = jsonResponse.getString("completed");

            txtid.setText(searchid);
            txtTitle.setText(searchtitle);
            txtCompleted.setText(searchcompleted);

        }
        catch(JSONException e){
            this.txtid.setText("ID não encontrado!");

        }
    }
}

