package view;

import java.util.concurrent.Semaphore;

import controller.Exercicio01;

public class Principal {
	
public static void main(String[] args) {
	
	int id, permissoes=1; 
	
	Semaphore semaforo = new Semaphore(permissoes);
	
	for(id = 1; id < 22; id++) {
		Exercicio01 t = new Exercicio01(id,semaforo); 
		t.start();
	}
}


}
