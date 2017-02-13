package com.example.anmol.garage.m_MySQL;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Anmol on 2/10/2017.
 */
public class Connector {
    public static Object connect(String urlAddress)
    {
        try
        {
            URL url=new URL(urlAddress);
            HttpURLConnection con=(HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setConnectTimeout(15000);
            con.setReadTimeout(15000);
            con.setDoInput(true);
            return  con;
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
            return "Error"+e.getMessage();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "Error"+e.getMessage();
        }
    }

}
