package info.gezielcarvalho.quadropesquisa;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

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
            String searchid = jsonResponse.getString("id");
            String searchtitle = jsonResponse.getString("title");
            String searchcompleted = jsonResponse.getString("completed");

            txtid.setText(searchid);
            txtTitle.setText(searchtitle);
            txtCompleted.setText(searchcompleted);

        }
        catch(JSONException e){
            this.txtTitle.setText("erroJSON");

        }
    }
}

