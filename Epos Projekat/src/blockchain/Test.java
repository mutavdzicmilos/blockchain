package blockchain;

import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class Test {

	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int tezina =4;

	public static void main(String[] args) {

		blockchain.add(new Block("Jokic je video projekat ", "0"));
		System.out.println("Majnujem prvi blok");
		blockchain.get(0).majnovanje(tezina);

		blockchain.add(new Block("Jokic je dao Aleksandri Krstajic max", blockchain.get(blockchain.size() - 1).kljucnovi));
		System.out.println("Majnujem drugi blok");
		blockchain.get(1).majnovanje(tezina);

		blockchain.add(new Block("Jokic je dao Lazaru Knezevicu max", blockchain.get(blockchain.size() - 1).kljucnovi));
		System.out.println("Majnujem treci blok");
		blockchain.get(2).majnovanje(tezina);

		blockchain.add(new Block("Jokic je dao Milosu Mutavdzicu max", blockchain.get(blockchain.size() - 1).kljucnovi));
		System.out.println("Majnujem cetvrti blok");
		blockchain.get(2).majnovanje(tezina);
		//formatiranje u Json
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nLanac koji pamtim: ");
		System.out.println(blockchainJson);
	}

}