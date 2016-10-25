package code.atividade3;

/**
 * Created by lflgoncalves on 10/24/16.
 */
public class SQLHelper {
    public static String createTableLembrete() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS lembretes ( ");
        sb.append("_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sb.append("lembrete_txt_lembrete VARCHAR(500)); ");

        return sb.toString();
    }

    public static String insertLembrete(String lembrete) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO lembretes (lembrete_txt_lembrete) VALUES ('" + lembrete + "') ");

        return sb.toString();
    }

    public static String getAllLembretes() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT lembrete_txt_lembrete FROM lembretes ");

        return sb.toString();
    }
}
