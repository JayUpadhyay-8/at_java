package org.atsign.common;

import org.atsign.client.api.AtClient;
import org.atsign.common.Keys.PublicKey;
import org.atsign.common.Keys.SelfKey;
import org.atsign.common.Keys.SharedKey;

public class TemporaryTestForByteAtClientOperation{
    public static void main(String[] args) throws Exception {
        AtSign atSign = new AtSign("@16ourfeminist");
        AtClient atClient = AtClient.withRemoteSecondary("root.atsign.org:64", atSign, true);

        PublicKey pk = new KeyBuilders.PublicKeyBuilder(atSign).key("testPublicKey").build();
        byte[] value = "testToken".getBytes();
        String responsePK = atClient.put(pk, value).get();
        System.out.println("response of public key here -- " + responsePK);
        byte[] getPublicValue = atClient.getBinary(pk).get();
        String str = new String(getPublicValue);
        System.out.println("get public key -- " + str + " get public value -- " + getPublicValue);

        SelfKey sk = new KeyBuilders.SelfKeyBuilder(atSign).key("testSelfKey").build();
        String responseSK = atClient.put(sk, value).get();
        System.out.println("response of Self here -- " + responseSK);
        

    }

}
