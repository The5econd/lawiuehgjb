/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimiento;

import javax.swing.JLabel;

/**
 *
 * @author MaPache
 */
public class Enemigo extends Thread{
    private int limite;
    private JLabel ball;
    private JLabel flecha;
    private int x;
    private int y;
    public Enemigo() {}

    public Enemigo(int limite, JLabel ball, JLabel flecha, int x, int y) {
        this.limite = limite;
        this.ball = ball;
        this.flecha = flecha;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        boolean flag = true;
        while(true){
            for (int i = x; i <= this.limite; i += 10) {
                this.ball.setLocation(i, y);
                float v = (float) Math.sqrt(Math.pow(flecha.getX()-ball.getX(), 2)+Math.pow(flecha.getY()-ball.getY(), 2));
                if(v <= 50){
                    flag = false;
                    break;
                }
                try {
                    sleep(75);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
            }
            if(!flag){
                break;
            }
            for (int i = this.limite; i >= x; i -= 10) {
                this.ball.setLocation(i, y);
                float v = (float) Math.sqrt(Math.pow(flecha.getX()-ball.getX(), 2)+Math.pow(flecha.getY()-ball.getY(), 2));
                if(v <= 50){
                    flag = false;
                    break;
                }
                try {
                    sleep(75);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
            }
            if(!flag){
                break;
            }
            yield();
        }
    }
}
