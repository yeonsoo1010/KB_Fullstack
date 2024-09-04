package org.scoula.common.util;

public class UploadFileName {
    public static String getUniqueName(String fileName) {

        int ix = fileName.lastIndexOf(".");
        String name = fileName.substring(0, ix);
        String ext = fileName.substring(ix+1);

        return String.format("%s_%d.%s", name, System.currentTimeMillis(), ext);
    }
}
