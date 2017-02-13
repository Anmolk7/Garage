package com.example.anmol.garage.m_MySQL;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.content.Context;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by Anmol on 2/10/2017.
 */
public class Downloader extends AsyncTask<Void,Void,String>
{
    Context c;
    String urlAddress;
    ListView lv;
    ProgressDialog pd;

   public Downloader(Context c, String urlAddress, ListView lv )
   {
       this.c=c;
       this.urlAddress=urlAddress;
       this.lv=lv;
   }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Retrieve");
        pd.setMessage("Retriving...please wait");
        pd.show();


    }

    @Override
    protected String doInBackground(Void... params) {
        return this.downloaderData();
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);
        pd.dismiss();
        if(jsonData.startsWith("Error"))
        {
            Toast.makeText(c,"Unsuccessful"+jsonData,Toast.LENGTH_SHORT).show();
        }
        else
        {
            //PARSE
        }
    }

private String downloaderData()
{
    Object connection=Connector.connect(urlAddress);
    if(connection.toString().startsWith("Error"))
    {
        return connection.toString();
    }

    try{
        HttpURLConnection con=(HttpURLConnection) connection;
        InputStream is = new BufferedInputStream(con.getInputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer jsonData=new StringBuffer();

   while ((line=br.readLine())!=null)
   {
       jsonData.append(line+"\n");
   }

        br.close();
        is.close();
        return jsonData.toString();


    }
    catch (IOException e)
    {
        e.printStackTrace();
        return "Error"+e.getMessage();
    }
}

}
