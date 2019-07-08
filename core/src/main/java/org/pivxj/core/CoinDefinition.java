package org.pivxj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {

    public static final String coinName = "NativeCoin";
    public static final String coinTicker = "N8V";
    public static final String coinURIScheme = "N8V";
    public static final String cryptsyMarketId = "584";
    public static final String cryptsyMarketCurrency = "N8V";
    public static final String PATTERN_PRIVATE_KEY_START_UNCOMPRESSED = "[7]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[X]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;

    public static final String UNSPENT_API_URL = "https://chainz.cryptoid.info/n8v/api.dws?q=unspent";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
    };


    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Cryptoid;

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://explorer.n8v.org/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://test.explorer.n8v.org/";

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(1* 60);  // 24 hours per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(1 * 60);  // 1 minute  per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //36 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 30; //main.h: static const int COINBASE_MATURITY
    public static final long MAX_COINS = 40000000;          //main.h:  MAX_MONEY


    public static final long DEFAULT_MIN_TX_FEE = 10000;   // MIN_TX_FEE
    public static final long DUST_LIMIT = 30000; //main.h CTransaction::GetMinFee        0.01 coins
    public static final long INSTANTX_FEE = 100000;
    public static final boolean feeCanBeRaised = false;

    //
    // N8V 3.1.9
    //
    public static final int PROTOCOL_VERSION = 70915;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70915;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 8848;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 8884;    //protocol.h GetDefaultPort(testnet=true)

    /** LibZerocoin starting block height */
    //todo delete
    public static final long TESTNET_ZEROCOIN_STARTING_BLOCK_HEIGHT = 201564;
    public static final long MAINNET_ZEROCOIN_STARTING_BLOCK_HEIGHT = 863787;

    //high fee required for zerocoin mints
    public static final Coin MIN_ZEROCOIN_MINT_FEE = Coin.CENT;
    //the maximum amount of confirmations until accumulated in 19
    public static final int MINT_REQUIRED_CONFIRMATIONS = 20;
    //The required confirmations for a zpiv to be stakable
    public static final int ZEROCOIN_REQUIRED_STAKE_DEPTH = 200;
    //
    public static final int ZEROCOIN_MAX_SPEND_OUTPUTS = 7;

    //
    //  Production
    //
    public static final int AddressHeader = 53;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 122;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long PacketMagic = 0xc02356a9;

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = 0x1e0ffff0;         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1559461295;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = 1555191;                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "00000b7892e23de3b819bb38f04cd3ff340e48ad7c379822a4ffa2b6a957eb9c";  //main.cpp: hashGenesisBlock
    static public String genesisMerkleRoot = "c0ac20b96c09fcfb9b1955cf77d0e00072e46ebca30e25e773c104bd7c2e3dca";
    static public int genesisBlockValue = 0;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "04ffff001d01044c55552e532e204e657773202620576f726c64205265706f7274204a616e203238203230313620576974682048697320416273656e63652c205472756d7020446f6d696e6174657320416e6f7468657220446562617465";//"04ffff001d01044c5957697265642030392f4a616e2f3230313420546865204772616e64204578706572696d656e7420476f6573204c6976653a204f76657273746f636b2e636f6d204973204e6f7720416363657074696e6720426974636f696e73";   //"limecoin se convertira en una de las monedas mas segura del mercado, checa nuestros avances"
    static public String genesisTxOutBytes = "abaab9327e5b33f265c3aaeb3537b8a989cc09c1692ef106bbfa38f285e15c34";//"040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "seed1.n8vcoin.dev",
            "seed2.n8vcoin.dev",
            "seed3.n8vcoin.dev"
    };

    public static int minBroadcastConnections = 3;   //0 for default; we need more peers.

    //
    // TestNet - PIVX
    //
    public static final boolean supportsTestNet = true;
    public static final int testnetAddressHeader = 35;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 12;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0x84b3a6d9;      //
    public static final String testnetGenesisHash =  "00000819edb34d126fadb7f6582f64de7466cf35ac5546d3852ad4c6f3ba393d";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1559461244L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (44682L);                         //main.cpp: LoadBlockIndex





    //main.cpp GetBlockValue(height, fee)
    public static final Coin GetBlockReward(int height) {
        return Coin.valueOf(5, 0);
    }

    public static int subsidyDecreaseBlockCount = 4730400;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x207fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
            "testnet.seed1.n8vcoin.dev",
            "testnet.seed2.n8vcoin.dev",
            "testnet.seed3.n8vcoin.dev"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "049c6f251a8c2cb50002a1d8d54a5959a685a00833e7362b144db4995fc376df0f0e7441674c50c8e16d294e5fb1b4e7790774f491e743de7a07c348ab3bf0b413";
    public static final String TESTNET_SATOSHI_KEY = "0455049254ed020015f732bdd6e99cfaaaab7119cbfd6c7c093182926e945733d9b3bb4cf775574c123e005380ed5b6c329f20026c95fdb0b2134614a414cff1fe";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "main";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {

//        checkpoints.put(  1500, Sha256Hash.wrap("000000aaf0300f59f49bc3e970bad15c11f961fe2347accffff19d96ec9778e3"));
//        checkpoints.put(  4991, Sha256Hash.wrap("000000003b01809551952460744d5dbb8fcbd6cbae3c220267bf7fa43f837367"));
//        checkpoints.put(  9918, Sha256Hash.wrap("00000000213e229f332c0ffbe34defdaa9e74de87f2d8d1f01af8d121c3c170b"));
//        checkpoints.put( 16912, Sha256Hash.wrap("00000000075c0d10371d55a60634da70f197548dbbfa4123e12abfcbc5738af9"));
//        checkpoints.put( 23912, Sha256Hash.wrap("0000000000335eac6703f3b1732ec8b2f89c3ba3a7889e5767b090556bb9a276"));
//        checkpoints.put( 35457, Sha256Hash.wrap("0000000000b0ae211be59b048df14820475ad0dd53b9ff83b010f71a77342d9f"));
//        checkpoints.put( 45479, Sha256Hash.wrap("000000000063d411655d590590e16960f15ceea4257122ac430c6fbe39fbf02d"));
//        checkpoints.put( 55895, Sha256Hash.wrap("0000000000ae4c53a43639a4ca027282f69da9c67ba951768a20415b6439a2d7"));
//        checkpoints.put( 68899, Sha256Hash.wrap("0000000000194ab4d3d9eeb1f2f792f21bb39ff767cb547fe977640f969d77b7"));
//        checkpoints.put( 74619, Sha256Hash.wrap("000000000011d28f38f05d01650a502cc3f4d0e793fbc26e2a2ca71f07dc3842"));
//        checkpoints.put( 75095, Sha256Hash.wrap("0000000000193d12f6ad352a9996ee58ef8bdc4946818a5fec5ce99c11b87f0d"));
//        checkpoints.put( 88805, Sha256Hash.wrap("00000000001392f1652e9bf45cd8bc79dc60fe935277cd11538565b4a94fa85f"));
//        checkpoints.put( 90544, Sha256Hash.wrap("000000000001b284b79a44a95215d7e6cf9e22cd4f9b562f2cc796e941e0e411"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "XgxDAS6B8iYgEEryemnJrpvoWZ3149MCkK";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "XDtvHyDDFGS3WJvwjxSANCpZiLLkKzoDnjrcRhca2iLQRtGEz1JZ";

}
