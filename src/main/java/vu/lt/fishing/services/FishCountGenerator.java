package vu.lt.fishing.services;


import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class FishCountGenerator implements Serializable {

    public Integer generateFishCount() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Thread exception: " + e);
        }
        return new Random().nextInt(500);
    }
}
