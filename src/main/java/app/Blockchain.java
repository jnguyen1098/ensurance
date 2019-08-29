package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Blockchain {
	public ArrayList<Block> blockchain;
	
	public Blockchain() {
		this.blockchain = new ArrayList<>();
	}
	
	public Blockchain(String filename) throws IOException {
		this.blockchain = new ArrayList<>();
		
		String line = "";
		BufferedReader br = new BufferedReader(new FileReader(filename));
		while ((line = br.readLine()) != null) {
			String[] fileLine = line.split(",");
			for (int i = 0; i < fileLine.length; i += 3) {
				Block tmpBlock = new Block(fileLine[i], fileLine[i+1], fileLine[i+2]);
				this.blockchain.add(tmpBlock);
			}
		}
		// System.out.println(this.toString());
		br.close();
	}
	
	public void add(Block block) {
		this.blockchain.add(block);
		return;
	}
	
	public boolean addAndCheckUnique(Block block) {
		boolean result = this.blockIsUnique(block);
		this.blockchain.add(block);
		return result;
	}
	
	public boolean blockIsUnique(Block block) {
		Iterator<Block> i = this.blockchain.iterator();
		while (i.hasNext()) {
			Block tmpBlock = i.next();
			if (tmpBlock.claimHash.equals(block.claimHash)) {
				return false;
			}
		}
		return true;
	}
	
	public String getLastHash() {
		String toReturn = null;
		Iterator<Block> i = this.blockchain.iterator();
		while (i.hasNext()) {
			toReturn = i.next().hash();
		}
		return toReturn;
	}
	
	public String toString() {
		Iterator<Block> iter = this.blockchain.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		return "";
	}
        
	
	public String fileOutput() {
		String toReturn = "";
		Iterator<Block> iter = this.blockchain.iterator();
		while (iter.hasNext()) {
			Block tmpBlock = iter.next();
			toReturn += tmpBlock.previousHash + "," + tmpBlock.hash + "," +
			tmpBlock.claimHash + ",";
		}
		toReturn = toReturn.substring(0, toReturn.length() - 1);
		return toReturn;
	}
	
}
