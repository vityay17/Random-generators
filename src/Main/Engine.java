package Main;

import java.awt.EventQueue;

import Algorytmy.LCG;

public class Engine {
	private LCG lcg;
	private Histogram histogram;
	private Window window;
	
	public Engine(){
		lcg = new LCG();
	}
	
	public LCG getLcg() {
		return lcg;
	}
		
	public Histogram getHistogram() {
		return histogram;
	}
	
	public Engine getThis(){
		return this;
		
	}
	
	public void startMainWindow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
