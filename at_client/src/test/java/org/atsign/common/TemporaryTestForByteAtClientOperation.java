package org.atsign.common;

import org.atsign.client.api.AtClient;
import org.atsign.common.Keys.PublicKey;
import org.atsign.common.Keys.SelfKey;
import org.atsign.common.Keys.SharedKey;

public class TemporaryTestForByteAtClientOperation{
    public static void main(String[] args) throws Exception {
        // Add your atSign Here
        AtSign atSign = new AtSign("@16ourfeminist");
        AtClient atClient = AtClient.withRemoteSecondary("root.atsign.org:64", atSign, true);

        PublicKey pk = new KeyBuilders.PublicKeyBuilder(atSign).key("testPublicKey").build();
        byte[] value = "testToken".getBytes();
        String responsePK = atClient.put(pk, value).get();
        System.out.println("response of public key here -- " + responsePK);
        byte[] getPublicValue = atClient.getBinary(pk).get();
        String str = new String(getPublicValue);
        System.out.println("get public key -- " + str + " get public value -- " + getPublicValue);
        
        System.out.println();
        System.out.println();
        
        SelfKey sk = new KeyBuilders.SelfKeyBuilder(atSign).key("testSelfKey").build();
        String responseSK = atClient.put(sk, value).get();
        System.out.println("response of Self here -- " + responseSK);
        byte[] getSelfValue = atClient.getBinary(sk).get();
        String strSelf = new String(getSelfValue);
        System.out.println("get Self key -- " + strSelf + " get Self value -- " + getSelfValue);
        
        System.out.println();
        System.out.println();
        
        SharedKey shKey = new KeyBuilders.SharedKeyBuilder(atSign, atSign).key("testSharedKey").build();
        String responseShareKey = atClient.put(shKey,value).get();
        System.out.println("response of SharedKey here -- " + responseShareKey);
        byte[] getSharedValue = atClient.getBinary(shKey).get();
        String strShared = new String(getSharedValue);
        System.out.println("get SharedKey  -- " + strShared + " get SharedKey value -- " + getSharedValue);
    }

}
