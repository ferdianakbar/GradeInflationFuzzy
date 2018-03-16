/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mosi;

/**
 *
 * @author root
 */
public class Fuzzy {
    
    private double ipk, rta, ipkRendah, ipkTinggi;
    private String layak;
    private double rtaTinggi,rtaRendah;
    private double z;

    public Fuzzy(double ipk, double rta) {
        this.ipk = ipk;
        this.rta = rta;
        calIpkRendah();
        calIpkTinggi();
        calRataRendah();
        calRataTinggi();
        infrensi();
    }

    
    /**
     * Fuzzyfikasi
     *Keanggotaan IPK
     */
    public void calIpkRendah(){
        double a=3,b=4;
        if (this.ipk<=a){
            this.ipkRendah=1;
        }else if (this.ipk>b){
            this.ipkRendah=0;
        }else{
	this.ipkRendah=(b-this.ipk)/(b-a);
        }
    }
    public void calIpkTinggi(){
        double a=3,b=4;
        if (this.ipk<=a){
            this.ipkTinggi=0;
        }else if (this.ipk>b){
            this.ipkTinggi=1;
        }else{
	this.ipkTinggi=(this.ipk-3)/(b-a);
        }
    }
    /**
     * Keanggotaan Rata 
     */
    public void calRataRendah(){
        double a=2.75,b=4;
       if (this.rta<=a){
            this.rtaRendah=1;
        }else if (this.rta>b){
            this.rtaRendah=0;
        }else{
            this.rtaRendah=(4-this.rta)/(b-a);
        }
    }
    public void calRataTinggi(){
        double a=2.75,b=4;
        if (this.rta<=a){
            this.rtaTinggi=0;
        }else if (this.rta>b){
            this.rtaTinggi=1;
        }else{
            this.rtaTinggi=(this.rta-2.75)/(b-a);
        }
    }
    
    /**
     * infrensi
     */
    public void infrensi(){
        double a0,a1,a2,a3,z0,z1,z2,z3;
        
        
        /**
         * infrensi
         * if ipk rendah and rata rendah then tidak layak
         */
       
        a0 = Math.min(ipkRendah, rtaRendah);
        z0=50-a0*(50-30);
        /**
         * if ipk rendah and rata tinggi then tidak layak
         */
       
        a1 = Math.min(ipkRendah, rtaTinggi);
        z1=74-a1*(74-51);
        /**
         * if ipk Tinggi and rata rendah then layak
         */
        a2 = Math.min(ipkTinggi, rtaRendah);
        z2=84-a2*(84-75);
        /**
         * if ipk Tinggi and rata tinggi then layak
         */
        a3 = Math.min(ipkTinggi, rtaTinggi);
        z3=100-a3*(100-85);
        
  //      System.out.println(a0+"  "+a1+"  "+a2+"  "+a3);
//        System.out.println(z0+"  "+z1+"  "+z2+"  "+z3);
        
        /**
         * defuzzyfikasi
         */
        this.z = ((z0*a0)+(z1*a1)+(z2*a2)+(z3*a3))/(a0+a2+a1+a3);
        /**
        System.out.println(this.rta+"   "+a0+"  "+a1+"  "+a2+"  "+a3);
        System.out.println(z0+"and"+z1+"and"+z2+"and"+z3);
        System.out.println(ipkRendah+","+ipkTinggi+","+rtaRendah+","+rtaTinggi);
        **/
    }
    
    public double bobot(){
        return z;
    }
}
