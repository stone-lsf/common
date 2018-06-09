package com.stone.tc.common.utils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.stone.tc.common.net.Address;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @author shifeng.luo
 * @version created on 2018/6/9 下午7:50
 */
@Slf4j
public class AddressUtil {
    public static final String COMMA = ",";

    /**
     * 解析地址列表
     *
     * @param addressStr 地址列表字符串
     * @return Address列表
     */
    public static List<Address> parseList(String addressStr) {
        Preconditions.checkState(StringUtils.isNotBlank(addressStr), "地址不能为空");

        String[] addressList = addressStr.split(COMMA);

        List<Address> addresses = Lists.newArrayListWithCapacity(addressList.length);
        for (String address : addressList) {
            addresses.add(parse(address.trim()));
        }
        return addresses;
    }

    /**
     * 解析地址
     *
     * @param addressStr 地址字符串
     * @return {@link Address}
     */
    public static Address parse(String addressStr) {
        String[] hostPort = addressStr.split(":");
        Preconditions.checkState(hostPort.length == 2, "服务器地址错误:" + addressStr);

        String hostname = hostPort[0];
        try {
            InetAddress address = InetAddress.getByName(hostname);
            int port = Integer.parseInt(hostPort[1]);
            return new Address(new InetSocketAddress(address, port));
        } catch (UnknownHostException e) {
            log.error("illegal address:{}", addressStr);
            throw new IllegalArgumentException("illegal address:" + addressStr);
        }
    }

    /**
     * 获取本地ip
     *
     * @return ip地址
     */
    public static String getLocalIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error("get local ip fail!", e);
            throw new IllegalStateException(e);
        }
    }

    public static InetAddress getInetAddress() {
        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            log.error("get local ip fail!", e);
            throw new IllegalStateException(e);
        }
    }

    public static Address getLocalAddress(int port) {
        return new Address(new InetSocketAddress(getInetAddress(), port));
    }
}
