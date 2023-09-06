package jdk.internal.access;

import jdk.internal.security.CodeSigner;
import jdk.internal.security.ProtectionParameter;
import jdk.internal.security.Service;
import jdk.internal.security.keystore.Builder;
import jdk.internal.security.Entry;
import sun.misc.JavaSecurityProtectionDomainAccess;

import java.net.URL;
import java.nio.ByteBuffer;
import java.security.*;
import java.util.Set;

public interface JavaSecurityAccess {
    Builder newKeyStoreBuilder(KeyStore a, ProtectionParameter b);
    void update(MessageDigest a, ByteBuffer b);
    CodeSource newCodeSource(URL a, CodeSigner[] b);
    String getEngineName(Object a);
    boolean checkEngine(String a);
    Object newInstance(Class a, String b, Object c) throws Exception;
    Set getServices(Provider a);
    void putService(Provider a, Service b);
    Service getService(Provider a, String b, String c);
    Provider configure(Provider a, String b);
    Entry getEntry(KeyStore a, String b, ProtectionParameter c) throws NoSuchAlgorithmException, GeneralSecurityException;
    Object doPrivileged(PrivilegedAction a, AccessControlContext b, Permission[] c);
    Object doPrivilegedWithCombiner(PrivilegedExceptionAction a, AccessControlContext b, Permission[] c) throws PrivilegedActionException;
    Object doIntersectionPrivilege(PrivilegedAction a, AccessControlContext b);
    Object doIntersectionPrivilege(PrivilegedAction a, AccessControlContext b, AccessControlContext c);
    JavaSecurityProtectionDomainAccess.ProtectionDomainCache getProtectionDomainCache();
}
