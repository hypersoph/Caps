package ca.yorku.caps;

import org.junit.Test;

import java.util.List;

import ca.roumani.i2c.CountryDB;

public class GameTest
{

    @Test
    public void qaTest() {
        Game game = new Game();
        String qa = game.qa();
        System.out.println(qa);
        String a = qa.split("\n")[1];
        System.out.println(a);

    }
    CountryDB db = new CountryDB();

}
