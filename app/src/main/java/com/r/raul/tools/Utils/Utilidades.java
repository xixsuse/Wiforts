package com.r.raul.tools.Utils;

import android.content.Context;
import android.os.Vibrator;

import com.r.raul.tools.Inspector.Machine;
import com.r.raul.tools.Ports.Puerto;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Utilidades {

    public static void lanzaVibracion(Context mContext, int time) {
        Vibrator v = (Vibrator) mContext
                .getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(time);
    }

    public static Future<Puerto> portIsOpen(final ExecutorService es, final String ip, final int puertoTratar, final int timeOut) {

        return es.submit(new Callable<Puerto>() {
            @Override
            public Puerto call() {
                // tratamiento
                try {
                    Socket socket = new Socket();
                    socket.setPerformancePreferences(1, 0, 0);
                	socket.setTcpNoDelay(true);
                    if (timeOut == 0) {
                        socket.connect(new InetSocketAddress(ip, puertoTratar));
                    } else {
                        socket.connect(new InetSocketAddress(ip, puertoTratar), timeOut);
                    }
                    socket.close();
                   // LogUtils.LOGI("Puerto: " + puertoTratar + " Abierto");
                    return new Puerto(puertoTratar, 0);
                } catch (SocketTimeoutException exTime) {
                   // LogUtils.LOGI("Puerto: " + puertoTratar + " TimeOut");
                    return new Puerto(puertoTratar, 2);
                } catch (Exception ex) {
                   // LogUtils.LOGI("Puerto: " + puertoTratar + " Cerrado");
                    return new Puerto(puertoTratar, 1);
                }

            }
        });

    }

}
