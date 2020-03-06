/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.entity;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.WString;
import com.sun.jna.win32.StdCallLibrary;

import javax.jws.Oneway;

/**
 *
 * @author zoudeyong
 */
public class Reader18 {

    /**
     *
     */
    public native int[] OpenComPort(int[]arr);
    public native int[] AutoOpenComPort(int[]arr);
    public native int CloseComPort();
    public native int[] OpenNetPort(int addr,int Port,String IPaddr);
    public native int OpenNetPort(int Port , String IPaddr,  char ComAdr, int  FrmHandle);
    public native int CloseNetPort(int Port);
    public native int CloseSpecComPort(int Frmhandle);
    public native int[] GetReaderInformation(int[]arr);
    public native int SetWGParameter(int[]arr);
    public native int[] ReadActiveModeData(int[]arr);
    public native int SetWorkMode(int[]arr);
    public native int[] GetWorkModeParameter(int[]arr);
    public native int BuzzerAndLEDControl(int[] arr);
    public native int WriteComAdr(int[] arr);
    public native int SetPowerDbm(int[] arr);
    public native int Writedfre(int[] arr);
    public native int Writebaud(int[] arr);
    public native int WriteScanTime(int[] arr);
    public native int SetAccuracy(int[] arr);
    //EPC  G2
    public native int[] Inventory_G2(int[]arr);
    public native int[] ReadCard_G2(int[]arr);
    public native int[] WriteCard_G2(int[]arr);
    public native int[] EraseCard_G2(int[]arr);
    public native int[] SetCardProtect_G2(int[]arr);
    public native int[] DestroyCard_G2(int[]arr);
    public native int[] WriteEPC_G2(int[]arr);
    public native int[] SetReadProtect_G2(int[]arr);
    public native int[] SetMultiReadProtect_G2(int[]arr);
    public native int[] RemoveReadProtect_G2(int[]arr);
    public native int[] CheckReadProtected_G2(int[]arr);
    public native int[] SetEASAlarm_G2(int[]arr);
    public native int[] CheckEASAlarm_G2(int[]arr);
    public native int[] LockUserBlock_G2(int[]arr);
    //18000_6B
    public native int[] Inventory_6B(int[]arr);
    public native int[] inventory2_6B(int[]arr);
    public native int[] ReadCard_6B(int[]arr);
    public native int[] WriteCard_6B(int[]arr);
    public native int[] LockByte_6B(int[]arr);
    public native int[] CheckLock_6B(int[]arr);
    private byte[] ComAddr = new byte[1];//读写器地址
    public int[] CardNum= new int[1];
    int Recv=0;
    public int[] FrmHandle= new int[1];//读写器句柄

    public interface MyCLibrary extends Library {
        MyCLibrary INSTANCE =(MyCLibrary)Native.loadLibrary("UHFReader188",  MyCLibrary.class);
        WString Preprocess(WString inputStr);
        int CloseNetPort(int FrmHandle);
        int  OpenNetPort(int Port , String IPaddr, byte[] ComAdr, int[] FrmHandle);
        int Inventory_G2(byte[] comAddr, int qValue, byte session, byte AdrTID,byte LenTID, byte TIDFlag, byte[] EPClenandEPC,byte[] Totallen,int[] CardNum,int FrmHandle);

           }

    public static void main(String[] args) {
        Reader18 reader18=new Reader18();
        byte[] comm = new byte[1];
        comm[0] = (byte)255;
        int[] Handle = new int[1];
        int result1 = MyCLibrary.INSTANCE.OpenNetPort(6000,"192.168.1.190",comm,Handle);
        if (result1==0){
            reader18.ComAddr=comm;
            reader18.FrmHandle=Handle;
        }
        System.out.println("result =="+result1);


        for (int i=0;i<10000;i++){
            String[]  EPC=reader18.Inventory();
            System.out.println("条码数量"+EPC.length);
            for (int j=0;j<EPC.length;j++){
                System.out.println(EPC[j]);
            }
        }

//        String comAddr="192.168.1.190";  //读写器地址
//        byte[]Ant=new byte[1];
//        int[] PortHandle= new int[1];
//        Reader18 Reader = new Reader18();
//        int result = MyCLibrary.INSTANCE.CloseNetPort(89);
//        System.out.println("result =="+result);
    }

    //询查EPC标签
    public   String[] Inventory()
    {
        CardNum[0]=0;//接收输出的EPC的总数量
        byte[]  StrBuff=new byte[5000];
        byte[] Totallen = new byte[1];//接收输出的EPClenand 字节数量
        CardNum[0]=0;//接收输出的EPC的总数量
        //如果询查TID,TIDFlag变量是1,再设置AdrTID和LenTID
        Recv=MyCLibrary.INSTANCE.Inventory_G2(ComAddr,4,(byte)0,(byte)0,(byte)6,(byte)0,StrBuff,Totallen,CardNum,FrmHandle[0]);
        if ((Recv == 1) | (Recv == 2) | (Recv == 3) | (Recv == 4))//代表已查找结束，
        {
            if(CardNum[0]==0) return null;
            String[] EPC=new String[CardNum[0]];
            int m=0;
            for(int index=0;index<CardNum[0];index++)
            {
                int epclen = StrBuff[m++]&255;
                String EPCstr="";
                byte[]epc = new byte[epclen];
                for(int n=0;n<epclen;n++)
                {
                    byte bbt = StrBuff[m++];
                    epc[n] = bbt;
                    String hex= Integer.toHexString(bbt& 255);
                    if(hex.length()==1)
                    {
                        hex="0"+hex;
                    }
                    EPCstr+=hex;
                }
                int rssi = StrBuff[m++];
                EPC[index] = EPCstr.toUpperCase();
//                System.out.println("标签"+EPCstr.toUpperCase());
            }
            if(CardNum[0]>0)
                return EPC;
        }
        return null;
    }
}
