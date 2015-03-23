package com.hahattpro.ttrandomlib;

import android.util.Log;

import java.sql.Time;
import java.util.Calendar;

/**
 * Created by haha on 3/23/2015.
 */
public class ttRandom {
//how to add a library
// http://stackoverflow.com/questions/16601299/how-to-create-a-library-project-in-android-studio-and-an-application-project-tha

    private int seed;
    private int multiplier = 4724;
    private int add_on = 99870;


    int counter = 0;

    private  int reseed(){
       long tmp = seed;
        seed = (int)((seed * multiplier + add_on) % (System.currentTimeMillis()));
        Log.i("seed", "seed = " + seed);
        counter++;
        Log.i("counter","counter = "+counter);

        long a = tmp-seed;
        if (a == 0) {
            seed = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);

        }
        return seed;
    }


    public ttRandom(int Seed) {
        seed = Seed;
        reseed();
        reseed();
        reseed();
        reseed();
        reseed();
    }

    public ttRandom() {
        seed = (int)(System.currentTimeMillis()%Integer.MAX_VALUE) ;
        reseed();
        reseed();
        reseed();
        reseed();
        reseed();
    }

    public double random_real(){
        double max = Integer.MAX_VALUE +1.0;
        double temp = reseed();
        if (temp < 0) temp = temp + max;
        return temp / max;
    }

    public int random_integer(int low, int high){
        if (low > high) return random_integer(high, low);
        else return ((int)((high - low + 1) *random_real())) + low;
    }
}
