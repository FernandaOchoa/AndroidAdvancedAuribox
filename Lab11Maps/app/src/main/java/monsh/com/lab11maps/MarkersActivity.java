package monsh.com.lab11maps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class MarkersActivity extends AppCompatActivity
        implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnMarkerDragListener,
        GoogleMap.OnInfoWindowClickListener {

    public static final String EXTRA_LATITUD = "LATITUD";
    public static final String EXTRA_LONGITUD = "LONGITUD";

    private Marker markerLeon;
    private Marker markerCdmx;
    private Marker markerDolores;

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markers);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        // Markers
        LatLng leon = new LatLng(21.15327, -101.60057);
        markerLeon = googleMap.addMarker(new MarkerOptions()
                .position(leon)
                .title("Leon, Gto")
        );

        LatLng cdmx = new LatLng(39.17539, -91.88428);
        markerCdmx = googleMap.addMarker(new MarkerOptions()
                .position(cdmx)
                .title("Ciudad de México")
                .draggable(true)
        );

        LatLng dolores = new LatLng(21.1474, -100.918);
        markerDolores = googleMap.addMarker(
                new MarkerOptions()
                        .position(dolores)
                        .title("Dolores Hidalgo")
        );

        // Cámara
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(dolores));

        // Eventos
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMarkerDragListener(this);
        googleMap.setOnInfoWindowClickListener(this);

    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        if (marker.equals(markerLeon)) {

            map.animateCamera(CameraUpdateFactory.newLatLng(marker.getPosition()), new GoogleMap.CancelableCallback() {
                @Override
                public void onFinish() {
                    Intent intent = new Intent(MarkersActivity.this, MarkerDetailActivity.class);
                    intent.putExtra(EXTRA_LATITUD, marker.getPosition().latitude);
                    intent.putExtra(EXTRA_LONGITUD, marker.getPosition().longitude);
                    startActivity(intent);
                }

                @Override
                public void onCancel() {

                }
            });

            return true;

        }

        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        if (marker.equals(markerDolores)) {
            Toast.makeText(this, "START", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        if (marker.equals(markerDolores)) {
            String newTitle = String.format(Locale.getDefault(),
                    getString(R.string.marker_detail_latlng),
                    marker.getPosition().latitude,
                    marker.getPosition().longitude);

            setTitle(newTitle);
        }
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        if (marker.equals(markerDolores)) {
            Toast.makeText(this, "END", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        if (marker.equals(markerCdmx)) {

            MexicoDialogFragment.newInstance(marker.getTitle(),
                    getString(R.string.mexico_descr))
                    .show(getSupportFragmentManager(), null);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}
