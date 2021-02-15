package com.jihogrammer.algo.compare;

import java.util.Comparator;

public class WriterNameComparator implements Comparator<Writer> {

    @Override
    public int compare(Writer o1, Writer o2) {

        int result = o1.name.compareTo(o2.name);

        return result == 0 ? o1.title.compareTo(o2.title) : result;

    }
    
}
