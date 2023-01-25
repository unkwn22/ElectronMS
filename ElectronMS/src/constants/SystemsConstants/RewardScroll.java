package constants.SystemsConstants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import tools.RandomStream.Randomizer;

public class RewardScroll {

    private final static RewardScroll instance = new RewardScroll();

    HashMap<Integer, Integer> RewardScroll = new HashMap<>();

    public static RewardScroll getInstance() {
        return instance;
    }

    protected RewardScroll() {
        try {
            FileReader fl = new FileReader("ElectronMS/property/RewardScroll.properties");
            BufferedReader br = new BufferedReader(fl);
            String[] readSplit;
            String readLine;
            int i = 0;
            while ((readLine = br.readLine()) != null) {
                readSplit = readLine.split(" - ");
                RewardScroll.put(i, Integer.parseInt(readSplit[0]));
                i++;
            }
            fl.close();
            br.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public int getRewardScroll() {
        return RewardScroll.get(Randomizer.rand(0, RewardScroll.size() - 1));
    }

}
