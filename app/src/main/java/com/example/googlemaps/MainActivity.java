package com.example.googlemaps;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mapa = googleMap;
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mapa.getUiSettings().setZoomControlsEnabled(true);
        CameraUpdate camUpd1 = CameraUpdateFactory.newLatLngZoom(new LatLng(-1.0126, -79.4696), 20);
        mapa.moveCamera(camUpd1);

        mapa.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null; //
            }
            @Override
            public View getInfoContents(Marker marker) {
                View view = getLayoutInflater().inflate(R.layout.ventana_de_informacion, null);
                ImageView imageView = view.findViewById(R.id.Facultad);
                TextView titleTextView = view.findViewById(R.id.txttitulo);
                TextView descriptionTextView = view.findViewById(R.id.txtdescripcion);
                if (marker.getTitle().equals("Facultad de Ciencias de la Salud")) {
                    imageView.setImageResource(R.drawable.facultadsalud);
                    titleTextView.setText("Facultad de Ciencias de la Salud");
                    descriptionTextView.setText(Html.fromHtml("<b>Carreras que oferta:</b><br/>Enfermería"));
                } else if (marker.getTitle().equals("Facultad de Ciencias Empresariales")) {
                    imageView.setImageResource(R.drawable.facultadempresariales);
                    titleTextView.setText("Facultad de Ciencias Empresariales");
                    descriptionTextView.setText(Html.fromHtml("<b>Carreras que oferta:</b><br/>Administración de Empresas<br/>Contabilidad y Auditoría<br/>Gestión del Talento Humano<br/>Mercadotecnia"));
                } else if (marker.getTitle().equals("Facultad de Ciencias Sociales, Económicas y Financieras")) {
                    imageView.setImageResource(R.drawable.facultadsociales);
                    titleTextView.setText("Facultad de Ciencias Sociales, Económicas y Financieras");
                    descriptionTextView.setText(Html.fromHtml("<b>Carreras que oferta:</b><br/>Administración Públicas<br/>Economía<br/>Finanzas<br/>Turismo"));
                } else if (marker.getTitle().equals("Facultad de Ciencias de la Educación")) {
                    imageView.setImageResource(R.drawable.facultadeducacion);
                    titleTextView.setText("Facultad de Ciencias de la Educación");
                    descriptionTextView.setText(Html.fromHtml("<b>Carreras que oferta:</b><br/>Educación básica<br/>Pedagogía de los Idiomas Nacionales y Extranjeros<br/>Psicopedagogía"));
                }
                return view;
            }
        });
        LatLng ubicacion1 = new LatLng(-1.0128590472579106, -79.46936342524782);
        mapa.addMarker(new MarkerOptions()
                .position(ubicacion1)
                .title("Facultad de Ciencias de la Salud"));
        LatLng ubicacion2 = new LatLng(-1.0122690534315153, -79.47022709657386);
        mapa.addMarker(new MarkerOptions()
                .position(ubicacion2)
                .title("Facultad de Ciencias Empresariales"));
        LatLng ubicacion3 = new LatLng(-1.0125908682592284, -79.47052213957345);
        mapa.addMarker(new MarkerOptions()
                .position(ubicacion3)
                .title("Facultad de Ciencias Sociales, Económicas y Financieras"));
        LatLng ubicacion4 = new LatLng(-1.0125694139383714, -79.47101566604547);
        mapa.addMarker(new MarkerOptions()
                .position(ubicacion4)
                .title("Facultad de Ciencias de la Educación"));
    }
}