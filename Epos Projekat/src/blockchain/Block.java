package blockchain;

import java.util.Date;

public class Block {
	
	public String kljucnovi;
	public String kljucstari; 
	private String informacija; 
	private long vreme; 
	private int brojilo;
	
	public Block(String informacija,String kljucstari ) {
		this.informacija = informacija;
		this.kljucstari = kljucstari;
		this.vreme = new Date().getTime();
		
		this.kljucnovi = racunajkod(); 
	}
	
	public String racunajkod() {
		String calculatedkljucnovi = HesiranjeKradeno.applySha256( 
				kljucstari +
				Long.toString(vreme) +
				Integer.toString(brojilo) + 
				informacija 
				);
		return calculatedkljucnovi;
	}
	
	public void majnovanje(int difficulty) {
		String target = HesiranjeKradeno.getDificultyString(difficulty); 
		while(!kljucnovi.substring( 0, difficulty).equals(target)) {
			brojilo ++;
			kljucnovi = racunajkod();
		}
		System.out.println("Block Mined!!! : " + kljucnovi);
	}
	
}
