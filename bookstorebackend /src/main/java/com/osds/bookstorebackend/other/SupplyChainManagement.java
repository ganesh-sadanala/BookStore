package com.osds.bookstorebackend.other;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.tx.gas.ContractGasProvider;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;

import org.web3j.protocol.core.methods.request.EthFilter;

import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;


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
public class SupplyChainManagement extends Contract {

    public static final String BINARY = "{\n"
            + "\t\"functionDebugData\": {\n"
            + "\t\t\"@_72\": {\n"
            + "\t\t\t\"entryPoint\": null,\n"
            + "\t\t\t\"id\": 72,\n"
            + "\t\t\t\"parameterSlots\": 1,\n"
            + "\t\t\t\"returnSlots\": 0\n"
            + "\t\t},\n"
            + "\t\t\"abi_decode_t_address_fromMemory\": {\n"
            + "\t\t\t\"entryPoint\": 210,\n"
            + "\t\t\t\"id\": null,\n"
            + "\t\t\t\"parameterSlots\": 2,\n"
            + "\t\t\t\"returnSlots\": 1\n"
            + "\t\t},\n"
            + "\t\t\"abi_decode_tuple_t_address_fromMemory\": {\n"
            + "\t\t\t\"entryPoint\": 233,\n"
            + "\t\t\t\"id\": null,\n"
            + "\t\t\t\"parameterSlots\": 2,\n"
            + "\t\t\t\"returnSlots\": 1\n"
            + "\t\t},\n"
            + "\t\t\"allocate_unbounded\": {\n"
            + "\t\t\t\"entryPoint\": null,\n"
            + "\t\t\t\"id\": null,\n"
            + "\t\t\t\"parameterSlots\": 0,\n"
            + "\t\t\t\"returnSlots\": 1\n"
            + "\t\t},\n"
            + "\t\t\"cleanup_t_address\": {\n"
            + "\t\t\t\"entryPoint\": 164,\n"
            + "\t\t\t\"id\": null,\n"
            + "\t\t\t\"parameterSlots\": 1,\n"
            + "\t\t\t\"returnSlots\": 1\n"
            + "\t\t},\n"
            + "\t\t\"cleanup_t_uint160\": {\n"
            + "\t\t\t\"entryPoint\": 132,\n"
            + "\t\t\t\"id\": null,\n"
            + "\t\t\t\"parameterSlots\": 1,\n"
            + "\t\t\t\"returnSlots\": 1\n"
            + "\t\t},\n"
            + "\t\t\"revert_error_c1322bf8034eace5e0b5c7295db60986aa89aae5e0ea0873e4689e076861a5db\": {\n"
            + "\t\t\t\"entryPoint\": null,\n"
            + "\t\t\t\"id\": null,\n"
            + "\t\t\t\"parameterSlots\": 0,\n"
            + "\t\t\t\"returnSlots\": 0\n"
            + "\t\t},\n"
            + "\t\t\"revert_error_dbdddcbe895c83990c08b3492a0e83918d802a52331272ac6fdb6a7c4aea3b1b\": {\n"
            + "\t\t\t\"entryPoint\": 127,\n"
            + "\t\t\t\"id\": null,\n"
            + "\t\t\t\"parameterSlots\": 0,\n"
            + "\t\t\t\"returnSlots\": 0\n"
            + "\t\t},\n"
            + "\t\t\"validator_revert_t_address\": {\n"
            + "\t\t\t\"entryPoint\": 184,\n"
            + "\t\t\t\"id\": null,\n"
            + "\t\t\t\"parameterSlots\": 1,\n"
            + "\t\t\t\"returnSlots\": 0\n"
            + "\t\t}\n"
            + "\t},\n"
            + "\t\"generatedSources\": [\n"
            + "\t\t{\n"
            + "\t\t\t\"ast\": {\n"
            + "\t\t\t\t\"nodeType\": \"YulBlock\",\n"
            + "\t\t\t\t\"src\": \"0:1199:2\",\n"
            + "\t\t\t\t\"statements\": [\n"
            + "\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\"body\": {\n"
            + "\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\n"
            + "\t\t\t\t\t\t\t\"src\": \"47:35:2\",\n"
            + "\t\t\t\t\t\t\t\"statements\": [\n"
            + "\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulAssignment\",\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"57:19:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\"value\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"73:2:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"64\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"mload\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"67:5:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"67:9:2\"\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"variableNames\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"memPtr\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"57:6:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\"name\": \"allocate_unbounded\",\n"
            + "\t\t\t\t\t\t\"nodeType\": \"YulFunctionDefinition\",\n"
            + "\t\t\t\t\t\t\"returnVariables\": [\n"
            + "\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\"name\": \"memPtr\",\n"
            + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
            + "\t\t\t\t\t\t\t\t\"src\": \"40:6:2\",\n"
            + "\t\t\t\t\t\t\t\t\"type\": \"\"\n"
            + "\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\"src\": \"7:75:2\"\n"
            + "\t\t\t\t\t},\n"
            + "\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\"body\": {\n"
            + "\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\n"
            + "\t\t\t\t\t\t\t\"src\": \"177:28:2\",\n"
            + "\t\t\t\t\t\t\t\"statements\": [\n"
            + "\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\"expression\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"194:1:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"197:1:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"revert\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"187:6:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"187:12:2\"\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulExpressionStatement\",\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"187:12:2\"\n"
            + "\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\"name\": \"revert_error_dbdddcbe895c83990c08b3492a0e83918d802a52331272ac6fdb6a7c4aea3b1b\",\n"
            + "\t\t\t\t\t\t\"nodeType\": \"YulFunctionDefinition\",\n"
            + "\t\t\t\t\t\t\"src\": \"88:117:2\"\n"
            + "\t\t\t\t\t},\n"
            + "\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\"body\": {\n"
            + "\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\n"
            + "\t\t\t\t\t\t\t\"src\": \"300:28:2\",\n"
            + "\t\t\t\t\t\t\t\"statements\": [\n"
            + "\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\"expression\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"317:1:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"320:1:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"revert\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"310:6:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"310:12:2\"\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulExpressionStatement\",\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"310:12:2\"\n"
            + "\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\"name\": \"revert_error_c1322bf8034eace5e0b5c7295db60986aa89aae5e0ea0873e4689e076861a5db\",\n"
            + "\t\t\t\t\t\t\"nodeType\": \"YulFunctionDefinition\",\n"
            + "\t\t\t\t\t\t\"src\": \"211:117:2\"\n"
            + "\t\t\t\t\t},\n"
            + "\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\"body\": {\n"
            + "\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\n"
            + "\t\t\t\t\t\t\t\"src\": \"379:81:2\",\n"
            + "\t\t\t\t\t\t\t\"statements\": [\n"
            + "\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulAssignment\",\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"389:65:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\"value\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"value\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"404:5:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"411:42:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0xffffffffffffffffffffffffffffffffffffffff\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"and\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"400:3:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"400:54:2\"\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"variableNames\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"cleaned\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"389:7:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\"name\": \"cleanup_t_uint160\",\n"
            + "\t\t\t\t\t\t\"nodeType\": \"YulFunctionDefinition\",\n"
            + "\t\t\t\t\t\t\"parameters\": [\n"
            + "\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\"name\": \"value\",\n"
            + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
            + "\t\t\t\t\t\t\t\t\"src\": \"361:5:2\",\n"
            + "\t\t\t\t\t\t\t\t\"type\": \"\"\n"
            + "\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\"returnVariables\": [\n"
            + "\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\"name\": \"cleaned\",\n"
            + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
            + "\t\t\t\t\t\t\t\t\"src\": \"371:7:2\",\n"
            + "\t\t\t\t\t\t\t\t\"type\": \"\"\n"
            + "\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\"src\": \"334:126:2\"\n"
            + "\t\t\t\t\t},\n"
            + "\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\"body\": {\n"
            + "\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\n"
            + "\t\t\t\t\t\t\t\"src\": \"511:51:2\",\n"
            + "\t\t\t\t\t\t\t\"statements\": [\n"
            + "\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulAssignment\",\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"521:35:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\"value\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"value\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"550:5:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"cleanup_t_uint160\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"532:17:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"532:24:2\"\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"variableNames\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"cleaned\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"521:7:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\"name\": \"cleanup_t_address\",\n"
            + "\t\t\t\t\t\t\"nodeType\": \"YulFunctionDefinition\",\n"
            + "\t\t\t\t\t\t\"parameters\": [\n"
            + "\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\"name\": \"value\",\n"
            + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
            + "\t\t\t\t\t\t\t\t\"src\": \"493:5:2\",\n"
            + "\t\t\t\t\t\t\t\t\"type\": \"\"\n"
            + "\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\"returnVariables\": [\n"
            + "\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\"name\": \"cleaned\",\n"
            + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
            + "\t\t\t\t\t\t\t\t\"src\": \"503:7:2\",\n"
            + "\t\t\t\t\t\t\t\t\"type\": \"\"\n"
            + "\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\"src\": \"466:96:2\"\n"
            + "\t\t\t\t\t},\n"
            + "\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\"body\": {\n"
            + "\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\n"
            + "\t\t\t\t\t\t\t\"src\": \"611:79:2\",\n"
            + "\t\t\t\t\t\t\t\"statements\": [\n"
            + "\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\"body\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"668:16:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"statements\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"expression\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"677:1:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"680:1:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"revert\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"670:6:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"670:12:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulExpressionStatement\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"670:12:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"condition\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"value\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"634:5:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"value\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"659:5:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"cleanup_t_address\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"641:17:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"641:24:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"eq\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"631:2:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"631:35:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"iszero\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"624:6:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"624:43:2\"\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIf\",\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"621:63:2\"\n"
            + "\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\"name\": \"validator_revert_t_address\",\n"
            + "\t\t\t\t\t\t\"nodeType\": \"YulFunctionDefinition\",\n"
            + "\t\t\t\t\t\t\"parameters\": [\n"
            + "\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\"name\": \"value\",\n"
            + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
            + "\t\t\t\t\t\t\t\t\"src\": \"604:5:2\",\n"
            + "\t\t\t\t\t\t\t\t\"type\": \"\"\n"
            + "\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\"src\": \"568:122:2\"\n"
            + "\t\t\t\t\t},\n"
            + "\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\"body\": {\n"
            + "\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\n"
            + "\t\t\t\t\t\t\t\"src\": \"759:80:2\",\n"
            + "\t\t\t\t\t\t\t\"statements\": [\n"
            + "\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulAssignment\",\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"769:22:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\"value\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"offset\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"784:6:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"mload\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"778:5:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"778:13:2\"\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"variableNames\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"value\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"769:5:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\"expression\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"value\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"827:5:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"validator_revert_t_address\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"800:26:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"800:33:2\"\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulExpressionStatement\",\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"800:33:2\"\n"
            + "\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\"name\": \"abi_decode_t_address_fromMemory\",\n"
            + "\t\t\t\t\t\t\"nodeType\": \"YulFunctionDefinition\",\n"
            + "\t\t\t\t\t\t\"parameters\": [\n"
            + "\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\"name\": \"offset\",\n"
            + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
            + "\t\t\t\t\t\t\t\t\"src\": \"737:6:2\",\n"
            + "\t\t\t\t\t\t\t\t\"type\": \"\"\n"
            + "\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\"name\": \"end\",\n"
            + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
            + "\t\t\t\t\t\t\t\t\"src\": \"745:3:2\",\n"
            + "\t\t\t\t\t\t\t\t\"type\": \"\"\n"
            + "\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\"returnVariables\": [\n"
            + "\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\"name\": \"value\",\n"
            + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
            + "\t\t\t\t\t\t\t\t\"src\": \"753:5:2\",\n"
            + "\t\t\t\t\t\t\t\t\"type\": \"\"\n"
            + "\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\"src\": \"696:143:2\"\n"
            + "\t\t\t\t\t},\n"
            + "\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\"body\": {\n"
            + "\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\n"
            + "\t\t\t\t\t\t\t\"src\": \"922:274:2\",\n"
            + "\t\t\t\t\t\t\t\"statements\": [\n"
            + "\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\"body\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"968:83:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"statements\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"expression\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"arguments\": [],\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"revert_error_dbdddcbe895c83990c08b3492a0e83918d802a52331272ac6fdb6a7c4aea3b1b\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"970:77:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"970:79:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulExpressionStatement\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"970:79:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"condition\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"dataEnd\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"943:7:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"headStart\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"952:9:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"sub\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"939:3:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"939:23:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"964:2:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"32\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"slt\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"935:3:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"935:32:2\"\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIf\",\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"932:119:2\"\n"
            + "\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"1061:128:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\"statements\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulVariableDeclaration\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"1076:15:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"value\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"1090:1:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"variables\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"offset\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"1080:6:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulAssignment\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"1105:74:2\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"value\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"headStart\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"1151:9:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"offset\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"1162:6:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"add\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"1147:3:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"1147:22:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"dataEnd\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"1171:7:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"abi_decode_t_address_fromMemory\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"1115:31:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"1115:64:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"variableNames\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"value0\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"1105:6:2\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\"name\": \"abi_decode_tuple_t_address_fromMemory\",\n"
            + "\t\t\t\t\t\t\"nodeType\": \"YulFunctionDefinition\",\n"
            + "\t\t\t\t\t\t\"parameters\": [\n"
            + "\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\"name\": \"headStart\",\n"
            + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
            + "\t\t\t\t\t\t\t\t\"src\": \"892:9:2\",\n"
            + "\t\t\t\t\t\t\t\t\"type\": \"\"\n"
            + "\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\"name\": \"dataEnd\",\n"
            + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
            + "\t\t\t\t\t\t\t\t\"src\": \"903:7:2\",\n"
            + "\t\t\t\t\t\t\t\t\"type\": \"\"\n"
            + "\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\"returnVariables\": [\n"
            + "\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\"name\": \"value0\",\n"
            + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
            + "\t\t\t\t\t\t\t\t\"src\": \"915:6:2\",\n"
            + "\t\t\t\t\t\t\t\t\"type\": \"\"\n"
            + "\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\"src\": \"845:351:2\"\n"
            + "\t\t\t\t\t}\n"
            + "\t\t\t\t]\n"
            + "\t\t\t},\n"
            + "\t\t\t\"contents\": \"{\\n\\n    function allocate_unbounded() -> memPtr {\\n        memPtr := mload(64)\\n    }\\n\\n    function revert_error_dbdddcbe895c83990c08b3492a0e83918d802a52331272ac6fdb6a7c4aea3b1b() {\\n        revert(0, 0)\\n    }\\n\\n    function revert_error_c1322bf8034eace5e0b5c7295db60986aa89aae5e0ea0873e4689e076861a5db() {\\n        revert(0, 0)\\n    }\\n\\n    function cleanup_t_uint160(value) -> cleaned {\\n        cleaned := and(value, 0xffffffffffffffffffffffffffffffffffffffff)\\n    }\\n\\n    function cleanup_t_address(value) -> cleaned {\\n        cleaned := cleanup_t_uint160(value)\\n    }\\n\\n    function validator_revert_t_address(value) {\\n        if iszero(eq(value, cleanup_t_address(value))) { revert(0, 0) }\\n    }\\n\\n    function abi_decode_t_address_fromMemory(offset, end) -> value {\\n        value := mload(offset)\\n        validator_revert_t_address(value)\\n    }\\n\\n    function abi_decode_tuple_t_address_fromMemory(headStart, dataEnd) -> value0 {\\n        if slt(sub(dataEnd, headStart), 32) { revert_error_dbdddcbe895c83990c08b3492a0e83918d802a52331272ac6fdb6a7c4aea3b1b() }\\n\\n        {\\n\\n            let offset := 0\\n\\n            value0 := abi_decode_t_address_fromMemory(add(headStart, offset), dataEnd)\\n        }\\n\\n    }\\n\\n}\\n\",\n"
            + "\t\t\t\"id\": 2,\n"
            + "\t\t\t\"language\": \"Yul\",\n"
            + "\t\t\t\"name\": \"#utility.yul\"\n"
            + "\t\t}\n"
            + "\t],\n"
            + "\t\"linkReferences\": {},\n"
            + "\t\"object\": \"60806040523480156200001157600080fd5b50604051620018e9380380620018e98339818101604052810190620000379190620000e9565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550506200011b565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000620000b18262000084565b9050919050565b620000c381620000a4565b8114620000cf57600080fd5b50565b600081519050620000e381620000b8565b92915050565b6000602082840312156200010257620001016200007f565b5b60006200011284828501620000d2565b91505092915050565b6117be806200012b6000396000f3fe608060405234801561001057600080fd5b50600436106100935760003560e01c8063492deb1511610066578063492deb151461011e5780637acc0b201461013a5780637efccd111461016e578063a7706a251461019e578063c897d5a6146101ba57610093565b80632927d1d91461009857806329d78328146100b45780632da7e031146100d0578063334d70ca14610100575b600080fd5b6100b260048036038101906100ad9190610bb2565b6101d8565b005b6100ce60048036038101906100c99190610bb2565b61036d565b005b6100ea60048036038101906100e59190610bb2565b610470565b6040516100f79190610bfa565b60405180910390f35b610108610515565b6040516101159190610c94565b60405180910390f35b61013860048036038101906101339190610bb2565b61053b565b005b610154600480360381019061014f9190610bb2565b6106d1565b604051610165959493929190610de6565b60405180910390f35b61018860048036038101906101839190610f75565b6107c9565b6040516101959190610fd1565b60405180910390f35b6101b860048036038101906101b39190610bb2565b610995565b005b6101c2610b62565b6040516101cf9190610fd1565b60405180910390f35b600080600083815260200190815260200160002090506000600381111561020257610201610d6f565b5b8160030160009054906101000a900460ff16600381111561022657610225610d6f565b5b14610266576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161025d9061105e565b60405180910390fd5b3373ffffffffffffffffffffffffffffffffffffffff168160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16146102f8576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016102ef906110f0565b60405180910390fd5b60018160030160006101000a81548160ff021916908360038111156103205761031f610d6f565b5b02179055503373ffffffffffffffffffffffffffffffffffffffff16827f8e4a7d4c074e0429c8218617269577bebe92d664dba0a99330d36a7460b5a62460405160405180910390a35050565b600080600083815260200190815260200160002090506001600381111561039757610396610d6f565b5b8160030160009054906101000a900460ff1660038111156103bb576103ba610d6f565b5b146103fb576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016103f29061115c565b60405180910390fd5b60028160030160006101000a81548160ff0219169083600381111561042357610422610d6f565b5b02179055503373ffffffffffffffffffffffffffffffffffffffff16827f7eb38f83fec1bdc45e831c15e9e3eb2369028929a0e38e3709b7e710362f823b60405160405180910390a35050565b6000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632da7e031836040518263ffffffff1660e01b81526004016104cd9190610fd1565b602060405180830381865afa1580156104ea573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061050e91906111a8565b9050919050565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600083815260200190815260200160002090506002600381111561056557610564610d6f565b5b8160030160009054906101000a900460ff16600381111561058957610588610d6f565b5b146105c9576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016105c090611247565b60405180910390fd5b600115158160030160019054906101000a900460ff16151514610621576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610618906112b3565b60405180910390fd5b60038160030160006101000a81548160ff0219169083600381111561064957610648610d6f565b5b02179055503373ffffffffffffffffffffffffffffffffffffffff168160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16837f512b8749848a8da068ec650563d846ebd78f9ec529354088fca5319736efd3ed60405160405180910390a45050565b60006020528060005260406000206000915090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169080600101805461071a90611302565b80601f016020809104026020016040519081016040528092919081815260200182805461074690611302565b80156107935780601f1061076857610100808354040283529160200191610793565b820191906000526020600020905b81548152906001019060200180831161077657829003601f168201915b5050505050908060020154908060030160009054906101000a900460ff16908060030160019054906101000a900460ff16905085565b600080821161080d576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016108049061137f565b60405180910390fd5b600060016000815480929190610822906113ce565b9190505590506040518060a001604052803373ffffffffffffffffffffffffffffffffffffffff1681526020018581526020018481526020016000600381111561086f5761086e610d6f565b5b81526020016000151581525060008083815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010190816108e991906115b8565b506040820151816002015560608201518160030160006101000a81548160ff0219169083600381111561091f5761091e610d6f565b5b021790555060808201518160030160016101000a81548160ff0219169083151502179055509050503373ffffffffffffffffffffffffffffffffffffffff16817f99e496cee88189ff08b550bb9f3c61e28506f4623c57a7c3811072ced0c8602d60405160405180910390a38091505092915050565b600080600083815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614610a3d576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610a34906116fc565b60405180910390fd5b600380811115610a5057610a4f610d6f565b5b8160030160009054906101000a900460ff166003811115610a7457610a73610d6f565b5b03610ab4576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610aab90611768565b60405180910390fd5b60018160030160016101000a81548160ff021916908315150217905550600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a7706a25836040518263ffffffff1660e01b8152600401610b2c9190610fd1565b600060405180830381600087803b158015610b4657600080fd5b505af1158015610b5a573d6000803e3d6000fd5b505050505050565b60015481565b6000604051905090565b600080fd5b600080fd5b6000819050919050565b610b8f81610b7c565b8114610b9a57600080fd5b50565b600081359050610bac81610b86565b92915050565b600060208284031215610bc857610bc7610b72565b5b6000610bd684828501610b9d565b91505092915050565b60008115159050919050565b610bf481610bdf565b82525050565b6000602082019050610c0f6000830184610beb565b92915050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b6000610c5a610c55610c5084610c15565b610c35565b610c15565b9050919050565b6000610c6c82610c3f565b9050919050565b6000610c7e82610c61565b9050919050565b610c8e81610c73565b82525050565b6000602082019050610ca96000830184610c85565b92915050565b6000610cba82610c15565b9050919050565b610cca81610caf565b82525050565b600081519050919050565b600082825260208201905092915050565b60005b83811015610d0a578082015181840152602081019050610cef565b60008484015250505050565b6000601f19601f8301169050919050565b6000610d3282610cd0565b610d3c8185610cdb565b9350610d4c818560208601610cec565b610d5581610d16565b840191505092915050565b610d6981610b7c565b82525050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602160045260246000fd5b60048110610daf57610dae610d6f565b5b50565b6000819050610dc082610d9e565b919050565b6000610dd082610db2565b9050919050565b610de081610dc5565b82525050565b600060a082019050610dfb6000830188610cc1565b8181036020830152610e0d8187610d27565b9050610e1c6040830186610d60565b610e296060830185610dd7565b610e366080830184610beb565b9695505050505050565b600080fd5b600080fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b610e8282610d16565b810181811067ffffffffffffffff82111715610ea157610ea0610e4a565b5b80604052505050565b6000610eb4610b68565b9050610ec08282610e79565b919050565b600067ffffffffffffffff821115610ee057610edf610e4a565b5b610ee982610d16565b9050602081019050919050565b82818337600083830152505050565b6000610f18610f1384610ec5565b610eaa565b905082815260208101848484011115610f3457610f33610e45565b5b610f3f848285610ef6565b509392505050565b600082601f830112610f5c57610f5b610e40565b5b8135610f6c848260208601610f05565b91505092915050565b60008060408385031215610f8c57610f8b610b72565b5b600083013567ffffffffffffffff811115610faa57610fa9610b77565b5b610fb685828601610f47565b9250506020610fc785828601610b9d565b9150509250929050565b6000602082019050610fe66000830184610d60565b92915050565b7f50726f6475637420686173206e6f74206265656e206d616e756661637475726560008201527f6420796574000000000000000000000000000000000000000000000000000000602082015250565b6000611048602583610cdb565b915061105382610fec565b604082019050919050565b600060208201905081810360008301526110778161103b565b9050919050565b7f4f6e6c79206d616e7566616374757265722063616e207368697020746865207060008201527f726f647563740000000000000000000000000000000000000000000000000000602082015250565b60006110da602683610cdb565b91506110e58261107e565b604082019050919050565b60006020820190508181036000830152611109816110cd565b9050919050565b7f50726f6475637420686173206e6f74206265656e207368697070656420796574600082015250565b6000611146602083610cdb565b915061115182611110565b602082019050919050565b6000602082019050818103600083015261117581611139565b9050919050565b61118581610bdf565b811461119057600080fd5b50565b6000815190506111a28161117c565b92915050565b6000602082840312156111be576111bd610b72565b5b60006111cc84828501611193565b91505092915050565b7f50726f6475637420686173206e6f74206265656e20726563656976656420796560008201527f7400000000000000000000000000000000000000000000000000000000000000602082015250565b6000611231602183610cdb565b915061123c826111d5565b604082019050919050565b6000602082019050818103600083015261126081611224565b9050919050565b7f50726f64756374206973206e6f742061757468656e7469630000000000000000600082015250565b600061129d601883610cdb565b91506112a882611267565b602082019050919050565b600060208201905081810360008301526112cc81611290565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b6000600282049050600182168061131a57607f821691505b60208210810361132d5761132c6112d3565b5b50919050565b7f5072696365206d7573742062652067726561746572207468616e203000000000600082015250565b6000611369601c83610cdb565b915061137482611333565b602082019050919050565b600060208201905081810360008301526113988161135c565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b60006113d982610b7c565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff820361140b5761140a61139f565b5b600182019050919050565b60008190508160005260206000209050919050565b60006020601f8301049050919050565b600082821b905092915050565b6000600883026114787fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8261143b565b611482868361143b565b95508019841693508086168417925050509392505050565b60006114b56114b06114ab84610b7c565b610c35565b610b7c565b9050919050565b6000819050919050565b6114cf8361149a565b6114e36114db826114bc565b848454611448565b825550505050565b600090565b6114f86114eb565b6115038184846114c6565b505050565b5b818110156115275761151c6000826114f0565b600181019050611509565b5050565b601f82111561156c5761153d81611416565b6115468461142b565b81016020851015611555578190505b6115696115618561142b565b830182611508565b50505b505050565b600082821c905092915050565b600061158f60001984600802611571565b1980831691505092915050565b60006115a8838361157e565b9150826002028217905092915050565b6115c182610cd0565b67ffffffffffffffff8111156115da576115d9610e4a565b5b6115e48254611302565b6115ef82828561152b565b600060209050601f8311600181146116225760008415611610578287015190505b61161a858261159c565b865550611682565b601f19841661163086611416565b60005b8281101561165857848901518255600182019150602085019450602081019050611633565b868310156116755784890151611671601f89168261157e565b8355505b6001600288020188555050505b505050505050565b7f4f6e6c79206d616e7566616374757265722063616e206d61726b20746865207060008201527f726f647563742061732061757468656e74696300000000000000000000000000602082015250565b60006116e6603383610cdb565b91506116f18261168a565b604082019050919050565b60006020820190508181036000830152611715816116d9565b9050919050565b7f50726f647563742068617320616c7265616479206265656e20736f6c64000000600082015250565b6000611752601d83610cdb565b915061175d8261171c565b602082019050919050565b6000602082019050818103600083015261178181611745565b905091905056fea2646970667358221220f11a5732c0d146cff0e123b7c84e7981bbe37ff351df96fe0bb437384783d57964736f6c63430008120033\",\n"
            + "\t\"opcodes\": \"PUSH1 0x80 PUSH1 0x40 MSTORE CALLVALUE DUP1 ISZERO PUSH3 0x11 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH1 0x40 MLOAD PUSH3 0x18E9 CODESIZE SUB DUP1 PUSH3 0x18E9 DUP4 CODECOPY DUP2 DUP2 ADD PUSH1 0x40 MSTORE DUP2 ADD SWAP1 PUSH3 0x37 SWAP2 SWAP1 PUSH3 0xE9 JUMP JUMPDEST DUP1 PUSH1 0x2 PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF MUL NOT AND SWAP1 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND MUL OR SWAP1 SSTORE POP POP PUSH3 0x11B JUMP JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH1 0x0 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF DUP3 AND SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH3 0xB1 DUP3 PUSH3 0x84 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH3 0xC3 DUP2 PUSH3 0xA4 JUMP JUMPDEST DUP2 EQ PUSH3 0xCF JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP JUMPDEST PUSH1 0x0 DUP2 MLOAD SWAP1 POP PUSH3 0xE3 DUP2 PUSH3 0xB8 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 DUP5 SUB SLT ISZERO PUSH3 0x102 JUMPI PUSH3 0x101 PUSH3 0x7F JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH3 0x112 DUP5 DUP3 DUP6 ADD PUSH3 0xD2 JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH2 0x17BE DUP1 PUSH3 0x12B PUSH1 0x0 CODECOPY PUSH1 0x0 RETURN INVALID PUSH1 0x80 PUSH1 0x40 MSTORE CALLVALUE DUP1 ISZERO PUSH2 0x10 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH1 0x4 CALLDATASIZE LT PUSH2 0x93 JUMPI PUSH1 0x0 CALLDATALOAD PUSH1 0xE0 SHR DUP1 PUSH4 0x492DEB15 GT PUSH2 0x66 JUMPI DUP1 PUSH4 0x492DEB15 EQ PUSH2 0x11E JUMPI DUP1 PUSH4 0x7ACC0B20 EQ PUSH2 0x13A JUMPI DUP1 PUSH4 0x7EFCCD11 EQ PUSH2 0x16E JUMPI DUP1 PUSH4 0xA7706A25 EQ PUSH2 0x19E JUMPI DUP1 PUSH4 0xC897D5A6 EQ PUSH2 0x1BA JUMPI PUSH2 0x93 JUMP JUMPDEST DUP1 PUSH4 0x2927D1D9 EQ PUSH2 0x98 JUMPI DUP1 PUSH4 0x29D78328 EQ PUSH2 0xB4 JUMPI DUP1 PUSH4 0x2DA7E031 EQ PUSH2 0xD0 JUMPI DUP1 PUSH4 0x334D70CA EQ PUSH2 0x100 JUMPI JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0xB2 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0xAD SWAP2 SWAP1 PUSH2 0xBB2 JUMP JUMPDEST PUSH2 0x1D8 JUMP JUMPDEST STOP JUMPDEST PUSH2 0xCE PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0xC9 SWAP2 SWAP1 PUSH2 0xBB2 JUMP JUMPDEST PUSH2 0x36D JUMP JUMPDEST STOP JUMPDEST PUSH2 0xEA PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0xE5 SWAP2 SWAP1 PUSH2 0xBB2 JUMP JUMPDEST PUSH2 0x470 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0xF7 SWAP2 SWAP1 PUSH2 0xBFA JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x108 PUSH2 0x515 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x115 SWAP2 SWAP1 PUSH2 0xC94 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x138 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x133 SWAP2 SWAP1 PUSH2 0xBB2 JUMP JUMPDEST PUSH2 0x53B JUMP JUMPDEST STOP JUMPDEST PUSH2 0x154 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x14F SWAP2 SWAP1 PUSH2 0xBB2 JUMP JUMPDEST PUSH2 0x6D1 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x165 SWAP6 SWAP5 SWAP4 SWAP3 SWAP2 SWAP1 PUSH2 0xDE6 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x188 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x183 SWAP2 SWAP1 PUSH2 0xF75 JUMP JUMPDEST PUSH2 0x7C9 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x195 SWAP2 SWAP1 PUSH2 0xFD1 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x1B8 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x1B3 SWAP2 SWAP1 PUSH2 0xBB2 JUMP JUMPDEST PUSH2 0x995 JUMP JUMPDEST STOP JUMPDEST PUSH2 0x1C2 PUSH2 0xB62 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x1CF SWAP2 SWAP1 PUSH2 0xFD1 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x0 DUP4 DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SWAP1 POP PUSH1 0x0 PUSH1 0x3 DUP2 GT ISZERO PUSH2 0x202 JUMPI PUSH2 0x201 PUSH2 0xD6F JUMP JUMPDEST JUMPDEST DUP2 PUSH1 0x3 ADD PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND PUSH1 0x3 DUP2 GT ISZERO PUSH2 0x226 JUMPI PUSH2 0x225 PUSH2 0xD6F JUMP JUMPDEST JUMPDEST EQ PUSH2 0x266 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x25D SWAP1 PUSH2 0x105E JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 PUSH1 0x0 ADD PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND EQ PUSH2 0x2F8 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x2EF SWAP1 PUSH2 0x10F0 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x1 DUP2 PUSH1 0x3 ADD PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH1 0xFF MUL NOT AND SWAP1 DUP4 PUSH1 0x3 DUP2 GT ISZERO PUSH2 0x320 JUMPI PUSH2 0x31F PUSH2 0xD6F JUMP JUMPDEST JUMPDEST MUL OR SWAP1 SSTORE POP CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP3 PUSH32 0x8E4A7D4C074E0429C8218617269577BEBE92D664DBA0A99330D36A7460B5A624 PUSH1 0x40 MLOAD PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 LOG3 POP POP JUMP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x0 DUP4 DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SWAP1 POP PUSH1 0x1 PUSH1 0x3 DUP2 GT ISZERO PUSH2 0x397 JUMPI PUSH2 0x396 PUSH2 0xD6F JUMP JUMPDEST JUMPDEST DUP2 PUSH1 0x3 ADD PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND PUSH1 0x3 DUP2 GT ISZERO PUSH2 0x3BB JUMPI PUSH2 0x3BA PUSH2 0xD6F JUMP JUMPDEST JUMPDEST EQ PUSH2 0x3FB JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x3F2 SWAP1 PUSH2 0x115C JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x2 DUP2 PUSH1 0x3 ADD PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH1 0xFF MUL NOT AND SWAP1 DUP4 PUSH1 0x3 DUP2 GT ISZERO PUSH2 0x423 JUMPI PUSH2 0x422 PUSH2 0xD6F JUMP JUMPDEST JUMPDEST MUL OR SWAP1 SSTORE POP CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP3 PUSH32 0x7EB38F83FEC1BDC45E831C15E9E3EB2369028929A0E38E3709B7E710362F823B PUSH1 0x40 MLOAD PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 LOG3 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x2 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH4 0x2DA7E031 DUP4 PUSH1 0x40 MLOAD DUP3 PUSH4 0xFFFFFFFF AND PUSH1 0xE0 SHL DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x4CD SWAP2 SWAP1 PUSH2 0xFD1 JUMP JUMPDEST PUSH1 0x20 PUSH1 0x40 MLOAD DUP1 DUP4 SUB DUP2 DUP7 GAS STATICCALL ISZERO DUP1 ISZERO PUSH2 0x4EA JUMPI RETURNDATASIZE PUSH1 0x0 DUP1 RETURNDATACOPY RETURNDATASIZE PUSH1 0x0 REVERT JUMPDEST POP POP POP POP PUSH1 0x40 MLOAD RETURNDATASIZE PUSH1 0x1F NOT PUSH1 0x1F DUP3 ADD AND DUP3 ADD DUP1 PUSH1 0x40 MSTORE POP DUP2 ADD SWAP1 PUSH2 0x50E SWAP2 SWAP1 PUSH2 0x11A8 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x2 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 JUMP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x0 DUP4 DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SWAP1 POP PUSH1 0x2 PUSH1 0x3 DUP2 GT ISZERO PUSH2 0x565 JUMPI PUSH2 0x564 PUSH2 0xD6F JUMP JUMPDEST JUMPDEST DUP2 PUSH1 0x3 ADD PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND PUSH1 0x3 DUP2 GT ISZERO PUSH2 0x589 JUMPI PUSH2 0x588 PUSH2 0xD6F JUMP JUMPDEST JUMPDEST EQ PUSH2 0x5C9 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x5C0 SWAP1 PUSH2 0x1247 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x1 ISZERO ISZERO DUP2 PUSH1 0x3 ADD PUSH1 0x1 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND ISZERO ISZERO EQ PUSH2 0x621 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x618 SWAP1 PUSH2 0x12B3 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x3 DUP2 PUSH1 0x3 ADD PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH1 0xFF MUL NOT AND SWAP1 DUP4 PUSH1 0x3 DUP2 GT ISZERO PUSH2 0x649 JUMPI PUSH2 0x648 PUSH2 0xD6F JUMP JUMPDEST JUMPDEST MUL OR SWAP1 SSTORE POP CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 PUSH1 0x0 ADD PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP4 PUSH32 0x512B8749848A8DA068EC650563D846EBD78F9EC529354088FCA5319736EFD3ED PUSH1 0x40 MLOAD PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 LOG4 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 MSTORE DUP1 PUSH1 0x0 MSTORE PUSH1 0x40 PUSH1 0x0 KECCAK256 PUSH1 0x0 SWAP2 POP SWAP1 POP DUP1 PUSH1 0x0 ADD PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND SWAP1 DUP1 PUSH1 0x1 ADD DUP1 SLOAD PUSH2 0x71A SWAP1 PUSH2 0x1302 JUMP JUMPDEST DUP1 PUSH1 0x1F ADD PUSH1 0x20 DUP1 SWAP2 DIV MUL PUSH1 0x20 ADD PUSH1 0x40 MLOAD SWAP1 DUP2 ADD PUSH1 0x40 MSTORE DUP1 SWAP3 SWAP2 SWAP1 DUP2 DUP2 MSTORE PUSH1 0x20 ADD DUP3 DUP1 SLOAD PUSH2 0x746 SWAP1 PUSH2 0x1302 JUMP JUMPDEST DUP1 ISZERO PUSH2 0x793 JUMPI DUP1 PUSH1 0x1F LT PUSH2 0x768 JUMPI PUSH2 0x100 DUP1 DUP4 SLOAD DIV MUL DUP4 MSTORE SWAP2 PUSH1 0x20 ADD SWAP2 PUSH2 0x793 JUMP JUMPDEST DUP3 ADD SWAP2 SWAP1 PUSH1 0x0 MSTORE PUSH1 0x20 PUSH1 0x0 KECCAK256 SWAP1 JUMPDEST DUP2 SLOAD DUP2 MSTORE SWAP1 PUSH1 0x1 ADD SWAP1 PUSH1 0x20 ADD DUP1 DUP4 GT PUSH2 0x776 JUMPI DUP3 SWAP1 SUB PUSH1 0x1F AND DUP3 ADD SWAP2 JUMPDEST POP POP POP POP POP SWAP1 DUP1 PUSH1 0x2 ADD SLOAD SWAP1 DUP1 PUSH1 0x3 ADD PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND SWAP1 DUP1 PUSH1 0x3 ADD PUSH1 0x1 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND SWAP1 POP DUP6 JUMP JUMPDEST PUSH1 0x0 DUP1 DUP3 GT PUSH2 0x80D JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x804 SWAP1 PUSH2 0x137F JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x0 PUSH1 0x1 PUSH1 0x0 DUP2 SLOAD DUP1 SWAP3 SWAP2 SWAP1 PUSH2 0x822 SWAP1 PUSH2 0x13CE JUMP JUMPDEST SWAP2 SWAP1 POP SSTORE SWAP1 POP PUSH1 0x40 MLOAD DUP1 PUSH1 0xA0 ADD PUSH1 0x40 MSTORE DUP1 CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD DUP6 DUP2 MSTORE PUSH1 0x20 ADD DUP5 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 PUSH1 0x3 DUP2 GT ISZERO PUSH2 0x86F JUMPI PUSH2 0x86E PUSH2 0xD6F JUMP JUMPDEST JUMPDEST DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 ISZERO ISZERO DUP2 MSTORE POP PUSH1 0x0 DUP1 DUP4 DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 DUP3 ADD MLOAD DUP2 PUSH1 0x0 ADD PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF MUL NOT AND SWAP1 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND MUL OR SWAP1 SSTORE POP PUSH1 0x20 DUP3 ADD MLOAD DUP2 PUSH1 0x1 ADD SWAP1 DUP2 PUSH2 0x8E9 SWAP2 SWAP1 PUSH2 0x15B8 JUMP JUMPDEST POP PUSH1 0x40 DUP3 ADD MLOAD DUP2 PUSH1 0x2 ADD SSTORE PUSH1 0x60 DUP3 ADD MLOAD DUP2 PUSH1 0x3 ADD PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH1 0xFF MUL NOT AND SWAP1 DUP4 PUSH1 0x3 DUP2 GT ISZERO PUSH2 0x91F JUMPI PUSH2 0x91E PUSH2 0xD6F JUMP JUMPDEST JUMPDEST MUL OR SWAP1 SSTORE POP PUSH1 0x80 DUP3 ADD MLOAD DUP2 PUSH1 0x3 ADD PUSH1 0x1 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH1 0xFF MUL NOT AND SWAP1 DUP4 ISZERO ISZERO MUL OR SWAP1 SSTORE POP SWAP1 POP POP CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 PUSH32 0x99E496CEE88189FF08B550BB9F3C61E28506F4623C57A7C3811072CED0C8602D PUSH1 0x40 MLOAD PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 LOG3 DUP1 SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x0 DUP4 DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SWAP1 POP CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 PUSH1 0x0 ADD PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND EQ PUSH2 0xA3D JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0xA34 SWAP1 PUSH2 0x16FC JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x3 DUP1 DUP2 GT ISZERO PUSH2 0xA50 JUMPI PUSH2 0xA4F PUSH2 0xD6F JUMP JUMPDEST JUMPDEST DUP2 PUSH1 0x3 ADD PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND PUSH1 0x3 DUP2 GT ISZERO PUSH2 0xA74 JUMPI PUSH2 0xA73 PUSH2 0xD6F JUMP JUMPDEST JUMPDEST SUB PUSH2 0xAB4 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0xAAB SWAP1 PUSH2 0x1768 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x1 DUP2 PUSH1 0x3 ADD PUSH1 0x1 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH1 0xFF MUL NOT AND SWAP1 DUP4 ISZERO ISZERO MUL OR SWAP1 SSTORE POP PUSH1 0x2 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH4 0xA7706A25 DUP4 PUSH1 0x40 MLOAD DUP3 PUSH4 0xFFFFFFFF AND PUSH1 0xE0 SHL DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0xB2C SWAP2 SWAP1 PUSH2 0xFD1 JUMP JUMPDEST PUSH1 0x0 PUSH1 0x40 MLOAD DUP1 DUP4 SUB DUP2 PUSH1 0x0 DUP8 DUP1 EXTCODESIZE ISZERO DUP1 ISZERO PUSH2 0xB46 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP GAS CALL ISZERO DUP1 ISZERO PUSH2 0xB5A JUMPI RETURNDATASIZE PUSH1 0x0 DUP1 RETURNDATACOPY RETURNDATASIZE PUSH1 0x0 REVERT JUMPDEST POP POP POP POP POP POP JUMP JUMPDEST PUSH1 0x1 SLOAD DUP2 JUMP JUMPDEST PUSH1 0x0 PUSH1 0x40 MLOAD SWAP1 POP SWAP1 JUMP JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0xB8F DUP2 PUSH2 0xB7C JUMP JUMPDEST DUP2 EQ PUSH2 0xB9A JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP JUMPDEST PUSH1 0x0 DUP2 CALLDATALOAD SWAP1 POP PUSH2 0xBAC DUP2 PUSH2 0xB86 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 DUP5 SUB SLT ISZERO PUSH2 0xBC8 JUMPI PUSH2 0xBC7 PUSH2 0xB72 JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0xBD6 DUP5 DUP3 DUP6 ADD PUSH2 0xB9D JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 ISZERO ISZERO SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0xBF4 DUP2 PUSH2 0xBDF JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0xC0F PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0xBEB JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF DUP3 AND SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0xC5A PUSH2 0xC55 PUSH2 0xC50 DUP5 PUSH2 0xC15 JUMP JUMPDEST PUSH2 0xC35 JUMP JUMPDEST PUSH2 0xC15 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0xC6C DUP3 PUSH2 0xC3F JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0xC7E DUP3 PUSH2 0xC61 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0xC8E DUP2 PUSH2 0xC73 JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0xCA9 PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0xC85 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0xCBA DUP3 PUSH2 0xC15 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0xCCA DUP2 PUSH2 0xCAF JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 MLOAD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP3 DUP3 MSTORE PUSH1 0x20 DUP3 ADD SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 JUMPDEST DUP4 DUP2 LT ISZERO PUSH2 0xD0A JUMPI DUP1 DUP3 ADD MLOAD DUP2 DUP5 ADD MSTORE PUSH1 0x20 DUP2 ADD SWAP1 POP PUSH2 0xCEF JUMP JUMPDEST PUSH1 0x0 DUP5 DUP5 ADD MSTORE POP POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x1F NOT PUSH1 0x1F DUP4 ADD AND SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0xD32 DUP3 PUSH2 0xCD0 JUMP JUMPDEST PUSH2 0xD3C DUP2 DUP6 PUSH2 0xCDB JUMP JUMPDEST SWAP4 POP PUSH2 0xD4C DUP2 DUP6 PUSH1 0x20 DUP7 ADD PUSH2 0xCEC JUMP JUMPDEST PUSH2 0xD55 DUP2 PUSH2 0xD16 JUMP JUMPDEST DUP5 ADD SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH2 0xD69 DUP2 PUSH2 0xB7C JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x21 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH1 0x4 DUP2 LT PUSH2 0xDAF JUMPI PUSH2 0xDAE PUSH2 0xD6F JUMP JUMPDEST JUMPDEST POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP PUSH2 0xDC0 DUP3 PUSH2 0xD9E JUMP JUMPDEST SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0xDD0 DUP3 PUSH2 0xDB2 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0xDE0 DUP2 PUSH2 0xDC5 JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0xA0 DUP3 ADD SWAP1 POP PUSH2 0xDFB PUSH1 0x0 DUP4 ADD DUP9 PUSH2 0xCC1 JUMP JUMPDEST DUP2 DUP2 SUB PUSH1 0x20 DUP4 ADD MSTORE PUSH2 0xE0D DUP2 DUP8 PUSH2 0xD27 JUMP JUMPDEST SWAP1 POP PUSH2 0xE1C PUSH1 0x40 DUP4 ADD DUP7 PUSH2 0xD60 JUMP JUMPDEST PUSH2 0xE29 PUSH1 0x60 DUP4 ADD DUP6 PUSH2 0xDD7 JUMP JUMPDEST PUSH2 0xE36 PUSH1 0x80 DUP4 ADD DUP5 PUSH2 0xBEB JUMP JUMPDEST SWAP7 SWAP6 POP POP POP POP POP POP JUMP JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x41 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH2 0xE82 DUP3 PUSH2 0xD16 JUMP JUMPDEST DUP2 ADD DUP2 DUP2 LT PUSH8 0xFFFFFFFFFFFFFFFF DUP3 GT OR ISZERO PUSH2 0xEA1 JUMPI PUSH2 0xEA0 PUSH2 0xE4A JUMP JUMPDEST JUMPDEST DUP1 PUSH1 0x40 MSTORE POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0xEB4 PUSH2 0xB68 JUMP JUMPDEST SWAP1 POP PUSH2 0xEC0 DUP3 DUP3 PUSH2 0xE79 JUMP JUMPDEST SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH8 0xFFFFFFFFFFFFFFFF DUP3 GT ISZERO PUSH2 0xEE0 JUMPI PUSH2 0xEDF PUSH2 0xE4A JUMP JUMPDEST JUMPDEST PUSH2 0xEE9 DUP3 PUSH2 0xD16 JUMP JUMPDEST SWAP1 POP PUSH1 0x20 DUP2 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST DUP3 DUP2 DUP4 CALLDATACOPY PUSH1 0x0 DUP4 DUP4 ADD MSTORE POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0xF18 PUSH2 0xF13 DUP5 PUSH2 0xEC5 JUMP JUMPDEST PUSH2 0xEAA JUMP JUMPDEST SWAP1 POP DUP3 DUP2 MSTORE PUSH1 0x20 DUP2 ADD DUP5 DUP5 DUP5 ADD GT ISZERO PUSH2 0xF34 JUMPI PUSH2 0xF33 PUSH2 0xE45 JUMP JUMPDEST JUMPDEST PUSH2 0xF3F DUP5 DUP3 DUP6 PUSH2 0xEF6 JUMP JUMPDEST POP SWAP4 SWAP3 POP POP POP JUMP JUMPDEST PUSH1 0x0 DUP3 PUSH1 0x1F DUP4 ADD SLT PUSH2 0xF5C JUMPI PUSH2 0xF5B PUSH2 0xE40 JUMP JUMPDEST JUMPDEST DUP2 CALLDATALOAD PUSH2 0xF6C DUP5 DUP3 PUSH1 0x20 DUP7 ADD PUSH2 0xF05 JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x40 DUP4 DUP6 SUB SLT ISZERO PUSH2 0xF8C JUMPI PUSH2 0xF8B PUSH2 0xB72 JUMP JUMPDEST JUMPDEST PUSH1 0x0 DUP4 ADD CALLDATALOAD PUSH8 0xFFFFFFFFFFFFFFFF DUP2 GT ISZERO PUSH2 0xFAA JUMPI PUSH2 0xFA9 PUSH2 0xB77 JUMP JUMPDEST JUMPDEST PUSH2 0xFB6 DUP6 DUP3 DUP7 ADD PUSH2 0xF47 JUMP JUMPDEST SWAP3 POP POP PUSH1 0x20 PUSH2 0xFC7 DUP6 DUP3 DUP7 ADD PUSH2 0xB9D JUMP JUMPDEST SWAP2 POP POP SWAP3 POP SWAP3 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0xFE6 PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0xD60 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH32 0x50726F6475637420686173206E6F74206265656E206D616E7566616374757265 PUSH1 0x0 DUP3 ADD MSTORE PUSH32 0x6420796574000000000000000000000000000000000000000000000000000000 PUSH1 0x20 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1048 PUSH1 0x25 DUP4 PUSH2 0xCDB JUMP JUMPDEST SWAP2 POP PUSH2 0x1053 DUP3 PUSH2 0xFEC JUMP JUMPDEST PUSH1 0x40 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1077 DUP2 PUSH2 0x103B JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH32 0x4F6E6C79206D616E7566616374757265722063616E2073686970207468652070 PUSH1 0x0 DUP3 ADD MSTORE PUSH32 0x726F647563740000000000000000000000000000000000000000000000000000 PUSH1 0x20 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x10DA PUSH1 0x26 DUP4 PUSH2 0xCDB JUMP JUMPDEST SWAP2 POP PUSH2 0x10E5 DUP3 PUSH2 0x107E JUMP JUMPDEST PUSH1 0x40 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1109 DUP2 PUSH2 0x10CD JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH32 0x50726F6475637420686173206E6F74206265656E207368697070656420796574 PUSH1 0x0 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1146 PUSH1 0x20 DUP4 PUSH2 0xCDB JUMP JUMPDEST SWAP2 POP PUSH2 0x1151 DUP3 PUSH2 0x1110 JUMP JUMPDEST PUSH1 0x20 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1175 DUP2 PUSH2 0x1139 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0x1185 DUP2 PUSH2 0xBDF JUMP JUMPDEST DUP2 EQ PUSH2 0x1190 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP JUMPDEST PUSH1 0x0 DUP2 MLOAD SWAP1 POP PUSH2 0x11A2 DUP2 PUSH2 0x117C JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 DUP5 SUB SLT ISZERO PUSH2 0x11BE JUMPI PUSH2 0x11BD PUSH2 0xB72 JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x11CC DUP5 DUP3 DUP6 ADD PUSH2 0x1193 JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH32 0x50726F6475637420686173206E6F74206265656E207265636569766564207965 PUSH1 0x0 DUP3 ADD MSTORE PUSH32 0x7400000000000000000000000000000000000000000000000000000000000000 PUSH1 0x20 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1231 PUSH1 0x21 DUP4 PUSH2 0xCDB JUMP JUMPDEST SWAP2 POP PUSH2 0x123C DUP3 PUSH2 0x11D5 JUMP JUMPDEST PUSH1 0x40 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1260 DUP2 PUSH2 0x1224 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH32 0x50726F64756374206973206E6F742061757468656E7469630000000000000000 PUSH1 0x0 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x129D PUSH1 0x18 DUP4 PUSH2 0xCDB JUMP JUMPDEST SWAP2 POP PUSH2 0x12A8 DUP3 PUSH2 0x1267 JUMP JUMPDEST PUSH1 0x20 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x12CC DUP2 PUSH2 0x1290 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x22 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH1 0x0 PUSH1 0x2 DUP3 DIV SWAP1 POP PUSH1 0x1 DUP3 AND DUP1 PUSH2 0x131A JUMPI PUSH1 0x7F DUP3 AND SWAP2 POP JUMPDEST PUSH1 0x20 DUP3 LT DUP2 SUB PUSH2 0x132D JUMPI PUSH2 0x132C PUSH2 0x12D3 JUMP JUMPDEST JUMPDEST POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH32 0x5072696365206D7573742062652067726561746572207468616E203000000000 PUSH1 0x0 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1369 PUSH1 0x1C DUP4 PUSH2 0xCDB JUMP JUMPDEST SWAP2 POP PUSH2 0x1374 DUP3 PUSH2 0x1333 JUMP JUMPDEST PUSH1 0x20 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1398 DUP2 PUSH2 0x135C JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x11 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH1 0x0 PUSH2 0x13D9 DUP3 PUSH2 0xB7C JUMP JUMPDEST SWAP2 POP PUSH32 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF DUP3 SUB PUSH2 0x140B JUMPI PUSH2 0x140A PUSH2 0x139F JUMP JUMPDEST JUMPDEST PUSH1 0x1 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP DUP2 PUSH1 0x0 MSTORE PUSH1 0x20 PUSH1 0x0 KECCAK256 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 PUSH1 0x1F DUP4 ADD DIV SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP3 DUP3 SHL SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x8 DUP4 MUL PUSH2 0x1478 PUSH32 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF DUP3 PUSH2 0x143B JUMP JUMPDEST PUSH2 0x1482 DUP7 DUP4 PUSH2 0x143B JUMP JUMPDEST SWAP6 POP DUP1 NOT DUP5 AND SWAP4 POP DUP1 DUP7 AND DUP5 OR SWAP3 POP POP POP SWAP4 SWAP3 POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x14B5 PUSH2 0x14B0 PUSH2 0x14AB DUP5 PUSH2 0xB7C JUMP JUMPDEST PUSH2 0xC35 JUMP JUMPDEST PUSH2 0xB7C JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0x14CF DUP4 PUSH2 0x149A JUMP JUMPDEST PUSH2 0x14E3 PUSH2 0x14DB DUP3 PUSH2 0x14BC JUMP JUMPDEST DUP5 DUP5 SLOAD PUSH2 0x1448 JUMP JUMPDEST DUP3 SSTORE POP POP POP POP JUMP JUMPDEST PUSH1 0x0 SWAP1 JUMP JUMPDEST PUSH2 0x14F8 PUSH2 0x14EB JUMP JUMPDEST PUSH2 0x1503 DUP2 DUP5 DUP5 PUSH2 0x14C6 JUMP JUMPDEST POP POP POP JUMP JUMPDEST JUMPDEST DUP2 DUP2 LT ISZERO PUSH2 0x1527 JUMPI PUSH2 0x151C PUSH1 0x0 DUP3 PUSH2 0x14F0 JUMP JUMPDEST PUSH1 0x1 DUP2 ADD SWAP1 POP PUSH2 0x1509 JUMP JUMPDEST POP POP JUMP JUMPDEST PUSH1 0x1F DUP3 GT ISZERO PUSH2 0x156C JUMPI PUSH2 0x153D DUP2 PUSH2 0x1416 JUMP JUMPDEST PUSH2 0x1546 DUP5 PUSH2 0x142B JUMP JUMPDEST DUP2 ADD PUSH1 0x20 DUP6 LT ISZERO PUSH2 0x1555 JUMPI DUP2 SWAP1 POP JUMPDEST PUSH2 0x1569 PUSH2 0x1561 DUP6 PUSH2 0x142B JUMP JUMPDEST DUP4 ADD DUP3 PUSH2 0x1508 JUMP JUMPDEST POP POP JUMPDEST POP POP POP JUMP JUMPDEST PUSH1 0x0 DUP3 DUP3 SHR SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x158F PUSH1 0x0 NOT DUP5 PUSH1 0x8 MUL PUSH2 0x1571 JUMP JUMPDEST NOT DUP1 DUP4 AND SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x15A8 DUP4 DUP4 PUSH2 0x157E JUMP JUMPDEST SWAP2 POP DUP3 PUSH1 0x2 MUL DUP3 OR SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH2 0x15C1 DUP3 PUSH2 0xCD0 JUMP JUMPDEST PUSH8 0xFFFFFFFFFFFFFFFF DUP2 GT ISZERO PUSH2 0x15DA JUMPI PUSH2 0x15D9 PUSH2 0xE4A JUMP JUMPDEST JUMPDEST PUSH2 0x15E4 DUP3 SLOAD PUSH2 0x1302 JUMP JUMPDEST PUSH2 0x15EF DUP3 DUP3 DUP6 PUSH2 0x152B JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 SWAP1 POP PUSH1 0x1F DUP4 GT PUSH1 0x1 DUP2 EQ PUSH2 0x1622 JUMPI PUSH1 0x0 DUP5 ISZERO PUSH2 0x1610 JUMPI DUP3 DUP8 ADD MLOAD SWAP1 POP JUMPDEST PUSH2 0x161A DUP6 DUP3 PUSH2 0x159C JUMP JUMPDEST DUP7 SSTORE POP PUSH2 0x1682 JUMP JUMPDEST PUSH1 0x1F NOT DUP5 AND PUSH2 0x1630 DUP7 PUSH2 0x1416 JUMP JUMPDEST PUSH1 0x0 JUMPDEST DUP3 DUP2 LT ISZERO PUSH2 0x1658 JUMPI DUP5 DUP10 ADD MLOAD DUP3 SSTORE PUSH1 0x1 DUP3 ADD SWAP2 POP PUSH1 0x20 DUP6 ADD SWAP5 POP PUSH1 0x20 DUP2 ADD SWAP1 POP PUSH2 0x1633 JUMP JUMPDEST DUP7 DUP4 LT ISZERO PUSH2 0x1675 JUMPI DUP5 DUP10 ADD MLOAD PUSH2 0x1671 PUSH1 0x1F DUP10 AND DUP3 PUSH2 0x157E JUMP JUMPDEST DUP4 SSTORE POP JUMPDEST PUSH1 0x1 PUSH1 0x2 DUP9 MUL ADD DUP9 SSTORE POP POP POP JUMPDEST POP POP POP POP POP POP JUMP JUMPDEST PUSH32 0x4F6E6C79206D616E7566616374757265722063616E206D61726B207468652070 PUSH1 0x0 DUP3 ADD MSTORE PUSH32 0x726F647563742061732061757468656E74696300000000000000000000000000 PUSH1 0x20 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x16E6 PUSH1 0x33 DUP4 PUSH2 0xCDB JUMP JUMPDEST SWAP2 POP PUSH2 0x16F1 DUP3 PUSH2 0x168A JUMP JUMPDEST PUSH1 0x40 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1715 DUP2 PUSH2 0x16D9 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH32 0x50726F647563742068617320616C7265616479206265656E20736F6C64000000 PUSH1 0x0 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1752 PUSH1 0x1D DUP4 PUSH2 0xCDB JUMP JUMPDEST SWAP2 POP PUSH2 0x175D DUP3 PUSH2 0x171C JUMP JUMPDEST PUSH1 0x20 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1781 DUP2 PUSH2 0x1745 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP INVALID LOG2 PUSH5 0x6970667358 0x22 SLT KECCAK256 CALL BYTE JUMPI ORIGIN 0xC0 0xD1 CHAINID 0xCF CREATE 0xE1 0x23 0xB7 0xC8 0x4E PUSH26 0x81BBE37FF351DF96FE0BB437384783D57964736F6C6343000812 STOP CALLER \",\n"
            + "\t\"sourceMap\": \"94:3045:1:-:0;;;527:136;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;:::i;:::-;628:27;586:19;;:70;;;;;;;;;;;;;;;;;;527:136;94:3045;;88:117:2;197:1;194;187:12;334:126;371:7;411:42;404:5;400:54;389:65;;334:126;;;:::o;466:96::-;503:7;532:24;550:5;532:24;:::i;:::-;521:35;;466:96;;;:::o;568:122::-;641:24;659:5;641:24;:::i;:::-;634:5;631:35;621:63;;680:1;677;670:12;621:63;568:122;:::o;696:143::-;753:5;784:6;778:13;769:22;;800:33;827:5;800:33;:::i;:::-;696:143;;;;:::o;845:351::-;915:6;964:2;952:9;943:7;939:23;935:32;932:119;;;970:79;;:::i;:::-;932:119;1090:1;1115:64;1171:7;1162:6;1151:9;1147:22;1115:64;:::i;:::-;1105:74;;1061:128;845:351;;;;:::o;94:3045:1:-;;;;;;;\"\n"
            + "}";

    public static final String FUNC_ISPRODUCTMARKEDASAUTHENTIC = "isProductMarkedAsAuthentic";

    public static final String FUNC_MANUFACTUREPRODUCT = "manufactureProduct";

    public static final String FUNC_MARKPRODUCTASAUTHENTIC = "markProductAsAuthentic";

    public static final String FUNC_PRODUCTAUTHENTICITY = "productAuthenticity";

    public static final String FUNC_PRODUCTINDEX = "productIndex";

    public static final String FUNC_PRODUCTS = "products";

    public static final String FUNC_RECEIVEPRODUCT = "receiveProduct";

    public static final String FUNC_SELLPRODUCT = "sellProduct";

    public static final String FUNC_SHIPPRODUCT = "shipProduct";

    public static final Event PRODUCTMANUFACTURED_EVENT = new Event("ProductManufactured", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event PRODUCTRECEIVED_EVENT = new Event("ProductReceived", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event PRODUCTSHIPPED_EVENT = new Event("ProductShipped", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event PRODUCTSOLD_EVENT = new Event("ProductSold", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected SupplyChainManagement(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SupplyChainManagement(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SupplyChainManagement(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SupplyChainManagement(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }


    public Flowable<ProductManufacturedEventResponse> productManufacturedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ProductManufacturedEventResponse>() {
            @Override
            public ProductManufacturedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PRODUCTMANUFACTURED_EVENT, log);
                ProductManufacturedEventResponse typedResponse = new ProductManufacturedEventResponse();
                typedResponse.log = log;
                typedResponse.productId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.manufacturer = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ProductManufacturedEventResponse> productManufacturedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PRODUCTMANUFACTURED_EVENT));
        return productManufacturedEventFlowable(filter);
    }

    public Flowable<ProductReceivedEventResponse> productReceivedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ProductReceivedEventResponse>() {
            @Override
            public ProductReceivedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PRODUCTRECEIVED_EVENT, log);
                ProductReceivedEventResponse typedResponse = new ProductReceivedEventResponse();
                typedResponse.log = log;
                typedResponse.productId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.receiver = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ProductReceivedEventResponse> productReceivedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PRODUCTRECEIVED_EVENT));
        return productReceivedEventFlowable(filter);
    }


    public Flowable<ProductShippedEventResponse> productShippedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ProductShippedEventResponse>() {
            @Override
            public ProductShippedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PRODUCTSHIPPED_EVENT, log);
                ProductShippedEventResponse typedResponse = new ProductShippedEventResponse();
                typedResponse.log = log;
                typedResponse.productId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.manufacturer = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ProductShippedEventResponse> productShippedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PRODUCTSHIPPED_EVENT));
        return productShippedEventFlowable(filter);
    }



    public Flowable<ProductSoldEventResponse> productSoldEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ProductSoldEventResponse>() {
            @Override
            public ProductSoldEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PRODUCTSOLD_EVENT, log);
                ProductSoldEventResponse typedResponse = new ProductSoldEventResponse();
                typedResponse.log = log;
                typedResponse.productId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.seller = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.buyer = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ProductSoldEventResponse> productSoldEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PRODUCTSOLD_EVENT));
        return productSoldEventFlowable(filter);
    }

    public RemoteFunctionCall<Boolean> isProductMarkedAsAuthentic(BigInteger _productId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISPRODUCTMARKEDASAUTHENTIC, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_productId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> manufactureProduct(String _name, BigInteger _price) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MANUFACTUREPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.generated.Uint256(_price)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> markProductAsAuthentic(BigInteger _productId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MARKPRODUCTASAUTHENTIC, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_productId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> productAuthenticity() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PRODUCTAUTHENTICITY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> productIndex() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PRODUCTINDEX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple5<String, String, BigInteger, BigInteger, Boolean>> products(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PRODUCTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bool>() {}));
        return new RemoteFunctionCall<Tuple5<String, String, BigInteger, BigInteger, Boolean>>(function,
                new Callable<Tuple5<String, String, BigInteger, BigInteger, Boolean>>() {
                    @Override
                    public Tuple5<String, String, BigInteger, BigInteger, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, String, BigInteger, BigInteger, Boolean>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (Boolean) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> receiveProduct(BigInteger _productId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RECEIVEPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_productId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> sellProduct(BigInteger _productId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SELLPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_productId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> shipProduct(BigInteger _productId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SHIPPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_productId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static SupplyChainManagement load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SupplyChainManagement(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SupplyChainManagement load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SupplyChainManagement(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SupplyChainManagement load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SupplyChainManagement(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SupplyChainManagement load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SupplyChainManagement(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SupplyChainManagement> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _productAuthenticityAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _productAuthenticityAddress)));
        return deployRemoteCall(SupplyChainManagement.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<SupplyChainManagement> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _productAuthenticityAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _productAuthenticityAddress)));
        return deployRemoteCall(SupplyChainManagement.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<SupplyChainManagement> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _productAuthenticityAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _productAuthenticityAddress)));
        return deployRemoteCall(SupplyChainManagement.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<SupplyChainManagement> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _productAuthenticityAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _productAuthenticityAddress)));
        return deployRemoteCall(SupplyChainManagement.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ProductManufacturedEventResponse extends BaseEventResponse {
        public BigInteger productId;

        public String manufacturer;
    }

    public static class ProductReceivedEventResponse extends BaseEventResponse {
        public BigInteger productId;

        public String receiver;
    }

    public static class ProductShippedEventResponse extends BaseEventResponse {
        public BigInteger productId;

        public String manufacturer;
    }

    public static class ProductSoldEventResponse extends BaseEventResponse {
        public BigInteger productId;

        public String seller;

        public String buyer;
    }
}
