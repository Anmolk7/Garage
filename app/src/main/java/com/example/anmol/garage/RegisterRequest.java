package com.example.anmol.garage;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anmol on 2/10/2017.
 */
public class RegisterRequest extends StringRequest
{

    private static final String REGISTER_REQUEST_URL="https://dizziest-reams.000webhostapp.com/Register1.php";
    private Map<String ,String> params;

    public RegisterRequest(String name, String username, String phone, String password, String city_name, String area, String cordinates, Response.Listener<String> listener)
    {
        super(Method.POST,REGISTER_REQUEST_URL, listener,null);
        params = new HashMap<>();
        params.put("name",name);
        params.put("username",username);
        params.put("phone",phone);
        params.put("password",password);
        params.put("city_name",city_name);
        params.put("area",area);
        params.put("cordinates",cordinates);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

