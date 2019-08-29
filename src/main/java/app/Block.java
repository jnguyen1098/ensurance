/* Code adapted from Medium.com 
 * "Creating Your First Blockchain with Java. Part 1." */

package app;

import java.util.Date;

public class Block {
	public String hash;
	public String previousHash;
	public String claimHash;
	public long timestamp;
	
	public Block(Claim claim, String previousHash) {
		this.claimHash = claim.toHash();
		this.previousHash = previousHash;
		this.timestamp = new Date().getTime();
		this.hash = hash();
	}
	
	public Block(Block toCopy) {
		this.claimHash = toCopy.claimHash;
		this.previousHash = toCopy.previousHash;
		this.timestamp = toCopy.timestamp;
		this.hash = toCopy.hash;
	}
	
	public Block(String previousHash, String hash, String claimHash) {
		this.previousHash = previousHash;
		this.hash = hash;
		this.claimHash = claimHash;
	}
	
	public String hash() {
		String toReturn = StringUtil.encode(previousHash +
				Long.toString(timestamp) +
				claimHash.toString()
				);
		
		return toReturn;
	}
	
	public String toString() {
		String toReturn = "";
		
		toReturn += "Previous Hash: " + previousHash + "\n";
		toReturn += "Hash: " + hash + "\n";
		toReturn += "Claim Hash: " + claimHash.toString() + "\n";
		
		return toReturn;
	}
        
}
