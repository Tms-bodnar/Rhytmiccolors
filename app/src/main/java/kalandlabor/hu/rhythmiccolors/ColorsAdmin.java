package kalandlabor.hu.rhythmiccolors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by user on 2017.04.30..
 */

public class ColorsAdmin {
    List<Integer> colorList;

    public ColorsAdmin() {
    }

    public ColorsAdmin(List<Integer> colorList) {
        this.colorList = colorList;
    }

    public static List<Integer> ListAdmin(Integer[] colorArray, int num, int size) {
        List<Integer> shuffledList = new ArrayList<>(num * size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < num; j++) {
                shuffledList.add(colorArray[j]);
            }
        }
        Collections.shuffle(shuffledList);
        return shuffledList;
    }

}
