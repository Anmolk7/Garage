package com.example.anmol.garage.m_MySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Anmol on 2/10/2017.
 */
public class DataParser extends AsyncTask<Void,Void,Boolean> {
Context c;
    String jsonData;
    ListView lv;
     ProgressDialog pd;
    ArrayList<String> spacecraft=new ArrayList<>();

    public DataParser(Context c, String urlAddress, ListView lv )
    {
        this.c=c;
        this.jsonData=jsonData;
        this.lv=lv;
    }
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Retrieve");
        pd.setMessage("Retriving...please wait");
        pd.show();


    }
    @Override
    protected Boolean doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }

    private Boolean parseData()
    {
        try
        {
            JSONArray ja= new JSONArray(jsonData);
            JSONObject jo;
            spacecraft.clear();
            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                String name=jo.getString("name");
                spacecraft.add(name);

            }
            return  true;
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return  false;

    }
}
