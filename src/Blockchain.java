import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Blockchain {
	
	// Calculate SHA256(blockHeader) repeatedly until hash starts with 'difficulty' number of zeroes
	private static String proofOfWork(Block block) throws IOException, NoSuchAlgorithmException {
		// Get current difficulty. Note: Difficulty is set to be static here for demonstration.
		int difficulty = block.getDifficulty();
		// Convert difficulty to a String pattern of 'difficulty' number of zeroes.
		StringBuffer nonceKeyBuffer = new StringBuffer(difficulty);
		for(int i = 0; i < difficulty; i++) {
			nonceKeyBuffer.append("0");
		}
		String nonceKey = nonceKeyBuffer.toString();
		// Start hashing with nonce = 0
		long nonce = 0;
		
		boolean nonceFound = false;
		// Initialize block header hash
		String headerHash = "";
		// For demonstration, consider timestamp, blockheight, merkleroot and previousblockhash = block header
		String message = block.getTimestamp() + block.getBlockHeight() + block.getMerkleRoot() + block.getPreviousBlockHash();

		while (!nonceFound) {
			// Append nonce to block header and hash
			headerHash = SHA256.getHash(message + nonce);
			// Check if hash matches pattern
			nonceFound = headerHash.substring(0, nonceKey.length()).equals(nonceKey);
			// If not, increment nonce and hash again
			nonce++;
		}
		// Update block nonce
		block.setNonce(nonce);
		// Update block hash
		block.setBlockHash();
		return headerHash;
	}
	
	// Alphabet to generate "random" bitcoin address looking strings
	private static final String ALPHA_NUMERIC_STRING = "AbCdEFgHiJkLMNoPQRsTUvwXyZ0123456789";

	// Generate random string with the above alphabet for length = count
	private static String randomString(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		// Define blockchain here
		LinkedList<Block> blockChain = new LinkedList<Block>();
		// Initial transaction list for genesis block
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		// Initialize random for transaction amount and number of transactions
		Random random = new Random();
		// Add a single coinbase transaction to genesis block
		Transaction genesisCoinbase = new Transaction("null", "Satoshi Nakomoto", 50);
		transactions.add(genesisCoinbase);
		// Create genesis block with previousblockhash = 0, blockheight = 0 and difficulty = 0 + single coinbase tx
		Block genesisBlock = new Block("0", 0, 0, transactions);
		genesisBlock.setNonce(0);
		genesisBlock.setBlockHash();
		// Add genesis block to blockchain
		blockChain.add(genesisBlock);
		System.out.println(genesisBlock.toString());
		// Track previous block to instantiate new block
		Block previousBlock = genesisBlock;
		// Set static difficulty here. TODO: Dynamic difficulty to demonstrate blocktime
		int staticDifficulty = 5;
		// Infinite loop
		while(true) {
			// Create random transaction pool
			ArrayList<Transaction> transactionPool = new ArrayList<Transaction>();
			// Add static coinbase transaction to current txlist for demonstration
			transactionPool.add(new Transaction("null", "miner_coinbase", 50));
			// Randomly add 1 - 10 transactions to tx pool
			for(int i = 0; i < random.nextInt(10) + 1; i++) {
				// Create a new transaction with a random from and to address and a random amount between 1 and 5 for simplicity
				transactionPool.add(new Transaction(randomString(34), randomString(34), random.nextInt(5) + 1));
			}
			// Create new block with previous blockhash, current blockheight, static difficulty and the above randomly created txpool
			Block newBlock = new Block(previousBlock.getBlockHash(), previousBlock.getBlockHeight() + 1, staticDifficulty, transactionPool);
			// Calculate POW
			String pow = proofOfWork(newBlock);
			System.out.println("Proof of work complete = " + pow + " & nonce = " + newBlock.getNonce());
			// Update previousBlock 
			previousBlock = newBlock;
			System.out.println(newBlock.toString());
		}

	}
}
