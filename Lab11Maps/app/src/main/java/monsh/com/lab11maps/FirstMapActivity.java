package monsh.com.lab11maps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class FirstMapActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    private FirstMapFragment mFirstMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_map);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFirstMapFragment = FirstMapFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.map_container, mFirstMapFragment)
                .commit();

        // Registrar escucha onMapReadyCallback
        mFirstMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng leon = new LatLng(21.15327, -101.60057);
        googleMap.addMarker(new MarkerOptions()
                .position(leon)
                .title("Leon, Ser Fiera es un Orgullo"));

        CameraPosition cameraPosition = CameraPosition.builder()
                .target(leon)
                .zoom(10)
                .build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
