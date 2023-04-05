package controller;

import java.util.concurrent.Semaphore;

public class Exercicio01 extends Thread {

	private int id;
	private Semaphore semaforo;
	
	public Exercicio01(int id, Semaphore semaforo) {
		this.id=id;
		this.semaforo=semaforo;
		
	}
	@Override
	public void run() {
		classifica();
	}
	private void classifica() { 
		if(id % 3 == 1) {
			for(int i = 0; i < 2; i++) { 
				calculos(200,800);
				transaçaoBD(1000);
				
			}
		}else if(id % 3 == 2) { 
			for(int i=0; i<3;i++) {
				
				calculos(500,1000);
				transaçaoBD(1500); 
			}
		}else if(id%3==0) {
			for(int i=0; i<2;i++) 
			{
				calculos(1000,1000);
				transaçaoBD(1500); 
			}
		}
	}
		
	private void calculos(int i, int j) { /// i = transaçaoBD; j = calculos
		
        int t = (int) (Math.random() * (i - j) + j);  // vai subtrair o valor do transaçaoBD com calculos,  depois somar mais o Calculos
       
        System.out.println("Thread " + id + " fazendo os calculos para " + t + " segundos");
      
        try {
            Thread.sleep(t * 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	private void transaçaoBD(int i) {
		
		 int t = (int) (Math.random() * (i - MIN_PRIORITY) + MAX_PRIORITY); //Primeiro subtrai o valor da transbd com o tempo minimo da thread, o resultado soma com o valor maximo da thread e multiplica no random 
	      
		 System.out.println("Thread " + id + " fazendo as transacao para " + t + " segundos");
	      
		 try {
	            semaforo.acquire();
	            
	            System.err.println("Thread " + id + " tem semaforo BD");
	           
	            Thread.sleep(t * 1); 
	            
	            System.err.println("Thread " + id + " lançado semaforo BD");
	            semaforo.release();
	     } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
		
	}

