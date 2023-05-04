package com.osds.bookstorebackend.other;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.2.
 */
@SuppressWarnings("rawtypes")
public class ProductAuthenticity extends Contract {
    public static final String BINARY = "{\n"
            + "\t\"functionDebugData\": {},\n"
            + "\t\"generatedSources\": [],\n"
            + "\t\"linkReferences\": {},\n"
            + "\t\"object\": \"608060405234801561001057600080fd5b5061020d806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c80632da7e031146100465780639ce72b1414610076578063a7706a25146100a6575b600080fd5b610060600480360381019061005b9190610174565b6100c2565b60405161006d91906101bc565b60405180910390f35b610090600480360381019061008b9190610174565b6100eb565b60405161009d91906101bc565b60405180910390f35b6100c060048036038101906100bb9190610174565b61010b565b005b600080600083815260200190815260200160002060009054906101000a900460ff169050919050565b60006020528060005260406000206000915054906101000a900460ff1681565b600160008083815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b600080fd5b6000819050919050565b6101518161013e565b811461015c57600080fd5b50565b60008135905061016e81610148565b92915050565b60006020828403121561018a57610189610139565b5b60006101988482850161015f565b91505092915050565b60008115159050919050565b6101b6816101a1565b82525050565b60006020820190506101d160008301846101ad565b9291505056fea2646970667358221220ce9ac4ae02c19739ea8a6d643e3ac14449d3732d0550336b2a23509807d6511a64736f6c63430008120033\",\n"
            + "\t\"opcodes\": \"PUSH1 0x80 PUSH1 0x40 MSTORE CALLVALUE DUP1 ISZERO PUSH2 0x10 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x20D DUP1 PUSH2 0x20 PUSH1 0x0 CODECOPY PUSH1 0x0 RETURN INVALID PUSH1 0x80 PUSH1 0x40 MSTORE CALLVALUE DUP1 ISZERO PUSH2 0x10 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH1 0x4 CALLDATASIZE LT PUSH2 0x41 JUMPI PUSH1 0x0 CALLDATALOAD PUSH1 0xE0 SHR DUP1 PUSH4 0x2DA7E031 EQ PUSH2 0x46 JUMPI DUP1 PUSH4 0x9CE72B14 EQ PUSH2 0x76 JUMPI DUP1 PUSH4 0xA7706A25 EQ PUSH2 0xA6 JUMPI JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x60 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x5B SWAP2 SWAP1 PUSH2 0x174 JUMP JUMPDEST PUSH2 0xC2 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x6D SWAP2 SWAP1 PUSH2 0x1BC JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x90 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x8B SWAP2 SWAP1 PUSH2 0x174 JUMP JUMPDEST PUSH2 0xEB JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x9D SWAP2 SWAP1 PUSH2 0x1BC JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0xC0 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0xBB SWAP2 SWAP1 PUSH2 0x174 JUMP JUMPDEST PUSH2 0x10B JUMP JUMPDEST STOP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x0 DUP4 DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 MSTORE DUP1 PUSH1 0x0 MSTORE PUSH1 0x40 PUSH1 0x0 KECCAK256 PUSH1 0x0 SWAP2 POP SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND DUP2 JUMP JUMPDEST PUSH1 0x1 PUSH1 0x0 DUP1 DUP4 DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH1 0xFF MUL NOT AND SWAP1 DUP4 ISZERO ISZERO MUL OR SWAP1 SSTORE POP POP JUMP JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0x151 DUP2 PUSH2 0x13E JUMP JUMPDEST DUP2 EQ PUSH2 0x15C JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP JUMPDEST PUSH1 0x0 DUP2 CALLDATALOAD SWAP1 POP PUSH2 0x16E DUP2 PUSH2 0x148 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 DUP5 SUB SLT ISZERO PUSH2 0x18A JUMPI PUSH2 0x189 PUSH2 0x139 JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x198 DUP5 DUP3 DUP6 ADD PUSH2 0x15F JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 ISZERO ISZERO SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0x1B6 DUP2 PUSH2 0x1A1 JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x1D1 PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x1AD JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP INVALID LOG2 PUSH5 0x6970667358 0x22 SLT KECCAK256 0xCE SWAP11 0xC4 0xAE MUL 0xC1 SWAP8 CODECOPY 0xEA DUP11 PUSH14 0x643E3AC14449D3732D0550336B2A 0x23 POP SWAP9 SMOD 0xD6 MLOAD BYTE PUSH5 0x736F6C6343 STOP ADDMOD SLT STOP CALLER \",\n"
            + "\t\"sourceMap\": \"57:347:0:-:0;;;;;;;;;;;;;;;;;;;\"\n"
            + "}";

    public static final String FUNC_ISPRODUCTAUTHENTIC = "isProductAuthentic";

    public static final String FUNC_ISPRODUCTMARKEDASAUTHENTIC = "isProductMarkedAsAuthentic";

    public static final String FUNC_MARKPRODUCTASAUTHENTIC = "markProductAsAuthentic";

    @Deprecated
    protected ProductAuthenticity(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ProductAuthenticity(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ProductAuthenticity(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ProductAuthenticity(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> isProductAuthentic(BigInteger param0) {
        final Function function = new Function(FUNC_ISPRODUCTAUTHENTIC, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isProductMarkedAsAuthentic(BigInteger productId) {
        final Function function = new Function(FUNC_ISPRODUCTMARKEDASAUTHENTIC, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(productId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> markProductAsAuthentic(BigInteger productId) {
        final Function function = new Function(
                FUNC_MARKPRODUCTASAUTHENTIC, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(productId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ProductAuthenticity load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProductAuthenticity(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ProductAuthenticity load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProductAuthenticity(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ProductAuthenticity load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ProductAuthenticity(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ProductAuthenticity load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ProductAuthenticity(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ProductAuthenticity> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ProductAuthenticity.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ProductAuthenticity> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ProductAuthenticity.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ProductAuthenticity> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ProductAuthenticity.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ProductAuthenticity> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ProductAuthenticity.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
