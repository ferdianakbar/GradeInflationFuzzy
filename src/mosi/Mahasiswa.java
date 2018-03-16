/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mosi;

import java.util.Comparator;

/**
 *
 * @author root
 */
public class Mahasiswa{
    private String nim, kelas, kelayakan;
    private double ipk, rata, nkelayakan;
    private Fuzzy fz;
    private double bobot;

    public Mahasiswa(String nim, String kelas, double ipk, double rata) {
        this.nim = nim;
        this.kelas = kelas;
        this.ipk = ipk;
        this.rata = rata;
        Fuzzy fz= new Fuzzy(ipk,rata);
        this.bobot=fz.bobot();
        setKelayakan();
        
    }

    public String getNim() {
        return nim;
    }

    public String getKelas() {
        return kelas;
    }

    public String getKelayakan() {
        return kelayakan;
    }

    public double getIpk() {
        return ipk;
    }

    public double getRata() {
        return rata;
    }

    public double getNkelayakan() {
        return bobot;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setKelayakan() {
        String layak;
        double pinf = Double.POSITIVE_INFINITY;
        double nan = Double.NaN;
        double ninf = Double.NEGATIVE_INFINITY;
        
        if (this.ipk<=3 && this.nkelayakan<75){
            layak = "TIDAK LAYAK";
        }else{
            layak = "LAYAK";
        }
        this.kelayakan = layak;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    public void setRata(double rata) {
        this.rata = rata;
    }

    public void setNkelayakan(double nkelayakan) {
        this.nkelayakan = nkelayakan;
    }
    
    public String toString(){
        
        return "nim :"+getNim()+"/nKelas"+getKelas()+"/nipk :"+getIpk()+"/nRata-rata Kelas: "+getRata()+"/nBobot:"+this.bobot+"/nKelayakan"+kelayakan;
    }


    public static Comparator<Mahasiswa> ComBobot = new Comparator<Mahasiswa>() {
        @Override
        public int compare(Mahasiswa m1, Mahasiswa m2){
            int com =  Double.compare(m2.getNkelayakan(),m1.getNkelayakan());
 
            return com;
        }
    };
    
}
