//Student Name: Sophia Nguyen
//This project was done individually
package ca.yorku.caps;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game
{
    private CountryDB db;

    public Game()
    {
        this.db = new CountryDB();
    }

    public String qa() {
        List<String> capitalList = db.getCapitals();
        int n = capitalList.size();

        int index = (int) (Math.random()*n);
        String c = capitalList.get(index);

        Map<String, Country> data = db.getData();
        Country ref = data.get(c);

        String qa = "";
        if (Math.random() < 0.5) {
            qa = String.format("What is the capital of %s?\n%s",ref.getName(), ref.getCapital());
        }
        else {
            qa = String.format("%s is the capital of?\n%s",ref.getCapital(), ref.getName());
        }

        return qa;
    }
{

}
}
