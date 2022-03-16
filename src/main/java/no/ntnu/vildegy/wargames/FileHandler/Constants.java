package no.ntnu.vildegy.wargames.FileHandler;

import java.util.HashMap;

public class Constants {

    public enum CSV__ARMY_FIELDS {
        ARMY_NAME, UNIT_TYPE, UNIT_NAME, UNIT_HEALTH
    }

    public static final HashMap<String, CSV__ARMY_FIELDS> CSV_FIELD_HEADER = new HashMap<>();
    static {
        CSV_FIELD_HEADER.put("ARMY_NAME", CSV__ARMY_FIELDS.ARMY_NAME);
        CSV_FIELD_HEADER.put("UNIT_TYPE", CSV__ARMY_FIELDS.UNIT_TYPE);
        CSV_FIELD_HEADER.put("UNIT_NAME", CSV__ARMY_FIELDS.UNIT_NAME);
        CSV_FIELD_HEADER.put("UNIT_HEALTH", CSV__ARMY_FIELDS.UNIT_HEALTH);
    }

    public static final String CSV_DELIMITER_STRING = ";";
}
