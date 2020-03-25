package com.zt.cad.linemanager.util;

import android.os.Environment;

import com.zt.cad.linemanager.MyApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AccessUtil {
    private static String m_sWorkDir;
    private static final String modelName = "test.dwg";

    public static String copyAssetsFileToSdcard(String sFileName) {
        String dir = getWorkDir();
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            dirFile.mkdir();
        }

        String modelPath = dir + "/" + sFileName;
        File model = new File(modelPath);
        if (model.exists()) {
            return modelPath;
        } else {
            try {
                InputStream in = MyApplication.getContext().getResources().getAssets().open(modelName);
                int length = in.available();
                byte[] buffer = new byte[length];
                in.read(buffer);
                OutputStream out = new FileOutputStream(modelPath);
                out.write(buffer);
                out.flush();
                out.close();
                in.close();
            } catch (IOException var11) {
                var11.printStackTrace();
            }

            return modelPath;
        }
    }

    public static String getWorkDir() {
        if (m_sWorkDir == null) {
            m_sWorkDir = Environment.getExternalStorageDirectory() + "/MxDraw";
        }
        return m_sWorkDir;
    }
}
