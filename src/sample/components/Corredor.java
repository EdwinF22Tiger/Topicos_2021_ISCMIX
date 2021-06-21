package sample.components;


import javafx.scene.control.ProgressBar;

public class Corredor extends Thread{


private  ProgressBar progressBar ;
        public Corredor(String nombre , ProgressBar progressBar) {
            super(nombre);
            this.progressBar = progressBar ;
           // this.setName(nombre );


        }



       /* @Override
        public void run() {
            super.run();
            System.out.println("inicia el corredor"+getName());
            for (int i=0 ;i<5 ; i++){

                try {
                    sleep((long)(Math.random()*10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("corredor "+getName()+"completo el km "+i);
            }
            System.out.println("llega a la meta el corredor "+getName()
            );
        }
    }*/
public void run (){

 super.run();
 double avance =0;
 while (avance < 1){
     avance += Math.random()/10;
     this.progressBar.setProgress(avance);
     try{ sleep((long)(Math.random()*1000));


 } catch (InterruptedException e) {
         e.printStackTrace();
     }
 }
}
}
