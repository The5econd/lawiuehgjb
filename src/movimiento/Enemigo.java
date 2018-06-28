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
    private int x;
    private int y;
    public Enemigo() {}

    public Enemigo(int limite, JLabel ball, int x, int y) {
        this.limite = limite;
        this.ball = ball;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        while(true){
            for (int i = x; i <= this.limite; i += 10) {
                this.ball.setLocation(i, y);
                try {
                    sleep(75);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
            }
            for (int i = this.limite; i >= x; i -= 10) {
                this.ball.setLocation(i, y);
                try {
                    sleep(75);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
            }
            yield();
        }
    }
}
