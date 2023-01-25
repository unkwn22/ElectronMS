package constants;

import java.io.FileInputStream;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import client.MapleClient;
import server.CustomEvents.BingoGame;
import client.Character.MapleCharacter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tools.Triple;

public class ServerConstants {

    /* ���� ���� */
    public static String Host = "175.207.0.33";
    public static String ADMIN1;
    public static String ADMIN2;
    public static String ADMIN3;
    public static String ADMIN4;
    public static String ADMIN5;
    public static int startMap;
    public static byte defaultFlag;
    public static int ChannelCount;
    public static int LoginPort;
    public static int ChannelPort;
    public static int CashShopPort;
    public static int BuddyChatPort;

    public static boolean isLocal = false;
    public static int AHT_VERSION = 0;
    public static long SKILL_FILE_CRC = 1471966654; // skill.wz crc32

    public static byte[] testPacket = null;
    public static boolean already = false;
    public static int defaultExpRate;
    public static int defaultMesoRate;
    public static int defaultDropRate;
    public static int defaultCashRate;
    public static int defaultBossCashRate;
    public static int maxDrop;
    public static int bossMaxDrop;

    public static String mrank1 = null;
    public static String prank1 = null;
    public static String crank1 = null;

    public static int defaultMaxChannelLoad = 50;
    public static int cshopNpc = 0;
    public static int chatlimit = 0;

    /* DB ���� */
    public static int dbPort;
    public static String dbHost;
    public static String dbUser;
    public static String dbPassword;

    /* Message ���� �� �̺�Ʈ ���� */
    public static String recommendMessage = "";
    public static String serverName = "";
    public static String serverMessage = "";
    public static String serverWelcome = "";
    public static String eventMessage = "";
    public static String serverHint = "������ �ٺ�";
    public static String beginner = "";
    public static String serverNotice = "";
    public static String serverNotititle = "";
    public static String serverNotification = "";
    public static String events = "";
    public static String real_face_hair = "";
    public static String serverCheckMessage = "���� " + serverName + " ���� ���� ���Դϴ�.\r\n �ڼ��� ������ Ȩ�������� �����Ͽ� �ֽʽÿ�.\r\n [���� : �ý��� ����ȭ]";

    /* ���� ���� */
    public static boolean serverCheck;

    public static boolean isDev = false;

    public static int shopSale = 0;

    /* ��Ÿ ���� */
    public static boolean UnlockMaxDamage = true;
    public static boolean feverTime = false;
    public static boolean useMaxDrop;
    public static boolean useBossMaxDrop;
    
    public static boolean showPackets = true;
    public static boolean DEBUG_RECEIVE = true;
    public static boolean DEBUG_SEND = true;
    /* ��Ŷ�׽�Ʈ 
    public static boolean showPackets = false;
    public static boolean sendPacketShow = false;
    public static boolean recvPacketShow = false;
    */
    public static boolean realese = false;
    public static String path = "";
    public static String windowsDumpPath = "";

    /* ���� ���� */
    public static short MAPLE_VERSION;
    public static byte subVersion;
    public static final byte check = 0;

    /* ��Ÿ ���� 2 */
    public static String hp_skillid_dummy = "";
    public static String[] hp_skillid_real;

    //public static int loginPointAid = -1;

    public static MapleCharacter chr;

    public static List<MapleCharacter> mChat_char = new ArrayList<>();

    public static boolean isShutdown = false;

    public static boolean AutoHotTimeSystem;
    public static boolean AutoHotTimeSystemtemchacks = false; 
    
    
    public static BingoGame BingoGame = null;    

    /* Hot TIme Settings */
    public static int AutoHotTimeSystemHour = 0;
    public static int AutoHotTimeSystemMinute = 0;
    public static int AutoHotTimeSystemSecond = 0;

    public static List<Integer> AutoHotTimeSundayItemCode = new ArrayList<>();
    public static List<Integer> AutoHotTimeMondayItemCode = new ArrayList<>();
    public static List<Integer> AutoHotTimeTuesdayItemCode = new ArrayList<>();
    public static List<Integer> AutoHotTimeWednesdayItemCode = new ArrayList<>();
    public static List<Integer> AutoHotTimeThursdayItemCode = new ArrayList<>();
    public static List<Integer> AutoHotTimeFridayItemCode = new ArrayList<>();
    public static List<Integer> AutoHotTimeSaturdayItemCode = new ArrayList<>();
    
    /* Hot Time Settings End */    
    
    /*Ŀ���� ����*/
    public static final Map<String, Triple<String, String, String>> authlist = new ConcurrentHashMap<>();//�������
    public static final Map<String, Triple<String, String, String>> authlist2 = new ConcurrentHashMap<>();//�������
    public static boolean ConnectorSetting;
    public static boolean ConnecterLog = false;    
    
    public static final char PLAYER_COMMAND_PREFIX = '@';
    public static final char ADMIN_COMMAND_PREFIX = '!';

    public static final String SERVER_NAME = "ElectronMS";
    public static final boolean AUTO_REGISTER = true;
    public static final int BCRYPT_ITERATIONS = 10;
    public static final boolean ENABLE_ADMIN_TOOL = true;
    
    static {
        try {
            FileInputStream setting = new FileInputStream("ElectronMS/property/ServerSettings.properties");
            Properties setting_ = new Properties();
            setting_.load(setting);
            setting.close();
            defaultFlag = Byte.parseByte(setting_.getProperty("Flag"));
            String[] temp = setting_.getProperty("Ŀ��������Ʈ").split(",");
            for (String v1 : temp) {
                GameConstants.questReader.add(Integer.parseInt(v1));
            }
            ChannelCount = Integer.parseInt(setting_.getProperty("ChannelCount"));
            LoginPort = Integer.parseInt(setting_.getProperty("LoginPort"));
            ChannelPort = Integer.parseInt(setting_.getProperty("ChannelPort"));
            CashShopPort = Integer.parseInt(setting_.getProperty("CSPort"));
            BuddyChatPort = Integer.parseInt(setting_.getProperty("BuddyChatPort"));

            defaultExpRate = Integer.parseInt(setting_.getProperty("EXPRate"));
            defaultDropRate = Integer.parseInt(setting_.getProperty("DropRate"));
            defaultMesoRate = Integer.parseInt(setting_.getProperty("MesoRate"));
            defaultCashRate = Integer.parseInt(setting_.getProperty("CashRate"));
            defaultBossCashRate = Integer.parseInt(setting_.getProperty("BossCashRate"));

            cshopNpc = Integer.parseInt(setting_.getProperty("CSNpc"));

            serverName = setting_.getProperty("�����̸�");
            serverMessage = setting_.getProperty("�����޼���");
            serverWelcome = setting_.getProperty("����ȯ���޼���");
            eventMessage = setting_.getProperty("�̺�Ʈ�޼���");
            beginner = setting_.getProperty("ó�����۰���");
            serverNotititle = setting_.getProperty("������������");
            serverNotification = setting_.getProperty("������������");
            recommendMessage = setting_.getProperty("��õ�޼���");
            serverHint = setting_.getProperty("������Ʈ");

            dbHost = setting_.getProperty("Arc.dbHost");
            dbPort = Integer.parseInt(setting_.getProperty(("Arc.dbPort")));
            dbUser = setting_.getProperty("Arc.dbUser");
            dbPassword = setting_.getProperty("Arc.dbPassword");

            events = setting_.getProperty("Events");

            startMap = Integer.parseInt(setting_.getProperty("StartMap"));
            serverHint = setting_.getProperty("������Ʈ");

            MAPLE_VERSION = Short.parseShort(setting_.getProperty("GameVersion"));
            subVersion = Byte.parseByte(setting_.getProperty("GameSubVersion"));

            path = setting_.getProperty("Path");
            windowsDumpPath = setting_.getProperty("WindowsDumpPath");

            serverCheck = Boolean.parseBoolean(setting_.getProperty(("��������")));
            showPackets = Boolean.parseBoolean(setting_.getProperty(("��Ŷ���")));
            useMaxDrop = Boolean.parseBoolean(setting_.getProperty(("�ִ������")));
            useBossMaxDrop = Boolean.parseBoolean(setting_.getProperty(("�ִ뺸��������")));
            bossMaxDrop = Integer.parseInt(setting_.getProperty("BossMaxDrop"));
            maxDrop = Integer.parseInt(setting_.getProperty("MaxDrop"));

            AutoHotTimeSystem = Boolean.parseBoolean(setting_.getProperty("IsAutoHotTime"));
            AutoHotTimeSystemHour = Integer.parseInt(setting_.getProperty("AutoHotTimeHour"));
            AutoHotTimeSystemMinute = Integer.parseInt(setting_.getProperty("AutoHotTimeMinute"));
            AutoHotTimeSystemSecond = Integer.parseInt(setting_.getProperty("AutoHotTimeSeconds"));
            
            String AutoHotTimeSundayItemCodes = setting_.getProperty("AutoHotTimeSundayItemCode");
            if (!AutoHotTimeSundayItemCodes.isEmpty()) {
                String[] AutoHotTimeSundayItemCodess = AutoHotTimeSundayItemCodes.split(",");
                for (String autoHotTimeSundayItemCodess : AutoHotTimeSundayItemCodess) {
                    AutoHotTimeSundayItemCode.add(Integer.parseInt(autoHotTimeSundayItemCodess));
                }
            }
            String AutoHotTimeMondayItemCodes = setting_.getProperty("AutoHotTimeMondayItemCode");
            if (!AutoHotTimeMondayItemCodes.isEmpty()) {
                String[] AutoHotTimeMondayItemCodess = AutoHotTimeMondayItemCodes.split(",");
                for (String autoHotTimeMondayItemCodess : AutoHotTimeMondayItemCodess) {
                    AutoHotTimeMondayItemCode.add(Integer.parseInt(autoHotTimeMondayItemCodess));
                }
            }
            String AutoHotTimeTuesdayItemCodes = setting_.getProperty("AutoHotTimeTuesdayItemCode");
            if (!AutoHotTimeTuesdayItemCodes.isEmpty()) {
                String[] AutoHotTimeTuesdayItemCodess = AutoHotTimeTuesdayItemCodes.split(",");
                for (String autoHotTimeTuesdayItemCodess : AutoHotTimeTuesdayItemCodess) {
                    AutoHotTimeTuesdayItemCode.add(Integer.parseInt(autoHotTimeTuesdayItemCodess));
                }
            }
            String AutoHotTimeWednesdayItemCodes = setting_.getProperty("AutoHotTimeWednesDayItemCode");
            if (!AutoHotTimeWednesdayItemCodes.isEmpty()) {
                String[] AutoHotTimeWednesdayItemCodess = AutoHotTimeWednesdayItemCodes.split(",");
                for (String autoHotTimeWednesdayItemCodess : AutoHotTimeWednesdayItemCodess) {
                    AutoHotTimeWednesdayItemCode.add(Integer.parseInt(autoHotTimeWednesdayItemCodess));
                }
            }
            String AutoHotTimeThursdayItemCodes = setting_.getProperty("AutoHotTimeThursdayItemCode");
            if (!AutoHotTimeThursdayItemCodes.isEmpty()) {
                String[] AutoHotTimeThursdayItemCodess = AutoHotTimeThursdayItemCodes.split(",");
                for (String autoHotTimeThursdayItemCodess : AutoHotTimeThursdayItemCodess) {
                    AutoHotTimeThursdayItemCode.add(Integer.parseInt(autoHotTimeThursdayItemCodess));
                }
            }

            String AutoHotTimeFridayItemCodes = setting_.getProperty("AutoHotTimeFridayItemCode");
            if (!AutoHotTimeFridayItemCodes.isEmpty()) {
                String[] AutoHotTimeFridayItemCodess = AutoHotTimeFridayItemCodes.split(",");
                for (String autoHotTimeFridayItemCodess : AutoHotTimeFridayItemCodess) {
                    AutoHotTimeFridayItemCode.add(Integer.parseInt(autoHotTimeFridayItemCodess));
                }
            }
            String AutoHotTimeSaturdayItemCodes = setting_.getProperty("AutoHotTimeSaturdayItemCode");
            if (!AutoHotTimeSaturdayItemCodes.isEmpty()) {
                String[] AutoHotTimeSaturdayItemCodess = AutoHotTimeSaturdayItemCodes.split(",");
                for (String autoHotTimeSaturdayItemCodess : AutoHotTimeSaturdayItemCodess) {
                    AutoHotTimeSaturdayItemCode.add(Integer.parseInt(autoHotTimeSaturdayItemCodess));
                }
            }
            
            ConnectorSetting = Boolean.parseBoolean(setting_.getProperty("IsConnectorSetting"));
        } catch (Exception e) {
            System.err.println("[����] ���� ���������� �ҷ����µ� �����Ͽ����ϴ�.");
            if (!realese) {
                e.printStackTrace();
            }
        }
    }

    public static int basePorts = (isLocal ? 100 : 0) + (ChannelPort);

    public static boolean isAdminIp(String ip) {
        ip = ip.replaceAll("/", "");
        return ip.equals(ServerConstants.ADMIN1) || ip.equals(ServerConstants.ADMIN2) || ip.equals(ServerConstants.ADMIN3) || ip.equals(ServerConstants.ADMIN4) || ip.equals(ServerConstants.ADMIN5);
    }

    public static String getServerHost(MapleClient ha) {
        try {
            return InetAddress.getByName(ServerConstants.Host).getHostAddress().replace("/", "");
        } catch (Exception e) {
            if (!ServerConstants.realese) {
                e.printStackTrace();
            }
        }
        return ServerConstants.Host;
    }
}
