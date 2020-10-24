package com.example.geolocationwitharduino;

import android.Manifest;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.androidnetworking.AndroidNetworking;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, MessageListener {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;

    private GoogleMap mMap;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidNetworking.initialize(getApplicationContext());
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.dialog_locating).setCancelable(true);
        alertDialog = alertDialogBuilder.create();
        final Button button = findViewById(R.id.button);

        //Register sms listener
        SmsReceiver.bindListener(this);

        checkReceiveSmsPermission();
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                alertDialog.show();
                sendSMSMessage();
            }
        });
    }

    @Override
    public void messageReceived(String message) {
        try {
            JSONObject data = new JSONObject(message);
            String source = data.getString("source");
            if (source.equals("gsm")) {
                JSONArray cellTowers = data.getJSONArray("cellTowers");
                showEstimatedLocation(cellTowers);
            } else if (source.equals("gps")) {
                putExactLocation(data);
            }
        } catch (JSONException e) {
            Toast.makeText(this, "Exception while parsing JSON", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void showEstimatedLocation(JSONArray cellTowers) {
        final JSONObject request = new JSONObject();
        try {
            request.put("homeMobileCountryCode", Integer.parseInt(getString(R.string.mcc_poland)));
            request.put("radioType", "gsm");
            request.put("considerIp", "false");
            request.put("cellTowers", cellTowers);
        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }
        new Thread() {
            public void run() {
                URL googleEndpoint = null;
                try {
                    // Create URL
                    googleEndpoint = new URL("https://www.googleapis.com/geolocation/v1/geolocate?key=".concat(getString(R.string.google_maps_key)));
                    // Create connection
                    HttpsURLConnection myConnection =
                            (HttpsURLConnection) googleEndpoint.openConnection();
                    myConnection.setRequestMethod("POST");
                    myConnection.setRequestProperty("Content-Type", "application/json; utf-8");
                    myConnection.setRequestProperty("Accept", "application/json");
                    myConnection.setDoOutput(true);

                    String jsonInputString = request.toString();

                    DataOutputStream localDataOutputStream = new DataOutputStream(myConnection.getOutputStream());
                    localDataOutputStream.writeBytes(jsonInputString);
                    localDataOutputStream.flush();
                    localDataOutputStream.close();

                    try (BufferedReader br = new BufferedReader(
                            new InputStreamReader(myConnection.getInputStream(), "utf-8"))) {
                        StringBuilder response = new StringBuilder();
                        String responseLine = null;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        final JSONObject responseJson = new JSONObject(response.toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    putEstimatedLocation(responseJson);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void putExactLocation(JSONObject location) throws JSONException {
        alertDialog.hide();
        double lat, lng;
        lat = location.getDouble("lat");
        lng = location.getDouble("lng");
        LatLng marker = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(marker).title("Your device"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 14.0f));
    }

    private void putEstimatedLocation(JSONObject data) throws JSONException {
        alertDialog.hide();
        JSONObject location = data.getJSONObject("location");
        double accuracy = data.getDouble("accuracy");
        double lat = location.getDouble("lat");
        double lng = location.getDouble("lng");

        LatLng center = new LatLng(lat, lng);
        Circle circle = mMap.addCircle(new CircleOptions()
                .center(center)
                .radius(accuracy)
                .fillColor(0x5500ff00)
                .strokeColor(Color.BLACK)
                .strokeWidth(1));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 12.0f));
    }

    protected void checkReceiveSmsPermission() {
        String permission = Manifest.permission.RECEIVE_SMS;
        int grant = ContextCompat.checkSelfPermission(this, permission);
        if (grant != PackageManager.PERMISSION_GRANTED) {
            String[] permission_list = new String[1];
            permission_list[0] = permission;

            ActivityCompat.requestPermissions(this, permission_list, 1);
        }
    }

    protected void sendSMSMessage() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                == PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(getString(R.string.arduino_gsm_number), null, getString(R.string.location_request), null, null);
                    Toast.makeText(getApplicationContext(), "Location request sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Location request failed, please try again.", Toast.LENGTH_LONG).show();
                }
            }
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

}