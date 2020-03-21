package edu.temple.coloractivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements PaletteFragment.onFragmentInteractionListener {
    boolean twoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        twoPanes = (findViewById(R.id.container2) != null);
        PaletteFragment paletteFragment = new PaletteFragment();
        loadFragment(R.id.main_fragment, paletteFragment, false);
        if (twoPanes) {
            loadFragment(R.id.container2, new CanvasFragment(), false);
        }
        else {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container2);
            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            }
        }
    }

    @Override
    public void displayNewColor(String color) {
        Fragment canvasFragment;
        
    }
}
