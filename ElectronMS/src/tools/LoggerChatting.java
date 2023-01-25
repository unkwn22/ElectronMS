package tools;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import client.Character.MapleCharacter;
import client.ItemInventory.IItem;
import client.Community.MapleUserTrade;
import constants.ServerConstants;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class LoggerChatting {

    public static String chatLog = "ChatLog.txt";
    public static String givercLog = "�Ŀ�����Ʈ����.txt";
    public static String givehbLog = "ȫ������Ʈ����.txt";
    public static String giveadLog = "�߰�����������.txt";
    public static String Leon = "�ݷ������.txt";
    public static String Kaung = "ī�����.txt";
    public static String Papulatus = "��Ǯ���������.txt";
    public static String Archive = "��ī�̷����.txt";
    public static String Signus = "�ñ׳ʽ����.txt";
    public static String demLog = "���̾����.txt";
    public static String Heila = "�������.txt";
    public static String Belum = "�������.txt";   
    public static String Half = "�ݹ����.txt";   
    public static String BloodyQueen = "���������.txt";   
    public static String Pierre = "�ǿ������.txt";   
    public static String Pinkbin = "��ũ�����.txt";   
    public static String Zacum = "�������.txt";
    public static String Magnus = "�ű׳ʽ����.txt";
    public static String swooLog = "�������.txt";
    public static String lucLog = "��õ����.txt";
    public static String wLog = "�����.txt";
    public static String crLog = "ũ�ν����.txt";
    public static String dorosiLog = "���ν����.txt";
    public static String dcLog = "ĳ���ͻ���.txt";
    public static String commandLog = "GM��ɾ�α�.txt";
    public static String commandLog2 = "������ɾ�α�.txt";
    public static String tradeLog = "��ȯ�α�.txt";

    public static void writeLog(String log, String text) {
        try {
            Calendar currentTime = Calendar.getInstance(TimeZone.getTimeZone("KST"), Locale.KOREAN);
            File file = new File("ElectronMS/property/Logs/" + log);
            if (!file.exists()) {
                boolean success = file.createNewFile();
                if (!success) {
                    throw new Exception("Error trying to create a log file for " + log);
                }
            }
            FileOutputStream fos = new FileOutputStream(file, true);

            fos.write((currentTime.getTime() + " " + text + "" + System.getProperty("line.separator"))
                    .getBytes());
            fos.close();
        } catch (Exception e) {
            if (!ServerConstants.realese) {
                e.printStackTrace();
            }
        }
    }

    public static void writeTradeLog(String log, String text, String character) {
        try {
            Calendar currentTime = Calendar.getInstance(TimeZone.getTimeZone("KST"), Locale.KOREAN);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            File file = new File(
                    "property/Logs/" + sdf.format(timestamp) + " " + character + " " + log);

            FileOutputStream fos = new FileOutputStream(file, true);
            fos.write((currentTime.getTime().toString() + " " + text + "" + System.getProperty("line.separator") + "\r\n")
                    .getBytes());
            fos.close();
        } catch (Exception e) {
            if (!ServerConstants.realese) {
                e.printStackTrace();
            }
        }
    }

    public static String getTradeLogType(MapleUserTrade local, MapleUserTrade partner) {
        StringBuilder sb = new StringBuilder();
        sb.append(local.getChr().getName()).append("��(��) ���� ������, �޼� \r\n");
        sb.append(local.exchangeMeso).append(" �޼�\r\n");
        for (final IItem item : local.exchangeItems) {
            sb.append(item.getItemId()).append(" ").append(item.getQuantity()).append("��\r\n");
        }
        sb.append(partner.getChr().getName()).append("==================================================\r\n");
        sb.append(partner.getChr().getName()).append("��(��) ���� ������, �޼�\r\n");
        sb.append(partner.exchangeMeso).append(" �޼�\r\n");
        for (final IItem item : partner.exchangeItems) {
            sb.append(item.getItemId()).append(" ").append(item.getQuantity()).append("��\r\n");
        }
        return sb.toString();
    }

    public static String getChatLogType(String type, MapleCharacter chr, String chattext) {
        return "[" + type + "] " + chr.getName() + " : " + chattext + " ����� : " + chr.getMap().getStreetName() + "-"
                + chr.getMap().getMapName() + " (" + chr.getMap().getId() + ")";
    }

    public static String getCommandLogType(String type, MapleCharacter chr, String chattext) {
        return "[" + type + "] ĳ���� �̸� : " + chr.getName() + "����� ��ɾ� : " + chattext + " ����� : "
                + chr.getMap().getStreetName() + "-" + chr.getMap().getMapName() + " (" + chr.getMap().getId() + ")";
    }

    public static String getRcgive(String type, MapleCharacter chr, MapleCharacter victim, long qty) {
        return "[" + type + "] ������ : " + chr.getName() + " / �������� : " + victim.getName() + " / ���޷� : " + qty;
    }

    public static String getBossLog(String type, MapleCharacter chr) {
        return "[" + type + "] �г��� : " + chr.getName() + " /  ����ID : " + chr.getAccountID();
    }

    public static String getDeleteLog(String type, String chr, String ac) {
        return "[" + type + "] �г��� : " + chr + " /  ����ID : " + ac;
    }
}
