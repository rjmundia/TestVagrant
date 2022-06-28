package com.testvagrant.rcbtest;

import com.google.gson.Gson;
import com.testvagrant.rcbpojo.Player;
import com.testvagrant.rcbpojo.RCBPojo;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;

public class RCBTest {
    Gson getPojo = new Gson();
    RCBPojo rcbPojo = null;
    String path = System.getProperty("user.dir") + "/src/test/resources/testData/TeamRCB.json";

    @Test
    public void validateForeignPlayers() {
        try (Reader reader = new FileReader(path)) {

            rcbPojo = getPojo.fromJson(reader, RCBPojo.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        assert rcbPojo != null;
        int count = 0;
        for (Player player : rcbPojo.getPlayer()) {
            if (!player.getCountry().equalsIgnoreCase("India")) {
                count++;
            }
        }
        Assert.assertEquals(4, count);
        System.out.println("Expected number of Foreign Players : " + 4);
        System.out.println("Actual number of Foreign Players : " + count);
    }

    @Test
    public void validateWicketKeeper() {
        try (Reader reader = new FileReader(path)) {

            rcbPojo = getPojo.fromJson(reader, RCBPojo.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Player player : rcbPojo.getPlayer()) {
            if (player.getRole().equalsIgnoreCase("Wicket-keeper")) {
                Assert.assertTrue(true);
                System.out.println("Expected Player's role : Wicket-keeper");
                System.out.println("Actual Player's role : " + player.getRole());
            }
        }
    }
}
