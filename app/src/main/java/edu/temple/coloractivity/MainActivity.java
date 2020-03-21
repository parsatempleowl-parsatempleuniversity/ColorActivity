package edu.temple.coloractivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
        if (twoPanes) {
            canvasFragment = getSupportFragmentManager().findFragmentById(R.id.container2);
            assert canvasFragment != null;
            ((CanvasFragment) canvasFragment).changeCanvasColor(color);
        }
        else {
            canvasFragment = new CanvasFragment();
            loadFragment(R.id.main_fragment, canvasFragment, true);
            ((CanvasFragment) canvasFragment).changeCanvasColor(color);
        }
    }

    private void loadFragment (int paneId, Fragment fragment, boolean placeOnBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().replace(paneId, fragment);
        if (placeOnBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();
    }
}
