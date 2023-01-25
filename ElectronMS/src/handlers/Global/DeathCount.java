/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers.Global;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import tools.Triple;

/**
 *
 * @author SoulGirlJP
 *
 * @Discord : SoulGirlJP#7859
 *
 **/


public class DeathCount {
    
    public static List<Triple<Integer, Integer, Integer>> deathcount = new ArrayList<>();

    protected static String toUni(String kor)
            throws UnsupportedEncodingException {
        return new String(kor.getBytes("KSC5601"), "8859_1");
    }

    public static void load() {
        try {
            FileInputStream setting = new FileInputStream("ElectronMS/property/DeathCount.properties");
            Properties setting_ = new Properties();
            setting_.load(setting);
            setting.close();
            String[] mapcode = setting_.getProperty(toUni("BossMap")).split(",");
            String[] time = setting_.getProperty(toUni("Time")).split(",");
            String[] deathcount = setting_.getProperty(toUni("DeathCount")).split(",");
            for (int i = 0; i < mapcode.length; i++) {
                DeathCount.deathcount.add(new Triple<>(Integer.parseInt(mapcode[i].replaceAll(" ", "")), Integer.parseInt(time[i].replaceAll(" ", "")), Integer.parseInt(deathcount[i].replaceAll(" ", ""))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
