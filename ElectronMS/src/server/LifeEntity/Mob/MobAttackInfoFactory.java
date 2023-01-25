package server.LifeEntity.Mob;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.LifeEntity.Mob.MonsterEntity.MapleMonster;
import tools.Pair;
import tools.StringUtil;

public class MobAttackInfoFactory {

    private static final MobAttackInfoFactory instance = new MobAttackInfoFactory();
    private static final MapleDataProvider dataSource = MapleDataProviderFactory.getDataProvider(new File("ElectronMS/wz/Mob.wz"));
    private static Map<Pair<Integer, Integer>, MobAttackInfo> mobAttacks = new HashMap<>();

    public static MobAttackInfoFactory getInstance() {
        return instance;
    }

    public MobAttackInfo getMobAttackInfo(MapleMonster mob, int attack) {
        MobAttackInfo ret = null;
        if (mob != null) {
            ret = mobAttacks.get(new Pair<>(mob.getId(), attack));
            if (ret != null) {
                return ret;
            }
        }
        if (mob == null) {
            return null;
        }
        MapleData mobData = dataSource.getData(StringUtil.getLeftPaddedStr(mob.getId() + ".img", '0', 11));
        if (mobData != null) {
            MapleData infoData = mobData.getChildByPath("info/link");
            if (infoData != null) {
                String linkedmob = MapleDataTool.getString("info/link", mobData);
                mobData = dataSource.getData(StringUtil.getLeftPaddedStr(linkedmob + ".img", '0', 11));
            }
            final MapleData attackData = mobData.getChildByPath("attack" + (attack + 1) + "/info");
            if (attackData != null) {
                ret = new MobAttackInfo(mob.getId(), attack);
                ret.setDeadlyAttack(attackData.getChildByPath("deadlyAttack") != null);
                ret.setMpBurn(MapleDataTool.getInt("mpBurn", attackData, 0));
                ret.setDiseaseSkill(MapleDataTool.getInt("disease", attackData, 0));
                ret.setDiseaseLevel(MapleDataTool.getInt("level", attackData, 0));
                ret.setMpCon(MapleDataTool.getInt("conMP", attackData, 0));
            }
        }
        mobAttacks.put(new Pair<>(mob.getId(), attack), ret);

        return ret;
    }
}
