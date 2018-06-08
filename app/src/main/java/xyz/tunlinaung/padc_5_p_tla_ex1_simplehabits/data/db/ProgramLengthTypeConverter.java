package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.db;

import android.arch.persistence.room.TypeConverter;

import java.util.Arrays;
import java.util.List;

public class ProgramLengthTypeConverter {

    @TypeConverter
    public static int[] toIntArray(String length) {
        String[] lengths = length.split(",");
        return Arrays.stream(lengths).mapToInt(Integer::parseInt).toArray();
    }

    @TypeConverter
    public static String toString(int[] lengths) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int length : lengths) {
            stringBuilder.append(length).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

}
