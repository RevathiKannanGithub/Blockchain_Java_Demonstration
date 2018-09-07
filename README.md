# Blockchain_Java_Demonstration

1. Run `javac *.java` under `\src`
2. Run `java Blockchain`

Purely for demonstration, this simple program assumes transactions to have string inputs/outputs, with no scripts/signing whatsoever. Merkle root is considered to be `SHA256(txlist)` for simplicity. POW hashes block header with a static difficulty.

The goal here is to demonstrate how POW works and how changing this static difficulty affects block time.

## Sample Output - 

```

-----------------------------------------------Block 0-----------------------------------------------------------------

Block Hash = e587903bbba940fe78077682d59ceba52de4311af6125d46e4c4df175cb04a2a
Previous Block Hash = 0
Merkle Root = 94236b28184aff349545c5e8a8a519bbf2bf5cea5a422e573185ef50b0f14d18
Timestamp = Fri Sep 07 10:19:36 IST 2018
Nonce = 0
Difficulty = 0
Transaction 0 : From : null; To : Satoshi Nakomoto; Amount = 50
-------------------------------------------------END--------------------------------------------------------------------

Proof of work complete = 00000bdf084419cadaa6391d8c9f9a315e4360127bfb0d78aeeea69cf9d37835 & nonce = 948049

-----------------------------------------------Block 1-----------------------------------------------------------------

Block Hash = e75a3ca71a0e81b26e5b40b3209a77e210607179f7169d28a57903a5e48d10e5
Previous Block Hash = e587903bbba940fe78077682d59ceba52de4311af6125d46e4c4df175cb04a2a
Merkle Root = c22a7b6136f5189e1a01bbeef0cc5f186d21adc8fb2077df64d89886addc8b5c
Timestamp = Fri Sep 07 10:19:36 IST 2018
Nonce = 948049
Difficulty = 5
Transaction 0 : From : null; To : miner_coinbase; Amount = 50
Transaction 1 : From : g7Jk1NL74HHi7yXsJ3HMNi806N8iA4704C; To : 5i9RM73v68vJCFvAPC7gMNyd7g8LCQo7N4; Amount = 4
Transaction 2 : From : dkoFC1X5NEyEd8HLJUXJg09A6yT2kNH4Jk; To : 7HHZyQPvo4dFvoN7wC6T4JJswwCZ3y31sv; Amount = 2
Transaction 3 : From : RXwU6MX62dsEoLswvU7kk09b4CNNEXPX3s; To : E1oX5NLbRMC2sX933gHi2i1w92Lw88HX2Z; Amount = 5
Transaction 4 : From : 4yoN2dEXdgQX0TZ3Tgk24RF10oQ3M8N5Mi; To : sb5TLPFCvH19Lg49QdAQiCFP7bs8JNXw4R; Amount = 2
-------------------------------------------------END--------------------------------------------------------------------

Proof of work complete = 00000ebe119ed6063da6684295a27352de16c6d4b340145fbc8407a3da566497 & nonce = 443832

-----------------------------------------------Block 2-----------------------------------------------------------------

Block Hash = 6fbfd8d5b337935e03eb399e4e112888d40580f5f3f399ecd463335e25c3a736
Previous Block Hash = e75a3ca71a0e81b26e5b40b3209a77e210607179f7169d28a57903a5e48d10e5
Merkle Root = 6203306476904f0945959016b35bb6d3f01aa283dfa6b4850ac171e05f3564cb
Timestamp = Fri Sep 07 10:19:38 IST 2018
Nonce = 443832
Difficulty = 5
Transaction 0 : From : null; To : miner_coinbase; Amount = 50
Transaction 1 : From : LkPF869F0d59XE8dNLPA0T8bwMgQR47iA5; To : 34QsXsZ4RPPXoL4J71ZJTEw49UR4E5CkT5; Amount = 2
Transaction 2 : From : w6QiENZLFQ5d5UHw5Cs7FbdPEQv3Jso7Cd; To : 3oi2Lo5oU9TQZ124CMJ10yA83Q37JNkQdZ; Amount = 2
Transaction 3 : From : LAo4v42T3N0AZ9PT1RZkNTbTgEoU9b1dw2; To : 0HTUHLgQTEMHdgMFk65sF0HEN5sPiXLHJo; Amount = 2
-------------------------------------------------END--------------------------------------------------------------------

Proof of work complete = 00000abaf46f77d96afa0b908def622a159a5c4bc11720c5861c0bcad05f9cb0 & nonce = 1075807
```
