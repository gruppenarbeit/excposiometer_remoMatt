/*
package com.example.matthustahli.radarexposimeter;

import android.content.Intent;

import java.util.Arrays;

import static java.lang.Thread.sleep;

*/
/**
 * Created by Remo on 20.10.2016.
 *//*

public class DetailView_Activity extends Activity_Superclass{

    Thread thread;
    private double[] Peak;
    private double[] RMS;
    private int[] freq_request;
    WifiDataBuffer buffer;
    Activity_Superclass Cali_Tables;

    DetailView_Activity(WifiDataBuffer buf, Activity_Superclass cali_tables, final int device_id, final int attenuator, final char measurement_type, int[] frequencies){

        this.buffer = buf;
        this.Cali_Tables = cali_tables;
        double[] array = new double[frequencies.length];
        Arrays.fill(array, 1000);
        Peak = array;
        RMS = array;
        freq_request = frequencies;
        thread = new Thread(){
            public void run(){
                startMeasurement(device_id, attenuator, measurement_type);
            }
        };
        thread.start();
    }



    public void startMeasurement (int device_id, int attenuator, char measurement_type) {

        DetailView_Packet_Trigger triggerClass = new DetailView_Packet_Trigger(device_id,attenuator, freq_request, measurement_type);
        byte[] triggerPacket = triggerClass.get_packet();

        //successful? => test boolean
        buffer.enqueue_ToESP(triggerPacket);

        while(true) {
            while (!buffer.isDataWaiting_FromESP()) {
                try {
                    sleep(10);
                    Build_Packet_Test testpacket = new Build_Packet_Test(56); //packet from exposi
                    buffer.enque_FromESP(testpacket.test_packet);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            byte[] packet_in = buffer.deque_FromESP();

            Data_Packet_Exposi packetExposi = new Data_Packet_Exposi(packet_in);

            int freq = packetExposi.get_frequency();
            int rms_exposi = packetExposi.get_rawData_rms();
            int peak_exposi = packetExposi.get_rawData_peak();

            double rms = Cali_Tables.get_rms(attenuator, freq, rms_exposi);
            double peak = Cali_Tables.get_peak(attenuator, freq, peak_exposi);
            updatePeak(peak, freq);
            updateRMS(rms, freq);
        }
    }


    private synchronized void updatePeak(double newPeak, int freq){
        int i = Arrays.binarySearch(freq_request, freq);
        if (i < Peak.length && i >= 0) Peak[i] = newPeak;
    }

    private synchronized void updateRMS(double newRMS, int freq){
        int i = Arrays.binarySearch(freq_request, freq);
        if (i < RMS.length && i >= 0)RMS[i] = newRMS;
    }

    public synchronized double[] readPeak(){
        return Peak;
    }

    public synchronized double[] readRMS(){
        return RMS;
    }

    public synchronized int[] readFreq(){
        return freq_request;
    }

    public synchronized void stop(){
        thread.stop();
    }

}
*/
