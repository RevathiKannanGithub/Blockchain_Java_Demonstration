import java.util.Date;
import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

public class Block implements Serializable{
	// Hash of this block
	String blockHash;
	// Hash of previous block
	String previousBlockHash;
	// Nonce for this block that satisfies POW
	long nonce = 0;
	// Static difficulty for demonstration
	int difficulty;
	// Block number
	int blockHeight;
	// Transaction list
	ArrayList<Transaction> transactions;
	// Timestamp when block was created before POW, for simplicity this is included in the block header
	Date timestamp;
	// Merkle root here is simply SHA256(transactionlistobject)
	String merkleRoot;
	
	public Block(String previousBlockHash, int blockHeight, int difficulty, ArrayList<Transaction> transactions) throws NoSuchAlgorithmException, IOException {
		this.previousBlockHash = previousBlockHash;
		this.blockHeight = blockHeight;
		this.difficulty = difficulty;
		this.transactions = new ArrayList<Transaction>(transactions);
		timestamp = new Date();
		merkleRoot = SHA256.getHash(this.transactions);
	}
	
	// Pretty print this blocks' data
    @Override
    public String toString() {
        String printBlock = "\n-----------------------------------------------Block " + this.blockHeight + "-----------------------------------------------------------------\n";
        printBlock += "\nBlock Hash = " + this.blockHash;
        printBlock += "\nPrevious Block Hash = " + this.previousBlockHash;
        printBlock += "\nMerkle Root = " + this.merkleRoot;
        printBlock += "\nTimestamp = " + this.timestamp;
        printBlock += "\nNonce = " + this.nonce;
        printBlock += "\nDifficulty = " + this.difficulty;
        for(int i = 0; i < this.transactions.size(); i++){
            printBlock += "\nTransaction " + i + " : " + this.transactions.get(i).toString();
        }
        printBlock += "\n-------------------------------------------------END--------------------------------------------------------------------\n";
        return printBlock;
    }
    
    // Getters/Setters
	
	public void setBlockHash() throws NoSuchAlgorithmException, IOException {
		// Set block hash after POW and nonce is found
		this.blockHash = SHA256.getHash(this);
	}

	public String getPreviousBlockHash() {
		return previousBlockHash;
	}

	public int getDifficulty() {
		return difficulty;
	}
	
	public void setNonce(long nonce) {
		this.nonce = nonce;
	}

	public int getBlockHeight() {
		return blockHeight;
	}

	public String getMerkleRoot() {
		return merkleRoot;
	}

	public String getBlockHash() {
		return this.blockHash;
	}

	public String getTimestamp() {
		return this.timestamp.toString();
	}

	public long getNonce() {
		return this.nonce;
	}
}
