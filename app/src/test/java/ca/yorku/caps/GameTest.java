package ca.yorku.caps;

import org.junit.Test;

import java.util.List;

import ca.roumani.i2c.CountryDB;

public class GameTest
{

    @Test
    public void qaTest() {
        Game game = new Game();
        System.out.println(game.qa());
    }
    CountryDB db = new CountryDB();
    @Test
    public void mics() {

        List<String> capitalList = db.getCapitals();
        int n = capitalList.size();
        int index = (int) (Math.random()*n);
        System.out.println(n);
        System.out.println(index);
    }
}
