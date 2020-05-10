package co.edu.javeriana.cotimiddleware.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public final class ObjectAndByteCovertUtil {
    private static final Logger LOG = LoggerFactory.getLogger(ObjectAndByteCovertUtil.class);

    public static Object ByteToObject(byte[] bytes) {
        LOG.info("Process.method.ByteToObject");
        Object obj = null;
        ByteArrayInputStream bi = null;
        ObjectInputStream oi = null;
        try {
            // bytearray to object
            bi = new ByteArrayInputStream(bytes);
            oi = new ObjectInputStream(bi);
            obj = oi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != bi)
                try {
                    bi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            if (null != oi)
                try {
                    oi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return obj;
    }

    public static byte[] ObjectToByte(Object obj) {
        LOG.info("Process.method.ObjectToByte");
        byte[] bytes = null;
        ByteArrayOutputStream bo = null;
        ObjectOutputStream oo = null;
        try {
            // object to bytearray
            bo = new ByteArrayOutputStream();
            oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);
            bytes = bo.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != bo) {
                try {
                    bo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != oo) {
                try {
                    oo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytes;
    }
}